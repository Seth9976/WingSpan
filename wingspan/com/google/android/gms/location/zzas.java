package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

final class zzas implements RemoteCall {
    private final List zza;

    zzas(List list0) {
        this.zza = list0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzat zzat0 = new zzat(((TaskCompletionSource)object1));
        ((zzaz)object0).zzy(this.zza, zzat0);
    }
}

