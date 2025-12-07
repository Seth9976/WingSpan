package com.onesignal.notifications.internal.limiting.impl;

import android.content.Context;
import android.service.notification.StatusBarNotification;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000F"}, d2 = {"Lcom/onesignal/notifications/internal/limiting/impl/NotificationLimitManager;", "Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationSummaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "(Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;)V", "clearOldestOverLimit", "", "notificationsToMakeRoomFor", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearOldestOverLimitStandard", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationLimitManager implements INotificationLimitManager {
    private final IApplicationService _applicationService;
    private final INotificationRepository _dataController;
    private final INotificationSummaryManager _notificationSummaryManager;

    public NotificationLimitManager(INotificationRepository iNotificationRepository0, IApplicationService iApplicationService0, INotificationSummaryManager iNotificationSummaryManager0) {
        Intrinsics.checkNotNullParameter(iNotificationRepository0, "_dataController");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationSummaryManager0, "_notificationSummaryManager");
        super();
        this._dataController = iNotificationRepository0;
        this._applicationService = iApplicationService0;
        this._notificationSummaryManager = iNotificationSummaryManager0;
    }

    public static final Object access$clearOldestOverLimitStandard(NotificationLimitManager notificationLimitManager0, int v, Continuation continuation0) {
        return notificationLimitManager0.clearOldestOverLimitStandard(v, continuation0);
    }

    @Override  // com.onesignal.notifications.internal.limiting.INotificationLimitManager
    public Object clearOldestOverLimit(int v, Continuation continuation0) {
        NotificationLimitManager notificationLimitManager0;
        com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimit.1 notificationLimitManager$clearOldestOverLimit$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimit.1) {
            notificationLimitManager$clearOldestOverLimit$10 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimit.1)continuation0;
            if((notificationLimitManager$clearOldestOverLimit$10.label & 0x80000000) == 0) {
                notificationLimitManager$clearOldestOverLimit$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.clearOldestOverLimit(0, this);
                    }
                };
            }
            else {
                notificationLimitManager$clearOldestOverLimit$10.label ^= 0x80000000;
            }
        }
        else {
            notificationLimitManager$clearOldestOverLimit$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.clearOldestOverLimit(0, this);
                }
            };
        }
        Object object0 = notificationLimitManager$clearOldestOverLimit$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationLimitManager$clearOldestOverLimit$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    notificationLimitManager$clearOldestOverLimit$10.L$0 = this;
                    notificationLimitManager$clearOldestOverLimit$10.I$0 = v;
                    notificationLimitManager$clearOldestOverLimit$10.label = 1;
                    return this.clearOldestOverLimitStandard(v, notificationLimitManager$clearOldestOverLimit$10) == object1 ? object1 : Unit.INSTANCE;
                }
                catch(Throwable unused_ex) {
                    notificationLimitManager0 = this;
                }
                notificationLimitManager$clearOldestOverLimit$10.L$0 = null;
                notificationLimitManager$clearOldestOverLimit$10.label = 3;
                return notificationLimitManager0._dataController.clearOldestOverLimitFallback(v, 49, notificationLimitManager$clearOldestOverLimit$10) == object1 ? object1 : Unit.INSTANCE;
            }
            case 1: 
            case 2: {
                v = notificationLimitManager$clearOldestOverLimit$10.I$0;
                notificationLimitManager0 = (NotificationLimitManager)notificationLimitManager$clearOldestOverLimit$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    return Unit.INSTANCE;
                }
                catch(Throwable unused_ex) {
                    notificationLimitManager$clearOldestOverLimit$10.L$0 = null;
                    notificationLimitManager$clearOldestOverLimit$10.label = 3;
                    return notificationLimitManager0._dataController.clearOldestOverLimitFallback(v, 49, notificationLimitManager$clearOldestOverLimit$10) == object1 ? object1 : Unit.INSTANCE;
                }
            }
            case 3: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final Object clearOldestOverLimitStandard(int v, Continuation continuation0) throws Throwable {
        NotificationLimitManager notificationLimitManager2;
        Iterator iterator2;
        NotificationLimitManager notificationLimitManager1;
        Iterator iterator1;
        Integer integer0;
        NotificationLimitManager notificationLimitManager0;
        Iterator iterator0;
        int v1;
        com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimitStandard.1 notificationLimitManager$clearOldestOverLimitStandard$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimitStandard.1) {
            notificationLimitManager$clearOldestOverLimitStandard$10 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimitStandard.1)continuation0;
            if((notificationLimitManager$clearOldestOverLimitStandard$10.label & 0x80000000) == 0) {
                notificationLimitManager$clearOldestOverLimitStandard$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return NotificationLimitManager.access$clearOldestOverLimitStandard(continuation0, 0, this);
                    }
                };
            }
            else {
                notificationLimitManager$clearOldestOverLimitStandard$10.label ^= 0x80000000;
            }
        }
        else {
            notificationLimitManager$clearOldestOverLimitStandard$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return NotificationLimitManager.access$clearOldestOverLimitStandard(continuation0, 0, this);
                }
            };
        }
        Object object0 = notificationLimitManager$clearOldestOverLimitStandard$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationLimitManager$clearOldestOverLimitStandard$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Context context0 = this._applicationService.getAppContext();
                StatusBarNotification[] arr_statusBarNotification = NotificationHelper.INSTANCE.getActiveNotifications(context0);
                v1 = arr_statusBarNotification.length - 49 + v;
                if(v1 < 1) {
                    return Unit.INSTANCE;
                }
                SortedMap sortedMap0 = new TreeMap();
                for(int v2 = 0; v2 < arr_statusBarNotification.length; ++v2) {
                    StatusBarNotification statusBarNotification0 = arr_statusBarNotification[v2];
                    if(!NotificationHelper.INSTANCE.isGroupSummary(statusBarNotification0)) {
                        sortedMap0.put(Boxing.boxLong(statusBarNotification0.getNotification().when), Boxing.boxInt(statusBarNotification0.getId()));
                    }
                }
                iterator0 = sortedMap0.entrySet().iterator();
                notificationLimitManager0 = this;
                goto label_43;
            }
            case 1: {
                v1 = notificationLimitManager$clearOldestOverLimitStandard$10.I$0;
                integer0 = (Integer)notificationLimitManager$clearOldestOverLimitStandard$10.L$2;
                iterator1 = (Iterator)notificationLimitManager$clearOldestOverLimitStandard$10.L$1;
                notificationLimitManager1 = (NotificationLimitManager)notificationLimitManager$clearOldestOverLimitStandard$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_59;
            }
            case 2: {
                v1 = notificationLimitManager$clearOldestOverLimitStandard$10.I$0;
                iterator2 = (Iterator)notificationLimitManager$clearOldestOverLimitStandard$10.L$1;
                notificationLimitManager2 = (NotificationLimitManager)notificationLimitManager$clearOldestOverLimitStandard$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    alab1:
        while(true) {
            iterator0 = iterator2;
            for(notificationLimitManager0 = notificationLimitManager2; true; notificationLimitManager0 = notificationLimitManager1) {
                --v1;
                if(v1 <= 0) {
                    break alab1;
                }
            label_43:
                if(!iterator0.hasNext()) {
                    break alab1;
                }
                Object object2 = iterator0.next();
                Integer integer1 = (Integer)((Map.Entry)object2).getValue();
                Intrinsics.checkNotNullExpressionValue(integer1, "value");
                notificationLimitManager$clearOldestOverLimitStandard$10.L$0 = notificationLimitManager0;
                notificationLimitManager$clearOldestOverLimitStandard$10.L$1 = iterator0;
                notificationLimitManager$clearOldestOverLimitStandard$10.L$2 = integer1;
                notificationLimitManager$clearOldestOverLimitStandard$10.I$0 = v1;
                notificationLimitManager$clearOldestOverLimitStandard$10.label = 1;
                Object object3 = notificationLimitManager0._dataController.markAsDismissed(((int)integer1), notificationLimitManager$clearOldestOverLimitStandard$10);
                if(object3 == object1) {
                    return object1;
                }
                iterator1 = iterator0;
                object0 = object3;
                notificationLimitManager1 = notificationLimitManager0;
                integer0 = integer1;
            label_59:
                if(((Boolean)object0).booleanValue()) {
                    Intrinsics.checkNotNullExpressionValue(integer0, "value");
                    notificationLimitManager$clearOldestOverLimitStandard$10.L$0 = notificationLimitManager1;
                    notificationLimitManager$clearOldestOverLimitStandard$10.L$1 = iterator1;
                    notificationLimitManager$clearOldestOverLimitStandard$10.L$2 = null;
                    notificationLimitManager$clearOldestOverLimitStandard$10.I$0 = v1;
                    notificationLimitManager$clearOldestOverLimitStandard$10.label = 2;
                    if(notificationLimitManager1._notificationSummaryManager.updatePossibleDependentSummaryOnDismiss(((int)integer0), notificationLimitManager$clearOldestOverLimitStandard$10) == object1) {
                        return object1;
                    }
                    iterator2 = iterator1;
                    notificationLimitManager2 = notificationLimitManager1;
                    break;
                }
                iterator0 = iterator1;
            }
        }
        return Unit.INSTANCE;
    }
}

