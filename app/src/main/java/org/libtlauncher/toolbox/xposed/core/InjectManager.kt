package org.libtlauncher.toolbox.xposed.core

import android.app.Activity
import dalvik.system.DexClassLoader
import java.io.File

object InjectManager {
    @JvmStatic
    @Throws(Exception::class)
    fun inject(MCActivity: Activity, MCPlayerName: String?, isScreen: Int,jsPath: String) {
        val dexPath = File(MCActivity.packageManager.getApplicationInfo("org.libtlauncher.toolbox", 0).sourceDir)
        if (!dexPath.exists()) return
        val c = "org.libtlauncher.toolbox.xposed.core.GameManager"
        val sp = MCActivity.packageManager.getApplicationInfo("org.libtlauncher.toolbox", 0).nativeLibraryDir
        val myClass = DexClassLoader(dexPath.absolutePath, MCActivity.getDir("dex", 0).absolutePath, sp, MCActivity.classLoader).loadClass(c)
        myClass.getMethod("LoaderJsByJava", Activity::class.java, String::class.java, Int::class.javaPrimitiveType,String::class.java).invoke(myClass.newInstance(), MCActivity, MCPlayerName, isScreen,jsPath)
    }
/*
    @JvmStatic
    @Throws(Exception::class)
    fun NoRoot(MCActivity: Activity) {
        val dexPath = File(MCActivity.packageManager.getApplicationInfo("org.libtlauncher.toolbox", 0).sourceDir)
        if (!dexPath.exists()) return
        val c = "org.libtlauncher.toolbox.xposed.NoRootInit"
        val sp = MCActivity.packageManager.getApplicationInfo("org.libtlauncher.toolbox", 0).nativeLibraryDir
        val myClass = DexClassLoader(dexPath.absolutePath, MCActivity.getDir("dex", 0).absolutePath, sp, MCActivity.classLoader).loadClass(c)
        myClass.getMethod("runNoRootHook", Activity::class.java).invoke(myClass.newInstance(), MCActivity)
    }*/
}