package org.libtlauncher.toolbox.activity;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.libtlauncher.toolbox.R;

import org.libtlauncher.toolbox.Utils.pluginUtil.getContext;
import org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.readInfo;
import org.libtlauncher.toolbox.xposed.info.publicInfo;
import org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.readNotice;
import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.LauncherInfo;
import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.Login;
import org.OriginBox.Minecraft.openMC;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import xyz.hasnat.sweettoast.SweetToast;

import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.JsInitLoader;
import static org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.Login.checkLocalUser;

public class MainActivity extends AppCompatActivity{

    public static String JsPath;

    boolean isUpdate = false;
    boolean updateThread = true;

    private static double DOUBLE_CLICK_TIME = 10L;

    public static TextView Debug;

    private boolean APP_DEBUG = false;

    public boolean hpkLoader;

    public static Context ctx;

    private boolean start;

    public static Handler rec_log;

    private LinearLayout setBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(0xFFFFFFFF);

        requestPermission();

        ctx = this;
        getContext.APP_ACT = this;


        if(checkLocalUser(ctx) && publicInfo.checkIsAutoLogin(this)){
            Login login = new Login(this);
            login.userLogin(Login.getUserID(this),Login.getUserPassword(this),false,this);
        }


         Debug = findViewById(R.id.debug);

        TextView Title = findViewById(R.id.title2);


        setBut = findViewById(R.id.settingView);

