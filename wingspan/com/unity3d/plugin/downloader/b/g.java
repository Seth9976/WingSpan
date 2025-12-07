package com.unity3d.plugin.downloader.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;

final class g extends Handler {
    final f a;

    g(f f0) {
        this.a = f0;
        super();
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        switch(message0.what) {
            case 10: {
                this.a.b.a(message0.getData().getInt("newState"));
                return;
            }
            case 11: {
                Bundle bundle0 = message0.getData();
                if(this.a.f != null) {
                    bundle0.setClassLoader(this.a.f.getClassLoader());
                    b b0 = (b)message0.getData().getParcelable("progress");
                    this.a.b.a(b0);
                    return;
                }
                return;
            }
            case 12: {
                this.a.b.a(((Messenger)message0.getData().getParcelable("EMH")));
            }
        }
    }
}

