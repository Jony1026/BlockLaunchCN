package org.libtlauncher.toolbox.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.LauncherInfo;

import cn.pedant.SweetAlert.SweetAlertDialog;
import xyz.hasnat.sweettoast.SweetToast;

public class UserActivity extends AppCompatActivity {


    private TextView email;
    public static Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle bundle){
        super.onCreate(bundle);

        getWindow().setStatusBarColor(0xFFFFFFFF);

            this.setContentView(R.layout.activity_user);

            activity = this;

            email = findViewById(R.id.email);

            TextView userNick = findViewById(R.id.userNick);

            TextView tags = findViewById(R.id.tags);

            TextView actor = findViewById(R.id.userActor);

            TextView level = findViewById(R.id.level);

            TextView count = findViewById(R.id.hasPluginCount);

            ImageView userHead = findViewById(R.id.userImage);
            if(LauncherInfo.UserQQ != "未统计") {
                Glide.with(userHead.getContext())
                        .load("https://q1.qlogo.cn/g?b=qq&nk=" + LauncherInfo.UserQQ + "&s=640")
                        .into(userHead);
            }

              level.setText(LauncherInfo.UserLevel);

            userNick.setText(LauncherInfo.UserName);

            email.setText(LauncherInfo.UserEmail);

            tags.setText(LauncherInfo.Tag);

            actor.setText(LauncherInfo.UserActor);

            count.setTextSize(12);

        if(strCount(LauncherInfo.UserHasLoaderMode,"true") == 3){
            count.setText("太棒了!您已经激活三种加载模式 小白见了都叫您大佬呢!");
        }else if(strCount(LauncherInfo.UserHasLoaderMode,"true") == 2){
            count.setText("阿哲...您激活了两种操作模式 已经很棒了呢！");
        }else if(strCount(LauncherInfo.UserHasLoaderMode,"true") == 1){
            count.setText("您是怎么做到只激活一种操作模式的!!!!?教教我！！");
        }else if(!LauncherInfo.UserHasLoaderMode.contains("true")){
            count.setText("这里空空的...您未激活加载模式呀..");
        }

           AssetManager mgr = getAssets();
            Typeface tf = Typeface.createFromAsset(mgr, "font/Gotham Bold.otf");
            email.setTypeface(tf);
            userNick.setTypeface(tf);


            if(!LauncherInfo.isLoginUser){SweetToast.error(this, "嘶~您还未登录......");this.finish();this.startActivity(new Intent(this, LoginActivity.class));}
    }

    public void checkAdmin(View v){
        MainActivity.checkAdmin();
    }

    public static int strCount(String a, String b) {
        int a_length = a.length();
        int b_length = b.length();
        int c = a.replaceAll(b, "").length();
       return (a_length - c) / b_length;
    }

    public void exitLogin(View v){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("你确定吗?")
                .setContentText("真的要退出登录吗？")
                .setConfirmText("确定")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        LauncherInfo.setAllNull();
                        sDialog.setTitleText("Message")
                                .setContentText("退出成功")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        activity.finish();
                                    }
                                })
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                }).show();
    }

    public void copyUserID(View v){
        copy(email.getText().toString());
        SweetToast.success(v.getContext(),"复制成功！！");
    }

    private void copy(String data) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText(null, data);
        clipboard.setPrimaryClip(clipData);
    }

    public void BackActivity(View v) {
        this.finish();
    }

}
