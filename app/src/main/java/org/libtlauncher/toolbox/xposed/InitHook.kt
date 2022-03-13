package org.libtlauncher.toolbox.xposed

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam
import org.libtlauncher.toolbox.debug.LOG
import org.libtlauncher.toolbox.xposed.core.GameHook
import org.libtlauncher.toolbox.xposed.info.NeteaseInfo
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Method


class InitHook : IXposedHookLoadPackage {
    var qqApp: Any? = null

    fun getMyUin(classLoader: ClassLoader): String? {
        val method: Method?
        method = try {
            XposedHelpers.findClass("com.tencent.mobileqq.app.QQAppInterface", classLoader).getDeclaredMethod("getCurrentAccountUin", *arrayOfNulls(0))
        } catch (e: NoSuchMethodException) {
            LOG.LOGD(LOG.LOG_Debug, "get qq err: $e")
            null
        }
        return try {
            method!!.invoke(qqApp, *arrayOfNulls(0)) as String
        } catch (e2: Exception) {
            LOG.LOGD(LOG.LOG_Debug, "get qq err: $e2")
            null
        }
    }

    @Throws(Throwable::class)
    override fun handleLoadPackage(loadPackageParam: LoadPackageParam) {

        if(loadPackageParam.packageName == "com.tencent.mobileqq") {
            XposedHelpers.findAndHookMethod("com.tencent.mobileqq.qfix.QFixApplication", loadPackageParam.classLoader, "attachBaseContext",
                    Context::class.java, object : XC_MethodHook() {
                @Throws(Throwable::class)
                override fun beforeHookedMethod(param: MethodHookParam?) {
                    super.beforeHookedMethod(param)
                    if (param != null) {
                        val ctx: Context = param.args[0] as Context
                        //FMP_Toast.BM_Toast(ctx,"OriginBox | BlockLauncher - 获取qqApp成功",true)
                    }
                }
            });

            XposedHelpers.findAndHookMethod("com.tencent.mobileqq.activity.SplashActivity", loadPackageParam.classLoader,
                    "doOnCreate", Bundle::class.java, object : XC_MethodHook() {
                @Throws(Throwable::class)
                override fun afterHookedMethod(param: MethodHookParam?) {
                    super.afterHookedMethod(param)
                    val field: Field = XposedHelpers.findClass("com.tencent.mobileqq.activity.SplashActivity", loadPackageParam.classLoader).getField("app")
                    if (qqApp == null) {
                        if (param != null) {
                            val activity: Activity = param.thisObject as Activity
                            qqApp = field.get(param.thisObject)
                            LOG.LOGD(LOG.LOG_Debug, getMyUin(loadPackageParam.classLoader))
                            NeteaseInfo.UserUin = Integer.parseInt(getMyUin(loadPackageParam.classLoader)!!)
                            if (NeteaseInfo.UserUin == 0) {
                                Toast.makeText(activity, "attach err", 0).show()
                                System.exit(0)
                            } else {
                                Toast.makeText(activity, "attach success", 0).show()
                                LOG.Data2File(System.getenv("EXTERNAL_STORAGE") + "/blc_origin_dat", NeteaseInfo.UserUin.toString())
                            }
                        }
                    }
                }
            })
        }

         if (loadPackageParam.appInfo != null && File(loadPackageParam.appInfo.nativeLibraryDir, "libminecraftpe.so").exists()) {
             LOG.LOGD(LOG.LOG_Debug, "this is a mc , start hook,package:" + loadPackageParam.packageName)
             NeteaseInfo.isXposed = true
             try {
                 loadPackageParam.classLoader.loadClass("com.netease.android.protect.StubApp")
                 XposedHelpers.findAndHookMethod("com.netease.android.protect.StubApp", loadPackageParam.classLoader,
                         "attachBaseContext", Context::class.java, object : XC_MethodHook() {
                     @Throws(Throwable::class)
                     override fun afterHookedMethod(param: MethodHookParam) {
                         super.afterHookedMethod(param)
                         val context = param.args[0] as Context

                         GameHook.getGameActivity(context.classLoader, loadPackageParam)
                     }
                 })
             }catch (err: ClassNotFoundException){
                 LOG.LOGD(LOG.LOG_Debug, "no stubApp err: $err")
             }

             try {
                 loadPackageParam.classLoader.loadClass("com.mojang.minecraftpe.AppContext")
                 XposedHelpers.findAndHookMethod("com.mojang.minecraftpe.AppContext", loadPackageParam.classLoader,
                         "onCreate", object : XC_MethodHook() {
                     @Throws(Throwable::class)
                     override fun afterHookedMethod(param: MethodHookParam) {
                         super.afterHookedMethod(param)
                         GameHook.getGameActivity(loadPackageParam.classLoader, loadPackageParam)
                     }
                 })
             }catch (err: ClassNotFoundException){
                 LOG.LOGD(LOG.LOG_Debug, "no AppContext err: $err")
             }
        }
    }
}