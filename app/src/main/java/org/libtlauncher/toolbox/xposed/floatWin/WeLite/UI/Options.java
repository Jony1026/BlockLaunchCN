package org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI;
import android.widget.LinearLayout;
import android.app.Activity;
import android.graphics.Color;
import android.widget.TextView;

import static org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI.drawable.RoundBG;
import static org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI.fontColor.parse;


public class Options {

    public static boolean[] booleans = new boolean[100];
    int ViewInt=0;

    public static boolean getViewBool(int n) {
        if (booleans[n]) {
            booleans[n] = false;
            return booleans[n];
        }else{

            booleans[n] = !booleans[n];
            return booleans[n];
        }
    }
    public static LinearLayout NewOption(Activity ctx, String text, final int type, final boolean fa){
        LinearLayout O1= WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29* LiteUI.size),(int)(WeLibs.H(ctx)*0.1* LiteUI.size), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

       LinearLayout O3= WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29* LiteUI.size),(int)(WeLibs.H(ctx)*0.09* LiteUI.size), Color.parseColor("#41ffffff"), new float[]{0,0,0,0}, "上下", "CC",0);
        LinearLayout O4= WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29* LiteUI.size),(int)(WeLibs.H(ctx)*0.09* LiteUI.size), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);


        final LinearLayout O5= WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.016* LiteUI.size),(int)(WeLibs.H(ctx)*0.09* LiteUI.size), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);
        if(type==1){
            O5.setBackgroundDrawable(RoundBG(new int[]{Color.parseColor("#96c8c8c8"),Color.parseColor("#96c8c8c8")},new float[]{0,0,0,0},"RB"));
        }else if(type==2){
            if(!fa){
                O5.setBackgroundDrawable(RoundBG(new int[]{Color.parseColor("#ffff4b4b"),Color.parseColor("#ffff9696")},new float[]{0,0,0,0},"RB"));
            }else{
                O5.setBackgroundDrawable(RoundBG(new int[]{Color.parseColor("#ff64ffa7"),Color.parseColor("#ff96ffff"),Color.parseColor("#fffdc8ff")},new float[]{0,0,0,0},"RB"));
            }
        }

        TextView OT= WeLibs.LText(ctx,parse(text),"CC",(int)(14*0.9),"#000000");
        O1.addView(O3);
        O3.addView(O4);
        O4.addView(OT);
        O3.addView(O5);

        return O1;

    };

}
