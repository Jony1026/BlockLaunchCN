package org.libtlauncher.toolbox.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.libtlauncher.toolbox.R;
import org.libtlauncher.toolbox.control.DownloadAnimation;

public class UpdateActivity extends AppCompatActivity {

    private boolean isNaN = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        TextView updateText = findViewById(R.id.Download_text);

        final DownloadAnimation dw = findViewById(R.id.arrow_download_button);

        dw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        getWindow().setStatusBarColor(0xFFFFFFFF);
    }

    public void BackActivity(View v) {
        this.finish();
    }

}

