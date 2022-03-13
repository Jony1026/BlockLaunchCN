package org.libtlauncher.toolbox.xposed.joinRoom;

import android.app.Activity;

import com.mojang.minecraftpe.RNCallPythonRetObj;

import org.libtlauncher.toolbox.debug.LOG;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class callPython {
    public static void joinRoom(Activity neteaseAct,String ip,int port){
        try {
            Field field = neteaseAct.getClass().getDeclaredField("nativeJsCall");
            field.setAccessible(true);
            LOG.LOGD(LOG.LOG_NativeJs,field.getName());
            field.set(neteaseAct,new Object[]{1007,ip, port,new RNCallPythonRetObj(new PromiseImitate())});
        } catch (Exception e) {
            LOG.LOGD(LOG.LOG_NativeJs,e.getMessage());
        }
    }
}
