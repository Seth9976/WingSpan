package androidx.loader.app.services;

import android.content.Context;
import np.dcc.protect.EntryPoint;

public final class i implements Runnable {
    public final Context a;
    public final Throwable b;

    static {
        EntryPoint.stub(18);
    }

    public i(Context context0, Throwable throwable0) {
        this.a = context0;
        this.b = throwable0;
    }

    @Override
    public final native void run() {
    }
}

