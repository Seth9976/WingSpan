package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Map;

class h implements OnCompleteListener {
    private IAssetPackManagerStatusQueryCallback a;
    private Looper b;
    private String[] c;

    public h(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback0, String[] arr_s) {
        this.a = iAssetPackManagerStatusQueryCallback0;
        this.b = Looper.myLooper();
        this.c = arr_s;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task0) {
        AssetPackStates assetPackStates0;
        int v;
        if(this.a == null) {
            return;
        }
        try {
            v = 0;
            assetPackStates0 = (AssetPackStates)task0.getResult();
        }
        catch(RuntimeExecutionException runtimeExecutionException0) {
            String s = runtimeExecutionException0.getMessage();
            String[] arr_s = this.c;
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                String s1 = arr_s[v1];
                if(s.contains(s1)) {
                    Handler handler0 = new Handler(this.b);
                    IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback0 = this.a;
                    int[] arr_v = {i.a(runtimeExecutionException0)};
                    handler0.post(new g(iAssetPackManagerStatusQueryCallback0, 0L, new String[]{s1}, new int[]{0}, arr_v));
                    return;
                }
            }
            String[] arr_s1 = this.c;
            int[] arr_v1 = new int[arr_s1.length];
            int[] arr_v2 = new int[arr_s1.length];
            for(int v2 = 0; v2 < this.c.length; ++v2) {
                arr_v1[v2] = 0;
                arr_v2[v2] = i.a(runtimeExecutionException0);
            }
            new Handler(this.b).post(new g(this.a, 0L, this.c, arr_v1, arr_v2));
            return;
        }
        Map map0 = assetPackStates0.packStates();
        int v3 = map0.size();
        String[] arr_s2 = new String[v3];
        int[] arr_v3 = new int[v3];
        int[] arr_v4 = new int[v3];
        for(Object object0: map0.values()) {
            arr_s2[v] = ((AssetPackState)object0).name();
            arr_v3[v] = ((AssetPackState)object0).status();
            arr_v4[v] = ((AssetPackState)object0).errorCode();
            ++v;
        }
        new Handler(this.b).post(new g(this.a, assetPackStates0.totalBytes(), arr_s2, arr_v3, arr_v4));
    }
}

