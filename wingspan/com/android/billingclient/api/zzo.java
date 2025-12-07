package com.android.billingclient.api;

import android.app.Activity;
import android.os.ResultReceiver;
import java.util.concurrent.Callable;

public final class zzo implements Callable {
    public final BillingClientImpl zza;
    public final Activity zzb;
    public final ResultReceiver zzc;
    public final AlternativeBillingOnlyInformationDialogListener zzd;

    public zzo(BillingClientImpl billingClientImpl0, Activity activity0, ResultReceiver resultReceiver0, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) {
        this.zza = billingClientImpl0;
        this.zzb = activity0;
        this.zzc = resultReceiver0;
        this.zzd = alternativeBillingOnlyInformationDialogListener0;
    }

    @Override
    public final Object call() {
        this.zza.zzu(this.zzb, this.zzc, this.zzd);
        return null;
    }
}

