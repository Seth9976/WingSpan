package com.google.android.gms.internal.play_billing;

public final class zzhi extends zzdd implements zzel {
    private static final zzhi zzb;
    private int zzd;
    private int zze;

    static {
        zzhi zzhi0 = new zzhi();
        zzhi.zzb = zzhi0;
        zzdd.zzt(zzhi.class, zzhi0);
    }

    static zzhi zzA() {
        return zzhi.zzb;
    }

    static void zzB(zzhi zzhi0, int v) {
        zzhi0.zze = v - 1;
        zzhi0.zzd |= 1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzhi.zzq(zzhi.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzhh.zza});
                }
                case 3: {
                    return new zzhi();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzhg(null);
                        }
                        case 5: {
                            return zzhi.zzb;
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

    public static zzhg zzz() {
        return (zzhg)zzhi.zzb.zzh();
    }
}

