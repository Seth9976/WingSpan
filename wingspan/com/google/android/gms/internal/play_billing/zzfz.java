package com.google.android.gms.internal.play_billing;

final class zzfz extends zzfy {
    @Override  // com.google.android.gms.internal.play_billing.zzfy
    final int zza(int v, byte[] arr_b, int v1, int v2) {
        int v3;
        while(v1 < v2 && arr_b[v1] >= 0) {
            v3 = 0;
            ++v1;
        }
        if(v1 < v2) {
            while(v1 < v2) {
                int v4 = v1 + 1;
                int v5 = arr_b[v1];
                if(v5 < 0) {
                    if(v5 < 0xFFFFFFE0) {
                        if(v4 >= v2) {
                            return v5;
                        }
                        if(v5 < -62) {
                            return -1;
                        }
                        v1 = v4 + 1;
                        if(arr_b[v4] <= -65) {
                            continue;
                        }
                        return -1;
                    }
                    else if(v5 < -16) {
                        if(v4 >= v2 - 1) {
                            return zzgb.zza(arr_b, v4, v2);
                        }
                        int v6 = arr_b[v4];
                        if(v6 > -65 || v5 == 0xFFFFFFE0 && v6 < 0xFFFFFFA0 || v5 == -19 && v6 >= 0xFFFFFFA0) {
                            return -1;
                        }
                        v1 = v4 + 2;
                        if(arr_b[v4 + 1] <= -65) {
                            continue;
                        }
                        return -1;
                    }
                    else {
                        if(v4 >= v2 - 2) {
                            return zzgb.zza(arr_b, v4, v2);
                        }
                        int v7 = arr_b[v4];
                        if(v7 > -65 || (v5 << 28) + (v7 + 0x70) >> 30 != 0) {
                            return -1;
                        }
                        int v8 = v4 + 2;
                        if(arr_b[v4 + 1] > -65) {
                            return -1;
                        }
                        v4 = v8 + 1;
                        if(arr_b[v8] > -65) {
                            return -1;
                        }
                    }
                }
                v1 = v4;
            }
        }
        return v3;
    }
}

