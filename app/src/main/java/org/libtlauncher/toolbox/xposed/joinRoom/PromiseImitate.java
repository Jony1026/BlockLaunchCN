package org.libtlauncher.toolbox.xposed.joinRoom;


import androidx.annotation.Nullable;

import com.facebook.react.bridge.Promise;

public class PromiseImitate implements Promise {

    public void reject(String str) {}

    public void reject(String str, String str2) {}

    public void reject(String str, String str2, Throwable th) {}

    public void reject(String str, Throwable th) {}

    public void reject(Throwable th) {}

    public void resolve(@Nullable Object obj) {}
}