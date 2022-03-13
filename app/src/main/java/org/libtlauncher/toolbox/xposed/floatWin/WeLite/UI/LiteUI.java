package org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.widget.PopupWindow;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.graphics.Color;

import android.widget.ScrollView;

import android.view.View;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.libtlauncher.toolbox.debug.LOG;
import org.libtlauncher.toolbox.xposed.jniManager.callJava;


public class LiteUI {

    public static PopupWindow MAC=null;

    public static String loget="iVBORw0KGgoAAAANSUhEUgAAABsAAAAbCAYAAACN1PRVAAAAAXNSR0IArs4c6QAAAARzQklUCAgI\nCHwIZIgAAAC/SURBVEiJ7dSxasJgEAfwH1XrY+RpnF3s2sGnEJyd+hIubqGVtFvX7r5HH0AHEbsk\nkIRYC7mEDvnDDQfH/fg4+BgSkFHgrik2SHAI3NsIfeCa16pLLC1BnYMzHBvAZXnooQUwRYZnfGKO\nU20mabG/AhU3uuQg1Re+YhIJFVUHdxHQYwPUBLbOb1BRaV9QyI16hd7vQG8DdAvK/gu0j4DgpS8I\ntl1Cf/31Mzzh3DWWYdEWgnGt/6r131hHQEPC8gPHX3+UvprbjAAAAABJRU5ErkJggg==\n";
    public static String logfc="iVBORw0KGgoAAAANSUhEUgAAABsAAAAbCAYAAACN1PRVAAAAAXNSR0IArs4c6QAAAARzQklUCAgI\nCHwIZIgAAAELSURBVEiJ7ZW9DcIwEEafUDpSpoyEC8ZIwQ4wAiMwBiNQeACGoAhbUIAEXUrKSFDE\nkHDEPwGCKHjSKXLy2efz3Tnw50dIAG0s6duZAi7GlEsYiXEGjAOd7IBcvJsBhUdzR1Pv0mfazFEB\nGuA5sgI4+EJqaCUnoPRo3kIRmLPBpz2/QwrsjaUWTUQVkeI5LZ1QBB5RCHInc6ryvxG3zJEaFzmw\nsn3U2MtYBWg6lb5swBiYejQuumj7zZmkpG7yW7MmVBGf6aFpJZqWfITw1aaWx7ikurnbyIBjYzwD\nJp7118DC5iwBRoEbGxpz8fAzlQusgI1loiyGLY6GNew8371oXiyQVy7OXDz/fJcro6VT3zfnok8A\nAAAASUVORK5CYII=\n";
    public static String logpi="iVBORw0KGgoAAAANSUhEUgAAABsAAAAbCAYAAACN1PRVAAAAAXNSR0IArs4c6QAAAARzQklUCAgI\nCHwIZIgAAACtSURBVEiJ7ZPdDcIgFIW/agdwBEfoBnWkjtARHMFR6AaM0BG6gT4AyQ2W4G1I1YYv\nIdyHC4efc6BS+RUaUXfARbl+AewWYQM8lcNoBE5bTlWJkQa540yiwQKDr42fBxKmaUXdAb1STBLW\nJh0txR4o3QXMyv5ihDjcUg3xM+ZCbXFBvvqxRvzvq8E35EMcTj1+0PsW/L8NdfbPdr3ZccXOBfdq\ngAnnvqXgvpUv8gLshTXaQVpGawAAAABJRU5ErkJggg==\n";
    public static String logqs="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\n";
    public static String logcd="iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAAAXNSR0IArs4c6QAAAARzQklUCAgI\nCHwIZIgAAAJqSURBVFiF7ZZPSBRRGMB/35uJAgsKCsEID+GhS3kIERMiKG/hSZIk8Nahjs4DvTie\nXEcUT506CP2BXOocderSHzQ7eCqENqjAkqBiD+HOfB3akc3WnXGdzcv+bjPzve/9+N733jxo0qRJ\nY5F6Bo2Ojh4rlUqDQB/QCRwFXGANWAEeu657f3Jy8mtDhXzfP1gsFn3gBnAgIfwXcEtExoMg+Jm5\n0MjIyGkReQScTDumzHtjTP/U1NRKZkLW2rOq+hQ4vEOZmO9hGF6YnZ19s2uhsbGx1o2NjWWgrU6Z\nmE9RFHXOzMys1woySVlKpdJcBjIAx40xc0lB1Sok1tqLURRdE5FuoCMxicgEgKqOJ4SqMeZMrX5y\nKx+staeiKLqtqj0i6fpdRCaCIPDL45OkJIqi68DN7QI2l8zzvPOq+lJEelKZbJEBCILAj6tVg8s1\nc5ZlOoDXwKF6ZSqx1voJlfoMLAL3WlpaHvq+H8UfDICqzmclA6kq1Qb0AwvFYvGV53mbZ5tYay+p\n6pOsZCpJUamYNcdxenO53KpR1cFGyEDqngJoDcPwwcDAgCOe570jxdYGPojI/NYJqwVaa/96r6rD\nQHvSBKo65JL+0GuvUv6qQimX6R9EZMgA++oZ3CC6DPBxry0qOGKA53ttUcE3Y4y5u9cWMSKyFJ/U\nL4DuOhJU3dL1NjVw1S0nHlbVRXZwWu9y4mosFwqFBQMQBMFb/vz0fmQ4wU744jjOlXw+H27+7aen\np5+JSJeq/u8mX3Yc51wul1uFba6wnuf1AUPle9EJYH+GAgqsi8iSqt4pFAoL+Xw+zDB/kyZNavIb\n98vyWpKjoVMAAAAASUVORK5CYII=\n";
    public static String logst="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\n";
    public static double size=0.9485;

