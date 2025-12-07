package com.unity3d.plugin.downloader.b;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;

final class l extends Handler {
    final k a;

    l(k k0) {
        this.a = k0;
        super();
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        switch(message0.what) {
            case 1: {
                this.a.b.a();
                return;
            }
            case 2: {
                this.a.b.b();
                return;
            }
            case 3: {
                this.a.b.a(message0.getData().getInt("flags"));
                return;
            }
            case 4: {
                this.a.b.c();
                return;
            }
            case 5: {
                this.a.b.d();
                return;
            }
            case 6: {
                this.a.b.a(((Messenger)message0.getData().getParcelable("EMH")));
            }
        }
    }
}

