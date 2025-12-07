package com.google.android.gms.internal.drive;

final class zzjw {
    private static final Class zzok;

    static {
        zzjw.zzok = zzjw.zzce();
    }

    private static Class zzce() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    public static zzjx zzcf() {
        if(zzjw.zzok != null) {
            try {
                return zzjw.zzn("getEmptyRegistry");
            }
            catch(Exception unused_ex) {
            }
        }
        return zzjx.zzoo;
    }

    static zzjx zzcg() {
        zzjx zzjx0 = null;
        if(zzjw.zzok != null) {
            try {
                zzjx0 = zzjw.zzn("loadGeneratedRegistry");
            }
            catch(Exception unused_ex) {
            }
        }
        if(zzjx0 == null) {
            zzjx0 = zzjx.zzcg();
        }
        return zzjx0 == null ? zzjw.zzcf() : zzjx0;
    }

    private static final zzjx zzn(String s) throws Exception {
        return (zzjx)zzjw.zzok.getDeclaredMethod(s).invoke(null);
    }
}

