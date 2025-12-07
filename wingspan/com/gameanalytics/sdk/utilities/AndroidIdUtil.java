package com.gameanalytics.sdk.utilities;

import android.content.Context;
import android.provider.Settings.Secure;

public class AndroidIdUtil {
    public static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        catch(SecurityException unused_ex) {
            return null;
        }
    }
}

