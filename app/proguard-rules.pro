
#土豆字典
-obfuscationdictionary dictionary_rules.txt
-classobfuscationdictionary dictionary_rules.txt
-packageobfuscationdictionary dictionary_rules.txt


-dontskipnonpubliclibraryclasses
# 这句话能够使我们的项目混淆后产生映射文件
# 包含有类名->混淆后类名的映射关系
#-verbose
-dontskipnonpubliclibraryclassmembers
# 不做预校验 去掉这一步能够加快混淆速度。
#-dontpreverify
-keepattributes *Annotation*,InnerClasses
-keepattributes Signature
-optimizations !code/simplification/cast,!field/*,!class/merging/*
 
# 保留我们使用的四大组件，自定义的Application等等这些类不被混淆
# 因为这些子类都有可能被外部调用
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class * extends org.mozilla.javascript.ScriptableObject

#moz rhino
-keep class org.mozilla.javascript.*{*;}
-keep class org.mozilla.javascript.*.*{*;}
#rxandroid
-keep class io.reactivex.*{ *; }
-keep class io.reactivex.android.*{ *; }
-keep class io.reactivex.android.plugins.*{ *; }
-keep class io.reactivex.android.schedulers.*{ *; }
#rxjava
-keep class io.reactivex.annotations.*{ *; }
-keep class io.reactivex.disposables.*{ *; }
-keep class io.reactivex.flowables.*{ *; }
-keep class io.reactivex.functions.*{ *; }
-keep class io.reactivex.internal.*{ *; }
-keep class io.reactivex.observables.*{ *; }
-keep class io.reactivex.observers.*{ *; }
-keep class io.reactivex.parallel.*{ *; }
-keep class io.reactivex.plugins.*{ *; }
-keep class io.reactivex.processors.*{ *; }
-keep class io.reactivex.schedulers.*{ *; }
-keep class io.reactivex.subjects.*{ *; }
-keep class io.reactivex.subscribers.*{ *; }
#必须将xposed模块的入口类排除，，会导致模块不生效
-keep class org.libtlauncher.toolbox.Utils.pluginUtil.loaderAppUtil.APP{*;}
 #-keep class org.libtlauncher.toolbox.bmobUtils.pluginUtil.loaderAppUtil.LoaderManager{*;}
-keep class org.libtlauncher.toolbox.xposed.InitHook{ *; }
-keep class org.libtlauncher.toolbox.xposed.core.scriptmanager.*{ *; }
-keep class org.libtlauncher.toolbox.xposed.jniManager.callJava{*;}
-keep class org.libtlauncher.toolbox.xposed.NoRootInit{*;}
#bmob类
-keep class org.libtlauncher.toolbox.Utils.pluginUtil.T_Plugin{*;}
-keep class org.libtlauncher.toolbox.Utils.pluginUtil.About_app{*;}
#bmob sdk
-keep class cn.bmob.v3.*{ *;}
-keep class cn.bmob.v3.a.*{ *;}
-keep class cn.bmob.v3.a.a*{ *;}
-keep class cn.bmob.v3.a.b*{ *;}
-keep class cn.bmob.v3.datatype.*{ *;}
-keep class cn.bmob.v3.datatype.a.*{ *;}
-keep class cn.bmob.v3.exception.*{ *;}
-keep class cn.bmob.v3.helper.*{ *;}
-keep class cn.bmob.v3.http.*{ *;}
-keep class cn.bmob.v3.http.a.*{ *;}
-keep class cn.bmob.v3.http.b.*{ *;}
-keep class cn.bmob.v3.http.bean.*{ *;}
-keep class cn.bmob.v3.http.c.*{ *;}
-keep class cn.bmob.v3.listener.*{ *;}
-keep class cn.bmob.v3.realtime.*{ *;}
-keep class cn.bmob.v3.socketio.*{ *;}
-keep class cn.bmob.v3.statistics.*{ *;}
-keep class cn.bmob.v3.update.*{ *;}
-keep class cn.bmob.v3.util.*{ *;}

-keep class org.libtlauncher.toolbox.xposed.floatWin.WeLite.UI.*{ *;}

#glide
-keep class com.bumptech.glide.util.*{*;}
-keep class com.bumptech.glide.*{*;}
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.GeneratedAppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
#sweet toast
-keep class xyz.hasnat.sweettoast.* { *; }
#dialog
-keep class cn.pedant.SweetAlert.* { *; }
# 保留R下面的资源
-keep class **.R$* {*;}
 
# 保留本地native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}


# 保留在Activity中的方法参数是view的方法，
# 这样以来我们在layout中写的onClick就不会被影响
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}
 
# 保留枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
 
# 保留我们自定义控件（继承自View）不被混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
 
# 保留Parcelable序列化类不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
 
# 保留Serializable序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
 
# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}