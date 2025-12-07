package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzbl implements ResultCallback {
    zzbl(zzbi zzbi0) {
    }

    @Override  // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result0) {
        if(!((Status)result0).isSuccess()) {
            zzbi.zzbz.efmt("DriveContentsImpl", "Error discarding contents, status: %s", new Object[]{((Status)result0)});
        }
    }
}

