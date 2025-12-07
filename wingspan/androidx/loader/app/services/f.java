package androidx.loader.app.services;

import android.content.Context;
import np.dcc.protect.EntryPoint;

public final class f implements Runnable {
    public final String a;
    public final Context b;

    static {
        EntryPoint.stub(23);
    }

    public f(String s, Context context0) {
        this.a = s;
        this.b = context0;
    }

    @Override
    public final native void run() {
    }
}

