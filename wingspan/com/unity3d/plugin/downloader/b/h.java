package com.unity3d.plugin.downloader.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

final class h implements ServiceConnection {
    final f a;

    h(f f0) {
        this.a = f0;
        super();
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
        Messenger messenger0 = new Messenger(iBinder0);
        this.a.e = messenger0;
        this.a.b.a(this.a.e);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
        this.a.e = null;
    }
}

