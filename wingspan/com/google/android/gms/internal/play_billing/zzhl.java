package com.google.android.gms.internal.play_billing;

public final class zzhl extends zzdd implements zzel {
    private static final zzhl zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private zzhb zzg;
    private zzhe zzh;

    static {
        zzhl zzhl0 = new zzhl();
        zzhl.zzb = zzhl0;
        zzdd.zzt(zzhl.class, zzhl0);
    }

    private zzhl() {
        this.zze = 0;
    }

    static zzhl zzA() {
        return zzhl.zzb;
    }

    static void zzB(zzhl zzhl0, zzhs zzhs0) {
        zzhl0.zzf = zzhs0;
        zzhl0.zze = 4;
    }

    static void zzC(zzhl zzhl0, zzgy zzgy0) {
        zzhl0.zzf = zzgy0;
        zzhl0.zze = 5;
    }

    static void zzD(zzhl zzhl0, zzhe zzhe0) {
        zzhe0.getClass();
        zzhl0.zzh = zzhe0;
        zzhl0.zzd |= 2;
    }

    static void zzE(zzhl zzhl0, zzhb zzhb0) {
        zzhl0.zzg = zzhb0;
        zzhl0.zzd |= 1;
    }

    static void zzF(zzhl zzhl0, zzgh zzgh0) {
        zzhl0.zzf = zzgh0;
        zzhl0.zze = 2;
    }

    static void zzG(zzhl zzhl0, zzgl zzgl0) {
        zzhl0.zzf = zzgl0;
        zzhl0.zze = 3;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzhl.zzq(zzhl.zzb, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001", new Object[]{"zzf", "zze", "zzd", "zzg", zzgh.class, zzgl.class, zzhs.class, zzgy.class, "zzh"});
                }
                case 3: {
                    return new zzhl();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzhk(null);
                        }
                        case 5: {
                            return zzhl.zzb;
                        }
                        default: {
                            return null;
                        }
                    }
                }
            }
        }
        return (byte)1;
    }

    public static zzhk zzz() {
        return (zzhk)zzhl.zzb.zzh();
    }
}

