package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.OnFailureListener;

final class zzl implements OnFailureListener {
    private final RegisterListenerMethod zzap;
    private final zzk zzaq;

    zzl(zzk zzk0, RegisterListenerMethod registerListenerMethod0) {
        this.zzaq = zzk0;
        this.zzap = registerListenerMethod0;
        super();
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        synchronized(this.zzaq) {
            this.zzaq.zzan.remove(this.zzap.getListenerKey());
        }
    }
}

