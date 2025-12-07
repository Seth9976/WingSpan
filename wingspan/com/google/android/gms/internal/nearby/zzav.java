package com.google.android.gms.internal.nearby;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate.Builder;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import java.util.Map.Entry;
import java.util.Map;

final class zzav extends zzdx {
    private final ListenerHolder zzbv;
    private final Map zzbw;

    zzav(ListenerHolder listenerHolder0) {
        this.zzbw = new ArrayMap();
        this.zzbv = (ListenerHolder)Preconditions.checkNotNull(listenerHolder0);
    }

    final void shutdown() {
        synchronized(this) {
            for(Object object0: this.zzbw.entrySet()) {
                zzay zzay0 = new zzay(this, ((zzaz)((Map.Entry)object0).getKey()).zze(), ((PayloadTransferUpdate)((Map.Entry)object0).getValue()));
                this.zzbv.notifyListener(zzay0);
            }
            this.zzbw.clear();
        }
    }

    @Override  // com.google.android.gms.internal.nearby.zzdw
    public final void zza(zzev zzev0) {
        synchronized(this) {
            Payload payload0 = zzfl.zza(zzev0.zzl());
            if(payload0 == null) {
                Log.w("NearbyConnectionsClient", String.format("Failed to convert incoming ParcelablePayload %d to Payload.", zzev0.zzl().getId()));
                return;
            }
            zzaz zzaz0 = new zzaz(zzev0.zzg(), zzev0.zzl().getId());
            PayloadTransferUpdate payloadTransferUpdate0 = new Builder().setPayloadId(zzev0.zzl().getId()).build();
            this.zzbw.put(zzaz0, payloadTransferUpdate0);
            zzaw zzaw0 = new zzaw(this, zzev0, payload0);
            this.zzbv.notifyListener(zzaw0);
        }
    }

    @Override  // com.google.android.gms.internal.nearby.zzdw
    public final void zza(zzex zzex0) {
        synchronized(this) {
            if(zzex0.zzn().getStatus() == 3) {
                zzaz zzaz0 = new zzaz(zzex0.zzg(), zzex0.zzn().getPayloadId());
                this.zzbw.put(zzaz0, zzex0.zzn());
            }
            else {
                zzaz zzaz1 = new zzaz(zzex0.zzg(), zzex0.zzn().getPayloadId());
                this.zzbw.remove(zzaz1);
            }
            zzax zzax0 = new zzax(this, zzex0);
            this.zzbv.notifyListener(zzax0);
        }
    }
}

