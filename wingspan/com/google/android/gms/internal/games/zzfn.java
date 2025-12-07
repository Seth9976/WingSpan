package com.google.android.gms.internal.games;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzfn {
    private final Handler zza;
    final Object zzb;
    private boolean zzc;
    private final HashMap zzd;

    public zzfn(Looper looper0, int v) {
        this.zzb = new Object();
        this.zza = new zzfu(looper0);
        this.zzd = new HashMap();
    }

    protected abstract void zza(String arg1, int arg2);

    static void zzb(zzfn zzfn0) {
        synchronized(zzfn0.zzb) {
            zzfn0.zzc = false;
            zzfn0.zzd();
        }
    }

    public final void zzc(String s, int v) {
        synchronized(this.zzb) {
            if(!this.zzc) {
                this.zzc = true;
                zzfm zzfm0 = new zzfm(this);
                this.zza.postDelayed(zzfm0, 1000L);
            }
            AtomicInteger atomicInteger0 = (AtomicInteger)this.zzd.get(s);
            if(atomicInteger0 == null) {
                atomicInteger0 = new AtomicInteger();
                this.zzd.put(s, atomicInteger0);
            }
            atomicInteger0.addAndGet(v);
        }
    }

    public final void zzd() {
        synchronized(this.zzb) {
            for(Object object1: this.zzd.entrySet()) {
                this.zza(((String)((Map.Entry)object1).getKey()), ((AtomicInteger)((Map.Entry)object1).getValue()).get());
            }
            this.zzd.clear();
        }
    }
}

