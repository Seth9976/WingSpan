package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;
import java.util.concurrent.Future;

public final class zzu implements Runnable {
    public final Future zza;
    public final Runnable zzb;

    public zzu(Future future0, Runnable runnable0) {
        this.zza = future0;
        this.zzb = runnable0;
    }

    @Override
    public final void run() {
        Future future0 = this.zza;
        if(!future0.isDone() && !future0.isCancelled()) {
            Runnable runnable0 = this.zzb;
            future0.cancel(true);
            zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
            if(runnable0 != null) {
                runnable0.run();
            }
        }
    }
}

