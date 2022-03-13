package org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI;

/*
 * File：FontColor
 * Author：XiaoMeng
 * QQ：3215476335
 * Tips：使用请保留此注释
 */

import android.text.Spanned;

public class fontColor {
    
    public static boolean FixColor = true;
    
    public static void useFixColor(boolean value){
        FixColor = value;
    }
    
    public static String[][] colors;
    
    
    public static String[][] defaultColor = {
        {" ", " &nbsp;"},
        {"\n", "<br/>"},
        {"§l", "</b><b>"},
        {"§m", "</del><del>"},
        {"§n", "</ins><ins>"},
        {"§o", "</i><i>"},
        {"§r", "</font></b></del></ins></i>"},
        {"§0", "</font><font color=#000000>"},
        {"§1", "</font><font color=#0000AA>"},
        {"§2", "</font><font color=#00AA00>"},
        {"§3", "</font><font color=#00AAAA>"},
        {"§4", "</font><font color=#AA0000>"},
        {"§5", "</font><font color=#AA00AA>"},
        {"§6", "</font><font color=#FFAA00>"},
        {"§7", "</font><font color=#cccccc>"},
        {"§8", "</font><font color=#555555>"},
        {"§9", "</font><font color=#5555FF>"},
        {"§a", "</font><font color=#55FF55>"},
        {"§b", "</font><font color=#55FFFF>"},
        {"§c", "</font><font color=#FF5555>"},
        {"§d", "</font><font color=#FF55FF>"},
        {"§e", "</font><font color=#FFFF55>"},
        {"§f", "</font><font color=#FFFFFF>"},
        {"§p", "</font><font color=#0090ff>"}
        };
    
    public static String[][] fixColor = {
        {" ", " &nbsp;"},
        {"\n", "<br/>"},
        {"§l", "</b><b>"},
        {"§m", "</del><del>"},
        {"§n", "</ins><ins>"},
        {"§o", "</i><i>"},
        {"§r", "</font></b></del></ins></i>"},
        {"§0", "</font><font color=#000000>"},
        {"§1", "</font><font color=#0000AA>"},
        {"§2", "</font><font color=#00AA00>"},
        {"§3", "</font><font color=#00AAAA>"},
        {"§4", "</font><font color=#AA0000>"},
        {"§5", "</font><font color=#AA00AA>"},
        {"§6", "</font><font color=#FFAA00>"},
        {"§7", "</font><font color=#cccccc>"},
        {"§8", "</font><font color=#555555>"},
        {"§9", "</font><font color=#5555FF>"},
        {"§a", "</font><font color=#00AA00>"},
        {"§b", "</font><font color=#0000AA>"},
        {"§c", "</font><font color=#AA0000>"},
        {"§d", "</font><font color=#AA00AA>"},
        {"§e", "</font><font color=#FFAA00>"},
        {"§f", "</font><font color=#FFFFFF>"},
        {"§p", "</font><font color=#0090ff>"}
    };
    
    
    public static Spanned parse(String text){
        if(FixColor == false){
        colors = defaultColor;
        }else if(FixColor == true){
            colors = fixColor;
        }
        for (int i = 0; i < 23; i++) {
            text = text.replace(colors[i][0],colors[i][1]);
        }
        return android.text.Html.fromHtml(text);
    }
    
    
}
