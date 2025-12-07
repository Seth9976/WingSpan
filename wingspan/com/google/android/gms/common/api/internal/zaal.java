package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

final class zaal implements ConnectionProgressReportCallbacks {
    private final WeakReference zaa;
    private final Api zab;
    private final boolean zac;

    public zaal(zaaw zaaw0, Api api0, boolean z) {
        this.zaa = new WeakReference(zaaw0);
        this.zab = api0;
        this.zac = z;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult0) {
        zaaw zaaw0 = (zaaw)this.zaa.get();
        if(zaaw0 == null) {
            return;
        }
        Preconditions.checkState(Looper.myLooper() == zaaw0.zaa.zag.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zaaw0.zab.lock();
        try {
            if(zaaw.zaw(zaaw0, 0)) {
                if(!connectionResult0.isSuccess()) {
                    zaaw0.zaE(connectionResult0, this.zab, this.zac);
                }
                if(zaaw0.zaH()) {
                    zaaw0.zaF();
                }
            }
        }
        finally {
            zaaw0.zab.unlock();
        }
    }
}

