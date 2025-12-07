package androidx.loader.app.services;

import android.app.AlertDialog;
import android.view.View.OnClickListener;
import android.view.View;
import np.dcc.protect.EntryPoint;

public final class g implements View.OnClickListener {
    public final AlertDialog a;

    static {
        EntryPoint.stub(16);
    }

    public g(AlertDialog alertDialog0) {
        this.a = alertDialog0;
    }

    @Override  // android.view.View$OnClickListener
    public final native void onClick(View arg1) {
    }
}

