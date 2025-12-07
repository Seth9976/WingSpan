package com.google.android.gms.internal.drive;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzmj extends zzmi {
    zzmj(int v) {
        super(v, null);
    }

    @Override  // com.google.android.gms.internal.drive.zzmi
    public final void zzbp() {
        if(!this.isImmutable()) {
            for(int v = 0; v < this.zzer(); ++v) {
                Map.Entry map$Entry0 = this.zzaw(v);
                if(((zzkd)map$Entry0.getKey()).zzcs()) {
                    map$Entry0.setValue(Collections.unmodifiableList(((List)map$Entry0.getValue())));
                }
            }
            for(Object object0: this.zzes()) {
                Map.Entry map$Entry1 = (Map.Entry)object0;
                if(((zzkd)map$Entry1.getKey()).zzcs()) {
                    map$Entry1.setValue(Collections.unmodifiableList(((List)map$Entry1.getValue())));
                }
            }
        }
        super.zzbp();
    }
}

