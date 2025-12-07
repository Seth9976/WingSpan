package com.onesignal.notifications.internal.display;

import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "", "displayNotification", "", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationDisplayer {
    Object displayNotification(NotificationGenerationJob arg1, Continuation arg2);
}

