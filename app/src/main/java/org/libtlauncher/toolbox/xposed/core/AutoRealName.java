package org.libtlauncher.toolbox.xposed.core;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import org.libtlauncher.toolbox.debug.LOG;
import org.libtlauncher.toolbox.xposed.info.FuncInfo;
import org.libtlauncher.toolbox.xposed.info.NeteaseInfo;
import org.libtlauncher.toolbox.Utils.RealNameUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findClass;

public class AutoRealName {
    private String[] realName = null;
    private Object realName_x$9 = null;
    private Object realName_x = null;
    private Object realName_m$a$2 = null;


    public AutoRealName(final XC_LoadPackage.LoadPackageParam loadPackageParam,ClassLoader classLoader){
        LOG.LOGD(LOG.LOG_Java,"自动实名初始化完成!");
        /*
         *自动实名(全自动)
         */
        try {
            //获取类
            final Class<?> x = findClass("com.netease.mpay.view.b.x", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","1 ok");
            Class<?> b = findClass("com.netease.mpay.view.b.x$b", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","2 ok");
            Class<?> a = findClass("com.netease.mpay.view.b.x$a", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","3 ok");
            final Class<?> x$9 = findClass("com.netease.mpay.view.b.x$9", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","4 ok");
            final Class<?> bv$b = findClass("com.netease.mpay.e.bv$b", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","5 ok");
            final Class<?> m$a$2 = findClass("com.netease.mpay.view.a.m$a$2", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","6 ok");
            final Class<?> m$a$1 = findClass("com.netease.mpay.view.a.m$a$1", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","7 ok");
            final Class<?> m$a = findClass("com.netease.mpay.view.a.m$a", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","8 ok");
            final Class<?> x$9$1 = findClass("com.netease.mpay.view.b.x$9$1", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","9 ok");
            final Class<?> w$3 = findClass("com.netease.mpay.view.b.w$3", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","10 ok");
            final Class<?> w = findClass("com.netease.mpay.view.b.w", classLoader);
            LOG.LOGD(" LOG.LOG_Debug","11 ok");
         //   final Class<?> MpayLoginActivity = findClass("com.netease.mpay.MpayLoginActivity",load.classLoader);
         //   final Class<?> m$1 = findClass("com.netease.mpay.m$1",load.classLoader);//网易校验类
         //   final Class<?> y$a = findClass("com.netease.mpay.y$a",load.classLoader);//网易校验类

            /*
            XposedHelpers.findAndHookMethod(MpayLoginActivity, "onCreate" , Bundle.class , new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    LOG.LOGD(LOG.LOG_Debug, "登录初始化");
                    Context LoginContext = (Context)param.thisObject;


                    NeteaseHook.callNeteaseSDK("showRealnameDialog");

                    LinearLayout LoginMinecraft = new LinearLayout(LoginContext);
                    EditText login = new EditText(LoginContext);

                    Toast.makeText(LoginContext,"testLoginCTXGet",0).show();

                }
            });

            XposedHelpers.findAndHookMethod(m$1, "a" , String.class , String.class , y$a,  new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    LOG.LOGD(LOG.LOG_Debug, "输入错误");
                    Context LoginContext = (Context)param.thisObject;

                    Toast.makeText(LoginContext,"这是一个小测试",0).show();

                }
            });
*/
            //自动实名
            XposedHelpers.findAndHookConstructor(x, Activity.class, b, a, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    LOG.LOGD(LOG.LOG_Debug, "实名初始化");
                    realName_x = param.thisObject;
                }
            });
            XposedHelpers.findAndHookConstructor(x$9, x, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    LOG.LOGD(LOG.LOG_Debug, "实名UI 构造函数");
                    realName_x$9 = param.thisObject;
                }
            });
            XposedHelpers.findAndHookConstructor(m$a$2, m$a, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    LOG.LOGD(LOG.LOG_Debug, "实名验证 构造函数");
                    realName_m$a$2 = param.thisObject;
                }
            });
            XposedHelpers.findAndHookConstructor(m$a$1, m$a, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    LOG.LOGD(LOG.LOG_Debug, "实名验证2 构造函数");
                    realName_m$a$2 = param.thisObject;
                }
            });
            XposedHelpers.findAndHookConstructor(w$3, w, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(final MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    LOG.LOGD(LOG.LOG_Debug, "实名提交 构造函数");
                    if (FuncInfo.isAutoRealName){
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {

                                    Method me = w$3.getDeclaredMethod("onClick", View.class);
                                    me.setAccessible(true);
                                    View v = new View(NeteaseInfo.MCContext);
                                    me.invoke(param.thisObject,v);
                                    LOG.LOGD(LOG.LOG_Debug, "身份信息提交完成!");
                                    reset();
                                } catch (Exception e) {
                                    LOG.LOGD(LOG.LOG_THROW, e.toString());
                                }
                            }
                        }, 250);//延迟5000毫秒 = 5秒
                    }
                }
            });
            XposedHelpers.findAndHookMethod(x, "d", new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            try {
                                if (FuncInfo.isAutoRealName){
                                    Field edit1 = x.getDeclaredField("h");
                                    Field edit2 = x.getDeclaredField("i");
                                    edit1.setAccessible(true);
                                    edit2.setAccessible(true);
                                    EditText editText1 = (EditText) edit1.get(realName_x);
                                    EditText editText2 = (EditText) edit2.get(realName_x);
                                    realName = RealNameUtil.getRealName();
                                    editText1.setText(realName[0]);
                                    editText2.setText(realName[1]);

                                    editText1.setBackgroundColor(Color.parseColor("#cccccc"));
                                    editText2.setBackgroundColor(Color.parseColor("#cccccc"));
                                    //等待后提交实名
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                //实例化对象

                                                Constructor ct = x$9$1.getDeclaredConstructor(x$9);
                                                ct.setAccessible(true);
                                                Object bv = ct.newInstance(realName_x$9);
                                                Method me = m$a$2.getDeclaredMethod("a", String.class, String.class, String.class, bv$b);
                                                me.setAccessible(true);
                                                me.invoke(realName_m$a$2, realName[0], realName[1], "86", bv);

                                            } catch (Exception e) {
                                                LOG.LOGD(LOG.LOG_THROW, e.toString());
                                            }
                                        }
                                    }, 250);//延迟1000毫秒 = 1秒
                                }
                            } catch (Exception e) {
                                LOG.LOGD(LOG.LOG_THROW, e.toString());
                            }
                        }
                    }
            );


            XposedHelpers.findAndHookMethod(x, "e", new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            try {
                                if (FuncInfo.isAutoRealName){
                                    Field txt = x.getDeclaredField("k");

                                    txt.setAccessible(true);

                                    EditText textV = (EditText) txt.get(realName_x);

                                    textV.setText("侧手");


                                }
                            } catch (Exception e) {
                                LOG.LOGD(LOG.LOG_THROW, e.toString());
                            }
                        }
                    }
            );
        }catch (Exception e){}


    }
    public void reset(){
        realName = null;
        realName_x$9 = null;
        realName_x = null;
        realName_m$a$2 = null;
    }
}

