package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzkk extends zzit {
    public static class zza extends zziu {
        private final zzkk zzrt;
        protected zzkk zzru;
        private boolean zzrv;

        protected zza(zzkk zzkk0) {
            this.zzrt = zzkk0;
            this.zzru = (zzkk)zzkk0.zza(zze.zzsa, null, null);
            this.zzrv = false;
        }

        @Override  // com.google.android.gms.internal.drive.zziu
        public Object clone() throws CloneNotSupportedException {
            zza zzkk$zza0 = (zza)this.zzrt.zza(zze.zzsb, null, null);
            zzkk$zza0.zza(((zzkk)this.zzde()));
            return zzkk$zza0;
        }

        @Override  // com.google.android.gms.internal.drive.zzls
        public final boolean isInitialized() {
            return zzkk.zza(this.zzru, false);
        }

        private static void zza(zzkk zzkk0, zzkk zzkk1) {
            zzmd.zzej().zzq(zzkk0).zzc(zzkk0, zzkk1);
        }

        @Override  // com.google.android.gms.internal.drive.zziu
        protected final zziu zza(zzit zzit0) {
            return this.zza(((zzkk)zzit0));
        }

        public final zza zza(zzkk zzkk0) {
            this.zzdb();
            zza.zza(this.zzru, zzkk0);
            return this;
        }

        @Override  // com.google.android.gms.internal.drive.zziu
        public final zziu zzbn() {
            return (zza)this.clone();
        }

        @Override  // com.google.android.gms.internal.drive.zzls
        public final zzlq zzda() {
            return this.zzrt;
        }

        protected final void zzdb() {
            if(this.zzrv) {
                zzkk zzkk0 = (zzkk)this.zzru.zza(zze.zzsa, null, null);
                zza.zza(zzkk0, this.zzru);
                this.zzru = zzkk0;
                this.zzrv = false;
            }
        }

        public zzkk zzdc() {
            if(this.zzrv) {
                return this.zzru;
            }
            this.zzru.zzbp();
            this.zzrv = true;
            return this.zzru;
        }

        public final zzkk zzdd() {
            zzkk zzkk0 = (zzkk)this.zzde();
            if(!zzkk0.isInitialized()) {
                throw new zzmw(zzkk0);
            }
            return zzkk0;
        }

        @Override  // com.google.android.gms.internal.drive.zzlr
        public zzlq zzde() {
            return this.zzdc();
        }

        @Override  // com.google.android.gms.internal.drive.zzlr
        public zzlq zzdf() {
            return this.zzdd();
        }
    }

    public static final class zzb extends zziv {
        private final zzkk zzrt;

        public zzb(zzkk zzkk0) {
            this.zzrt = zzkk0;
        }
    }

    public static abstract class zzc extends zzkk implements zzls {
        protected zzkb zzrw;

        public zzc() {
            this.zzrw = zzkb.zzcn();
        }

        final zzkb zzdg() {
            if(this.zzrw.isImmutable()) {
                this.zzrw = (zzkb)this.zzrw.clone();
            }
            return this.zzrw;
        }
    }

    public static final class zzd extends zzjv {
    }

    public static final class zze {
        public static final enum int zzrx = 1;
        public static final enum int zzry = 2;
        public static final enum int zzrz = 3;
        public static final enum int zzsa = 4;
        public static final enum int zzsb = 5;
        public static final enum int zzsc = 6;
        public static final enum int zzsd = 7;
        private static final int[] zzse = null;
        public static final enum int zzsf = 1;
        public static final enum int zzsg = 2;
        private static final int[] zzsh = null;
        public static final enum int zzsi = 1;
        public static final enum int zzsj = 2;
        private static final int[] zzsk;

        static {
            zze.zzse = new int[]{1, 2, 3, 4, 5, 6, 7};
            zze.zzsh = new int[]{1, 2};
            zze.zzsk = new int[]{1, 2};
        }

        public static int[] zzdh() {
            return (int[])zze.zzse.clone();
        }
    }

    protected zzmy zzrq;
    private int zzrr;
    private static Map zzrs;

    static {
        zzkk.zzrs = new ConcurrentHashMap();
    }

    public zzkk() {
        this.zzrq = zzmy.zzfa();
        this.zzrr = -1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return ((zzkk)this.zza(zze.zzsc, null, null)).getClass().isInstance(object0) ? zzmd.zzej().zzq(this).equals(this, ((zzkk)object0)) : false;
    }

    @Override
    public int hashCode() {
        if(this.zzne != 0) {
            return this.zzne;
        }
        this.zzne = zzmd.zzej().zzq(this).hashCode(this);
        return this.zzne;
    }

    @Override  // com.google.android.gms.internal.drive.zzls
    public final boolean isInitialized() {
        return zzkk.zza(this, true);
    }

    @Override
    public String toString() {
        return zzlt.zza(this, super.toString());
    }

    private static zzkk zza(zzkk zzkk0, byte[] arr_b, int v, int v1, zzjx zzjx0) throws zzkq {
        zzkk zzkk1 = (zzkk)zzkk0.zza(zze.zzsa, null, null);
        try {
            zzmd.zzej().zzq(zzkk1).zza(zzkk1, arr_b, 0, v1, new zziz(zzjx0));
            zzkk1.zzbp();
            if(zzkk1.zzne != 0) {
                throw new RuntimeException();
            }
            return zzkk1;
        }
        catch(IOException iOException0) {
            throw iOException0.getCause() instanceof zzkq ? ((zzkq)iOException0.getCause()) : new zzkq(iOException0.getMessage()).zzg(zzkk1);
        }
        catch(IndexOutOfBoundsException unused_ex) {
            throw zzkq.zzdi().zzg(zzkk1);
        }
    }

    protected static zzkk zza(zzkk zzkk0, byte[] arr_b, zzjx zzjx0) throws zzkq {
        zzkk zzkk1 = zzkk.zza(zzkk0, arr_b, 0, arr_b.length, zzjx0);
        if(zzkk1 != null && !zzkk1.isInitialized()) {
            throw new zzkq(new zzmw(zzkk1).getMessage()).zzg(zzkk1);
        }
        return zzkk1;
    }

    protected static Object zza(zzlq zzlq0, String s, Object[] arr_object) {
        return new zzme(zzlq0, s, arr_object);
    }

    static Object zza(Method method0, Object object0, Object[] arr_object) {
        try {
            return method0.invoke(object0, arr_object);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new RuntimeException("Couldn\'t use Java reflection to implement protocol message reflection.", illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Throwable throwable0 = invocationTargetException0.getCause();
            if(throwable0 instanceof RuntimeException) {
                throw (RuntimeException)throwable0;
            }
            if(throwable0 instanceof Error) {
                throw (Error)throwable0;
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable0);
        }
    }

    protected static void zza(Class class0, zzkk zzkk0) {
        zzkk.zzrs.put(class0, zzkk0);
    }

    protected static final boolean zza(zzkk zzkk0, boolean z) {
        int v = (byte)(((Byte)zzkk0.zza(zze.zzrx, null, null)));
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        boolean z1 = zzmd.zzej().zzq(zzkk0).zzp(zzkk0);
        if(z) {
            zzkk0.zza(2, (z1 ? zzkk0 : null), null);
        }
        return z1;
    }

    protected abstract Object zza(int arg1, Object arg2, Object arg3);

    @Override  // com.google.android.gms.internal.drive.zzlq
    public final void zzb(zzjr zzjr0) throws IOException {
        zzmd.zzej().zzf(this.getClass()).zza(this, zzjt.zza(zzjr0));
    }

    @Override  // com.google.android.gms.internal.drive.zzit
    final int zzbm() {
        return this.zzrr;
    }

    protected final void zzbp() {
        zzmd.zzej().zzq(this).zzd(this);
    }

    protected final zza zzcw() {
        return (zza)this.zza(zze.zzsb, null, null);
    }

    @Override  // com.google.android.gms.internal.drive.zzlq
    public final int zzcx() {
        if(this.zzrr == -1) {
            this.zzrr = zzmd.zzej().zzq(this).zzn(this);
        }
        return this.zzrr;
    }

    @Override  // com.google.android.gms.internal.drive.zzlq
    public final zzlr zzcy() {
        zzlr zzlr0 = (zza)this.zza(zze.zzsb, null, null);
        ((zza)zzlr0).zza(this);
        return zzlr0;
    }

    @Override  // com.google.android.gms.internal.drive.zzlq
    public final zzlr zzcz() {
        return (zza)this.zza(zze.zzsb, null, null);
    }

    static zzkk zzd(Class class0) {
        zzkk zzkk0 = (zzkk)zzkk.zzrs.get(class0);
        if(zzkk0 == null) {
            try {
                Class.forName(class0.getName(), true, class0.getClassLoader());
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException0);
            }
            zzkk0 = (zzkk)zzkk.zzrs.get(class0);
        }
        if(zzkk0 == null) {
            zzkk0 = (zzkk)((zzkk)zznd.zzh(class0)).zza(zze.zzsc, null, null);
            if(zzkk0 == null) {
                throw new IllegalStateException();
            }
            zzkk.zzrs.put(class0, zzkk0);
            return zzkk0;
        }
        return zzkk0;
    }

    @Override  // com.google.android.gms.internal.drive.zzls
    public final zzlq zzda() {
        return (zzkk)this.zza(zze.zzsc, null, null);
    }

    @Override  // com.google.android.gms.internal.drive.zzit
    final void zzo(int v) {
        this.zzrr = v;
    }
}

