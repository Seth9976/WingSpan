package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzai;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzcp;
import com.google.android.gms.internal.play_billing.zzgh;
import com.google.android.gms.internal.play_billing.zzgl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;

final class zzj extends BroadcastReceiver {
    final zzk zza;
    private boolean zzb;
    private final boolean zzc;
    private boolean zzd;

    zzj(zzk zzk0, boolean z) {
        this.zza = zzk0;
        super();
        this.zzc = z;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        Bundle bundle0 = intent0.getExtras();
        if(bundle0 == null) {
            zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            zzgh zzgh0 = zzbx.zzb(11, 1, zzca.zzj);
            this.zza.zze.zza(zzgh0);
            zzk zzk0 = this.zza;
            if(zzk0.zzb == null) {
                return;
            }
            zzk0.zzb.onPurchasesUpdated(zzca.zzj, null);
            return;
        }
        BillingResult billingResult0 = zzb.zze(intent0, "BillingBroadcastManager");
        String s = intent0.getAction();
        int v = Objects.equals(bundle0.getString("INTENT_SOURCE"), "LAUNCH_BILLING_FLOW") ? 2 : 1;
        if(bundle0.getByteArray("BROADCAST_RECEIVER_LOGGING_PAYLOAD") != null) {
            try {
                byte[] arr_b = bundle0.getByteArray("BROADCAST_RECEIVER_LOGGING_PAYLOAD");
                this.zza.zze.zzc(arr_b);
            }
            catch(Throwable unused_ex) {
                zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
            }
        }
        if(!s.equals("com.android.vending.billing.PURCHASES_UPDATED") && !s.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            if(s.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                zzai zzai0 = zzai.zzl(zzbx.zza(s));
                this.zza.zze.zze(4, zzai0, false, this.zzd);
                if(billingResult0.getResponseCode() != 0) {
                    this.zzc(bundle0, billingResult0, v);
                    this.zza.zzb.onPurchasesUpdated(billingResult0, zzai.zzk());
                    return;
                }
                if(this.zza.zzc == null && this.zza.zzd == null) {
                    zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                    zzgh zzgh1 = zzbx.zzb(77, v, zzca.zzj);
                    this.zza.zze.zza(zzgh1);
                    this.zza.zzb.onPurchasesUpdated(zzca.zzj, zzai.zzk());
                    return;
                }
                String s1 = bundle0.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if(s1 != null) {
                    try {
                        if(this.zza.zzd == null) {
                            AlternativeChoiceDetails alternativeChoiceDetails0 = new AlternativeChoiceDetails(s1);
                            this.zza.zzc.userSelectedAlternativeBilling(alternativeChoiceDetails0);
                        }
                        else {
                            UserChoiceDetails userChoiceDetails0 = new UserChoiceDetails(s1);
                            this.zza.zzd.userSelectedAlternativeBilling(userChoiceDetails0);
                        }
                    }
                    catch(JSONException unused_ex) {
                        zzb.zzk("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", s1));
                        zzgh zzgh2 = zzbx.zzb(17, v, zzca.zzj);
                        this.zza.zze.zza(zzgh2);
                        this.zza.zzb.onPurchasesUpdated(zzca.zzj, zzai.zzk());
                        return;
                    }
                    zzgl zzgl0 = zzbx.zzd(v);
                    this.zza.zze.zzb(zzgl0);
                    return;
                }
                zzb.zzk("BillingBroadcastManager", "Couldn\'t find alternative billing user choice data in bundle.");
                zzgh zzgh3 = zzbx.zzb(16, v, zzca.zzj);
                this.zza.zze.zza(zzgh3);
                this.zza.zzb.onPurchasesUpdated(zzca.zzj, zzai.zzk());
            }
            return;
        }
        List list0 = zzb.zzi(bundle0);
        if(billingResult0.getResponseCode() == 0) {
            zzgl zzgl1 = zzbx.zzd(v);
            this.zza.zze.zzb(zzgl1);
        }
        else {
            this.zzc(bundle0, billingResult0, v);
        }
        zzai zzai1 = zzai.zzl(zzbx.zza(s));
        this.zza.zze.zzf(4, zzai1, list0, billingResult0, false, this.zzd);
        this.zza.zzb.onPurchasesUpdated(billingResult0, list0);
    }

    public final void zza(Context context0, IntentFilter intentFilter0) {
        synchronized(this) {
            if(this.zzb) {
                return;
            }
            this.zzd = this.zza.zzh;
            zzby zzby0 = this.zza.zze;
            ArrayList arrayList0 = new ArrayList();
            for(int v1 = 0; v1 < intentFilter0.countActions(); ++v1) {
                arrayList0.add(zzbx.zza(intentFilter0.getAction(v1)));
            }
            int v2 = 2;
            zzby0.zze(2, arrayList0, false, this.zzd);
            if(Build.VERSION.SDK_INT >= 33) {
                if(!this.zzc) {
                    v2 = 4;
                }
                context0.registerReceiver(this, intentFilter0, v2);
            }
            else {
                context0.registerReceiver(this, intentFilter0);
            }
            this.zzb = true;
        }
    }

    public final void zzb(Context context0) {
        synchronized(this) {
            if(this.zzb) {
                context0.unregisterReceiver(this);
                this.zzb = false;
                return;
            }
            zzb.zzk("BillingBroadcastManager", "Receiver is not registered.");
        }
    }

    private final void zzc(Bundle bundle0, BillingResult billingResult0, int v) {
        if(bundle0.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
            try {
                this.zza.zze.zza(zzgh.zzB(bundle0.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzcp.zza()));
            }
            catch(Throwable unused_ex) {
                zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
            }
            return;
        }
        this.zza.zze.zza(zzbx.zzb(23, v, billingResult0));
    }
}

