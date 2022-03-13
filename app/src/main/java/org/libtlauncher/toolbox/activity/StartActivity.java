package org.libtlauncher.toolbox.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.control.PrinterTextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StartActivity extends AppCompatActivity {
    private final Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        PrinterTextView TV = findViewById(R.id.PrintView);

        TV.setPrintText("Welcome To use BlockLauncher[CN]");
        TV.startPrint();

        getWindow().setStatusBarColor(0xFFFFFFFF);

        String url = ctx.getFilesDir()+"/cache";
        File file = new File(url);

        if(file.exists()) {
            Intent it = new Intent(this,MainActivity.class);
            startActivity(it);
            StopActivity();
        }else {
            try {
                FileOutputStream os = openFileOutput("cache", MODE_PRIVATE);
                // os.write("".getBytes());
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            TV.SetOnPrintDoneListener(new PrinterTextView.OnPrintDoneListener() {
                @Override
                public void OnPrintDone() {
                    Intent it = new Intent(ctx,MainActivity.class);
                    startActivity(it);
                    overridePendingTransition(R.anim.fade_out,R.anim.fade_in);
                    StopActivity();
                }
            });
        }

    }

    public void StopActivity(){
        this.finish();
    }



}
