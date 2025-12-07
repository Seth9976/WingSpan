package com.google.android.gms.appset;

import android.content.Context;
import com.google.android.gms.internal.appset.zzr;

public final class AppSet {
    public static AppSetIdClient getClient(Context context0) {
        return new zzr(context0);
    }
}

