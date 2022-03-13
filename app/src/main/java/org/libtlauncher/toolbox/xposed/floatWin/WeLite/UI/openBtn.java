package org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI;
import android.content.Context;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.app.Activity;
import android.widget.LinearLayout;
import android.view.View;
import android.view.Gravity;
import android.view.MotionEvent;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.animation.Animator;
import android.graphics.Color;

public class openBtn{
    private Context context;
    private Context ctx20;
    private PopupWindow mOpBtmWindow;
    private int orgX, orgY;
    private int offsetX = 0,offsetY = 300;

    private static WindowManager mWindowManager = null;
    private static Context mContext = null;
    private static View mView = null;

    public static boolean x=false;

    public openBtn(Context ctx){
        context = ctx;
        offsetX = W();
        initBtn();
    }

    public void show(){

        if(mOpBtmWindow!=null&&!mOpBtmWindow.isShowing())
            mOpBtmWindow.showAtLocation(((Activity)context).getWindow().getDecorView(), Gravity.LEFT|Gravity.TOP,offsetX,offsetY);

    }
    public void dismiss(){
        if(mOpBtmWindow!=null&&mOpBtmWindow.isShowing()){
            mOpBtmWindow.dismiss();
        }
    }

    private int H(){
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private int W(){
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private int DoubleToInt(double mDouble){
        int num = (new Double(mDouble)).intValue();
        return num;
    }
    private int dip2px(float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    private void initBtn(){

        final LinearLayout $av = new LinearLayout(context);
        $av.setOrientation(1);

        final LinearLayout av2=new LinearLayout(context);
        av2.setGravity(Gravity.CENTER|Gravity.CENTER);
        av2.setLayoutParams(new LinearLayout.LayoutParams(dip2px(40),dip2px(40)));
        av2.setBackgroundDrawable(drawable.Round("#ffffff",new float[]{99,99,99,99}));
        av2.setOrientation(1);
        LinearLayout log=new LinearLayout(context);
        log.setLayoutParams(new LinearLayout.LayoutParams(dip2px(31),dip2px(31)));
        log.setGravity(Gravity.CENTER|Gravity.CENTER);
        log.setBackgroundDrawable(drawable.RoundBG(new int[]{Color.parseColor("#9FA5D5"),Color.parseColor("#E8F5C8")}, new float[]{100,100,100,100},"RB"));
        log.setOrientation(1);
        LinearLayout log2=new LinearLayout(context);
        log2.setLayoutParams(new LinearLayout.LayoutParams(dip2px(15),dip2px(15)));
        log2.setBackgroundDrawable(drawable.Round("#ffffff",new float[]{99,99,99,99}));
        log2.setOrientation(1);
        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!x){
                    //	intpopwin.popwin_two(context);
                    LiteUI.Menu((Activity) context);
                }
                x=!x;
            }
        });


        log.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN) {
                    orgX = (int) event.getX();
                    orgY = (int) event.getY();
                } else if (action == MotionEvent.ACTION_MOVE) {
                    offsetX = (int) event.getRawX() - orgX;
                    offsetY = (int) event.getRawY() - orgY;
                    mOpBtmWindow.update(offsetX, offsetY, -1, -1, true);

                    if (offsetY > H() - DoubleToInt(H() * 0.1)) {//bottom
                        av2.setBackgroundDrawable(drawable.Round("#ffffff", new float[]{99, 99, 0, 0}));
                    } else if (offsetY < 0 + DoubleToInt(H() * 0.1)) {//top
                        av2.setBackgroundDrawable(drawable.Round("#ffffff", new float[]{0, 0, 99, 99}));
                    } else if (offsetX > W() - DoubleToInt(H() * 0.1)) {//right
                        av2.setBackgroundDrawable(drawable.Round("#ffffff", new float[]{99, 0, 0, 99}));
                    } else if (offsetX < 0 + DoubleToInt(H() * 0.1)) {//left
                        av2.setBackgroundDrawable(drawable.Round("#ffffff", new float[]{0, 99, 99, 0}));
                    } else {//mid
                        av2.setBackgroundDrawable(drawable.Round("#ffffff", new float[]{99, 99, 99, 99}));
                    }
                } else if (action == MotionEvent.ACTION_UP) {// canm = false;
                }
                return false;
            }
        });

        $av.addView(av2);
        av2.addView(log);
        log.addView(log2);
        setAnimator(log);

      mOpBtmWindow=new PopupWindow($av,LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

       //// runtime.addWindowView(contextm);

    }



    private void setAnimator(final LinearLayout layout) {
        final ObjectAnimator animator = ObjectAnimator.ofFloat(layout, "rotation", 0f, 360f);
        LinearInterpolator lin = new LinearInterpolator();
        animator.setInterpolator(lin);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                setAnimator(layout);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.setDuration(50);
        animator.start();
    }


}
