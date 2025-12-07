package com.onesignal.notifications.internal.summary.impl;

import android.app.NotificationManager;
import android.content.Context;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository.DefaultImpls;
import com.onesignal.notifications.internal.data.INotificationRepository.NotificationData;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0002\u0010\u000EJ\u0019\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u001BH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001CJ!\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0016H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001E"}, d2 = {"Lcom/onesignal/notifications/internal/summary/impl/NotificationSummaryManager;", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_summaryNotificationDisplayer", "Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_notificationRestoreProcessor", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreProcessor;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/restoration/INotificationRestoreProcessor;Lcom/onesignal/core/internal/time/ITime;)V", "clearNotificationOnSummaryClick", "", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalUpdateSummaryNotificationAfterChildRemoved", "dismissed", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreSummary", "updatePossibleDependentSummaryOnDismiss", "androidNotificationId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSummaryNotificationAfterChildRemoved", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationSummaryManager implements INotificationSummaryManager {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationRestoreProcessor _notificationRestoreProcessor;
    private final ISummaryNotificationDisplayer _summaryNotificationDisplayer;
    private final ITime _time;

    public NotificationSummaryManager(IApplicationService iApplicationService0, INotificationRepository iNotificationRepository0, ISummaryNotificationDisplayer iSummaryNotificationDisplayer0, ConfigModelStore configModelStore0, INotificationRestoreProcessor iNotificationRestoreProcessor0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationRepository0, "_dataController");
        Intrinsics.checkNotNullParameter(iSummaryNotificationDisplayer0, "_summaryNotificationDisplayer");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iNotificationRestoreProcessor0, "_notificationRestoreProcessor");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._dataController = iNotificationRepository0;
        this._summaryNotificationDisplayer = iSummaryNotificationDisplayer0;
        this._configModelStore = configModelStore0;
        this._notificationRestoreProcessor = iNotificationRestoreProcessor0;
        this._time = iTime0;
    }

    @Override  // com.onesignal.notifications.internal.summary.INotificationSummaryManager
    public Object clearNotificationOnSummaryClick(String s, Continuation continuation0) {
        Integer integer0;
        NotificationSummaryManager notificationSummaryManager0;
        Object object2;
        NotificationManager notificationManager0;
        com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.clearNotificationOnSummaryClick.1 notificationSummaryManager$clearNotificationOnSummaryClick$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.clearNotificationOnSummaryClick.1) {
            notificationSummaryManager$clearNotificationOnSummaryClick$10 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.clearNotificationOnSummaryClick.1)continuation0;
            if((notificationSummaryManager$clearNotificationOnSummaryClick$10.label & 0x80000000) == 0) {
                notificationSummaryManager$clearNotificationOnSummaryClick$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.clearNotificationOnSummaryClick(null, this);
                    }
                };
            }
            else {
                notificationSummaryManager$clearNotificationOnSummaryClick$10.label ^= 0x80000000;
            }
        }
        else {
            notificationSummaryManager$clearNotificationOnSummaryClick$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.clearNotificationOnSummaryClick(null, this);
                }
            };
        }
        Object object0 = notificationSummaryManager$clearNotificationOnSummaryClick$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationSummaryManager$clearNotificationOnSummaryClick$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Context context0 = this._applicationService.getAppContext();
                notificationManager0 = NotificationHelper.INSTANCE.getNotificationManager(context0);
                notificationSummaryManager$clearNotificationOnSummaryClick$10.L$0 = this;
                notificationSummaryManager$clearNotificationOnSummaryClick$10.L$1 = s;
                notificationSummaryManager$clearNotificationOnSummaryClick$10.L$2 = notificationManager0;
                notificationSummaryManager$clearNotificationOnSummaryClick$10.label = 1;
                object2 = this._dataController.getAndroidIdForGroup(s, false, notificationSummaryManager$clearNotificationOnSummaryClick$10);
                if(object2 == object1) {
                    return object1;
                }
                notificationSummaryManager0 = this;
                goto label_33;
            }
            case 1: {
                NotificationManager notificationManager1 = (NotificationManager)notificationSummaryManager$clearNotificationOnSummaryClick$10.L$2;
                String s1 = (String)notificationSummaryManager$clearNotificationOnSummaryClick$10.L$1;
                notificationSummaryManager0 = (NotificationSummaryManager)notificationSummaryManager$clearNotificationOnSummaryClick$10.L$0;
                ResultKt.throwOnFailure(object0);
                notificationManager0 = notificationManager1;
                s = s1;
                object2 = object0;
            label_33:
                if(((Integer)object2) != null) {
                    if(!((ConfigModel)notificationSummaryManager0._configModelStore.getModel()).getClearGroupOnSummaryClick()) {
                        goto label_47;
                    }
                    if(Intrinsics.areEqual(s, "os_group_undefined")) {
                        integer0 = Boxing.boxInt(0xD52D1DDE);
                    }
                    else {
                        notificationSummaryManager$clearNotificationOnSummaryClick$10.L$0 = notificationManager0;
                        notificationSummaryManager$clearNotificationOnSummaryClick$10.L$1 = null;
                        notificationSummaryManager$clearNotificationOnSummaryClick$10.L$2 = null;
                        notificationSummaryManager$clearNotificationOnSummaryClick$10.label = 2;
                        Object object3 = notificationSummaryManager0._dataController.getAndroidIdForGroup(s, true, notificationSummaryManager$clearNotificationOnSummaryClick$10);
                        if(object3 == object1) {
                            return object1;
                        }
                        integer0 = (Integer)object3;
                        goto label_58;
                    label_47:
                        notificationSummaryManager$clearNotificationOnSummaryClick$10.L$0 = null;
                        notificationSummaryManager$clearNotificationOnSummaryClick$10.L$1 = null;
                        notificationSummaryManager$clearNotificationOnSummaryClick$10.L$2 = null;
                        notificationSummaryManager$clearNotificationOnSummaryClick$10.label = 3;
                        return notificationSummaryManager0._dataController.markAsDismissed(((int)(((Integer)object2))), notificationSummaryManager$clearNotificationOnSummaryClick$10) == object1 ? object1 : Unit.INSTANCE;
                    }
                    goto label_58;
                }
                break;
            }
            case 2: {
                NotificationManager notificationManager2 = (NotificationManager)notificationSummaryManager$clearNotificationOnSummaryClick$10.L$0;
                ResultKt.throwOnFailure(object0);
                notificationManager0 = notificationManager2;
                integer0 = (Integer)object0;
            label_58:
                if(integer0 != null) {
                    notificationManager0.cancel(((int)integer0));
                    return Unit.INSTANCE;
                }
                break;
            }
            case 3: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return Unit.INSTANCE;
    }

    private final Object internalUpdateSummaryNotificationAfterChildRemoved(String s, boolean z, Continuation continuation0) {
        NotificationSummaryManager notificationSummaryManager0;
        String s1;
        List list0;
        int v;
        com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.internalUpdateSummaryNotificationAfterChildRemoved.1 notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.internalUpdateSummaryNotificationAfterChildRemoved.1) {
            notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.internalUpdateSummaryNotificationAfterChildRemoved.1)continuation0;
            if((notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.label & 0x80000000) == 0) {
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
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
                        return continuation0.internalUpdateSummaryNotificationAfterChildRemoved(null, false, this);
                    }
                };
            }
            else {
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.label ^= 0x80000000;
            }
        }
        else {
            notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
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
                    return continuation0.internalUpdateSummaryNotificationAfterChildRemoved(null, false, this);
                }
            };
        }
        Object object0 = notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$0 = this;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$1 = s;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.Z$0 = z;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.label = 1;
                object0 = this._dataController.listNotificationsForGroup(s, notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10);
                if(object0 == object1) {
                    return object1;
                }
                notificationSummaryManager0 = this;
                break;
            }
            case 1: {
                z = notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.Z$0;
                s = (String)notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$1;
                NotificationSummaryManager notificationSummaryManager1 = (NotificationSummaryManager)notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$0;
                ResultKt.throwOnFailure(object0);
                notificationSummaryManager0 = notificationSummaryManager1;
                break;
            }
            case 2: {
                v = notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.I$0;
                z = notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.Z$0;
                list0 = (List)notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$2;
                s1 = (String)notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$1;
                notificationSummaryManager0 = (NotificationSummaryManager)notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_54;
            }
            case 3: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            case 4: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            case 5: {
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
        list0 = (List)object0;
        int v1 = list0.size();
        notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$0 = notificationSummaryManager0;
        notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$1 = s;
        notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$2 = list0;
        notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.Z$0 = z;
        notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.I$0 = v1;
        notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.label = 2;
        Object object2 = notificationSummaryManager0._dataController.getAndroidIdForGroup(s, true, notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10);
        if(object2 == object1) {
            return object1;
        }
        s1 = s;
        v = v1;
        object0 = object2;
    label_54:
        if(((Integer)object0) != null) {
            int v2 = (int)(((Integer)object0));
            if(v == 0) {
                Context context0 = notificationSummaryManager0._applicationService.getAppContext();
                NotificationHelper.INSTANCE.getNotificationManager(context0).cancel(v2);
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$0 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$1 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$2 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.label = 3;
                return DefaultImpls.markAsConsumed$default(notificationSummaryManager0._dataController, v2, z, null, false, notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10, 12, null) == object1 ? object1 : Unit.INSTANCE;
            }
            if(v == 1) {
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$0 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$1 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$2 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.label = 4;
                return notificationSummaryManager0.restoreSummary(s1, notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10) == object1 ? object1 : Unit.INSTANCE;
            }
            try {
                NotificationData iNotificationRepository$NotificationData0 = (NotificationData)CollectionsKt.first(list0);
                NotificationGenerationJob notificationGenerationJob0 = new NotificationGenerationJob(new JSONObject(iNotificationRepository$NotificationData0.getFullData()), notificationSummaryManager0._time);
                notificationGenerationJob0.setRestoring(true);
                notificationGenerationJob0.setShownTimeStamp(Boxing.boxLong(iNotificationRepository$NotificationData0.getCreatedAt()));
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$0 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$1 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.L$2 = null;
                notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10.label = 5;
                if(notificationSummaryManager0._summaryNotificationDisplayer.updateSummaryNotification(notificationGenerationJob0, notificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$10) == object1) {
                    return object1;
                }
            }
            catch(JSONException jSONException0) {
                jSONException0.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final Object restoreSummary(String s, Continuation continuation0) {
        Iterator iterator0;
        NotificationSummaryManager notificationSummaryManager0;
        com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.restoreSummary.1 notificationSummaryManager$restoreSummary$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.restoreSummary.1) {
            notificationSummaryManager$restoreSummary$10 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.restoreSummary.1)continuation0;
            if((notificationSummaryManager$restoreSummary$10.label & 0x80000000) == 0) {
                notificationSummaryManager$restoreSummary$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.restoreSummary(null, this);
                    }
                };
            }
            else {
                notificationSummaryManager$restoreSummary$10.label ^= 0x80000000;
            }
        }
        else {
            notificationSummaryManager$restoreSummary$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.restoreSummary(null, this);
                }
            };
        }
        Object object0 = notificationSummaryManager$restoreSummary$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationSummaryManager$restoreSummary$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                notificationSummaryManager$restoreSummary$10.L$0 = this;
                notificationSummaryManager$restoreSummary$10.label = 1;
                object0 = this._dataController.listNotificationsForGroup(s, notificationSummaryManager$restoreSummary$10);
                if(object0 == object1) {
                    return object1;
                }
                notificationSummaryManager0 = this;
                iterator0 = ((List)object0).iterator();
                break;
            }
            case 1: {
                NotificationSummaryManager notificationSummaryManager1 = (NotificationSummaryManager)notificationSummaryManager$restoreSummary$10.L$0;
                ResultKt.throwOnFailure(object0);
                notificationSummaryManager0 = notificationSummaryManager1;
                iterator0 = ((List)object0).iterator();
                break;
            }
            case 2: {
                iterator0 = (Iterator)notificationSummaryManager$restoreSummary$10.L$1;
                notificationSummaryManager0 = (NotificationSummaryManager)notificationSummaryManager$restoreSummary$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object2 = iterator0.next();
            notificationSummaryManager$restoreSummary$10.L$0 = notificationSummaryManager0;
            notificationSummaryManager$restoreSummary$10.L$1 = iterator0;
            notificationSummaryManager$restoreSummary$10.label = 2;
            if(com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor.DefaultImpls.processNotification$default(notificationSummaryManager0._notificationRestoreProcessor, ((NotificationData)object2), 0, notificationSummaryManager$restoreSummary$10, 2, null) == object1) {
                return object1;
            }
            if(false) {
                break;
            }
        }
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.summary.INotificationSummaryManager
    public Object updatePossibleDependentSummaryOnDismiss(int v, Continuation continuation0) {
        NotificationSummaryManager notificationSummaryManager0;
        com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.updatePossibleDependentSummaryOnDismiss.1 notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.updatePossibleDependentSummaryOnDismiss.1) {
            notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.updatePossibleDependentSummaryOnDismiss.1)continuation0;
            if((notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.label & 0x80000000) == 0) {
                notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updatePossibleDependentSummaryOnDismiss(0, this);
                    }
                };
            }
            else {
                notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.label ^= 0x80000000;
            }
        }
        else {
            notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updatePossibleDependentSummaryOnDismiss(0, this);
                }
            };
        }
        Object object0 = notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.L$0 = this;
                notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.label = 1;
                object0 = this._dataController.getGroupId(v, notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10);
                if(object0 == object1) {
                    return object1;
                }
                notificationSummaryManager0 = this;
                break;
            }
            case 1: {
                notificationSummaryManager0 = (NotificationSummaryManager)notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.L$0;
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
        if(((String)object0) != null) {
            notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.L$0 = null;
            notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10.label = 2;
            return notificationSummaryManager0.internalUpdateSummaryNotificationAfterChildRemoved(((String)object0), true, notificationSummaryManager$updatePossibleDependentSummaryOnDismiss$10) == object1 ? object1 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.summary.INotificationSummaryManager
    public Object updateSummaryNotificationAfterChildRemoved(String s, boolean z, Continuation continuation0) {
        Object object0 = this.internalUpdateSummaryNotificationAfterChildRemoved(s, z, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }
}

