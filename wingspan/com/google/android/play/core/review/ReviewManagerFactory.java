package com.google.android.play.core.review;

import android.content.Context;

public class ReviewManagerFactory {
    public static ReviewManager create(Context context0) {
        Context context1 = context0.getApplicationContext();
        if(context1 != null) {
            context0 = context1;
        }
        return new zzd(new zzi(context0));
    }
}

