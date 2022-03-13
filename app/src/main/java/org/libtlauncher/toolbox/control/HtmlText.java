package org.libtlauncher.toolbox.control;

import android.text.Html;
import android.text.Spanned;

public class HtmlText {

    public static String[][] color = {
            {" ", " &nbsp;"},
            {"§!", "<br/>"},
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
        for (int i = 0; i < 23; i++) {
            text = text.replace(color[i][0],color[i][1]);
        }
        return android.text.Html.fromHtml(text);
    }


}
