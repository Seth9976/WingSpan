package com.unity3d.plugin.downloader.b;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

final class e implements n {
    private Messenger a;

    public e(Messenger messenger0) {
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

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(int v) {
        Bundle bundle0 = new Bundle(1);
        bundle0.putInt("newState", v);
        this.a(10, bundle0);
    }

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(Messenger messenger0) {
    }

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(b b0) {
        Bundle bundle0 = new Bundle(1);
        bundle0.putParcelable("progress", b0);
        this.a(11, bundle0);
    }
}

