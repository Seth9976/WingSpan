package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzk;
import java.lang.ref.WeakReference;

final class zzbi extends zzk {
    final WeakReference zza;
    final ResultReceiver zzb;

    zzbi(WeakReference weakReference0, ResultReceiver resultReceiver0, zzbh zzbh0) {
        this.zza = weakReference0;
        this.zzb = resultReceiver0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzl
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
            zzb.zzk("BillingClient", "Unable to launch intent for external offer dialog" + v);
            this.zzb.send(v, bundle0);
            return;
        }
        PendingIntent pendingIntent0 = (PendingIntent)bundle0.getParcelable("EXTERNAL_PAYMENT_DIALOG_INTENT");
        if(pendingIntent0 == null) {
            zzb.zzk("BillingClient", "The PendingIntent for the external offer dialog is null");
            Bundle bundle1 = new Bundle();
            bundle1.putInt("RESPONSE_CODE", 6);
            bundle1.putString("DEBUG_MESSAGE", "An internal error occurred.");
            this.zzb.send(6, bundle1);
            return;
        }
        try {
            Activity activity0 = (Activity)this.zza.get();
            Intent intent0 = new Intent(activity0, ProxyBillingActivityV2.class);
            intent0.putExtra("external_payment_dialog_result_receiver", this.zzb);
            intent0.putExtra("external_payment_dialog_pending_intent", pendingIntent0);
            activity0.startActivity(intent0);
        }
        catch(RuntimeException runtimeException0) {
            zzb.zzl("BillingClient", "Runtime error while launching intent for the external offer dialog.", runtimeException0);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("RESPONSE_CODE", 6);
            bundle2.putString("DEBUG_MESSAGE", "An internal error occurred.");
            bundle2.putInt("INTERNAL_LOG_ERROR_REASON", 98);
            bundle2.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("%s: %s", runtimeException0.getClass().getName(), zzab.zzb(runtimeException0.getMessage())));
            this.zzb.send(6, bundle2);
        }
    }
}

