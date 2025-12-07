package com.onesignal.notifications.internal.restoration;

import com.onesignal.notifications.internal.data.INotificationRepository.NotificationData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001A\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000B"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/INotificationRestoreProcessor;", "", "process", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNotification", "notification", "Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;", "delay", "", "(Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationRestoreProcessor {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static Object processNotification$default(INotificationRestoreProcessor iNotificationRestoreProcessor0, NotificationData iNotificationRepository$NotificationData0, int v, Continuation continuation0, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processNotification");
            }
            if((v1 & 2) != 0) {
                v = 0;
            }
            return iNotificationRestoreProcessor0.processNotification(iNotificationRepository$NotificationData0, v, continuation0);
        }
    }

    Object process(Continuation arg1);

    Object processNotification(NotificationData arg1, int arg2, Continuation arg3);
}

