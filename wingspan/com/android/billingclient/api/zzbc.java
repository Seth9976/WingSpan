package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzgh;
import org.json.JSONException;

final class zzbc extends zze {
    final ExternalOfferReportingDetailsListener zza;
    final zzby zzb;

    zzbc(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener0, zzby zzby0, zzbb zzbb0) {
        this.zza = externalOfferReportingDetailsListener0;
        this.zzb = zzby0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzf
    public final void zza(Bundle bundle0) throws RemoteException {
        ExternalOfferReportingDetails externalOfferReportingDetails0;
        if(bundle0 == null) {
            zzgh zzgh0 = zzbx.zzb(0x5F, 24, zzca.zzj);
            this.zzb.zza(zzgh0);
            this.zza.onExternalOfferReportingDetailsResponse(zzca.zzj, null);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult0 = zzca.zza(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", "createExternalOfferReportingDetailsAsync() failed. Response code: " + v);
            zzgh zzgh1 = zzbx.zzb(23, 24, billingResult0);
            this.zzb.zza(zzgh1);
            this.zza.onExternalOfferReportingDetailsResponse(billingResult0, null);
            return;
        }
        String s = bundle0.getString("CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS");
        try {
            externalOfferReportingDetails0 = new ExternalOfferReportingDetails(s);
        }
        catch(JSONException jSONException0) {
            zzb.zzl("BillingClient", "Error when parsing invalid external offer reporting details. \n Exception: ", jSONException0);
            zzgh zzgh2 = zzbx.zzb(104, 24, zzca.zzj);
            this.zzb.zza(zzgh2);
            this.zza.onExternalOfferReportingDetailsResponse(zzca.zzj, null);
            return;
        }
        this.zza.onExternalOfferReportingDetailsResponse(billingResult0, externalOfferReportingDetails0);
    }
}

