package com.unity3d.plugin.downloader.b;

import android.content.Context;
import android.os.Messenger;

final class k implements p {
    final Messenger a;
    private o b;

    public k(o o0) {
        this.b = null;
        this.a = new Messenger(new l(this));
        this.b = o0;
    }

    @Override  // com.unity3d.plugin.downloader.b.p
    public final Messenger a() {
        return this.a;
    }

    @Override  // com.unity3d.plugin.downloader.b.p
    public final void a(Context context0) {
    }

    @Override  // com.unity3d.plugin.downloader.b.p
    public final void b(Context context0) {
    }
}

