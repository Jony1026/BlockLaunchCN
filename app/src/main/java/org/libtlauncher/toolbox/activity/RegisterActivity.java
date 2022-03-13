package org.libtlauncher.toolbox.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.readInfo;
import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.Login;

import xyz.hasnat.sweettoast.SweetToast;

import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.JsInitLoader;

public class RegisterActivity extends AppCompatActivity {

    private Activity ctx = null;

    private EditText email
   ,user
   ,pass
   ,samePass;

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);

        ctx = this;
        JsInitLoader(this, readInfo.hpk,false);

        getWindow().setStatusBarColor(0xFFFFFFFF);

        this.setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);

        user = findViewById(R.id.user);

        pass = findViewById(R.id.password);

        samePass = findViewById(R.id.samePass);

    }

    public void IntentToLogin(View v){
        this.finish();
        Intent it = new Intent(this,UserActivity.class);
        this.startActivity(it);
    }

    public void register(View v) {
        Login l = new Login(ctx);
        if(pass.getText().toString().equals(samePass.getText().toString())) {
            l.userRegister(user.getText().toString(), pass.getText().toString(), email.getText().toString());
        }else{
            SweetToast.error(ctx,"两次密码输入不相同！");
        }
    }

    public Object getEditText(EditText ev,String mode){
        return ev.getText().toString();
    }

    public void BackActivity(View v) {
        this.finish();
    }
}
