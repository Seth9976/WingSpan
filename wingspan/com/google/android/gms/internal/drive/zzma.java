package com.google.android.gms.internal.drive;

final class zzma {
    private static final zzly zzuu;
    private static final zzly zzuv;

    static {
        zzma.zzuu = zzma.zzei();
        zzma.zzuv = new zzlz();
    }

    static zzly zzeg() {
        return zzma.zzuu;
    }

    static zzly zzeh() {
        return zzma.zzuv;
    }

    private static zzly zzei() {
        try {
            return (zzly)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
            return null;
        }
    }
}

