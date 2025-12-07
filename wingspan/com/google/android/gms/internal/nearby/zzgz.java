package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzgz extends zzha {
    private final Status zzbj;

    zzgz(zzgy zzgy0, Status status0) {
        this.zzbj = status0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        if(this.zzbj.isSuccess()) {
            ((ResultHolder)object0).setResult(this.zzbj);
            return;
        }
        ((ResultHolder)object0).setFailedResult(this.zzbj);
    }
}

