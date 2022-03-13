package org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI;

import android.widget.ScrollView;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.app.Activity;
import android.widget.TextView;

import android.util.DisplayMetrics;
import android.text.Spanned;

import static org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI.drawable.RoundBG;

public class WeLibs {

    public static LinearLayout W_LinearLayout(Activity ctx,int sizeW,int sizeH,int[] color,float[] cr,String or,String gravity,int ori){

        LinearLayout _L1=new android.widget.LinearLayout(ctx);

        _L1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(sizeW,sizeH));
        if(gravity=="LT"){_L1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.TOP);
        }else if(gravity=="LL"){
            _L1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.CENTER);
        }else if(gravity=="LB"){
            _L1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.BOTTOM);
        }else if(gravity=="CT"){
            _L1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.TOP);
        }else if(gravity=="CC"){
            _L1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.CENTER);
        }else if(gravity=="CB"){
            _L1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.BOTTOM);
        }else if(gravity=="RT"){
            _L1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.TOP);
        }else if(gravity=="RR"){
            _L1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.CENTER);
        }else if(gravity=="RB"){
            _L1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.BOTTOM);
        };

        _L1.setOrientation(ori);



        _L1.setBackgroundDrawable(RoundBG(color,cr,or));



        return _L1;
    }

    public static int H(Activity ctx) {
        DisplayMetrics metrics = new android.util.DisplayMetrics();
        ctx.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    };

    public static int W(Activity ctx) {
        DisplayMetrics metrics = new android.util.DisplayMetrics();
        ctx.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    };


    public static ScrollView NewScrollView(Context context,int w,int h){
        ScrollView sc=new ScrollView(context);
        sc.setLayoutParams(new android.widget.LinearLayout.LayoutParams(w,h));
        sc.setVerticalScrollBarEnabled(false);

        return sc;
    };

    public static LinearLayout W_LinearLayout(Activity ctx,int sizeW,int sizeH,int color,float[] cr,String or,String gravity,int ori){

        LinearLayout _L1=new android.widget.LinearLayout(ctx);

        _L1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(sizeW,sizeH));
        if(gravity=="LT"){_L1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.TOP);
        }else if(gravity=="LL"){
            _L1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.CENTER);
        }else if(gravity=="LB"){
            _L1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.BOTTOM);
        }else if(gravity=="CT"){
            _L1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.TOP);
        }else if(gravity=="CC"){
            _L1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.CENTER);
        }else if(gravity=="CB"){
            _L1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.BOTTOM);
        }else if(gravity=="RT"){
            _L1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.TOP);
        }else if(gravity=="RR"){
            _L1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.CENTER);
        }else if(gravity=="RB"){
            _L1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.BOTTOM);
        };

        _L1.setOrientation(ori);



        _L1.setBackgroundDrawable(RoundBG(color,cr,or));



        return _L1;
    };




    public static PopupWindow NewCDV(Activity ctx,View view,int sizeW,int sizeH,int color,float[] cr,String or,boolean fa,boolean ta,String gravity,int pyx,int pyy,String anim){
        PopupWindow _CView = new android.widget.PopupWindow();

        _CView.setBackgroundDrawable(RoundBG(color,cr,or));


        _CView.setContentView(view);
        _CView.setWidth(sizeW);
        _CView.setHeight(sizeH);
        _CView.setFocusable(fa);
        _CView.setTouchable(ta);
        switch(anim){
            case "null":
                _CView.setAnimationStyle(android.R.style.Animation_Dialog);
                break;
            case "In":
                _CView.setAnimationStyle(android.R.style.Animation_InputMethod);
                break;
            case "To":
                _CView.setAnimationStyle(android.R.style.Animation_Toast);
                break;
            case "Tr":
                _CView.setAnimationStyle(android.R.style.Animation_Translucent);
                break;
            case "Ac":
                _CView.setAnimationStyle(android.R.style.Animation_Activity);
                break;
        };
        if(gravity=="LT"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.LEFT|android.view.Gravity.TOP,pyx,pyy);
        }else if(gravity=="LL"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.LEFT|android.view.Gravity.CENTER,pyx,pyy);
        }else if(gravity=="LB"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.LEFT|android.view.Gravity.BOTTOM,pyx,pyy);
        }else if(gravity=="CT"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.CENTER|android.view.Gravity.TOP,pyx,pyy);
        }else if(gravity=="CC"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.CENTER|android.view.Gravity.CENTER,pyx,pyy);
        }else if(gravity=="CB"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.CENTER|android.view.Gravity.BOTTOM,pyx,pyy);
        }else if(gravity=="RT"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.RIGHT|android.view.Gravity.TOP,pyx,pyy);
        }else if(gravity=="RR"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.RIGHT|android.view.Gravity.CENTER,pyx,pyy);
        }else if(gravity=="RB"){
            _CView.showAtLocation(ctx.getWindow().getDecorView(),android.view.Gravity.RIGHT|android.view.Gravity.BOTTOM,pyx,pyy);
        };
        return _CView;
    };


    public static TextView LText(Context ctx,Spanned text,String gravity,int size,String color){
        TextView _T1 = new android.widget.TextView(ctx);
        if(gravity=="LT"){
            _T1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.TOP);
        }else if(gravity=="LL"){
            _T1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.CENTER);
        }else if(gravity=="LB"){
            _T1.setGravity(android.view.Gravity.LEFT|android.view.Gravity.BOTTOM);
        }else if(gravity=="CT"){
            _T1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.TOP);
        }else if(gravity=="CC"){
            _T1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.CENTER);
        }else if(gravity=="CB"){
            _T1.setGravity(android.view.Gravity.CENTER|android.view.Gravity.BOTTOM);
        }else if(gravity=="RT"){
            _T1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.TOP);
        }else if(gravity=="RR"){
            _T1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.CENTER);
        }else if(gravity=="RB"){
            _T1.setGravity(android.view.Gravity.RIGHT|android.view.Gravity.BOTTOM);
        };
        _T1.setText(text);

        _T1.setTextSize(size);

        if(color!=null){
            _T1.setTextColor(android.graphics.Color.parseColor(color));
        };
        return _T1;
    }

}

