package com.unity3d.plugin.downloader;

import android.view.View.OnClickListener;
import android.view.View;

final class c implements View.OnClickListener {
    final UnityDownloaderActivity a;

    c(UnityDownloaderActivity unityDownloaderActivity0) {
        this.a = unityDownloaderActivity0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        this.a.m.a(1);
        this.a.m.c();
        this.a.h.setVisibility(8);
    }
}

