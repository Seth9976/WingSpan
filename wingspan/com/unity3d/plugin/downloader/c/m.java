package com.unity3d.plugin.downloader.c;

import android.app.PendingIntent;
import android.content.Context;
import android.provider.Settings.Secure;
import com.unity3d.plugin.downloader.d.a;
import com.unity3d.plugin.downloader.d.b;
import com.unity3d.plugin.downloader.d.d;

final class m implements Runnable {
    final Context a;
    final j b;

    m(j j0, Context context0, PendingIntent pendingIntent0) {
        this.b = j0;
        super();
        this.a = context0;
        j0.mPendingIntent = pendingIntent0;
    }

    @Override
    public final void run() {
        j.b(true);
        this.b.mNotification.a(2);
        String s = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
        a a0 = new a(this.b.h(), "com.MonsterCouch.Wingspan", s);
        b b0 = new b(this.a, a0);
        b0.a();
        String s1 = this.b.g();
        new d(this.a, b0, s1).a(new n(this, b0));
    }
}

