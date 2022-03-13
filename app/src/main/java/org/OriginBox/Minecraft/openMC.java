package org.OriginBox.Minecraft;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONObject;
import org.libtlauncher.toolbox.activity.UserActivity;
import org.libtlauncher.toolbox.debug.LOG;
import org.libtlauncher.toolbox.xposed.info.NeteaseInfo;
import org.libtlauncher.toolbox.Utils.pluginUtil.userUtil.LauncherInfo;

import xyz.hasnat.sweettoast.SweetToast;

public class openMC {
    private static boolean start ;
    public openMC(final Activity ctx, boolean start_a, final View v){
            //待加固
           start = start_a;
            start = false;
            if (LauncherInfo.isLoginUser) {
                Snackbar.make(v, "即将启动我的世界 您可以点击取消来取消", Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.parseColor("#FFFF855D"))
                        .setAction("取消", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        start = true;
                                        SweetToast.success(ctx, "已取消");
                                    }
                                }

                        ).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!start) {
                            try {
                                if(LauncherInfo.UserHasLoaderMode == null || LauncherInfo.UserHasLoaderMode.equals("")){
                                    Snackbar.make(v, "错误 无此使用权限", Snackbar.LENGTH_SHORT)
                                            .show();
                                    start = false;
                                    return;
                                }
                                JSONObject jsonObject = new JSONObject(LauncherInfo.UserHasLoaderMode);
                                Boolean mode1 = jsonObject.optBoolean("1");
                                Boolean mode2 = jsonObject.optBoolean("2");
                                Boolean mode3 = jsonObject.optBoolean("3");
                                if (LauncherInfo.LoaderMode == 1 && !mode1) {
                                    Snackbar.make(v, "错误 无此使用权限", Snackbar.LENGTH_SHORT)
                                            .show();
                                    start = false;
                                    return;
                                } else if (LauncherInfo.LoaderMode == 2 && !mode2) {
                                    Snackbar.make(v, "错误 无此使用权限", Snackbar.LENGTH_SHORT)
                                            .show();
                                    start = false;
                                    return;
                                } else if (LauncherInfo.LoaderMode == 3 && !mode3){
                                    Snackbar.make(v, "错误 无此使用权限", Snackbar.LENGTH_SHORT)
                                            .show();
                                start = false;
                                return;
                            }
                                start = false;
                                NeteaseInfo.AutoRunPlugin = true;
                                Intent a = new Intent();
                                a.setClassName("com.netease.x19", "com.mojang.minecraftpe.MainActivity");
                                JSONObject jo = new JSONObject();
                                JSONObject user = new JSONObject();
                                try {
                                    jo.put("JsPath", LauncherInfo.JsPath);
                                    jo.put("LoaderMode", LauncherInfo.LoaderMode);
                                    jo.put("isDebug",LauncherInfo.isLoaderDebug);

                                    user.put("name", LauncherInfo.UserName);
                                    user.put("qq", LauncherInfo.UserQQ);
                                    user.put("isLogin", LauncherInfo.isLoginUser);

                                    user.put("id",LauncherInfo.UserID);
                                    user.put("pass",LauncherInfo.UserPass);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                a.putExtra("loadInfo", jo.toString());
                                a.putExtra("0x0", "0x0x0x0x0");
                                a.putExtra("user", user.toString());
                                ctx.startActivity(a);
                            }catch (Exception err){
                                Snackbar.make(v, "错误 未找到我的世界", Snackbar.LENGTH_SHORT)
                                        .show();
                                LOG.LOGD(LOG.LOG_Debug,err.toString());
                            }
                        }

                    }
                }, 3000);
            } else {
                Snackbar.make(v, "你没有登录", Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.parseColor("#FFFF855D"))
                        .setAction("登录", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(ctx, UserActivity.class);
                                        ctx.startActivity(it);
                                    }
                                }

                        ).show();
            }
        }
    }
