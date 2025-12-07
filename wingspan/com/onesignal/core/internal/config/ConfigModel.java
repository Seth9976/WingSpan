package com.onesignal.core.internal.config;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00A2\u0006\u0002\u0010\u0002J\u001A\u0010d\u001A\u0004\u0018\u00010\u00012\u0006\u0010e\u001A\u00020\u00042\u0006\u0010f\u001A\u00020gH\u0014R$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001A\u0004\u0018\u00010\r2\b\u0010\u0003\u001A\u0004\u0018\u00010\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001A\u0004\u0018\u00010\r2\b\u0010\u0003\u001A\u0004\u0018\u00010\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0019\u0010\u0015\"\u0004\b\u001A\u0010\u0017R$\u0010\u001B\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u001C\u0010\u0010\"\u0004\b\u001D\u0010\u0012R$\u0010\u001E\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u001F\u0010\u0010\"\u0004\b \u0010\u0012R\u0011\u0010!\u001A\u00020\"8F\u00A2\u0006\u0006\u001A\u0004\b#\u0010$R$\u0010&\u001A\u00020%2\u0006\u0010\u0003\u001A\u00020%8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R(\u0010.\u001A\u0004\u0018\u00010\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00048F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR$\u00102\u001A\u0002012\u0006\u0010\u0003\u001A\u0002018F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001A\u0002012\u0006\u0010\u0003\u001A\u0002018F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b8\u00104\"\u0004\b9\u00106R\u0011\u0010:\u001A\u00020;8F\u00A2\u0006\u0006\u001A\u0004\b<\u0010=R$\u0010>\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R$\u0010@\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R(\u0010D\u001A\u0004\u0018\u00010C2\b\u0010\u0003\u001A\u0004\u0018\u00010C8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001A\u00020%2\u0006\u0010\u0003\u001A\u00020%8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bJ\u0010(\"\u0004\bK\u0010*R$\u0010L\u001A\u00020%2\u0006\u0010\u0003\u001A\u00020%8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bM\u0010(\"\u0004\bN\u0010*R(\u0010O\u001A\u0004\u0018\u00010\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00048F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR$\u0010R\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bS\u0010\u0010\"\u0004\bT\u0010\u0012R$\u0010U\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bV\u0010\u0010\"\u0004\bW\u0010\u0012R$\u0010X\u001A\u00020%2\u0006\u0010\u0003\u001A\u00020%8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bY\u0010(\"\u0004\bZ\u0010*R$\u0010[\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R$\u0010^\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R$\u0010a\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bb\u0010\u0010\"\u0004\bc\u0010\u0012\u00A8\u0006h"}, d2 = {"Lcom/onesignal/core/internal/config/ConfigModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "apiUrl", "getApiUrl", "()Ljava/lang/String;", "setApiUrl", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "", "clearGroupOnSummaryClick", "getClearGroupOnSummaryClick", "()Z", "setClearGroupOnSummaryClick", "(Z)V", "consentGiven", "getConsentGiven", "()Ljava/lang/Boolean;", "setConsentGiven", "(Ljava/lang/Boolean;)V", "consentRequired", "getConsentRequired", "setConsentRequired", "disableGMSMissingPrompt", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "enterprise", "getEnterprise", "setEnterprise", "fcmParams", "Lcom/onesignal/core/internal/config/FCMConfigModel;", "getFcmParams", "()Lcom/onesignal/core/internal/config/FCMConfigModel;", "", "fetchIAMMinInterval", "getFetchIAMMinInterval", "()J", "setFetchIAMMinInterval", "(J)V", "firebaseAnalytics", "getFirebaseAnalytics", "setFirebaseAnalytics", "googleProjectNumber", "getGoogleProjectNumber", "setGoogleProjectNumber", "", "httpGetTimeout", "getHttpGetTimeout", "()I", "setHttpGetTimeout", "(I)V", "httpTimeout", "getHttpTimeout", "setHttpTimeout", "influenceParams", "Lcom/onesignal/core/internal/config/InfluenceConfigModel;", "getInfluenceParams", "()Lcom/onesignal/core/internal/config/InfluenceConfigModel;", "isInitializedWithRemote", "setInitializedWithRemote", "locationShared", "getLocationShared", "setLocationShared", "Lorg/json/JSONArray;", "notificationChannels", "getNotificationChannels", "()Lorg/json/JSONArray;", "setNotificationChannels", "(Lorg/json/JSONArray;)V", "opRepoExecutionInterval", "getOpRepoExecutionInterval", "setOpRepoExecutionInterval", "opRepoPostWakeDelay", "getOpRepoPostWakeDelay", "setOpRepoPostWakeDelay", "pushSubscriptionId", "getPushSubscriptionId", "setPushSubscriptionId", "receiveReceiptEnabled", "getReceiveReceiptEnabled", "setReceiveReceiptEnabled", "restoreTTLFilter", "getRestoreTTLFilter", "setRestoreTTLFilter", "sessionFocusTimeout", "getSessionFocusTimeout", "setSessionFocusTimeout", "unsubscribeWhenNotificationsDisabled", "getUnsubscribeWhenNotificationsDisabled", "setUnsubscribeWhenNotificationsDisabled", "useIdentityVerification", "getUseIdentityVerification", "setUseIdentityVerification", "userRejectedGMSUpdate", "getUserRejectedGMSUpdate", "setUserRejectedGMSUpdate", "createModelForProperty", "property", "jsonObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ConfigModel extends Model {
    public ConfigModel() {
        super(null, null, 3, null);
    }

    @Override  // com.onesignal.common.modeling.Model
    protected Model createModelForProperty(String s, JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(s, "property");
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        if(Intrinsics.areEqual(s, "influenceParams")) {
            InfluenceConfigModel influenceConfigModel0 = new InfluenceConfigModel(this, "influenceParams");
            influenceConfigModel0.initializeFromJson(jSONObject0);
            return influenceConfigModel0;
        }
        if(Intrinsics.areEqual(s, "fcmParams")) {
            FCMConfigModel fCMConfigModel0 = new FCMConfigModel(this, "influenceParams");
            fCMConfigModel0.initializeFromJson(jSONObject0);
            return fCMConfigModel0;
        }
        return null;
    }

    public final String getApiUrl() [...] // 潜在的解密器

    public final String getAppId() {
        return Model.getStringProperty$default(this, "appId", null, 2, null);
    }

    public final boolean getClearGroupOnSummaryClick() {
        return this.getBooleanProperty("clearGroupOnSummaryClick", com.onesignal.core.internal.config.ConfigModel.clearGroupOnSummaryClick.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.clearGroupOnSummaryClick.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.clearGroupOnSummaryClick.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.clearGroupOnSummaryClick.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.clearGroupOnSummaryClick.2();
            }

            com.onesignal.core.internal.config.ConfigModel.clearGroupOnSummaryClick.2() {
                super(0);
            }

            public final Boolean invoke() {
                return true;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final Boolean getConsentGiven() {
        return Model.getOptBooleanProperty$default(this, "consentGiven", null, 2, null);
    }

    public final Boolean getConsentRequired() {
        return Model.getOptBooleanProperty$default(this, "consentRequired", null, 2, null);
    }

    public final boolean getDisableGMSMissingPrompt() {
        return this.getBooleanProperty("disableGMSMissingPrompt", com.onesignal.core.internal.config.ConfigModel.disableGMSMissingPrompt.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.disableGMSMissingPrompt.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.disableGMSMissingPrompt.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.disableGMSMissingPrompt.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.disableGMSMissingPrompt.2();
            }

            com.onesignal.core.internal.config.ConfigModel.disableGMSMissingPrompt.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean getEnterprise() {
        return this.getBooleanProperty("enterprise", com.onesignal.core.internal.config.ConfigModel.enterprise.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.enterprise.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.enterprise.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.enterprise.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.enterprise.2();
            }

            com.onesignal.core.internal.config.ConfigModel.enterprise.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final FCMConfigModel getFcmParams() {
        Object object0 = this.getAnyProperty("fcmParams", new Function0() {
            {
                ConfigModel.this = configModel0;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return new FCMConfigModel(ConfigModel.this, "fcmParams");
            }
        });
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type com.onesignal.core.internal.config.FCMConfigModel");
        return (FCMConfigModel)object0;
    }

    public final long getFetchIAMMinInterval() {
        return this.getLongProperty("fetchIAMMinInterval", com.onesignal.core.internal.config.ConfigModel.fetchIAMMinInterval.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.fetchIAMMinInterval.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.fetchIAMMinInterval.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.fetchIAMMinInterval.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.fetchIAMMinInterval.2();
            }

            com.onesignal.core.internal.config.ConfigModel.fetchIAMMinInterval.2() {
                super(0);
            }

            public final Long invoke() {
                return 30000L;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean getFirebaseAnalytics() {
        return this.getBooleanProperty("firebaseAnalytics", com.onesignal.core.internal.config.ConfigModel.firebaseAnalytics.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.firebaseAnalytics.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.firebaseAnalytics.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.firebaseAnalytics.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.firebaseAnalytics.2();
            }

            com.onesignal.core.internal.config.ConfigModel.firebaseAnalytics.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final String getGoogleProjectNumber() {
        return Model.getOptStringProperty$default(this, "googleProjectNumber", null, 2, null);
    }

    public final int getHttpGetTimeout() {
        return this.getIntProperty("httpGetTimeout", com.onesignal.core.internal.config.ConfigModel.httpGetTimeout.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.httpGetTimeout.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.httpGetTimeout.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.httpGetTimeout.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.httpGetTimeout.2();
            }

            com.onesignal.core.internal.config.ConfigModel.httpGetTimeout.2() {
                super(0);
            }

            public final Integer invoke() {
                return 60000;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final int getHttpTimeout() {
        return this.getIntProperty("httpTimeout", com.onesignal.core.internal.config.ConfigModel.httpTimeout.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.httpTimeout.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.httpTimeout.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.httpTimeout.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.httpTimeout.2();
            }

            com.onesignal.core.internal.config.ConfigModel.httpTimeout.2() {
                super(0);
            }

            public final Integer invoke() {
                return 120000;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final InfluenceConfigModel getInfluenceParams() {
        Object object0 = this.getAnyProperty("influenceParams", new Function0() {
            {
                ConfigModel.this = configModel0;
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return new InfluenceConfigModel(ConfigModel.this, "influenceParams");
            }
        });
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type com.onesignal.core.internal.config.InfluenceConfigModel");
        return (InfluenceConfigModel)object0;
    }

    public final boolean getLocationShared() {
        return this.getBooleanProperty("locationShared", com.onesignal.core.internal.config.ConfigModel.locationShared.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.locationShared.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.locationShared.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.locationShared.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.locationShared.2();
            }

            com.onesignal.core.internal.config.ConfigModel.locationShared.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final JSONArray getNotificationChannels() {
        String s = this.getOptStringProperty("notificationChannels", com.onesignal.core.internal.config.ConfigModel.notificationChannels.2.INSTANCE);
        if(s == null) {
            s = "[]";
        }
        return new JSONArray(s);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0010\u0000\u001A\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.notificationChannels.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.notificationChannels.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.notificationChannels.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.notificationChannels.2();
            }

            com.onesignal.core.internal.config.ConfigModel.notificationChannels.2() {
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return null;
            }

            public final String invoke() [...] // Inlined contents
        }

    }

    public final long getOpRepoExecutionInterval() {
        return this.getLongProperty("opRepoExecutionInterval", com.onesignal.core.internal.config.ConfigModel.opRepoExecutionInterval.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.opRepoExecutionInterval.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.opRepoExecutionInterval.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.opRepoExecutionInterval.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.opRepoExecutionInterval.2();
            }

            com.onesignal.core.internal.config.ConfigModel.opRepoExecutionInterval.2() {
                super(0);
            }

            public final Long invoke() {
                return 5000L;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final long getOpRepoPostWakeDelay() {
        return this.getLongProperty("opRepoPostWakeDelay", com.onesignal.core.internal.config.ConfigModel.opRepoPostWakeDelay.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.opRepoPostWakeDelay.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.opRepoPostWakeDelay.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.opRepoPostWakeDelay.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.opRepoPostWakeDelay.2();
            }

            com.onesignal.core.internal.config.ConfigModel.opRepoPostWakeDelay.2() {
                super(0);
            }

            public final Long invoke() {
                return 200L;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final String getPushSubscriptionId() {
        return Model.getOptStringProperty$default(this, "pushSubscriptionId", null, 2, null);
    }

    public final boolean getReceiveReceiptEnabled() {
        return this.getBooleanProperty("receiveReceiptEnabled", com.onesignal.core.internal.config.ConfigModel.receiveReceiptEnabled.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.receiveReceiptEnabled.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.receiveReceiptEnabled.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.receiveReceiptEnabled.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.receiveReceiptEnabled.2();
            }

            com.onesignal.core.internal.config.ConfigModel.receiveReceiptEnabled.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean getRestoreTTLFilter() {
        return this.getBooleanProperty("restoreTTLFilter", com.onesignal.core.internal.config.ConfigModel.restoreTTLFilter.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.restoreTTLFilter.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.restoreTTLFilter.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.restoreTTLFilter.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.restoreTTLFilter.2();
            }

            com.onesignal.core.internal.config.ConfigModel.restoreTTLFilter.2() {
                super(0);
            }

            public final Boolean invoke() {
                return true;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final long getSessionFocusTimeout() {
        return this.getLongProperty("sessionFocusTimeout", com.onesignal.core.internal.config.ConfigModel.sessionFocusTimeout.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.sessionFocusTimeout.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.sessionFocusTimeout.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.sessionFocusTimeout.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.sessionFocusTimeout.2();
            }

            com.onesignal.core.internal.config.ConfigModel.sessionFocusTimeout.2() {
                super(0);
            }

            public final Long invoke() {
                return 30000L;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean getUnsubscribeWhenNotificationsDisabled() {
        return this.getBooleanProperty("unsubscribeWhenNotificationsDisabled", com.onesignal.core.internal.config.ConfigModel.unsubscribeWhenNotificationsDisabled.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.unsubscribeWhenNotificationsDisabled.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.unsubscribeWhenNotificationsDisabled.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.unsubscribeWhenNotificationsDisabled.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.unsubscribeWhenNotificationsDisabled.2();
            }

            com.onesignal.core.internal.config.ConfigModel.unsubscribeWhenNotificationsDisabled.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean getUseIdentityVerification() {
        return this.getBooleanProperty("useIdentityVerification", com.onesignal.core.internal.config.ConfigModel.useIdentityVerification.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.useIdentityVerification.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.useIdentityVerification.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.useIdentityVerification.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.useIdentityVerification.2();
            }

            com.onesignal.core.internal.config.ConfigModel.useIdentityVerification.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean getUserRejectedGMSUpdate() {
        return this.getBooleanProperty("userRejectedGMSUpdate", com.onesignal.core.internal.config.ConfigModel.userRejectedGMSUpdate.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.userRejectedGMSUpdate.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.userRejectedGMSUpdate.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.userRejectedGMSUpdate.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.userRejectedGMSUpdate.2();
            }

            com.onesignal.core.internal.config.ConfigModel.userRejectedGMSUpdate.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean isInitializedWithRemote() {
        return this.getBooleanProperty("isInitializedWithRemote", com.onesignal.core.internal.config.ConfigModel.isInitializedWithRemote.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.ConfigModel.isInitializedWithRemote.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.ConfigModel.isInitializedWithRemote.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.ConfigModel.isInitializedWithRemote.2.INSTANCE = new com.onesignal.core.internal.config.ConfigModel.isInitializedWithRemote.2();
            }

            com.onesignal.core.internal.config.ConfigModel.isInitializedWithRemote.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final void setApiUrl(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "apiUrl", s, null, false, 12, null);
    }

    public final void setAppId(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "appId", s, null, false, 12, null);
    }

    public final void setClearGroupOnSummaryClick(boolean z) {
        Model.setBooleanProperty$default(this, "clearGroupOnSummaryClick", z, null, false, 12, null);
    }

    public final void setConsentGiven(Boolean boolean0) {
        Model.setOptBooleanProperty$default(this, "consentGiven", boolean0, null, false, 12, null);
    }

    public final void setConsentRequired(Boolean boolean0) {
        Model.setOptBooleanProperty$default(this, "consentRequired", boolean0, null, false, 12, null);
    }

    public final void setDisableGMSMissingPrompt(boolean z) {
        Model.setBooleanProperty$default(this, "disableGMSMissingPrompt", z, null, false, 12, null);
    }

    public final void setEnterprise(boolean z) {
        Model.setBooleanProperty$default(this, "enterprise", z, null, false, 12, null);
    }

    public final void setFetchIAMMinInterval(long v) {
        Model.setLongProperty$default(this, "fetchIAMMinInterval", v, null, false, 12, null);
    }

    public final void setFirebaseAnalytics(boolean z) {
        Model.setBooleanProperty$default(this, "firebaseAnalytics", z, null, false, 12, null);
    }

    public final void setGoogleProjectNumber(String s) {
        Model.setOptStringProperty$default(this, "googleProjectNumber", s, null, false, 12, null);
    }

    public final void setHttpGetTimeout(int v) {
        Model.setIntProperty$default(this, "httpGetTimeout", v, null, false, 12, null);
    }

    public final void setHttpTimeout(int v) {
        Model.setIntProperty$default(this, "httpTimeout", v, null, false, 12, null);
    }

    public final void setInitializedWithRemote(boolean z) {
        Model.setBooleanProperty$default(this, "isInitializedWithRemote", z, null, false, 12, null);
    }

    public final void setLocationShared(boolean z) {
        Model.setBooleanProperty$default(this, "locationShared", z, null, false, 12, null);
    }

    public final void setNotificationChannels(JSONArray jSONArray0) {
        Model.setOptStringProperty$default(this, "notificationChannels", (jSONArray0 == null ? null : jSONArray0.toString()), null, false, 12, null);
    }

    public final void setOpRepoExecutionInterval(long v) {
        Model.setLongProperty$default(this, "opRepoExecutionInterval", v, null, false, 12, null);
    }

    public final void setOpRepoPostWakeDelay(long v) {
        Model.setLongProperty$default(this, "opRepoPostWakeDelay", v, null, false, 12, null);
    }

    public final void setPushSubscriptionId(String s) {
        Model.setOptStringProperty$default(this, "pushSubscriptionId", s, null, false, 12, null);
    }

    public final void setReceiveReceiptEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "receiveReceiptEnabled", z, null, false, 12, null);
    }

    public final void setRestoreTTLFilter(boolean z) {
        Model.setBooleanProperty$default(this, "restoreTTLFilter", z, null, false, 12, null);
    }

    public final void setSessionFocusTimeout(long v) {
        Model.setLongProperty$default(this, "sessionFocusTimeout", v, null, false, 12, null);
    }

    public final void setUnsubscribeWhenNotificationsDisabled(boolean z) {
        Model.setBooleanProperty$default(this, "unsubscribeWhenNotificationsDisabled", z, null, false, 12, null);
    }

    public final void setUseIdentityVerification(boolean z) {
        Model.setBooleanProperty$default(this, "useIdentityVerification", z, null, false, 12, null);
    }

    public final void setUserRejectedGMSUpdate(boolean z) {
        Model.setBooleanProperty$default(this, "userRejectedGMSUpdate", z, null, false, 12, null);
    }
}

