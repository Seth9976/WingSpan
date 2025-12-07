package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhl;

final class zzcf {
    private boolean zza;
    private Transport zzb;

    zzcf(Context context0) {
        try {
            TransportRuntime.initialize(context0);
            TransportFactory transportFactory0 = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE);
            Encoding encoding0 = Encoding.of("proto");
            this.zzb = transportFactory0.getTransport("PLAY_BILLING_LIBRARY", zzhl.class, encoding0, (zzce this) -> ((zzhl)object0).zzd());
        }
        catch(Throwable unused_ex) {
            this.zza = true;
        }
    }

    public final void zza(zzhl zzhl0) {
        if(this.zza) {
            zzb.zzk("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.zzb.send(Event.ofData(zzhl0));
        }
        catch(Throwable unused_ex) {
            zzb.zzk("BillingLogger", "logging failed.");
        }
    }
}

