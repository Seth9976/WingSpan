package com.google.android.gms.internal.drive;

public abstract class zziu implements zzlr {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return this.zzbn();
    }

    protected abstract zziu zza(zzit arg1);

    @Override  // com.google.android.gms.internal.drive.zzlr
    public final zzlr zza(zzlq zzlq0) {
        if(!this.zzda().getClass().isInstance(zzlq0)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return this.zza(((zzit)zzlq0));
    }

    public abstract zziu zzbn();
}

