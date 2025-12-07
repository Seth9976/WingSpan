package com.unity3d.plugin.downloader.c;

import android.app.Notification.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Messenger;
import com.unity3d.plugin.downloader.b.b;
import com.unity3d.plugin.downloader.b.m;
import com.unity3d.plugin.downloader.b.n;

public final class d implements n {
    private int a;
    private final Context b;
    private final NotificationManager c;
    private CharSequence d;
    private n e;
    private Notification.Builder f;
    private Notification.Builder g;
    private Notification.Builder h;
    private CharSequence i;
    private String j;
    private b k;
    private PendingIntent l;
    private static final int m = -908767821;

    static {
    }

    d(Context context0, CharSequence charSequence0) {
        this.a = -1;
        this.b = context0;
        this.i = charSequence0;
        this.c = (NotificationManager)context0.getSystemService("notification");
        this.f = new Notification.Builder(context0);
        this.g = new Notification.Builder(context0);
        this.f.setPriority(-1);
        this.g.setPriority(-1);
        this.f.setCategory("progress");
        this.g.setCategory("progress");
        this.h = this.g;
    }

    public final void a() {
        n n0 = this.e;
        if(n0 != null) {
            n0.a(this.a);
        }
    }

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(int v) {
        boolean z;
        int v2;
        n n0 = this.e;
        if(n0 != null) {
            n0.a(v);
        }
        if(v != this.a) {
            this.a = v;
            if(v != 1 && this.l != null) {
                int v1 = 0x108008A;
                switch(v) {
                    case 0: {
                        v2 = m.b(this.b, "state_unknown");
                        z = false;
                        break;
                    }
                    case 2: 
                    case 3: {
                        v2 = m.a(this.b, v);
                        z = true;
                        v1 = 0x1080082;
                        break;
                    }
                    case 4: {
                        v2 = m.a(this.b, 4);
                        v1 = 0x1080081;
                        z = true;
                        break;
                    }
                    case 5: 
                    case 7: {
                        v2 = m.a(this.b, v);
                        z = false;
                        v1 = 0x1080082;
                        break;
                    }
                    default: {
                        Context context0 = this.b;
                        if(v == 15 || v == 16 || v == 17 || v == 18 || v == 19) {
                            v2 = m.a(context0, v);
                            z = false;
                        }
                        else {
                            v2 = m.a(context0, v);
                            z = true;
                        }
                    }
                }
                this.j = this.b.getString(v2);
                this.d = this.i;
                this.h.setTicker(this.i + ": " + this.j).setSmallIcon(v1).setContentTitle(this.d).setContentText(this.j);
                Notification.Builder notification$Builder0 = this.h;
                if(z) {
                    notification$Builder0.setOngoing(true);
                }
                else {
                    notification$Builder0.setOngoing(false);
                    this.h.setAutoCancel(true);
                }
                Notification notification0 = this.h.build();
                this.c.notify(d.m, notification0);
            }
        }
    }

    public final void a(PendingIntent pendingIntent0) {
        this.g.setContentIntent(pendingIntent0);
        this.f.setContentIntent(pendingIntent0);
        this.l = pendingIntent0;
    }

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(Messenger messenger0) {
    }

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(b b0) {
        Notification.Builder notification$Builder0;
        this.k = b0;
        n n0 = this.e;
        if(n0 != null) {
            n0.a(b0);
        }
        if(Long.compare(b0.a, 0L) <= 0) {
            this.g.setTicker(this.d).setSmallIcon(0x1080081).setContentTitle(this.d).setContentText(this.j);
            notification$Builder0 = this.g;
        }
        else {
            this.f.setProgress(((int)b0.a), ((int)b0.b), false);
            Notification.Builder notification$Builder1 = this.f.setContentText(m.a(b0.b, b0.a)).setSmallIcon(0x1080081).setTicker(this.i + ": " + this.j).setContentTitle(this.i);
            int v = m.b(this.b, "time_remaining_notification");
            Object[] arr_object = {m.a(b0.c)};
            notification$Builder1.setContentInfo(this.b.getString(v, arr_object));
            notification$Builder0 = this.f;
        }
        this.h = notification$Builder0;
        Notification notification0 = this.h.build();
        this.c.notify(d.m, notification0);
    }

    public final void b(Messenger messenger0) {
        n n0 = com.unity3d.plugin.downloader.b.d.a(messenger0);
        this.e = n0;
        b b0 = this.k;
        if(b0 != null) {
            n0.a(b0);
        }
        int v = this.a;
        if(v != -1) {
            this.e.a(v);
        }
    }
}

