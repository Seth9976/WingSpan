package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;

final class zzas extends ResultReceiver {
    final InAppMessageResponseListener zza;

    zzas(BillingClientImpl billingClientImpl0, Handler handler0, InAppMessageResponseListener inAppMessageResponseListener0) {
        this.zza = inAppMessageResponseListener0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        InAppMessageResult inAppMessageResult0 = zzb.zzf(bundle0, "BillingClient");
        this.zza.onInAppMessageResponse(inAppMessageResult0);
    }
}

