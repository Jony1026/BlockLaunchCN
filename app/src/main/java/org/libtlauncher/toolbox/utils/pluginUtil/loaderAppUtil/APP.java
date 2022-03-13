package org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil;

import android.content.Context;

import org.libtlauncher.toolbox.activity.MainActivity;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSStaticFunction;

public class APP extends ScriptableObject {
    @JSStaticFunction
    public static Context getContext(){
        return MainActivity.ctx;
    }
    @Override
    public String getClassName() {
        return "APP";
    }
}
