package com.onesignal.notifications.internal.backend;

import com.onesignal.core.internal.device.IDeviceService.DeviceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J1\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ1\u0010\u000B\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/internal/backend/INotificationBackendService;", "", "updateNotificationAsOpened", "", "appId", "", "notificationId", "subscriptionId", "deviceType", "Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationAsReceived", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationBackendService {
    Object updateNotificationAsOpened(String arg1, String arg2, String arg3, DeviceType arg4, Continuation arg5);

    Object updateNotificationAsReceived(String arg1, String arg2, String arg3, DeviceType arg4, Continuation arg5);
}

