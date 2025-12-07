package com.google.android.gms.internal.play_billing;

final class zzcy implements zzei {
    private static final zzcy zza;

    static {
        zzcy.zza = new zzcy();
    }

    public static zzcy zza() {
        return zzcy.zza;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzei
    public final zzeh zzb(Class class0) {
        if(zzdd.class.isAssignableFrom(class0)) {
            try {
                return (zzeh)zzdd.zzi(class0.asSubclass(zzdd.class)).zzy(3, null, null);
            }
            catch(Exception exception0) {
                throw new RuntimeException("Unable to get message info for " + class0.getName(), exception0);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + class0.getName());
    }

    @Override  // com.google.android.gms.internal.play_billing.zzei
    public final boolean zzc(Class class0) {
        return zzdd.class.isAssignableFrom(class0);
    }
}

