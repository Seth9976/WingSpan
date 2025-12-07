package com.google.android.gms.internal.play_billing;

public final class zzgr extends zzdd implements zzel {
    private static final zzgr zzb;
    private int zzd;
    private int zze;
    private String zzf;
    private int zzg;
    private String zzh;

    static {
        zzgr zzgr0 = new zzgr();
        zzgr.zzb = zzgr0;
        zzdd.zzt(zzgr.class, zzgr0);
    }

    private zzgr() {
        this.zzf = "";
        this.zzh = "";
    }

    static zzgr zzA() {
        return zzgr.zzb;
    }

    static void zzB(zzgr zzgr0, int v) {
        zzgr0.zzd |= 1;
        zzgr0.zze = v;
    }

    static void zzC(zzgr zzgr0, String s) {
        s.getClass();
        zzgr0.zzd |= 2;
        zzgr0.zzf = s;
    }

    static void zzD(zzgr zzgr0, String s) {
        zzgr0.zzd |= 8;
        zzgr0.zzh = s;
    }

    static void zzE(zzgr zzgr0, int v) {
        zzgr0.zzg = v - 1;
        zzgr0.zzd |= 4;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzgr.zzq(zzgr.zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzgp.zza, "zzh"});
                }
                case 3: {
                    return new zzgr();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzgn(null);
                        }
                        case 5: {
                            return zzgr.zzb;
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

    public static zzgn zzz() {
        return (zzgn)zzgr.zzb.zzh();
    }
}

