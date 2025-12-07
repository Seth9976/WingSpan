package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate.Builder;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

final class zzay extends zzau {
    private final String zzbm;
    private final PayloadTransferUpdate zzbz;

    zzay(zzav zzav0, String s, PayloadTransferUpdate payloadTransferUpdate0) {
        this.zzbm = s;
        this.zzbz = payloadTransferUpdate0;
        super(null);
    }

    @Override  // com.google.android.gms.common.api.internal.ListenerHolder$Notifier
    public final void notifyListener(Object object0) {
        PayloadTransferUpdate payloadTransferUpdate0 = new Builder(this.zzbz).setStatus(2).build();
        ((PayloadCallback)object0).onPayloadTransferUpdate(this.zzbm, payloadTransferUpdate0);
    }
}

