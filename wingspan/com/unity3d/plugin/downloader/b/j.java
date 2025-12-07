package com.unity3d.plugin.downloader.b;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

final class j implements o {
    private Messenger a;

    public j(Messenger messenger0) {
        this.a = messenger0;
    }

    private void a(int v, Bundle bundle0) {
        Message message0 = Message.obtain(null, v);
        message0.setData(bundle0);
        try {
            this.a.send(message0);
        }
        catch(RemoteException remoteException0) {
            remoteException0.printStackTrace();
        }
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void a() {
        this.a(1, new Bundle());
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void a(int v) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("flags", v);
        this.a(3, bundle0);
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void a(Messenger messenger0) {
        Bundle bundle0 = new Bundle(1);
        bundle0.putParcelable("EMH", messenger0);
        this.a(6, bundle0);
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void b() {
        this.a(2, new Bundle());
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void c() {
        this.a(4, new Bundle());
    }

    @Override  // com.unity3d.plugin.downloader.b.o
    public final void d() {
        this.a(5, new Bundle());
    }
}

