package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbj {
    public static Looper zza(Looper looper0) {
        return looper0 == null ? zzbj.zzb() : looper0;
    }

    public static Looper zzb() {
        Preconditions.checkState(Looper.myLooper() != null, "Can\'t create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}

