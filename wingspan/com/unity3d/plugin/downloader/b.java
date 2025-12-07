package com.unity3d.plugin.downloader;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;

final class b implements View.OnClickListener {
    final UnityDownloaderActivity a;

    b(UnityDownloaderActivity unityDownloaderActivity0) {
        this.a = unityDownloaderActivity0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Intent intent0 = new Intent("android.settings.WIFI_SETTINGS");
        this.a.startActivity(intent0);
    }
}

