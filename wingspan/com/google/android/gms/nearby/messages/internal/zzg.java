package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;

public final class zzg extends zzc {
    public zzg(String s) {
        this(zzg.zzm(s));
    }

    public zzg(String s, String s1) {
        this(zzg.zzm(s), zzg.zzm(s1));
    }

    public zzg(byte[] arr_b) {
        Preconditions.checkArgument(arr_b.length == 10 || arr_b.length == 16, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
        super(arr_b);
    }

    private zzg(byte[] arr_b, byte[] arr_b1) {
        byte[][] arr2_b = new byte[2][];
        boolean z = false;
        Preconditions.checkArgument(arr_b.length == 10, "Namespace length(" + arr_b.length + " bytes) must be 10 bytes.");
        arr2_b[0] = arr_b;
        if(arr_b1.length == 6) {
            z = true;
        }
        Preconditions.checkArgument(z, "Instance length(" + arr_b1.length + " bytes) must be 6 bytes.");
        arr2_b[1] = arr_b1;
        this(ArrayUtils.concatByteArrays(arr2_b));
    }

    @Override  // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        return "EddystoneUidPrefix{bytes=" + this.getHex() + '}';
    }
}

