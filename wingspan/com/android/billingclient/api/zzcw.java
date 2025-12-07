package com.android.billingclient.api;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

public final class zzcw implements ActivityResultCallback {
    public final ProxyBillingActivityV2 zza;

    public zzcw(ProxyBillingActivityV2 proxyBillingActivityV20) {
        this.zza = proxyBillingActivityV20;
    }

    @Override  // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object object0) {
        this.zza.zzb(((ActivityResult)object0));
    }
}

