package com.google.android.gms.internal.play_billing;

public final class zzgl extends zzdd implements zzel {
    private static final zzgl zzb;
    private int zzd;
    private int zze;
    private Object zzf;
    private int zzg;

    static {
        zzgl zzgl0 = new zzgl();
        zzgl.zzb = zzgl0;
        zzdd.zzt(zzgl.class, zzgl0);
    }

    private zzgl() {
        this.zze = 0;
    }

    static zzgl zzA() {
        return zzgl.zzb;
    }

    static void zzB(zzgl zzgl0, zzhi zzhi0) {
        zzhi0.getClass();
        zzgl0.zzf = zzhi0;
        zzgl0.zze = 2;
    }

    static void zzC(zzgl zzgl0, int v) {
        zzgl0.zzg = v - 1;
        zzgl0.zzd |= 1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzgl.zzq(zzgl.zzb, "\u0001\u0002\u0001\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzgi.zza, zzhi.class});
                }
                case 3: {
                    return new zzgl();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzgk(null);
                        }
                        case 5: {
                            return zzgl.zzb;
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

    public static zzgk zzz() {
        return (zzgk)zzgl.zzb.zzh();
    }
}

