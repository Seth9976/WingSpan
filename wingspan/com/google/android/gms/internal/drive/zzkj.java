package com.google.android.gms.internal.drive;

final class zzkj implements zzlp {
    private static final zzkj zzrp;

    static {
        zzkj.zzrp = new zzkj();
    }

    @Override  // com.google.android.gms.internal.drive.zzlp
    public final boolean zzb(Class class0) {
        return zzkk.class.isAssignableFrom(class0);
    }

    @Override  // com.google.android.gms.internal.drive.zzlp
    public final zzlo zzc(Class class0) {
        if(!zzkk.class.isAssignableFrom(class0)) {
            String s = class0.getName();
            throw new IllegalArgumentException((s.length() == 0 ? new String("Unsupported message type: ") : "Unsupported message type: " + s));
        }
        try {
            return (zzlo)zzkk.zzd(class0.asSubclass(zzkk.class)).zza(zze.zzrz, null, null);
        }
        catch(Exception exception0) {
            String s1 = class0.getName();
            throw new RuntimeException((s1.length() == 0 ? new String("Unable to get message info for ") : "Unable to get message info for " + s1), exception0);
        }
    }

    public static zzkj zzcv() {
        return zzkj.zzrp;
    }
}

