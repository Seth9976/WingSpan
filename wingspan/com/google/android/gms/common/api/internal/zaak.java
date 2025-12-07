package com.google.android.gms.common.api.internal;

final class zaak implements Runnable {
    final zaaw zaa;

    zaak(zaaw zaaw0) {
        this.zaa = zaaw0;
        super();
    }

    @Override
    public final void run() {
        this.zaa.zad.cancelAvailabilityErrorNotifications(this.zaa.zac);
    }
}

