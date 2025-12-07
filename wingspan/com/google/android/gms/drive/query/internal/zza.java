package com.google.android.gms.drive.query.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.zzd;

public abstract class zza extends AbstractSafeParcelable implements Filter {
    @Override
    public String toString() {
        return String.format("Filter[%s]", this.zza(new zzd()));
    }
}

