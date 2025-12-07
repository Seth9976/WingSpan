package com.unity3d.plugin.downloader.d;

import android.content.Context;
import android.util.Log;
import com.unity3d.plugin.downloader.e.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class b implements l {
    private long a;
    private long b;
    private long c;
    private long d;
    private long e;
    private int f;
    private m g;
    private Vector h;
    private Vector i;
    private Vector j;

    public b(Context context0, k k0) {
        this.e = 0L;
        this.h = new Vector();
        this.i = new Vector();
        this.j = new Vector();
        m m0 = new m(context0.getSharedPreferences("com.google.android.vending.licensing.APKExpansionPolicy", 0), k0);
        this.g = m0;
        this.f = Integer.parseInt(m0.b("lastResponse", "291"));
        this.a = Long.parseLong(this.g.b("validityTimestamp", "0"));
        this.b = Long.parseLong(this.g.b("retryUntil", "0"));
        this.c = Long.parseLong(this.g.b("maxRetries", "0"));
        this.d = Long.parseLong(this.g.b("retryCount", "0"));
    }

    private void a(long v) {
        this.d = v;
        this.g.a("retryCount", Long.toString(v));
    }

    private void a(String s) {
        Long long0;
        try {
            long0 = Long.parseLong(s);
        }
        catch(NumberFormatException unused_ex) {
            Log.w("APKExpansionPolicy", "License validity timestamp (VT) missing, caching for a minute");
            long0 = (long)(System.currentTimeMillis() + 60000L);
            s = "1764702400508";
        }
        this.a = (long)long0;
        this.g.a("validityTimestamp", s);
    }

    public final String a(int v) {
        return v >= this.h.size() ? null : ((String)this.h.elementAt(v));
    }

    public final void a() {
        this.g.a("lastResponse", "291");
        this.b("0");
        this.c("0");
        this.a(0L);
        this.a("0");
        this.g.a();
    }

    @Override  // com.unity3d.plugin.downloader.d.l
    public final void a(int v, n n0) {
        Vector vector0;
        String s1;
        int v1;
        this.a((v == 291 ? this.d + 1L : 0L));
        if(v == 0x100) {
            Map map0 = b.d(n0.g);
            this.f = 0x100;
            this.a("1764702400565");
            for(Object object0: map0.keySet()) {
                String s = (String)object0;
                if(s.equals("VT")) {
                    this.a(((String)map0.get(s)));
                }
                else if(s.equals("GT")) {
                    this.b(((String)map0.get(s)));
                }
                else if(s.equals("GR")) {
                    this.c(((String)map0.get(s)));
                }
                else {
                    if(s.startsWith("FILE_URL")) {
                        v1 = Integer.parseInt(s.substring(8)) - 1;
                        s1 = (String)map0.get(s);
                        if(v1 >= this.h.size()) {
                            this.h.setSize(v1 + 1);
                        }
                        vector0 = this.h;
                    }
                    else if(s.startsWith("FILE_NAME")) {
                        v1 = Integer.parseInt(s.substring(9)) - 1;
                        s1 = (String)map0.get(s);
                        if(v1 >= this.i.size()) {
                            this.i.setSize(v1 + 1);
                        }
                        vector0 = this.i;
                    }
                    else {
                        goto label_33;
                    }
                    vector0.set(v1, s1);
                    continue;
                label_33:
                    if(s.startsWith("FILE_SIZE")) {
                        int v2 = Integer.parseInt(s.substring(9)) - 1;
                        long v3 = Long.parseLong(((String)map0.get(s)));
                        if(v2 >= this.j.size()) {
                            this.j.setSize(v2 + 1);
                        }
                        this.j.set(v2, v3);
                    }
                }
            }
        }
        else if(v == 561) {
            this.a("0");
            this.b("0");
            this.c("0");
        }
        this.e = System.currentTimeMillis();
        this.f = v;
        this.g.a("lastResponse", Integer.toString(v));
        this.g.a();
    }

    private void b(String s) {
        Long long0;
        try {
            long0 = Long.parseLong(s);
        }
        catch(NumberFormatException unused_ex) {
            Log.w("APKExpansionPolicy", "License retry timestamp (GT) missing, grace period disabled");
            long0 = 0L;
            s = "0";
        }
        this.b = (long)long0;
        this.g.a("retryUntil", s);
    }

    public final int b() {
        return this.h.size();
    }

    public final String b(int v) {
        return v >= this.i.size() ? null : ((String)this.i.elementAt(v));
    }

    private void c(String s) {
        Long long0;
        try {
            long0 = Long.parseLong(s);
        }
        catch(NumberFormatException unused_ex) {
            Log.w("APKExpansionPolicy", "Licence retry count (GR) missing, grace period disabled");
            long0 = 0L;
            s = "0";
        }
        this.c = (long)long0;
        this.g.a("maxRetries", s);
    }

    public final long c(int v) {
        return v >= this.j.size() ? -1L : ((long)(((Long)this.j.elementAt(v))));
    }

    @Override  // com.unity3d.plugin.downloader.d.l
    public final boolean c() {
        long v = System.currentTimeMillis();
        return this.f == 0x100 ? v <= this.a : this.f == 291 && v < this.e + 60000L && (v <= this.b || this.d <= this.c);
    }

    private static Map d(String s) {
        Map map0 = new HashMap();
        try {
            c.a(new URI("?" + s), map0);
        }
        catch(URISyntaxException unused_ex) {
            Log.w("APKExpansionPolicy", "Invalid syntax error while decoding extras data from server.");
        }
        return map0;
    }
}

