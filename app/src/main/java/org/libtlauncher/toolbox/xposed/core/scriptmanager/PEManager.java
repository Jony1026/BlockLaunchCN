package org.libtlauncher.toolbox.xposed.core.scriptmanager;

import android.os.Looper;

import org.json.JSONObject;
import org.libtlauncher.toolbox.debug.LOG;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;
import org.OriginBox.Minecraft.interfaceRhino;

import org.OriginBox.Minecraft.run;

public class PEManager {
    public static native void Socket_Init(String str,String str1,int i);
    public static native int Socket_Send(String str);
    public static native String Socket_Recv();
    public static native void Socket_Close();

    public static int SendString(String str){
        Socket_Init("127.0.0.1","12346",1);
        int result = Socket_Send(str);
        Socket_Close();
        return result;
    }

    public static String SendStringAndRecvString(String str){
        Socket_Init("127.0.0.1","12346",1);
        Socket_Send(str);
        String result = Socket_Recv();
        Socket_Close();
        return result;
    }

    public static JSONObject CallNow(String fName,JSONObject fArgs){
        try{
            JSONObject call = new JSONObject();
            call.put("type","Now");
            call.put("fName",fName);
            call.put("fArgs",fArgs);
            String result = SendStringAndRecvString(call.toString());

            return new JSONObject(result);
        } catch (Exception e) {
            LOG.LOGD(LOG.LOG_Debug,e.getMessage());
            return null;
        }
    }

    public static void CallTick(String fName,JSONObject fArgs) {
        try {
            JSONObject call = new JSONObject();
            call.put("type", "Tick");
            call.put("fName", fName);
            call.put("fArgs", fArgs);
            SendString(call.toString());
        } catch (Exception e) {
            LOG.LOGD(LOG.LOG_Debug,e.getMessage());
        }
    }
    //问一下 js中


    public static void LoadJs(final String LoaderPath){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Looper.prepare();
                    Context enter = Context.enter();
                    interfaceRhino IJ = new interfaceRhino(enter);
                    ScriptableObject IS = IJ.get(enter);

                    run r = new run(enter,IS,LoaderPath);
                } catch (Exception e) {
                    LOG.LOGD(LOG.LOG_Java, "NativeJs:" + e.getMessage());
                }
            }
        }).start();
    }
}
