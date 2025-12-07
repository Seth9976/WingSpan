package com.google.android.gms.internal.play_billing;

final class zzcs {
    private static final zzcq zza;
    private static final zzcq zzb;

    static {
        zzcq zzcq0;
        zzcs.zza = new zzcr();
        try {
            zzcq0 = null;
            zzcq0 = (zzcq)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
        }
        zzcs.zzb = zzcq0;
    }

    static zzcq zza() {
        zzcq zzcq0 = zzcs.zzb;
        if(zzcq0 == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return zzcq0;
    }

    static zzcq zzb() {
        return zzcs.zza;
    }
}

