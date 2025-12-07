package com.android.billingclient.api;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

public final class zzcv implements ActivityResultCallback {
    public final ProxyBillingActivityV2 zza;

    public zzcv(ProxyBillingActivityV2 proxyBillingActivityV20) {
        this.zza = proxyBillingActivityV20;
    }

    @Override  // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object object0) {
        this.zza.zza(((ActivityResult)object0));
    }
}

