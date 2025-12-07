package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.Preconditions;

public final class zbb {
    private String zba;

    private zbb() {
    }

    zbb(zba zba0) {
    }

    public final zbb zba(String s) {
        this.zba = Preconditions.checkNotEmpty(s);
        return this;
    }

    public final zbc zbb() {
        return new zbc(this.zba);
    }

    public static final zbb zbc(zbc zbc0) {
        String s = zbc0.zbb();
        zbb zbb0 = new zbb();
        if(s != null) {
            zbb0.zba = Preconditions.checkNotEmpty(s);
        }
        return zbb0;
    }
}

