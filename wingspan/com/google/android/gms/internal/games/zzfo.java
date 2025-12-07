package com.google.android.gms.internal.games;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzfo {
    private final AtomicReference zza;

    public zzfo() {
        this.zza = new AtomicReference();
    }

    protected abstract zzfn zza();

    public final void zzb() {
        zzfn zzfn0 = (zzfn)this.zza.get();
        if(zzfn0 != null) {
            zzfn0.zzd();
        }
    }

    public final void zzc(String s, int v) {
        zzfn zzfn0 = (zzfn)this.zza.get();
        if(zzfn0 == null) {
            zzfn zzfn1 = this.zza();
            AtomicReference atomicReference0 = this.zza;
            while(true) {
                if(WorkSpec..ExternalSyntheticBackport0.m(atomicReference0, null, zzfn1)) {
                    zzfn0 = zzfn1;
                    break;
                }
                if(atomicReference0.get() != null) {
                    zzfn0 = (zzfn)this.zza.get();
                    break;
                }
            }
        }
        zzfn0.zzc(s, v);
    }
}

