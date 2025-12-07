package androidx.loader.app.services;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import np.dcc.protect.EntryPoint;

public final class h implements View.OnClickListener {
    public final Context a;
    public final String b;

    static {
        EntryPoint.stub(17);
    }

    public h(Context context0, String s) {
        this.a = context0;
        this.b = s;
    }

    @Override  // android.view.View$OnClickListener
    public final native void onClick(View arg1) {
    }
}

