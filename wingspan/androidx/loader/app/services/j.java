package androidx.loader.app.services;

import android.content.Context;
import np.dcc.protect.EntryPoint;
import org.json.JSONObject;

public final class j implements Runnable {
    public final Context a;
    public final JSONObject b;

    static {
        EntryPoint.stub(19);
    }

    public j(Context context0, JSONObject jSONObject0) {
        this.a = context0;
        this.b = jSONObject0;
    }

    @Override
    public final native void run() {
    }
}

