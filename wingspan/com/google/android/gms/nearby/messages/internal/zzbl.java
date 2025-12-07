package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

final class zzbl extends zzbv {
    private final Message zzil;
    private final zzbt zzim;
    private final PublishOptions zzin;

    zzbl(zzbi zzbi0, GoogleApiClient googleApiClient0, Message message0, zzbt zzbt0, PublishOptions publishOptions0) {
        this.zzil = message0;
        this.zzim = zzbt0;
        this.zzin = publishOptions0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final void doExecute(AnyClient api$AnyClient0) throws RemoteException {
        ((zzah)api$AnyClient0).zza(this.zzah(), zzaf.zza(this.zzil), this.zzim, this.zzin);
    }
}

