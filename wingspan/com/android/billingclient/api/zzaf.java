package com.android.billingclient.api;

import android.app.Activity;
import android.os.ResultReceiver;
import java.util.concurrent.Callable;

public final class zzaf implements Callable {
    public final BillingClientImpl zza;
    public final Activity zzb;
    public final ResultReceiver zzc;
    public final ExternalOfferInformationDialogListener zzd;

    public zzaf(BillingClientImpl billingClientImpl0, Activity activity0, ResultReceiver resultReceiver0, ExternalOfferInformationDialogListener externalOfferInformationDialogListener0) {
        this.zza = billingClientImpl0;
        this.zzb = activity0;
        this.zzc = resultReceiver0;
        this.zzd = externalOfferInformationDialogListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzv(this.zzb, this.zzc, this.zzd);
        return null;
    }
}

