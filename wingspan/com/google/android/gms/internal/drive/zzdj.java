package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.OnChangeListener;

final class zzdj implements ChangeListener {
    private final OnChangeListener zzgi;

    private zzdj(OnChangeListener onChangeListener0) {
        this.zzgi = onChangeListener0;
    }

    @Override  // com.google.android.gms.drive.events.ChangeListener
    public final void onChange(ChangeEvent changeEvent0) {
        this.zzgi.onChange(changeEvent0);
    }

    static ChangeListener zza(OnChangeListener onChangeListener0) {
        return new zzdj(onChangeListener0);
    }
}

