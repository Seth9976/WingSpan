package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzt;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

final class zzbo extends zzt {
    final WeakReference zza;
    final ResultReceiver zzb;

    zzbo(WeakReference weakReference0, ResultReceiver resultReceiver0, zzbn zzbn0) {
        this.zza = weakReference0;
        this.zzb = resultReceiver0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzu
    public final void zza(Bundle bundle0) throws RemoteException {
        ResultReceiver resultReceiver0 = this.zzb;
        if(resultReceiver0 == null) {
            zzb.zzk("BillingClient", "Unable to send result for in-app messaging");
            return;
        }
        if(bundle0 == null) {
            resultReceiver0.send(0, null);
            return;
        }
        Activity activity0 = (Activity)this.zza.get();
        PendingIntent pendingIntent0 = (PendingIntent)bundle0.getParcelable("KEY_LAUNCH_INTENT");
        if(activity0 != null && pendingIntent0 != null) {
            try {
                Intent intent0 = new Intent(activity0, ProxyBillingActivity.class);
                intent0.putExtra("in_app_message_result_receiver", this.zzb);
                intent0.putExtra("IN_APP_MESSAGE_INTENT", pendingIntent0);
                activity0.startActivity(intent0);
            }
            catch(CancellationException cancellationException0) {
                this.zzb.send(0, null);
                zzb.zzl("BillingClient", "Exception caught while launching intent for in-app messaging.", cancellationException0);
            }
            return;
        }
        this.zzb.send(0, null);
        zzb.zzk("BillingClient", "Unable to launch intent for in-app messaging");
    }
}

