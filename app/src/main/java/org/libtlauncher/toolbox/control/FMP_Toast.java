package org.libtlauncher.toolbox.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import android.graphics.drawable.NinePatchDrawable;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FMP_Toast {
    private static ImageView BM_ImageView;
    private static LinearLayout BM_Layout;
    private static TextView BM_TextView;
    private static Toast BM_Toast;

    public static void BM_Toast(Context context, String str, boolean z) {

        BM_Layout = new LinearLayout(context);
        BM_Layout.setOrientation(LinearLayout.HORIZONTAL);
        BM_Layout.setGravity(Gravity.CENTER);
        BM_Layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        ImageView imageView = new ImageView(context);
        imageView.setTag("image");
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) dp2px(context,30f),(int) dp2px(context,30f)));

        TextView tv = new TextView(context);
        tv.setTextSize(13);
        tv.setTextColor(Color.parseColor("#FFFEFEFE"));
        tv.setTag("text");
        tv.setPadding(25,0,25,0);

        BM_Layout.addView(imageView);
        BM_Layout.addView(tv);

            BM_ImageView = BM_Layout.findViewWithTag("image");
            BM_TextView =  BM_Layout.findViewWithTag("text");
            BM_TextView.setBackground(getBase64NinePatchDrawable("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAGG5wT2wCAAAAAAAAAAAAAAAAAAAAQYLaQeYAAAAAv7tmAAAAPG5wVGMAAgIDIAAAACgAAAAAAAAXAAAADwAAAAsAAAALMAAAAAAAAB8AAAAkAAAAAAAAADwAAAAB5gAAAAAAAAF3ntyjAAACAElEQVRo3u3bsWsTURwH8E9aGgexQzsogW5COim4CBKUDnVRWvwTHDq7ODqpi+Cig6KbYHUQwQjOImQRpINbQBwM1qkdIlksgsMlcASbXNIS7t6975bjOPjwfneXe+/9Ko6eGm6ggTqWUDW79PALP9HCe3QOO7lyROgdXMOCfOUd7mP3uMDreIKT8psebqOZPjg/xYW28GjGZTtNqriOLnamBW/ioWJlDd/QnrSka/iU8zIeVd5XsDvJCD/AOcVMFafxIesIr+Cz4ufiXMYTN4SRjazgRiDgRlZwPRBwPSt4KRDwclZwNRDwwpySJYIjOIIjOIIjOILzDb4XErgy5u/k44A+DUeCF/FMMi0idHANL7Ea4j08DF7FK5wpw0PrkmTGPlhsGrzZH9nFMryWtvA0oI/8seCuZKK6FBk8tM7ieahP5nQGKw/7eI1TuFAGMPzFR8nC02WcKMN7eJCVfomfD3mE0+niTYglnmUxbR0vygTmP3sl4gRABEdwBEdwBEdwBEdwBE8H/hOI9yAreD8Q8F5WcDsQcDsruBUIuBU3lx6SjqGt9AVME524QXxEfuOHpI+gaLmFL0ze89CWTPCtFQh7F9uDH9N0tezgK67K93pUrz+y2+mD81Ne7DveSvoI8rg808TNQRmnUzmGiw+34i2bbafaAfb6t9vYVrx/msNPM376M/gAAAAASUVORK5CYII="));
            BM_TextView.setTextSize((float) ((int) dp2px(context, 4.4f)));
            BM_TextView.setGravity(Gravity.CENTER);
            BM_TextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        if (z) {
            BM_ImageView.setImageDrawable(getBase64Image("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAGG5wT2wCAAAAAAAAAAAAAAAAAAAAQYLaQeYAAAAAv7tmAAAAPG5wVGMAAgIDIAAAACgAAAAAAAAXAAAADwAAAAsAAAALMAAAAAAAAB8AAAAkAAAAAAAAADwAAAAB5gAAAAAAAAF3ntyjAAACAElEQVRo3u3bsWsTURwH8E9aGgexQzsogW5COim4CBKUDnVRWvwTHDq7ODqpi+Cig6KbYHUQwQjOImQRpINbQBwM1qkdIlksgsMlcASbXNIS7t6975bjOPjwfneXe+/9Ko6eGm6ggTqWUDW79PALP9HCe3QOO7lyROgdXMOCfOUd7mP3uMDreIKT8psebqOZPjg/xYW28GjGZTtNqriOLnamBW/ioWJlDd/QnrSka/iU8zIeVd5XsDvJCD/AOcVMFafxIesIr+Cz4ufiXMYTN4SRjazgRiDgRlZwPRBwPSt4KRDwclZwNRDwwpySJYIjOIIjOIIjOILzDb4XErgy5u/k44A+DUeCF/FMMi0idHANL7Ea4j08DF7FK5wpw0PrkmTGPlhsGrzZH9nFMryWtvA0oI/8seCuZKK6FBk8tM7ieahP5nQGKw/7eI1TuFAGMPzFR8nC02WcKMN7eJCVfomfD3mE0+niTYglnmUxbR0vygTmP3sl4gRABEdwBEdwBEdwBEdwBE8H/hOI9yAreD8Q8F5WcDsQcDsruBUIuBU3lx6SjqGt9AVME524QXxEfuOHpI+gaLmFL0ze89CWTPCtFQh7F9uDH9N0tezgK67K93pUrz+y2+mD81Ne7DveSvoI8rg808TNQRmnUzmGiw+34i2bbafaAfb6t9vYVrx/msNPM376M/gAAAAASUVORK5CYII="));
        } else {
            BM_ImageView.setImageDrawable(getBase64Image("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAk1BMVEUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACKqXIEBgSHpW+DoW1uh1swOyccIheAnWp7mGZ0jmBrglhTZUQkLB15lGRXakdGVjomLh8WGxISFg9DUjc4RS4tOCYqMyJ9mWdccUxOYEA/TTQ8SjIzPypogFYMDwrOFJ7rAAAAEXRSTlMAHvvzd+Sn+bm4cFf4WU7Xpf5WFuwAAAFnSURBVEjH7ZfnasMwFEblGTtJhyzHe+/M9v2frvFQsVxQLIlCCzk/P+7BFleCe8GEpBraHq5AeTNVCcyRdBkyIOsz/VWBjCgv2N3KkJ3t6O4gF7vhvAqfrPTnfoec6ABIMq8sS0CF3KjA5JdNoPHLGtjzyxsABXjKorJbXzz4E+9Su49kL7TuxHBJ1sehR5Ura+S8qIrH2K5o8smaKMn/wXFGk31cdSXiGsdHmnzAVTkR5zg+0OQQV3VkB3Ds0OTbVJSSReg45S21VdlQ45fLLo/niR9cEjcKgriCS8o4CD7cP3y3nzK/XHU3t/jkkdE1Gt/CKWGWu9T6JkNscmPNcRCLXFgkEYOM/N6w/dAJfXuwm/VyM7hO3hZt7gyvMUCrZad3o6QXUBIN3y5Wy+d7dYo7lKR9w8r/cz1/VxYaaMRGKYNfNoXGR7HBFei8si40rIusCSILiuBqJL6U4XVws+pOaoaK1S+gCuu4pj4rYQAAAABJRU5ErkJggg=="));
        }
        BM_Toast = new Toast(context);
        BM_Toast.setView(BM_Layout);
        BM_Toast.setGravity(Gravity.CENTER|Gravity.BOTTOM, 0, (int) dp2px(context, 58.0f));
        BM_TextView.setText(str);
        BM_Toast.show();

    }

    public static Drawable getBase64Image(String str) {

        byte[] decode = Base64.encode(str.getBytes(), 0);

        return new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
    }

    public static NinePatchDrawable getBase64NinePatchDrawable(String str) {
        byte[] decode = Base64.decode(str, 0);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
        return new NinePatchDrawable(decodeByteArray, decodeByteArray.getNinePatchChunk(), new Rect(), (String) null);
    }


    public static float dp2px(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

}
