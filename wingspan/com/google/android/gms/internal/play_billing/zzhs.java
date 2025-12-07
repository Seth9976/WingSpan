package com.google.android.gms.internal.play_billing;

public final class zzhs extends zzdd implements zzel {
    private static final zzhs zzb;
    private int zzd;
    private int zze;

    static {
        zzhs zzhs0 = new zzhs();
        zzhs.zzb = zzhs0;
        zzdd.zzt(zzhs.class, zzhs0);
    }

    public static zzhs zzA() {
        return zzhs.zzb;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdd
    protected final Object zzy(int v, Object object0, Object object1) {
        if(v - 1 != 0) {
            switch(v - 1) {
                case 2: {
                    return zzhs.zzq(zzhs.zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzhr.zza});
                }
                case 3: {
                    return new zzhs();
                }
                default: {
                    switch(v - 1) {
                        case 4: {
                            return new zzhq(null);
                        }
                        case 5: {
                            return zzhs.zzb;
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

    static zzhs zzz() {
        return zzhs.zzb;
    }
}

