package org.libtlauncher.toolbox.Utils.pluginUtil.userUtil;

public class LauncherInfo {
    private static String NULL = "未初始化";
    public static String Tag = NULL;
    public static String UserName = NULL;
    public static String UserQQ = NULL;
    public static String UserEmail = NULL;
    public static String UserActor = NULL;
    public static String UserLevel = NULL;
    public static String UserHasPlugin = NULL;
    public static String UserHasLoaderMode = NULL;

    public static String UserID = NULL;
    public static String UserPass = NULL;

    public static boolean isLoginUser = false;

    public static boolean isLoaderDebug = false;
    public static boolean isShowDebug = false;
    public static String JsPath = "/sdcard/cs.js";
    public static int LoaderMode = 0;

    public static void setAllNull(){
        Tag = NULL;
        UserHasPlugin = NULL;
        UserName = NULL;
        UserQQ = NULL;
        UserEmail = NULL;
        UserActor = NULL;
        UserLevel = NULL;
        UserHasLoaderMode = NULL;
        isLoginUser = false;
    }

}
