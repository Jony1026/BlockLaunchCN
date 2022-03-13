package org.libtlauncher.toolbox.debug;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LOG {
    public static boolean debugMode = true;
    public static void LOGD(String TAG,String str){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        File a = new File(System.getenv("EXTERNAL_STORAGE")+"/BlockLauncher-CN.log");
        if (debugMode){
            Log.d(TAG,str);
            try {
                addTxtToFileWrite(new File(System.getenv("EXTERNAL_STORAGE")+"/BlockLauncher-CN.log"),df.format(new Date())+"-"+str);
            } catch (IOException e) {
                try {
                    a.createNewFile();
                } catch (IOException ex) {
                    a.mkdirs();
                }
                Log.d(LOG.LOG_Java,"err");
            }
        }
    }

    public static void Data2File(String path,String data){
        try {
            addTxtToFileWrite(new File(path),data);
        } catch (IOException e) {
           LOGD(LOG_Debug,e.getMessage());
        }
    }

    public static void addTxtToFileWrite(File file, String content) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            writer.write("\r\n");
            writer.write(content);
        } catch (IOException ignored) {
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    public static String LOG_System = "LOG-BlockLauncher-System-";
    public static String LOG_Java = "LOG-BlockLauncher-Java-";
    public static String LOG_Mod = "LOG-BlockLauncher-Mod-";
    public static String LOG_Debug = "LOG-BlockLauncher-Java-Debug-";
    public static String LOG_RN = "LOG-BlockLauncher-Java-RN-";
    public static String LOG_THROW = "LOG-BlockLauncher-Java-Throw-";
    public static String LOG_Func = "LOG-BlockLauncher-Java-Func-";
    public static String LOG_CMD = "LOG-BlockLauncher-System-CMD-";
    public static String LOG_API = "LOG-BlockLauncher-API-";

    public static String LOG_NativeJs = "LOG-BlockLauncher-Js-";

}
