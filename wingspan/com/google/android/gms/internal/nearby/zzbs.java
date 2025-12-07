package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

final class zzbs implements OnFailureListener {
    private final String zzbm;
    private final zzbd zzcq;

    zzbs(zzbd zzbd0, String s) {
        this.zzcq = zzbd0;
        this.zzbm = s;
        super();
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        if(exception0 instanceof ApiException && ((ApiException)exception0).getStatusCode() == 8003) {
            return;
        }
        this.zzcq.zzc(this.zzbm);
    }
}

