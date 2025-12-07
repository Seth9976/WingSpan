package com.onesignal.notifications.internal;

import androidx.core.app.NotificationCompat.Extender;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BackgroundImageLayout;
import com.onesignal.notifications.IActionButton;
import com.onesignal.notifications.IDisplayableMutableNotification;
import com.onesignal.notifications.internal.common.NotificationHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\t\n\u0002\b\u001A\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u007FB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u0006B/\b\u0016\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\fJ\b\u0010s\u001A\u00020tH\u0016J\u0006\u0010u\u001A\u00020vJ\u0018\u0010w\u001A\u00020t2\u0006\u0010x\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0002J\b\u0010y\u001A\u00020tH\u0002J\u0010\u0010z\u001A\u00020t2\u0006\u0010x\u001A\u00020\u0003H\u0002J\u0012\u0010{\u001A\u00020t2\b\u0010|\u001A\u0004\u0018\u00010JH\u0016J\u0006\u0010}\u001A\u00020\u0003J\b\u0010~\u001A\u00020#H\u0016R\"\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\bX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0003X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\n\u001A\u00020\u000BX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001C\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\u001C\u0010\"\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001C\u0010(\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010%\"\u0004\b*\u0010\'R\u001C\u0010+\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010%\"\u0004\b-\u0010\'R\u0011\u0010.\u001A\u00020/\u00A2\u0006\b\n\u0000\u001A\u0004\b0\u00101R\u001C\u00102\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b3\u0010%\"\u0004\b4\u0010\'R\u001C\u00105\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b6\u0010%\"\u0004\b7\u0010\'R\u001C\u00108\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b9\u0010%\"\u0004\b:\u0010\'R\"\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001C\u0010=\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b>\u0010%\"\u0004\b?\u0010\'R\u001C\u0010@\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bA\u0010%\"\u0004\bB\u0010\'R\u001C\u0010C\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bD\u0010%\"\u0004\bE\u0010\'R\u001A\u0010F\u001A\u00020\u000BX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001BR\u001C\u0010I\u001A\u0004\u0018\u00010JX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001C\u0010O\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bP\u0010%\"\u0004\bQ\u0010\'R\u001A\u0010R\u001A\u00020\u000BX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bS\u0010\u0019\"\u0004\bT\u0010\u001BR\u001A\u0010U\u001A\u00020#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bV\u0010%\"\u0004\bW\u0010\'R\u001A\u0010X\u001A\u00020YX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001C\u0010^\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b_\u0010%\"\u0004\b`\u0010\'R\u001C\u0010a\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bb\u0010%\"\u0004\bc\u0010\'R\u001C\u0010d\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\be\u0010%\"\u0004\bf\u0010\'R\u001C\u0010g\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bh\u0010%\"\u0004\bi\u0010\'R\u001C\u0010j\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bk\u0010%\"\u0004\bl\u0010\'R\u001C\u0010m\u001A\u0004\u0018\u00010#X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bn\u0010%\"\u0004\bo\u0010\'R\u001A\u0010p\u001A\u00020\u000BX\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bq\u0010\u0019\"\u0004\br\u0010\u001B\u00A8\u0006\u0080\u0001"}, d2 = {"Lcom/onesignal/notifications/internal/Notification;", "Lcom/onesignal/notifications/IDisplayableMutableNotification;", "payload", "Lorg/json/JSONObject;", "time", "Lcom/onesignal/core/internal/time/ITime;", "(Lorg/json/JSONObject;Lcom/onesignal/core/internal/time/ITime;)V", "groupedNotifications", "", "jsonPayload", "androidNotificationId", "", "(Ljava/util/List;Lorg/json/JSONObject;ILcom/onesignal/core/internal/time/ITime;)V", "actionButtons", "Lcom/onesignal/notifications/IActionButton;", "getActionButtons", "()Ljava/util/List;", "setActionButtons", "(Ljava/util/List;)V", "additionalData", "getAdditionalData", "()Lorg/json/JSONObject;", "setAdditionalData", "(Lorg/json/JSONObject;)V", "getAndroidNotificationId", "()I", "setAndroidNotificationId", "(I)V", "backgroundImageLayout", "Lcom/onesignal/notifications/BackgroundImageLayout;", "getBackgroundImageLayout", "()Lcom/onesignal/notifications/BackgroundImageLayout;", "setBackgroundImageLayout", "(Lcom/onesignal/notifications/BackgroundImageLayout;)V", "bigPicture", "", "getBigPicture", "()Ljava/lang/String;", "setBigPicture", "(Ljava/lang/String;)V", "body", "getBody", "setBody", "collapseId", "getCollapseId", "setCollapseId", "displayWaiter", "Lcom/onesignal/common/threading/Waiter;", "getDisplayWaiter", "()Lcom/onesignal/common/threading/Waiter;", "fromProjectNumber", "getFromProjectNumber", "setFromProjectNumber", "groupKey", "getGroupKey", "setGroupKey", "groupMessage", "getGroupMessage", "setGroupMessage", "getGroupedNotifications", "setGroupedNotifications", "largeIcon", "getLargeIcon", "setLargeIcon", "launchURL", "getLaunchURL", "setLaunchURL", "ledColor", "getLedColor", "setLedColor", "lockScreenVisibility", "getLockScreenVisibility", "setLockScreenVisibility", "notificationExtender", "Landroidx/core/app/NotificationCompat$Extender;", "getNotificationExtender", "()Landroidx/core/app/NotificationCompat$Extender;", "setNotificationExtender", "(Landroidx/core/app/NotificationCompat$Extender;)V", "notificationId", "getNotificationId", "setNotificationId", "priority", "getPriority", "setPriority", "rawPayload", "getRawPayload", "setRawPayload", "sentTime", "", "getSentTime", "()J", "setSentTime", "(J)V", "smallIcon", "getSmallIcon", "setSmallIcon", "smallIconAccentColor", "getSmallIconAccentColor", "setSmallIconAccentColor", "sound", "getSound", "setSound", "templateId", "getTemplateId", "setTemplateId", "templateName", "getTemplateName", "setTemplateName", "title", "getTitle", "setTitle", "ttl", "getTtl", "setTtl", "display", "", "hasNotificationId", "", "initPayloadData", "currentJsonPayload", "setActionButtonsFromData", "setBackgroundImageLayoutFromData", "setExtender", "extender", "toJSONObject", "toString", "ActionButton", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Notification implements IDisplayableMutableNotification {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000B\u001A\u00020\fR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/onesignal/notifications/internal/Notification$ActionButton;", "Lcom/onesignal/notifications/IActionButton;", "id", "", "text", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getId", "getText", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class ActionButton implements IActionButton {
        private final String icon;
        private final String id;
        private final String text;

        public ActionButton() {
            this(null, null, null, 7, null);
        }

        public ActionButton(String s, String s1, String s2) {
            this.id = s;
            this.text = s1;
            this.icon = s2;
        }

        public ActionButton(String s, String s1, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = null;
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                s2 = null;
            }
            this(s, s1, s2);
        }

        @Override  // com.onesignal.notifications.IActionButton
        public String getIcon() {
            return this.icon;
        }

        @Override  // com.onesignal.notifications.IActionButton
        public String getId() {
            return this.id;
        }

        @Override  // com.onesignal.notifications.IActionButton
        public String getText() {
            return this.text;
        }

        public final JSONObject toJSONObject() {
            JSONObject jSONObject0 = new JSONObject();
            try {
                jSONObject0.put("id", this.getId());
                jSONObject0.put("text", this.getText());
                jSONObject0.put("icon", this.getIcon());
            }
            catch(Throwable throwable0) {
                throwable0.printStackTrace();
            }
            return jSONObject0;
        }
    }

    private List actionButtons;
    private JSONObject additionalData;
    private int androidNotificationId;
    private BackgroundImageLayout backgroundImageLayout;
    private String bigPicture;
    private String body;
    private String collapseId;
    private final Waiter displayWaiter;
    private String fromProjectNumber;
    private String groupKey;
    private String groupMessage;
    private List groupedNotifications;
    private String largeIcon;
    private String launchURL;
    private String ledColor;
    private int lockScreenVisibility;
    private Extender notificationExtender;
    private String notificationId;
    private int priority;
    private String rawPayload;
    private long sentTime;
    private String smallIcon;
    private String smallIconAccentColor;
    private String sound;
    private String templateId;
    private String templateName;
    private String title;
    private int ttl;

    public Notification(List list0, JSONObject jSONObject0, int v, ITime iTime0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonPayload");
        Intrinsics.checkNotNullParameter(iTime0, "time");
        super();
        this.displayWaiter = new Waiter();
        this.lockScreenVisibility = 1;
        this.rawPayload = "";
        this.initPayloadData(jSONObject0, iTime0);
        this.setGroupedNotifications(list0);
        this.setAndroidNotificationId(v);
    }

    public Notification(JSONObject jSONObject0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "payload");
        Intrinsics.checkNotNullParameter(iTime0, "time");
        this(null, jSONObject0, 0, iTime0);
    }

    @Override  // com.onesignal.notifications.IDisplayableNotification
    public void display() {
        this.displayWaiter.wake();
    }

    @Override  // com.onesignal.notifications.INotification
    public List getActionButtons() {
        return this.actionButtons;
    }

    @Override  // com.onesignal.notifications.INotification
    public JSONObject getAdditionalData() {
        return this.additionalData;
    }

    @Override  // com.onesignal.notifications.INotification
    public int getAndroidNotificationId() {
        return this.androidNotificationId;
    }

    @Override  // com.onesignal.notifications.INotification
    public BackgroundImageLayout getBackgroundImageLayout() {
        return this.backgroundImageLayout;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getBigPicture() {
        return this.bigPicture;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getBody() {
        return this.body;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getCollapseId() {
        return this.collapseId;
    }

    public final Waiter getDisplayWaiter() {
        return this.displayWaiter;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getFromProjectNumber() {
        return this.fromProjectNumber;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getGroupKey() {
        return this.groupKey;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getGroupMessage() {
        return this.groupMessage;
    }

    @Override  // com.onesignal.notifications.INotification
    public List getGroupedNotifications() {
        return this.groupedNotifications;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getLargeIcon() {
        return this.largeIcon;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getLaunchURL() {
        return this.launchURL;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getLedColor() {
        return this.ledColor;
    }

    @Override  // com.onesignal.notifications.INotification
    public int getLockScreenVisibility() {
        return this.lockScreenVisibility;
    }

    public final Extender getNotificationExtender() {
        return this.notificationExtender;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getNotificationId() {
        return this.notificationId;
    }

    @Override  // com.onesignal.notifications.INotification
    public int getPriority() {
        return this.priority;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getRawPayload() {
        return this.rawPayload;
    }

    @Override  // com.onesignal.notifications.INotification
    public long getSentTime() {
        return this.sentTime;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getSmallIcon() {
        return this.smallIcon;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getSmallIconAccentColor() {
        return this.smallIconAccentColor;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getSound() {
        return this.sound;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getTemplateId() {
        return this.templateId;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getTemplateName() {
        return this.templateName;
    }

    @Override  // com.onesignal.notifications.INotification
    public String getTitle() {
        return this.title;
    }

    @Override  // com.onesignal.notifications.INotification
    public int getTtl() {
        return this.ttl;
    }

    public final boolean hasNotificationId() {
        return this.getAndroidNotificationId() != 0;
    }

    private final void initPayloadData(JSONObject jSONObject0, ITime iTime0) {
        JSONObject jSONObject1;
        try {
            jSONObject1 = NotificationHelper.INSTANCE.getCustomJSONObject(jSONObject0);
        }
        catch(Throwable throwable0) {
            Logging.error("Error assigning OSNotificationReceivedEvent payload values!", throwable0);
            return;
        }
        long v = iTime0.getCurrentTimeMillis();
        if(jSONObject0.has("google.ttl")) {
            this.setSentTime(jSONObject0.optLong("google.sent_time", v) / 1000L);
            this.setTtl(jSONObject0.optInt("google.ttl", 0x3F480));
        }
        else if(jSONObject0.has("hms.ttl")) {
            this.setSentTime(jSONObject0.optLong("hms.sent_time", v) / 1000L);
            this.setTtl(jSONObject0.optInt("hms.ttl", 0x3F480));
        }
        else {
            this.setSentTime(v / 1000L);
            this.setTtl(0x3F480);
        }
        this.setNotificationId(JSONObjectExtensionsKt.safeString(jSONObject1, "i"));
        this.setTemplateId(JSONObjectExtensionsKt.safeString(jSONObject1, "ti"));
        this.setTemplateName(JSONObjectExtensionsKt.safeString(jSONObject1, "tn"));
        String s = jSONObject0.toString();
        Intrinsics.checkNotNullExpressionValue(s, "currentJsonPayload.toString()");
        this.setRawPayload(s);
        this.setAdditionalData(JSONObjectExtensionsKt.safeJSONObject(jSONObject1, "a"));
        this.setLaunchURL(JSONObjectExtensionsKt.safeString(jSONObject1, "u"));
        this.setBody(JSONObjectExtensionsKt.safeString(jSONObject0, "alert"));
        this.setTitle(JSONObjectExtensionsKt.safeString(jSONObject0, "title"));
        this.setSmallIcon(JSONObjectExtensionsKt.safeString(jSONObject0, "sicon"));
        this.setBigPicture(JSONObjectExtensionsKt.safeString(jSONObject0, "bicon"));
        this.setLargeIcon(JSONObjectExtensionsKt.safeString(jSONObject0, "licon"));
        this.setSound(JSONObjectExtensionsKt.safeString(jSONObject0, "sound"));
        this.setGroupKey(JSONObjectExtensionsKt.safeString(jSONObject0, "grp"));
        this.setGroupMessage(JSONObjectExtensionsKt.safeString(jSONObject0, "grp_msg"));
        this.setSmallIconAccentColor(JSONObjectExtensionsKt.safeString(jSONObject0, "bgac"));
        this.setLedColor(JSONObjectExtensionsKt.safeString(jSONObject0, "ledc"));
        String s1 = JSONObjectExtensionsKt.safeString(jSONObject0, "vis");
        if(s1 != null) {
            this.setLockScreenVisibility(Integer.parseInt(s1));
        }
        this.setFromProjectNumber(JSONObjectExtensionsKt.safeString(jSONObject0, "from"));
        this.setPriority(jSONObject0.optInt("pri", 0));
        String s2 = JSONObjectExtensionsKt.safeString(jSONObject0, "collapse_key");
        if(!Intrinsics.areEqual("do_not_collapse", s2)) {
            this.setCollapseId(s2);
        }
        try {
            this.setActionButtonsFromData();
        }
        catch(Throwable throwable1) {
            Logging.error("Error assigning OSNotificationReceivedEvent.actionButtons values!", throwable1);
        }
        try {
            this.setBackgroundImageLayoutFromData(jSONObject0);
        }
        catch(Throwable throwable2) {
            Logging.error("Error assigning OSNotificationReceivedEvent.backgroundImageLayout values!", throwable2);
        }
    }

    public void setActionButtons(List list0) {
        this.actionButtons = list0;
    }

    private final void setActionButtonsFromData() throws Throwable {
        if(this.getAdditionalData() != null) {
            JSONObject jSONObject0 = this.getAdditionalData();
            Intrinsics.checkNotNull(jSONObject0);
            if(jSONObject0.has("actionButtons")) {
                JSONObject jSONObject1 = this.getAdditionalData();
                Intrinsics.checkNotNull(jSONObject1);
                JSONArray jSONArray0 = jSONObject1.getJSONArray("actionButtons");
                List list0 = new ArrayList();
                int v = jSONArray0.length();
                for(int v1 = 0; v1 < v; ++v1) {
                    JSONObject jSONObject2 = jSONArray0.getJSONObject(v1);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonActionButton");
                    list0.add(new ActionButton(JSONObjectExtensionsKt.safeString(jSONObject2, "id"), JSONObjectExtensionsKt.safeString(jSONObject2, "text"), JSONObjectExtensionsKt.safeString(jSONObject2, "icon")));
                }
                this.setActionButtons(list0);
                JSONObject jSONObject3 = this.getAdditionalData();
                Intrinsics.checkNotNull(jSONObject3);
                jSONObject3.remove("actionId");
                JSONObject jSONObject4 = this.getAdditionalData();
                Intrinsics.checkNotNull(jSONObject4);
                jSONObject4.remove("actionButtons");
            }
        }
    }

    public void setAdditionalData(JSONObject jSONObject0) {
        this.additionalData = jSONObject0;
    }

    public void setAndroidNotificationId(int v) {
        this.androidNotificationId = v;
    }

    public void setBackgroundImageLayout(BackgroundImageLayout backgroundImageLayout0) {
        this.backgroundImageLayout = backgroundImageLayout0;
    }

    private final void setBackgroundImageLayoutFromData(JSONObject jSONObject0) throws Throwable {
        String s = JSONObjectExtensionsKt.safeString(jSONObject0, "bg_img");
        if(s != null) {
            JSONObject jSONObject1 = new JSONObject(s);
            this.setBackgroundImageLayout(new BackgroundImageLayout(JSONObjectExtensionsKt.safeString(jSONObject1, "img"), JSONObjectExtensionsKt.safeString(jSONObject1, "tc"), JSONObjectExtensionsKt.safeString(jSONObject1, "bc")));
        }
    }

    public void setBigPicture(String s) {
        this.bigPicture = s;
    }

    public void setBody(String s) {
        this.body = s;
    }

    public void setCollapseId(String s) {
        this.collapseId = s;
    }

    @Override  // com.onesignal.notifications.IMutableNotification
    public void setExtender(Extender notificationCompat$Extender0) {
        this.notificationExtender = notificationCompat$Extender0;
    }

    public void setFromProjectNumber(String s) {
        this.fromProjectNumber = s;
    }

    public void setGroupKey(String s) {
        this.groupKey = s;
    }

    public void setGroupMessage(String s) {
        this.groupMessage = s;
    }

    public void setGroupedNotifications(List list0) {
        this.groupedNotifications = list0;
    }

    public void setLargeIcon(String s) {
        this.largeIcon = s;
    }

    public void setLaunchURL(String s) {
        this.launchURL = s;
    }

    public void setLedColor(String s) {
        this.ledColor = s;
    }

    public void setLockScreenVisibility(int v) {
        this.lockScreenVisibility = v;
    }

    public final void setNotificationExtender(Extender notificationCompat$Extender0) {
        this.notificationExtender = notificationCompat$Extender0;
    }

    public void setNotificationId(String s) {
        this.notificationId = s;
    }

    public void setPriority(int v) {
        this.priority = v;
    }

    public void setRawPayload(String s) {
        Intrinsics.checkNotNullParameter(s, "<set-?>");
        this.rawPayload = s;
    }

    public void setSentTime(long v) {
        this.sentTime = v;
    }

    public void setSmallIcon(String s) {
        this.smallIcon = s;
    }

    public void setSmallIconAccentColor(String s) {
        this.smallIconAccentColor = s;
    }

    public void setSound(String s) {
        this.sound = s;
    }

    public void setTemplateId(String s) {
        this.templateId = s;
    }

    public void setTemplateName(String s) {
        this.templateName = s;
    }

    public void setTitle(String s) {
        this.title = s;
    }

    public void setTtl(int v) {
        this.ttl = v;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("androidNotificationId", this.getAndroidNotificationId());
            JSONArray jSONArray0 = new JSONArray();
            if(this.getGroupedNotifications() != null) {
                List list0 = this.getGroupedNotifications();
                Intrinsics.checkNotNull(list0);
                for(Object object0: list0) {
                    jSONArray0.put(((Notification)object0).toJSONObject());
                }
            }
            jSONObject0.put("groupedNotifications", jSONArray0);
            jSONObject0.put("notificationId", this.getNotificationId());
            jSONObject0.put("templateName", this.getTemplateName());
            jSONObject0.put("templateId", this.getTemplateId());
            jSONObject0.put("title", this.getTitle());
            jSONObject0.put("body", this.getBody());
            jSONObject0.put("smallIcon", this.getSmallIcon());
            jSONObject0.put("largeIcon", this.getLargeIcon());
            jSONObject0.put("bigPicture", this.getBigPicture());
            jSONObject0.put("smallIconAccentColor", this.getSmallIconAccentColor());
            jSONObject0.put("launchURL", this.getLaunchURL());
            jSONObject0.put("sound", this.getSound());
            jSONObject0.put("ledColor", this.getLedColor());
            jSONObject0.put("lockScreenVisibility", this.getLockScreenVisibility());
            jSONObject0.put("groupKey", this.getGroupKey());
            jSONObject0.put("groupMessage", this.getGroupMessage());
            jSONObject0.put("fromProjectNumber", this.getFromProjectNumber());
            jSONObject0.put("collapseId", this.getCollapseId());
            jSONObject0.put("priority", this.getPriority());
            if(this.getAdditionalData() != null) {
                jSONObject0.put("additionalData", this.getAdditionalData());
            }
            if(this.getActionButtons() != null) {
                JSONArray jSONArray1 = new JSONArray();
                List list1 = this.getActionButtons();
                Intrinsics.checkNotNull(list1);
                for(Object object1: list1) {
                    Intrinsics.checkNotNull(((IActionButton)object1), "null cannot be cast to non-null type com.onesignal.notifications.internal.Notification.ActionButton");
                    jSONArray1.put(((ActionButton)(((IActionButton)object1))).toJSONObject());
                }
                jSONObject0.put("actionButtons", jSONArray1);
            }
            jSONObject0.put("rawPayload", this.getRawPayload());
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OSNotification{notificationExtender=" + this.notificationExtender + ", groupedNotifications=" + this.getGroupedNotifications() + ", androidNotificationId=" + this.getAndroidNotificationId() + ", notificationId=\'" + this.getNotificationId() + "\', templateName=\'" + this.getTemplateName() + "\', templateId=\'" + this.getTemplateId() + "\', title=\'" + this.getTitle() + "\', body=\'" + this.getBody() + "\', additionalData=" + this.getAdditionalData() + ", smallIcon=\'" + this.getSmallIcon() + "\', largeIcon=\'" + this.getLargeIcon() + "\', bigPicture=\'" + this.getBigPicture() + "\', smallIconAccentColor=\'" + this.getSmallIconAccentColor() + "\', launchURL=\'" + this.getLaunchURL() + "\', sound=\'" + this.getSound() + "\', ledColor=\'" + this.getLedColor() + "\', lockScreenVisibility=" + this.getLockScreenVisibility() + ", groupKey=\'" + this.getGroupKey() + "\', groupMessage=\'" + this.getGroupMessage() + "\', actionButtons=" + this.getActionButtons() + ", fromProjectNumber=\'" + this.getFromProjectNumber() + "\', backgroundImageLayout=" + this.getBackgroundImageLayout() + ", collapseId=\'" + this.getCollapseId() + "\', priority=" + this.getPriority() + ", rawPayload=\'" + this.getRawPayload() + "\'}";
    }
}

