package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

final class zzft extends zzfv {
    zzft(Unsafe unsafe0) {
        super(unsafe0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfv
    public final double zza(Object object0, long v) {
        return Double.longBitsToDouble(this.zza.getLong(object0, v));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfv
    public final float zzb(Object object0, long v) {
        return Float.intBitsToFloat(this.zza.getInt(object0, v));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfv
    public final void zzc(Object object0, long v, boolean z) {
        if(zzfw.zzb) {
            zzfw.zzi(object0, v, z);
            return;
        }
        zzfw.zzj(object0, v, z);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfv
    public final void zzd(Object object0, long v, byte b) {
        if(zzfw.zzb) {
            zzfw.zzD(object0, v, b);
            return;
        }
        zzfw.zzE(object0, v, b);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfv
    public final void zze(Object object0, long v, double f) {
        this.zza.putLong(object0, v, Double.doubleToLongBits(f));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzfv
    public final void zzf(Object object0, long v, float f) {
        this.zza.putInt(object0, v, Float.floatToIntBits(f));
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.play_billing.zzfv
    public final boolean zzg(Object object0, long v) {
        return zzfw.zzb ? zzfw.zzt(object0, v) : zzfw.zzu(object0, v);
    }
}

