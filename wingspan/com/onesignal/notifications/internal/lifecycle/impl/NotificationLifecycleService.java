package com.onesignal.notifications.internal.lifecycle.impl;

import android.app.Activity;
import android.content.Context;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.events.CallbackProducer;
import com.onesignal.common.events.EventProducer;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationReceivedEvent;
import com.onesignal.notifications.INotificationServiceExtension;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import com.onesignal.notifications.internal.NotificationClickEvent;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleCallback;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleEventHandler;
import com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\tH\u0016J\u0010\u0010\u0019\u001A\u00020\u00172\u0006\u0010\u001A\u001A\u00020\u000EH\u0016J\u0010\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u0012H\u0016J!\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010#J\u0019\u0010$\u001A\u00020\u001E2\u0006\u0010%\u001A\u00020\"H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010&J\u0010\u0010\'\u001A\u00020\u00172\u0006\u0010(\u001A\u00020)H\u0016J\u0010\u0010*\u001A\u00020\u00172\u0006\u0010+\u001A\u00020,H\u0016J)\u0010-\u001A\u00020\u00172\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\u00152\u0006\u0010.\u001A\u00020/H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00100J\u0019\u00101\u001A\u00020\u00172\u0006\u00102\u001A\u000203H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00104J\u0010\u00105\u001A\u00020\u00172\u0006\u0010\u001A\u001A\u00020\tH\u0016J\u0010\u00106\u001A\u00020\u00172\u0006\u0010\u001A\u001A\u00020\u000EH\u0016J\u0010\u00107\u001A\u00020\u00172\u0006\u0010\u001C\u001A\u00020\u0012H\u0016J\u0012\u00108\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0010H\u0016J\u000E\u00109\u001A\u00020\u00172\u0006\u0010:\u001A\u00020;R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\bX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\bX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006<"}, d2 = {"Lcom/onesignal/notifications/internal/lifecycle/impl/NotificationLifecycleService;", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleService;", "applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;)V", "extOpenedCallback", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/notifications/INotificationClickListener;", "extRemoteReceivedCallback", "Lcom/onesignal/common/events/CallbackProducer;", "Lcom/onesignal/notifications/INotificationServiceExtension;", "extWillShowInForegroundCallback", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "intLifecycleCallback", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleCallback;", "intLifecycleHandler", "Lcom/onesignal/notifications/internal/lifecycle/INotificationLifecycleEventHandler;", "unprocessedOpenedNotifs", "Lkotlin/collections/ArrayDeque;", "Lorg/json/JSONArray;", "addExternalClickListener", "", "callback", "addExternalForegroundLifecycleListener", "listener", "addInternalNotificationLifecycleEventHandler", "handler", "canOpenNotification", "", "activity", "Landroid/app/Activity;", "data", "Lorg/json/JSONObject;", "(Landroid/app/Activity;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canReceiveNotification", "jsonPayload", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "externalNotificationWillShowInForeground", "willDisplayEvent", "Lcom/onesignal/notifications/INotificationWillDisplayEvent;", "externalRemoteNotificationReceived", "notificationReceivedEvent", "Lcom/onesignal/notifications/INotificationReceivedEvent;", "notificationOpened", "notificationId", "", "(Landroid/app/Activity;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notificationReceived", "notificationJob", "Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "(Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeExternalClickListener", "removeExternalForegroundLifecycleListener", "removeInternalNotificationLifecycleEventHandler", "setInternalNotificationLifecycleCallback", "setupNotificationServiceExtension", "context", "Landroid/content/Context;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationLifecycleService implements INotificationLifecycleService {
    private final ITime _time;
    private final EventProducer extOpenedCallback;
    private final CallbackProducer extRemoteReceivedCallback;
    private final EventProducer extWillShowInForegroundCallback;
    private final CallbackProducer intLifecycleCallback;
    private final EventProducer intLifecycleHandler;
    private final ArrayDeque unprocessedOpenedNotifs;

    public NotificationLifecycleService(IApplicationService iApplicationService0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "applicationService");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._time = iTime0;
        this.intLifecycleHandler = new EventProducer();
        this.intLifecycleCallback = new CallbackProducer();
        this.extRemoteReceivedCallback = new CallbackProducer();
        this.extWillShowInForegroundCallback = new EventProducer();
        this.extOpenedCallback = new EventProducer();
        this.unprocessedOpenedNotifs = new ArrayDeque();
        this.setupNotificationServiceExtension(iApplicationService0.getAppContext());
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void addExternalClickListener(INotificationClickListener iNotificationClickListener0) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener0, "callback");
        this.extOpenedCallback.subscribe(iNotificationClickListener0);
        if(this.extOpenedCallback.getHasSubscribers() && CollectionsKt.any(this.unprocessedOpenedNotifs)) {
            for(Object object0: this.unprocessedOpenedNotifs) {
                Function1 function10 = new Function1() {
                    final NotificationClickEvent $openedResult;

                    {
                        this.$openedResult = notificationClickEvent0;
                        super(1);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        this.invoke(((INotificationClickListener)object0));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(INotificationClickListener iNotificationClickListener0) {
                        Intrinsics.checkNotNullParameter(iNotificationClickListener0, "it");
                        iNotificationClickListener0.onClick(this.$openedResult);
                    }
                };
                this.extOpenedCallback.fireOnMain(function10);
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void addExternalForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener0, "listener");
        this.extWillShowInForegroundCallback.subscribe(iNotificationLifecycleListener0);
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void addInternalNotificationLifecycleEventHandler(INotificationLifecycleEventHandler iNotificationLifecycleEventHandler0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleEventHandler0, "handler");
        this.intLifecycleHandler.subscribe(iNotificationLifecycleEventHandler0);
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public Object canOpenNotification(Activity activity0, JSONObject jSONObject0, Continuation continuation0) {
        com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification.1 notificationLifecycleService$canOpenNotification$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification.1) {
            notificationLifecycleService$canOpenNotification$10 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification.1)continuation0;
            if((notificationLifecycleService$canOpenNotification$10.label & 0x80000000) == 0) {
                notificationLifecycleService$canOpenNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
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
                notificationLifecycleService$canOpenNotification$10.label ^= 0x80000000;
            }
        }
        else {
            notificationLifecycleService$canOpenNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
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
        Object object0 = notificationLifecycleService$canOpenNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationLifecycleService$canOpenNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                BooleanRef ref$BooleanRef0 = new BooleanRef();
                ref$BooleanRef0.element = this.extOpenedCallback.getHasSubscribers();
                com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification.2 notificationLifecycleService$canOpenNotification$20 = new Function2(activity0, jSONObject0, null) {
                    final Activity $activity;
                    final BooleanRef $canOpen;
                    final JSONObject $data;
                    Object L$0;
                    int label;

                    {
                        this.$canOpen = ref$BooleanRef0;
                        this.$activity = activity0;
                        this.$data = jSONObject0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification.2 notificationLifecycleService$canOpenNotification$20 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification.2(this.$canOpen, this.$activity, this.$data, continuation0);
                        notificationLifecycleService$canOpenNotification$20.L$0 = object0;
                        return notificationLifecycleService$canOpenNotification$20;
                    }

                    public final Object invoke(INotificationLifecycleCallback iNotificationLifecycleCallback0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canOpenNotification.2)this.create(iNotificationLifecycleCallback0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((INotificationLifecycleCallback)object0), ((Continuation)object1));
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        BooleanRef ref$BooleanRef1;
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                INotificationLifecycleCallback iNotificationLifecycleCallback0 = (INotificationLifecycleCallback)this.L$0;
                                BooleanRef ref$BooleanRef0 = this.$canOpen;
                                this.L$0 = ref$BooleanRef0;
                                this.label = 1;
                                object0 = iNotificationLifecycleCallback0.canOpenNotification(this.$activity, this.$data, this);
                                if(object0 == object1) {
                                    return object1;
                                }
                                ref$BooleanRef1 = ref$BooleanRef0;
                                break;
                            }
                            case 1: {
                                ref$BooleanRef1 = (BooleanRef)this.L$0;
                                ResultKt.throwOnFailure(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        ref$BooleanRef1.element = ((Boolean)object0).booleanValue();
                        return Unit.INSTANCE;
                    }
                };
                notificationLifecycleService$canOpenNotification$10.L$0 = ref$BooleanRef0;
                notificationLifecycleService$canOpenNotification$10.label = 1;
                return this.intLifecycleCallback.suspendingFire(notificationLifecycleService$canOpenNotification$20, notificationLifecycleService$canOpenNotification$10) == object1 ? object1 : Boxing.boxBoolean(ref$BooleanRef0.element);
            }
            case 1: {
                BooleanRef ref$BooleanRef1 = (BooleanRef)notificationLifecycleService$canOpenNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(ref$BooleanRef1.element);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public Object canReceiveNotification(JSONObject jSONObject0, Continuation continuation0) {
        com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification.1 notificationLifecycleService$canReceiveNotification$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification.1) {
            notificationLifecycleService$canReceiveNotification$10 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification.1)continuation0;
            if((notificationLifecycleService$canReceiveNotification$10.label & 0x80000000) == 0) {
                notificationLifecycleService$canReceiveNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
                notificationLifecycleService$canReceiveNotification$10.label ^= 0x80000000;
            }
        }
        else {
            notificationLifecycleService$canReceiveNotification$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = notificationLifecycleService$canReceiveNotification$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationLifecycleService$canReceiveNotification$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                BooleanRef ref$BooleanRef0 = new BooleanRef();
                ref$BooleanRef0.element = true;
                com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification.2 notificationLifecycleService$canReceiveNotification$20 = new Function2(jSONObject0, null) {
                    final BooleanRef $canReceive;
                    final JSONObject $jsonPayload;
                    Object L$0;
                    int label;

                    {
                        this.$canReceive = ref$BooleanRef0;
                        this.$jsonPayload = jSONObject0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification.2 notificationLifecycleService$canReceiveNotification$20 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification.2(this.$canReceive, this.$jsonPayload, continuation0);
                        notificationLifecycleService$canReceiveNotification$20.L$0 = object0;
                        return notificationLifecycleService$canReceiveNotification$20;
                    }

                    public final Object invoke(INotificationLifecycleCallback iNotificationLifecycleCallback0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.canReceiveNotification.2)this.create(iNotificationLifecycleCallback0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((INotificationLifecycleCallback)object0), ((Continuation)object1));
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        BooleanRef ref$BooleanRef1;
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                INotificationLifecycleCallback iNotificationLifecycleCallback0 = (INotificationLifecycleCallback)this.L$0;
                                BooleanRef ref$BooleanRef0 = this.$canReceive;
                                this.L$0 = ref$BooleanRef0;
                                this.label = 1;
                                object0 = iNotificationLifecycleCallback0.canReceiveNotification(this.$jsonPayload, this);
                                if(object0 == object1) {
                                    return object1;
                                }
                                ref$BooleanRef1 = ref$BooleanRef0;
                                break;
                            }
                            case 1: {
                                ref$BooleanRef1 = (BooleanRef)this.L$0;
                                ResultKt.throwOnFailure(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        ref$BooleanRef1.element = ((Boolean)object0).booleanValue();
                        return Unit.INSTANCE;
                    }
                };
                notificationLifecycleService$canReceiveNotification$10.L$0 = ref$BooleanRef0;
                notificationLifecycleService$canReceiveNotification$10.label = 1;
                return this.intLifecycleCallback.suspendingFire(notificationLifecycleService$canReceiveNotification$20, notificationLifecycleService$canReceiveNotification$10) == object1 ? object1 : Boxing.boxBoolean(ref$BooleanRef0.element);
            }
            case 1: {
                BooleanRef ref$BooleanRef1 = (BooleanRef)notificationLifecycleService$canReceiveNotification$10.L$0;
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(ref$BooleanRef1.element);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void externalNotificationWillShowInForeground(INotificationWillDisplayEvent iNotificationWillDisplayEvent0) {
        Intrinsics.checkNotNullParameter(iNotificationWillDisplayEvent0, "willDisplayEvent");
        Function1 function10 = new Function1() {
            final INotificationWillDisplayEvent $willDisplayEvent;

            {
                this.$willDisplayEvent = iNotificationWillDisplayEvent0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((INotificationLifecycleListener)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(INotificationLifecycleListener iNotificationLifecycleListener0) {
                Intrinsics.checkNotNullParameter(iNotificationLifecycleListener0, "it");
                iNotificationLifecycleListener0.onWillDisplay(this.$willDisplayEvent);
            }
        };
        this.extWillShowInForegroundCallback.fire(function10);
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void externalRemoteNotificationReceived(INotificationReceivedEvent iNotificationReceivedEvent0) {
        Intrinsics.checkNotNullParameter(iNotificationReceivedEvent0, "notificationReceivedEvent");
        Function1 function10 = new Function1() {
            final INotificationReceivedEvent $notificationReceivedEvent;

            {
                this.$notificationReceivedEvent = iNotificationReceivedEvent0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((INotificationServiceExtension)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(INotificationServiceExtension iNotificationServiceExtension0) {
                Intrinsics.checkNotNullParameter(iNotificationServiceExtension0, "it");
                iNotificationServiceExtension0.onNotificationReceived(this.$notificationReceivedEvent);
            }
        };
        this.extRemoteReceivedCallback.fire(function10);
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public Object notificationOpened(Activity activity0, JSONArray jSONArray0, String s, Continuation continuation0) {
        NotificationLifecycleService notificationLifecycleService0;
        com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened.1 notificationLifecycleService$notificationOpened$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened.1) {
            notificationLifecycleService$notificationOpened$10 = (com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened.1)continuation0;
            if((notificationLifecycleService$notificationOpened$10.label & 0x80000000) == 0) {
                notificationLifecycleService$notificationOpened$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.notificationOpened(null, null, null, this);
                    }
                };
            }
            else {
                notificationLifecycleService$notificationOpened$10.label ^= 0x80000000;
            }
        }
        else {
            notificationLifecycleService$notificationOpened$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.notificationOpened(null, null, null, this);
                }
            };
        }
        Object object0 = notificationLifecycleService$notificationOpened$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationLifecycleService$notificationOpened$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened.2 notificationLifecycleService$notificationOpened$20 = new Function2(jSONArray0, s, null) {
                    final Activity $activity;
                    final JSONArray $data;
                    final String $notificationId;
                    Object L$0;
                    int label;

                    {
                        this.$activity = activity0;
                        this.$data = jSONArray0;
                        this.$notificationId = s;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened.2 notificationLifecycleService$notificationOpened$20 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened.2(this.$activity, this.$data, this.$notificationId, continuation0);
                        notificationLifecycleService$notificationOpened$20.L$0 = object0;
                        return notificationLifecycleService$notificationOpened$20;
                    }

                    public final Object invoke(INotificationLifecycleEventHandler iNotificationLifecycleEventHandler0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationOpened.2)this.create(iNotificationLifecycleEventHandler0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((INotificationLifecycleEventHandler)object0), ((Continuation)object1));
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                this.label = 1;
                                return ((INotificationLifecycleEventHandler)this.L$0).onNotificationOpened(this.$activity, this.$data, this.$notificationId, this) == object1 ? object1 : Unit.INSTANCE;
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
                notificationLifecycleService$notificationOpened$10.L$0 = this;
                notificationLifecycleService$notificationOpened$10.L$1 = jSONArray0;
                notificationLifecycleService$notificationOpened$10.label = 1;
                if(this.intLifecycleHandler.suspendingFire(notificationLifecycleService$notificationOpened$20, notificationLifecycleService$notificationOpened$10) == object1) {
                    return object1;
                }
                notificationLifecycleService0 = this;
                break;
            }
            case 1: {
                jSONArray0 = (JSONArray)notificationLifecycleService$notificationOpened$10.L$1;
                notificationLifecycleService0 = (NotificationLifecycleService)notificationLifecycleService$notificationOpened$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(notificationLifecycleService0.extOpenedCallback.getHasSubscribers()) {
            Function1 function10 = new Function1() {
                final NotificationClickEvent $openResult;

                {
                    this.$openResult = notificationClickEvent0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((INotificationClickListener)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(INotificationClickListener iNotificationClickListener0) {
                    Intrinsics.checkNotNullParameter(iNotificationClickListener0, "it");
                    iNotificationClickListener0.onClick(this.$openResult);
                }
            };
            notificationLifecycleService0.extOpenedCallback.fireOnMain(function10);
            return Unit.INSTANCE;
        }
        notificationLifecycleService0.unprocessedOpenedNotifs.add(jSONArray0);
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public Object notificationReceived(NotificationGenerationJob notificationGenerationJob0, Continuation continuation0) {
        com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationReceived.2 notificationLifecycleService$notificationReceived$20 = new Function2(null) {
            final NotificationGenerationJob $notificationJob;
            Object L$0;
            int label;

            {
                this.$notificationJob = notificationGenerationJob0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationReceived.2 notificationLifecycleService$notificationReceived$20 = new com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationReceived.2(this.$notificationJob, continuation0);
                notificationLifecycleService$notificationReceived$20.L$0 = object0;
                return notificationLifecycleService$notificationReceived$20;
            }

            public final Object invoke(INotificationLifecycleEventHandler iNotificationLifecycleEventHandler0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService.notificationReceived.2)this.create(iNotificationLifecycleEventHandler0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((INotificationLifecycleEventHandler)object0), ((Continuation)object1));
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return ((INotificationLifecycleEventHandler)this.L$0).onNotificationReceived(this.$notificationJob, this) == object1 ? object1 : Unit.INSTANCE;
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
        Object object0 = this.intLifecycleHandler.suspendingFire(notificationLifecycleService$notificationReceived$20, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void removeExternalClickListener(INotificationClickListener iNotificationClickListener0) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener0, "listener");
        this.extOpenedCallback.unsubscribe(iNotificationClickListener0);
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void removeExternalForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener0, "listener");
        this.extWillShowInForegroundCallback.unsubscribe(iNotificationLifecycleListener0);
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void removeInternalNotificationLifecycleEventHandler(INotificationLifecycleEventHandler iNotificationLifecycleEventHandler0) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleEventHandler0, "handler");
        this.intLifecycleHandler.unsubscribe(iNotificationLifecycleEventHandler0);
    }

    @Override  // com.onesignal.notifications.internal.lifecycle.INotificationLifecycleService
    public void setInternalNotificationLifecycleCallback(INotificationLifecycleCallback iNotificationLifecycleCallback0) {
        this.intLifecycleCallback.set(iNotificationLifecycleCallback0);
    }

    public final void setupNotificationServiceExtension(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        String s = AndroidUtils.INSTANCE.getManifestMeta(context0, "com.onesignal.NotificationServiceExtension");
        if(s == null) {
            Logging.verbose$default("No class found, not setting up OSRemoteNotificationReceivedHandler", null, 2, null);
            return;
        }
        Logging.verbose$default(("Found class: " + s + ", attempting to call constructor"), null, 2, null);
        try {
            Object object0 = Class.forName(s).newInstance();
            if(object0 instanceof INotificationServiceExtension && !this.extRemoteReceivedCallback.getHasCallback()) {
                this.extRemoteReceivedCallback.set(object0);
            }
        }
        catch(IllegalAccessException illegalAccessException0) {
            illegalAccessException0.printStackTrace();
        }
        catch(InstantiationException instantiationException0) {
            instantiationException0.printStackTrace();
        }
        catch(ClassNotFoundException classNotFoundException0) {
            classNotFoundException0.printStackTrace();
        }
    }
}

