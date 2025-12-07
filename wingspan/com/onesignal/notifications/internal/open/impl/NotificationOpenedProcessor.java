package com.onesignal.notifications.internal.open.impl;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository.NotificationData;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.open.INotificationOpenedProcessor;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import java.util.List;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u00A2\u0006\u0002\u0010\nJ!\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0011J#\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0015J\u001A\u0010\u0016\u001A\u00020\f2\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001A\u00020\u0018H\u0003J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0017\u001A\u00020\u0018H\u0002J)\u0010\u001B\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u001AH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u0017\u001A\u00020\u0018H\u0002J!\u0010 \u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0018H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010!J!\u0010\"\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0018H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010!J/\u0010#\u001A\u0004\u0018\u00010$2\b\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001A\u00020\u00182\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010%R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006&"}, d2 = {"Lcom/onesignal/notifications/internal/open/impl/NotificationOpenedProcessor;", "Lcom/onesignal/notifications/internal/open/INotificationOpenedProcessor;", "_summaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_lifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "(Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;)V", "addChildNotifications", "", "dataArray", "Lorg/json/JSONArray;", "summaryGroup", "", "(Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearStatusBarNotifications", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDismissFromActionButtonPress", "intent", "Landroid/content/Intent;", "isOneSignalIntent", "", "markNotificationsConsumed", "dismissed", "(Landroid/content/Context;Landroid/content/Intent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newContentValuesWithConsumed", "Landroid/content/ContentValues;", "processFromContext", "(Landroid/content/Context;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processIntent", "processToOpenIntent", "Lcom/onesignal/notifications/internal/open/impl/NotificationIntentExtras;", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationOpenedProcessor implements INotificationOpenedProcessor {
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationLifecycleService _lifecycleService;
    private final INotificationSummaryManager _summaryManager;

    public NotificationOpenedProcessor(INotificationSummaryManager iNotificationSummaryManager0, INotificationRepository iNotificationRepository0, ConfigModelStore configModelStore0, INotificationLifecycleService iNotificationLifecycleService0) {
        Intrinsics.checkNotNullParameter(iNotificationSummaryManager0, "_summaryManager");
        Intrinsics.checkNotNullParameter(iNotificationRepository0, "_dataController");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService0, "_lifecycleService");
        super();
        this._summaryManager = iNotificationSummaryManager0;
        this._dataController = iNotificationRepository0;
        this._configModelStore = configModelStore0;
        this._lifecycleService = iNotificationLifecycleService0;
    }

    public static final Object access$clearStatusBarNotifications(NotificationOpenedProcessor notificationOpenedProcessor0, Context context0, String s, Continuation continuation0) {
        return notificationOpenedProcessor0.clearStatusBarNotifications(context0, s, continuation0);
    }

    private final Object addChildNotifications(JSONArray jSONArray0, String s, Continuation continuation0) {
        com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.addChildNotifications.1 notificationOpenedProcessor$addChildNotifications$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.addChildNotifications.1) {
            notificationOpenedProcessor$addChildNotifications$10 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.addChildNotifications.1)continuation0;
            if((notificationOpenedProcessor$addChildNotifications$10.label & 0x80000000) == 0) {
                notificationOpenedProcessor$addChildNotifications$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.addChildNotifications(null, null, this);
                    }
                };
            }
            else {
                notificationOpenedProcessor$addChildNotifications$10.label ^= 0x80000000;
            }
        }
        else {
            notificationOpenedProcessor$addChildNotifications$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.addChildNotifications(null, null, this);
                }
            };
        }
        Object object0 = notificationOpenedProcessor$addChildNotifications$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationOpenedProcessor$addChildNotifications$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                notificationOpenedProcessor$addChildNotifications$10.L$0 = jSONArray0;
                notificationOpenedProcessor$addChildNotifications$10.label = 1;
                object0 = this._dataController.listNotificationsForGroup(s, notificationOpenedProcessor$addChildNotifications$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
                jSONArray0 = (JSONArray)notificationOpenedProcessor$addChildNotifications$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        for(Object object2: ((List)object0)) {
            jSONArray0.put(new JSONObject(((NotificationData)object2).getFullData()));
        }
        return Unit.INSTANCE;
    }

    private final Object clearStatusBarNotifications(Context context0, String s, Continuation continuation0) {
        if(s != null) {
            Object object0 = this._summaryManager.clearNotificationOnSummaryClick(s, continuation0);
            return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
        }
        if(NotificationHelper.INSTANCE.getGrouplessNotifsCount(context0) < 1) {
            NotificationHelper.INSTANCE.getNotificationManager(context0).cancel(0xD52D1DDE);
        }
        return Unit.INSTANCE;
    }

    private final void handleDismissFromActionButtonPress(Context context0, Intent intent0) {
        if(intent0.getBooleanExtra("action_button", false)) {
            Intrinsics.checkNotNull(context0);
            NotificationManagerCompat.from(context0).cancel(intent0.getIntExtra("androidNotificationId", 0));
            if(Build.VERSION.SDK_INT < 0x1F) {
                context0.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
        }
    }

    // 去混淆评级： 低(30)
    private final boolean isOneSignalIntent(Intent intent0) {
        return intent0.hasExtra("onesignalData") || intent0.hasExtra("summary") || intent0.hasExtra("androidNotificationId");
    }

    private final Object markNotificationsConsumed(Context context0, Intent intent0, boolean z, Continuation continuation0) {
        String s1;
        boolean z1;
        NotificationOpenedProcessor notificationOpenedProcessor0;
        com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.markNotificationsConsumed.1 notificationOpenedProcessor$markNotificationsConsumed$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.markNotificationsConsumed.1) {
            notificationOpenedProcessor$markNotificationsConsumed$10 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.markNotificationsConsumed.1)continuation0;
            if((notificationOpenedProcessor$markNotificationsConsumed$10.label & 0x80000000) == 0) {
                notificationOpenedProcessor$markNotificationsConsumed$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    boolean Z$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.markNotificationsConsumed(null, null, false, this);
                    }
                };
            }
            else {
                notificationOpenedProcessor$markNotificationsConsumed$10.label ^= 0x80000000;
            }
        }
        else {
            notificationOpenedProcessor$markNotificationsConsumed$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                boolean Z$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.markNotificationsConsumed(null, null, false, this);
                }
            };
        }
        Object object0 = notificationOpenedProcessor$markNotificationsConsumed$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationOpenedProcessor$markNotificationsConsumed$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                String s = intent0.getStringExtra("summary");
                notificationOpenedProcessor$markNotificationsConsumed$10.L$0 = this;
                notificationOpenedProcessor$markNotificationsConsumed$10.L$1 = intent0;
                notificationOpenedProcessor$markNotificationsConsumed$10.L$2 = s;
                notificationOpenedProcessor$markNotificationsConsumed$10.Z$0 = z;
                notificationOpenedProcessor$markNotificationsConsumed$10.label = 1;
                if(this.clearStatusBarNotifications(context0, s, notificationOpenedProcessor$markNotificationsConsumed$10) == object1) {
                    return object1;
                }
                notificationOpenedProcessor0 = this;
                z1 = z;
                s1 = s;
                break;
            }
            case 1: {
                boolean z2 = notificationOpenedProcessor$markNotificationsConsumed$10.Z$0;
                String s2 = (String)notificationOpenedProcessor$markNotificationsConsumed$10.L$2;
                intent0 = (Intent)notificationOpenedProcessor$markNotificationsConsumed$10.L$1;
                notificationOpenedProcessor0 = (NotificationOpenedProcessor)notificationOpenedProcessor$markNotificationsConsumed$10.L$0;
                ResultKt.throwOnFailure(object0);
                s1 = s2;
                z1 = z2;
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
        int v = intent0.getIntExtra("androidNotificationId", 0);
        boolean z3 = ((ConfigModel)notificationOpenedProcessor0._configModelStore.getModel()).getClearGroupOnSummaryClick();
        notificationOpenedProcessor$markNotificationsConsumed$10.L$0 = null;
        notificationOpenedProcessor$markNotificationsConsumed$10.L$1 = null;
        notificationOpenedProcessor$markNotificationsConsumed$10.L$2 = null;
        notificationOpenedProcessor$markNotificationsConsumed$10.label = 2;
        return notificationOpenedProcessor0._dataController.markAsConsumed(v, z1, s1, z3, notificationOpenedProcessor$markNotificationsConsumed$10) == object1 ? object1 : Unit.INSTANCE;
    }

    private final ContentValues newContentValuesWithConsumed(Intent intent0) {
        ContentValues contentValues0 = new ContentValues();
        if(intent0.getBooleanExtra("dismissed", false)) {
            contentValues0.put("dismissed", 1);
            return contentValues0;
        }
        contentValues0.put("opened", 1);
        return contentValues0;
    }

    @Override  // com.onesignal.notifications.internal.open.INotificationOpenedProcessor
    public Object processFromContext(Context context0, Intent intent0, Continuation continuation0) {
        if(!this.isOneSignalIntent(intent0)) {
            return Unit.INSTANCE;
        }
        this.handleDismissFromActionButtonPress(context0, intent0);
        Object object0 = this.processIntent(context0, intent0, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    private final Object processIntent(Context context0, Intent intent0, Continuation continuation0) {
        NotificationOpenedProcessor notificationOpenedProcessor0;
        Context context1;
        Intent intent1;
        NotificationIntentExtras notificationIntentExtras0;
        boolean z;
        NotificationOpenedProcessor notificationOpenedProcessor1;
        Context context2;
        Intent intent2;
        String s;
        String s2;
        Object object2;
        boolean z2;
        NotificationOpenedProcessor notificationOpenedProcessor2;
        NotificationIntentExtras notificationIntentExtras1;
        com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processIntent.1 notificationOpenedProcessor$processIntent$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processIntent.1) {
            notificationOpenedProcessor$processIntent$10 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processIntent.1)continuation0;
            if((notificationOpenedProcessor$processIntent$10.label & 0x80000000) == 0) {
                notificationOpenedProcessor$processIntent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    boolean Z$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.processIntent(null, null, this);
                    }
                };
            }
            else {
                notificationOpenedProcessor$processIntent$10.label ^= 0x80000000;
            }
        }
        else {
            notificationOpenedProcessor$processIntent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                boolean Z$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.processIntent(null, null, this);
                }
            };
        }
        Object object0 = notificationOpenedProcessor$processIntent$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationOpenedProcessor$processIntent$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                s2 = intent0.getStringExtra("summary");
                z2 = intent0.getBooleanExtra("dismissed", false);
                if(z2) {
                    notificationOpenedProcessor2 = this;
                    notificationIntentExtras1 = null;
                }
                else {
                    notificationOpenedProcessor$processIntent$10.L$0 = this;
                    notificationOpenedProcessor$processIntent$10.L$1 = context0;
                    notificationOpenedProcessor$processIntent$10.L$2 = intent0;
                    notificationOpenedProcessor$processIntent$10.L$3 = s2;
                    notificationOpenedProcessor$processIntent$10.Z$0 = false;
                    notificationOpenedProcessor$processIntent$10.label = 1;
                    object2 = this.processToOpenIntent(context0, intent0, s2, notificationOpenedProcessor$processIntent$10);
                    if(object2 == object1) {
                        return object1;
                    }
                    notificationOpenedProcessor2 = this;
                label_55:
                    notificationIntentExtras1 = (NotificationIntentExtras)object2;
                    if(notificationIntentExtras1 == null) {
                        return Unit.INSTANCE;
                    }
                }
                break;
            }
            case 1: {
                boolean z1 = notificationOpenedProcessor$processIntent$10.Z$0;
                String s1 = (String)notificationOpenedProcessor$processIntent$10.L$3;
                Intent intent3 = (Intent)notificationOpenedProcessor$processIntent$10.L$2;
                Context context3 = (Context)notificationOpenedProcessor$processIntent$10.L$1;
                notificationOpenedProcessor2 = (NotificationOpenedProcessor)notificationOpenedProcessor$processIntent$10.L$0;
                ResultKt.throwOnFailure(object0);
                z2 = z1;
                context0 = context3;
                object2 = object0;
                s2 = s1;
                intent0 = intent3;
                goto label_55;
            }
            case 2: {
                z = notificationOpenedProcessor$processIntent$10.Z$0;
                notificationIntentExtras0 = (NotificationIntentExtras)notificationOpenedProcessor$processIntent$10.L$4;
                s = (String)notificationOpenedProcessor$processIntent$10.L$3;
                intent2 = (Intent)notificationOpenedProcessor$processIntent$10.L$2;
                context2 = (Context)notificationOpenedProcessor$processIntent$10.L$1;
                notificationOpenedProcessor1 = (NotificationOpenedProcessor)notificationOpenedProcessor$processIntent$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_75;
            }
            case 3: {
                z = notificationOpenedProcessor$processIntent$10.Z$0;
                notificationIntentExtras0 = (NotificationIntentExtras)notificationOpenedProcessor$processIntent$10.L$3;
                intent1 = (Intent)notificationOpenedProcessor$processIntent$10.L$2;
                context1 = (Context)notificationOpenedProcessor$processIntent$10.L$1;
                notificationOpenedProcessor0 = (NotificationOpenedProcessor)notificationOpenedProcessor$processIntent$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_90;
            }
            case 4: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        notificationOpenedProcessor$processIntent$10.L$0 = notificationOpenedProcessor2;
        notificationOpenedProcessor$processIntent$10.L$1 = context0;
        notificationOpenedProcessor$processIntent$10.L$2 = intent0;
        notificationOpenedProcessor$processIntent$10.L$3 = s2;
        notificationOpenedProcessor$processIntent$10.L$4 = notificationIntentExtras1;
        notificationOpenedProcessor$processIntent$10.Z$0 = z2;
        notificationOpenedProcessor$processIntent$10.label = 2;
        if(notificationOpenedProcessor2.markNotificationsConsumed(context0, intent0, z2, notificationOpenedProcessor$processIntent$10) == object1) {
            return object1;
        }
        notificationOpenedProcessor1 = notificationOpenedProcessor2;
        context2 = context0;
        z = z2;
        s = s2;
        intent2 = intent0;
        notificationIntentExtras0 = notificationIntentExtras1;
    label_75:
        if(s == null) {
            String s3 = intent2.getStringExtra("grp");
            if(s3 != null) {
                notificationOpenedProcessor$processIntent$10.L$0 = notificationOpenedProcessor1;
                notificationOpenedProcessor$processIntent$10.L$1 = context2;
                notificationOpenedProcessor$processIntent$10.L$2 = intent2;
                notificationOpenedProcessor$processIntent$10.L$3 = notificationIntentExtras0;
                notificationOpenedProcessor$processIntent$10.L$4 = null;
                notificationOpenedProcessor$processIntent$10.Z$0 = z;
                notificationOpenedProcessor$processIntent$10.label = 3;
                if(notificationOpenedProcessor1._summaryManager.updateSummaryNotificationAfterChildRemoved(s3, z, notificationOpenedProcessor$processIntent$10) == object1) {
                    return object1;
                }
                intent1 = intent2;
                context1 = context2;
                notificationOpenedProcessor0 = notificationOpenedProcessor1;
            label_90:
                context2 = context1;
                notificationOpenedProcessor1 = notificationOpenedProcessor0;
                intent2 = intent1;
            }
        }
        Logging.debug$default(("processIntent from context: " + context2 + " and intent: " + intent2), null, 2, null);
        if(intent2.getExtras() != null) {
            Logging.debug$default(("processIntent intent extras: " + intent2.getExtras()), null, 2, null);
        }
        if(!z) {
            if(!(context2 instanceof Activity)) {
                Logging.error$default(("NotificationOpenedProcessor processIntent from an non Activity context: " + context2), null, 2, null);
                return Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(notificationIntentExtras0);
            String s4 = NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(notificationIntentExtras0.getJsonData());
            Intrinsics.checkNotNull(s4);
            notificationOpenedProcessor$processIntent$10.L$0 = null;
            notificationOpenedProcessor$processIntent$10.L$1 = null;
            notificationOpenedProcessor$processIntent$10.L$2 = null;
            notificationOpenedProcessor$processIntent$10.L$3 = null;
            notificationOpenedProcessor$processIntent$10.L$4 = null;
            notificationOpenedProcessor$processIntent$10.label = 4;
            return notificationOpenedProcessor1._lifecycleService.notificationOpened(((Activity)context2), notificationIntentExtras0.getDataArray(), s4, notificationOpenedProcessor$processIntent$10) == object1 ? object1 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final Object processToOpenIntent(Context context0, Intent intent0, String s, Continuation continuation0) {
        JSONArray jSONArray0;
        Object object2;
        JSONObject jSONObject1;
        NotificationOpenedProcessor notificationOpenedProcessor0;
        JSONObject jSONObject0;
        com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processToOpenIntent.1 notificationOpenedProcessor$processToOpenIntent$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processToOpenIntent.1) {
            notificationOpenedProcessor$processToOpenIntent$10 = (com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor.processToOpenIntent.1)continuation0;
            if((notificationOpenedProcessor$processToOpenIntent$10.label & 0x80000000) == 0) {
                notificationOpenedProcessor$processToOpenIntent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.processToOpenIntent(null, null, null, this);
                    }
                };
            }
            else {
                notificationOpenedProcessor$processToOpenIntent$10.label ^= 0x80000000;
            }
        }
        else {
            notificationOpenedProcessor$processToOpenIntent$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.processToOpenIntent(null, null, null, this);
                }
            };
        }
        Object object0 = notificationOpenedProcessor$processToOpenIntent$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationOpenedProcessor$processToOpenIntent$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    jSONObject0 = new JSONObject(intent0.getStringExtra("onesignalData"));
                }
                catch(JSONException jSONException0) {
                    notificationOpenedProcessor0 = this;
                    jSONObject1 = null;
                    goto label_54;
                }
                try {
                    if(context0 instanceof Activity) {
                        notificationOpenedProcessor$processToOpenIntent$10.L$0 = this;
                        notificationOpenedProcessor$processToOpenIntent$10.L$1 = intent0;
                        notificationOpenedProcessor$processToOpenIntent$10.L$2 = s;
                        notificationOpenedProcessor$processToOpenIntent$10.L$3 = jSONObject0;
                        notificationOpenedProcessor$processToOpenIntent$10.label = 1;
                        object2 = this._lifecycleService.canOpenNotification(((Activity)context0), jSONObject0, notificationOpenedProcessor$processToOpenIntent$10);
                        goto label_35;
                    }
                    else {
                        Logging.error$default(("NotificationOpenedProcessor processIntent from an non Activity context: " + context0), null, 2, null);
                        notificationOpenedProcessor0 = this;
                        jSONObject1 = jSONObject0;
                    }
                    goto label_48;
                }
                catch(JSONException jSONException0) {
                    notificationOpenedProcessor0 = this;
                    jSONObject1 = jSONObject0;
                    goto label_54;
                }
            label_35:
                if(object2 == object1) {
                    return object1;
                }
                notificationOpenedProcessor0 = this;
                object0 = object2;
                jSONObject1 = jSONObject0;
                goto label_46;
            }
            case 1: {
                jSONObject1 = (JSONObject)notificationOpenedProcessor$processToOpenIntent$10.L$3;
                s = (String)notificationOpenedProcessor$processToOpenIntent$10.L$2;
                intent0 = (Intent)notificationOpenedProcessor$processToOpenIntent$10.L$1;
                notificationOpenedProcessor0 = (NotificationOpenedProcessor)notificationOpenedProcessor$processToOpenIntent$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_46:
                    if(!((Boolean)object0).booleanValue()) {
                        return null;
                    }
                label_48:
                    jSONObject1.put("androidNotificationId", intent0.getIntExtra("androidNotificationId", 0));
                    intent0.putExtra("onesignalData", jSONObject1.toString());
                    JSONObject jSONObject2 = new JSONObject(intent0.getStringExtra("onesignalData"));
                    jSONArray0 = JSONUtils.INSTANCE.wrapInJsonArray(jSONObject2);
                    goto label_56;
                }
                catch(JSONException jSONException0) {
                }
            label_54:
                jSONException0.printStackTrace();
                jSONArray0 = null;
            label_56:
                if(s != null) {
                    Intrinsics.checkNotNull(jSONArray0);
                    notificationOpenedProcessor$processToOpenIntent$10.L$0 = jSONArray0;
                    notificationOpenedProcessor$processToOpenIntent$10.L$1 = jSONObject1;
                    notificationOpenedProcessor$processToOpenIntent$10.L$2 = null;
                    notificationOpenedProcessor$processToOpenIntent$10.L$3 = null;
                    notificationOpenedProcessor$processToOpenIntent$10.label = 2;
                    if(notificationOpenedProcessor0.addChildNotifications(jSONArray0, s, notificationOpenedProcessor$processToOpenIntent$10) == object1) {
                        return object1;
                    }
                }
                Intrinsics.checkNotNull(jSONArray0);
                Intrinsics.checkNotNull(jSONObject1);
                return new NotificationIntentExtras(jSONArray0, jSONObject1);
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        jSONObject1 = (JSONObject)notificationOpenedProcessor$processToOpenIntent$10.L$1;
        jSONArray0 = (JSONArray)notificationOpenedProcessor$processToOpenIntent$10.L$0;
        ResultKt.throwOnFailure(object0);
        Intrinsics.checkNotNull(jSONArray0);
        Intrinsics.checkNotNull(jSONObject1);
        return new NotificationIntentExtras(jSONArray0, jSONObject1);
    }
}

