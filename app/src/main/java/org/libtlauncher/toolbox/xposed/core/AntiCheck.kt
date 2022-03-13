package org.libtlauncher.toolbox.xposed.core

import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import org.libtlauncher.toolbox.debug.LOG
import java.lang.Exception
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.util.*

class AntiCheck(loadPackageParam: XC_LoadPackage.LoadPackageParam) {

    init {
        XposedHelpers.findAndHookMethod("android.telephony.TelephonyManager", loadPackageParam.classLoader,
                "getDeviceId", object : XC_MethodHook() {
            @Throws(Throwable::class)
            override fun afterHookedMethod(param: MethodHookParam?) {
                super.afterHookedMethod(param)
                if (param != null) {
                    param.result = System.currentTimeMillis()

                }
            }
        })

        XposedHelpers.findAndHookMethod(ClassLoader::class.java, "loadClass", String::class.java, object : XC_MethodHook() {
            override fun beforeHookedMethod(param: MethodHookParam) {
                try {
                    super.beforeHookedMethod(param)
                    if (param.args != null && param.args[0] != null && param.args[0].toString().startsWith("de.robv.android.xposed.")) {
                        LOG.LOGD(LOG.LOG_Java, "mc check xp class:" + param.args[0])
                       // param.args[0] = ""
                    }
                }catch (e : Exception){
                    LOG.LOGD(LOG.LOG_Debug,"err $e")
                }
            }
        })

        XposedHelpers.findAndHookMethod(StackTraceElement::class.java, "getClassName", object : XC_MethodHook() {
            @Throws(Throwable::class)
            override fun afterHookedMethod(param: MethodHookParam) {
                super.afterHookedMethod(param)
                val result = param.result as String
                LOG.LOGD(LOG.LOG_Java, "mc check xp class 2:$result")
                if (result.contains("de.robv.android.xposed.")) {
                    param.result = ""
                    LOG.LOGD(LOG.LOG_Java, "setResult:$result")
                } else if (result.contains("com.android.internal.os.ZygoteInit")) {
                    param.result = ""
                }
            }
        })
    }
}