package com.google.android.gms.internal.play_billing;

public final class zzgh extends zzdd implements zzel {
    private static final zzgh zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private int zzg;
    private zzgr zzh;

    static {
        zzgh zzgh0 = new zzgh();
        zzgh.zzb = zzgh0;
        zzdd.zzt(zzgh.class, zzgh0);
    }

    private zzgh() {
        this.zze = 0;
    }

    public static zzgh zzB(byte[] arr_b, zzcp zzcp0) throws zzdn {
        return (zzgh)zzdd.zzk(zzgh.zzb, arr_b, zzcp0);
    }

    static void zzC(zzgh zzgh0, zzgr zzgr0) {
        zzgr0.getClass();
        zzgh0.zzh = zzgr0;
        zzgh0.zzd |= 2;
    }

    static void zzD(zzgh zzgh0, zzhi zzhi0) {
        zzhi0.getClass();
        zzgh0.zzf = zzhi0;
        zzgh0.zze = 4;
    }

    static void zzE(zzgh zzgh0, int v) {
        zzgh0.zzg = v - 1;
        zzgh0.zzd |= 1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzgh.zzq(zzgh.zzb, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzgi.zza, "zzh", zzhi.class});
                }
                case 3: {
                    return new zzgh();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzgg(null);
                        }
                        case 5: {
                            return zzgh.zzb;
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

    public static zzgg zzz() {
        return (zzgg)zzgh.zzb.zzh();
    }
}

