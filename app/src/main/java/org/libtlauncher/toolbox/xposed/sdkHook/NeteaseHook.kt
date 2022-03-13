package org.libtlauncher.toolbox.xposed.sdkHook

import android.content.Context
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam
import org.json.JSONObject
import org.libtlauncher.toolbox.xposed.info.NeteaseClassInfo
import org.libtlauncher.toolbox.debug.LOG

class NeteaseHook(loadPackageParam: LoadPackageParam?, classLoader: ClassLoader?) {
    companion object {
        var SdkNetease: Any? = null
        var RNBridge: Any? = null

        //调用网易SDK接口
        @JvmStatic
        fun callNeteaseSDK(name: String) {
            if (SdkNetease != null) {
                try {
                    val json = JSONObject("{\"methodId\":\"$name\"}")
                    LOG.LOGD(LOG.LOG_Func, "call sdk: " + json.optString("methodId"))
                    val me = NeteaseClass.SdkNetease!!.getDeclaredMethod("extendFunc", String::class.java)
                    me.isAccessible = true
                    me.invoke(SdkNetease, json.toString())
                } catch (e: Exception) {
                    LOG.LOGD(LOG.LOG_THROW, e.toString())
                }
            } else {
                LOG.LOGD(LOG.LOG_THROW, "Error")
            }
        }

        //调用网易Cpp接口
        fun callNeteaseCpp(name: String) {
            if (RNBridge != null) {
                try {
                    LOG.LOGD(LOG.LOG_Func, "BlockLauncher调用RNBridge: $name")
                    val callcpp = NeteaseClass.RNBridge!!.getDeclaredMethod("callCpp", String::class.java)
                    callcpp.isAccessible = true
                    callcpp.invoke(RNBridge, name)
                } catch (e: Exception) {
                    LOG.LOGD(LOG.LOG_THROW, e.toString())
                }
            } else {
                LOG.LOGD(LOG.LOG_THROW, "错误! 缺少 RNBridge对象")
            }
        }

        //调用网易Python接口
        fun callNeteasePython(name: String) {
            if (RNBridge != null) {
                try {
                    LOG.LOGD(LOG.LOG_Func, "BlockLauncher调用RNBridge: $name")
                    val callcpp = NeteaseClass.RNBridge!!.getDeclaredMethod("callPython", String::class.java)
                    callcpp.isAccessible = true
                    callcpp.invoke(RNBridge, name)
                } catch (e: Exception) {
                    LOG.LOGD(LOG.LOG_THROW, e.toString())
                }
            } else {
                LOG.LOGD(LOG.LOG_THROW, "错误! 缺少 RNBridge对象")
            }
        }
    }

    init {
        //获取网易sdk对象  调用网易SDK
        XposedHelpers.findAndHookConstructor(XposedHelpers.findClass(NeteaseClassInfo.SdkNetease, classLoader), Context::class.java, object : XC_MethodHook() {
            @Throws(Throwable::class)
            override fun beforeHookedMethod(param: MethodHookParam) {
                super.beforeHookedMethod(param)
                SdkNetease = param.thisObject
                LOG.LOGD(LOG.LOG_Java, "网易SDK对象获取成功!")
            }
        })
    }
}