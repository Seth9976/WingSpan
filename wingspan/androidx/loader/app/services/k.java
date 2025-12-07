package androidx.loader.app.services;

import android.content.Context;
import np.dcc.protect.EntryPoint;

public final class k implements Runnable {
    public final Context a;
    public final Exception b;

    static {
        EntryPoint.stub(28);
    }

    public k(Context context0, Exception exception0) {
        this.a = context0;
        this.b = exception0;
    }

    @Override
    public final native void run() {
    }
}

