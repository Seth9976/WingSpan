package com.unity3d.plugin.downloader.e;

public class a {
    static final boolean a = true;
    private static final byte[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final byte[] e;

    static {
        a.b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 0x2F};
        a.c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 0x5F};
        a.d = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 0x3F, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 0x1F, 0x20, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0x2F, 0x30, 49, 50, 51, -9, -9, -9, -9, -9};
        a.e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 0x3F, -9, 26, 27, 28, 29, 30, 0x1F, 0x20, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0x2F, 0x30, 49, 50, 51, -9, -9, -9, -9, -9};
    }

    private static int a(byte[] arr_b, byte[] arr_b1, int v, byte[] arr_b2) {
        int v1 = arr_b[2];
        if(v1 == 61) {
            arr_b1[v] = (byte)((arr_b2[arr_b[1]] << 24 >>> 12 | arr_b2[arr_b[0]] << 24 >>> 6) >>> 16);
            return 1;
        }
        int v2 = arr_b[3];
        if(v2 == 61) {
            int v3 = arr_b2[arr_b[1]] << 24 >>> 12 | arr_b2[arr_b[0]] << 24 >>> 6 | arr_b2[v1] << 24 >>> 18;
            arr_b1[v] = (byte)(v3 >>> 16);
            arr_b1[v + 1] = (byte)(v3 >>> 8);
            return 2;
        }
        int v4 = arr_b2[arr_b[1]] << 24 >>> 12 | arr_b2[arr_b[0]] << 24 >>> 6 | arr_b2[v1] << 24 >>> 18 | arr_b2[v2] << 24 >>> 24;
        arr_b1[v] = (byte)(v4 >> 16);
        arr_b1[v + 1] = (byte)(v4 >> 8);
        arr_b1[v + 2] = (byte)v4;
        return 3;
    }

    public static String a(byte[] arr_b) {
        byte[] arr_b1 = a.b;
        int v = (arr_b.length + 2) / 3 * 4;
        int v1 = v + v / 0x7FFFFFFF;
        byte[] arr_b2 = new byte[v1];
        int v2 = arr_b.length - 2;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        while(v3 < v2) {
            int v6 = arr_b[v3] << 24 >>> 8 | arr_b[v3 + 1] << 24 >>> 16 | arr_b[v3 + 2] << 24 >>> 24;
            arr_b2[v4] = arr_b1[v6 >>> 18];
            arr_b2[v4 + 1] = arr_b1[v6 >>> 12 & 0x3F];
            arr_b2[v4 + 2] = arr_b1[v6 >>> 6 & 0x3F];
            arr_b2[v4 + 3] = arr_b1[v6 & 0x3F];
            v5 += 4;
            if(v5 == 0x7FFFFFFF) {
                arr_b2[v4 + 4] = 10;
                v5 = 0;
                ++v4;
            }
            v3 += 3;
            v4 += 4;
        }
        if(v3 < arr_b.length) {
            int v7 = arr_b.length - v3;
            int v8 = (v7 <= 2 ? 0 : arr_b[v3 + 2] << 24 >>> 24) | ((v7 <= 0 ? 0 : arr_b[v3] << 24 >>> 8) | (v7 <= 1 ? 0 : arr_b[v3 + 1] << 24 >>> 16));
            switch(v7) {
                case 1: {
                    arr_b2[v4] = arr_b1[v8 >>> 18];
                    arr_b2[v4 + 1] = arr_b1[v8 >>> 12 & 0x3F];
                    arr_b2[v4 + 2] = 61;
                    arr_b2[v4 + 3] = 61;
                    break;
                }
                case 2: {
                    arr_b2[v4] = arr_b1[v8 >>> 18];
                    arr_b2[v4 + 1] = arr_b1[v8 >>> 12 & 0x3F];
                    arr_b2[v4 + 2] = arr_b1[v8 >>> 6 & 0x3F];
                    arr_b2[v4 + 3] = 61;
                    break;
                }
                case 3: {
                    arr_b2[v4] = arr_b1[v8 >>> 18];
                    arr_b2[v4 + 1] = arr_b1[v8 >>> 12 & 0x3F];
                    arr_b2[v4 + 2] = arr_b1[v8 >>> 6 & 0x3F];
                    arr_b2[v4 + 3] = arr_b1[v8 & 0x3F];
                }
            }
            if(v5 + 4 == 0x7FFFFFFF) {
                arr_b2[v4 + 4] = 10;
                ++v4;
            }
            v4 += 4;
        }
        if(!a.a && v4 != v1) {
            throw new AssertionError();
        }
        return new String(arr_b2, 0, v1);
    }

    public static byte[] a(String s) [...] // 潜在的解密器
}

