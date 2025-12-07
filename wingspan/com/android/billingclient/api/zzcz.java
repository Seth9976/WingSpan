package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.ArrayList;

final class zzcz {
    static zzcy zza(Bundle bundle0, String s, String s1) {
        BillingResult billingResult0 = zzca.zzj;
        if(bundle0 == null) {
            zzb.zzk("BillingClient", String.format("%s got null owned items list", s1));
            return new zzcy(billingResult0, 54);
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        String s2 = zzb.zzg(bundle0, "BillingClient");
        Builder billingResult$Builder0 = BillingResult.newBuilder();
        billingResult$Builder0.setResponseCode(v);
        billingResult$Builder0.setDebugMessage(s2);
        BillingResult billingResult1 = billingResult$Builder0.build();
        if(v != 0) {
            zzb.zzk("BillingClient", String.format("%s failed. Response code: %s", s1, v));
            return new zzcy(billingResult1, 23);
        }
        if(bundle0.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundle0.containsKey("INAPP_PURCHASE_DATA_LIST") && bundle0.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList arrayList0 = bundle0.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arrayList1 = bundle0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arrayList2 = bundle0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            if(arrayList0 == null) {
                zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", s1));
                return new zzcy(billingResult0, 56);
            }
            if(arrayList1 == null) {
                zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null purchases list.", s1));
                return new zzcy(billingResult0, 57);
            }
            if(arrayList2 == null) {
                zzb.zzk("BillingClient", String.format("Bundle returned from %s contains null signatures list.", s1));
                return new zzcy(billingResult0, 58);
            }
            return new zzcy(zzca.zzl, 1);
        }
        zzb.zzk("BillingClient", String.format("Bundle returned from %s doesn\'t contain required fields.", s1));
        return new zzcy(billingResult0, 55);
    }
}

