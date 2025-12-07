package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzgh;
import org.json.JSONException;

final class zzba extends zzc {
    final AlternativeBillingOnlyReportingDetailsListener zza;
    final zzby zzb;

    zzba(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener0, zzby zzby0, zzaz zzaz0) {
        this.zza = alternativeBillingOnlyReportingDetailsListener0;
        this.zzb = zzby0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzd
    public final void zza(Bundle bundle0) throws RemoteException {
        AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails0;
        if(bundle0 == null) {
            zzgh zzgh0 = zzbx.zzb(71, 15, zzca.zzj);
            this.zzb.zza(zzgh0);
            this.zza.onAlternativeBillingOnlyTokenResponse(zzca.zzj, null);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        BillingResult billingResult0 = zzca.zza(v, zzb.zzg(bundle0, "BillingClient"));
        if(v != 0) {
            zzb.zzk("BillingClient", "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: " + v);
            zzgh zzgh1 = zzbx.zzb(23, 15, billingResult0);
            this.zzb.zza(zzgh1);
            this.zza.onAlternativeBillingOnlyTokenResponse(billingResult0, null);
            return;
        }
        String s = bundle0.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS");
        try {
            alternativeBillingOnlyReportingDetails0 = new AlternativeBillingOnlyReportingDetails(s);
        }
        catch(JSONException jSONException0) {
            zzb.zzl("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", jSONException0);
            zzgh zzgh2 = zzbx.zzb(72, 15, zzca.zzj);
            this.zzb.zza(zzgh2);
            this.zza.onAlternativeBillingOnlyTokenResponse(zzca.zzj, null);
            return;
        }
        this.zza.onAlternativeBillingOnlyTokenResponse(billingResult0, alternativeBillingOnlyReportingDetails0);
    }
}

