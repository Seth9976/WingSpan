package com.google.android.gms.internal.play_billing;

public final class zzhe extends zzdd implements zzel {
    private static final zzhe zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzhe zzhe0 = new zzhe();
        zzhe.zzb = zzhe0;
        zzdd.zzt(zzhe.class, zzhe0);
    }

    static zzhe zzA() {
        return zzhe.zzb;
    }

    static void zzB(zzhe zzhe0, boolean z) {
        zzhe0.zzd |= 2;
        zzhe0.zzf = false;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzhe.zzq(zzhe.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
                }
                case 3: {
                    return new zzhe();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzhd(null);
                        }
                        case 5: {
                            return zzhe.zzb;
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

    public static zzhd zzz() {
        return (zzhd)zzhe.zzb.zzh();
    }
}

