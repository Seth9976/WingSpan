package com.onesignal.inAppMessages.internal.preview;

import android.app.Activity;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.notifications.internal.INotificationActivityOpener;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u001A\u001A\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001BJ\u0012\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u001E\u001A\u00020\u0017H\u0002J\b\u0010\u001F\u001A\u00020\u0013H\u0003J\b\u0010 \u001A\u00020!H\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/onesignal/inAppMessages/internal/preview/InAppMessagePreviewHandler;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleCallback;", "_iamDisplayer", "Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationDisplayer", "Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "_notificationActivityOpener", "Lcom/onesignal/notifications/internal/INotificationActivityOpener;", "_notificationLifeCycle", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_state", "Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/display/INotificationDisplayer;Lcom/onesignal/notifications/internal/INotificationActivityOpener;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/inAppMessages/internal/state/InAppStateService;Lcom/onesignal/core/internal/time/ITime;)V", "canOpenNotification", "", "activity", "Landroid/app/Activity;", "jsonData", "Lorg/json/JSONObject;", "(Landroid/app/Activity;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canReceiveNotification", "jsonPayload", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inAppPreviewPushUUID", "", "payload", "shouldDisplayNotification", "start", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessagePreviewHandler implements IStartableService, INotificationLifecycleCallback {
    private final IApplicationService _applicationService;
    private final IInAppDisplayer _iamDisplayer;
    private final INotificationActivityOpener _notificationActivityOpener;
    private final INotificationDisplayer _notificationDisplayer;
    private final INotificationLifecycleService _notificationLifeCycle;
    private final InAppStateService _state;
    private final ITime _time;

    public InAppMessagePreviewHandler(IInAppDisplayer iInAppDisplayer0, IApplicationService iApplicationService0, INotificationDisplayer iNotificationDisplayer0, INotificationActivityOpener iNotificationActivityOpener0, INotificationLifecycleService iNotificationLifecycleService0, InAppStateService inAppStateService0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iInAppDisplayer0, "_iamDisplayer");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationDisplayer0, "_notificationDisplayer");
        Intrinsics.checkNotNullParameter(iNotificationActivityOpener0, "_notificationActivityOpener");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService0, "_notificationLifeCycle");
        Intrinsics.checkNotNullParameter(inAppStateService0, "_state");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._iamDisplayer = iInAppDisplayer0;
        this._applicationService = iApplicationService0;
        this._notificationDisplayer = iNotificationDisplayer0;
        this._notificationActivityOpener = iNotificationActivityOpener0;
        this._notificationLifeCycle = iNotificationLifecycleService0;
        this._state = inAppStateService0;
        this._time = iTime0;
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback
    public Object canOpenNotification(Activity activity0, JSONObject jSONObject0, Continuation continuation0) {
        InAppMessagePreviewHandler inAppMessagePreviewHandler0;
        String s;
        com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canOpenNotification.1 inAppMessagePreviewHandler$canOpenNotification$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canOpenNotification.1) {
            inAppMessagePreviewHandler$canOpenNotification$10 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canOpenNotification.1)continuation0;
            if((inAppMessagePreviewHandler$canOpenNotification$10.label & 0x80000000) == 0) {
                inAppMessagePreviewHandler$canOpenNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.canOpenNotification(null, null, this);
                    }
                };
            }
            else {
                inAppMessagePreviewHandler$canOpenNotification$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagePreviewHandler$canOpenNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.canOpenNotification(null, null, this);
                }
            };
        }
        Object object0 = inAppMessagePreviewHandler$canOpenNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagePreviewHandler$canOpenNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                s = this.inAppPreviewPushUUID(jSONObject0);
                if(s == null) {
                    return Boxing.boxBoolean(true);
                }
                JSONArray jSONArray0 = new JSONArray().put(jSONObject0);
                Intrinsics.checkNotNullExpressionValue(jSONArray0, "JSONArray().put(jsonData)");
                inAppMessagePreviewHandler$canOpenNotification$10.L$0 = this;
                inAppMessagePreviewHandler$canOpenNotification$10.L$1 = s;
                inAppMessagePreviewHandler$canOpenNotification$10.label = 1;
                if(this._notificationActivityOpener.openDestinationActivity(activity0, jSONArray0, inAppMessagePreviewHandler$canOpenNotification$10) == object1) {
                    return object1;
                }
                inAppMessagePreviewHandler0 = this;
                goto label_30;
            }
            case 1: {
                String s1 = (String)inAppMessagePreviewHandler$canOpenNotification$10.L$1;
                InAppMessagePreviewHandler inAppMessagePreviewHandler1 = (InAppMessagePreviewHandler)inAppMessagePreviewHandler$canOpenNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                s = s1;
                inAppMessagePreviewHandler0 = inAppMessagePreviewHandler1;
            label_30:
                inAppMessagePreviewHandler0._state.setInAppMessageIdShowing(s);
                inAppMessagePreviewHandler$canOpenNotification$10.L$0 = inAppMessagePreviewHandler0;
                inAppMessagePreviewHandler$canOpenNotification$10.L$1 = null;
                inAppMessagePreviewHandler$canOpenNotification$10.label = 2;
                object0 = inAppMessagePreviewHandler0._iamDisplayer.displayPreviewMessage(s, inAppMessagePreviewHandler$canOpenNotification$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 2: {
                inAppMessagePreviewHandler0 = (InAppMessagePreviewHandler)inAppMessagePreviewHandler$canOpenNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((Boolean)object0).booleanValue()) {
            inAppMessagePreviewHandler0._state.setInAppMessageIdShowing(null);
        }
        return Boxing.boxBoolean(false);
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback
    public Object canReceiveNotification(JSONObject jSONObject0, Continuation continuation0) {
        InAppMessagePreviewHandler inAppMessagePreviewHandler0;
        com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canReceiveNotification.1 inAppMessagePreviewHandler$canReceiveNotification$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canReceiveNotification.1) {
            inAppMessagePreviewHandler$canReceiveNotification$10 = (com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler.canReceiveNotification.1)continuation0;
            if((inAppMessagePreviewHandler$canReceiveNotification$10.label & 0x80000000) == 0) {
                inAppMessagePreviewHandler$canReceiveNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.canReceiveNotification(null, this);
                    }
                };
            }
            else {
                inAppMessagePreviewHandler$canReceiveNotification$10.label ^= 0x80000000;
            }
        }
        else {
            inAppMessagePreviewHandler$canReceiveNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.canReceiveNotification(null, this);
                }
            };
        }
        Object object0 = inAppMessagePreviewHandler$canReceiveNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppMessagePreviewHandler$canReceiveNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                String s = this.inAppPreviewPushUUID(jSONObject0);
                if(s == null) {
                    return Boxing.boxBoolean(true);
                }
                if(this._applicationService.isInForeground()) {
                    this._state.setInAppMessageIdShowing(s);
                    inAppMessagePreviewHandler$canReceiveNotification$10.L$0 = this;
                    inAppMessagePreviewHandler$canReceiveNotification$10.label = 1;
                    object0 = this._iamDisplayer.displayPreviewMessage(s, inAppMessagePreviewHandler$canReceiveNotification$10);
                    if(object0 == object1) {
                        return object1;
                    }
                    inAppMessagePreviewHandler0 = this;
                    goto label_33;
                }
                else {
                    NotificationGenerationJob notificationGenerationJob0 = new NotificationGenerationJob(jSONObject0, this._time);
                    inAppMessagePreviewHandler$canReceiveNotification$10.label = 2;
                    if(this._notificationDisplayer.displayNotification(notificationGenerationJob0, inAppMessagePreviewHandler$canReceiveNotification$10) == object1) {
                        return object1;
                    }
                }
                break;
            }
            case 1: {
                inAppMessagePreviewHandler0 = (InAppMessagePreviewHandler)inAppMessagePreviewHandler$canReceiveNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_33:
                if(!((Boolean)object0).booleanValue()) {
                    inAppMessagePreviewHandler0._state.setInAppMessageIdShowing(null);
                    return Boxing.boxBoolean(false);
                }
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(false);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return Boxing.boxBoolean(false);
    }

    private final String inAppPreviewPushUUID(JSONObject jSONObject0) {
        JSONObject jSONObject1;
        try {
            jSONObject1 = NotificationHelper.INSTANCE.getCustomJSONObject(jSONObject0);
        }
        catch(JSONException unused_ex) {
            return null;
        }
        if(!jSONObject1.has("a")) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject1.optJSONObject("a");
        return jSONObject2 == null || !jSONObject2.has("os_in_app_message_preview_id") ? null : jSONObject2.optString("os_in_app_message_preview_id");
    }

    private final boolean shouldDisplayNotification() [...] // Inlined contents

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._notificationLifeCycle.setInternalNotificationLifecycleCallback(this);
    }
}

