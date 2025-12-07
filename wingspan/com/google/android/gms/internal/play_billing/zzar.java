package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.CheckForNull;

final class zzar extends zzam {
    private final transient zzal zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzar(zzal zzal0, Object[] arr_object, int v, int v1) {
        this.zza = zzal0;
        this.zzb = arr_object;
        this.zzc = v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final boolean contains(@CheckForNull Object object0) {
        if(object0 instanceof Map.Entry) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            return object2 != null && object2.equals(this.zza.get(object1));
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzam
    public final Iterator iterator() {
        return this.zzd().zzm(0);
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final int zza(Object[] arr_object, int v) {
        return this.zzd().zza(arr_object, 0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzam
    public final zzaw zze() {
        return this.zzd().zzm(0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    final boolean zzf() {
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzam
    final zzai zzh() {
        return new zzaq(this);
    }
}

