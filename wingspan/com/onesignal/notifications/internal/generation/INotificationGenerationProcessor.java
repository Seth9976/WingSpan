package com.onesignal.notifications.internal.generation;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J9\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000F"}, d2 = {"Lcom/onesignal/notifications/internal/generation/INotificationGenerationProcessor;", "", "processNotificationData", "", "context", "Landroid/content/Context;", "androidNotificationId", "", "jsonPayload", "Lorg/json/JSONObject;", "isRestoring", "", "timestamp", "", "(Landroid/content/Context;ILorg/json/JSONObject;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationGenerationProcessor {
    Object processNotificationData(Context arg1, int arg2, JSONObject arg3, boolean arg4, long arg5, Continuation arg6);
}

