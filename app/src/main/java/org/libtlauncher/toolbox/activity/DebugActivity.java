package org.libtlauncher.toolbox.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.Utils.pluginUtil.checkAdmin;
import org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.readInfo;
import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.LauncherInfo;

import xyz.hasnat.sweettoast.SweetToast;

import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.JsInitLoader;


public class DebugActivity extends AppCompatActivity {
    private final Context context = this;
    private EditText jsPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JsInitLoader(this, readInfo.hpk,false);
        setContentView(R.layout.activity_debugger);
        getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
        jsPath = findViewById(R.id.jsPath);
        LinearLayout ll = findViewById(R.id.item_switch);
        checkAdmin.check(ll,R.id.switch_widget,this);
    }

    public void saveJsPath(View v){

        LinearLayout ll = findViewById(R.id.item_switch);
        if(jsPath.getText().toString() != null && !jsPath.getText().toString().equals("") && checkAdmin.check(ll,R.id.switch_widget,this)) {
            SweetToast.success(v.getContext(), "保存路径:" + jsPath.getText().toString());
            LauncherInfo.JsPath = jsPath.getText().toString();
        }else{
            SweetToast.error(v.getContext(),"该路径未空...");
        }
    }

    public void BackActivity(View v){
       this.finish();
    }

}
