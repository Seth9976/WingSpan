package com.onesignal.core.internal.preferences;

import android.content.Context;
import android.os.Build.VERSION;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/internal/preferences/PreferenceStoreFix;", "", "()V", "ensureNoObfuscatedPrefStore", "", "context", "Landroid/content/Context;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PreferenceStoreFix {
    public static final PreferenceStoreFix INSTANCE;

    static {
        PreferenceStoreFix.INSTANCE = new PreferenceStoreFix();
    }

    public final void ensureNoObfuscatedPrefStore(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        try {
            File file0 = Build.VERSION.SDK_INT < 24 ? new File(context0.getFilesDir().getParentFile(), "shared_prefs") : new File(context0.getDataDir(), "shared_prefs");
            File file1 = new File(file0, "OneSignal.xml");
            if(!file0.exists() || !file0.isDirectory() || file1.exists()) {
                return;
            }
            File[] arr_file = file0.listFiles();
            if(arr_file == null) {
                return;
            }
        label_9:
            for(int v = 0; v < arr_file.length; ++v) {
                File file2 = arr_file[v];
                Intrinsics.checkNotNullExpressionValue(file2, "prefsFile");
                if(context0.getSharedPreferences(FilesKt.getNameWithoutExtension(file2), 0).contains("GT_PLAYER_ID")) {
                    file2.renameTo(file1);
                    return;
                }
            }
        }
        catch(Throwable throwable0) {
            Logging.log(LogLevel.ERROR, "error attempting to fix obfuscated preference store", throwable0);
            if(true) {
                return;
            }
            goto label_9;
        }
    }
}

