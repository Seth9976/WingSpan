package com.google.android.gms.internal.drive;

final class zzka {
    private static final zzjy zzoq;
    private static final zzjy zzor;

    static {
        zzka.zzoq = new zzjz();
        zzka.zzor = zzka.zzck();
    }

    private static zzjy zzck() {
        try {
            return (zzjy)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    static zzjy zzcl() {
        return zzka.zzoq;
    }

    static zzjy zzcm() {
        zzjy zzjy0 = zzka.zzor;
        if(zzjy0 == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return zzjy0;
    }
}

