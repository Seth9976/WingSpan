package com.onesignal.notifications.internal.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\u0018\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u00020\u000FH\u0016J\u0018\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u00020\u000FH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u000BR\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2 = {"Lcom/onesignal/notifications/internal/analytics/impl/FirebaseAnalyticsTracker;", "Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "isEnabled", "", "()Z", "lastOpenedTime", "Ljava/util/concurrent/atomic/AtomicLong;", "lastReceivedNotificationCampaign", "", "lastReceivedNotificationId", "lastReceivedTime", "mFirebaseAnalyticsInstance", "", "getFirebaseAnalyticsInstance", "trackInfluenceOpenEvent", "", "trackOpenedEvent", "notificationId", "campaign", "trackReceivedEvent", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class FirebaseAnalyticsTracker implements IAnalyticsTracker {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001A\u00020\nJ\u0018\u0010\u000B\u001A\u0004\u0018\u00010\f2\f\u0010\r\u001A\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002J\u0018\u0010\u000E\u001A\u0004\u0018\u00010\f2\f\u0010\r\u001A\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/onesignal/notifications/internal/analytics/impl/FirebaseAnalyticsTracker$Companion;", "", "()V", "EVENT_NOTIFICATION_INFLUENCE_OPEN", "", "EVENT_NOTIFICATION_OPENED", "EVENT_NOTIFICATION_RECEIVED", "firebaseAnalyticsClass", "Ljava/lang/Class;", "canTrack", "", "getInstanceMethod", "Ljava/lang/reflect/Method;", "clazz", "getTrackMethod", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Method access$getInstanceMethod(Companion firebaseAnalyticsTracker$Companion0, Class class0) {
            return firebaseAnalyticsTracker$Companion0.getInstanceMethod(class0);
        }

        public static final Method access$getTrackMethod(Companion firebaseAnalyticsTracker$Companion0, Class class0) {
            return firebaseAnalyticsTracker$Companion0.getTrackMethod(class0);
        }

        public final boolean canTrack() {
            try {
                FirebaseAnalyticsTracker.firebaseAnalyticsClass = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
                return true;
            }
            catch(ClassNotFoundException unused_ex) {
                return false;
            }
        }

        private final Method getInstanceMethod(Class class0) {
            try {
                Intrinsics.checkNotNull(class0);
                return class0.getMethod("getInstance", Context.class);
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                noSuchMethodException0.printStackTrace();
                return null;
            }
        }

        private final Method getTrackMethod(Class class0) {
            try {
                Intrinsics.checkNotNull(class0);
                return class0.getMethod("logEvent", String.class, Bundle.class);
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                noSuchMethodException0.printStackTrace();
                return null;
            }
        }
    }

    public static final Companion Companion = null;
    private static final String EVENT_NOTIFICATION_INFLUENCE_OPEN = "os_notification_influence_open";
    private static final String EVENT_NOTIFICATION_OPENED = "os_notification_opened";
    private static final String EVENT_NOTIFICATION_RECEIVED = "os_notification_received";
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ITime _time;
    private static Class firebaseAnalyticsClass;
    private AtomicLong lastOpenedTime;
    private String lastReceivedNotificationCampaign;
    private String lastReceivedNotificationId;
    private AtomicLong lastReceivedTime;
    private Object mFirebaseAnalyticsInstance;

    static {
        FirebaseAnalyticsTracker.Companion = new Companion(null);
    }

    public FirebaseAnalyticsTracker(IApplicationService iApplicationService0, ConfigModelStore configModelStore0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._configModelStore = configModelStore0;
        this._time = iTime0;
    }

    private final Object getFirebaseAnalyticsInstance() {
        if(this.mFirebaseAnalyticsInstance == null) {
            Method method0 = Companion.access$getInstanceMethod(FirebaseAnalyticsTracker.Companion, FirebaseAnalyticsTracker.firebaseAnalyticsClass);
            try {
                Intrinsics.checkNotNull(method0);
                this.mFirebaseAnalyticsInstance = method0.invoke(null, this._applicationService.getAppContext());
                return this.mFirebaseAnalyticsInstance;
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
                return null;
            }
        }
        return this.mFirebaseAnalyticsInstance;
    }

    private final boolean isEnabled() {
        return ((ConfigModel)this._configModelStore.getModel()).getFirebaseAnalytics();
    }

    @Override  // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackInfluenceOpenEvent() {
        if(this.isEnabled() && this.lastReceivedTime != null && this.lastReceivedNotificationId != null) {
            long v = this._time.getCurrentTimeMillis();
            AtomicLong atomicLong0 = this.lastReceivedTime;
            Intrinsics.checkNotNull(atomicLong0);
            if(v - atomicLong0.get() > 120000L) {
                return;
            }
            AtomicLong atomicLong1 = this.lastOpenedTime;
            if(atomicLong1 != null) {
                Intrinsics.checkNotNull(atomicLong1);
                if(v - atomicLong1.get() < 30000L) {
                    return;
                }
            }
            try {
                Object object0 = this.getFirebaseAnalyticsInstance();
                Method method0 = Companion.access$getTrackMethod(FirebaseAnalyticsTracker.Companion, FirebaseAnalyticsTracker.firebaseAnalyticsClass);
                Bundle bundle0 = new Bundle();
                bundle0.putString("source", "OneSignal");
                bundle0.putString("medium", "notification");
                String s = this.lastReceivedNotificationId;
                Intrinsics.checkNotNull(s);
                bundle0.putString("notification_id", s);
                String s1 = this.lastReceivedNotificationCampaign;
                Intrinsics.checkNotNull(s1);
                bundle0.putString("campaign", s1);
                Intrinsics.checkNotNull(method0);
                method0.invoke(object0, "os_notification_influence_open", bundle0);
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
        }
    }

    @Override  // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackOpenedEvent(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "notificationId");
        Intrinsics.checkNotNullParameter(s1, "campaign");
        if(!this.isEnabled()) {
            return;
        }
        if(this.lastOpenedTime == null) {
            this.lastOpenedTime = new AtomicLong();
        }
        AtomicLong atomicLong0 = this.lastOpenedTime;
        Intrinsics.checkNotNull(atomicLong0);
        atomicLong0.set(this._time.getCurrentTimeMillis());
        try {
            Object object0 = this.getFirebaseAnalyticsInstance();
            Method method0 = Companion.access$getTrackMethod(FirebaseAnalyticsTracker.Companion, FirebaseAnalyticsTracker.firebaseAnalyticsClass);
            Bundle bundle0 = new Bundle();
            bundle0.putString("source", "OneSignal");
            bundle0.putString("medium", "notification");
            bundle0.putString("notification_id", s);
            bundle0.putString("campaign", s1);
            Intrinsics.checkNotNull(method0);
            method0.invoke(object0, "os_notification_opened", bundle0);
        }
        catch(Throwable throwable0) {
            throwable0.printStackTrace();
        }
    }

    @Override  // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackReceivedEvent(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "notificationId");
        Intrinsics.checkNotNullParameter(s1, "campaign");
        if(!this.isEnabled()) {
            return;
        }
        try {
            Object object0 = this.getFirebaseAnalyticsInstance();
            Method method0 = Companion.access$getTrackMethod(FirebaseAnalyticsTracker.Companion, FirebaseAnalyticsTracker.firebaseAnalyticsClass);
            Bundle bundle0 = new Bundle();
            bundle0.putString("source", "OneSignal");
            bundle0.putString("medium", "notification");
            bundle0.putString("notification_id", s);
            bundle0.putString("campaign", s1);
            Intrinsics.checkNotNull(method0);
            method0.invoke(object0, "os_notification_received", bundle0);
            if(this.lastReceivedTime == null) {
                this.lastReceivedTime = new AtomicLong();
            }
            AtomicLong atomicLong0 = this.lastReceivedTime;
            Intrinsics.checkNotNull(atomicLong0);
            atomicLong0.set(this._time.getCurrentTimeMillis());
            this.lastReceivedNotificationId = s;
            this.lastReceivedNotificationCampaign = s1;
        }
        catch(Throwable throwable0) {
            throwable0.printStackTrace();
        }
    }
}

