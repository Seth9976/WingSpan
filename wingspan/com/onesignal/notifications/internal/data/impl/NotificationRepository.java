package com.onesignal.notifications.internal.data.impl;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase.DefaultImpls;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import com.onesignal.notifications.internal.data.INotificationRepository.NotificationData;
import com.onesignal.notifications.internal.data.INotificationRepository;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u00A2\u0006\u0002\u0010\fJ!\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0012Ji\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u00102\b\u0010\u001C\u001A\u0004\u0018\u00010\u00152\b\u0010\u001D\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u0015H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010!J!\u0010\"\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u0015H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010#J\u0011\u0010$\u001A\u00020\u000EH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010%J\u001B\u0010&\u001A\u00020\u00192\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\'J#\u0010(\u001A\u0004\u0018\u00010\u00102\u0006\u0010)\u001A\u00020\u00152\u0006\u0010*\u001A\u00020\u0019H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010+J\u001B\u0010,\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001A\u00020\u0015H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\'J\u001B\u0010-\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u001B\u001A\u00020\u0010H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010.J\u0010\u0010/\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u0010H\u0002J\u001F\u00100\u001A\b\u0012\u0004\u0012\u000202012\u0006\u00103\u001A\u00020\u0015H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\'J\'\u00104\u001A\b\u0012\u0004\u0012\u000202012\u000E\u00105\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u000101H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00106J3\u00107\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\u00102\u0006\u00108\u001A\u00020\u00192\b\u00103\u001A\u0004\u0018\u00010\u00152\u0006\u00109\u001A\u00020\u0019H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010:J\u0019\u0010;\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u0010H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010.J\u0019\u0010<\u001A\u00020\u000E2\u0006\u0010)\u001A\u00020\u0015H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\'J\u0011\u0010=\u001A\u00020\u000EH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010%R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006?"}, d2 = {"Lcom/onesignal/notifications/internal/data/impl/NotificationRepository;", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_queryHelper", "Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;", "_databaseProvider", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_badgeCountUpdater", "Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;Lcom/onesignal/core/internal/database/IDatabaseProvider;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;)V", "clearOldestOverLimitFallback", "", "notificationsToMakeRoomFor", "", "maxNumberOfNotificationsInt", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotification", "id", "", "groupId", "collapseKey", "shouldDismissIdenticals", "", "isOpened", "androidId", "title", "body", "expireTime", "", "jsonPayload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSummaryNotification", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpiredNotifications", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doesNotificationExist", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndroidIdForGroup", "group", "getSummaryNotification", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndroidIdFromCollapseKey", "getGroupId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalMarkAsDismissed", "listNotificationsForGroup", "", "Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;", "summaryGroup", "listNotificationsForOutstanding", "excludeAndroidIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsConsumed", "dismissed", "clearGroupOnSummaryClick", "(IZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsDismissed", "markAsDismissedForGroup", "markAsDismissedForOutstanding", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationRepository implements INotificationRepository {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/onesignal/notifications/internal/data/impl/NotificationRepository$Companion;", "", "()V", "COLUMNS_FOR_LIST_NOTIFICATIONS", "", "", "getCOLUMNS_FOR_LIST_NOTIFICATIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "NOTIFICATION_CACHE_DATA_LIFETIME", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final String[] getCOLUMNS_FOR_LIST_NOTIFICATIONS() {
            return NotificationRepository.COLUMNS_FOR_LIST_NOTIFICATIONS;
        }
    }

    private static final String[] COLUMNS_FOR_LIST_NOTIFICATIONS = null;
    public static final Companion Companion = null;
    private static final long NOTIFICATION_CACHE_DATA_LIFETIME = 604800L;
    private final IApplicationService _applicationService;
    private final IBadgeCountUpdater _badgeCountUpdater;
    private final IDatabaseProvider _databaseProvider;
    private final INotificationQueryHelper _queryHelper;
    private final ITime _time;

    static {
        NotificationRepository.Companion = new Companion(null);
        NotificationRepository.COLUMNS_FOR_LIST_NOTIFICATIONS = new String[]{"title", "message", "notification_id", "android_notification_id", "full_data", "created_time"};
    }

    public NotificationRepository(IApplicationService iApplicationService0, INotificationQueryHelper iNotificationQueryHelper0, IDatabaseProvider iDatabaseProvider0, ITime iTime0, IBadgeCountUpdater iBadgeCountUpdater0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationQueryHelper0, "_queryHelper");
        Intrinsics.checkNotNullParameter(iDatabaseProvider0, "_databaseProvider");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        Intrinsics.checkNotNullParameter(iBadgeCountUpdater0, "_badgeCountUpdater");
        super();
        this._applicationService = iApplicationService0;
        this._queryHelper = iNotificationQueryHelper0;
        this._databaseProvider = iDatabaseProvider0;
        this._time = iTime0;
        this._badgeCountUpdater = iBadgeCountUpdater0;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object clearOldestOverLimitFallback(int v, int v1, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(this, v, null) {
            final int $maxNumberOfNotificationsInt;
            final int $notificationsToMakeRoomFor;
            int label;

            {
                this.$maxNumberOfNotificationsInt = v;
                NotificationRepository.this = notificationRepository0;
                this.$notificationsToMakeRoomFor = v1;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.data.impl.NotificationRepository.clearOldestOverLimitFallback.2(this.$maxNumberOfNotificationsInt, NotificationRepository.this, this.$notificationsToMakeRoomFor, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.clearOldestOverLimitFallback.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                try {
                    IDatabase iDatabase0 = NotificationRepository.this._databaseProvider.getOs();
                    String s = NotificationRepository.this._queryHelper.recentUninteractedWithNotificationsWhere().toString();
                    com.onesignal.notifications.internal.data.impl.NotificationRepository.clearOldestOverLimitFallback.2.1 notificationRepository$clearOldestOverLimitFallback$2$10 = new Function1(this.$notificationsToMakeRoomFor, NotificationRepository.this) {
                        final int $maxNumberOfNotificationsInt;
                        final int $notificationsToMakeRoomFor;

                        {
                            this.$maxNumberOfNotificationsInt = v;
                            this.$notificationsToMakeRoomFor = v1;
                            NotificationRepository.this = notificationRepository0;
                            super(1);
                        }

                        @Override  // kotlin.jvm.functions.Function1
                        public Object invoke(Object object0) {
                            this.invoke(((ICursor)object0));
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ICursor iCursor0) {
                            Intrinsics.checkNotNullParameter(iCursor0, "it");
                            int v = iCursor0.getCount() - this.$maxNumberOfNotificationsInt + this.$notificationsToMakeRoomFor;
                            if(v < 1) {
                                return;
                            }
                            while(iCursor0.moveToNext()) {
                                int v1 = iCursor0.getInt("android_notification_id");
                                NotificationRepository.this.internalMarkAsDismissed(v1);
                                --v;
                                if(v <= 0) {
                                    break;
                                }
                            }
                        }
                    };
                    DefaultImpls.query$default(iDatabase0, "notification", new String[]{"android_notification_id"}, s, null, null, null, "_id", String.valueOf(this.$maxNumberOfNotificationsInt) + this.$notificationsToMakeRoomFor, notificationRepository$clearOldestOverLimitFallback$2$10, 56, null);
                }
                catch(Throwable throwable0) {
                    Logging.error("Error clearing oldest notifications over limit! ", throwable0);
                }
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object createNotification(String s, String s1, String s2, boolean z, boolean z1, int v, String s3, String s4, long v1, String s5, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(z, v, this, s1, s2, z1, s3, s4, v1, s5, null) {
            final int $androidId;
            final String $body;
            final String $collapseKey;
            final long $expireTime;
            final String $groupId;
            final String $id;
            final boolean $isOpened;
            final String $jsonPayload;
            final boolean $shouldDismissIdenticals;
            final String $title;
            int label;

            {
                this.$id = s;
                this.$shouldDismissIdenticals = z;
                this.$androidId = v;
                NotificationRepository.this = notificationRepository0;
                this.$groupId = s1;
                this.$collapseKey = s2;
                this.$isOpened = z1;
                this.$title = s3;
                this.$body = s4;
                this.$expireTime = v1;
                this.$jsonPayload = s5;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.data.impl.NotificationRepository.createNotification.2(this.$id, this.$shouldDismissIdenticals, this.$androidId, NotificationRepository.this, this.$groupId, this.$collapseKey, this.$isOpened, this.$title, this.$body, this.$expireTime, this.$jsonPayload, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.createNotification.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                Logging.debug$default(("Saving Notification id=" + this.$id), null, 2, null);
                int v = 1;
                try {
                    if(this.$shouldDismissIdenticals) {
                        ContentValues contentValues0 = new ContentValues();
                        contentValues0.put("dismissed", Boxing.boxInt(1));
                        NotificationRepository.this._databaseProvider.getOs().update("notification", contentValues0, "android_notification_id = " + this.$androidId, null);
                        NotificationRepository.this._badgeCountUpdater.update();
                    }
                    ContentValues contentValues1 = new ContentValues();
                    contentValues1.put("notification_id", this.$id);
                    String s = this.$groupId;
                    if(s != null) {
                        contentValues1.put("group_id", s);
                    }
                    String s1 = this.$collapseKey;
                    if(s1 != null) {
                        contentValues1.put("collapse_id", s1);
                    }
                    if(!this.$isOpened) {
                        v = 0;
                    }
                    contentValues1.put("opened", Boxing.boxInt(v));
                    if(!this.$isOpened) {
                        contentValues1.put("android_notification_id", Boxing.boxInt(this.$androidId));
                    }
                    String s2 = this.$title;
                    if(s2 != null) {
                        contentValues1.put("title", s2);
                    }
                    String s3 = this.$body;
                    if(s3 != null) {
                        contentValues1.put("message", s3);
                    }
                    contentValues1.put("expire_time", Boxing.boxLong(this.$expireTime));
                    contentValues1.put("full_data", this.$jsonPayload);
                    NotificationRepository.this._databaseProvider.getOs().insertOrThrow("notification", null, contentValues1);
                    Logging.debug$default(("Notification saved values: " + contentValues1), null, 2, null);
                    if(!this.$isOpened) {
                        NotificationRepository.this._badgeCountUpdater.update();
                        return Unit.INSTANCE;
                    }
                }
                catch(JSONException jSONException0) {
                    jSONException0.printStackTrace();
                }
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object createSummaryNotification(int v, String s, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(s, this, null) {
            final int $androidId;
            final String $groupId;
            int label;

            {
                this.$androidId = v;
                this.$groupId = s;
                NotificationRepository.this = notificationRepository0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.data.impl.NotificationRepository.createSummaryNotification.2(this.$androidId, this.$groupId, NotificationRepository.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.createSummaryNotification.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("android_notification_id", Boxing.boxInt(this.$androidId));
                contentValues0.put("group_id", this.$groupId);
                contentValues0.put("is_summary", Boxing.boxInt(1));
                NotificationRepository.this._databaseProvider.getOs().insertOrThrow("notification", null, contentValues0);
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object deleteExpiredNotifications(Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(null) {
            int label;

            {
                NotificationRepository.this = notificationRepository0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.data.impl.NotificationRepository.deleteExpiredNotifications.2(NotificationRepository.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.deleteExpiredNotifications.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                String s = String.valueOf(NotificationRepository.this._time.getCurrentTimeMillis() / 1000L - 604800L);
                Intrinsics.checkNotNullExpressionValue(s, "valueOf(\n               …FETIME,\n                )");
                NotificationRepository.this._databaseProvider.getOs().delete("notification", "created_time < ?", new String[]{s});
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object doesNotificationExist(String s, Continuation continuation0) {
        com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist.1 notificationRepository$doesNotificationExist$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist.1) {
            notificationRepository$doesNotificationExist$10 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist.1)continuation0;
            if((notificationRepository$doesNotificationExist$10.label & 0x80000000) == 0) {
                notificationRepository$doesNotificationExist$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.doesNotificationExist(null, this);
                    }
                };
            }
            else {
                notificationRepository$doesNotificationExist$10.label ^= 0x80000000;
            }
        }
        else {
            notificationRepository$doesNotificationExist$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.doesNotificationExist(null, this);
                }
            };
        }
        Object object0 = notificationRepository$doesNotificationExist$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationRepository$doesNotificationExist$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(s != null && !Intrinsics.areEqual("", s)) {
                    BooleanRef ref$BooleanRef0 = new BooleanRef();
                    com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist.2 notificationRepository$doesNotificationExist$20 = new Function2(this, ref$BooleanRef0, null) {
                        final String $id;
                        final BooleanRef $result;
                        int label;

                        {
                            this.$id = s;
                            NotificationRepository.this = notificationRepository0;
                            this.$result = ref$BooleanRef0;
                            super(2, continuation0);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist.2(this.$id, NotificationRepository.this, this.$result, continuation0);
                        }

                        @Override  // kotlin.jvm.functions.Function2
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            ResultKt.throwOnFailure(object0);
                            String[] arr_s = new String[1];
                            Intrinsics.checkNotNull(this.$id);
                            arr_s[0] = this.$id;
                            IDatabase iDatabase0 = NotificationRepository.this._databaseProvider.getOs();
                            com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist.2.1 notificationRepository$doesNotificationExist$2$10 = new Function1(this.$result) {
                                final String $id;
                                final BooleanRef $result;

                                {
                                    this.$id = s;
                                    this.$result = ref$BooleanRef0;
                                    super(1);
                                }

                                @Override  // kotlin.jvm.functions.Function1
                                public Object invoke(Object object0) {
                                    this.invoke(((ICursor)object0));
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ICursor iCursor0) {
                                    Intrinsics.checkNotNullParameter(iCursor0, "it");
                                    if(iCursor0.moveToFirst()) {
                                        Logging.debug$default(("Notification notValidOrDuplicated with id duplicated, duplicate FCM message received, skip processing of " + this.$id), null, 2, null);
                                        this.$result.element = true;
                                    }
                                }
                            };
                            DefaultImpls.query$default(iDatabase0, "notification", new String[]{"notification_id"}, "notification_id = ?", arr_s, null, null, null, null, notificationRepository$doesNotificationExist$2$10, 0xF0, null);
                            return Unit.INSTANCE;
                        }
                    };
                    notificationRepository$doesNotificationExist$10.L$0 = ref$BooleanRef0;
                    notificationRepository$doesNotificationExist$10.label = 1;
                    return BuildersKt.withContext(Dispatchers.getIO(), notificationRepository$doesNotificationExist$20, notificationRepository$doesNotificationExist$10) == object1 ? object1 : Boxing.boxBoolean(ref$BooleanRef0.element);
                }
                return Boxing.boxBoolean(false);
            }
            case 1: {
                BooleanRef ref$BooleanRef1 = (BooleanRef)notificationRepository$doesNotificationExist$10.L$0;
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(ref$BooleanRef1.element);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object getAndroidIdForGroup(String s, boolean z, Continuation continuation0) {
        com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup.1 notificationRepository$getAndroidIdForGroup$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup.1) {
            notificationRepository$getAndroidIdForGroup$10 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup.1)continuation0;
            if((notificationRepository$getAndroidIdForGroup$10.label & 0x80000000) == 0) {
                notificationRepository$getAndroidIdForGroup$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getAndroidIdForGroup(null, false, this);
                    }
                };
            }
            else {
                notificationRepository$getAndroidIdForGroup$10.label ^= 0x80000000;
            }
        }
        else {
            notificationRepository$getAndroidIdForGroup$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getAndroidIdForGroup(null, false, this);
                }
            };
        }
        Object object0 = notificationRepository$getAndroidIdForGroup$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationRepository$getAndroidIdForGroup$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                boolean z1 = Intrinsics.areEqual(s, "os_group_undefined");
                ObjectRef ref$ObjectRef1 = new ObjectRef();
                ref$ObjectRef1.element = ((String)ref$ObjectRef1.element) + " AND dismissed = 0 AND opened = 0 AND ";
                ref$ObjectRef1.element = ((String)ref$ObjectRef1.element) + (z ? "is_summary = 1" : "is_summary = 0");
                com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup.2 notificationRepository$getAndroidIdForGroup$20 = new Function2(ref$ObjectRef1, (z1 ? null : new String[]{s}), ref$ObjectRef0, null) {
                    final ObjectRef $recentId;
                    final String[] $whereArgs;
                    final ObjectRef $whereStr;
                    int label;

                    {
                        NotificationRepository.this = notificationRepository0;
                        this.$whereStr = ref$ObjectRef0;
                        this.$whereArgs = arr_s;
                        this.$recentId = ref$ObjectRef1;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup.2(NotificationRepository.this, this.$whereStr, this.$whereArgs, this.$recentId, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        IDatabase iDatabase0 = NotificationRepository.this._databaseProvider.getOs();
                        String s = (String)this.$whereStr.element;
                        com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup.2.1 notificationRepository$getAndroidIdForGroup$2$10 = new Function1() {
                            final ObjectRef $recentId;

                            {
                                this.$recentId = ref$ObjectRef0;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                this.invoke(((ICursor)object0));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ICursor iCursor0) {
                                Intrinsics.checkNotNullParameter(iCursor0, "it");
                                this.$recentId.element = iCursor0.moveToFirst() ? iCursor0.getInt("android_notification_id") : null;
                            }
                        };
                        DefaultImpls.query$default(iDatabase0, "notification", new String[]{"android_notification_id"}, s, this.$whereArgs, null, null, "created_time DESC", "1", notificationRepository$getAndroidIdForGroup$2$10, 0x30, null);
                        return Unit.INSTANCE;
                    }
                };
                notificationRepository$getAndroidIdForGroup$10.L$0 = ref$ObjectRef0;
                notificationRepository$getAndroidIdForGroup$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), notificationRepository$getAndroidIdForGroup$20, notificationRepository$getAndroidIdForGroup$10) == object1 ? object1 : ref$ObjectRef0.element;
            }
            case 1: {
                ObjectRef ref$ObjectRef2 = (ObjectRef)notificationRepository$getAndroidIdForGroup$10.L$0;
                ResultKt.throwOnFailure(object0);
                return ref$ObjectRef2.element;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object getAndroidIdFromCollapseKey(String s, Continuation continuation0) {
        com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey.1 notificationRepository$getAndroidIdFromCollapseKey$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey.1) {
            notificationRepository$getAndroidIdFromCollapseKey$10 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey.1)continuation0;
            if((notificationRepository$getAndroidIdFromCollapseKey$10.label & 0x80000000) == 0) {
                notificationRepository$getAndroidIdFromCollapseKey$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getAndroidIdFromCollapseKey(null, this);
                    }
                };
            }
            else {
                notificationRepository$getAndroidIdFromCollapseKey$10.label ^= 0x80000000;
            }
        }
        else {
            notificationRepository$getAndroidIdFromCollapseKey$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getAndroidIdFromCollapseKey(null, this);
                }
            };
        }
        Object object0 = notificationRepository$getAndroidIdFromCollapseKey$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationRepository$getAndroidIdFromCollapseKey$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey.2 notificationRepository$getAndroidIdFromCollapseKey$20 = new Function2(s, ref$ObjectRef0, null) {
                    final ObjectRef $androidId;
                    final String $collapseKey;
                    int label;

                    {
                        NotificationRepository.this = notificationRepository0;
                        this.$collapseKey = s;
                        this.$androidId = ref$ObjectRef0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey.2(NotificationRepository.this, this.$collapseKey, this.$androidId, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        IDatabase iDatabase0 = NotificationRepository.this._databaseProvider.getOs();
                        com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey.2.1 notificationRepository$getAndroidIdFromCollapseKey$2$10 = new Function1() {
                            final ObjectRef $androidId;

                            {
                                this.$androidId = ref$ObjectRef0;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                this.invoke(((ICursor)object0));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ICursor iCursor0) {
                                Intrinsics.checkNotNullParameter(iCursor0, "it");
                                if(iCursor0.moveToFirst()) {
                                    this.$androidId.element = iCursor0.getInt("android_notification_id");
                                }
                            }
                        };
                        DefaultImpls.query$default(iDatabase0, "notification", new String[]{"android_notification_id"}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{this.$collapseKey}, null, null, null, null, notificationRepository$getAndroidIdFromCollapseKey$2$10, 0xF0, null);
                        return Unit.INSTANCE;
                    }
                };
                notificationRepository$getAndroidIdFromCollapseKey$10.L$0 = ref$ObjectRef0;
                notificationRepository$getAndroidIdFromCollapseKey$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), notificationRepository$getAndroidIdFromCollapseKey$20, notificationRepository$getAndroidIdFromCollapseKey$10) == object1 ? object1 : ref$ObjectRef0.element;
            }
            case 1: {
                ObjectRef ref$ObjectRef1 = (ObjectRef)notificationRepository$getAndroidIdFromCollapseKey$10.L$0;
                ResultKt.throwOnFailure(object0);
                return ref$ObjectRef1.element;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object getGroupId(int v, Continuation continuation0) {
        com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId.1 notificationRepository$getGroupId$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId.1) {
            notificationRepository$getGroupId$10 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId.1)continuation0;
            if((notificationRepository$getGroupId$10.label & 0x80000000) == 0) {
                notificationRepository$getGroupId$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getGroupId(0, this);
                    }
                };
            }
            else {
                notificationRepository$getGroupId$10.label ^= 0x80000000;
            }
        }
        else {
            notificationRepository$getGroupId$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getGroupId(0, this);
                }
            };
        }
        Object object0 = notificationRepository$getGroupId$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationRepository$getGroupId$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId.2 notificationRepository$getGroupId$20 = new Function2(v, ref$ObjectRef0, null) {
                    final int $androidId;
                    final ObjectRef $groupId;
                    int label;

                    {
                        NotificationRepository.this = notificationRepository0;
                        this.$androidId = v;
                        this.$groupId = ref$ObjectRef0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId.2(NotificationRepository.this, this.$androidId, this.$groupId, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        IDatabase iDatabase0 = NotificationRepository.this._databaseProvider.getOs();
                        com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId.2.1 notificationRepository$getGroupId$2$10 = new Function1() {
                            final ObjectRef $groupId;

                            {
                                this.$groupId = ref$ObjectRef0;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                this.invoke(((ICursor)object0));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ICursor iCursor0) {
                                Intrinsics.checkNotNullParameter(iCursor0, "it");
                                if(iCursor0.moveToFirst()) {
                                    this.$groupId.element = iCursor0.getOptString("group_id");
                                }
                            }
                        };
                        DefaultImpls.query$default(iDatabase0, "notification", new String[]{"group_id"}, "android_notification_id = " + this.$androidId, null, null, null, null, null, notificationRepository$getGroupId$2$10, 0xF8, null);
                        return Unit.INSTANCE;
                    }
                };
                notificationRepository$getGroupId$10.L$0 = ref$ObjectRef0;
                notificationRepository$getGroupId$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), notificationRepository$getGroupId$20, notificationRepository$getGroupId$10) == object1 ? object1 : ref$ObjectRef0.element;
            }
            case 1: {
                ObjectRef ref$ObjectRef1 = (ObjectRef)notificationRepository$getGroupId$10.L$0;
                ResultKt.throwOnFailure(object0);
                return ref$ObjectRef1.element;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final boolean internalMarkAsDismissed(int v) {
        Context context0 = this._applicationService.getAppContext();
        ContentValues contentValues0 = new ContentValues();
        boolean z = true;
        contentValues0.put("dismissed", 1);
        if(this._databaseProvider.getOs().update("notification", contentValues0, "android_notification_id = " + v + " AND opened = 0 AND dismissed = 0", null) <= 0) {
            z = false;
        }
        this._badgeCountUpdater.update();
        NotificationHelper.INSTANCE.getNotificationManager(context0).cancel(v);
        return z;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object listNotificationsForGroup(String s, Continuation continuation0) {
        com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForGroup.1 notificationRepository$listNotificationsForGroup$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForGroup.1) {
            notificationRepository$listNotificationsForGroup$10 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForGroup.1)continuation0;
            if((notificationRepository$listNotificationsForGroup$10.label & 0x80000000) == 0) {
                notificationRepository$listNotificationsForGroup$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.listNotificationsForGroup(null, this);
                    }
                };
            }
            else {
                notificationRepository$listNotificationsForGroup$10.label ^= 0x80000000;
            }
        }
        else {
            notificationRepository$listNotificationsForGroup$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.listNotificationsForGroup(null, this);
                }
            };
        }
        Object object0 = notificationRepository$listNotificationsForGroup$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationRepository$listNotificationsForGroup$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                List list0 = new ArrayList();
                com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForGroup.2 notificationRepository$listNotificationsForGroup$20 = new Function2(this, list0, null) {
                    final List $listOfNotifications;
                    final String $summaryGroup;
                    int label;

                    {
                        this.$summaryGroup = s;
                        NotificationRepository.this = notificationRepository0;
                        this.$listOfNotifications = list0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForGroup.2(this.$summaryGroup, NotificationRepository.this, this.$listOfNotifications, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForGroup.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        DefaultImpls.query$default(NotificationRepository.this._databaseProvider.getOs(), "notification", NotificationRepository.Companion.getCOLUMNS_FOR_LIST_NOTIFICATIONS(), "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{this.$summaryGroup}, null, null, "_id DESC", null, new Function1(this.$summaryGroup) {
                            final List $listOfNotifications;
                            final String $summaryGroup;

                            {
                                this.$listOfNotifications = list0;
                                this.$summaryGroup = s;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                this.invoke(((ICursor)object0));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ICursor iCursor0) {
                                Intrinsics.checkNotNullParameter(iCursor0, "it");
                                if(iCursor0.moveToFirst()) {
                                    while(true) {
                                        try {
                                        label_2:
                                            String s = iCursor0.getOptString("title");
                                            String s1 = iCursor0.getOptString("message");
                                            String s2 = iCursor0.getString("notification_id");
                                            NotificationData iNotificationRepository$NotificationData0 = new NotificationData(iCursor0.getInt("android_notification_id"), s2, iCursor0.getString("full_data"), iCursor0.getLong("created_time"), s, s1);
                                            this.$listOfNotifications.add(iNotificationRepository$NotificationData0);
                                        }
                                        catch(JSONException unused_ex) {
                                            Logging.error$default(("Could not parse JSON of sub notification in group: " + this.$summaryGroup), null, 2, null);
                                        }
                                        if(iCursor0.moveToNext()) {
                                            goto label_2;
                                        }
                                        break;
                                    }
                                }
                            }
                        }, 0xB0, null);
                        return Unit.INSTANCE;
                    }
                };
                notificationRepository$listNotificationsForGroup$10.L$0 = list0;
                notificationRepository$listNotificationsForGroup$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), notificationRepository$listNotificationsForGroup$20, notificationRepository$listNotificationsForGroup$10) == object1 ? object1 : list0;
            }
            case 1: {
                List list1 = (List)notificationRepository$listNotificationsForGroup$10.L$0;
                ResultKt.throwOnFailure(object0);
                return list1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object listNotificationsForOutstanding(List list0, Continuation continuation0) {
        com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForOutstanding.1 notificationRepository$listNotificationsForOutstanding$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForOutstanding.1) {
            notificationRepository$listNotificationsForOutstanding$10 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForOutstanding.1)continuation0;
            if((notificationRepository$listNotificationsForOutstanding$10.label & 0x80000000) == 0) {
                notificationRepository$listNotificationsForOutstanding$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.listNotificationsForOutstanding(null, this);
                    }
                };
            }
            else {
                notificationRepository$listNotificationsForOutstanding$10.label ^= 0x80000000;
            }
        }
        else {
            notificationRepository$listNotificationsForOutstanding$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.listNotificationsForOutstanding(null, this);
                }
            };
        }
        Object object0 = notificationRepository$listNotificationsForOutstanding$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationRepository$listNotificationsForOutstanding$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                List list1 = new ArrayList();
                com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForOutstanding.2 notificationRepository$listNotificationsForOutstanding$20 = new Function2(list0, list1, null) {
                    final List $excludeAndroidIds;
                    final List $listOfNotifications;
                    int label;

                    {
                        NotificationRepository.this = notificationRepository0;
                        this.$excludeAndroidIds = list0;
                        this.$listOfNotifications = list1;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForOutstanding.2(NotificationRepository.this, this.$excludeAndroidIds, this.$listOfNotifications, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForOutstanding.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        StringBuilder stringBuilder0 = NotificationRepository.this._queryHelper.recentUninteractedWithNotificationsWhere();
                        if(this.$excludeAndroidIds != null) {
                            stringBuilder0.append(" AND android_notification_id NOT IN (");
                            stringBuilder0.append(TextUtils.join(",", this.$excludeAndroidIds));
                            stringBuilder0.append(")");
                        }
                        DefaultImpls.query$default(NotificationRepository.this._databaseProvider.getOs(), "notification", NotificationRepository.Companion.getCOLUMNS_FOR_LIST_NOTIFICATIONS(), stringBuilder0.toString(), null, null, null, "_id DESC", "49", new Function1() {
                            final List $listOfNotifications;

                            {
                                this.$listOfNotifications = list0;
                                super(1);
                            }

                            @Override  // kotlin.jvm.functions.Function1
                            public Object invoke(Object object0) {
                                this.invoke(((ICursor)object0));
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ICursor iCursor0) {
                                Intrinsics.checkNotNullParameter(iCursor0, "it");
                                while(iCursor0.moveToNext()) {
                                    String s = iCursor0.getOptString("title");
                                    String s1 = iCursor0.getOptString("message");
                                    String s2 = iCursor0.getString("notification_id");
                                    NotificationData iNotificationRepository$NotificationData0 = new NotificationData(iCursor0.getInt("android_notification_id"), s2, iCursor0.getString("full_data"), iCursor0.getLong("created_time"), s, s1);
                                    this.$listOfNotifications.add(iNotificationRepository$NotificationData0);
                                }
                            }
                        }, 56, null);
                        return Unit.INSTANCE;
                    }
                };
                notificationRepository$listNotificationsForOutstanding$10.L$0 = list1;
                notificationRepository$listNotificationsForOutstanding$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), notificationRepository$listNotificationsForOutstanding$20, notificationRepository$listNotificationsForOutstanding$10) == object1 ? object1 : list1;
            }
            case 1: {
                List list2 = (List)notificationRepository$listNotificationsForOutstanding$10.L$0;
                ResultKt.throwOnFailure(object0);
                return list2;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object markAsConsumed(int v, boolean z, String s, boolean z1, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(z, z1, this, v, null) {
            final int $androidId;
            final boolean $clearGroupOnSummaryClick;
            final boolean $dismissed;
            final String $summaryGroup;
            Object L$0;
            boolean Z$0;
            int label;

            {
                this.$summaryGroup = s;
                this.$dismissed = z;
                this.$clearGroupOnSummaryClick = z1;
                NotificationRepository.this = notificationRepository0;
                this.$androidId = v;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsConsumed.2(this.$summaryGroup, this.$dismissed, this.$clearGroupOnSummaryClick, NotificationRepository.this, this.$androidId, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsConsumed.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                String s2;
                boolean z1;
                String s1;
                String[] arr_s;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        arr_s = null;
                        String s = this.$summaryGroup;
                        if(s == null) {
                            s1 = "android_notification_id = " + this.$androidId;
                        }
                        else {
                            boolean z = Intrinsics.areEqual(s, "os_group_undefined");
                            if(z) {
                                s1 = "group_id IS NULL";
                            }
                            else {
                                arr_s = new String[]{this.$summaryGroup};
                                s1 = "group_id = ?";
                            }
                            if(!this.$dismissed && !this.$clearGroupOnSummaryClick) {
                                this.L$0 = s1;
                                this.Z$0 = z;
                                this.label = 1;
                                object0 = NotificationRepository.this.getAndroidIdForGroup(this.$summaryGroup, false, this);
                                if(object0 == object1) {
                                    return object1;
                                }
                                z1 = z;
                                s2 = s1;
                                goto label_28;
                            }
                        }
                        break;
                    }
                    case 1: {
                        z1 = this.Z$0;
                        s2 = (String)this.L$0;
                        ResultKt.throwOnFailure(object0);
                    label_28:
                        String s3 = String.valueOf(object0);
                        s1 = s2 + " AND android_notification_id = ?";
                        arr_s = z1 ? new String[]{s3} : new String[]{this.$summaryGroup, s3};
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                ContentValues contentValues0 = new ContentValues();
                if(this.$dismissed) {
                    contentValues0.put("dismissed", Boxing.boxInt(1));
                }
                else {
                    contentValues0.put("opened", Boxing.boxInt(1));
                }
                NotificationRepository.this._databaseProvider.getOs().update("notification", contentValues0, s1, arr_s);
                NotificationRepository.this._badgeCountUpdater.update();
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object markAsDismissed(int v, Continuation continuation0) {
        com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissed.1 notificationRepository$markAsDismissed$10;
        if(continuation0 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissed.1) {
            notificationRepository$markAsDismissed$10 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissed.1)continuation0;
            if((notificationRepository$markAsDismissed$10.label & 0x80000000) == 0) {
                notificationRepository$markAsDismissed$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.markAsDismissed(0, this);
                    }
                };
            }
            else {
                notificationRepository$markAsDismissed$10.label ^= 0x80000000;
            }
        }
        else {
            notificationRepository$markAsDismissed$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.markAsDismissed(0, this);
                }
            };
        }
        Object object0 = notificationRepository$markAsDismissed$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(notificationRepository$markAsDismissed$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                BooleanRef ref$BooleanRef0 = new BooleanRef();
                com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissed.2 notificationRepository$markAsDismissed$20 = new Function2(this, v, null) {
                    final int $androidId;
                    final BooleanRef $didDismiss;
                    int label;

                    {
                        this.$didDismiss = ref$BooleanRef0;
                        NotificationRepository.this = notificationRepository0;
                        this.$androidId = v;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissed.2(this.$didDismiss, NotificationRepository.this, this.$androidId, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissed.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        ResultKt.throwOnFailure(object0);
                        this.$didDismiss.element = NotificationRepository.this.internalMarkAsDismissed(this.$androidId);
                        return Unit.INSTANCE;
                    }
                };
                notificationRepository$markAsDismissed$10.L$0 = ref$BooleanRef0;
                notificationRepository$markAsDismissed$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), notificationRepository$markAsDismissed$20, notificationRepository$markAsDismissed$10) == object1 ? object1 : Boxing.boxBoolean(ref$BooleanRef0.element);
            }
            case 1: {
                BooleanRef ref$BooleanRef1 = (BooleanRef)notificationRepository$markAsDismissed$10.L$0;
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(ref$BooleanRef1.element);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object markAsDismissedForGroup(String s, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(s, null) {
            final String $group;
            int label;

            {
                NotificationRepository.this = notificationRepository0;
                this.$group = s;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissedForGroup.2(NotificationRepository.this, this.$group, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissedForGroup.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                Context context0 = NotificationRepository.this._applicationService.getAppContext();
                NotificationManager notificationManager0 = NotificationHelper.INSTANCE.getNotificationManager(context0);
                String[] arr_s = {this.$group};
                IDatabase iDatabase0 = NotificationRepository.this._databaseProvider.getOs();
                com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissedForGroup.2.1 notificationRepository$markAsDismissedForGroup$2$10 = new Function1() {
                    final NotificationManager $notificationManager;

                    {
                        this.$notificationManager = notificationManager0;
                        super(1);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        this.invoke(((ICursor)object0));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ICursor iCursor0) {
                        Intrinsics.checkNotNullParameter(iCursor0, "it");
                        while(iCursor0.moveToNext()) {
                            int v = iCursor0.getInt("android_notification_id");
                            if(v != -1) {
                                this.$notificationManager.cancel(v);
                            }
                        }
                    }
                };
                DefaultImpls.query$default(iDatabase0, "notification", new String[]{"android_notification_id"}, "group_id = ? AND dismissed = 0 AND opened = 0", arr_s, null, null, null, null, notificationRepository$markAsDismissedForGroup$2$10, 0xF0, null);
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("dismissed", Boxing.boxInt(1));
                NotificationRepository.this._databaseProvider.getOs().update("notification", contentValues0, "group_id = ? AND opened = 0 AND dismissed = 0", arr_s);
                NotificationRepository.this._badgeCountUpdater.update();
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationRepository
    public Object markAsDismissedForOutstanding(Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new Function2(null) {
            int label;

            {
                NotificationRepository.this = notificationRepository0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissedForOutstanding.2(NotificationRepository.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissedForOutstanding.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                Context context0 = NotificationRepository.this._applicationService.getAppContext();
                NotificationManager notificationManager0 = NotificationHelper.INSTANCE.getNotificationManager(context0);
                IDatabase iDatabase0 = NotificationRepository.this._databaseProvider.getOs();
                com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissedForOutstanding.2.1 notificationRepository$markAsDismissedForOutstanding$2$10 = new Function1() {
                    final NotificationManager $notificationManager;

                    {
                        this.$notificationManager = notificationManager0;
                        super(1);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        this.invoke(((ICursor)object0));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ICursor iCursor0) {
                        Intrinsics.checkNotNullParameter(iCursor0, "it");
                        if(iCursor0.moveToFirst()) {
                            while(true) {
                                int v = iCursor0.getInt("android_notification_id");
                                this.$notificationManager.cancel(v);
                                if(!iCursor0.moveToNext()) {
                                    break;
                                }
                            }
                        }
                    }
                };
                DefaultImpls.query$default(iDatabase0, "notification", new String[]{"android_notification_id"}, "dismissed = 0 AND opened = 0", null, null, null, null, null, notificationRepository$markAsDismissedForOutstanding$2$10, 0xF8, null);
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("dismissed", Boxing.boxInt(1));
                NotificationRepository.this._databaseProvider.getOs().update("notification", contentValues0, "opened = 0", null);
                NotificationRepository.this._badgeCountUpdater.updateCount(0);
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }
}

