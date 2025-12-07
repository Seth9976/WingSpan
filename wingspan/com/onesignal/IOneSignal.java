package com.onesignal;

import android.content.Context;
import com.onesignal.debug.IDebugManager;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.session.ISessionManager;
import com.onesignal.user.IUserManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001A\u0010+\u001A\u00020\u00032\u0006\u0010,\u001A\u00020-2\b\u0010.\u001A\u0004\u0018\u00010 H&J\u0010\u0010/\u001A\u0002002\u0006\u00101\u001A\u00020 H\u0016J\u001C\u0010/\u001A\u0002002\u0006\u00101\u001A\u00020 2\n\b\u0002\u00102\u001A\u0004\u0018\u00010 H&J\b\u00103\u001A\u000200H&R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0012\u0010\u000B\u001A\u00020\fX¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0018\u0010\u000F\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\u0012\u0010\u0012\u001A\u00020\u0013X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0005R\u0012\u0010\u0017\u001A\u00020\u0018X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0012\u0010\u001B\u001A\u00020\u001CX¦\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0012\u0010\u001F\u001A\u00020 X¦\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0012\u0010#\u001A\u00020$X¦\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&R\u0012\u0010\'\u001A\u00020(X¦\u0004¢\u0006\u0006\u001A\u0004\b)\u0010*¨\u00064"}, d2 = {"Lcom/onesignal/IOneSignal;", "", "consentGiven", "", "getConsentGiven", "()Z", "setConsentGiven", "(Z)V", "consentRequired", "getConsentRequired", "setConsentRequired", "debug", "Lcom/onesignal/debug/IDebugManager;", "getDebug", "()Lcom/onesignal/debug/IDebugManager;", "disableGMSMissingPrompt", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "inAppMessages", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "getInAppMessages", "()Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "isInitialized", "location", "Lcom/onesignal/location/ILocationManager;", "getLocation", "()Lcom/onesignal/location/ILocationManager;", "notifications", "Lcom/onesignal/notifications/INotificationsManager;", "getNotifications", "()Lcom/onesignal/notifications/INotificationsManager;", "sdkVersion", "", "getSdkVersion", "()Ljava/lang/String;", "session", "Lcom/onesignal/session/ISessionManager;", "getSession", "()Lcom/onesignal/session/ISessionManager;", "user", "Lcom/onesignal/user/IUserManager;", "getUser", "()Lcom/onesignal/user/IUserManager;", "initWithContext", "context", "Landroid/content/Context;", "appId", "login", "", "externalId", "jwtBearerToken", "logout", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IOneSignal {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static void login(IOneSignal iOneSignal0, String s) {
            Intrinsics.checkNotNullParameter(s, "externalId");
            iOneSignal0.login(s, null);
        }

        public static void login$default(IOneSignal iOneSignal0, String s, String s1, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            iOneSignal0.login(s, s1);
        }
    }

    boolean getConsentGiven();

    boolean getConsentRequired();

    IDebugManager getDebug();

    boolean getDisableGMSMissingPrompt();

    IInAppMessagesManager getInAppMessages();

    ILocationManager getLocation();

    INotificationsManager getNotifications();

    String getSdkVersion();

    ISessionManager getSession();

    IUserManager getUser();

    boolean initWithContext(Context arg1, String arg2);

    boolean isInitialized();

    void login(String arg1);

    void login(String arg1, String arg2);

    void logout();

    void setConsentGiven(boolean arg1);

    void setConsentRequired(boolean arg1);

    void setDisableGMSMissingPrompt(boolean arg1);
}

