package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.List;

class PlayAssetDeliveryUnityWrapper {
    private t a;
    private static PlayAssetDeliveryUnityWrapper b;

    private PlayAssetDeliveryUnityWrapper(Context context0) {
        this.a = null;
        if(PlayAssetDeliveryUnityWrapper.b != null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper should be created only once. Use getInstance() instead.");
        }
        try {
            if(this.getClass().getClassLoader().loadClass("com.google.android.play.core.assetpacks.AssetPackManager").getMethod("getPackStates", new Class[]{List.class}).getReturnType().getName().equals("com.google.android.gms.tasks.Task")) {
                this.a = this.a(context0);
            }
        }
        catch(ClassNotFoundException | NoSuchMethodException | SecurityException unused_ex) {
        }
    }

    private t a(Context context0) {
        return i.a(context0);
    }

    private void a() {
        if(this.playCoreApiMissing()) {
            throw new RuntimeException("AssetPackManager API is not available! Make sure your gradle project includes \'com.google.android.play:asset-delivery\' dependency.");
        }
    }

    public void cancelAssetPackDownload(String s) {
        this.cancelAssetPackDownloads(new String[]{s});
    }

    public void cancelAssetPackDownloads(String[] arr_s) {
        this.a();
        ((i)this.a).a(arr_s);
    }

    public void downloadAssetPack(String s, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback0) {
        this.downloadAssetPacks(new String[]{s}, iAssetPackManagerDownloadStatusCallback0);
    }

    public void downloadAssetPacks(String[] arr_s, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback0) {
        this.a();
        ((i)this.a).a(arr_s, iAssetPackManagerDownloadStatusCallback0);
    }

    public String getAssetPackPath(String s) {
        this.a();
        return ((i)this.a).a(s);
    }

    public void getAssetPackState(String s, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback0) {
        this.getAssetPackStates(new String[]{s}, iAssetPackManagerStatusQueryCallback0);
    }

    public void getAssetPackStates(String[] arr_s, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback0) {
        this.a();
        ((i)this.a).a(arr_s, iAssetPackManagerStatusQueryCallback0);
    }

    public static PlayAssetDeliveryUnityWrapper getInstance() {
        synchronized(PlayAssetDeliveryUnityWrapper.class) {
            PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper0;
            while((playAssetDeliveryUnityWrapper0 = PlayAssetDeliveryUnityWrapper.b) == null) {
                try {
                    PlayAssetDeliveryUnityWrapper.class.wait(3000L);
                }
                catch(InterruptedException interruptedException0) {
                    u.Log(6, interruptedException0.getMessage());
                }
            }
            if(playAssetDeliveryUnityWrapper0 != null) {
                return playAssetDeliveryUnityWrapper0;
            }
        }
        throw new RuntimeException("PlayAssetDeliveryUnityWrapper is not yet initialised.");
    }

    public static PlayAssetDeliveryUnityWrapper init(Context context0) {
        synchronized(PlayAssetDeliveryUnityWrapper.class) {
            if(PlayAssetDeliveryUnityWrapper.b == null) {
                PlayAssetDeliveryUnityWrapper.b = new PlayAssetDeliveryUnityWrapper(context0);
                PlayAssetDeliveryUnityWrapper.class.notifyAll();
                return PlayAssetDeliveryUnityWrapper.b;
            }
        }
        throw new RuntimeException("PlayAssetDeliveryUnityWrapper.init() should be called only once. Use getInstance() instead.");
    }

    public boolean playCoreApiMissing() {
        return this.a == null;
    }

    public Object registerDownloadStatusListener(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback0) {
        this.a();
        return ((i)this.a).a(iAssetPackManagerDownloadStatusCallback0);
    }

    public void removeAssetPack(String s) {
        this.a();
        ((i)this.a).b(s);
    }

    public void requestToUseMobileData(Activity activity0, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback0) {
        this.a();
        ((i)this.a).a(activity0, iAssetPackManagerMobileDataConfirmationCallback0);
    }

    public void unregisterDownloadStatusListener(Object object0) {
        this.a();
        ((i)this.a).a(object0);
    }
}

