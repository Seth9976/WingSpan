package com.google.android.gms.nearby.messages.internal;

import java.util.Arrays;

public class zzc {
    private static final char[] zzhd;
    private final byte[] zzy;

    static {
        zzc.zzhd = "0123456789abcdef".toCharArray();
    }

    protected zzc(byte[] arr_b) {
        this.zzy = arr_b;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0.getClass().isAssignableFrom(this.getClass()) ? Arrays.equals(this.zzy, ((zzc)object0).zzy) : false;
    }

    public final byte[] getBytes() {
        return this.zzy;
    }

    public final String getHex() {
        return zzc.zzf(this.zzy);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.zzy);
    }

    @Override
    public String toString() {
        return zzc.zzf(this.zzy);
    }

    public static String zzf(byte[] arr_b) {
        StringBuilder stringBuilder0 = new StringBuilder(arr_b.length * 2);
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = arr_b[v];
            stringBuilder0.append(zzc.zzhd[v1 >> 4 & 15]);
            stringBuilder0.append(zzc.zzhd[v1 & 15]);
        }
        return stringBuilder0.toString();
    }

    public static byte[] zzm(String s) {
        int v = s.length();
        byte[] arr_b = new byte[v / 2];
        for(int v1 = 0; v1 < v / 2; ++v1) {
            arr_b[v1] = (byte)((Character.digit(s.charAt(v1 * 2), 16) << 4) + Character.digit(s.charAt(v1 * 2 + 1), 16));
        }
        return arr_b;
    }
}

