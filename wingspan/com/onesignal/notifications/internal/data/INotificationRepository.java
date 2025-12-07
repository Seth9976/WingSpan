package com.onesignal.notifications.internal.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b`\u0018\u00002\u00020\u0001:\u00012J!\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0007Ji\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\f\u001A\u0004\u0018\u00010\n2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\nH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0016J!\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\nH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001A\u00020\u0003H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001AJ\u001B\u0010\u001B\u001A\u00020\u000E2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001CJ#\u0010\u001D\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u000EH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010 J\u001B\u0010!\u001A\u0004\u0018\u00010\u00052\u0006\u0010\f\u001A\u00020\nH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001CJ\u001B\u0010\"\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001A\u00020\u0005H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010#J\u001F\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\u001E\u001A\u00020\nH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001CJ)\u0010\'\u001A\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010(\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010)J7\u0010*\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010+\u001A\u00020\u000E2\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010-\u001A\u00020\u000EH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010.J\u0019\u0010/\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u0005H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010#J\u0019\u00100\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\nH\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001CJ\u0011\u00101\u001A\u00020\u0003H\u00A6@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001A\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u00063"}, d2 = {"Lcom/onesignal/notifications/internal/data/INotificationRepository;", "", "clearOldestOverLimitFallback", "", "notificationsToMakeRoomFor", "", "maxNumberOfNotificationsInt", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotification", "id", "", "groupId", "collapseKey", "shouldDismissIdenticals", "", "isOpened", "androidId", "title", "body", "expireTime", "", "jsonPayload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSummaryNotification", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpiredNotifications", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doesNotificationExist", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndroidIdForGroup", "group", "getSummaryNotification", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndroidIdFromCollapseKey", "getGroupId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listNotificationsForGroup", "", "Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;", "listNotificationsForOutstanding", "excludeAndroidIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsConsumed", "dismissed", "summaryGroup", "clearGroupOnSummaryClick", "(IZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsDismissed", "markAsDismissedForGroup", "markAsDismissedForOutstanding", "NotificationData", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationRepository {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static Object listNotificationsForOutstanding$default(INotificationRepository iNotificationRepository0, List list0, Continuation continuation0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listNotificationsForOutstanding");
            }
            if((v & 1) != 0) {
                list0 = null;
            }
            return iNotificationRepository0.listNotificationsForOutstanding(list0, continuation0);
        }

        public static Object markAsConsumed$default(INotificationRepository iNotificationRepository0, int v, boolean z, String s, boolean z1, Continuation continuation0, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: markAsConsumed");
            }
            if((v1 & 4) != 0) {
                s = null;
            }
            if((v1 & 8) != 0) {
                z1 = true;
            }
            return iNotificationRepository0.markAsConsumed(v, z, s, z1, continuation0);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0011R\u0013\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;", "", "androidId", "", "id", "", "fullData", "createdAt", "", "title", "message", "(ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAndroidId", "()I", "getCreatedAt", "()J", "getFullData", "()Ljava/lang/String;", "getId", "getMessage", "getTitle", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class NotificationData {
        private final int androidId;
        private final long createdAt;
        private final String fullData;
        private final String id;
        private final String message;
        private final String title;

        public NotificationData(int v, String s, String s1, long v1, String s2, String s3) {
            Intrinsics.checkNotNullParameter(s, "id");
            Intrinsics.checkNotNullParameter(s1, "fullData");
            super();
            this.androidId = v;
            this.id = s;
            this.fullData = s1;
            this.createdAt = v1;
            this.title = s2;
            this.message = s3;
        }

        public final int getAndroidId() {
            return this.androidId;
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final String getFullData() {
            return this.fullData;
        }

        public final String getId() {
            return this.id;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    Object clearOldestOverLimitFallback(int arg1, int arg2, Continuation arg3);

    Object createNotification(String arg1, String arg2, String arg3, boolean arg4, boolean arg5, int arg6, String arg7, String arg8, long arg9, String arg10, Continuation arg11);

    Object createSummaryNotification(int arg1, String arg2, Continuation arg3);

    Object deleteExpiredNotifications(Continuation arg1);

    Object doesNotificationExist(String arg1, Continuation arg2);

    Object getAndroidIdForGroup(String arg1, boolean arg2, Continuation arg3);

    Object getAndroidIdFromCollapseKey(String arg1, Continuation arg2);

    Object getGroupId(int arg1, Continuation arg2);

    Object listNotificationsForGroup(String arg1, Continuation arg2);

    Object listNotificationsForOutstanding(List arg1, Continuation arg2);

    Object markAsConsumed(int arg1, boolean arg2, String arg3, boolean arg4, Continuation arg5);

    Object markAsDismissed(int arg1, Continuation arg2);

    Object markAsDismissedForGroup(String arg1, Continuation arg2);

    Object markAsDismissedForOutstanding(Continuation arg1);
}

