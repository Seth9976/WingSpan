package com.google.android.gms.internal.auth;

final class zzeo {
    private static final zzem zza;
    private static final zzem zzb;

    static {
        zzem zzem0;
        zzeo.zza = new zzen();
        try {
            zzem0 = null;
            zzem0 = (zzem)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
        }
        zzeo.zzb = zzem0;
    }

    static zzem zza() {
        zzem zzem0 = zzeo.zzb;
        if(zzem0 == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return zzem0;
    }

    static zzem zzb() {
        return zzeo.zza;
    }
}

