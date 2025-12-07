package com.onesignal.session.internal.session;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H&J\b\u0010\u0007\u001A\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "", "onSessionActive", "", "onSessionEnded", "duration", "", "onSessionStarted", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ISessionLifecycleHandler {
    void onSessionActive();

    void onSessionEnded(long arg1);

    void onSessionStarted();
}

