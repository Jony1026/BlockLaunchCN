package org.libtlauncher.toolbox.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class BlockLinearLayout extends LinearLayout implements NestedScrollingParent {

    private View mHeaderView;
    private View mFooterView;
    private static final int MAX_WIDTH = 500;
    private View mChildView;
    // 解决多点触控问题
    private boolean isRunAnim;
    private int mDrag = 2;

    public BlockLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        mHeaderView = new View(context);
        mHeaderView.setBackgroundColor(0xffFFC125);
        mFooterView = new View(context);
        mFooterView.setBackgroundColor(0xffFF3E96);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mChildView = getChildAt(0);
        LayoutParams layoutParams = new LayoutParams(MAX_WIDTH, LayoutParams.MATCH_PARENT);
        addView(mHeaderView, 0, layoutParams);
        addView(mFooterView, getChildCount(), layoutParams);
        // 左移
        scrollBy(MAX_WIDTH, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ViewGroup.LayoutParams params = mChildView.getLayoutParams();
        params.width = getMeasuredWidth();
    }

    /**
     * 必须要复写 onStartNestedScroll后调用
     */
    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {

    }

    /**
     * 返回true代表处理本次事件
     */
    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        if (target instanceof RecyclerView && !isRunAnim) {
            return true;
        }
        return false;
    }

    /**
     * 复位初始位置
     */
    @Override
    public void onStopNestedScroll(View target) {
        startAnimation(new ProgressAnimation());
    }

    /**
     * 回弹动画
     */
    private class ProgressAnimation extends Animation {
        // 预留
        private float startProgress = 0;
        private float endProgress = 1;

        private ProgressAnimation(){
            isRunAnim = true;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            float progress = ((endProgress - startProgress) * interpolatedTime) + startProgress;
            scrollBy((int) ((MAX_WIDTH - getScrollX()) * progress), 0);
            if (progress == 1) {
                isRunAnim = false;
            }
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            setDuration(260);
            setInterpolator(new AccelerateInterpolator());
        }
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        // 如果在自定义ViewGroup之上还有父View交给我来处理
        getParent().requestDisallowInterceptTouchEvent(true);
        // dx>0 往左滑动 dx<0往右滑动
        boolean hiddenLeft = dx > 0 && getScrollX() < MAX_WIDTH && !ViewCompat.canScrollHorizontally(target, -1);
        boolean showLeft = dx < 0 && !ViewCompat.canScrollHorizontally(target, -1);
        boolean hiddenRight = dx < 0 && getScrollX() > MAX_WIDTH && !ViewCompat.canScrollHorizontally(target, 1);
        boolean showRight = dx > 0 && !ViewCompat.canScrollHorizontally(target, 1);
        if (hiddenLeft || showLeft || hiddenRight || showRight) {
            scrollBy(dx / mDrag, 0);
            consumed[0] = dx;
        }

        // 限制错位问题
        if (dx > 0 && getScrollX() > MAX_WIDTH && !ViewCompat.canScrollHorizontally(target, -1)) {
            scrollTo(MAX_WIDTH, 0);
        }
        if (dx < 0 && getScrollX() < MAX_WIDTH && !ViewCompat.canScrollHorizontally(target, 1)) {
            scrollTo(MAX_WIDTH, 0);
        }
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }


    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        // 当RecyclerView在界面之内交给它自己惯性滑动
        if (getScrollX() == MAX_WIDTH) {
            return false;
        }
        return true;
    }

    @Override
    public int getNestedScrollAxes() {
        return 0;
    }

    /**
     * 限制滑动 移动x轴不能超出最大范围
     */
    @Override
    public void scrollTo(int x, int y) {
        if (x < 0) {
            x = 0;
        } else if (x > MAX_WIDTH * 2) {
            x = MAX_WIDTH * 2;
        }
        super.scrollTo(x, y);
    }
}