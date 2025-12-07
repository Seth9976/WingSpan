package com.onesignal.notifications.internal.generation;

import android.content.Context;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001JB\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;", "", "beginEnqueueingWork", "", "context", "Landroid/content/Context;", "osNotificationId", "", "androidNotificationId", "", "jsonPayload", "Lorg/json/JSONObject;", "timestamp", "", "isRestoring", "isHighPriority", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationGenerationWorkManager {
    boolean beginEnqueueingWork(Context arg1, String arg2, int arg3, JSONObject arg4, long arg5, boolean arg6, boolean arg7);
}

