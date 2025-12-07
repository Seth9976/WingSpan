package com.google.android.gms.internal.play_billing;

public final class zzho extends zzdd implements zzel {
    private static final zzho zzb;
    private int zzd;
    private zzdk zze;
    private int zzf;
    private String zzg;

    static {
        zzho zzho0 = new zzho();
        zzho.zzb = zzho0;
        zzdd.zzt(zzho.class, zzho0);
    }

    private zzho() {
        this.zze = zzdd.zzm();
        this.zzg = "";
    }

    static zzho zzA() {
        return zzho.zzb;
    }

    static void zzB(zzho zzho0, Iterable iterable0) {
        zzdk zzdk0 = zzho0.zze;
        if(!zzdk0.zzc()) {
            zzho0.zze = zzdd.zzn(zzdk0);
        }
        zzbm.zzc(iterable0, zzho0.zze);
    }

    static void zzC(zzho zzho0, int v) {
        zzho0.zzd |= 1;
        zzho0.zzf = v;
    }

    static void zzD(zzho zzho0, String s) {
        s.getClass();
        zzho0.zzd |= 2;
        zzho0.zzg = s;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzho.zzq(zzho.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001A\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
                }
                case 3: {
                    return new zzho();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzhn(null);
                        }
                        case 5: {
                            return zzho.zzb;
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

    public static zzhn zzz() {
        return (zzhn)zzho.zzb.zzh();
    }
}

