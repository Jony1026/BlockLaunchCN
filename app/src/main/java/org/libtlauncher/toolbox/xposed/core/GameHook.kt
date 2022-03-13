package org.libtlauncher.toolbox.xposed.core

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import org.json.JSONObject
import org.libtlauncher.toolbox.control.FMP_Toast
import org.libtlauncher.toolbox.control.HtmlText
import org.libtlauncher.toolbox.debug.LOG
import org.libtlauncher.toolbox.xposed.floatWin.WindowLib
import org.libtlauncher.toolbox.xposed.getMCContext
import org.libtlauncher.toolbox.xposed.info.NeteaseClassInfo
import org.libtlauncher.toolbox.xposed.info.NeteaseInfo
import org.libtlauncher.toolbox.xposed.sdkHook.NeteaseClass
import org.libtlauncher.toolbox.xposed.sdkHook.NeteaseHook
import java.io.File
import java.security.SecureRandom

object GameHook {
   var loadPackageParam: XC_LoadPackage.LoadPackageParam? = null

    fun NoRootHook(){
        if(!NeteaseInfo.isXposed) {
            FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "免Root模式仅可使用悬浮窗", false)
            if (NeteaseInfo.LoaderMode != 0) {
                Handler().postDelayed({
                    try {
                        GameManager.LoaderJsByJava(NeteaseInfo.MCActivity, null, 2, NeteaseInfo.JsPath)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }, 1000)
            }
        }
    }

    fun InitHook() {
        LOG.LOGD(LOG.LOG_Debug, "activity&context get success")

        var type = ""
        if(NeteaseInfo.LoaderMode == 1){
            type = "进入软件就加载"
        }else if(NeteaseInfo.LoaderMode == 2){
            type = "进入世界就加载"
        }else{
            type = "进入RN就加载"
        }
        FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "start type:${type}", true)

        NeteaseClass.GetClass(loadPackageParam, NeteaseInfo.MCActivity.classLoader)
        LOG.LOGD(LOG.LOG_Debug, "getClass success")
        NeteaseHook(loadPackageParam, NeteaseInfo.MCActivity.classLoader)
        LOG.LOGD(LOG.LOG_Debug, "gameHook success")
        ReactNativeHook(loadPackageParam, NeteaseInfo.MCActivity.classLoader)
        LOG.LOGD(LOG.LOG_Debug, "rnHook success")
        NoShield(loadPackageParam, NeteaseInfo.MCActivity.classLoader)
        LOG.LOGD(LOG.LOG_Debug, "noShield success")

        if (NeteaseInfo.LoaderMode == 1) {
            Handler().postDelayed({
                try {
                    InjectManager.inject(NeteaseInfo.MCActivity, null, 1, NeteaseInfo.JsPath)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }, 1)
        }
    }

    fun hookRN(){
        try {
            loadPackageParam?.classLoader?.loadClass("com.facebook.react.ReactInstanceManagerBuilder")
            XposedHelpers.findAndHookMethod("com.facebook.react.ReactInstanceManagerBuilder", NeteaseInfo.ClassLoader, "build", object : XC_MethodHook() {
                @Throws(Throwable::class)
                override fun beforeHookedMethod(param: MethodHookParam) {
                    val checkRN = File("/sdcard/.NeteaseRN")
                    if (checkRN.exists()) {
                        XposedHelpers.callMethod(param.thisObject, "setJSBundleFile", arrayOf<Class<*>>(String::class.java), "/sdcard/.NeteaseRN/index.bundle")
                    }
                }
            })
        }catch (err: ClassNotFoundException){
            LOG.LOGD(LOG.LOG_Debug, "no rib err:$err")
        }
    }


        fun getGameActivity(classLoader: ClassLoader, loadPM: XC_LoadPackage.LoadPackageParam) {
            XposedHelpers.findAndHookMethod(NeteaseClassInfo.MainActivity, classLoader, "onCreate", Bundle::class.java, object : XC_MethodHook() {
                @Throws(Throwable::class)
                override fun afterHookedMethod(param: MethodHookParam) {
                    super.afterHookedMethod(param)
                    NeteaseInfo.MCContext = param.thisObject as Context //获取Context
                    NeteaseInfo.MCActivity = param.thisObject as Activity //获取Activity
                    val it = NeteaseInfo.MCActivity.intent
                    NeteaseInfo.it = it
                    if (it.getStringExtra("0x0") != null) {
                        val a = it.getStringExtra("loadInfo")
                        val jsonObject = JSONObject(a)
                        val JSPath = jsonObject.optString("JsPath")
                        val LoaderMode = jsonObject.optInt("LoaderMode")
                        val isDebug = jsonObject.optBoolean("isDebug")
                        NeteaseInfo.JsPath = JSPath
                        NeteaseInfo.LoaderMode = LoaderMode
                        NeteaseInfo.isLoaderDebug = isDebug

                        val b = it.getStringExtra("user")
                        val jsonObject2 = JSONObject(b)
                        NeteaseInfo.UserID = jsonObject2.optString("id")
                        NeteaseInfo.UserPass = jsonObject2.optString("pass")

                        loadPackageParam = loadPM
                        InitHook()
                    } else {
                        val id = java.lang.Long.toHexString(SecureRandom().nextLong())
                        val bt1 = TextView(getMCContext.application)
                        bt1.text = HtmlText.parse("§l§dOriginTips§!§e此OriginBox未正确启动§!§a如要正确启动 请打开APP启动§!§l§rPackage - ${loadPM.packageName}")
                        bt1.setTextColor(Color.parseColor("#E8B7D4"))
                        bt1.textSize = 12f
                        bt1.gravity = Gravity.RIGHT
                        Gravity.BOTTOM
                        val obj = WindowLib.addWindowView(NeteaseInfo.MCContext, bt1, 0, 0, Gravity.BOTTOM)
                        val windowManager: WindowManager = obj[0] as WindowManager
                        val params: WindowManager.LayoutParams = obj[1] as WindowManager.LayoutParams

                        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        bt1.setOnClickListener(View.OnClickListener {
                            FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "check permission ing...", true);
                            FMP_Toast.BM_Toast(NeteaseInfo.MCContext, "no permission !", true);
                            windowManager.removeView(bt1)
                        })

                    }
                }


            })
        }
    }