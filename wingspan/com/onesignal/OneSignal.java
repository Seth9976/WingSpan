package com.onesignal;

import android.content.Context;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.debug.IDebugManager;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.session.ISessionManager;
import com.onesignal.user.IUserManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00C6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00A2\u0006\u0002\u0010\u0002J\u001A\u0010B\u001A\u0002HC\"\n\b\u0000\u0010C\u0018\u0001*\u00020\u0001H\u0086\b\u00A2\u0006\u0002\u0010DJ\u001C\u0010E\u001A\u0004\u0018\u0001HC\"\n\b\u0000\u0010C\u0018\u0001*\u00020\u0001H\u0086\b\u00A2\u0006\u0002\u0010DJ\u0010\u0010F\u001A\u00020\"2\u0006\u0010G\u001A\u00020HH\u0007J\u0018\u0010F\u001A\u00020I2\u0006\u0010G\u001A\u00020H2\u0006\u0010J\u001A\u00020:H\u0007J\u0010\u0010K\u001A\u00020I2\u0006\u0010L\u001A\u00020:H\u0007J\u001C\u0010K\u001A\u00020I2\u0006\u0010L\u001A\u00020:2\n\b\u0002\u0010M\u001A\u0004\u0018\u00010:H\u0007J\b\u0010N\u001A\u00020IH\u0007R\u001A\u0010\u0003\u001A\u00020\u00048FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\t8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b\n\u0010\u0002\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\u000E8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b\u000F\u0010\u0002\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u00020\u00138FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b\u0014\u0010\u0002\u001A\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\u00020\u00188FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b\u0019\u0010\u0002\u001A\u0004\b\u001A\u0010\u001BR\u001A\u0010\u001C\u001A\u00020\u001D8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b\u001E\u0010\u0002\u001A\u0004\b\u001F\u0010 R*\u0010#\u001A\u00020\"2\u0006\u0010!\u001A\u00020\"8F@FX\u0087\u000E\u00A2\u0006\u0012\u0012\u0004\b$\u0010\u0002\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R*\u0010)\u001A\u00020\"2\u0006\u0010!\u001A\u00020\"8F@FX\u0087\u000E\u00A2\u0006\u0012\u0012\u0004\b*\u0010\u0002\u001A\u0004\b+\u0010&\"\u0004\b,\u0010(R*\u0010-\u001A\u00020\"2\u0006\u0010!\u001A\u00020\"8F@FX\u0087\u000E\u00A2\u0006\u0012\u0012\u0004\b.\u0010\u0002\u001A\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001A\u00101\u001A\u00020\"8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b2\u0010\u0002\u001A\u0004\b1\u0010&R\u001B\u00103\u001A\u0002048BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b7\u00108\u001A\u0004\b5\u00106R\u001A\u00109\u001A\u00020:8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b;\u0010\u0002\u001A\u0004\b<\u0010=R\u0011\u0010>\u001A\u00020?8F\u00A2\u0006\u0006\u001A\u0004\b@\u0010A\u00A8\u0006O"}, d2 = {"Lcom/onesignal/OneSignal;", "", "()V", "Debug", "Lcom/onesignal/debug/IDebugManager;", "getDebug$annotations", "getDebug", "()Lcom/onesignal/debug/IDebugManager;", "InAppMessages", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "getInAppMessages$annotations", "getInAppMessages", "()Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "Location", "Lcom/onesignal/location/ILocationManager;", "getLocation$annotations", "getLocation", "()Lcom/onesignal/location/ILocationManager;", "Notifications", "Lcom/onesignal/notifications/INotificationsManager;", "getNotifications$annotations", "getNotifications", "()Lcom/onesignal/notifications/INotificationsManager;", "Session", "Lcom/onesignal/session/ISessionManager;", "getSession$annotations", "getSession", "()Lcom/onesignal/session/ISessionManager;", "User", "Lcom/onesignal/user/IUserManager;", "getUser$annotations", "getUser", "()Lcom/onesignal/user/IUserManager;", "value", "", "consentGiven", "getConsentGiven$annotations", "getConsentGiven", "()Z", "setConsentGiven", "(Z)V", "consentRequired", "getConsentRequired$annotations", "getConsentRequired", "setConsentRequired", "disableGMSMissingPrompt", "getDisableGMSMissingPrompt$annotations", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "isInitialized", "isInitialized$annotations", "oneSignal", "Lcom/onesignal/IOneSignal;", "getOneSignal", "()Lcom/onesignal/IOneSignal;", "oneSignal$delegate", "Lkotlin/Lazy;", "sdkVersion", "", "getSdkVersion$annotations", "getSdkVersion", "()Ljava/lang/String;", "services", "Lcom/onesignal/common/services/IServiceProvider;", "getServices", "()Lcom/onesignal/common/services/IServiceProvider;", "getService", "T", "()Ljava/lang/Object;", "getServiceOrNull", "initWithContext", "context", "Landroid/content/Context;", "", "appId", "login", "externalId", "jwtBearerToken", "logout", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OneSignal {
    public static final OneSignal INSTANCE;
    private static final Lazy oneSignal$delegate;

    static {
        OneSignal.INSTANCE = new OneSignal();
        OneSignal.oneSignal$delegate = LazyKt.lazy(OneSignal.oneSignal.2.INSTANCE);
    }

    public static final boolean getConsentGiven() {
        return OneSignal.INSTANCE.getOneSignal().getConsentGiven();
    }

    @JvmStatic
    public static void getConsentGiven$annotations() {
    }

    public static final boolean getConsentRequired() {
        return OneSignal.INSTANCE.getOneSignal().getConsentRequired();
    }

    @JvmStatic
    public static void getConsentRequired$annotations() {
    }

    public static final IDebugManager getDebug() {
        return OneSignal.INSTANCE.getOneSignal().getDebug();
    }

    @JvmStatic
    public static void getDebug$annotations() {
    }

    public static final boolean getDisableGMSMissingPrompt() {
        return OneSignal.INSTANCE.getOneSignal().getDisableGMSMissingPrompt();
    }

    @JvmStatic
    public static void getDisableGMSMissingPrompt$annotations() {
    }

    public static final IInAppMessagesManager getInAppMessages() {
        return OneSignal.INSTANCE.getOneSignal().getInAppMessages();
    }

    @JvmStatic
    public static void getInAppMessages$annotations() {
    }

    public static final ILocationManager getLocation() {
        return OneSignal.INSTANCE.getOneSignal().getLocation();
    }

    @JvmStatic
    public static void getLocation$annotations() {
    }

    public static final INotificationsManager getNotifications() {
        return OneSignal.INSTANCE.getOneSignal().getNotifications();
    }

    @JvmStatic
    public static void getNotifications$annotations() {
    }

    private final IOneSignal getOneSignal() {
        return (IOneSignal)OneSignal.oneSignal$delegate.getValue();
    }

    public static final String getSdkVersion() {
        return OneSignal.INSTANCE.getOneSignal().getSdkVersion();
    }

    @JvmStatic
    public static void getSdkVersion$annotations() {
    }

    public final Object getService() {
        IServiceProvider iServiceProvider0 = this.getServices();
        Intrinsics.reifiedOperationMarker(4, "T");
        return iServiceProvider0.getService(Object.class);
    }

    public final Object getServiceOrNull() {
        IServiceProvider iServiceProvider0 = this.getServices();
        Intrinsics.reifiedOperationMarker(4, "T");
        return iServiceProvider0.getServiceOrNull(Object.class);
    }

    public final IServiceProvider getServices() {
        IOneSignal iOneSignal0 = this.getOneSignal();
        Intrinsics.checkNotNull(iOneSignal0, "null cannot be cast to non-null type com.onesignal.common.services.IServiceProvider");
        return (IServiceProvider)iOneSignal0;
    }

    public static final ISessionManager getSession() {
        return OneSignal.INSTANCE.getOneSignal().getSession();
    }

    @JvmStatic
    public static void getSession$annotations() {
    }

    public static final IUserManager getUser() {
        return OneSignal.INSTANCE.getOneSignal().getUser();
    }

    @JvmStatic
    public static void getUser$annotations() {
    }

    @JvmStatic
    public static final void initWithContext(Context context0, String s) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(s, "appId");
        OneSignal.INSTANCE.getOneSignal().initWithContext(context0, s);
    }

    @JvmStatic
    public static final boolean initWithContext(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        return OneSignal.INSTANCE.getOneSignal().initWithContext(context0, null);
    }

    public static final boolean isInitialized() {
        return OneSignal.INSTANCE.getOneSignal().isInitialized();
    }

    @JvmStatic
    public static void isInitialized$annotations() {
    }

    @JvmStatic
    public static final void login(String s) {
        Intrinsics.checkNotNullParameter(s, "externalId");
        OneSignal.INSTANCE.getOneSignal().login(s);
    }

    @JvmStatic
    public static final void login(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "externalId");
        OneSignal.INSTANCE.getOneSignal().login(s, s1);
    }

    public static void login$default(String s, String s1, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        OneSignal.login(s, s1);
    }

    @JvmStatic
    public static final void logout() {
        OneSignal.INSTANCE.getOneSignal().logout();
    }

    public static final void setConsentGiven(boolean z) {
        OneSignal.INSTANCE.getOneSignal().setConsentGiven(z);
    }

    public static final void setConsentRequired(boolean z) {
        OneSignal.INSTANCE.getOneSignal().setConsentRequired(z);
    }

    public static final void setDisableGMSMissingPrompt(boolean z) {
        OneSignal.INSTANCE.getOneSignal().setDisableGMSMissingPrompt(z);
    }
}

