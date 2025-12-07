package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzi;
import org.json.JSONException;

final class zzbg extends zzi {
    final BillingConfigResponseListener zza;
    final zzby zzb;

    zzbg(BillingConfigResponseListener billingConfigResponseListener0, zzby zzby0, zzbf zzbf0) {
        this.zza = billingConfigResponseListener0;
        this.zzb = zzby0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzj
    public final void zza(Bundle bundle0) throws RemoteException {
        if(bundle0 == null) {
            zzgh zzgh0 = zzbx.zzb(0x3F, 13, zzca.zzj);
            this.zzb.zza(zzgh0);
            this.zza.onBillingConfigResponse(zzca.zzj, null);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        String s = zzb.zzg(bundle0, "BillingClient");
        Builder billingResult$Builder0 = BillingResult.newBuilder();
        billingResult$Builder0.setResponseCode(v);
        billingResult$Builder0.setDebugMessage(s);
        if(v != 0) {
            zzb.zzk("BillingClient", "getBillingConfig() failed. Response code: " + v);
            BillingResult billingResult0 = billingResult$Builder0.build();
            zzgh zzgh1 = zzbx.zzb(23, 13, billingResult0);
            this.zzb.zza(zzgh1);
            this.zza.onBillingConfigResponse(billingResult0, null);
            return;
        }
        if(!bundle0.containsKey("BILLING_CONFIG")) {
            zzb.zzk("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            billingResult$Builder0.setResponseCode(6);
            BillingResult billingResult1 = billingResult$Builder0.build();
            zzgh zzgh2 = zzbx.zzb(0x40, 13, billingResult1);
            this.zzb.zza(zzgh2);
            this.zza.onBillingConfigResponse(billingResult1, null);
            return;
        }
        String s1 = bundle0.getString("BILLING_CONFIG");
        try {
            BillingConfig billingConfig0 = new BillingConfig(s1);
            BillingResult billingResult2 = billingResult$Builder0.build();
            this.zza.onBillingConfigResponse(billingResult2, billingConfig0);
        }
        catch(JSONException jSONException0) {
            zzb.zzl("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", jSONException0);
            zzgh zzgh3 = zzbx.zzb(65, 13, zzca.zzj);
            this.zzb.zza(zzgh3);
            this.zza.onBillingConfigResponse(zzca.zzj, null);
        }
    }
}