    public static BitmapDrawable BaseT(String str){

        byte[] A = android.util.Base64.decode(str, 0);
        BitmapDrawable B=new android.graphics.drawable.BitmapDrawable(android.graphics.BitmapFactory.decodeByteArray(A, 0, A.length));
        return B;

    };


    public static void Menu(final Activity ctx){
        ctx.runOnUiThread(new java.lang.Runnable(){
            @SuppressLint("Range")
            @Override
            public void run() {
                if(MAC!=null){
                    MAC.dismiss();
                    MAC=null;
                }else{
                    final LinearLayout MA1=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout MA2=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)), Color.parseColor("#64ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout MA3=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)*0.1), Color.parseColor("#64ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout	MA4=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)*0.1), Color.parseColor("#64ffffff"), new float[]{0,0,0,0}, "上下", "CC",0);

                    LinearLayout	MA5=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)*0.02),new int[]{
                                    Color.parseColor("#ffc8c8c8"),
                                    Color.parseColor("#10c8c8c8")
                            }, new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout  MA6=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)- WeLibs.H(ctx)*0.1- WeLibs.H(ctx)*0.1- WeLibs.H(ctx)*0.04- WeLibs.H(ctx)*0.1), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    final ScrollView MA7=
                            WeLibs.NewScrollView(ctx, (int)(WeLibs.W(ctx) * 0.29*size),(int)(WeLibs.H(ctx)- WeLibs.H(ctx)*0.1*0.9- WeLibs.H(ctx)*0.1*0.9- WeLibs.H(ctx)*0.04- WeLibs.H(ctx)*0.1*0.9));

