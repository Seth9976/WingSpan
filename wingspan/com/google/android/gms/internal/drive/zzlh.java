package com.google.android.gms.internal.drive;

final class zzlh implements zzlp {
    private zzlp[] zztt;

    zzlh(zzlp[] arr_zzlp) {
        this.zztt = arr_zzlp;
    }

    @Override  // com.google.android.gms.internal.drive.zzlp
    public final boolean zzb(Class class0) {
        zzlp[] arr_zzlp = this.zztt;
        for(int v = 0; v < arr_zzlp.length; ++v) {
            if(arr_zzlp[v].zzb(class0)) {
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.drive.zzlp
    public final zzlo zzc(Class class0) {
        zzlp[] arr_zzlp = this.zztt;
        for(int v = 0; v < arr_zzlp.length; ++v) {
            zzlp zzlp0 = arr_zzlp[v];
            if(zzlp0.zzb(class0)) {
                return zzlp0.zzc(class0);
            }
        }
        String s = class0.getName();
        throw new UnsupportedOperationException((s.length() == 0 ? new String("No factory is available for message type: ") : "No factory is available for message type: " + s));
    }
}

