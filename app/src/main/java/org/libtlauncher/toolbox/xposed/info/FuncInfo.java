package org.libtlauncher.toolbox.xposed.info;

public class FuncInfo {
    /*功能变量 Java层*/

    //功能1 IP外进
    public static boolean isMaskIP = false;//是否启动IP外进
    public static String MaskIP = "42.186.8.52";//外进IP
    public static int MaskPort = 15963;//外进端口

    //功能2 绕过游戏内聊天屏蔽词
    public static boolean isNoShieldingWords = true;//是否开启绕过游戏内聊天屏蔽词

    //功能2 自动实名认证
    public static boolean isAutoRealName = true;

    //功能3 绕过游戏内手机绑定
    public static boolean isNoMobileBindInGame = true;

    //功能4 IP外进租赁服
    public static boolean isMaskIPRental = isMaskIP;//是否启动IP租赁
    public static String MaskIPRental = MaskIP;//外进IP
    public static int MaskPortRental = MaskPort;//外进端口
}
