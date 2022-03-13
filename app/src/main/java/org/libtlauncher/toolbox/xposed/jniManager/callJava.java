package org.libtlauncher.toolbox.xposed.jniManager;

import android.content.Context;
import android.widget.Toast;

import org.libtlauncher.toolbox.xposed.info.NeteaseInfo;

public class callJava {
    public static native void Socket_Init(String str,String str1,int i);
    public static native int Socket_Send(String str);
    public static native String Socket_Recv();
    public static native void Socket_Close();

    public static native void Native_sendClientMessage(String str);

    public static Object getMinecraftContext(){
        return NeteaseInfo.MCContext;
    }
    public static void toast(String str){
        Toast.makeText((Context) getMinecraftContext(),str,0).show();
    }
}
