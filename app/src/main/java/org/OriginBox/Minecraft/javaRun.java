package org.OriginBox.Minecraft;

import org.libtlauncher.toolbox.xposed.core.scriptmanager.ToolBox;
import org.mozilla.javascript.ScriptableObject;

import java.lang.reflect.InvocationTargetException;

public class javaRun {
    public javaRun(ScriptableObject IS, final boolean a, final boolean b, final boolean c, final boolean d, final boolean e, final boolean f, final boolean g, final boolean h) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        ScriptableObject.defineClass(IS, ToolBox.class);

    }
}
