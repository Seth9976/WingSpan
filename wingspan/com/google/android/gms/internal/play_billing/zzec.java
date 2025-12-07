package com.google.android.gms.internal.play_billing;

final class zzec implements zzew {
    private static final zzei zza;
    private final zzei zzb;

    static {
        zzec.zza = new zzea();
    }

    public zzec() {
        zzei zzei0;
        zzei[] arr_zzei;
        try {
            arr_zzei = new zzei[]{zzcy.zza(), null};
            zzei0 = (zzei)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance").invoke(null);
        }
        catch(Exception unused_ex) {
            zzei0 = zzec.zza;
        }
        arr_zzei[1] = zzei0;
        zzeb zzeb0 = new zzeb(arr_zzei);
        super();
        this.zzb = zzeb0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzew
    public final zzev zza(Class class0) {
        zzex.zzq(class0);
        zzeh zzeh0 = this.zzb.zzb(class0);
        if(zzeh0.zzb()) {
            return zzdd.class.isAssignableFrom(class0) ? zzeo.zzc(zzex.zzn(), zzcs.zzb(), zzeh0.zza()) : zzeo.zzc(zzex.zzm(), zzcs.zza(), zzeh0.zza());
        }
        if(zzdd.class.isAssignableFrom(class0)) {
            return zzec.zzb(zzeh0) ? zzen.zzl(class0, zzeh0, zzeq.zzb(), zzdy.zzd(), zzex.zzn(), zzcs.zzb(), zzeg.zzb()) : zzen.zzl(class0, zzeh0, zzeq.zzb(), zzdy.zzd(), zzex.zzn(), null, zzeg.zzb());
        }
        return zzec.zzb(zzeh0) ? zzen.zzl(class0, zzeh0, zzeq.zza(), zzdy.zzc(), zzex.zzm(), zzcs.zza(), zzeg.zza()) : zzen.zzl(class0, zzeh0, zzeq.zza(), zzdy.zzc(), zzex.zzm(), null, zzeg.zza());
    }

    private static boolean zzb(zzeh zzeh0) {
        return zzeh0.zzc() - 1 != 1;
    }
}

