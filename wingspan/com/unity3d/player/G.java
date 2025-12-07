package com.unity3d.player;

class g implements Runnable {
    private IAssetPackManagerStatusQueryCallback a;
    private long b;
    private String[] c;
    private int[] d;
    private int[] e;

    g(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback0, long v, String[] arr_s, int[] arr_v, int[] arr_v1) {
        this.a = iAssetPackManagerStatusQueryCallback0;
        this.b = v;
        this.c = arr_s;
        this.d = arr_v;
        this.e = arr_v1;
    }

    @Override
    public void run() {
        this.a.onStatusResult(this.b, this.c, this.d, this.e);
    }
}

