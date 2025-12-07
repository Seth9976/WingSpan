package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.Map;

class f implements OnCompleteListener {
    private IAssetPackManagerDownloadStatusCallback a;
    private Looper b;
    private String c;

    public f(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback0, String s) {
        this.a = iAssetPackManagerDownloadStatusCallback0;
        this.b = Looper.myLooper();
        this.c = s;
    }

    private void a(String s, int v, int v1, long v2) {
        new Handler(this.b).post(new b(Collections.singleton(this.a), s, v, v2, (v == 4 ? v2 : 0L), 0, v1));
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task0) {
        AssetPackStates assetPackStates0;
        try {
            assetPackStates0 = (AssetPackStates)task0.getResult();
        }
        catch(RuntimeExecutionException runtimeExecutionException0) {
            this.a(this.c, 0, i.a(runtimeExecutionException0), 0L);
            return;
        }
        Map map0 = assetPackStates0.packStates();
        if(map0.size() == 0) {
            return;
        }
        for(Object object0: map0.values()) {
            AssetPackState assetPackState0 = (AssetPackState)object0;
            if(assetPackState0.errorCode() == 0) {
                switch(assetPackState0.status()) {
                    case 0: 
                    case 4: 
                    case 5: {
                        break;
                    }
                    default: {
                        i i0 = i.d;
                        String s = assetPackState0.name();
                        IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback0 = this.a;
                        Looper looper0 = this.b;
                        i0.getClass();
                        i i1 = i.d;
                        synchronized(i1) {
                            Object object1 = i0.c;
                            if(object1 == null) {
                                c c0 = new c(i0, iAssetPackManagerDownloadStatusCallback0, looper0);
                                i0.a.registerListener(c0);
                                i0.c = c0;
                            }
                            else {
                                synchronized(((c)object1)) {
                                    ((c)object1).a.add(iAssetPackManagerDownloadStatusCallback0);
                                }
                            }
                            i0.b.add(s);
                            i0.a.fetch(Collections.singletonList(s));
                        }
                        continue;
                    }
                }
            }
            this.a(assetPackState0.name(), assetPackState0.status(), assetPackState0.errorCode(), assetPackStates0.totalBytes());
        }
    }
}

