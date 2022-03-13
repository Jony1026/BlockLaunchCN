package org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil;


import android.content.Context;

import org.libtlauncher.toolbox.activity.DebugLoggerActivity;
import org.libtlauncher.toolbox.debug.LOG;
import org.mozilla.javascript.ScriptableObject;
import org.OriginBox.Minecraft.runtime;

import java.io.FileReader;
import java.io.IOException;


public class APPLoader {

    /**
     * Author: Tloutdust.
     * Powered By Mozilla.
     **/

    private static org.mozilla.javascript.Context enter;

    private static ScriptableObject IS;

    private static String Path;

    private static int mode = 0;

    private Context Minecraftpe;

   public APPLoader(){
     try{
       enter = org.mozilla.javascript.Context.enter();
       IS = enter.initStandardObjects();
       ScriptableObject.defineClass(IS, APP.class);
       enter.setOptimizationLevel(-1);
     }catch (Exception e){
         switch (mode) {
             case 1:
                 AddLogView("err"+e.getMessage());
                 break;
             default:
                 throw new IllegalStateException("Unexpected value: " + mode);
         }
       }
   }

    public static void DuowanManager(final String LoaderPath,final boolean a, final boolean b, final boolean c, final boolean d, final boolean e, final boolean f, final boolean g, final boolean h) throws Exception, IOException {
        runtime ip = new runtime(LoaderPath,a,b,c,d,e,f,g,h);

     }

    public static void isDEBUG(int i){
        mode = i;
    }

    public static void AddLogView(String Message){
        DebugLoggerActivity.tv.setText(DebugLoggerActivity.tv.getText()+Message+"\n\n");
    }

    public static void JsInitLoader(final Context ctx, final String code,boolean isAddLogPrint){
                try {
                    enter = org.mozilla.javascript.Context.enter();
                    IS = enter.initStandardObjects();
                    ScriptableObject.defineClass(IS, APP.class);
                    enter.setOptimizationLevel(-1);
                    enter.evaluateString(IS, "function print(msg){ android.widget.Toast.makeText(APP.getContext(),msg,android.widget.Toast.LENGTH_LONG).show(); };", "print Module", 1, null);
                    if (code != null) {
                        enter.evaluateString(IS, code, ctx.getPackageName(), 1, null);
                    } else {
                        enter.evaluateReader(IS, new FileReader(Path), "Tlauncher Js Loader", 1, null);
                    }
                } catch (Exception e) {
                    if(isAddLogPrint){
                        AddLogView(e.getMessage());
                    }
                    LOG.LOGD(LOG.LOG_Debug,e.toString());
                }
    }

    public static void cleanLoader(){
        enter=null;
        IS=null;
    }

    public static void CleanLoaderPath(){
        Path = null;
    }

    public static void SetLoaderPath(String path){
        Path = path;
    }

    public static void CleanAll(){
        cleanLoader();
        CleanLoaderPath();
        SetLoaderPath(null);
    }

}
