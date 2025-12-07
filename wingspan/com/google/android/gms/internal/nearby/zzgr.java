package com.google.android.gms.internal.nearby;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.util.Hex;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.UUID;

public final class zzgr {
    private static final ParcelUuid zzgm;
    private final int zzgn;
    private final List zzgo;
    private final SparseArray zzgp;
    private final Map zzgq;
    private final int zzgr;
    private final String zzgs;
    private final byte[] zzgt;

    static {
        zzgr.zzgm = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    }

    private zzgr(List list0, SparseArray sparseArray0, Map map0, int v, int v1, String s, byte[] arr_b) {
        this.zzgo = list0;
        this.zzgp = sparseArray0;
        this.zzgq = map0;
        this.zzgs = s;
        this.zzgn = v;
        this.zzgr = v1;
        this.zzgt = arr_b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof zzgr ? Arrays.equals(this.zzgt, ((zzgr)object0).zzgt) : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.zzgt);
    }

    @Override
    public final String toString() {
        String s2;
        int v = this.zzgn;
        String s = String.valueOf(this.zzgo);
        SparseArray sparseArray0 = this.zzgp;
        StringBuilder stringBuilder0 = new StringBuilder();
        String s1 = "{}";
        int v1 = 0;
        if(sparseArray0.size() <= 0) {
            s2 = "{}";
        }
        else {
            stringBuilder0.append('{');
            for(int v2 = 0; v2 < sparseArray0.size(); ++v2) {
                if(v2 > 0) {
                    stringBuilder0.append(", ");
                }
                int v3 = sparseArray0.keyAt(v2);
                byte[] arr_b = (byte[])sparseArray0.valueAt(v2);
                stringBuilder0.append(v3);
                stringBuilder0.append('=');
                stringBuilder0.append((arr_b == null ? null : Hex.bytesToStringUppercase(arr_b)));
            }
            stringBuilder0.append('}');
            s2 = stringBuilder0.toString();
        }
        Map map0 = this.zzgq;
        StringBuilder stringBuilder1 = new StringBuilder();
        if(map0.keySet().size() > 0) {
            stringBuilder1.append('{');
            for(Object object0: map0.entrySet()) {
                if(v1 > 0) {
                    stringBuilder1.append(", ");
                }
                stringBuilder1.append(((Map.Entry)object0).getKey());
                stringBuilder1.append('=');
                byte[] arr_b1 = (byte[])((Map.Entry)object0).getValue();
                stringBuilder1.append((arr_b1 == null ? null : Hex.bytesToStringUppercase(arr_b1)));
                ++v1;
            }
            stringBuilder1.append('}');
            s1 = stringBuilder1.toString();
        }
        return "BleRecord [mAdvertiseFlags=" + v + ", mServiceUuids=" + s + ", mManufacturerSpecificData=" + s2 + ", mServiceData=" + s1 + ", mTxPowerLevel=" + this.zzgr + ", mDeviceName=" + this.zzgs + "]";
    }

    private static int zza(byte[] arr_b, int v, int v1, int v2, List list0) {
        while(v1 > 0) {
            list0.add(zzgr.zze(zzgr.zza(arr_b, v, v2)));
            v1 -= v2;
            v += v2;
        }
        return v;
    }

    private static byte[] zza(byte[] arr_b, int v, int v1) {
        byte[] arr_b1 = new byte[v1];
        System.arraycopy(arr_b, v, arr_b1, 0, v1);
        return arr_b1;
    }

    public static zzgr zzd(byte[] arr_b) {
        if(arr_b == null) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList();
        SparseArray sparseArray0 = new SparseArray();
        HashMap hashMap0 = new HashMap();
        String s = null;
        int v1 = 0x80000000;
        int v2 = -1;
        try {
            for(int v = 0; v < arr_b.length; v = v3 - 1 + v4) {
                int v3 = arr_b[v] & 0xFF;
                if(v3 == 0) {
                    break;
                }
                int v4 = v + 2;
                switch(arr_b[v + 1] & 0xFF) {
                    case 1: {
                        v2 = arr_b[v4] & 0xFF;
                        break;
                    }
                    case 2: 
                    case 3: {
                        zzgr.zza(arr_b, v4, v3 - 1, 2, arrayList0);
                        break;
                    }
                    case 4: 
                    case 5: {
                        zzgr.zza(arr_b, v4, v3 - 1, 4, arrayList0);
                        break;
                    }
                    case 6: 
                    case 7: {
                        zzgr.zza(arr_b, v4, v3 - 1, 16, arrayList0);
                        break;
                    }
                    case 8: 
                    case 9: {
                        s = new String(zzgr.zza(arr_b, v4, v3 - 1));
                        break;
                    }
                    case 10: {
                        v1 = arr_b[v4];
                        break;
                    }
                    case 22: {
                        hashMap0.put(zzgr.zze(zzgr.zza(arr_b, v4, 2)), zzgr.zza(arr_b, v4 + 2, v3 - 3));
                        break;
                    }
                    case 0xFF: {
                        sparseArray0.put(((arr_b[v4 + 1] & 0xFF) << 8) + (0xFF & arr_b[v4]), zzgr.zza(arr_b, v4 + 2, v3 - 3));
                    }
                }
            }
            return new zzgr((arrayList0.isEmpty() ? null : arrayList0), sparseArray0, hashMap0, v2, v1, s, arr_b);
        }
        catch(Exception exception0) {
            String s1 = Arrays.toString(arr_b);
            Log.w("BleRecord", (s1.length() == 0 ? new String("Unable to parse scan record: ") : "Unable to parse scan record: " + s1), exception0);
            return null;
        }
    }

    private static ParcelUuid zze(byte[] arr_b) {
        long v;
        if(arr_b != null) {
            if(arr_b.length != 2 && (arr_b.length != 4 && arr_b.length != 16)) {
                throw new IllegalArgumentException("uuidBytes length invalid - " + arr_b.length);
            }
            switch(arr_b.length) {
                case 2: {
                    v = ((long)(arr_b[0] & 0xFF)) + ((long)((arr_b[1] & 0xFF) << 8));
                    return new ParcelUuid(new UUID(zzgr.zzgm.getUuid().getMostSignificantBits() + (v << 0x20), zzgr.zzgm.getUuid().getLeastSignificantBits()));
                }
                case 16: {
                    ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN);
                    return new ParcelUuid(new UUID(byteBuffer0.getLong(8), byteBuffer0.getLong(0)));
                }
                default: {
                    v = ((long)((arr_b[3] & 0xFF) << 24)) + (((long)(arr_b[0] & 0xFF)) + ((long)((arr_b[1] & 0xFF) << 8)) + ((long)((arr_b[2] & 0xFF) << 16)));
                    return new ParcelUuid(new UUID(zzgr.zzgm.getUuid().getMostSignificantBits() + (v << 0x20), zzgr.zzgm.getUuid().getLeastSignificantBits()));
                }
            }
        }
        throw new IllegalArgumentException("uuidBytes cannot be null");
    }
}

