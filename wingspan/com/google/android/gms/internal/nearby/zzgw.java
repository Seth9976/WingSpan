package com.google.android.gms.internal.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.internal.Update;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzn;
import java.util.Collections;
import java.util.List;

public final class zzgw extends zzn {
    private final ListenerHolder zzjj;

    public zzgw(ListenerHolder listenerHolder0) {
        this.zzjj = listenerHolder0;
    }

    public static void zza(Intent intent0, MessageListener messageListener0) {
        Bundle bundle0 = intent0.getBundleExtra("com.google.android.gms.nearby.messages.UPDATES");
        List list0 = bundle0 == null ? Collections.emptyList() : bundle0.getParcelableArrayList("com.google.android.gms.nearby.messages.UPDATES");
        zzgw.zza(list0, messageListener0);
    }

    public static void zza(Iterable iterable0, MessageListener messageListener0) {
        for(Object object0: iterable0) {
            boolean z = !((Update)object0).zzg(1);
            boolean z1 = !((Update)object0).zzg(2);
            boolean z2 = !((Update)object0).zzg(4);
            if(((Update)object0).zzg(8)) {
            }
        }
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(zzaf zzaf0) {
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzm
    public final void zza(List list0) throws RemoteException {
        zzgx zzgx0 = new zzgx(this, list0);
        this.zzjj.notifyListener(zzgx0);
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzm
    public final void zzb(zzaf zzaf0) {
    }
}

