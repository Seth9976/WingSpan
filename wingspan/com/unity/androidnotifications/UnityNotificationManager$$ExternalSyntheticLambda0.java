package com.unity.androidnotifications;

public final class UnityNotificationManager..ExternalSyntheticLambda0 implements Runnable {
    public final UnityNotificationManager f$0;
    public final Integer f$1;

    public UnityNotificationManager..ExternalSyntheticLambda0(UnityNotificationManager unityNotificationManager0, Integer integer0) {
        this.f$0 = unityNotificationManager0;
        this.f$1 = integer0;
    }

    @Override
    public final void run() {
        this.f$0.lambda$showNotification$0$com-unity-androidnotifications-UnityNotificationManager(this.f$1);
    }
}

