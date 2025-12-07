package com.onesignal.notifications;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u001D\n\u0002\u0010\t\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001R\u001A\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\bX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u00020\fX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u00108&X\u00A7\u0004\u00A2\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018R\u0014\u0010\u001B\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001C\u0010\u0018R\u0014\u0010\u001D\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001E\u0010\u0018R\u0014\u0010\u001F\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b \u0010\u0018R\u0014\u0010!\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b\"\u0010\u0018R\u001A\u0010#\u001A\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0003X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b$\u0010\u0006R\u0014\u0010%\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b&\u0010\u0018R\u0014\u0010\'\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b(\u0010\u0018R\u0014\u0010)\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b*\u0010\u0018R\u0012\u0010+\u001A\u00020\fX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b,\u0010\u000ER\u0014\u0010-\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b.\u0010\u0018R\u0012\u0010/\u001A\u00020\fX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b0\u0010\u000ER\u0012\u00101\u001A\u00020\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b2\u0010\u0018R\u0012\u00103\u001A\u000204X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b5\u00106R\u0014\u00107\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b8\u0010\u0018R\u0014\u00109\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b:\u0010\u0018R\u0014\u0010;\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b<\u0010\u0018R\u0014\u0010=\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b>\u0010\u0018R\u0014\u0010?\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b@\u0010\u0018R\u0014\u0010A\u001A\u0004\u0018\u00010\u0016X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bB\u0010\u0018R\u0012\u0010C\u001A\u00020\fX\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bD\u0010\u000E\u00A8\u0006E"}, d2 = {"Lcom/onesignal/notifications/INotification;", "", "actionButtons", "", "Lcom/onesignal/notifications/IActionButton;", "getActionButtons", "()Ljava/util/List;", "additionalData", "Lorg/json/JSONObject;", "getAdditionalData", "()Lorg/json/JSONObject;", "androidNotificationId", "", "getAndroidNotificationId", "()I", "backgroundImageLayout", "Lcom/onesignal/notifications/BackgroundImageLayout;", "getBackgroundImageLayout$annotations", "()V", "getBackgroundImageLayout", "()Lcom/onesignal/notifications/BackgroundImageLayout;", "bigPicture", "", "getBigPicture", "()Ljava/lang/String;", "body", "getBody", "collapseId", "getCollapseId", "fromProjectNumber", "getFromProjectNumber", "groupKey", "getGroupKey", "groupMessage", "getGroupMessage", "groupedNotifications", "getGroupedNotifications", "largeIcon", "getLargeIcon", "launchURL", "getLaunchURL", "ledColor", "getLedColor", "lockScreenVisibility", "getLockScreenVisibility", "notificationId", "getNotificationId", "priority", "getPriority", "rawPayload", "getRawPayload", "sentTime", "", "getSentTime", "()J", "smallIcon", "getSmallIcon", "smallIconAccentColor", "getSmallIconAccentColor", "sound", "getSound", "templateId", "getTemplateId", "templateName", "getTemplateName", "title", "getTitle", "ttl", "getTtl", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotification {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated(message = "This is not applicable for Android 12+")
        public static void getBackgroundImageLayout$annotations() {
        }
    }

    List getActionButtons();

    JSONObject getAdditionalData();

    int getAndroidNotificationId();

    BackgroundImageLayout getBackgroundImageLayout();

    String getBigPicture();

    String getBody();

    String getCollapseId();

    String getFromProjectNumber();

    String getGroupKey();

    String getGroupMessage();

    List getGroupedNotifications();

    String getLargeIcon();

    String getLaunchURL();

    String getLedColor();

    int getLockScreenVisibility();

    String getNotificationId();

    int getPriority();

    String getRawPayload();

    long getSentTime();

    String getSmallIcon();

    String getSmallIconAccentColor();

    String getSound();

    String getTemplateId();

    String getTemplateName();

    String getTitle();

    int getTtl();
}

