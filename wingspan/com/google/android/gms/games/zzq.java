package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

public class zzq extends DataBufferRef {
    public zzq(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
    }

    // 去混淆评级： 低(20)
    protected final int zzq(String s, int v) {
        return !this.hasColumn(s) || this.hasNull(s) ? v : this.getInteger(s);
    }

    // 去混淆评级： 低(20)
    protected final String zzr(String s, String s1) {
        return !this.hasColumn(s) || this.hasNull(s) ? null : this.getString(s);
    }
}

