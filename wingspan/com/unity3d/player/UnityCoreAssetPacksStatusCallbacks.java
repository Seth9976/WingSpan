package com.unity3d.player;

class UnityCoreAssetPacksStatusCallbacks implements IAssetPackManagerDownloadStatusCallback, IAssetPackManagerStatusQueryCallback {
    private final native void nativeStatusQueryResult(String arg1, int arg2, int arg3) {
    }

    @Override  // com.unity3d.player.IAssetPackManagerStatusQueryCallback
    public void onStatusResult(long v, String[] arr_s, int[] arr_v, int[] arr_v1) {
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            this.nativeStatusQueryResult(arr_s[v1], arr_v[v1], arr_v1[v1]);
        }
    }

    @Override  // com.unity3d.player.IAssetPackManagerDownloadStatusCallback
    public void onStatusUpdate(String s, int v, long v1, long v2, int v3, int v4) {
        this.nativeStatusQueryResult(s, v, v4);
    }
}

