package org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.widget.Toast;

import org.json.JSONObject;
import org.libtlauncher.toolbox.BuildConfig;
import org.libtlauncher.toolbox.Utils.pluginUtil.About_app;
import org.libtlauncher.toolbox.debug.LOG;
import org.libtlauncher.toolbox.xposed.info.publicInfo;
import org.libtlauncher.toolbox.control.HtmlText;

import cn.bmob.v3.AsyncCustomEndpoints;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobInstallationManager;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.InstallationListener;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.CloudCodeListener;
import cn.bmob.v3.listener.QueryListener;

import static org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APPLoader.JsInitLoader;

public class readNotice {
    public static String returnString;
    public static String updateAt;
    public static String version;

    public static boolean isCanUse(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo[] info = cm.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void update(Activity act,String version,String uri){
        if(version == null){
            act.finish();
        }
        if (!BuildConfig.VERSION_NAME.equals(version) && !readInfo.version.equals(version)) {
                Toast.makeText(act, "有新版本:" + version, 0).show();
                if(!uri.equals("无")){
                Intent intent= new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(uri);
                intent.setData(content_url);
                act.startActivity(intent);
            }
                act.finish();
        }

    }
    public static String read(final Activity act){
        Bmob.resetDomain("http://sdk.shengapi.cn/8/");
        Bmob.initialize(act, publicInfo.InfoKey,"android");

        if(!isCanUse(act)) act.finish();

        final About_app a = new About_app();
        BmobQuery<About_app> bmobQuery = new BmobQuery<About_app>();


        bmobQuery.getObject("gICtTTTd", new QueryListener<About_app>() {
            @Override
            public void done(About_app object,BmobException e) {
                if(e==null){
                    returnString = object.getNotice();
                    updateAt = object.getUpdatedAt();
                    version = object.getVersion();
                    readInfo.hpk = object.getHpk();
                    JsInitLoader(act, object.getHpk(),false);
                    update(act,object.getVersion(),object.getUpdateUrl());
                }else{
                    LOG.LOGD(LOG.LOG_Debug,e.getMessage());
                }
            }
        });
        if (returnString != null && updateAt != null) {
             return  "更新时间:"+updateAt+"\n"+ HtmlText.parse(returnString);
        }else{
            return  "点击我更新公告";
        }
    }
}
