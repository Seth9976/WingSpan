package com.google.android.gms.internal.play_billing;

final class zzeg {
    private static final zzef zza;
    private static final zzef zzb;

    static {
        zzef zzef0 = null;
        try {
            zzef0 = (zzef)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
        }
        zzeg.zza = zzef0;
        zzeg.zzb = new zzef();
    }

    static zzef zza() {
        return zzeg.zza;
    }

    static zzef zzb() {
        return zzeg.zzb;
    }
}

