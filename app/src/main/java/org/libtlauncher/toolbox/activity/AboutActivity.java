package org.libtlauncher.toolbox.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.libtlauncher.toolbox.R;

import xyz.hasnat.sweettoast.SweetToast;

public class AboutActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView Title = findViewById(R.id.titleqwq);

        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr,"font/Sans.ttf");
         Title.setTypeface(tf);

        getWindow().setStatusBarColor(0xFFFFFFFF);
    }

  public void BiliBili(View v){
      String url = "https://space.bilibili.com/405953892?share_medium=android&share_source=copy_link&bbid=XY534655BBC060B763645119F0B451657E75D&ts=1597662325452";
      Uri uri = Uri.parse(url);
      Intent intent = new Intent(Intent.ACTION_VIEW, uri);
      startActivity(intent);
      SweetToast.success(this,"请选择哔哩哔哩打开 若无表示您尚未安装哔哩哔哩");
  }

  public void BackActivity(View v){
        this.finish();
  }


    public void IntentQQ(View v) {
        String key = "vhUCCCSvyjv-q33kRx3GChQGtqOkjcDn";
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D" + key));
        try {
            startActivity(intent);
        } catch (Exception e) {
            SweetToast.error(this,"版本不支持或者您尚未安装QQ");
        }
    }

    public void Bin(View v){
        String url = "mqqwpa://im/chat?chat_type=wpa&uin=1956674550";//uin是发送过去的qq号码
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public void SemiLuo(View v){
        String url = "mqqwpa://im/chat?chat_type=wpa&uin=335357911";//uin是发送过去的qq号码
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public void XqHer(View v){
        String url = "mqqwpa://im/chat?chat_type=wpa&uin=1575157146";//uin是发送过去的qq号码
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

}