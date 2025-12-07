package com.onesignal.notifications.internal.open.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.common.JSONUtils;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0002J#\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ!\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u0006H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/onesignal/notifications/internal/open/impl/NotificationOpenedProcessorHMS;", "Lcom/onesignal/notifications/internal/open/INotificationOpenedProcessorHMS;", "_lifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "(Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;)V", "covertHMSOpenIntentToJson", "Lorg/json/JSONObject;", "intent", "Landroid/content/Intent;", "handleHMSNotificationOpenIntent", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleProcessJsonOpenData", "jsonData", "(Landroid/app/Activity;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reformatButtonClickAction", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationOpenedProcessorHMS implements INotificationOpenedProcessorHMS {
    private final INotificationLifecycleService _lifecycleService;

    public NotificationOpenedProcessorHMS(INotificationLifecycleService iNotificationLifecycleService0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService0, "_lifecycleService");
        super();
        this._lifecycleService = iNotificationLifecycleService0;
    }

    private final JSONObject covertHMSOpenIntentToJson(Intent intent0) {
        if(!NotificationFormatHelper.INSTANCE.isOneSignalIntent(intent0)) {
            return null;
        }
        Intrinsics.checkNotNull(intent0);
        Bundle bundle0 = intent0.getExtras();
        Intrinsics.checkNotNull(bundle0);
        JSONObject jSONObject0 = JSONUtils.INSTANCE.bundleAsJSONObject(bundle0);
        this.reformatButtonClickAction(jSONObject0);
        return jSONObject0;
    }

    @Override  // com.onesignal.notifications.internal.open.INotificationOpenedProcessorHMS
    public Object handleHMSNotificationOpenIntent(Activity activity0, Intent intent0, Continuation continuation0) {
        if(intent0 == null) {
            return Unit.INSTANCE;
        }
        JSONObject jSONObject0 = this.covertHMSOpenIntentToJson(intent0);
        if(jSONObject0 == null) {
            return Unit.INSTANCE;
        }
        Object object0 = this.handleProcessJsonOpenData(activity0, jSONObject0, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final Object handleProcessJsonOpenData(Activity activity0, JSONObject jSONObject0, Continuation continuation0) {
        NotificationOpenedProcessorHMS notificationOpenedProcessorHMS0;
        com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS.handleProcessJsonOpenData.1 notificationOpenedProcessorHMS$handleProcessJsonOpenData$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS.handleProcessJsonOpenData.1) {
            notificationOpenedProcessorHMS$handleProcessJsonOpenData$10 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS.handleProcessJsonOpenData.1)continuation0;
            if((notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.label & 0x80000000) == 0) {
                notificationOpenedProcessorHMS$handleProcessJsonOpenData$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.handleProcessJsonOpenData(null, null, this);
                    }
                };
            }
            else {
                notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.label ^= 0x80000000;
            }
        }
        else {
            notificationOpenedProcessorHMS$handleProcessJsonOpenData$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.handleProcessJsonOpenData(null, null, this);
                }
            };
        }
        Object object0 = notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$0 = this;
                notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$1 = activity0;
                notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$2 = jSONObject0;
                notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.label = 1;
                object0 = this._lifecycleService.canOpenNotification(activity0, jSONObject0, notificationOpenedProcessorHMS$handleProcessJsonOpenData$10);
                if(object0 == object1) {
                    return object1;
                }
                notificationOpenedProcessorHMS0 = this;
                break;
            }
            case 1: {
                jSONObject0 = (JSONObject)notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$2;
                activity0 = (Activity)notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$1;
                notificationOpenedProcessorHMS0 = (NotificationOpenedProcessorHMS)notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((Boolean)object0).booleanValue()) {
            return Unit.INSTANCE;
        }
        JSONArray jSONArray0 = JSONUtils.INSTANCE.wrapInJsonArray(jSONObject0);
        String s = NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(jSONObject0);
        Intrinsics.checkNotNull(s);
        notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$0 = null;
        notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$1 = null;
        notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.L$2 = null;
        notificationOpenedProcessorHMS$handleProcessJsonOpenData$10.label = 2;
        return notificationOpenedProcessorHMS0._lifecycleService.notificationOpened(activity0, jSONArray0, s, notificationOpenedProcessorHMS$handleProcessJsonOpenData$10) == object1 ? object1 : Unit.INSTANCE;
    }

    private final void reformatButtonClickAction(JSONObject jSONObject0) {
        try {
            String s = (String)NotificationHelper.INSTANCE.getCustomJSONObject(jSONObject0).remove("actionId");
            if(s == null) {
                return;
            }
            jSONObject0.put("actionId", s);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }
}

