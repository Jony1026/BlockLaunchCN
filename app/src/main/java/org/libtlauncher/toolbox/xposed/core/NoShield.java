package org.libtlauncher.toolbox.xposed.core;

import android.content.Context;
import android.util.Log;


import org.libtlauncher.toolbox.xposed.info.FuncInfo;
import org.libtlauncher.toolbox.debug.LOG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class NoShield {
    private XC_LoadPackage.LoadPackageParam loadPackageParam;

    public NoShield(final XC_LoadPackage.LoadPackageParam load, final ClassLoader classLoader){
        try {
            loadPackageParam = load;

            /*
             *绕过屏蔽词
             */
            XposedHelpers.findAndHookMethod(XposedHelpers.findClass("com.netease.environment.model.DefaultRegex",classLoader), "getEncodedData", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    if (FuncInfo.isNoShieldingWords) {
                        param.setResult("");
                    }
                }
            });
            XposedHelpers.findAndHookMethod(XposedHelpers.findClass("com.netease.environment.utils.FileUtils",classLoader), "getFileDir", Context.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    if (FuncInfo.isNoShieldingWords) {
                        Context ctx = (Context) param.args[0];
                        if (ctx != null) {
                            param.setResult(ctx.getFilesDir() + "");
                        }
                    }
                }
            });
            XposedHelpers.findAndHookMethod(XposedHelpers.findClass("com.netease.environment.utils.FileUtils",classLoader), "getTempDir", Context.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    if (FuncInfo.isNoShieldingWords) {
                        Context ctx = (Context) param.args[0];
                        if (ctx != null) {
                            param.setResult(ctx.getFilesDir() + "");
                        }
                    }
                }
            });
            XposedHelpers.findAndHookMethod(XposedHelpers.findClass("com.netease.environment.utils.FileUtils",classLoader), "getTempFileName", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    if (FuncInfo.isNoShieldingWords) {
                        Method getGameId = XposedHelpers.findClass("com.netease.environment.config.SdkData",classLoader).getMethod("getGameId");
                        String ret = (String) getGameId.invoke(null);
                        param.setResult(ret + "");
                    }
                }
            });
            XposedHelpers.findAndHookMethod(XposedHelpers.findClass("com.netease.environment.utils.FileUtils",classLoader), "getRegexFileName", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    if (FuncInfo.isNoShieldingWords) {
                        Method getGameId = XposedHelpers.findClass("com.netease.environment.config.SdkData",classLoader).getMethod("getGameId");
                        String ret = (String) getGameId.invoke(null);
                        param.setResult(ret + "");
                    }
                }
            });
            XposedHelpers.findAndHookMethod(XposedHelpers.findClass("com.netease.environment.utils.FileUtils",classLoader), "readFile", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    if (FuncInfo.isNoShieldingWords) {
                        String str = (String) param.args[0];
                        String str2 = "";
                        if (str == null || str.isEmpty()) {
                            param.setResult(str2);
                        }
                        File file = new File(str);
                        if (!file.exists() || file.isDirectory()) {
                            Log.i("MCPE", "The file dosen't not exist:" + str);
                        } else {
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    str2 = str2 + readLine;
                                }
                                fileInputStream.close();
                            } catch (FileNotFoundException unused) {
                                Log.i("MCPE", "The file doesn't not exist.");
                            } catch (IOException unused2) {
                                Log.i("MCPE", "read file failed : IOException");
                            } catch (Exception unused3) {
                                Log.i("MCPE", "read file failed : Exception");
                            }
                        }
                        param.setResult(str2);
                    }
                }
            });
        } catch (Exception e){
            LOG.LOGD(LOG.LOG_THROW,e.toString());
        }
    }
}
