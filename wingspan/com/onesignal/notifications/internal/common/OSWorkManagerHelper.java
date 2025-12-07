package com.onesignal.notifications.internal.common;

import android.content.Context;
import androidx.work.Configuration.Builder;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\b\u0010\u0007\u001A\u00020\bH\u0003¨\u0006\t"}, d2 = {"Lcom/onesignal/notifications/internal/common/OSWorkManagerHelper;", "", "()V", "getInstance", "Landroidx/work/WorkManager;", "context", "Landroid/content/Context;", "isInitialized", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OSWorkManagerHelper {
    public static final OSWorkManagerHelper INSTANCE;

    static {
        OSWorkManagerHelper.INSTANCE = new OSWorkManagerHelper();
    }

    @JvmStatic
    public static final WorkManager getInstance(Context context0) {
        synchronized(OSWorkManagerHelper.class) {
            Intrinsics.checkNotNullParameter(context0, "context");
            if(!OSWorkManagerHelper.INSTANCE.isInitialized()) {
                try {
                    WorkManager.initialize(context0, new Builder().build());
                }
                catch(IllegalStateException illegalStateException0) {
                    Logging.error("OSWorkManagerHelper initializing WorkManager failed: ", illegalStateException0);
                }
            }
            WorkManager workManager0 = WorkManager.getInstance(context0);
            Intrinsics.checkNotNullExpressionValue(workManager0, "getInstance(context)");
            return workManager0;
        }
    }

    private final boolean isInitialized() {
        return WorkManagerImpl.getInstance() != null;
    }
}

