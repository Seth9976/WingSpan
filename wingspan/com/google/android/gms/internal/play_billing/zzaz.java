package com.google.android.gms.internal.play_billing;

abstract class zzaz implements zzbd {
    @Override  // com.google.android.gms.internal.play_billing.zzbd
    public final zzbc zza(CharSequence charSequence0) {
        int v = charSequence0.length();
        int v1 = v + v;
        if(v1 < 0) {
            throw new IllegalArgumentException(zzab.zza("expectedInputSize must be >= 0 but was %s", new Object[]{v1}));
        }
        zzbe zzbe0 = this.zzb();
        int v3 = charSequence0.length();
        for(int v2 = 0; v2 < v3; ++v2) {
            ((zzba)zzbe0).zza(charSequence0.charAt(v2));
        }
        return zzbe0.zzc();
    }
}

