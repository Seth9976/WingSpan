package com.android.billingclient.api;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import java.util.concurrent.Callable;

public final class zzal implements Callable {
    public final BillingClientImpl zza;
    public final Bundle zzb;
    public final Activity zzc;
    public final ResultReceiver zzd;

    public zzal(BillingClientImpl billingClientImpl0, Bundle bundle0, Activity activity0, ResultReceiver resultReceiver0) {
        this.zza = billingClientImpl0;
        this.zzb = bundle0;
        this.zzc = activity0;
        this.zzd = resultReceiver0;
    }

    @Override
    public final Object call() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd);
        return null;
    }
}

