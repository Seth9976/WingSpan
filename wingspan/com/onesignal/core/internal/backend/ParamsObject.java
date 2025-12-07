package com.onesignal.core.internal.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\u0018\u00002\u00020\u0001B\u00B1\u0001\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\u0006\u0010\u0015\u001A\u00020\u0016\u00A2\u0006\u0002\u0010\u0017R\u001E\u0010\u000B\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001E\u0010\r\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b\u001D\u0010\u0019\"\u0004\b\u001E\u0010\u001BR\u001E\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b\u001F\u0010\u0019\"\u0004\b \u0010\u001BR\u001A\u0010\u0015\u001A\u00020\u0016X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001E\u0010\t\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001BR\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001A\u0010\u0013\u001A\u00020\u0014X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001E\u0010\u000F\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001BR\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\u001E\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u00109\u001A\u0004\b5\u00106\"\u0004\b7\u00108R\u001E\u0010\f\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001BR\u001E\u0010\u0010\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b<\u0010\u0019\"\u0004\b=\u0010\u001BR\u001E\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001BR\u001E\u0010\u000E\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001BR\u001E\u0010\u0006\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\bB\u0010\u0019\"\u0004\bC\u0010\u001B\u00A8\u0006D"}, d2 = {"Lcom/onesignal/core/internal/backend/ParamsObject;", "", "googleProjectNumber", "", "enterprise", "", "useIdentityVerification", "notificationChannels", "Lorg/json/JSONArray;", "firebaseAnalytics", "restoreTTLFilter", "clearGroupOnSummaryClick", "receiveReceiptEnabled", "disableGMSMissingPrompt", "unsubscribeWhenNotificationsDisabled", "locationShared", "requiresUserPrivacyConsent", "opRepoExecutionInterval", "", "influenceParams", "Lcom/onesignal/core/internal/backend/InfluenceParamsObject;", "fcmParams", "Lcom/onesignal/core/internal/backend/FCMParamsObject;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lorg/json/JSONArray;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/onesignal/core/internal/backend/InfluenceParamsObject;Lcom/onesignal/core/internal/backend/FCMParamsObject;)V", "getClearGroupOnSummaryClick", "()Ljava/lang/Boolean;", "setClearGroupOnSummaryClick", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "getEnterprise", "setEnterprise", "getFcmParams", "()Lcom/onesignal/core/internal/backend/FCMParamsObject;", "setFcmParams", "(Lcom/onesignal/core/internal/backend/FCMParamsObject;)V", "getFirebaseAnalytics", "setFirebaseAnalytics", "getGoogleProjectNumber", "()Ljava/lang/String;", "setGoogleProjectNumber", "(Ljava/lang/String;)V", "getInfluenceParams", "()Lcom/onesignal/core/internal/backend/InfluenceParamsObject;", "setInfluenceParams", "(Lcom/onesignal/core/internal/backend/InfluenceParamsObject;)V", "getLocationShared", "setLocationShared", "getNotificationChannels", "()Lorg/json/JSONArray;", "setNotificationChannels", "(Lorg/json/JSONArray;)V", "getOpRepoExecutionInterval", "()Ljava/lang/Long;", "setOpRepoExecutionInterval", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getReceiveReceiptEnabled", "setReceiveReceiptEnabled", "getRequiresUserPrivacyConsent", "setRequiresUserPrivacyConsent", "getRestoreTTLFilter", "setRestoreTTLFilter", "getUnsubscribeWhenNotificationsDisabled", "setUnsubscribeWhenNotificationsDisabled", "getUseIdentityVerification", "setUseIdentityVerification", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ParamsObject {
    private Boolean clearGroupOnSummaryClick;
    private Boolean disableGMSMissingPrompt;
    private Boolean enterprise;
    private FCMParamsObject fcmParams;
    private Boolean firebaseAnalytics;
    private String googleProjectNumber;
    private InfluenceParamsObject influenceParams;
    private Boolean locationShared;
    private JSONArray notificationChannels;
    private Long opRepoExecutionInterval;
    private Boolean receiveReceiptEnabled;
    private Boolean requiresUserPrivacyConsent;
    private Boolean restoreTTLFilter;
    private Boolean unsubscribeWhenNotificationsDisabled;
    private Boolean useIdentityVerification;

    public ParamsObject(String s, Boolean boolean0, Boolean boolean1, JSONArray jSONArray0, Boolean boolean2, Boolean boolean3, Boolean boolean4, Boolean boolean5, Boolean boolean6, Boolean boolean7, Boolean boolean8, Boolean boolean9, Long long0, InfluenceParamsObject influenceParamsObject0, FCMParamsObject fCMParamsObject0) {
        Intrinsics.checkNotNullParameter(influenceParamsObject0, "influenceParams");
        Intrinsics.checkNotNullParameter(fCMParamsObject0, "fcmParams");
        super();
        this.googleProjectNumber = s;
        this.enterprise = boolean0;
        this.useIdentityVerification = boolean1;
        this.notificationChannels = jSONArray0;
        this.firebaseAnalytics = boolean2;
        this.restoreTTLFilter = boolean3;
        this.clearGroupOnSummaryClick = boolean4;
        this.receiveReceiptEnabled = boolean5;
        this.disableGMSMissingPrompt = boolean6;
        this.unsubscribeWhenNotificationsDisabled = boolean7;
        this.locationShared = boolean8;
        this.requiresUserPrivacyConsent = boolean9;
        this.opRepoExecutionInterval = long0;
        this.influenceParams = influenceParamsObject0;
        this.fcmParams = fCMParamsObject0;
    }

    public ParamsObject(String s, Boolean boolean0, Boolean boolean1, JSONArray jSONArray0, Boolean boolean2, Boolean boolean3, Boolean boolean4, Boolean boolean5, Boolean boolean6, Boolean boolean7, Boolean boolean8, Boolean boolean9, Long long0, InfluenceParamsObject influenceParamsObject0, FCMParamsObject fCMParamsObject0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v & 1) == 0 ? s : null), ((v & 2) == 0 ? boolean0 : null), ((v & 4) == 0 ? boolean1 : null), ((v & 8) == 0 ? jSONArray0 : null), ((v & 16) == 0 ? boolean2 : null), ((v & 0x20) == 0 ? boolean3 : null), ((v & 0x40) == 0 ? boolean4 : null), ((v & 0x80) == 0 ? boolean5 : null), ((v & 0x100) == 0 ? boolean6 : null), ((v & 0x200) == 0 ? boolean7 : null), ((v & 0x400) == 0 ? boolean8 : null), ((v & 0x800) == 0 ? boolean9 : null), ((v & 0x1000) == 0 ? long0 : null), influenceParamsObject0, fCMParamsObject0);
    }

    public final Boolean getClearGroupOnSummaryClick() {
        return this.clearGroupOnSummaryClick;
    }

    public final Boolean getDisableGMSMissingPrompt() {
        return this.disableGMSMissingPrompt;
    }

    public final Boolean getEnterprise() {
        return this.enterprise;
    }

    public final FCMParamsObject getFcmParams() {
        return this.fcmParams;
    }

    public final Boolean getFirebaseAnalytics() {
        return this.firebaseAnalytics;
    }

    public final String getGoogleProjectNumber() {
        return this.googleProjectNumber;
    }

    public final InfluenceParamsObject getInfluenceParams() {
        return this.influenceParams;
    }

    public final Boolean getLocationShared() {
        return this.locationShared;
    }

    public final JSONArray getNotificationChannels() {
        return this.notificationChannels;
    }

    public final Long getOpRepoExecutionInterval() {
        return this.opRepoExecutionInterval;
    }

    public final Boolean getReceiveReceiptEnabled() {
        return this.receiveReceiptEnabled;
    }

    public final Boolean getRequiresUserPrivacyConsent() {
        return this.requiresUserPrivacyConsent;
    }

    public final Boolean getRestoreTTLFilter() {
        return this.restoreTTLFilter;
    }

    public final Boolean getUnsubscribeWhenNotificationsDisabled() {
        return this.unsubscribeWhenNotificationsDisabled;
    }

    public final Boolean getUseIdentityVerification() {
        return this.useIdentityVerification;
    }

    public final void setClearGroupOnSummaryClick(Boolean boolean0) {
        this.clearGroupOnSummaryClick = boolean0;
    }

    public final void setDisableGMSMissingPrompt(Boolean boolean0) {
        this.disableGMSMissingPrompt = boolean0;
    }

    public final void setEnterprise(Boolean boolean0) {
        this.enterprise = boolean0;
    }

    public final void setFcmParams(FCMParamsObject fCMParamsObject0) {
        Intrinsics.checkNotNullParameter(fCMParamsObject0, "<set-?>");
        this.fcmParams = fCMParamsObject0;
    }

    public final void setFirebaseAnalytics(Boolean boolean0) {
        this.firebaseAnalytics = boolean0;
    }

    public final void setGoogleProjectNumber(String s) {
        this.googleProjectNumber = s;
    }

    public final void setInfluenceParams(InfluenceParamsObject influenceParamsObject0) {
        Intrinsics.checkNotNullParameter(influenceParamsObject0, "<set-?>");
        this.influenceParams = influenceParamsObject0;
    }

    public final void setLocationShared(Boolean boolean0) {
        this.locationShared = boolean0;
    }

    public final void setNotificationChannels(JSONArray jSONArray0) {
        this.notificationChannels = jSONArray0;
    }

    public final void setOpRepoExecutionInterval(Long long0) {
        this.opRepoExecutionInterval = long0;
    }

    public final void setReceiveReceiptEnabled(Boolean boolean0) {
        this.receiveReceiptEnabled = boolean0;
    }

    public final void setRequiresUserPrivacyConsent(Boolean boolean0) {
        this.requiresUserPrivacyConsent = boolean0;
    }

    public final void setRestoreTTLFilter(Boolean boolean0) {
        this.restoreTTLFilter = boolean0;
    }

    public final void setUnsubscribeWhenNotificationsDisabled(Boolean boolean0) {
        this.unsubscribeWhenNotificationsDisabled = boolean0;
    }

    public final void setUseIdentityVerification(Boolean boolean0) {
        this.useIdentityVerification = boolean0;
    }
}

