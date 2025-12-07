package com.google.android.gms.internal.play_billing;

final class zzeq {
    private static final zzep zza;
    private static final zzep zzb;

    static {
        zzep zzep0 = null;
        try {
            zzep0 = (zzep)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
        }
        zzeq.zza = zzep0;
        zzeq.zzb = new zzep();
    }

    static zzep zza() {
        return zzeq.zza;
    }

    static zzep zzb() {
        return zzeq.zzb;
    }
}

