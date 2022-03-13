package org.libtlauncher.toolbox.xposed.sdkHook

import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam
import org.libtlauncher.toolbox.xposed.info.NeteaseClassInfo
import org.libtlauncher.toolbox.debug.LOG
import java.lang.reflect.Field

object NeteaseClass {
    /*
     * 注意!!!
     * 必须保证 下面的Class静态变量的名字和NeteaseClassInfo.java中类名的静态变量名一致
     * 如果名称不一致将无法获取Class对象
     */
    var NeteaseAppliction: Class<*>? = null
    var MainActivity: Class<*>? = null
    @JvmField
    var SdkNetease: Class<*>? = null
    @JvmField
    var RNBridge: Class<*>? = null
    var ReactApplicationContext: Class<*>? = null
    @JvmField
    var Promise: Class<*>? = null
    var DefaulRegex: Class<*>? = null
    var FileUtils: Class<*>? = null

    @JvmStatic
    fun GetClass(loadPackageParam: LoadPackageParam?, classLoader: ClassLoader?) {
        var classLoader = classLoader
        if (classLoader == null) {
            if (loadPackageParam != null) {
                classLoader = loadPackageParam.classLoader
            }
        }
        val fields_name = NeteaseClassInfo::class.java.fields
        val fileds_class = NeteaseClass::class.java.fields
        //获取全部类
        for (fl in fields_name) {
            try {
                val ClassName = fl[null] as String
                val FieldName = fl.name
                var thisClassField: Field? = null
                for (f in fileds_class) {
                    val name = f.name
                    if (name == FieldName) {
                        thisClassField = f
                    }
                }
                if (thisClassField != null) {
                    LOG.LOGD(LOG.LOG_Debug, "LoaderClass:$ClassName")
                    val clazz = XposedHelpers.findClass(ClassName, classLoader)
                    //设置类到当前类到变量
                    thisClassField[null] = clazz
                    LOG.LOGD(LOG.LOG_Debug, "LoaderSuccess:$ClassName")
                } else {
                    LOG.LOGD(LOG.LOG_THROW, "LoaderError Find err: $FieldName")
                    LOG.LOGD(LOG.LOG_THROW, "LoaderError: $ClassName")
                }
            } catch (e: Exception) {
                LOG.LOGD(LOG.LOG_THROW, e.toString())
            }
        }
    }
}