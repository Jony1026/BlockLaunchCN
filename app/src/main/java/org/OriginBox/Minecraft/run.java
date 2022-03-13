package org.OriginBox.Minecraft;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import java.io.FileReader;
import java.io.IOException;

public class run {
    public run(Context enter, ScriptableObject IS, String LoaderPath) throws IOException {
        enter.evaluateReader(IS, new FileReader(LoaderPath), "BlockLauncher Js:"+LoaderPath, 1, null);
    }
}
