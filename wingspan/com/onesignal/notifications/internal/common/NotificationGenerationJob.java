package com.onesignal.notifications.internal.common;

import android.net.Uri;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.Notification;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000B\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\u0002\u0010\tJ\u0006\u0010H\u001A\u00020\u001AJ\b\u0010I\u001A\u00020\u0012H\u0016J\f\u0010J\u001A\u00020\b*\u00020\bH\u0002R\u0011\u0010\n\u001A\u00020\u00038F\u00A2\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\u000E8F\u00A2\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u00128F\u00A2\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u00168F\u00A2\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u001AX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u001AX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001B\"\u0004\b\u001F\u0010\u001DR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\f\"\u0004\b!\u0010\"R\u0011\u0010#\u001A\u00020\b\u00A2\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u001E\u0010&\u001A\u0004\u0018\u00010\u000EX\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010+\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001C\u0010,\u001A\u0004\u0018\u00010-X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R\u001C\u00102\u001A\u0004\u0018\u00010\u0016X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b3\u0010\u0018\"\u0004\b4\u00105R\u001E\u00106\u001A\u0004\u0018\u00010\u000EX\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010+\u001A\u0004\b7\u0010(\"\u0004\b8\u0010*R\u001C\u00109\u001A\u0004\u0018\u00010-X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b:\u0010/\"\u0004\b;\u00101R\u001C\u0010<\u001A\u0004\u0018\u00010\u0016X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b=\u0010\u0018\"\u0004\b>\u00105R\u001E\u0010?\u001A\u0004\u0018\u00010@X\u0086\u000E\u00A2\u0006\u0010\n\u0002\u0010E\u001A\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0013\u0010F\u001A\u0004\u0018\u00010\u00168F\u00A2\u0006\u0006\u001A\u0004\bG\u0010\u0018\u00A8\u0006K"}, d2 = {"Lcom/onesignal/notifications/internal/common/NotificationGenerationJob;", "", "jsonPayload", "Lorg/json/JSONObject;", "time", "Lcom/onesignal/core/internal/time/ITime;", "(Lorg/json/JSONObject;Lcom/onesignal/core/internal/time/ITime;)V", "inNotification", "Lcom/onesignal/notifications/internal/Notification;", "(Lcom/onesignal/notifications/internal/Notification;Lorg/json/JSONObject;)V", "additionalData", "getAdditionalData", "()Lorg/json/JSONObject;", "androidId", "", "getAndroidId", "()I", "apiNotificationId", "", "getApiNotificationId", "()Ljava/lang/String;", "body", "", "getBody", "()Ljava/lang/CharSequence;", "isNotificationToDisplay", "", "()Z", "setNotificationToDisplay", "(Z)V", "isRestoring", "setRestoring", "getJsonPayload", "setJsonPayload", "(Lorg/json/JSONObject;)V", "notification", "getNotification", "()Lcom/onesignal/notifications/internal/Notification;", "orgFlags", "getOrgFlags", "()Ljava/lang/Integer;", "setOrgFlags", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "orgSound", "Landroid/net/Uri;", "getOrgSound", "()Landroid/net/Uri;", "setOrgSound", "(Landroid/net/Uri;)V", "overriddenBodyFromExtender", "getOverriddenBodyFromExtender", "setOverriddenBodyFromExtender", "(Ljava/lang/CharSequence;)V", "overriddenFlags", "getOverriddenFlags", "setOverriddenFlags", "overriddenSound", "getOverriddenSound", "setOverriddenSound", "overriddenTitleFromExtender", "getOverriddenTitleFromExtender", "setOverriddenTitleFromExtender", "shownTimeStamp", "", "getShownTimeStamp", "()Ljava/lang/Long;", "setShownTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "title", "getTitle", "hasExtender", "toString", "setAndroidNotificationId", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationGenerationJob {
    private boolean isNotificationToDisplay;
    private boolean isRestoring;
    private JSONObject jsonPayload;
    private final Notification notification;
    private Integer orgFlags;
    private Uri orgSound;
    private CharSequence overriddenBodyFromExtender;
    private Integer overriddenFlags;
    private Uri overriddenSound;
    private CharSequence overriddenTitleFromExtender;
    private Long shownTimeStamp;

    public NotificationGenerationJob(Notification notification0, JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(notification0, "inNotification");
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonPayload");
        super();
        this.jsonPayload = jSONObject0;
        this.notification = this.setAndroidNotificationId(notification0);
    }

    public NotificationGenerationJob(JSONObject jSONObject0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonPayload");
        Intrinsics.checkNotNullParameter(iTime0, "time");
        this(new Notification(jSONObject0, iTime0), jSONObject0);
    }

    public final JSONObject getAdditionalData() {
        Intrinsics.checkNotNull(this.notification);
        JSONObject jSONObject0 = this.notification.getAdditionalData();
        return jSONObject0 == null ? new JSONObject() : jSONObject0;
    }

    public final int getAndroidId() {
        Intrinsics.checkNotNull(this.notification);
        return this.notification.getAndroidNotificationId();
    }

    public final String getApiNotificationId() {
        String s = NotificationHelper.INSTANCE.getNotificationIdFromFCMJson(this.jsonPayload);
        return s == null ? "" : s;
    }

    public final CharSequence getBody() {
        CharSequence charSequence0 = this.overriddenBodyFromExtender;
        if(charSequence0 == null) {
            Intrinsics.checkNotNull(this.notification);
            return this.notification.getBody();
        }
        return charSequence0;
    }

    public final JSONObject getJsonPayload() {
        return this.jsonPayload;
    }

    public final Notification getNotification() {
        return this.notification;
    }

    public final Integer getOrgFlags() {
        return this.orgFlags;
    }

    public final Uri getOrgSound() {
        return this.orgSound;
    }

    public final CharSequence getOverriddenBodyFromExtender() {
        return this.overriddenBodyFromExtender;
    }

    public final Integer getOverriddenFlags() {
        return this.overriddenFlags;
    }

    public final Uri getOverriddenSound() {
        return this.overriddenSound;
    }

    public final CharSequence getOverriddenTitleFromExtender() {
        return this.overriddenTitleFromExtender;
    }

    public final Long getShownTimeStamp() {
        return this.shownTimeStamp;
    }

    public final CharSequence getTitle() {
        CharSequence charSequence0 = this.overriddenTitleFromExtender;
        if(charSequence0 == null) {
            Intrinsics.checkNotNull(this.notification);
            return this.notification.getTitle();
        }
        return charSequence0;
    }

    public final boolean hasExtender() {
        Intrinsics.checkNotNull(this.notification);
        return this.notification.getNotificationExtender() != null;
    }

    public final boolean isNotificationToDisplay() {
        return this.isNotificationToDisplay;
    }

    public final boolean isRestoring() {
        return this.isRestoring;
    }

    private final Notification setAndroidNotificationId(Notification notification0) {
        if(notification0 != null && !notification0.hasNotificationId()) {
            notification0.setAndroidNotificationId(new SecureRandom().nextInt());
        }
        return notification0;
    }

    public final void setJsonPayload(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<set-?>");
        this.jsonPayload = jSONObject0;
    }

    public final void setNotificationToDisplay(boolean z) {
        this.isNotificationToDisplay = z;
    }

    public final void setOrgFlags(Integer integer0) {
        this.orgFlags = integer0;
    }

    public final void setOrgSound(Uri uri0) {
        this.orgSound = uri0;
    }

    public final void setOverriddenBodyFromExtender(CharSequence charSequence0) {
        this.overriddenBodyFromExtender = charSequence0;
    }

    public final void setOverriddenFlags(Integer integer0) {
        this.overriddenFlags = integer0;
    }

    public final void setOverriddenSound(Uri uri0) {
        this.overriddenSound = uri0;
    }

    public final void setOverriddenTitleFromExtender(CharSequence charSequence0) {
        this.overriddenTitleFromExtender = charSequence0;
    }

    public final void setRestoring(boolean z) {
        this.isRestoring = z;
    }

    public final void setShownTimeStamp(Long long0) {
        this.shownTimeStamp = long0;
    }

    @Override
    public String toString() {
        return "NotificationGenerationJob{jsonPayload=" + this.jsonPayload + ", isRestoring=" + this.isRestoring + ", isNotificationToDisplay=" + this.isNotificationToDisplay + ", shownTimeStamp=" + this.shownTimeStamp + ", overriddenBodyFromExtender=" + this.overriddenBodyFromExtender + ", overriddenTitleFromExtender=" + this.overriddenTitleFromExtender + ", overriddenSound=" + this.overriddenSound + ", overriddenFlags=" + this.overriddenFlags + ", orgFlags=" + this.orgFlags + ", orgSound=" + this.orgSound + ", notification=" + this.notification + '}';
    }
}

