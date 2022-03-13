package org.OriginBox.Minecraft;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

public class interfaceRhino {

    public interfaceRhino(Context enter) {
    }

    public ScriptableObject get(Context enter){
        final ScriptableObject IS = enter.initStandardObjects();//this zh
        enter.setOptimizationLevel(-1);
        return IS;
    }
}
