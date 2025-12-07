package com.google.android.gms.internal.play_billing;

public final class zzgy extends zzdd implements zzel {
    private static final zzdj zzb;
    private static final zzgy zzd;
    private int zze;
    private String zzf;
    private int zzg;
    private zzdi zzh;
    private zzdk zzi;
    private zzgr zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzgy.zzb = new zzgs();
        zzgy zzgy0 = new zzgy();
        zzgy.zzd = zzgy0;
        zzdd.zzt(zzgy.class, zzgy0);
    }

    private zzgy() {
        this.zzf = "";
        this.zzh = zzgy.zzl();
        this.zzi = zzgy.zzm();
    }

    static zzgy zzA() {
        return zzgy.zzd;
    }

    public static zzgy zzB(byte[] arr_b, zzcp zzcp0) throws zzdn {
        return (zzgy)zzdd.zzk(zzgy.zzd, arr_b, zzcp0);
    }

    static void zzC(zzgy zzgy0, zzho zzho0) {
        zzho0.getClass();
        zzdk zzdk0 = zzgy0.zzi;
        if(!zzdk0.zzc()) {
            zzgy0.zzi = zzdd.zzn(zzdk0);
        }
        zzgy0.zzi.add(zzho0);
    }

    static void zzD(zzgy zzgy0, zzgr zzgr0) {
        zzgr0.getClass();
        zzgy0.zzj = zzgr0;
        zzgy0.zze |= 4;
    }

    static void zzE(zzgy zzgy0, boolean z) {
        zzgy0.zze |= 8;
        zzgy0.zzk = z;
    }

    static void zzF(zzgy zzgy0, boolean z) {
        zzgy0.zze |= 16;
        zzgy0.zzl = false;
    }

    static void zzG(zzgy zzgy0, Iterable iterable0) {
        zzdi zzdi0 = zzgy0.zzh;
        if(!zzdi0.zzc()) {
            int v = zzdi0.size();
            zzgy0.zzh = zzdi0.zzg((v == 0 ? 10 : v + v));
        }
        for(Object object0: iterable0) {
            zzgy0.zzh.zzh(((zzgv)object0).zza());
        }
    }

    static void zzH(zzgy zzgy0, int v) {
        zzgy0.zzg = v - 1;
        zzgy0.zze |= 2;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzgy.zzq(zzgy.zzd, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001B\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zze", "zzf", "zzg", zzgx.zza, "zzh", zzgu.zza, "zzi", zzho.class, "zzj", "zzk", "zzl"});
                }
                case 3: {
                    return new zzgy();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzgw(null);
                        }
                        case 5: {
                            return zzgy.zzd;
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

    public static zzgw zzz() {
        return (zzgw)zzgy.zzd.zzh();
    }
}

