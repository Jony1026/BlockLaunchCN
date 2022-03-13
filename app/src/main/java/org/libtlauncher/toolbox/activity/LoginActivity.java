package org.libtlauncher.toolbox.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.readInfo;
import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.Login;


import xyz.hasnat.sweettoast.SweetToast;

import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.JsInitLoader;

public class LoginActivity extends AppCompatActivity {

    private Activity ctx = null;

    @Override
    protected void onCreate(@Nullable Bundle bundle){
        super.onCreate(bundle);

        ctx = this;

        JsInitLoader(this, readInfo.hpk,false);

        getWindow().setStatusBarColor(0xFFFFFFFF);

            this.setContentView(R.layout.activity_login);

            AssetManager mgr = getAssets();
            Typeface tf = Typeface.createFromAsset(mgr, "font/Gotham Bold.otf");

        final EditText userNum = findViewById(R.id.userNum);

        final EditText userPass = findViewById(R.id.userPass);

        final TextView LoginButton = findViewById(R.id.LoginButton);

        final Login login = new Login(ctx);

        if(Login.checkLocalUser(ctx)){
            userNum.setText(Login.getUserID(ctx));
            userPass.setText(Login.getUserPassword(ctx));
        }


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    final String User = String.valueOf(userNum.getText());
                    final String Pass = String.valueOf(userPass.getText());

                    login.userLogin(User,Pass,true,ctx);

                } catch (Exception err) {
                    //登陆失败 比如服务器繁忙， 密码错误
                    SweetToast.error(ctx, err.getMessage());
                    err.printStackTrace();
                }
            }//?
        });


    }

    public void IntentToRegister(View v){
        this.finish();
        Intent it = new Intent(this,RegisterActivity.class);
        this.startActivity(it);
    }

    public void BackActivity(View v) {
        this.finish();
    }
}
