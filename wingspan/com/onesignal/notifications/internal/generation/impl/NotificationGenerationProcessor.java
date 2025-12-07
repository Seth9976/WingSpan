package com.onesignal.notifications.internal.generation.impl;

import android.content.Context;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.Notification;
import com.onesignal.notifications.internal.NotificationReceivedEvent;
import com.onesignal.notifications.internal.NotificationWillDisplayEvent;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayer;
import com.onesignal.notifications.internal.generation.INotificationGenerationProcessor;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u00A2\u0006\u0002\u0010\u0010J\u000E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0012J\u0019\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0019\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001EJ)\u0010\u001F\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\u001D2\u0006\u0010!\u001A\u00020\u00152\u0006\u0010\"\u001A\u00020\u0015H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010#J\u0019\u0010$\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\u001DH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001EJ+\u0010%\u001A\u0004\u0018\u00010\u00152\u0006\u0010 \u001A\u00020\u001D2\u0006\u0010&\u001A\u00020\u00152\u0006\u0010\'\u001A\u00020\u0015H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010#J9\u0010(\u001A\u00020\u001B2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020\u00122\u0006\u0010\'\u001A\u00020\u00152\u0006\u0010.\u001A\u00020/H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00100J!\u00101\u001A\u00020\u001B2\u0006\u0010 \u001A\u00020\u001D2\u0006\u00102\u001A\u00020\u0015H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00103J\u0010\u00104\u001A\u00020\u00152\u0006\u0010 \u001A\u00020\u001DH\u0002J\u0010\u00105\u001A\u00020\u00152\u0006\u0010 \u001A\u00020\u001DH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u00066"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationProcessor;", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationProcessor;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationDisplayer", "Lcom/onesignal/notifications/internal/display/INotificationDisplayer;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_notificationSummaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "_lifecycleService", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/display/INotificationDisplayer;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;Lcom/onesignal/core/internal/time/ITime;)V", "getCustomJSONObject", "Lorg/json/JSONObject;", "jsonObject", "isDuplicateNotification", "", "notification", "Lcom/onesignal/notifications/internal/Notification;", "(Lcom/onesignal/notifications/internal/Notification;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNotificationWithinTTL", "markNotificationAsDismissed", "", "notifiJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postProcessNotification", "notificationJob", "wasOpened", "wasDisplayed", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCollapseKey", "processHandlerResponse", "wantsToDisplay", "isRestoring", "processNotificationData", "context", "Landroid/content/Context;", "androidNotificationId", "", "jsonPayload", "timestamp", "", "(Landroid/content/Context;ILorg/json/JSONObject;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveNotification", "opened", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisplayNotification", "shouldFireForegroundHandlers", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationGenerationProcessor implements INotificationGenerationProcessor {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationLifecycleService _lifecycleService;
    private final INotificationDisplayer _notificationDisplayer;
    private final INotificationSummaryManager _notificationSummaryManager;
    private final ITime _time;

    public NotificationGenerationProcessor(IApplicationService iApplicationService0, INotificationDisplayer iNotificationDisplayer0, ConfigModelStore configModelStore0, INotificationRepository iNotificationRepository0, INotificationSummaryManager iNotificationSummaryManager0, INotificationLifecycleService iNotificationLifecycleService0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationDisplayer0, "_notificationDisplayer");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iNotificationRepository0, "_dataController");
        Intrinsics.checkNotNullParameter(iNotificationSummaryManager0, "_notificationSummaryManager");
        Intrinsics.checkNotNullParameter(iNotificationLifecycleService0, "_lifecycleService");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._notificationDisplayer = iNotificationDisplayer0;
        this._configModelStore = configModelStore0;
        this._dataController = iNotificationRepository0;
        this._notificationSummaryManager = iNotificationSummaryManager0;
        this._lifecycleService = iNotificationLifecycleService0;
        this._time = iTime0;
    }

    public static final Object access$isDuplicateNotification(NotificationGenerationProcessor notificationGenerationProcessor0, Notification notification0, Continuation continuation0) {
        return notificationGenerationProcessor0.isDuplicateNotification(notification0, continuation0);
    }

    public final JSONObject getCustomJSONObject(JSONObject jSONObject0) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        return new JSONObject(jSONObject0.optString("custom"));
    }

    private final Object isDuplicateNotification(Notification notification0, Continuation continuation0) {
        return this._dataController.doesNotificationExist(notification0.getNotificationId(), continuation0);
    }

    private final boolean isNotificationWithinTTL(Notification notification0) {
        return ((ConfigModel)this._configModelStore.getModel()).getRestoreTTLFilter() ? notification0.getSentTime() + ((long)notification0.getTtl()) > this._time.getCurrentTimeMillis() / 1000L : true;
    }

    private final Object markNotificationAsDismissed(NotificationGenerationJob notificationGenerationJob0, Continuation continuation0) {
        NotificationGenerationProcessor notificationGenerationProcessor0;
        com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.markNotificationAsDismissed.1 notificationGenerationProcessor$markNotificationAsDismissed$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.markNotificationAsDismissed.1) {
            notificationGenerationProcessor$markNotificationAsDismissed$10 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.markNotificationAsDismissed.1)continuation0;
            if((notificationGenerationProcessor$markNotificationAsDismissed$10.label & 0x80000000) == 0) {
                notificationGenerationProcessor$markNotificationAsDismissed$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.markNotificationAsDismissed(null, this);
                    }
                };
            }
            else {
                notificationGenerationProcessor$markNotificationAsDismissed$10.label ^= 0x80000000;
            }
        }
        else {
            notificationGenerationProcessor$markNotificationAsDismissed$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.markNotificationAsDismissed(null, this);
                }
            };
        }
        Object object0 = notificationGenerationProcessor$markNotificationAsDismissed$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationGenerationProcessor$markNotificationAsDismissed$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(!notificationGenerationJob0.isNotificationToDisplay()) {
                    return Unit.INSTANCE;
                }
                Logging.debug$default(("Marking restored or disabled notifications as dismissed: " + notificationGenerationJob0), null, 2, null);
                int v = notificationGenerationJob0.getAndroidId();
                notificationGenerationProcessor$markNotificationAsDismissed$10.L$0 = this;
                notificationGenerationProcessor$markNotificationAsDismissed$10.L$1 = notificationGenerationJob0;
                notificationGenerationProcessor$markNotificationAsDismissed$10.label = 1;
                object0 = this._dataController.markAsDismissed(v, notificationGenerationProcessor$markNotificationAsDismissed$10);
                if(object0 == object1) {
                    return object1;
                }
                notificationGenerationProcessor0 = this;
                break;
            }
            case 1: {
                notificationGenerationJob0 = (NotificationGenerationJob)notificationGenerationProcessor$markNotificationAsDismissed$10.L$1;
                notificationGenerationProcessor0 = (NotificationGenerationProcessor)notificationGenerationProcessor$markNotificationAsDismissed$10.L$0;
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
        if(((Boolean)object0).booleanValue()) {
            int v1 = notificationGenerationJob0.getAndroidId();
            notificationGenerationProcessor$markNotificationAsDismissed$10.L$0 = null;
            notificationGenerationProcessor$markNotificationAsDismissed$10.L$1 = null;
            notificationGenerationProcessor$markNotificationAsDismissed$10.label = 2;
            return notificationGenerationProcessor0._notificationSummaryManager.updatePossibleDependentSummaryOnDismiss(v1, notificationGenerationProcessor$markNotificationAsDismissed$10) == object1 ? object1 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final Object postProcessNotification(NotificationGenerationJob notificationGenerationJob0, boolean z, boolean z1, Continuation continuation0) {
        NotificationGenerationProcessor notificationGenerationProcessor0;
        com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.postProcessNotification.1 notificationGenerationProcessor$postProcessNotification$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.postProcessNotification.1) {
            notificationGenerationProcessor$postProcessNotification$10 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.postProcessNotification.1)continuation0;
            if((notificationGenerationProcessor$postProcessNotification$10.label & 0x80000000) == 0) {
                notificationGenerationProcessor$postProcessNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    boolean Z$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.postProcessNotification(null, false, false, this);
                    }
                };
            }
            else {
                notificationGenerationProcessor$postProcessNotification$10.label ^= 0x80000000;
            }
        }
        else {
            notificationGenerationProcessor$postProcessNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                boolean Z$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.postProcessNotification(null, false, false, this);
                }
            };
        }
        Object object0 = notificationGenerationProcessor$postProcessNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationGenerationProcessor$postProcessNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                notificationGenerationProcessor$postProcessNotification$10.L$0 = this;
                notificationGenerationProcessor$postProcessNotification$10.L$1 = notificationGenerationJob0;
                notificationGenerationProcessor$postProcessNotification$10.Z$0 = z1;
                notificationGenerationProcessor$postProcessNotification$10.label = 1;
                if(this.saveNotification(notificationGenerationJob0, z, notificationGenerationProcessor$postProcessNotification$10) == object1) {
                    return object1;
                }
                notificationGenerationProcessor0 = this;
                break;
            }
            case 1: {
                z1 = notificationGenerationProcessor$postProcessNotification$10.Z$0;
                notificationGenerationJob0 = (NotificationGenerationJob)notificationGenerationProcessor$postProcessNotification$10.L$1;
                notificationGenerationProcessor0 = (NotificationGenerationProcessor)notificationGenerationProcessor$postProcessNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            case 3: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!z1) {
            notificationGenerationProcessor$postProcessNotification$10.L$0 = null;
            notificationGenerationProcessor$postProcessNotification$10.L$1 = null;
            notificationGenerationProcessor$postProcessNotification$10.label = 2;
            return notificationGenerationProcessor0.markNotificationAsDismissed(notificationGenerationJob0, notificationGenerationProcessor$postProcessNotification$10) == object1 ? object1 : Unit.INSTANCE;
        }
        notificationGenerationProcessor$postProcessNotification$10.L$0 = null;
        notificationGenerationProcessor$postProcessNotification$10.L$1 = null;
        notificationGenerationProcessor$postProcessNotification$10.label = 3;
        return notificationGenerationProcessor0._lifecycleService.notificationReceived(notificationGenerationJob0, notificationGenerationProcessor$postProcessNotification$10) == object1 ? object1 : Unit.INSTANCE;
    }

    private final Object processCollapseKey(NotificationGenerationJob notificationGenerationJob0, Continuation continuation0) {
        com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processCollapseKey.1 notificationGenerationProcessor$processCollapseKey$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processCollapseKey.1) {
            notificationGenerationProcessor$processCollapseKey$10 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processCollapseKey.1)continuation0;
            if((notificationGenerationProcessor$processCollapseKey$10.label & 0x80000000) == 0) {
                notificationGenerationProcessor$processCollapseKey$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.processCollapseKey(null, this);
                    }
                };
            }
            else {
                notificationGenerationProcessor$processCollapseKey$10.label ^= 0x80000000;
            }
        }
        else {
            notificationGenerationProcessor$processCollapseKey$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.processCollapseKey(null, this);
                }
            };
        }
        Object object0 = notificationGenerationProcessor$processCollapseKey$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationGenerationProcessor$processCollapseKey$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(notificationGenerationJob0.isRestoring()) {
                    return Unit.INSTANCE;
                }
                if(!notificationGenerationJob0.getJsonPayload().has("collapse_key") || Intrinsics.areEqual("do_not_collapse", notificationGenerationJob0.getJsonPayload().optString("collapse_key"))) {
                    return Unit.INSTANCE;
                }
                String s = notificationGenerationJob0.getJsonPayload().optString("collapse_key");
                Intrinsics.checkNotNullExpressionValue(s, "collapseId");
                notificationGenerationProcessor$processCollapseKey$10.L$0 = notificationGenerationJob0;
                notificationGenerationProcessor$processCollapseKey$10.label = 1;
                object0 = this._dataController.getAndroidIdFromCollapseKey(s, notificationGenerationProcessor$processCollapseKey$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
                notificationGenerationJob0 = (NotificationGenerationJob)notificationGenerationProcessor$processCollapseKey$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((Integer)object0) != null) {
            notificationGenerationJob0.getNotification().setAndroidNotificationId(((int)(((Integer)object0))));
        }
        return Unit.INSTANCE;
    }

    private final Object processHandlerResponse(NotificationGenerationJob notificationGenerationJob0, boolean z, boolean z1, Continuation continuation0) {
        NotificationGenerationProcessor notificationGenerationProcessor0;
        com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processHandlerResponse.1 notificationGenerationProcessor$processHandlerResponse$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processHandlerResponse.1) {
            notificationGenerationProcessor$processHandlerResponse$10 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processHandlerResponse.1)continuation0;
            if((notificationGenerationProcessor$processHandlerResponse$10.label & 0x80000000) == 0) {
                notificationGenerationProcessor$processHandlerResponse$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.processHandlerResponse(null, false, false, this);
                    }
                };
            }
            else {
                notificationGenerationProcessor$processHandlerResponse$10.label ^= 0x80000000;
            }
        }
        else {
            notificationGenerationProcessor$processHandlerResponse$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.processHandlerResponse(null, false, false, this);
                }
            };
        }
        Object object0 = notificationGenerationProcessor$processHandlerResponse$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationGenerationProcessor$processHandlerResponse$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(z && (AndroidUtils.INSTANCE.isStringNotEmpty(notificationGenerationJob0.getNotification().getBody()) && this.isNotificationWithinTTL(notificationGenerationJob0.getNotification()))) {
                    notificationGenerationProcessor$processHandlerResponse$10.L$0 = this;
                    notificationGenerationProcessor$processHandlerResponse$10.L$1 = notificationGenerationJob0;
                    notificationGenerationProcessor$processHandlerResponse$10.label = 1;
                    if(this.processCollapseKey(notificationGenerationJob0, notificationGenerationProcessor$processHandlerResponse$10) == object1) {
                        return object1;
                    }
                    notificationGenerationProcessor0 = this;
                    break;
                }
                if(z1) {
                    notificationGenerationProcessor$processHandlerResponse$10.label = 2;
                    return this.markNotificationAsDismissed(notificationGenerationJob0, notificationGenerationProcessor$processHandlerResponse$10) == object1 ? object1 : null;
                }
                notificationGenerationJob0.setNotificationToDisplay(false);
                notificationGenerationProcessor$processHandlerResponse$10.label = 3;
                return this.postProcessNotification(notificationGenerationJob0, true, false, notificationGenerationProcessor$processHandlerResponse$10) == object1 ? object1 : null;
            }
            case 1: {
                notificationGenerationJob0 = (NotificationGenerationJob)notificationGenerationProcessor$processHandlerResponse$10.L$1;
                notificationGenerationProcessor0 = (NotificationGenerationProcessor)notificationGenerationProcessor$processHandlerResponse$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: 
            case 3: {
                ResultKt.throwOnFailure(object0);
                return null;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(notificationGenerationProcessor0.shouldDisplayNotification(notificationGenerationJob0)) {
            notificationGenerationJob0.setNotificationToDisplay(true);
            return Boxing.boxBoolean(true);
        }
        return Boxing.boxBoolean(false);
    }

    @Override  // com.onesignal.notifications.internal.generation.INotificationGenerationProcessor
    public Object processNotificationData(Context context0, int v, JSONObject jSONObject0, boolean z, long v1, Continuation continuation0) {
        NotificationGenerationJob notificationGenerationJob4;
        NotificationGenerationProcessor notificationGenerationProcessor7;
        NotificationGenerationJob notificationGenerationJob3;
        int v9;
        boolean z10;
        NotificationGenerationProcessor notificationGenerationProcessor6;
        boolean z9;
        boolean z8;
        NotificationGenerationJob notificationGenerationJob2;
        boolean z7;
        boolean z5;
        NotificationGenerationProcessor notificationGenerationProcessor4;
        BooleanRef ref$BooleanRef2;
        boolean z4;
        int v7;
        BooleanRef ref$BooleanRef1;
        NotificationGenerationJob notificationGenerationJob1;
        Notification notification2;
        long v6;
        Context context2;
        NotificationGenerationProcessor notificationGenerationProcessor2;
        Notification notification1;
        boolean z3;
        NotificationGenerationProcessor notificationGenerationProcessor0;
        Context context1;
        long v3;
        boolean z2;
        JSONObject jSONObject1;
        int v2;
        com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.1 notificationGenerationProcessor$processNotificationData$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.1) {
            notificationGenerationProcessor$processNotificationData$10 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.1)continuation0;
            if((notificationGenerationProcessor$processNotificationData$10.label & 0x80000000) == 0) {
                notificationGenerationProcessor$processNotificationData$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    long J$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    boolean Z$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.processNotificationData(null, 0, null, false, 0L, this);
                    }
                };
            }
            else {
                notificationGenerationProcessor$processNotificationData$10.label ^= 0x80000000;
            }
        }
        else {
            notificationGenerationProcessor$processNotificationData$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                long J$0;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                boolean Z$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.processNotificationData(null, 0, null, false, 0L, this);
                }
            };
        }
        Object object0 = notificationGenerationProcessor$processNotificationData$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z1 = true;
        switch(notificationGenerationProcessor$processNotificationData$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                notificationGenerationProcessor$processNotificationData$10.L$0 = this;
                notificationGenerationProcessor$processNotificationData$10.L$1 = context0;
                notificationGenerationProcessor$processNotificationData$10.L$2 = jSONObject0;
                v2 = v;
                notificationGenerationProcessor$processNotificationData$10.I$0 = v2;
                notificationGenerationProcessor$processNotificationData$10.Z$0 = z;
                notificationGenerationProcessor$processNotificationData$10.J$0 = v1;
                notificationGenerationProcessor$processNotificationData$10.label = 1;
                object0 = this._lifecycleService.canReceiveNotification(jSONObject0, notificationGenerationProcessor$processNotificationData$10);
                if(object0 == object1) {
                    return object1;
                }
                jSONObject1 = jSONObject0;
                z2 = z;
                v3 = v1;
                context1 = context0;
                notificationGenerationProcessor0 = this;
                goto label_43;
            }
            case 1: {
                long v4 = notificationGenerationProcessor$processNotificationData$10.J$0;
                z2 = notificationGenerationProcessor$processNotificationData$10.Z$0;
                int v5 = notificationGenerationProcessor$processNotificationData$10.I$0;
                jSONObject1 = (JSONObject)notificationGenerationProcessor$processNotificationData$10.L$2;
                context1 = (Context)notificationGenerationProcessor$processNotificationData$10.L$1;
                NotificationGenerationProcessor notificationGenerationProcessor1 = (NotificationGenerationProcessor)notificationGenerationProcessor$processNotificationData$10.L$0;
                ResultKt.throwOnFailure(object0);
                v2 = v5;
                notificationGenerationProcessor0 = notificationGenerationProcessor1;
                v3 = v4;
            label_43:
                if(!((Boolean)object0).booleanValue()) {
                    return Unit.INSTANCE;
                }
                Notification notification0 = new Notification(null, jSONObject1, v2, notificationGenerationProcessor0._time);
                if(z2) {
                    notificationGenerationProcessor2 = notificationGenerationProcessor0;
                    notification1 = notification0;
                    z3 = true;
                }
                else {
                    notificationGenerationProcessor$processNotificationData$10.L$0 = notificationGenerationProcessor0;
                    notificationGenerationProcessor$processNotificationData$10.L$1 = context1;
                    notificationGenerationProcessor$processNotificationData$10.L$2 = jSONObject1;
                    notificationGenerationProcessor$processNotificationData$10.L$3 = notification0;
                    notificationGenerationProcessor$processNotificationData$10.Z$0 = false;
                    notificationGenerationProcessor$processNotificationData$10.J$0 = v3;
                    notificationGenerationProcessor$processNotificationData$10.label = 2;
                    Object object2 = notificationGenerationProcessor0.isDuplicateNotification(notification0, notificationGenerationProcessor$processNotificationData$10);
                    if(object2 == object1) {
                        return object1;
                    }
                    notification1 = notification0;
                    object0 = object2;
                    notificationGenerationProcessor2 = notificationGenerationProcessor0;
                    context2 = context1;
                    v6 = v3;
                    goto label_74;
                }
                goto label_79;
            }
            case 2: {
                v6 = notificationGenerationProcessor$processNotificationData$10.J$0;
                z2 = notificationGenerationProcessor$processNotificationData$10.Z$0;
                notification1 = (Notification)notificationGenerationProcessor$processNotificationData$10.L$3;
                jSONObject1 = (JSONObject)notificationGenerationProcessor$processNotificationData$10.L$2;
                context2 = (Context)notificationGenerationProcessor$processNotificationData$10.L$1;
                notificationGenerationProcessor2 = (NotificationGenerationProcessor)notificationGenerationProcessor$processNotificationData$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_74:
                if(((Boolean)object0).booleanValue()) {
                    return Unit.INSTANCE;
                }
                z3 = z2;
                context1 = context2;
                v3 = v6;
            label_79:
                NotificationGenerationJob notificationGenerationJob0 = new NotificationGenerationJob(notification1, jSONObject1);
                notificationGenerationJob0.setShownTimeStamp(Boxing.boxLong(v3));
                notificationGenerationJob0.setRestoring(z3);
                BooleanRef ref$BooleanRef0 = new BooleanRef();
                ref$BooleanRef0.element = true;
                Logging.info$default("Fire remoteNotificationReceived", null, 2, null);
                try {
                    com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.2 notificationGenerationProcessor$processNotificationData$20 = new Function2(new NotificationReceivedEvent(context1, notification1), ref$BooleanRef0, notification1, null) {
                        final Notification $notification;
                        final NotificationReceivedEvent $notificationReceivedEvent;
                        final BooleanRef $wantsToDisplay;
                        int label;

                        {
                            NotificationGenerationProcessor.this = notificationGenerationProcessor0;
                            this.$notificationReceivedEvent = notificationReceivedEvent0;
                            this.$wantsToDisplay = ref$BooleanRef0;
                            this.$notification = notification0;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.2(NotificationGenerationProcessor.this, this.$notificationReceivedEvent, this.$wantsToDisplay, this.$notification, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch(this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure(object0);
                                    com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.2.1 notificationGenerationProcessor$processNotificationData$2$10 = new Function2(this.$notificationReceivedEvent, this.$wantsToDisplay, this.$notification, null) {
                                        final Notification $notification;
                                        final NotificationReceivedEvent $notificationReceivedEvent;
                                        final BooleanRef $wantsToDisplay;
                                        int label;

                                        {
                                            NotificationGenerationProcessor.this = notificationGenerationProcessor0;
                                            this.$notificationReceivedEvent = notificationReceivedEvent0;
                                            this.$wantsToDisplay = ref$BooleanRef0;
                                            this.$notification = notification0;
                                            super(2, continuation0);
                                        }

                                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.2.1(NotificationGenerationProcessor.this, this.$notificationReceivedEvent, this.$wantsToDisplay, this.$notification, continuation0);
                                        }

                                        @Override  // kotlin.jvm.functions.Function2
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object object0) {
                                            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch(this.label) {
                                                case 0: {
                                                    ResultKt.throwOnFailure(object0);
                                                    NotificationGenerationProcessor.this._lifecycleService.externalRemoteNotificationReceived(this.$notificationReceivedEvent);
                                                    if(this.$notificationReceivedEvent.isPreventDefault()) {
                                                        this.$wantsToDisplay.element = false;
                                                        this.label = 1;
                                                        if(this.$notification.getDisplayWaiter().waitForWake(this) == object1) {
                                                            return object1;
                                                        }
                                                        this.$wantsToDisplay.element = true;
                                                        return Unit.INSTANCE;
                                                    }
                                                    break;
                                                }
                                                case 1: {
                                                    ResultKt.throwOnFailure(object0);
                                                    this.$wantsToDisplay.element = true;
                                                    break;
                                                }
                                                default: {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    Job job0 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, notificationGenerationProcessor$processNotificationData$2$10, 2, null);
                                    this.label = 1;
                                    return job0.join(this) == object1 ? object1 : Unit.INSTANCE;
                                }
                                case 1: {
                                    ResultKt.throwOnFailure(object0);
                                    return Unit.INSTANCE;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    notificationGenerationProcessor$processNotificationData$10.L$0 = notificationGenerationProcessor2;
                    notificationGenerationProcessor$processNotificationData$10.L$1 = notification1;
                    notificationGenerationProcessor$processNotificationData$10.L$2 = notificationGenerationJob0;
                    notificationGenerationProcessor$processNotificationData$10.L$3 = ref$BooleanRef0;
                    notificationGenerationProcessor$processNotificationData$10.Z$0 = z3;
                    notificationGenerationProcessor$processNotificationData$10.I$0 = 0;
                    notificationGenerationProcessor$processNotificationData$10.label = 3;
                    if(TimeoutKt.withTimeout(30000L, notificationGenerationProcessor$processNotificationData$20, notificationGenerationProcessor$processNotificationData$10) == object1) {
                        return object1;
                    }
                    goto label_112;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                    notification2 = notification1;
                    notificationGenerationJob1 = notificationGenerationJob0;
                    ref$BooleanRef1 = ref$BooleanRef0;
                    v7 = 0;
                    z4 = z3;
                    Logging.error(("remoteNotificationReceived timed out, continuing with wantsToDisplay=" + ref$BooleanRef1.element + '.'), timeoutCancellationException0);
                    goto label_134;
                }
                catch(Throwable throwable0) {
                    notification2 = notification1;
                    notificationGenerationJob1 = notificationGenerationJob0;
                    ref$BooleanRef1 = ref$BooleanRef0;
                    v7 = 0;
                    z4 = z3;
                    Logging.error("remoteNotificationReceived threw an exception. Displaying normal OneSignal notification.", throwable0);
                    goto label_134;
                }
                return object1;
            label_112:
                notification2 = notification1;
                notificationGenerationJob1 = notificationGenerationJob0;
                ref$BooleanRef1 = ref$BooleanRef0;
                v7 = 0;
                z4 = z3;
                goto label_134;
            }
            case 3: {
                v7 = notificationGenerationProcessor$processNotificationData$10.I$0;
                z4 = notificationGenerationProcessor$processNotificationData$10.Z$0;
                ref$BooleanRef1 = (BooleanRef)notificationGenerationProcessor$processNotificationData$10.L$3;
                notificationGenerationJob1 = (NotificationGenerationJob)notificationGenerationProcessor$processNotificationData$10.L$2;
                notification2 = (Notification)notificationGenerationProcessor$processNotificationData$10.L$1;
                NotificationGenerationProcessor notificationGenerationProcessor3 = (NotificationGenerationProcessor)notificationGenerationProcessor$processNotificationData$10.L$0;
                try {
                    notificationGenerationProcessor2 = notificationGenerationProcessor3;
                    ResultKt.throwOnFailure(object0);
                    notificationGenerationProcessor2 = notificationGenerationProcessor3;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                    notificationGenerationProcessor2 = notificationGenerationProcessor3;
                    Logging.error(("remoteNotificationReceived timed out, continuing with wantsToDisplay=" + ref$BooleanRef1.element + '.'), timeoutCancellationException0);
                }
                catch(Throwable throwable0) {
                    Logging.error("remoteNotificationReceived threw an exception. Displaying normal OneSignal notification.", throwable0);
                }
            label_134:
                notificationGenerationProcessor$processNotificationData$10.L$0 = notificationGenerationProcessor2;
                notificationGenerationProcessor$processNotificationData$10.L$1 = notification2;
                notificationGenerationProcessor$processNotificationData$10.L$2 = notificationGenerationJob1;
                notificationGenerationProcessor$processNotificationData$10.L$3 = ref$BooleanRef1;
                notificationGenerationProcessor$processNotificationData$10.Z$0 = z4;
                notificationGenerationProcessor$processNotificationData$10.I$0 = v7;
                notificationGenerationProcessor$processNotificationData$10.label = 4;
                object0 = notificationGenerationProcessor2.processHandlerResponse(notificationGenerationJob1, ref$BooleanRef1.element, z4, notificationGenerationProcessor$processNotificationData$10);
                if(object0 == object1) {
                    return object1;
                }
                ref$BooleanRef2 = ref$BooleanRef1;
                notificationGenerationProcessor4 = notificationGenerationProcessor2;
                z5 = z4;
                goto label_159;
            }
            case 4: {
                int v8 = notificationGenerationProcessor$processNotificationData$10.I$0;
                boolean z6 = notificationGenerationProcessor$processNotificationData$10.Z$0;
                BooleanRef ref$BooleanRef3 = (BooleanRef)notificationGenerationProcessor$processNotificationData$10.L$3;
                notificationGenerationJob1 = (NotificationGenerationJob)notificationGenerationProcessor$processNotificationData$10.L$2;
                notification2 = (Notification)notificationGenerationProcessor$processNotificationData$10.L$1;
                NotificationGenerationProcessor notificationGenerationProcessor5 = (NotificationGenerationProcessor)notificationGenerationProcessor$processNotificationData$10.L$0;
                ResultKt.throwOnFailure(object0);
                z5 = z6;
                ref$BooleanRef2 = ref$BooleanRef3;
                v7 = v8;
                notificationGenerationProcessor4 = notificationGenerationProcessor5;
            label_159:
                if(((Boolean)object0) == null) {
                    return Unit.INSTANCE;
                }
                z7 = ((Boolean)object0).booleanValue();
                if(z7) {
                    if(notificationGenerationProcessor4.shouldFireForegroundHandlers(notificationGenerationJob1)) {
                        Logging.info$default("Fire notificationWillShowInForegroundHandler", null, 2, null);
                        ref$BooleanRef2.element = true;
                        try {
                            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.3 notificationGenerationProcessor$processNotificationData$30 = new Function2(new NotificationWillDisplayEvent(notificationGenerationJob1.getNotification()), ref$BooleanRef2, notification2, null) {
                                final Notification $notification;
                                final NotificationWillDisplayEvent $notificationWillDisplayEvent;
                                final BooleanRef $wantsToDisplay;
                                int label;

                                {
                                    NotificationGenerationProcessor.this = notificationGenerationProcessor0;
                                    this.$notificationWillDisplayEvent = notificationWillDisplayEvent0;
                                    this.$wantsToDisplay = ref$BooleanRef0;
                                    this.$notification = notification0;
                                    super(2, continuation0);
                                }

                                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.3(NotificationGenerationProcessor.this, this.$notificationWillDisplayEvent, this.$wantsToDisplay, this.$notification, continuation0);
                                }

                                @Override  // kotlin.jvm.functions.Function2
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.3)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object object0) {
                                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch(this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure(object0);
                                            com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.3.1 notificationGenerationProcessor$processNotificationData$3$10 = new Function2(this.$notificationWillDisplayEvent, this.$wantsToDisplay, this.$notification, null) {
                                                final Notification $notification;
                                                final NotificationWillDisplayEvent $notificationWillDisplayEvent;
                                                final BooleanRef $wantsToDisplay;
                                                int label;

                                                {
                                                    NotificationGenerationProcessor.this = notificationGenerationProcessor0;
                                                    this.$notificationWillDisplayEvent = notificationWillDisplayEvent0;
                                                    this.$wantsToDisplay = ref$BooleanRef0;
                                                    this.$notification = notification0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.3.1(NotificationGenerationProcessor.this, this.$notificationWillDisplayEvent, this.$wantsToDisplay, this.$notification, continuation0);
                                                }

                                                @Override  // kotlin.jvm.functions.Function2
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.processNotificationData.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object object0) {
                                                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch(this.label) {
                                                        case 0: {
                                                            ResultKt.throwOnFailure(object0);
                                                            NotificationGenerationProcessor.this._lifecycleService.externalNotificationWillShowInForeground(this.$notificationWillDisplayEvent);
                                                            if(this.$notificationWillDisplayEvent.isPreventDefault()) {
                                                                this.$wantsToDisplay.element = false;
                                                                this.label = 1;
                                                                if(this.$notification.getDisplayWaiter().waitForWake(this) == object1) {
                                                                    return object1;
                                                                }
                                                                this.$wantsToDisplay.element = true;
                                                                return Unit.INSTANCE;
                                                            }
                                                            break;
                                                        }
                                                        case 1: {
                                                            ResultKt.throwOnFailure(object0);
                                                            this.$wantsToDisplay.element = true;
                                                            break;
                                                        }
                                                        default: {
                                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            Job job0 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, notificationGenerationProcessor$processNotificationData$3$10, 2, null);
                                            this.label = 1;
                                            return job0.join(this) == object1 ? object1 : Unit.INSTANCE;
                                        }
                                        case 1: {
                                            ResultKt.throwOnFailure(object0);
                                            return Unit.INSTANCE;
                                        }
                                        default: {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                    }
                                }
                            };
                            notificationGenerationProcessor$processNotificationData$10.L$0 = notificationGenerationProcessor4;
                            notificationGenerationProcessor$processNotificationData$10.L$1 = notificationGenerationJob1;
                            notificationGenerationProcessor$processNotificationData$10.L$2 = ref$BooleanRef2;
                            notificationGenerationProcessor$processNotificationData$10.L$3 = null;
                            notificationGenerationProcessor$processNotificationData$10.Z$0 = z5;
                            notificationGenerationProcessor$processNotificationData$10.I$0 = v7;
                            notificationGenerationProcessor$processNotificationData$10.label = 5;
                            if(TimeoutKt.withTimeout(30000L, notificationGenerationProcessor$processNotificationData$30, notificationGenerationProcessor$processNotificationData$10) == object1) {
                                return object1;
                            }
                            notificationGenerationJob2 = notificationGenerationJob1;
                            goto label_203;
                        }
                        catch(TimeoutCancellationException timeoutCancellationException1) {
                            notificationGenerationJob2 = notificationGenerationJob1;
                            Logging.info(("notificationWillShowInForegroundHandler timed out, continuing with wantsToDisplay=" + ref$BooleanRef2.element + '.'), timeoutCancellationException1);
                            goto label_203;
                        }
                        catch(Throwable throwable1) {
                            notificationGenerationJob2 = notificationGenerationJob1;
                            goto label_202;
                        }
                        return object1;
                    }
                    else {
                        z8 = v7;
                        z9 = z5;
                        notificationGenerationProcessor6 = notificationGenerationProcessor4;
                    }
                    goto label_227;
                }
                else {
                    z10 = z5;
                }
                goto label_251;
            }
            case 5: {
                v7 = notificationGenerationProcessor$processNotificationData$10.I$0;
                z5 = notificationGenerationProcessor$processNotificationData$10.Z$0;
                ref$BooleanRef2 = (BooleanRef)notificationGenerationProcessor$processNotificationData$10.L$2;
                notificationGenerationJob2 = (NotificationGenerationJob)notificationGenerationProcessor$processNotificationData$10.L$1;
                notificationGenerationProcessor4 = (NotificationGenerationProcessor)notificationGenerationProcessor$processNotificationData$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    goto label_203;
                }
                catch(TimeoutCancellationException timeoutCancellationException1) {
                    Logging.info(("notificationWillShowInForegroundHandler timed out, continuing with wantsToDisplay=" + ref$BooleanRef2.element + '.'), timeoutCancellationException1);
                    goto label_203;
                }
                catch(Throwable throwable1) {
                }
            label_202:
                Logging.error("notificationWillShowInForegroundHandler threw an exception. Displaying normal OneSignal notification.", throwable1);
            label_203:
                v9 = v7;
                z9 = z5;
                notificationGenerationJob3 = notificationGenerationJob2;
                notificationGenerationProcessor7 = notificationGenerationProcessor4;
                notificationGenerationProcessor$processNotificationData$10.L$0 = notificationGenerationProcessor7;
                notificationGenerationProcessor$processNotificationData$10.L$1 = notificationGenerationJob3;
                notificationGenerationProcessor$processNotificationData$10.L$2 = null;
                notificationGenerationProcessor$processNotificationData$10.L$3 = null;
                notificationGenerationProcessor$processNotificationData$10.Z$0 = z9;
                notificationGenerationProcessor$processNotificationData$10.I$0 = v9;
                notificationGenerationProcessor$processNotificationData$10.label = 6;
                object0 = notificationGenerationProcessor7.processHandlerResponse(notificationGenerationJob3, ref$BooleanRef2.element, z9, notificationGenerationProcessor$processNotificationData$10);
                if(object0 == object1) {
                    return object1;
                }
                goto label_222;
            }
            case 6: {
                v9 = notificationGenerationProcessor$processNotificationData$10.I$0;
                z9 = notificationGenerationProcessor$processNotificationData$10.Z$0;
                notificationGenerationJob3 = (NotificationGenerationJob)notificationGenerationProcessor$processNotificationData$10.L$1;
                notificationGenerationProcessor7 = (NotificationGenerationProcessor)notificationGenerationProcessor$processNotificationData$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_222:
                if(((Boolean)object0) == null) {
                    return Unit.INSTANCE;
                }
                notificationGenerationJob1 = notificationGenerationJob3;
                notificationGenerationProcessor6 = notificationGenerationProcessor7;
                z8 = v9;
                z7 = ((Boolean)object0).booleanValue();
            label_227:
                if(z7) {
                    notificationGenerationProcessor$processNotificationData$10.L$0 = notificationGenerationProcessor6;
                    notificationGenerationProcessor$processNotificationData$10.L$1 = notificationGenerationJob1;
                    notificationGenerationProcessor$processNotificationData$10.L$2 = null;
                    notificationGenerationProcessor$processNotificationData$10.L$3 = null;
                    notificationGenerationProcessor$processNotificationData$10.Z$0 = z9;
                    notificationGenerationProcessor$processNotificationData$10.label = 7;
                    object0 = notificationGenerationProcessor6._notificationDisplayer.displayNotification(notificationGenerationJob1, notificationGenerationProcessor$processNotificationData$10);
                    if(object0 == object1) {
                        return object1;
                    }
                    z10 = z9;
                    notificationGenerationJob4 = notificationGenerationJob1;
                    goto label_247;
                }
                else {
                    z10 = z9;
                }
                goto label_249;
            }
            case 7: {
                z10 = notificationGenerationProcessor$processNotificationData$10.Z$0;
                notificationGenerationJob4 = (NotificationGenerationJob)notificationGenerationProcessor$processNotificationData$10.L$1;
                notificationGenerationProcessor6 = (NotificationGenerationProcessor)notificationGenerationProcessor$processNotificationData$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_247:
                z8 = ((Boolean)object0).booleanValue();
                notificationGenerationJob1 = notificationGenerationJob4;
            label_249:
                notificationGenerationProcessor4 = notificationGenerationProcessor6;
                v7 = z8;
            label_251:
                if(!notificationGenerationJob1.isRestoring()) {
                    if(v7 == 0) {
                        z1 = false;
                    }
                    notificationGenerationProcessor$processNotificationData$10.L$0 = null;
                    notificationGenerationProcessor$processNotificationData$10.L$1 = null;
                    notificationGenerationProcessor$processNotificationData$10.L$2 = null;
                    notificationGenerationProcessor$processNotificationData$10.L$3 = null;
                    notificationGenerationProcessor$processNotificationData$10.Z$0 = z10;
                    notificationGenerationProcessor$processNotificationData$10.label = 8;
                    if(notificationGenerationProcessor4.postProcessNotification(notificationGenerationJob1, false, z1, notificationGenerationProcessor$processNotificationData$10) == object1) {
                        return object1;
                    }
                }
                goto label_264;
            }
            case 8: {
                break;
            }
            case 9: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        z10 = notificationGenerationProcessor$processNotificationData$10.Z$0;
        ResultKt.throwOnFailure(object0);
    label_264:
        if(z10) {
            notificationGenerationProcessor$processNotificationData$10.L$0 = null;
            notificationGenerationProcessor$processNotificationData$10.L$1 = null;
            notificationGenerationProcessor$processNotificationData$10.L$2 = null;
            notificationGenerationProcessor$processNotificationData$10.L$3 = null;
            notificationGenerationProcessor$processNotificationData$10.label = 9;
            return DelayKt.delay(100L, notificationGenerationProcessor$processNotificationData$10) == object1 ? object1 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final Object saveNotification(NotificationGenerationJob notificationGenerationJob0, boolean z, Continuation continuation0) {
        com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.saveNotification.1 notificationGenerationProcessor$saveNotification$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.saveNotification.1) {
            notificationGenerationProcessor$saveNotification$10 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor.saveNotification.1)continuation0;
            if((notificationGenerationProcessor$saveNotification$10.label & 0x80000000) == 0) {
                notificationGenerationProcessor$saveNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.saveNotification(null, false, this);
                    }
                };
            }
            else {
                notificationGenerationProcessor$saveNotification$10.label ^= 0x80000000;
            }
        }
        else {
            notificationGenerationProcessor$saveNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.saveNotification(null, false, this);
                }
            };
        }
        Object object0 = notificationGenerationProcessor$saveNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationGenerationProcessor$saveNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Logging.debug$default(("Saving Notification job: " + notificationGenerationJob0), null, 2, null);
                JSONObject jSONObject0 = notificationGenerationJob0.getJsonPayload();
                try {
                    JSONObject jSONObject1 = this.getCustomJSONObject(jSONObject0);
                    String s = !jSONObject0.has("collapse_key") || Intrinsics.areEqual("do_not_collapse", jSONObject0.optString("collapse_key")) ? null : jSONObject0.optString("collapse_key");
                    long v = jSONObject0.optLong("google.sent_time", this._time.getCurrentTimeMillis()) / 1000L + ((long)jSONObject0.optInt("google.ttl", 0x3F480));
                    String s1 = jSONObject1.optString("i");
                    Intrinsics.checkNotNullExpressionValue(s1, "customJSON.optString(\"i\")");
                    String s2 = JSONObjectExtensionsKt.safeString(jSONObject0, "grp");
                    int v1 = notificationGenerationJob0.getAndroidId();
                    String s3 = notificationGenerationJob0.getTitle() == null ? null : String.valueOf(notificationGenerationJob0.getTitle());
                    String s4 = notificationGenerationJob0.getBody() == null ? null : String.valueOf(notificationGenerationJob0.getBody());
                    String s5 = jSONObject0.toString();
                    Intrinsics.checkNotNullExpressionValue(s5, "jsonPayload.toString()");
                    notificationGenerationProcessor$saveNotification$10.label = 1;
                    if(this._dataController.createNotification(s1, s2, s, notificationGenerationJob0.isNotificationToDisplay(), z, v1, s3, s4, v, s5, notificationGenerationProcessor$saveNotification$10) == object1) {
                        return object1;
                    }
                }
                catch(JSONException jSONException0) {
                    jSONException0.printStackTrace();
                }
                return Unit.INSTANCE;
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure(object0);
                }
                catch(JSONException jSONException0) {
                    jSONException0.printStackTrace();
                }
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final boolean shouldDisplayNotification(NotificationGenerationJob notificationGenerationJob0) {
        if(!notificationGenerationJob0.hasExtender()) {
            String s = notificationGenerationJob0.getJsonPayload().optString("alert");
            return AndroidUtils.INSTANCE.isStringNotEmpty(s);
        }
        return true;
    }

    private final boolean shouldFireForegroundHandlers(NotificationGenerationJob notificationGenerationJob0) {
        if(!this._applicationService.isInForeground()) {
            Logging.info$default("App is in background, show notification", null, 2, null);
            return false;
        }
        if(notificationGenerationJob0.isRestoring()) {
            Logging.info$default("Not firing notificationWillShowInForegroundHandler for restored notifications", null, 2, null);
            return false;
        }
        return true;
    }
}

