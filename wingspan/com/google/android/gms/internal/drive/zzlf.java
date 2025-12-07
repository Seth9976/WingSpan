package com.google.android.gms.internal.drive;

final class zzlf implements zzmg {
    private final zzlp zztr;
    private static final zzlp zzts;

    static {
        zzlf.zzts = new zzlg();
    }

    public zzlf() {
        this(new zzlh(new zzlp[]{zzkj.zzcv(), zzlf.zzdv()}));
    }

    private zzlf(zzlp zzlp0) {
        this.zztr = (zzlp)zzkm.zza(zzlp0, "messageInfoFactory");
    }

    private static boolean zza(zzlo zzlo0) {
        return zzlo0.zzec() == zze.zzsf;
    }

    private static zzlp zzdv() {
        try {
            return (zzlp)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance").invoke(null);
        }
        catch(Exception unused_ex) {
            return zzlf.zzts;
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzmg
    public final zzmf zze(Class class0) {
        zzmh.zzg(class0);
        zzlo zzlo0 = this.zztr.zzc(class0);
        if(zzlo0.zzed()) {
            return zzkk.class.isAssignableFrom(class0) ? zzlw.zza(zzmh.zzeo(), zzka.zzcl(), zzlo0.zzee()) : zzlw.zza(zzmh.zzem(), zzka.zzcm(), zzlo0.zzee());
        }
        if(zzkk.class.isAssignableFrom(class0)) {
            return zzlf.zza(zzlo0) ? zzlu.zza(class0, zzlo0, zzma.zzeh(), zzla.zzdu(), zzmh.zzeo(), zzka.zzcl(), zzln.zzea()) : zzlu.zza(class0, zzlo0, zzma.zzeh(), zzla.zzdu(), zzmh.zzeo(), null, zzln.zzea());
        }
        return zzlf.zza(zzlo0) ? zzlu.zza(class0, zzlo0, zzma.zzeg(), zzla.zzdt(), zzmh.zzem(), zzka.zzcm(), zzln.zzdz()) : zzlu.zza(class0, zzlo0, zzma.zzeg(), zzla.zzdt(), zzmh.zzen(), null, zzln.zzdz());
    }
}

