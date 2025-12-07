package com.onesignal.notifications.internal.generation.impl;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.Data.Builder;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker.Result;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.onesignal.OneSignal;
import com.onesignal.common.AndroidUtils;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.generation.INotificationGenerationProcessor;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0004H\u0016¨\u0006\u0013"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationWorkManager;", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;", "()V", "beginEnqueueingWork", "", "context", "Landroid/content/Context;", "osNotificationId", "", "androidNotificationId", "", "jsonPayload", "Lorg/json/JSONObject;", "timestamp", "", "isRestoring", "isHighPriority", "Companion", "NotificationGenerationWorker", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationGenerationWorkManager implements INotificationGenerationWorkManager {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u0004J\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u0004R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationWorkManager$Companion;", "", "()V", "ANDROID_NOTIF_ID_WORKER_DATA_PARAM", "", "IS_RESTORING_WORKER_DATA_PARAM", "JSON_PAYLOAD_WORKER_DATA_PARAM", "OS_ID_DATA_PARAM", "TIMESTAMP_WORKER_DATA_PARAM", "notificationIds", "Ljava/util/concurrent/ConcurrentHashMap;", "", "addNotificationIdProcessed", "osNotificationId", "removeNotificationIdProcessed", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final boolean addNotificationIdProcessed(String s) {
            Intrinsics.checkNotNullParameter(s, "osNotificationId");
            if(AndroidUtils.INSTANCE.isStringNotEmpty(s)) {
                if(NotificationGenerationWorkManager.notificationIds.contains(s)) {
                    Logging.debug$default(("OSNotificationWorkManager notification with notificationId: " + s + " already queued"), null, 2, null);
                    return false;
                }
                NotificationGenerationWorkManager.notificationIds.put(s, Boolean.TRUE);
            }
            return true;
        }

        public final void removeNotificationIdProcessed(String s) {
            Intrinsics.checkNotNullParameter(s, "osNotificationId");
            if(AndroidUtils.INSTANCE.isStringNotEmpty(s)) {
                NotificationGenerationWorkManager.notificationIds.remove(s);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001A\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/generation/impl/NotificationGenerationWorkManager$NotificationGenerationWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class NotificationGenerationWorker extends CoroutineWorker {
        public NotificationGenerationWorker(Context context0, WorkerParameters workerParameters0) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(workerParameters0, "workerParams");
            super(context0, workerParameters0);
        }

        @Override  // androidx.work.CoroutineWorker
        public Object doWork(Continuation continuation0) {
            Result listenableWorker$Result2;
            String s1;
            com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager.NotificationGenerationWorker.doWork.1 notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10;
            if(continuation0 instanceof com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager.NotificationGenerationWorker.doWork.1) {
                notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10 = (com.onesignal.notifications.internal.generation.impl.NotificationGenerationWorkManager.NotificationGenerationWorker.doWork.1)continuation0;
                if((notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10.label & 0x80000000) == 0) {
                    notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        int label;
                        Object result;

                        @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.doWork(this);
                        }
                    };
                }
                else {
                    notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10.label ^= 0x80000000;
                }
            }
            else {
                notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.doWork(this);
                    }
                };
            }
            Object object0 = notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10.result;
            Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10.label) {
                case 0: {
                    ResultKt.throwOnFailure(object0);
                    Context context0 = this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(context0, "applicationContext");
                    if(!OneSignal.initWithContext(context0)) {
                        Result listenableWorker$Result0 = Result.success();
                        Intrinsics.checkNotNullExpressionValue(listenableWorker$Result0, "success()");
                        return listenableWorker$Result0;
                    }
                    INotificationGenerationProcessor iNotificationGenerationProcessor0 = (INotificationGenerationProcessor)OneSignal.INSTANCE.getServices().getService(INotificationGenerationProcessor.class);
                    Data data0 = this.getInputData();
                    Intrinsics.checkNotNullExpressionValue(data0, "inputData");
                    String s = data0.getString("os_notif_id");
                    if(s == null) {
                        Result listenableWorker$Result1 = Result.failure();
                        Intrinsics.checkNotNullExpressionValue(listenableWorker$Result1, "failure()");
                        return listenableWorker$Result1;
                    }
                    try {
                        Logging.debug$default(("NotificationWorker running doWork with data: " + data0), null, 2, null);
                        int v = data0.getInt("android_notif_id", 0);
                        JSONObject jSONObject0 = new JSONObject(data0.getString("json_payload"));
                        long v1 = data0.getLong("timestamp", System.currentTimeMillis() / 1000L);
                        boolean z = false;
                        boolean z1 = data0.getBoolean("is_restoring", false);
                        Context context1 = this.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(context1, "applicationContext");
                        if(z1) {
                            z = true;
                        }
                        notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10.L$0 = s;
                        notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10.label = 1;
                        if(iNotificationGenerationProcessor0.processNotificationData(context1, v, jSONObject0, z, v1, notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10) == object1) {
                            return object1;
                        }
                        s1 = s;
                        break;
                    }
                    catch(JSONException jSONException0) {
                        s1 = s;
                        goto label_54;
                    }
                    catch(Throwable throwable0) {
                        s1 = s;
                        Intrinsics.checkNotNull(s1);
                        NotificationGenerationWorkManager.Companion.removeNotificationIdProcessed(s1);
                        throw throwable0;
                    }
                    return object1;
                }
                case 1: {
                    s1 = (String)notificationGenerationWorkManager$NotificationGenerationWorker$doWork$10.L$0;
                    try {
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    catch(JSONException jSONException0) {
                        try {
                        label_54:
                            Logging.error(("Error occurred doing work for job with id: " + s1), jSONException0);
                            listenableWorker$Result2 = Result.failure();
                            Intrinsics.checkNotNullExpressionValue(listenableWorker$Result2, "failure()");
                        }
                        catch(Throwable throwable0) {
                            Intrinsics.checkNotNull(s1);
                            NotificationGenerationWorkManager.Companion.removeNotificationIdProcessed(s1);
                            throw throwable0;
                        }
                        Intrinsics.checkNotNull(s1);
                        NotificationGenerationWorkManager.Companion.removeNotificationIdProcessed(s1);
                        return listenableWorker$Result2;
                    }
                    catch(Throwable throwable0) {
                    }
                    Intrinsics.checkNotNull(s1);
                    NotificationGenerationWorkManager.Companion.removeNotificationIdProcessed(s1);
                    throw throwable0;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
            Intrinsics.checkNotNull(s1);
            NotificationGenerationWorkManager.Companion.removeNotificationIdProcessed(s1);
            Result listenableWorker$Result3 = Result.success();
            Intrinsics.checkNotNullExpressionValue(listenableWorker$Result3, "success()");
            return listenableWorker$Result3;
        }
    }

    private static final String ANDROID_NOTIF_ID_WORKER_DATA_PARAM = "android_notif_id";
    public static final Companion Companion = null;
    private static final String IS_RESTORING_WORKER_DATA_PARAM = "is_restoring";
    private static final String JSON_PAYLOAD_WORKER_DATA_PARAM = "json_payload";
    private static final String OS_ID_DATA_PARAM = "os_notif_id";
    private static final String TIMESTAMP_WORKER_DATA_PARAM = "timestamp";
    private static final ConcurrentHashMap notificationIds;

    static {
        NotificationGenerationWorkManager.Companion = new Companion(null);
        NotificationGenerationWorkManager.notificationIds = new ConcurrentHashMap();
    }

    @Override  // com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager
    public boolean beginEnqueueingWork(Context context0, String s, int v, JSONObject jSONObject0, long v1, boolean z, boolean z1) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(s, "osNotificationId");
        String s1 = NotificationFormatHelper.INSTANCE.getOSNotificationIdFromJson(jSONObject0);
        if(s1 == null) {
            Logging.debug$default("Notification beginEnqueueingWork with id null", null, 2, null);
            return false;
        }
        if(!NotificationGenerationWorkManager.Companion.addNotificationIdProcessed(s1)) {
            Logging.debug$default("Notification beginEnqueueingWork with id duplicated", null, 2, null);
            return true;
        }
        Data data0 = new Builder().putString("os_notif_id", s1).putInt("android_notif_id", v).putString("json_payload", String.valueOf(jSONObject0)).putLong("timestamp", v1).putBoolean("is_restoring", z).build();
        Intrinsics.checkNotNullExpressionValue(data0, "Builder()\n              …\n                .build()");
        OneTimeWorkRequest oneTimeWorkRequest0 = (OneTimeWorkRequest)((androidx.work.OneTimeWorkRequest.Builder)new androidx.work.OneTimeWorkRequest.Builder(NotificationGenerationWorker.class).setInputData(data0)).build();
        Logging.debug$default(("NotificationWorkManager enqueueing notification work with notificationId: " + s + " and jsonPayload: " + jSONObject0), null, 2, null);
        OSWorkManagerHelper.getInstance(context0).enqueueUniqueWork(s, ExistingWorkPolicy.KEEP, oneTimeWorkRequest0);
        return true;
    }
}

