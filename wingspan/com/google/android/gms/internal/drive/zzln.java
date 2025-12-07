package com.google.android.gms.internal.drive;

final class zzln {
    private static final zzll zztz;
    private static final zzll zzua;

    static {
        zzln.zztz = zzln.zzeb();
        zzln.zzua = new zzlm();
    }

    static zzll zzdz() {
        return zzln.zztz;
    }

    static zzll zzea() {
        return zzln.zzua;
    }

    private static zzll zzeb() {
        try {
            return (zzll)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor().newInstance();
        }
        catch(Exception unused_ex) {
            return null;
        }
    }
}

