package com.onesignal.notifications.internal.lifecycle;

import android.app.Activity;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationReceivedEvent;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0007H&J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\nH&J!\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u0010H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0017H&J\u0010\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u001AH&J)\u0010\u001B\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001FJ\u0019\u0010 \u001A\u00020\u00032\u0006\u0010!\u001A\u00020\"H¦@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010%\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0007H&J\u0010\u0010&\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\nH&J\u0012\u0010\'\u001A\u00020\u00032\b\u0010(\u001A\u0004\u0018\u00010)H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "", "addExternalClickListener", "", "listener", "Lcom/onesignal/notifications/INotificationClickListener;", "addExternalForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addInternalNotificationLifecycleEventHandler", "handler", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "canOpenNotification", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONObject;", "(Landroid/app/Activity;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canReceiveNotification", "jsonPayload", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "externalNotificationWillShowInForeground", "willDisplayEvent", "Lcom/onesignal/notifications/INotificationWillDisplayEvent;", "externalRemoteNotificationReceived", "notificationReceivedEvent", "Lcom/onesignal/notifications/INotificationReceivedEvent;", "notificationOpened", "Lorg/json/JSONArray;", "notificationId", "", "(Landroid/app/Activity;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notificationReceived", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeExternalClickListener", "removeExternalForegroundLifecycleListener", "removeInternalNotificationLifecycleEventHandler", "setInternalNotificationLifecycleCallback", "callback", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleCallback;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationLifecycleService {
    void addExternalClickListener(INotificationClickListener arg1);

    void addExternalForegroundLifecycleListener(INotificationLifecycleListener arg1);

    void addInternalNotificationLifecycleEventHandler(INotificationLifecycleEventHandler arg1);

    Object canOpenNotification(Activity arg1, JSONObject arg2, Continuation arg3);

    Object canReceiveNotification(JSONObject arg1, Continuation arg2);

    void externalNotificationWillShowInForeground(INotificationWillDisplayEvent arg1);

    void externalRemoteNotificationReceived(INotificationReceivedEvent arg1);

    Object notificationOpened(Activity arg1, JSONArray arg2, String arg3, Continuation arg4);

    Object notificationReceived(NotificationGenerationJob arg1, Continuation arg2);

    void removeExternalClickListener(INotificationClickListener arg1);

    void removeExternalForegroundLifecycleListener(INotificationLifecycleListener arg1);

    void removeInternalNotificationLifecycleEventHandler(INotificationLifecycleEventHandler arg1);

    void setInternalNotificationLifecycleCallback(INotificationLifecycleCallback arg1);
}

