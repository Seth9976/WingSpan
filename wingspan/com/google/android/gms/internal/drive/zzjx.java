package com.google.android.gms.internal.drive;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzjx {
    static final class zza {
        private final int number;
        private final Object object;

        zza(Object object0, int v) {
            this.object = object0;
            this.number = v;
        }

        @Override
        public final boolean equals(Object object0) {
            return object0 instanceof zza ? this.object == ((zza)object0).object && this.number == ((zza)object0).number : false;
        }

        @Override
        public final int hashCode() {
            return System.identityHashCode(this.object) * 0xFFFF + this.number;
        }
    }

    private static volatile boolean zzol;
    private static final Class zzom;
    private static volatile zzjx zzon;
    static final zzjx zzoo;
    private final Map zzop;

    static {
        zzjx.zzom = zzjx.zzch();
        zzjx.zzoo = new zzjx(true);
    }

    zzjx() {
        this.zzop = new HashMap();
    }

    private zzjx(boolean z) {
        this.zzop = Collections.emptyMap();
    }

    public final zzd zza(zzlq zzlq0, int v) {
        zza zzjx$zza0 = new zza(zzlq0, v);
        return (zzd)this.zzop.get(zzjx$zza0);
    }

    static zzjx zzcg() {
        return zzki.zza(zzjx.class);
    }

    private static Class zzch() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    public static zzjx zzci() {
        return zzjw.zzcf();
    }

    public static zzjx zzcj() {
        zzjx zzjx0 = zzjx.zzon;
        if(zzjx0 == null) {
            synchronized(zzjx.class) {
                zzjx0 = zzjx.zzon;
                if(zzjx0 == null) {
                    zzjx0 = zzjw.zzcg();
                    zzjx.zzon = zzjx0;
                }
                return zzjx0;
            }
        }
        return zzjx0;
    }
}

