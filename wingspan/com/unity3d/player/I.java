package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackManagerFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class i implements t {
    private AssetPackManager a;
    private HashSet b;
    private Object c;
    private static i d;

    private i(Context context0) {
        if(i.d != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        this.a = AssetPackManagerFactory.getInstance(context0);
        this.b = new HashSet();
    }

    private static int a(Throwable throwable0) {
        do {
            if(throwable0 instanceof AssetPackException) {
                return ((AssetPackException)throwable0).getErrorCode();
            }
            throwable0 = throwable0.getCause();
        }
        while(throwable0 != null);
        return -100;
    }

    public static t a(Context context0) {
        if(i.d == null) {
            i.d = new i(context0);
        }
        return i.d;
    }

    public Object a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback0) {
        c c0 = new c(this, iAssetPackManagerDownloadStatusCallback0, Looper.myLooper());
        this.a.registerListener(c0);
        return c0;
    }

    public String a(String s) {
        AssetPackLocation assetPackLocation0 = this.a.getPackLocation(s);
        return assetPackLocation0 == null ? "" : assetPackLocation0.assetsPath();
    }

    public void a(Activity activity0, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback0) {
        this.a.showCellularDataConfirmation(activity0).addOnSuccessListener(new e(iAssetPackManagerMobileDataConfirmationCallback0));
    }

    public void a(Object object0) {
        if(!(object0 instanceof c)) {
            return;
        }
        this.a.unregisterListener(((c)object0));
    }

    public void a(String[] arr_s) {
        this.a.cancel(Arrays.asList(arr_s));
    }

    public void a(String[] arr_s, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback0) {
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            this.a.getPackStates(Collections.singletonList(s)).addOnCompleteListener(new f(iAssetPackManagerDownloadStatusCallback0, s));
        }
    }

    public void a(String[] arr_s, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback0) {
        this.a.getPackStates(Arrays.asList(arr_s)).addOnCompleteListener(new h(iAssetPackManagerStatusQueryCallback0, arr_s));
    }

    public void b(String s) {
        this.a.removePack(s);
    }
}

