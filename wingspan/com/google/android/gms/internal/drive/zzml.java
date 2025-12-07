package com.google.android.gms.internal.drive;

import java.util.Iterator;

final class zzml extends zzmr {
    private final zzmi zzvk;

    private zzml(zzmi zzmi0) {
        this.zzvk = zzmi0;
        super(zzmi0, null);
    }

    zzml(zzmi zzmi0, zzmj zzmj0) {
        this(zzmi0);
    }

    @Override  // com.google.android.gms.internal.drive.zzmr
    public final Iterator iterator() {
        return new zzmk(this.zzvk, null);
    }
}

