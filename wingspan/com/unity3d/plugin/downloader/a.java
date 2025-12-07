package com.unity3d.plugin.downloader;

import android.view.View.OnClickListener;
import android.view.View;

final class a implements View.OnClickListener {
    final UnityDownloaderActivity a;

    a(UnityDownloaderActivity unityDownloaderActivity0) {
        this.a = unityDownloaderActivity0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a.k) {
            this.a.m.c();
        }
        else {
            this.a.m.b();
        }
        this.a.a(!this.a.k);
    }
}

