package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zau;

final class zacz extends zau {
    final zada zaa;

    public zacz(zada zada0, Looper looper0) {
        this.zaa = zada0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        switch(message0.what) {
            case 0: {
                PendingResult pendingResult0 = (PendingResult)message0.obj;
                Object object0 = this.zaa.zae;
                synchronized(object0) {
                    zada zada0 = (zada)Preconditions.checkNotNull(this.zaa.zab);
                    if(pendingResult0 == null) {
                        zada0.zaj(new Status(13, "Transform returned null"));
                    }
                    else if(pendingResult0 instanceof zacp) {
                        zada0.zaj(((zacp)pendingResult0).zaa());
                    }
                    else {
                        zada0.zai(pendingResult0);
                    }
                }
                return;
            }
            case 1: {
                RuntimeException runtimeException0 = (RuntimeException)message0.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: " + runtimeException0.getMessage());
                throw runtimeException0;
            }
            default: {
                Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message0.what);
            }
        }
    }
}

