package com.google.android.gms.drive;

@Deprecated
public final class zzn extends ExecutionOptions {
    private boolean zzat;

    private zzn(String s, boolean z, int v, boolean z1) {
        super(s, z, v);
        this.zzat = z1;
    }

    zzn(String s, boolean z, int v, boolean z1, zzo zzo0) {
        this(s, z, v, z1);
    }

    public static zzn zza(ExecutionOptions executionOptions0) {
        zzp zzp0 = new zzp();
        if(executionOptions0 != null) {
            zzp0.setConflictStrategy(executionOptions0.zzn());
            zzp0.setNotifyOnCompletion(executionOptions0.zzm());
            String s = executionOptions0.zzl();
            if(s != null) {
                zzp0.setTrackingTag(s);
            }
        }
        return (zzn)zzp0.build();
    }

    public final boolean zzp() {
        return this.zzat;
    }
}

