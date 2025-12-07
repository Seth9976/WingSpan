package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzgq;

final class zzau extends ResultReceiver {
    final ExternalOfferInformationDialogListener zza;
    final BillingClientImpl zzb;

    zzau(BillingClientImpl billingClientImpl0, Handler handler0, ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) {
        this.zza = externalOfferInformationDialogListener0;
        this.zzb = billingClientImpl0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        Builder billingResult$Builder0 = BillingResult.newBuilder();
        billingResult$Builder0.setResponseCode(v);
        if(v != 0) {
            if(bundle0 == null) {
                zzgh zzgh0 = zzbx.zzb(97, 25, zzca.zzj);
                this.zzb.zzf.zza(zzgh0);
                this.zza.onExternalOfferInformationDialogResponse(zzca.zzj);
                return;
            }
            billingResult$Builder0.setDebugMessage(zzb.zzg(bundle0, "BillingClient"));
            int v1 = bundle0.getInt("INTERNAL_LOG_ERROR_REASON");
            this.zzb.zzf.zza(zzbx.zzc((v1 == 0 ? 23 : zzgq.zza(v1)), 25, billingResult$Builder0.build(), bundle0.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS")));
        }
        BillingResult billingResult0 = billingResult$Builder0.build();
        this.zza.onExternalOfferInformationDialogResponse(billingResult0);
    }
}

