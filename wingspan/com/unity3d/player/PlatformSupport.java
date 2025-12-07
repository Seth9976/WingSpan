package com.unity3d.player;

import android.os.Build.VERSION;

public class PlatformSupport {
    static final boolean MARSHMALLOW_SUPPORT;
    static final boolean NOUGAT_SUPPORT;
    static final boolean PIE_SUPPORT;

    static {
        boolean z = true;
        PlatformSupport.MARSHMALLOW_SUPPORT = true;
        PlatformSupport.NOUGAT_SUPPORT = Build.VERSION.SDK_INT >= 24;
        if(Build.VERSION.SDK_INT < 28) {
            z = false;
        }
        PlatformSupport.PIE_SUPPORT = z;
    }
}

