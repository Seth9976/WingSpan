package com.google.android.gms.internal.play_billing;

final class zzgu implements zzdh {
    static final zzdh zza;

    static {
        zzgu.zza = new zzgu();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdh
    public final boolean zza(int v) {
        switch(v) {
            case 0: {
                return zzgv.zza != null;
            }
            case 1: {
                return zzgv.zzb != null;
            }
            case 2: {
                return zzgv.zzc != null;
            }
            case 3: {
                return zzgv.zzd != null;
            }
            default: {
                return false;
            }
        }
    }
}

