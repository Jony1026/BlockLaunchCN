package org.libtlauncher.toolbox.xposed.info;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import org.libtlauncher.toolbox.debug.LOG;

import static android.content.Context.MODE_PRIVATE;

public class publicInfo {
    public static String InfoKey = "5c6609bc20a1f1812a82957e3c01ae6b";
    public static boolean isAutoLogin = false;
    public static String cloudVersion = null;

    public void putInfo(Activity activity,boolean isAutoLoginBool){
        SharedPreferences sp = activity.getSharedPreferences("public_Info",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("isAutoLogin", String.valueOf(isAutoLoginBool));
        boolean commit = editor.commit();
        LOG.LOGD(LOG.LOG_Java,"sp:"+commit);
    }

    public static boolean checkIsAutoLogin(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences("BlockLauncherInfo", MODE_PRIVATE);
        if (sp.getString("isAutoLogin", "none").equals("none") && sp.getString("isAutoLogin", "none").equals("false")) {
            return false;
        } else if (sp.getString("isAutoLogin", "none").equals("true")) {
            return true;
        }else return false;
    }
}
