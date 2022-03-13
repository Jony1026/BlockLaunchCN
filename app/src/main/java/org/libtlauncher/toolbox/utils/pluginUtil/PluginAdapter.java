package org.libtlauncher.toolbox.Utils.pluginUtil;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.bumptech.glide.Glide;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.Utils.pluginUtil.base.RecyclerBaseAdapter;
import org.libtlauncher.toolbox.Utils.pluginUtil.base.ViewHolder;
import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.LauncherInfo;

import java.util.List;

import xyz.hasnat.sweettoast.SweetToast;


public class PluginAdapter<T> extends RecyclerBaseAdapter {



    public PluginAdapter(Context context,int layoutId,List list){
        super(context,layoutId);
        this.items=list;
    }

    @Override
    public void convert(ViewHolder holder, Object bean, int viewType) {
        final T_Plugin data=(T_Plugin)bean;
        ImageView cover=holder.getView(R.id.imageView);
        Glide.with(cover.getContext())
                .load(data.getPluginCover())
                .into(cover);

        VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(context.getResources(),R.drawable.ic_star_yellow,context.getTheme());
        vectorDrawableCompat.setTint(Color.parseColor("#FFFF972E"));

        ImageView rank_View = holder.getView(R.id.rank_icon);
        rank_View.setImageDrawable(vectorDrawableCompat);

        final String PluginID = data.getPluginId();

        TextView title=holder.getView(R.id.pluginTitle);
        title.setText(data.getPluginTitle());

        TextView rank=holder.getView(R.id.rankText);
        rank.setText(data.getPluginRanking());

        TextView desc=holder.getView(R.id.plugin_desc);
        desc.setText(data.getPluginDesc());

        final Button buy=holder.getView(R.id.pluginBuy);

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(25.0f);
       buy.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFF972E")));
        buy.setBackground(gradientDrawable);

        if( LauncherInfo.UserHasPlugin.contains(PluginID)){
            GradientDrawable down_gradientDrawable = new GradientDrawable();
            down_gradientDrawable.setCornerRadius(25.0f);
            buy.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF855DFF")));
            buy.setBackground(down_gradientDrawable);

            buy.setTag("down_t");

            vectorDrawableCompat.setTint(Color.parseColor("#FF855DFF"));
            rank_View.setImageDrawable(vectorDrawableCompat);
            rank.setTextColor(Color.parseColor("#FF855DFF"));

            buy.setText("下载");

        }

            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(LauncherInfo.UserHasPlugin.contains(PluginID)){
                        SweetToast.success(context,"开始下载js......");
                    }else
                    if(data.getPluginQGroupKey() != null) {
                        IntentQQ(data.getPluginQGroupKey());
                        SweetToast.info(view.getContext(),"即将跳转至"+data.getPluginTitle()+"的购买界面");
                    } else {
                        SweetToast.info(view.getContext(), "该插件未设置跳转");
                    }
                }
            });

    }


    public void IntentQQ(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D" + key));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            SweetToast.error(context,"版本不支持或者您尚未安装QQ");
        }
    }

}
