package com.google.android.gms.internal.drive;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zznd {
    static final class zza extends zzd {
        zza(Unsafe unsafe0) {
            super(unsafe0);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, double f) {
            this.zza(object0, v, Double.doubleToLongBits(f));
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, float f) {
            this.zza(object0, v, Float.floatToIntBits(f));
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, boolean z) {
            if(zznd.zzwr) {
                zznd.zzb(object0, v, z);
                return;
            }
            zznd.zzc(object0, v, z);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zze(Object object0, long v, byte b) {
            if(zznd.zzwr) {
                zznd.zza(object0, v, b);
                return;
            }
            zznd.zzb(object0, v, b);
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final boolean zzl(Object object0, long v) {
            return zznd.zzwr ? zznd.zzr(object0, v) : zznd.zzs(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final float zzm(Object object0, long v) {
            return Float.intBitsToFloat(this.zzj(object0, v));
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final double zzn(Object object0, long v) {
            return Double.longBitsToDouble(this.zzk(object0, v));
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final byte zzx(Object object0, long v) {
            return zznd.zzwr ? zznd.zzp(object0, v) : zznd.zzq(object0, v);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe0) {
            super(unsafe0);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, double f) {
            this.zza(object0, v, Double.doubleToLongBits(f));
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, float f) {
            this.zza(object0, v, Float.floatToIntBits(f));
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, boolean z) {
            if(zznd.zzwr) {
                zznd.zzb(object0, v, z);
                return;
            }
            zznd.zzc(object0, v, z);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zze(Object object0, long v, byte b) {
            if(zznd.zzwr) {
                zznd.zza(object0, v, b);
                return;
            }
            zznd.zzb(object0, v, b);
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final boolean zzl(Object object0, long v) {
            return zznd.zzwr ? zznd.zzr(object0, v) : zznd.zzs(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final float zzm(Object object0, long v) {
            return Float.intBitsToFloat(this.zzj(object0, v));
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final double zzn(Object object0, long v) {
            return Double.longBitsToDouble(this.zzk(object0, v));
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final byte zzx(Object object0, long v) {
            return zznd.zzwr ? zznd.zzp(object0, v) : zznd.zzq(object0, v);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe0) {
            super(unsafe0);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, double f) {
            this.zzws.putDouble(object0, v, f);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, float f) {
            this.zzws.putFloat(object0, v, f);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zza(Object object0, long v, boolean z) {
            this.zzws.putBoolean(object0, v, z);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final void zze(Object object0, long v, byte b) {
            this.zzws.putByte(object0, v, b);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final boolean zzl(Object object0, long v) {
            return this.zzws.getBoolean(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final float zzm(Object object0, long v) {
            return this.zzws.getFloat(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final double zzn(Object object0, long v) {
            return this.zzws.getDouble(object0, v);
        }

        @Override  // com.google.android.gms.internal.drive.zznd$zzd
        public final byte zzx(Object object0, long v) {
            return this.zzws.getByte(object0, v);
        }
    }

    static abstract class zzd {
        Unsafe zzws;

        zzd(Unsafe unsafe0) {
            this.zzws = unsafe0;
        }

        public abstract void zza(Object arg1, long arg2, double arg3);

        public abstract void zza(Object arg1, long arg2, float arg3);

        public final void zza(Object object0, long v, int v1) {
            this.zzws.putInt(object0, v, v1);
        }

        public final void zza(Object object0, long v, long v1) {
            this.zzws.putLong(object0, v, v1);
        }

        public abstract void zza(Object arg1, long arg2, boolean arg3);

        public abstract void zze(Object arg1, long arg2, byte arg3);

        public final int zzj(Object object0, long v) {
            return this.zzws.getInt(object0, v);
        }

        public final long zzk(Object object0, long v) {
            return this.zzws.getLong(object0, v);
        }

        public abstract boolean zzl(Object arg1, long arg2);

        public abstract float zzm(Object arg1, long arg2);

        public abstract double zzn(Object arg1, long arg2);

        public abstract byte zzx(Object arg1, long arg2);
    }

    private static final Logger logger;
    private static final Class zzni;
    private static final boolean zzog;
    private static final Unsafe zzuc;
    private static final boolean zzvy;
    private static final boolean zzvz;
    private static final zzd zzwa;
    private static final boolean zzwb;
    private static final long zzwc;
    private static final long zzwd;
    private static final long zzwe;
    private static final long zzwf;
    private static final long zzwg;
    private static final long zzwh;
    private static final long zzwi;
    private static final long zzwj;
    private static final long zzwk;
    private static final long zzwl;
    private static final long zzwm;
    private static final long zzwn;
    private static final long zzwo;
    private static final long zzwp;
    private static final int zzwq;
    static final boolean zzwr;

    static {
        zznd.logger = Logger.getLogger("com.google.android.gms.internal.drive.zznd");
        Unsafe unsafe0 = zznd.zzff();
        zznd.zzuc = unsafe0;
        zznd.zzni = zzix.zzbs();
        zznd.zzvy = zznd.zzk(Long.TYPE);
        zznd.zzvz = zznd.zzk(Integer.TYPE);
        zzd zznd$zzd0 = null;
        if(unsafe0 != null) {
            zznd$zzd0 = new zzc(unsafe0);
        }
        zznd.zzwa = zznd$zzd0;
        zznd.zzwb = zznd.zzfh();
        zznd.zzog = zznd.zzfg();
        long v = (long)zznd.zzi(byte[].class);
        zznd.zzwc = v;
        zznd.zzwd = (long)zznd.zzi(boolean[].class);
        zznd.zzwe = (long)zznd.zzj(boolean[].class);
        zznd.zzwf = (long)zznd.zzi(int[].class);
        zznd.zzwg = (long)zznd.zzj(int[].class);
        zznd.zzwh = (long)zznd.zzi(long[].class);
        zznd.zzwi = (long)zznd.zzj(long[].class);
        zznd.zzwj = (long)zznd.zzi(float[].class);
        zznd.zzwk = (long)zznd.zzj(float[].class);
        zznd.zzwl = (long)zznd.zzi(double[].class);
        zznd.zzwm = (long)zznd.zzj(double[].class);
        zznd.zzwn = (long)zznd.zzi(Object[].class);
        zznd.zzwo = (long)zznd.zzj(Object[].class);
        Field field0 = zznd.zzfi();
        zznd.zzwp = field0 == null || zznd$zzd0 == null ? -1L : zznd$zzd0.zzws.objectFieldOffset(field0);
        zznd.zzwq = (int)(v & 7L);
        zznd.zzwr = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    static byte zza(byte[] arr_b, long v) {
        return zznd.zzwa.zzx(arr_b, zznd.zzwc + v);
    }

    private static void zza(Object object0, long v, byte b) {
        int v1 = (~((int)v) & 3) << 3;
        zznd.zza(object0, -4L & v, (0xFF & b) << v1 | zznd.zzj(object0, -4L & v) & ~(0xFF << v1));
    }

    static void zza(Object object0, long v, double f) {
        zznd.zzwa.zza(object0, v, f);
    }

    static void zza(Object object0, long v, float f) {
        zznd.zzwa.zza(object0, v, f);
    }

    static void zza(Object object0, long v, int v1) {
        zznd.zzwa.zza(object0, v, v1);
    }

    static void zza(Object object0, long v, long v1) {
        zznd.zzwa.zza(object0, v, v1);
    }

    static void zza(Object object0, long v, Object object1) {
        zznd.zzwa.zzws.putObject(object0, v, object1);
    }

    static void zza(Object object0, long v, boolean z) {
        zznd.zzwa.zza(object0, v, z);
    }

    static void zza(byte[] arr_b, long v, byte b) {
        zznd.zzwa.zze(arr_b, zznd.zzwc + v, b);
    }

    private static Field zzb(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private static void zzb(Object object0, long v, byte b) {
        int v1 = (((int)v) & 3) << 3;
        zznd.zza(object0, -4L & v, (0xFF & b) << v1 | zznd.zzj(object0, -4L & v) & ~(0xFF << v1));
    }

    private static void zzb(Object object0, long v, boolean z) {
        zznd.zza(object0, v, ((byte)z));
    }

    private static void zzc(Object object0, long v, boolean z) {
        zznd.zzb(object0, v, ((byte)z));
    }

    static boolean zzfd() [...] // 潜在的解密器

    static boolean zzfe() [...] // 潜在的解密器

    static Unsafe zzff() {
        try {
            return (Unsafe)AccessController.doPrivileged(new zzne());
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    private static boolean zzfg() {
        Unsafe unsafe0 = zznd.zzuc;
        if(unsafe0 == null) {
            return false;
        }
        try {
            Class class0 = unsafe0.getClass();
            class0.getMethod("objectFieldOffset", Field.class);
            class0.getMethod("arrayBaseOffset", Class.class);
            class0.getMethod("arrayIndexScale", Class.class);
            class0.getMethod("getInt", Object.class, Long.TYPE);
            class0.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            class0.getMethod("getLong", Object.class, Long.TYPE);
            class0.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            class0.getMethod("getObject", Object.class, Long.TYPE);
            class0.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            class0.getMethod("getByte", Object.class, Long.TYPE);
            class0.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            class0.getMethod("getBoolean", Object.class, Long.TYPE);
            class0.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            class0.getMethod("getFloat", Object.class, Long.TYPE);
            class0.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            class0.getMethod("getDouble", Object.class, Long.TYPE);
            class0.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        }
        catch(Throwable throwable0) {
            zznd.logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", "platform method missing - proto runtime falling back to safer methods: " + throwable0);
            return false;
        }
    }

    private static boolean zzfh() {
        Unsafe unsafe0 = zznd.zzuc;
        if(unsafe0 == null) {
            return false;
        }
        try {
            Class class0 = unsafe0.getClass();
            class0.getMethod("objectFieldOffset", Field.class);
            class0.getMethod("getLong", Object.class, Long.TYPE);
            if(zznd.zzfi() == null) {
                return false;
            }
            class0.getMethod("getByte", Long.TYPE);
            class0.getMethod("putByte", Long.TYPE, Byte.TYPE);
            class0.getMethod("getInt", Long.TYPE);
            class0.getMethod("putInt", Long.TYPE, Integer.TYPE);
            class0.getMethod("getLong", Long.TYPE);
            class0.getMethod("putLong", Long.TYPE, Long.TYPE);
            class0.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            class0.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        }
        catch(Throwable throwable0) {
            zznd.logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", "platform method missing - proto runtime falling back to safer methods: " + throwable0);
            return false;
        }
    }

    private static Field zzfi() {
        Field field0 = zznd.zzb(Buffer.class, "address");
        return field0 == null || field0.getType() != Long.TYPE ? null : field0;
    }

    static Object zzh(Class class0) {
        try {
            return zznd.zzuc.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    private static int zzi(Class class0) {
        return zznd.zzwa.zzws.arrayBaseOffset(class0);
    }

    private static int zzj(Class class0) {
        return zznd.zzwa.zzws.arrayIndexScale(class0);
    }

    static int zzj(Object object0, long v) {
        return zznd.zzwa.zzj(object0, v);
    }

    static long zzk(Object object0, long v) {
        return zznd.zzwa.zzk(object0, v);
    }

    // 去混淆评级： 低(30)
    private static boolean zzk(Class class0) {
        return false;
    }

    static boolean zzl(Object object0, long v) {
        return zznd.zzwa.zzl(object0, v);
    }

    static float zzm(Object object0, long v) {
        return zznd.zzwa.zzm(object0, v);
    }

    static double zzn(Object object0, long v) {
        return zznd.zzwa.zzn(object0, v);
    }

    static Object zzo(Object object0, long v) {
        return zznd.zzwa.zzws.getObject(object0, v);
    }

    private static byte zzp(Object object0, long v) {
        return (byte)(zznd.zzj(object0, -4L & v) >>> ((int)((~v & 3L) << 3)));
    }

    private static byte zzq(Object object0, long v) {
        return (byte)(zznd.zzj(object0, -4L & v) >>> ((int)((v & 3L) << 3)));
    }

    private static boolean zzr(Object object0, long v) {
        return zznd.zzp(object0, v) != 0;
    }

    private static boolean zzs(Object object0, long v) {
        return zznd.zzq(object0, v) != 0;
    }
}