                    final LinearLayout MA8=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)- WeLibs.H(ctx)*0.1*0.9- WeLibs.H(ctx)*0.1*0.9- WeLibs.H(ctx)*0.04- WeLibs.H(ctx)*0.1*0.9), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout	MA9=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)*0.02),new int[]{
                                    Color.parseColor("#10c8c8c8"),
                                    Color.parseColor("#ffc8c8c8")
                            }, new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout	MA10=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.29*size),(int)(WeLibs.H(ctx)*0.1), Color.parseColor("#64ffffff"), new float[]{0,0,0,0}, "上下", "CC",0);

                    final TextView 	MAT1=
                            WeLibs.LText(ctx, fontColor.parse("—｜ 攻 击 ｜—"),"CC",(int)(20*size),"#000000");
                    MAT1.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            MAC.dismiss();
                        }
                    });
                    final LinearLayout	MA11=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.09),(int)(WeLibs.H(ctx)*0.15), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);


                    final LinearLayout	MA12=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.036),(int)(WeLibs.W(ctx)*0.036), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    final LinearLayout	MA13=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.09),(int)(WeLibs.H(ctx)*0.15), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    final LinearLayout	MA14=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.036),(int)(WeLibs.W(ctx)*0.036), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    final LinearLayout	MA15=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.09),(int)(WeLibs.H(ctx)*0.15), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);



                    final LinearLayout	MA16=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.036),(int)(WeLibs.W(ctx)*0.036), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);
                    MA12.setBackground(BaseT(loget));
                    MA12.setOnClickListener(new View.OnClickListener() {



                        @Override
                        public void onClick(View view) {
                            gui1(ctx,MAT1,MA8);
                            animation.UIReveal(MA8,(int)(WeLibs.W(ctx)*0.3*size/6*1),0,0,(int)(WeLibs.H(ctx)),500);
                        }
                    });


                    MA14.setBackground(BaseT(logfc));
                    MA14.setOnClickListener(new View.OnClickListener() {



                        @Override
                        public void onClick(View view) {
                            gui2(ctx,MAT1,MA8);
                            animation.UIReveal(MA8,(int)(WeLibs.W(ctx)*0.3*size/6*1),0,0,(int)(WeLibs.H(ctx)),500);
                        }
                    });

                    MA16.setBackground(BaseT(logpi));
                    MA16.setOnClickListener(new View.OnClickListener() {



                        @Override
                        public void onClick(View view) {
                            gui3(ctx,MAT1,MA8);
                            animation.UIReveal(MA8,(int)(WeLibs.W(ctx)*0.3*size/6*1),0,0,(int)(WeLibs.H(ctx)),500);
                        }
                    });

                    MA12.setAlpha(89);
                    MA14.setAlpha(89);
                    MA16.setAlpha(89);
                    LinearLayout	MA17=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.09),(int)(WeLibs.H(ctx)*0.15), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);


                    LinearLayout	MA18=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.036),(int)(WeLibs.W(ctx)*0.036), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout	MA19=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.09),(int)(WeLibs.H(ctx)*0.15), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);


                    LinearLayout	MA20=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.036),(int)(WeLibs.W(ctx)*0.036), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout	MA21=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.09),(int)(WeLibs.H(ctx)*0.15), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);

                    LinearLayout	MA22=
                            WeLibs.W_LinearLayout(ctx,(int)(WeLibs.W(ctx)*0.036),(int)(WeLibs.W(ctx)*0.036), Color.parseColor("#00ffffff"), new float[]{0,0,0,0}, "上下", "CC",1);




                    MA18.setBackground(BaseT(logqs));
                    MA20.setBackground(BaseT(logcd));
                    MA22.setBackground(BaseT(logst));
                    MA18.setAlpha(89);
                    MA20.setAlpha(89);
                    MA22.setAlpha(89);


                    MA1.addView(MA2);
                    MA2.addView(MA3);
                    MA3.addView(MAT1);
                    MA2.addView(MA4);
                    MA4.addView(MA11);
                    MA11.addView(MA12);
                    MA4.addView(MA13);
                    MA13.addView(MA14);
                    MA4.addView(MA15);
                    MA15.addView(MA16);
                    MA2.addView(MA5);
                    MA2.addView(MA6);
                    MA6.addView(MA7);
                    MA7.addView(MA8);

                    MA2.addView(MA9);
                    MA2.addView(MA10);
                    MA10.addView(MA17);
                    MA17.addView(MA18);
                    MA10.addView(MA19);
                    MA19.addView(MA20);
                    MA10.addView(MA21);
                    MA21.addView(MA22);

                    gui1(ctx,MAT1,MA8);
                    animation.UIReveal(MA8,(int)(WeLibs.W(ctx)*0.3*size/6*1),0,0,(int)(WeLibs.H(ctx)),500);

                    MAC= WeLibs.NewCDV(ctx,MA1,(Double.valueOf(WeLibs.W(ctx)*0.29*size)).intValue(),(Double.valueOf(WeLibs.H(ctx))).intValue(),Color.parseColor("#00ffffff"), new float[]{0,0,0,0},"上下",false,true,"RR",0,0,"Tr");
                };

            };


        });
    }

    public static void gui1(final Activity ctx, final TextView MAT1, final LinearLayout MA8){
        MA8.removeAllViews();
        MAT1.setText(fontColor.parse("— | 攻 击 | —"));

        LinearLayout kl = Options.NewOption(ctx,"开启杀戮",2,functionInfo.Killaura);
        kl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(functionInfo.Killaura){
                    function(new String[]{"Hack","State"},new String[]{"Killaura","false"},null,null);
                    functionInfo.Killaura = false;
                }else{
                    function(new String[]{"Hack","State"},new String[]{"Killaura","true"},null,null);
                    functionInfo.Killaura = true;
                }
                gui1(ctx,MAT1,MA8);
            }
        });

        LinearLayout va = Options.NewOption(ctx,"喷气背包",2,functionInfo.JetPack);
        va.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(functionInfo.JetPack){
                    function(new String[]{"Hack","State"},new String[]{"JetPack","false"},null,null);
                    functionInfo.JetPack = false;
                }else{
                    function(new String[]{"Hack","State"},new String[]{"JetPack","true"},null,null);
                    functionInfo.JetPack = true;
                }
                gui1(ctx,MAT1,MA8);
            }
        });


        LinearLayout va_2 = Options.NewOption(ctx,"获取冒险破坏物品",1,false);
        va_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function(new String[]{"Hack","Handle"},new String[]{"Destroy","true"},null,null);
            }
        });

        LinearLayout va_3 = Options.NewOption(ctx,"获取附魔 - Max",1,false);
        va_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             function(new String[]{"Hack","Action"},new String[]{"Enchant","EnchantAll"},null,null);
            }
        });

        LinearLayout va_4 = Options.NewOption(ctx,"下落无伤害",2,functionInfo.NoFall);
        va_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(functionInfo.NoFall){
                    function(new String[]{"Hack","State"},new String[]{"NoFall","false"},null,null);
                    functionInfo.NoFall = false;
                }else{
                    function(new String[]{"Hack","State"},new String[]{"NoFall","true"},null,null);
                    functionInfo.NoFall = true;
                }
                gui1(ctx,MAT1,MA8);
            }
        });

        LinearLayout va_5 = Options.NewOption(ctx,"获取物品",1,false);
        va_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        LinearLayout va_6 = Options.NewOption(ctx,"删除所有附魔",1,false);
        va_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function(new String[]{"Hack","Action"},new String[]{"Enchant","EnchantRm"},null,null);
            }
        });

        LinearLayout va_7 = Options.NewOption(ctx,"无视清空背包",2,functionInfo.AntiClear);
        va_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(functionInfo.AntiClear){
                    functionInfo.AntiClear = false;
                    function(new String[]{"Hack","State"},new String[]{"AntiClear","false"},null,null);
                }else{
                    functionInfo.AntiClear = true;
                    function(new String[]{"Hack","State"},new String[]{"AntiClear","true"},null,null);
                }
                gui1(ctx,MAT1,MA8);
            }
        });
