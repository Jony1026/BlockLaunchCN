package org.libtlauncher.toolbox.xposed.core;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.libtlauncher.toolbox.control.FMP_Toast;
import org.libtlauncher.toolbox.debug.LOG;
import org.libtlauncher.toolbox.xposed.core.scriptmanager.PEManager;
import org.libtlauncher.toolbox.xposed.core.scriptmanager.ToolBox;
import org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI.LiteUI;
import org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI.WeLibs;
import org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI.openBtn;
import org.libtlauncher.toolbox.xposed.floatWin.WindowLib;
import org.libtlauncher.toolbox.xposed.info.NeteaseInfo;
import org.libtlauncher.toolbox.xposed.joinRoom.callPython;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Handler;

import de.robv.android.xposed.XposedHelpers;

public class GameManager {

    @SuppressLint("StaticFieldLeak")
    private static Activity activity;
    public static WeakReference<Activity> weakReference;
    public static void LoaderJsByJava(final Activity act, final String name , int i , String path){
        try {
            activity = act;
            /*反射*/
           Field field = act.getClass().getDeclaredField("currentMainActivity");
           field.setAccessible(true);
           field.set(act, new WeakReference<>(act));

            act.setTheme(androidx.appcompat.R.style.Theme_AppCompat_Light);
            act.setTheme(android.R.style.Theme_Material_Light);

           // FMP_Toast.BM_Toast(act,"在此使用了FMP助手的 BM_Toast 原作者为 @Gaozaici 感谢 如有侵权请联系我 我将删除",true);
            //Runtime.getRuntime().loadLibrary("Toolbox-Netease-support-122");
           //Runtime.getRuntime().loadLibrary("Toolbox-C++-support");
           //Runtime.getRuntime().loadLibrary("JSSocket");

            FMP_Toast.BM_Toast(act,"so库加载成功! - api supports was add",true);

            if(i==1)act.setRequestedOrientation(0);
           openBtn openBtn = new openBtn(act);
           openBtn.show();
           RNWindow.show(act);
           //PEManager.LoadJs("/sdcard/aa.js");
           FMP_Toast.BM_Toast(act,"启动成功 祝您游戏愉快~",true);

           if(i==1)act.setRequestedOrientation(1);


        }catch (Exception err){
            LOG.LOGD(LOG.LOG_NativeJs,"err"+err.getMessage());
        }
    }





}
