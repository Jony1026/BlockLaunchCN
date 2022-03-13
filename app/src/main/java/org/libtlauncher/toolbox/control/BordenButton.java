package org.libtlauncher.toolbox.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class BordenButton extends Button {
    public BordenButton(Context context) {
        super(context);
    }

    public BordenButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BordenButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BordenButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }


    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setSingleLine(true);
        setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20.0f);
        gradientDrawable.setColor(Color.parseColor("#1E88E5"));
        //gradientDrawable.setStroke(5, Color.parseColor("#1E88E5"));
        setBackground(gradientDrawable);
    }
}


