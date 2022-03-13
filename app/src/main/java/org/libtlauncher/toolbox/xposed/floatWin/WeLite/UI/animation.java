package org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI;
import android.animation.Animator;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.AlphaAnimation;

public class animation {
	/*#揭露*/
	public static ViewTreeObserver.OnGlobalLayoutListener UIReveal(final LinearLayout view,final int x,final int y,final float startr,final float endr,final int time) {
		 final ViewTreeObserver.OnGlobalLayoutListener  globallayoutlinstener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {
				
				Animator anim = ViewAnimationUtils.createCircularReveal(view, x, y, startr, endr);
				anim.setDuration(time);
				anim.start();
				view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
			}
		};
		view.setVisibility(android.view.View.VISIBLE);
		view.getViewTreeObserver().addOnGlobalLayoutListener(globallayoutlinstener);
		return globallayoutlinstener;
	};
	/*#移动*/
	public static TranslateAnimation UIMove(LinearLayout  view,int x1,int x2,int y1,int y2,int time,int type) {
	
		 int tp = ((type == 0) ? android.view.animation.Animation.RELATIVE_TO_SELF : type == 1 ? android.view.animation.Animation.RELATIVE_TO_PARENT : android.view.animation.Animation.ABSOLUTE);
		 TranslateAnimation dh = new android.view.animation.TranslateAnimation(tp,(int)( x1 * 0.01), tp,(int)( x2 * 0.01), tp,(int)( y1 * 0.01), tp,(int)( y2 * 0.01));
		 dh.setDuration(time);
		 if (view != null) view.startAnimation(dh);
		return dh;
	};
	/*#旋转*/
	public static RotateAnimation UIRotate(LinearLayout view,int A,int B,int x,int y,int time,int type) {
		
		int tp = (( type == 0) ? android.view.animation.Animation.RELATIVE_TO_SELF : type == 1 ? android.view.animation.Animation.RELATIVE_TO_PARENT : android.view.animation.Animation.ABSOLUTE);
		RotateAnimation dh = new android.view.animation.RotateAnimation(A, B, tp, (int)(x * 0.01), tp, (int)(y * 0.01));
		dh.setDuration(time);
		dh.setFillAfter(true);
		if (view != null) view.startAnimation(dh);
		return dh;
	};
	/*#收缩*/
	public static ScaleAnimation UIShrink(LinearLayout view,int x1,int x2,int y1,int y2,int x,int y,int time,int type) {
	
		int tp = (( type == 0) ? android.view.animation.Animation.RELATIVE_TO_SELF : type == 1 ? android.view.animation.Animation.RELATIVE_TO_PARENT : android.view.animation.Animation.ABSOLUTE);
		ScaleAnimation dh = new android.view.animation.ScaleAnimation((int)(x1 * 0.01), (int)(x2 * 0.01), (int)(y1 * 0.01), (int)(y2 * 0.01), tp, (int)(x * 0.01), tp, (int)(y * 0.01));
		dh.setDuration(time);
		if (view != null) view.startAnimation(dh);
		return dh;
	};
	/*#淡入*/
	public static AlphaAnimation UIFadein(LinearLayout view,int A,int B,int time) {
		AlphaAnimation dh = new android.view.animation.AlphaAnimation((int)(A * 0.01), (int)(B * 0.01));
		dh.setDuration(time);
		if (view != null) view.startAnimation(dh);
		return dh;
	};
	/*#缩放*/
	public static ScaleAnimation UIZoom(LinearLayout view,int In,int out,int time,int type) {
		return UIShrink(view, In, out, In, out, 50, 50, time, type);
	};
	/*#水平*/
	public static TranslateAnimation UILevel(LinearLayout view,int In,int out,int time,int type) {
		return UIMove(view, In, out, 0, 0, time, type);
	};
	/*#垂直*/
	public static TranslateAnimation UIPlumb(LinearLayout view,int In,int out,int time,int type) {
		return UIMove(view, 0, 0, In, out, time, type);
	};
}
