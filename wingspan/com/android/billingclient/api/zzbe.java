package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzg;
import java.lang.ref.WeakReference;

final class zzbe extends zzg {
    final WeakReference zza;
    final ResultReceiver zzb;

    zzbe(WeakReference weakReference0, ResultReceiver resultReceiver0, zzbd zzbd0) {
        this.zza = weakReference0;
        this.zzb = resultReceiver0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzh
    public final void zza(Bundle bundle0) throws RemoteException {
        if(bundle0 == null) {
            this.zzb.send(6, null);
            return;
        }
        if(!bundle0.containsKey("RESPONSE_CODE")) {
            zzb.zzk("BillingClient", "Response bundle doesn\'t contain a response code");
            this.zzb.send(6, bundle0);
            return;
        }
        int v = zzb.zzb(bundle0, "BillingClient");
        if(v != 0) {
            zzb.zzk("BillingClient", "Unable to launch intent for alternative billing only dialog" + v);
            this.zzb.send(v, bundle0);
            return;
        }
        PendingIntent pendingIntent0 = (PendingIntent)bundle0.getParcelable("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
        if(pendingIntent0 == null) {
            zzb.zzj("BillingClient", "User has acknowledged the alternative billing only dialog before.");
            this.zzb.send(0, bundle0);
            return;
        }
        try {
            Activity activity0 = (Activity)this.zza.get();
            Intent intent0 = new Intent(activity0, ProxyBillingActivityV2.class);
            intent0.putExtra("alternative_billing_only_dialog_result_receiver", this.zzb);
            intent0.putExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT", pendingIntent0);
            activity0.startActivity(intent0);
        }
        catch(RuntimeException runtimeException0) {
            zzb.zzl("BillingClient", "Runtime error while launching intent for alternative billing only dialog.", runtimeException0);
            Bundle bundle1 = new Bundle();
            bundle1.putInt("RESPONSE_CODE", 6);
            bundle1.putString("DEBUG_MESSAGE", "An internal error occurred.");
            bundle1.putInt("INTERNAL_LOG_ERROR_REASON", 75);
            bundle1.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("%s: %s", runtimeException0.getClass().getName(), zzab.zzb(runtimeException0.getMessage())));
            this.zzb.send(6, bundle1);
        }
    }
}

