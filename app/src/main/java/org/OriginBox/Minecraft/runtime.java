package org.OriginBox.Minecraft;

import android.os.Looper;

import org.libtlauncher.toolbox.debug.LOG;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

public class runtime {

    public runtime(final String LoaderPath, final boolean a, final boolean b, final boolean c, final boolean d, final boolean e, final boolean f, final boolean g, final boolean h) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Looper.prepare();
                    Context enter = Context.enter();
                    interfaceRhino IJ = new interfaceRhino(enter);
                    ScriptableObject IS = IJ.get(enter);
                    javaRun b1 = new javaRun(IS,a,b,c,d,e,f,g,h);
                     new run(enter,IS,LoaderPath);
                } catch (Exception e) {
                    LOG.LOGD(LOG.LOG_Java, "NativeJs:" + e.getMessage());
                }
            }
        }).start();
    }
}
