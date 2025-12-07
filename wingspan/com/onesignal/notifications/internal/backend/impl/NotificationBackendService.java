package com.onesignal.notifications.internal.backend.impl;

import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.device.IDeviceService.DeviceType;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ1\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000F"}, d2 = {"Lcom/onesignal/notifications/internal/backend/impl/NotificationBackendService;", "Lcom/onesignal/notifications/internal/backend/INotificationBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "updateNotificationAsOpened", "", "appId", "", "notificationId", "subscriptionId", "deviceType", "Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationAsReceived", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationBackendService implements INotificationBackendService {
    private final IHttpClient _httpClient;

    public NotificationBackendService(IHttpClient iHttpClient0) {
        Intrinsics.checkNotNullParameter(iHttpClient0, "_httpClient");
        super();
        this._httpClient = iHttpClient0;
    }

    @Override  // com.onesignal.notifications.internal.backend.INotificationBackendService
    public Object updateNotificationAsOpened(String s, String s1, String s2, DeviceType iDeviceService$DeviceType0, Continuation continuation0) {
        com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsOpened.1 notificationBackendService$updateNotificationAsOpened$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsOpened.1) {
            notificationBackendService$updateNotificationAsOpened$10 = (com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsOpened.1)continuation0;
            if((notificationBackendService$updateNotificationAsOpened$10.label & 0x80000000) == 0) {
                notificationBackendService$updateNotificationAsOpened$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateNotificationAsOpened(null, null, null, null, this);
                    }
                };
            }
            else {
                notificationBackendService$updateNotificationAsOpened$10.label ^= 0x80000000;
            }
        }
        else {
            notificationBackendService$updateNotificationAsOpened$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateNotificationAsOpened(null, null, null, null, this);
                }
            };
        }
        Object object0 = notificationBackendService$updateNotificationAsOpened$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationBackendService$updateNotificationAsOpened$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject();
                jSONObject0.put("app_id", s);
                jSONObject0.put("player_id", s2);
                jSONObject0.put("opened", true);
                jSONObject0.put("device_type", iDeviceService$DeviceType0.getValue());
                notificationBackendService$updateNotificationAsOpened$10.label = 1;
                object0 = this._httpClient.put("notifications/" + s1, jSONObject0, notificationBackendService$updateNotificationAsOpened$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((HttpResponse)object0).isSuccess()) {
            throw new BackendException(((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        }
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.backend.INotificationBackendService
    public Object updateNotificationAsReceived(String s, String s1, String s2, DeviceType iDeviceService$DeviceType0, Continuation continuation0) {
        com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsReceived.1 notificationBackendService$updateNotificationAsReceived$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsReceived.1) {
            notificationBackendService$updateNotificationAsReceived$10 = (com.onesignal.notifications.internal.backend.impl.NotificationBackendService.updateNotificationAsReceived.1)continuation0;
            if((notificationBackendService$updateNotificationAsReceived$10.label & 0x80000000) == 0) {
                notificationBackendService$updateNotificationAsReceived$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateNotificationAsReceived(null, null, null, null, this);
                    }
                };
            }
            else {
                notificationBackendService$updateNotificationAsReceived$10.label ^= 0x80000000;
            }
        }
        else {
            notificationBackendService$updateNotificationAsReceived$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateNotificationAsReceived(null, null, null, null, this);
                }
            };
        }
        Object object0 = notificationBackendService$updateNotificationAsReceived$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationBackendService$updateNotificationAsReceived$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject().put("app_id", s).put("player_id", s2).put("device_type", iDeviceService$DeviceType0.getValue());
                Intrinsics.checkNotNullExpressionValue(jSONObject0, "JSONObject()\n           …_type\", deviceType.value)");
                notificationBackendService$updateNotificationAsReceived$10.label = 1;
                object0 = this._httpClient.put("notifications/" + s1 + "/report_received", jSONObject0, notificationBackendService$updateNotificationAsReceived$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((HttpResponse)object0).isSuccess()) {
            throw new BackendException(((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        }
        return Unit.INSTANCE;
    }
}

