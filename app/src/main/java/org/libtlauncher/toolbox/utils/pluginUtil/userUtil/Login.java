package org.libtlauncher.toolbox.Utils.pluginUtil.userUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.Toast;

import org.json.JSONObject;
import org.libtlauncher.toolbox.activity.UserActivity;
import org.libtlauncher.toolbox.debug.LOG;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.pedant.SweetAlert.SweetAlertDialog;
import xyz.hasnat.sweettoast.SweetToast;

import static android.content.Context.MODE_PRIVATE;

public class Login {
    private final Activity LoginAct;
    public Login(Activity act){
        LoginAct = act;
    }

    public void putInfo(String id,String pass){
        SharedPreferences sp = LoginAct.getSharedPreferences("BlockLauncherInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userID",id);
        editor.putString("userPassword",pass);
        boolean commit = editor.commit();
        LOG.LOGD(LOG.LOG_Java,"sp:"+commit);
    }

    public static boolean checkLocalUser(Context ctx){
        SharedPreferences sp = ctx.getSharedPreferences("BlockLauncherInfo",MODE_PRIVATE);
        if(sp.getString("userID", "none").equals("none") && sp.getString("userPassword", "none").equals("none")){
            return false;
        }else{
            LOG.LOGD("BlockLauncher",sp.getString("userID", "none"));
            return true;
        }
    }

    public static String getUserID(Context ctx){
        SharedPreferences sp = ctx.getSharedPreferences("BlockLauncherInfo",MODE_PRIVATE);
        return sp.getString("userID", "none");
    }

    public static String getUserPassword(Context ctx){
        SharedPreferences sp = ctx.getSharedPreferences("BlockLauncherInfo",MODE_PRIVATE);
        return sp.getString("userPassword", "none");
    }

    public void userLogin(final String id, final String pass, final boolean isFinish, final Context ctx){
        final Promise am = new Promise();
        am.setUsername(id);
        am.setPassword(pass);

        SweetToast.info(LoginAct,"正在链接服务器 请留在此界面");

        am.login(new SaveListener<Promise>() {
            @Override
            public void done(final Promise bmobUser, BmobException e) {
                if(e == null){
                    Toast.makeText(ctx,am.isBan()+"",0).show();
                    if(bmobUser.isBan()){
                        try {
                            JSONObject ban = new JSONObject(bmobUser.getBan());
                            String banTime = ban.getString("ban");
                            String unbanTime = ban.getString("unban");
                            String reason = ban.getString("reason");
                            String op = ban.getString("op");
                            new SweetAlertDialog(ctx, SweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("您已被封号")
                                    .setContentText("封号时间:"+banTime+"\n"+"解封时间:"+unbanTime+"\n"+"封号原因:"+reason+"\n"+"操作员:"+op)
                                    .setConfirmText("确定")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            Activity act = (Activity) ctx;
                                            act.finish();
                                            Uri uri = Uri.fromParts("package", "org.libtlauncher.toolbox", null);
                                            Intent intent = new Intent(Intent.ACTION_DELETE, uri);
                                            act.startActivity(intent);
                                        }
                                    }).show();
                        } catch (Exception jsonException) {
                            LOG.LOGD(LOG.LOG_Debug,jsonException.getMessage());
                        }

                    }else {
                        String tag = bmobUser.getUserTag();
                        String name = bmobUser.getUsername();
                        String qq = bmobUser.getUserQQ();
                        String email = bmobUser.getEmail();
                        String actor = bmobUser.getUserActor();
                        String level = bmobUser.getUserLevel();
                        String hasPlugin = bmobUser.getUserHasPlugin();
                        String hasLoaderMode = bmobUser.getUserHasLoaderMode();

                        LauncherInfo.UserID = id;
                        LauncherInfo.UserPass = pass;

                        putInfo(name, pass);

                        LauncherInfo.Tag = tag;
                        LauncherInfo.UserName = name;
                        LauncherInfo.UserEmail = email;
                        LauncherInfo.UserActor = actor;
                        LauncherInfo.UserLevel = level;
                        LauncherInfo.UserHasPlugin = hasPlugin;
                        LauncherInfo.UserHasLoaderMode = hasLoaderMode;
                        if (qq != null) LauncherInfo.UserQQ = qq;
                        else LauncherInfo.UserQQ = "未统计";

                        if (bmobUser.getEmailVerified()) {
                            LauncherInfo.isLoginUser = true;
                            if (isFinish) {
                                LoginAct.finish();
                            }
                            Intent it = new Intent(LoginAct, UserActivity.class);
                            LoginAct.startActivity(it);
                            Toast.makeText(UserActivity.activity, "登录成功 欢迎 @" + name, 0).show();
                        } else {
                            Toast.makeText(LoginAct, "该账号未通过邮箱验证...请检查邮箱", 0).show();
                        }
                    }
                }else{
                    if(e.getErrorCode() == 101){
                        Toast.makeText(LoginAct,"账号或密码错误或不存在",0).show();
                        return;
                    }
                    LOG.LOGD("BMOB",e.getMessage()+" , "+bmobUser);
                    Toast.makeText(LoginAct,"请发送给developer(售后群群主):"+e.getMessage()+",错误代码:"+e.getErrorCode(),0).show();
                }
            }
        });
    }

    public void userRegister(String id,String pass,String email){
        Promise am = new Promise();
        am.setUsername(id);
        am.setPassword(pass);
        am.setEmail(email);
        am.setBan("{\"ban\":\"00:00:00\",\"unban\":\"00:00:00\",\"reason\":\"\",\"op\":\"\"}");
        am.setUserActor("淡水鱼");
        am.setBan(false);
        am.setUserHasLoaderMode("{\"1\":false,\"2\":false,\"3\":false}");
        am.setUserLevel("Lv1");
        am.setUserTag("萌新");

        am.signUp(new SaveListener<Promise>() {
            @Override
            public void done(Promise bmobUser, BmobException e) {
                if(e == null){
                    Toast.makeText(LoginAct,"注册成功 请留意邮件以激活您的 Block 账户！",0).show();
                }else{
                    if(e.getErrorCode() == 301){
                        Toast.makeText(LoginAct,"注册失败:请输入一个正确的邮箱",0).show();
                        return;
                    }else if(e.getErrorCode() == 138){
                        Toast.makeText(LoginAct,"注册失败:目前未开启注册通道",0).show();
                        return;
                    }
                    LOG.LOGD("BMOB",e.getMessage()+" , "+bmobUser);
                    Toast.makeText(LoginAct,"注册失败 请根据报错判定原因"+e.getMessage()+e.getErrorCode(),0).show();
                }
            }
        });
    }
}