        TextView notice = findViewById(R.id.NoticeView);
        LinearLayout funcLayout = findViewById(R.id.funcLayout);

        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr,"font/Sans.ttf");
        Title.setTypeface(tf);
        //xpb.setTypeface(tf);
       // Hbutton.setTypeface(tf);
        //Notice.setTypeface(tf);

        updateNotice(notice);




     // LinearLayout layout1=findViewById(R.id.item_switch1);
     // Switch layout_switch1=layout1.findViewById(R.id.switch_widget);
     //
     // layout_switch1.setChecked(new File(System.getenv("EXTERNAL_STORAGE")+"/hasEncode.cache").exists());
     // layout_switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
     //     @Override
     //     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
     //
     //         AlphaAnimation appearAnimation = new AlphaAnimation(0, 1);
     //         appearAnimation.setDuration(500);
     //
     //         AlphaAnimation disappearAnimation = new AlphaAnimation(1, 0);
     //         disappearAnimation.setDuration(500);
     //         if (!isChecked) {
     //             new File(System.getenv("EXTERNAL_STORAGE") + "/hasEncode.cache").delete();
     //         } else {
     //             try {
     //                 LOG.addTxtToFileWrite(new File(System.getenv("EXTERNAL_STORAGE") + "/hasEncode.cache"), "a");
     //             } catch (IOException e) {
     //                 e.printStackTrace();
     //             }
     //         }
     //     }
     // });
        ctx = this;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SweetToast.info(this,"Good Bye Sir~");
    }




    public static String readInStream(FileInputStream inStream){
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = -1;
            while((length = inStream.read(buffer)) != -1 ){
                outStream.write(buffer, 0, length);
            }
            outStream.close();
            inStream.close();
            return outStream.toString();
        } catch (Exception e) {
            Log.i("FileTest", e.getMessage());
        }
        return null;
    }


    public void onRadioButtonClicked(View view) {
        RadioButton button = (RadioButton) view;
        boolean isChecked = button.isChecked();
        switch (view.getId()) {
            case R.id.inGame:
                if (isChecked) {
                    LauncherInfo.LoaderMode = 1;
                }
                break;
                /*
            case R.id.inWorld:
                if (isChecked) {
                    LauncherInfo.LoaderMode = 2;
                }
                break;*/
            case R.id.inOriginBox:
                if (isChecked) {
                    LauncherInfo.LoaderMode = 4;
                }
                break;
            case R.id.inRN:
                if (isChecked) {
                    LauncherInfo.LoaderMode = 3;
                }
                break;
            default:
                break;
        }
    }


    public void IntentToAbout(View v){
        Intent it = new Intent(this,AboutActivity.class);
        startActivity(it);
    }

    public void IntentToPlugin(View v){
        Intent it = new Intent(this,PluginActivity.class);
        startActivity(it);
    }

    public void IntentToDebug(View v){
        Intent it = new Intent(this,DebugActivity.class);
        startActivity(it);
    }

    public void updateNotice(View v){
       TextView tv = (TextView)v;
       tv.setText(String.format("\n%s", readNotice.read((Activity) ctx)));
        if(readInfo.hpk!=null) {
          JsInitLoader(v.getContext(), readInfo.hpk,false);
        }
    }

    public void test(View v){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //intent.setDataAndType(Uri.fromFile(dir.getParentFile()), "file/*.txt");
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            startActivityForResult(Intent.createChooser(intent, "请选择文件"), 1);
        }catch (Exception err){
            SweetToast.error(ctx,"请安装文件管理器");
        }

    }

    public void debugger(View v){
            Intent it = new Intent(this, DebugLoggerActivity.class);
            startActivity(it);
    }

    public void IntentToUser(View v){
        Intent it = new Intent(this, UserActivity.class);
        startActivity(it);
    }



    public void requestPermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,

                    Manifest.permission.READ_EXTERNAL_STORAGE,

            }, 100);


        }
    }

    public void Linser(View v){
        LinearLayout LL= findViewById(R.id.devtools);

        AlphaAnimation appearAnimation = new AlphaAnimation(0, 1);
        appearAnimation.setDuration(500);

        if(!APP_DEBUG) {
            if ((System.currentTimeMillis() - DOUBLE_CLICK_TIME) > 500) {//这里测试1500ms比较合适
                DOUBLE_CLICK_TIME = System.currentTimeMillis();
                System.out.println("OnClick");
                APP_DEBUG = true;
                SweetToast.success(this, "双击了这里");
                LL.startAnimation(appearAnimation);
            }
        }else {
            SweetToast.success(this,"DevMode is open");
        }
    }
    private boolean view_clo = false;
    public void closeSet(final View v){

        if(!view_clo) {
            view_clo = true;

            setBut.animate()
                    .alpha(0f)
                    .setDuration(500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            setBut.animate()
                        .setInterpolator(new AccelerateDecelerateInterpolator(){
                                @Override
                                public float getInterpolation(float input) {
                                    return super.getInterpolation(input);
                                }
                            });
                            setBut.setVisibility(View.GONE);
                            final TextView v1 = (TextView) v;
                            v1.animate()
                                    .alpha(0f)
                                    .setDuration(500)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            v1.animate()
                                                    .alpha(1f)
                                                    .setDuration(500)
                                                    .setListener(new AnimatorListenerAdapter() {
                                                        @Override
                                                        public void onAnimationStart(Animator animation) {
                                                            v1.setText(v1.getText() + " - 已折叠,再次点击以展开");
                                                        }
                                                    });
                                        }
                                    });

                        }
                    });
        }else{
            view_clo = false;
            setBut.animate()
                    .alpha(1f)
                    .setDuration(500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            setBut.setVisibility(View.VISIBLE);
                            final TextView v1 = (TextView) v;
                            v1.animate()
                                    .alpha(0f)
                                    .setDuration(500)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            v1.animate()
                                                    .alpha(1f)
                                                    .setDuration(500)
                                                    .setListener(new AnimatorListenerAdapter() {
                                                        @Override
                                                        public void onAnimationStart(Animator animation) {
                                                            v1.setText("设置");
                                                        }
                                                    });
                                        }
                                    });

                        }
                    });
        }

        //setBut.setVisibility(View.GONE);
    }


    public static void checkAdmin(){
        if(LauncherInfo.UserLevel.equals("ADMIN")){
            Debug.setVisibility(View.VISIBLE);
        }
    }

    public void startGame(final View v) {
        openMC SE = new openMC(this,start,v);
        }
}

