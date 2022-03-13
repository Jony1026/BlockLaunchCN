package org.libtlauncher.toolbox.xposed.core.scriptmanager;

import android.app.Activity;

import org.libtlauncher.toolbox.xposed.joinRoom.callPython;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSStaticFunction;

import java.security.PublicKey;

public class ToolBox extends ScriptableObject {
    @JSStaticFunction
    public static void joinRoom(Activity act,String ip, int port){
        callPython.joinRoom(act,ip,port);
    }
    @Override
    public String getClassName() {
        return "ToolBox";
    }
}
