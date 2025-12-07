package com.onesignal.notifications.internal.restoration.impl;

import android.content.Context;
import android.service.notification.StatusBarNotification;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository.NotificationData;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0011\u0010\u000E\u001A\u00020\u000FH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreProcessor;", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreProcessor;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_workManager", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_badgeCountUpdater", "Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;)V", "getVisibleNotifications", "", "", "process", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNotification", "notification", "Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;", "delay", "(Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationRestoreProcessor implements INotificationRestoreProcessor {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreProcessor$Companion;", "", "()V", "DEFAULT_TTL_IF_NOT_IN_PAYLOAD", "", "DELAY_BETWEEN_NOTIFICATION_RESTORES_MS", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    public static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 0x3F480;
    private static final int DELAY_BETWEEN_NOTIFICATION_RESTORES_MS = 200;
    private final IApplicationService _applicationService;
    private final IBadgeCountUpdater _badgeCountUpdater;
    private final INotificationRepository _dataController;
    private final INotificationGenerationWorkManager _workManager;

    static {
        NotificationRestoreProcessor.Companion = new Companion(null);
    }

    public NotificationRestoreProcessor(IApplicationService iApplicationService0, INotificationGenerationWorkManager iNotificationGenerationWorkManager0, INotificationRepository iNotificationRepository0, IBadgeCountUpdater iBadgeCountUpdater0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationGenerationWorkManager0, "_workManager");
        Intrinsics.checkNotNullParameter(iNotificationRepository0, "_dataController");
        Intrinsics.checkNotNullParameter(iBadgeCountUpdater0, "_badgeCountUpdater");
        super();
        this._applicationService = iApplicationService0;
        this._workManager = iNotificationGenerationWorkManager0;
        this._dataController = iNotificationRepository0;
        this._badgeCountUpdater = iBadgeCountUpdater0;
    }

    private final List getVisibleNotifications() {
        Context context0 = this._applicationService.getAppContext();
        StatusBarNotification[] arr_statusBarNotification = NotificationHelper.INSTANCE.getActiveNotifications(context0);
        if(arr_statusBarNotification.length == 0) {
            return null;
        }
        List list0 = new ArrayList();
        for(int v = 0; v < arr_statusBarNotification.length; ++v) {
            list0.add(arr_statusBarNotification[v].getId());
        }
        return list0;
    }

    @Override  // com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor
    public Object process(Continuation continuation0) {
        Iterator iterator0;
        NotificationRestoreProcessor notificationRestoreProcessor0;
        com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor.process.1 notificationRestoreProcessor$process$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor.process.1) {
            notificationRestoreProcessor$process$10 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor.process.1)continuation0;
            if((notificationRestoreProcessor$process$10.label & 0x80000000) == 0) {
                notificationRestoreProcessor$process$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.process(this);
                    }
                };
            }
            else {
                notificationRestoreProcessor$process$10.label ^= 0x80000000;
            }
        }
        else {
            notificationRestoreProcessor$process$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.process(this);
                }
            };
        }
        Object object0 = notificationRestoreProcessor$process$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationRestoreProcessor$process$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Logging.info$default("Restoring notifications", null, 2, null);
                try {
                    List list0 = this.getVisibleNotifications();
                    notificationRestoreProcessor$process$10.L$0 = this;
                    notificationRestoreProcessor$process$10.label = 1;
                    object0 = this._dataController.listNotificationsForOutstanding(list0, notificationRestoreProcessor$process$10);
                    if(object0 == object1) {
                        return object1;
                    }
                    notificationRestoreProcessor0 = this;
                    iterator0 = ((List)object0).iterator();
                    goto label_31;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                NotificationRestoreProcessor notificationRestoreProcessor1 = (NotificationRestoreProcessor)notificationRestoreProcessor$process$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    notificationRestoreProcessor0 = notificationRestoreProcessor1;
                    iterator0 = ((List)object0).iterator();
                    goto label_31;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                iterator0 = (Iterator)notificationRestoreProcessor$process$10.L$1;
                notificationRestoreProcessor0 = (NotificationRestoreProcessor)notificationRestoreProcessor$process$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_31:
                    while(iterator0.hasNext()) {
                        Object object2 = iterator0.next();
                        notificationRestoreProcessor$process$10.L$0 = notificationRestoreProcessor0;
                        notificationRestoreProcessor$process$10.L$1 = iterator0;
                        notificationRestoreProcessor$process$10.label = 2;
                        if(notificationRestoreProcessor0.processNotification(((NotificationData)object2), 200, notificationRestoreProcessor$process$10) == object1) {
                            return object1;
                        }
                        if(false) {
                            break;
                        }
                    }
                    notificationRestoreProcessor0._badgeCountUpdater.update();
                    return Unit.INSTANCE;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Logging.error("Error restoring notification records! ", throwable0);
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor
    public Object processNotification(NotificationData iNotificationRepository$NotificationData0, int v, Continuation continuation0) {
        Context context0 = this._applicationService.getAppContext();
        JSONObject jSONObject0 = new JSONObject(iNotificationRepository$NotificationData0.getFullData());
        this._workManager.beginEnqueueingWork(context0, iNotificationRepository$NotificationData0.getId(), iNotificationRepository$NotificationData0.getAndroidId(), jSONObject0, iNotificationRepository$NotificationData0.getCreatedAt(), true, false);
        if(v > 0) {
            Object object0 = DelayKt.delay(v, continuation0);
            return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}

