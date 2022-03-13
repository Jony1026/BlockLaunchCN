package com.facebook.react.bridge;

import androidx.annotation.Nullable;

public interface Promise {
    @Deprecated
    void reject(String str);

    void reject(String str, String str2);

    void reject(String str, String str2, Throwable th);

    void reject(String str, Throwable th);

    void reject(Throwable th);

    void resolve(@Nullable Object obj);
}

