package org.libtlauncher.toolbox.xposed.info;

public class NeteaseClassInfo {
    /*
     * 类型必须是public static String 并且变量名要与MeteaseClass对应
     */
    public static String NeteaseAppliction = "com.mojang.minecraftpe.AppContext";
    public static String MainActivity = "com.mojang.minecraftpe.MainActivity";/* 主活动包名 */
    public static String RNBridge = "com.mojang.minecraftpe.RNMCBridge";//RN包名
    public static String SdkNetease = "com.netease.ntunisdk.SdkNetease";//网易sdk包名
    public static String ReactApplicationContext = "com.facebook.react.bridge.ReactApplicationContext";//RN上下文
    public static String Promise = "com.facebook.react.bridge.Promise";//RN回调
    public static String DefaulRegex = "com.netease.environment.model.DefaultRegex";
    public static String FileUtils = "com.netease.environment.utils.FileUtils";
    public static String SdkData = "com.netease.environment.config.SdkData";
}
