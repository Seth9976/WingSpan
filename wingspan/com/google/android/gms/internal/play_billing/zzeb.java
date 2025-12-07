package com.google.android.gms.internal.play_billing;

final class zzeb implements zzei {
    private final zzei[] zza;

    zzeb(zzei[] arr_zzei) {
        this.zza = arr_zzei;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzei
    public final zzeh zzb(Class class0) {
        for(int v = 0; v < 2; ++v) {
            zzei zzei0 = this.zza[v];
            if(zzei0.zzc(class0)) {
                return zzei0.zzb(class0);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + class0.getName());
    }

    @Override  // com.google.android.gms.internal.play_billing.zzei
    public final boolean zzc(Class class0) {
        for(int v = 0; v < 2; ++v) {
            if(this.zza[v].zzc(class0)) {
                return true;
            }
        }
        return false;
    }
}

