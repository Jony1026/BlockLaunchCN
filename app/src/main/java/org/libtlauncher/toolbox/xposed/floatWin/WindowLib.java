package org.libtlauncher.toolbox.xposed.floatWin;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class WindowLib {
    public static Object[] addWindowView(Context act, View v,int w,int h,int gravity) {
        Activity activity = (Activity) act;
        final WindowManager wm = activity.getWindowManager();

        WindowManager.LayoutParams params = new WindowManager.LayoutParams();

        if(gravity != 0) {
            params.gravity = gravity;
        }else{
            params.gravity = Gravity.CENTER;
        }

        params.format = PixelFormat.RGBA_8888;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }
        if(w == 0||h == 0) {
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        }else{
            params.width = w;
            params.height = h;
        }

       params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;

        params.windowAnimations = android.R.style.Animation_Translucent;

        wm.addView(v, params);

        return new Object[]{
                wm,
                params
        };
    }

    public static void addViews(LinearLayout main, View[] views){
        for (int i = 0 ; i < views.length;i++){
            main.addView(views[i]);
        }
    }
}
