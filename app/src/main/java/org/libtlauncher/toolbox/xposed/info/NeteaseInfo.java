package org.libtlauncher.toolbox.xposed.info;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

@SuppressLint("StaticFieldLeak")
public class NeteaseInfo {
    /*加固基本块*/
    public static ClassLoader ClassLoader = null;
    public static Context stubContext = null;
   /*MC基本块*/
    public static Context MCContext = null;
    public static Activity MCActivity = null;
    public static String UserNickName = null;
    /*设备伪装 没启用*/
    public static boolean IsMask = true;
    public static boolean IsAutoMask = false;
    public static String android_id = "93843948442";

    public static boolean AutoRunPlugin = false;
    public static String JsTips = "欢迎";

    /*Hook 可被动态修改*/
    public static String JsPath = null;
    public static int LoaderMode = 0;

    public static Intent it = null;
    public static boolean isLoaderDebug;

    public static int UserUin = 0;

    public static String UserID = null;
    public static String UserPass = null;

    public static boolean isXposed = false;
}
