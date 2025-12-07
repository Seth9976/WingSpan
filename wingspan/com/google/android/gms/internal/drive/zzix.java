package com.google.android.gms.internal.drive;

final class zzix {
    private static final Class zzni;
    private static final boolean zznj;

    static {
        zzix.zzni = zzix.zzj("libcore.io.Memory");
        zzix.zznj = zzix.zzj("org.robolectric.Robolectric") != null;
    }

    static boolean zzbr() [...] // 潜在的解密器

    static Class zzbs() {
        return zzix.zzni;
    }

    private static Class zzj(String s) {
        try {
            return Class.forName(s);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }
}

