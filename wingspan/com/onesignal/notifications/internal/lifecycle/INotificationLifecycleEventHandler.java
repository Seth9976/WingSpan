package com.onesignal.notifications.internal.lifecycle;

import android.app.Activity;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000F"}, d2 = {"Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "", "onNotificationOpened", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONArray;", "notificationId", "", "(Landroid/app/Activity;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onNotificationReceived", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationLifecycleEventHandler {
    Object onNotificationOpened(Activity arg1, JSONArray arg2, String arg3, Continuation arg4);

    Object onNotificationReceived(NotificationGenerationJob arg1, Continuation arg2);
}

