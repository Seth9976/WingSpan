package com.unity3d.player;

import android.content.Context;
import android.provider.Settings.System;

public class OrientationLockListener implements L {
    private N a;
    private Context b;

    OrientationLockListener(Context context0) {
        this.b = context0;
        this.a = new N(context0);
        this.nativeUpdateOrientationLockState(Settings.System.getInt(context0.getContentResolver(), "accelerometer_rotation", 0));
        this.a.a(this, "accelerometer_rotation");
    }

    public void a() {
        this.a.a();
        this.a = null;
    }

    public void a(boolean z) {
        this.nativeUpdateOrientationLockState(Settings.System.getInt(this.b.getContentResolver(), "accelerometer_rotation", 0));
    }

    public final native void nativeUpdateOrientationLockState(int arg1) {
    }
}

