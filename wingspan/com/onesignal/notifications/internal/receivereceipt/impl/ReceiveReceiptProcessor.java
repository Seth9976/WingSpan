package com.onesignal.notifications.internal.receivereceipt.impl;

import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.device.IDeviceService.DeviceType;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000E"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptProcessor;", "Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptProcessor;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_backend", "Lcom/onesignal/notifications/internal/backend/INotificationBackendService;", "(Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/notifications/internal/backend/INotificationBackendService;)V", "sendReceiveReceipt", "", "appId", "", "subscriptionId", "notificationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ReceiveReceiptProcessor implements IReceiveReceiptProcessor {
    private final INotificationBackendService _backend;
    private final IDeviceService _deviceService;

    public ReceiveReceiptProcessor(IDeviceService iDeviceService0, INotificationBackendService iNotificationBackendService0) {
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(iNotificationBackendService0, "_backend");
        super();
        this._deviceService = iDeviceService0;
        this._backend = iNotificationBackendService0;
    }

    @Override  // com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor
    public Object sendReceiveReceipt(String s, String s1, String s2, Continuation continuation0) {
        com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor.sendReceiveReceipt.1 receiveReceiptProcessor$sendReceiveReceipt$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor.sendReceiveReceipt.1) {
            receiveReceiptProcessor$sendReceiveReceipt$10 = (com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor.sendReceiveReceipt.1)continuation0;
            if((receiveReceiptProcessor$sendReceiveReceipt$10.label & 0x80000000) == 0) {
                receiveReceiptProcessor$sendReceiveReceipt$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendReceiveReceipt(null, null, null, this);
                    }
                };
            }
            else {
                receiveReceiptProcessor$sendReceiveReceipt$10.label ^= 0x80000000;
            }
        }
        else {
            receiveReceiptProcessor$sendReceiveReceipt$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendReceiveReceipt(null, null, null, this);
                }
            };
        }
        Object object0 = receiveReceiptProcessor$sendReceiveReceipt$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(receiveReceiptProcessor$sendReceiveReceipt$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                DeviceType iDeviceService$DeviceType0 = this._deviceService.getDeviceType();
                try {
                    receiveReceiptProcessor$sendReceiveReceipt$10.label = 1;
                    if(this._backend.updateNotificationAsReceived(s, s2, s1, iDeviceService$DeviceType0, receiveReceiptProcessor$sendReceiveReceipt$10) == object1) {
                        return object1;
                    }
                }
                catch(BackendException backendException0) {
                    Logging.error$default(("Receive receipt failed with statusCode: " + backendException0.getStatusCode() + " response: " + backendException0.getResponse()), null, 2, null);
                }
                return Unit.INSTANCE;
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure(object0);
                }
                catch(BackendException backendException0) {
                    Logging.error$default(("Receive receipt failed with statusCode: " + backendException0.getStatusCode() + " response: " + backendException0.getResponse()), null, 2, null);
                }
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

