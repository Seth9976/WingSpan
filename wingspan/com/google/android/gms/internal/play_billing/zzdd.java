package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzdd extends zzbm {
    private static final Map zzb;
    protected zzfn zzc;
    private int zzd;

    static {
        zzdd.zzb = new ConcurrentHashMap();
    }

    public zzdd() {
        this.zzd = -1;
        this.zzc = zzfn.zzc();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        return this.getClass() == object0.getClass() ? zzes.zza().zzb(this.getClass()).zzj(this, ((zzdd)object0)) : false;
    }

    @Override
    public final int hashCode() {
        if(!this.zzx()) {
            int v = this.zza;
            if(v == 0) {
                v = this.zze();
                this.zza = v;
            }
            return v;
        }
        return this.zze();
    }

    @Override
    public final String toString() {
        return zzem.zza(this, super.toString());
    }

    private static zzdd zzA(zzdd zzdd0, byte[] arr_b, int v, int v1, zzcp zzcp0) throws zzdn {
        zzdd zzdd1 = zzdd0.zzj();
        try {
            zzev zzev0 = zzes.zza().zzb(zzdd1.getClass());
            zzev0.zzh(zzdd1, arr_b, 0, v1, new zzbp(zzcp0));
            zzev0.zzf(zzdd1);
            return zzdd1;
        }
        catch(zzdn zzdn0) {
            zzdn0.zzf(zzdd1);
            throw zzdn0;
        }
        catch(zzfl zzfl0) {
            zzdn zzdn1 = zzfl0.zza();
            zzdn1.zzf(zzdd1);
            throw zzdn1;
        }
        catch(IOException iOException0) {
            if(iOException0.getCause() instanceof zzdn) {
                throw (zzdn)iOException0.getCause();
            }
            zzdn zzdn2 = new zzdn(iOException0);
            zzdn2.zzf(zzdd1);
            throw zzdn2;
        }
        catch(IndexOutOfBoundsException unused_ex) {
            zzdn zzdn3 = zzdn.zzg();
            zzdn3.zzf(zzdd1);
            throw zzdn3;
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbm
    final int zza(zzev zzev0) {
        if(this.zzx()) {
            int v = zzev0.zza(this);
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
            return v;
        }
        int v1 = this.zzd & 0x7FFFFFFF;
        if(v1 == 0x7FFFFFFF) {
            int v2 = zzev0.zza(this);
            if(v2 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v2);
            }
            this.zzd = this.zzd & 0x80000000 | v2;
            return v2;
        }
        return v1;
    }

    final int zze() {
        return zzes.zza().zzb(this.getClass()).zzb(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzel
    public final zzek zzf() {
        return (zzdd)this.zzy(6, null, null);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzek
    public final int zzg() {
        int v;
        if(this.zzx()) {
            v = this.zzz(null);
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
        }
        else {
            v = this.zzd & 0x7FFFFFFF;
            if(v == 0x7FFFFFFF) {
                v = this.zzz(null);
                if(v < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + v);
                }
                this.zzd = this.zzd & 0x80000000 | v;
                return v;
            }
        }
        return v;
    }

    protected final zzcz zzh() {
        return (zzcz)this.zzy(5, null, null);
    }

    static zzdd zzi(Class class0) {
        Map map0 = zzdd.zzb;
        zzdd zzdd0 = (zzdd)map0.get(class0);
        if(zzdd0 == null) {
            try {
                Class.forName(class0.getName(), true, class0.getClassLoader());
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException0);
            }
            zzdd0 = (zzdd)map0.get(class0);
        }
        if(zzdd0 == null) {
            zzdd0 = (zzdd)((zzdd)zzfw.zze(class0)).zzy(6, null, null);
            if(zzdd0 == null) {
                throw new IllegalStateException();
            }
            map0.put(class0, zzdd0);
            return zzdd0;
        }
        return zzdd0;
    }

    final zzdd zzj() {
        return (zzdd)this.zzy(4, null, null);
    }

    protected static zzdd zzk(zzdd zzdd0, byte[] arr_b, zzcp zzcp0) throws zzdn {
        zzdd zzdd1 = zzdd.zzA(zzdd0, arr_b, 0, arr_b.length, zzcp0);
        if(zzdd1 != null && !zzdd1.zzw()) {
            zzdn zzdn0 = new zzfl(zzdd1).zza();
            zzdn0.zzf(zzdd1);
            throw zzdn0;
        }
        return zzdd1;
    }

    protected static zzdi zzl() {
        return zzde.zzf();
    }

    protected static zzdk zzm() {
        return zzet.zze();
    }

    protected static zzdk zzn(zzdk zzdk0) {
        int v = zzdk0.size();
        return v == 0 ? zzdk0.zzd(10) : zzdk0.zzd(v + v);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzek
    public final zzej zzo() {
        return (zzcz)this.zzy(5, null, null);
    }

    static Object zzp(Method method0, Object object0, Object[] arr_object) {
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

    protected static Object zzq(zzek zzek0, String s, Object[] arr_object) {
        return new zzeu(zzek0, s, arr_object);
    }

    protected final void zzr() {
        zzes.zza().zzb(this.getClass()).zzf(this);
        this.zzs();
    }

    final void zzs() {
        this.zzd &= 0x7FFFFFFF;
    }

    protected static void zzt(Class class0, zzdd zzdd0) {
        zzdd0.zzs();
        zzdd.zzb.put(class0, zzdd0);
    }

    // 去混淆评级： 低(25)
    final void zzu(int v) {
        this.zzd |= 0x7FFFFFFF;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzek
    public final void zzv(zzck zzck0) throws IOException {
        zzes.zza().zzb(this.getClass()).zzi(this, zzcl.zza(zzck0));
    }

    public final boolean zzw() {
        switch(((byte)(((Byte)this.zzy(1, null, null))))) {
            case 0: {
                return false;
            }
            case 1: {
                return true;
            }
            default: {
                boolean z = zzes.zza().zzb(this.getClass()).zzk(this);
                this.zzy(2, (z ? this : null), null);
                return z;
            }
        }
    }

    final boolean zzx() {
        return (this.zzd & 0x80000000) != 0;
    }

    protected abstract Object zzy(int arg1, Object arg2, Object arg3);

    private final int zzz(zzev zzev0) {
        return zzes.zza().zzb(this.getClass()).zza(this);
    }
}

