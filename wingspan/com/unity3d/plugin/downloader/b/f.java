package com.unity3d.plugin.downloader.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;

final class f implements p {
    final Messenger a;
    private n b;
    private Class c;
    private boolean d;
    private Messenger e;
    private Context f;
    private ServiceConnection g;

    public f(n n0, Class class0) {
        this.b = null;
        this.a = new Messenger(new g(this));
        this.g = new h(this);
        this.b = n0;
        this.c = class0;
    }

    @Override  // com.unity3d.plugin.downloader.b.p
    public final Messenger a() {
        return this.a;
    }

    @Override  // com.unity3d.plugin.downloader.b.p
    public final void a(Context context0) {
        this.f = context0;
        Intent intent0 = new Intent(context0, this.c);
        intent0.putExtra("EMH", this.a);
        if(context0.bindService(intent0, this.g, 2)) {
            this.d = true;
        }
    }

    @Override  // com.unity3d.plugin.downloader.b.p
    public final void b(Context context0) {
        if(this.d) {
            context0.unbindService(this.g);
            this.d = false;
        }
        this.f = null;
    }
}

