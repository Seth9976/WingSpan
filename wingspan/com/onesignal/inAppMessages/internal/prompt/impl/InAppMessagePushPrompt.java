package com.onesignal.inAppMessages.internal.prompt.impl;

import com.onesignal.notifications.INotificationsManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\t\u001A\u0004\u0018\u00010\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000BR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePushPrompt;", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "_notificationsManager", "Lcom/onesignal/notifications/INotificationsManager;", "(Lcom/onesignal/notifications/INotificationsManager;)V", "promptKey", "", "getPromptKey", "()Ljava/lang/String;", "handlePrompt", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt$PromptActionResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessagePushPrompt extends InAppMessagePrompt {
    private final INotificationsManager _notificationsManager;

    public InAppMessagePushPrompt(INotificationsManager iNotificationsManager0) {
        Intrinsics.checkNotNullParameter(iNotificationsManager0, "_notificationsManager");
        super();
        this._notificationsManager = iNotificationsManager0;
    }

    @Override  // com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt
    public String getPromptKey() {
        return "push";
    }

    @Override  // com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt
    public Object handlePrompt(Continuation continuation0) {
        com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt.handlePrompt.1 inAppMessagePushPrompt$handlePrompt$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt.handlePrompt.1) {
            inAppMessagePushPrompt$handlePrompt$10 = (com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePushPrompt.handlePrompt.1)continuation0;
            if((inAppMessagePushPrompt$handlePrompt$10.label & 0x80000000) == 0) {
                inAppMessagePushPrompt$handlePrompt$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.handlePrompt(this);
                    }
                };
            }
            else {
                inAppMessagePushPrompt$handlePrompt$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagePushPrompt$handlePrompt$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.handlePrompt(this);
                }
            };
        }
        Object object0 = inAppMessagePushPrompt$handlePrompt$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagePushPrompt$handlePrompt$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                inAppMessagePushPrompt$handlePrompt$10.label = 1;
                object0 = this._notificationsManager.requestPermission(true, inAppMessagePushPrompt$handlePrompt$10);
                if(object0 == object1) {
                    return object1;
                }
                return ((Boolean)object0).booleanValue() ? PromptActionResult.PERMISSION_GRANTED : PromptActionResult.PERMISSION_DENIED;
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                return ((Boolean)object0).booleanValue() ? PromptActionResult.PERMISSION_GRANTED : PromptActionResult.PERMISSION_DENIED;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

