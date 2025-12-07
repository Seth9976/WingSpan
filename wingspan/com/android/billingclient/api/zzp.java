package com.android.billingclient.api;

public final class zzp implements Runnable {
    public final BillingClientImpl zza;
    public final AlternativeBillingOnlyInformationDialogListener zzb;

    public zzp(BillingClientImpl billingClientImpl0, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener0) {
        this.zza = billingClientImpl0;
        this.zzb = alternativeBillingOnlyInformationDialogListener0;
    }

    @Override
    public final void run() {
        this.zza.zzac(this.zzb);
    }
}

