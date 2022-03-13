package org.libtlauncher.toolbox.control;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.EditText;

@SuppressLint("AppCompatCustomView")
public class MIUIEdit extends EditText {
    public MIUIEdit(Context context) {
        super(context);
    }

    public MIUIEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MIUIEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MIUIEdit(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setSingleLine(true);
        setTextColor(Color.parseColor("#000000"));
        setHintTextColor(Color.parseColor("#88000000"));
        setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(30.0f);
        gradientDrawable.setStroke(5, Color.parseColor("#FF1E88E5"));
        setBackground(gradientDrawable);
    }
}

