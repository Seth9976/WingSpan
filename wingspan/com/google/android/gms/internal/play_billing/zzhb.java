package com.google.android.gms.internal.play_billing;

public final class zzhb extends zzdd implements zzel {
    private static final zzhb zzb;
    private int zzd;
    private String zze;
    private String zzf;

    static {
        zzhb zzhb0 = new zzhb();
        zzhb.zzb = zzhb0;
        zzdd.zzt(zzhb.class, zzhb0);
    }

    private zzhb() {
        this.zze = "";
        this.zzf = "";
    }

    static zzhb zzA() {
        return zzhb.zzb;
    }

    static void zzB(zzhb zzhb0, String s) {
        s.getClass();
        zzhb0.zzd |= 1;
        zzhb0.zze = s;
    }

    static void zzC(zzhb zzhb0, String s) {
        s.getClass();
        zzhb0.zzd |= 2;
        zzhb0.zzf = s;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzhb.zzq(zzhb.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
                }
                case 3: {
                    return new zzhb();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzha(null);
                        }
                        case 5: {
                            return zzhb.zzb;
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

    public static zzha zzz() {
        return (zzha)zzhb.zzb.zzh();
    }
}

