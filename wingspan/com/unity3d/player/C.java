package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.HashSet;
import java.util.Set;

class c implements AssetPackStateUpdateListener {
    private HashSet a;
    private Looper b;
    final i c;

    public c(i i0, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback0, Looper looper0) {
        this.c = i0;
        super();
        HashSet hashSet0 = new HashSet();
        this.a = hashSet0;
        hashSet0.add(iAssetPackManagerDownloadStatusCallback0);
        this.b = looper0;
    }

    public void onStateUpdate(Object object0) {
        AssetPackState assetPackState0 = (AssetPackState)object0;
        synchronized(this) {
            switch(assetPackState0.status()) {
                case 0: 
                case 4: 
                case 5: {
                    i i0 = i.-$$Nest$sfgetd();
                    synchronized(i0) {
                        i.-$$Nest$fgetb(this.c).remove(assetPackState0.name());
                        if(i.-$$Nest$fgetb(this.c).isEmpty()) {
                            i i1 = this.c;
                            Object object1 = i.-$$Nest$fgetc(i1);
                            if(object1 instanceof c) {
                                i.-$$Nest$fgeta(i1).unregisterListener(((c)object1));
                            }
                            i.-$$Nest$fputc(this.c, null);
                        }
                    }
                }
            }
            if(this.a.size() == 0) {
                return;
            }
            new Handler(this.b).post(new b(((Set)this.a.clone()), assetPackState0.name(), assetPackState0.status(), assetPackState0.totalBytesToDownload(), assetPackState0.bytesDownloaded(), assetPackState0.transferProgressPercentage(), assetPackState0.errorCode()));
        }
    }
}

