package org.libtlauncher.toolbox.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.readInfo;
import org.libtlauncher.toolbox.control.BordenButton;
import org.libtlauncher.toolbox.control.MIUIEdit;

import xyz.hasnat.sweettoast.SweetToast;

import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.CleanLoaderPath;
import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.JsInitLoader;
import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.isDEBUG;

public class DebugLoggerActivity extends AppCompatActivity {

    public static Context ctx;

    public static TextView tv;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = this;

        JsInitLoader(this, readInfo.hpk,false);

        setContentView(R.layout.activity_debugger_logger);

        tv = findViewById(R.id.TD_logger);

        final MIUIEdit code = findViewById(R.id.code);

        BordenButton runButton = findViewById(R.id.runbutton);

        getWindow().setStatusBarColor(0xFFFFFFFF);

        SweetToast.success(ctx,"Init Loader Enter Success!!!");

        isDEBUG(1);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String evalCode = String.valueOf(code.getText());
                JsInitLoader(ctx,evalCode,true);
            }
        });
    }

    public void BackActivity(View v) {
        //cleanLoader();
        CleanLoaderPath();
        this.finish();
    }

}