/*
        MA8.addView(va);
        MA8.addView(va_2);
        MA8.addView(va_3);
        MA8.addView(va_4);
        MA8.addView(va_5);*/
        addViews(MA8,new View[]{kl,va,va_4,va_7,va_6,va_5,va_2,va_3});
    }

    public static void gui2(final Activity ctx, final TextView MAT1, final LinearLayout MA8){
        MA8.removeAllViews();
        MAT1.setText(fontColor.parse(" — | 游 戏 | —"));

        LinearLayout va_2 = Options.NewOption(ctx,"禁止被踢出游戏",1,functionInfo.AntiKick);
        va_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                if(functionInfo.AntiKick){
                    functionInfo.AntiKick = false;
                    function(new String[]{"Hack","State"},new String[]{"AntiClear","false"},null,null);
                }else{
                    functionInfo.AntiKick = true;
                    function(new String[]{"Hack","State"},new String[]{"AntiClear","true"},null,null);
                }
                gui1(ctx,MAT1,MA8);
            */
            }
        });
        addViews(MA8,new View[]{va_2});

    }

    public static void gui3(final Activity ctx, TextView MAT1, LinearLayout MA8){
        MA8.removeAllViews();
        MAT1.setText(fontColor.parse("— | 设 置 | —"));

        LinearLayout va_2 = Options.NewOption(ctx,"设置杀戮CPS 12(test",1,false);
        va_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


    }


    public static void addViews(LinearLayout main,View[] views){
        for (int i = 0 ; i < views.length;i++){
           main.addView(views[i]);
        }
    }

    public static void function(@NonNull String[] putItem, @NonNull String[] putString,@Nullable String[] cfg,@Nullable String[] cdg_value){
        callJava.Socket_Init("127.0.0.1","5001",9);
        JSONObject hack = new JSONObject();
        try {
            for(int i = 0;i<putItem.length;i++) {
                hack.put(putItem[i], putString[i]);
            }
            if(cfg != null){
                JSONObject config = new JSONObject();
                for(int cfg_i = 0;cfg_i<cfg.length;cfg_i++) {
                    config.put(cfg[cfg_i], cdg_value != null ? cdg_value[cfg_i] : null);
                }
                hack.put("Config",config);
            }
            JSONObject data = new JSONObject();
            data.put("JavaMessage",hack);

            callJava.Socket_Send(data.toString());
            callJava.Socket_Close();
        } catch (JSONException e) {
            LOG.LOGD(LOG.LOG_Java,e.toString());
            callJava.Socket_Close();
        }
    }

}


