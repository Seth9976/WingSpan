package com.voxelbusters.essentialkit.notificationservices.datatypes;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.ResourcesUtil;
import com.voxelbusters.essentialkit.utilities.StringUtil;
import com.voxelbusters.essentialkit.utilities.common.annotations.SkipInCodeGenerator;
import java.io.Serializable;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class Notification implements Parcelable, Serializable {
    public final class a implements Parcelable.Creator {
        public a() {
            super();
        }

        @Override  // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel0) {
            return new Notification(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public final Object[] newArray(int v) {
            return new Notification[v];
        }
    }

    @SkipInCodeGenerator
    public static final Parcelable.Creator CREATOR = null;
    public static final int DEFAULT_PERSISTENCE_ID = 0x6F;
    public static final String PAYLOAD = "notification-payload";
    public static final String PROJECT_ASSETS_EXPECTED_FOLDER = "Assets/StreamingAssets";
    private final String TAG;
    public int badge;
    public String bigPicture;
    public String channelId;
    public String contentText;
    public String contentTitle;
    public String id;
    public boolean isLaunchNotification;
    public boolean isRemoteNotification;
    public String largeIcon;
    public int persistenceId;
    public NotificationImportance priority;
    public boolean process;
    public String soundFileName;
    public String tag;
    public String tickerText;
    public NotificationTrigger trigger;
    public JSONObject userInfo;

    static {
        Notification.CREATOR = new a();
    }

    @SkipInCodeGenerator
    public Notification(Parcel parcel0) {
        this.TAG = "[Native Plugins : Notification]";
        this.priority = NotificationImportance.Max;
        boolean z = false;
        this.isLaunchNotification = false;
        this.isRemoteNotification = false;
        this.process = true;
        this.id = parcel0.readString();
        this.contentTitle = parcel0.readString();
        this.tickerText = parcel0.readString();
        this.contentText = parcel0.readString();
        this.badge = parcel0.readInt();
        this.soundFileName = parcel0.readString();
        this.bigPicture = parcel0.readString();
        this.tag = parcel0.readString();
        this.largeIcon = parcel0.readString();
        this.channelId = parcel0.readString();
        NotificationImportance[] arr_notificationImportance = NotificationImportance.values();
        this.priority = arr_notificationImportance[parcel0.readInt()];
        this.isLaunchNotification = parcel0.readByte() != 0;
        if(parcel0.readByte() != 0) {
            z = true;
        }
        this.isRemoteNotification = z;
        this.persistenceId = parcel0.readInt();
        NotificationTrigger notificationTrigger0 = null;
        try {
            this.userInfo = parcel0.readByte() == 0 ? null : new JSONObject(parcel0.readString());
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        if(parcel0.readByte() != 0) {
            notificationTrigger0 = (NotificationTrigger)parcel0.readValue(NotificationTrigger.class.getClassLoader());
        }
        this.trigger = notificationTrigger0;
    }

    public Notification(String s) {
        this.TAG = "[Native Plugins : Notification]";
        this.priority = NotificationImportance.Max;
        this.isLaunchNotification = false;
        this.isRemoteNotification = false;
        this.process = true;
        this.id = s;
        this.persistenceId = new Random().nextInt();
    }

    @Override  // android.os.Parcelable
    @SkipInCodeGenerator
    public int describeContents() {
        return 0;
    }

    public static Notification fromJson(Context context0, JSONObject jSONObject0) {
        TimeIntervalNotificationTrigger timeIntervalNotificationTrigger0;
        Logger.debug(("From Json : " + jSONObject0.toString()));
        String s = jSONObject0.optString(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_NOTIFICATION_IDENTIFIER_KEY"), "");
        if(StringUtil.isNullOrEmpty(s)) {
            s = "1764702342709";
        }
        Notification notification0 = new Notification(s);
        notification0.contentTitle = jSONObject0.optString(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_CONTENT_TITLE_KEY"), "");
        notification0.contentText = jSONObject0.optString(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_CONTENT_TEXT_KEY"), "");
        notification0.tag = jSONObject0.optString(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_TAG_KEY"), "");
        notification0.tickerText = jSONObject0.optString(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_TICKER_TEXT_KEY"), "");
        notification0.badge = jSONObject0.optInt(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_BADGE_KEY"), 0);
        notification0.soundFileName = jSONObject0.optString(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_SOUND_FILE_NAME_KEY"), "");
        notification0.bigPicture = jSONObject0.optString(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_BIG_PICTURE_KEY"), "");
        notification0.largeIcon = jSONObject0.optString(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_LARGE_ICON_KEY"), "");
        notification0.channelId = jSONObject0.optString(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_CHANNEL_ID_KEY"), "");
        NotificationImportance[] arr_notificationImportance = NotificationImportance.values();
        notification0.priority = arr_notificationImportance[jSONObject0.optInt(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_PRIORITY_KEY"), NotificationImportance.Max.ordinal())];
        notification0.persistenceId = jSONObject0.optInt(ResourcesUtil.getStringOpt(context0, "NOTIFICATION_SERVICES_PERSISTENCE_ID_KEY"), ((int)System.currentTimeMillis()));
        String s1 = jSONObject0.optString("client_service_provider", null);
        if(s1 == null || s1.equals("voxelbusters")) {
            notification0.process = true;
        }
        else {
            Logger.warning("Not processing this notification as client service provider is not mentioned as voxelbusters");
            notification0.process = false;
        }
        String s2 = jSONObject0.optString(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_USER_INFO_KEY"));
        if(!StringUtil.isNullOrEmpty(s2)) {
            try {
                notification0.userInfo = new JSONObject(s2);
            }
            catch(JSONException jSONException0) {
                Logger.error("User info needs to be of dictionary type");
                jSONException0.printStackTrace();
            }
        }
        JSONObject jSONObject1 = jSONObject0.optJSONObject("trigger");
        if(jSONObject1 != null && jSONObject1.optString("type", "TIME_INTERVAL").equals("TIME_INTERVAL")) {
            timeIntervalNotificationTrigger0 = TimeIntervalNotificationTrigger.fromJson(jSONObject1);
        }
        else if(jSONObject1 != null && jSONObject1.optString("type", "TIME_INTERVAL").equals("CALENDAR")) {
            timeIntervalNotificationTrigger0 = CalendarNotificationTrigger.fromJson(jSONObject1);
        }
        else {
            return notification0;
        }
        notification0.trigger = timeIntervalNotificationTrigger0;
        return notification0;
    }

    public String getPersistenceId() {
        return String.valueOf(this.persistenceId);
    }

    public boolean hasCalendarTimeTrigger() {
        return this.trigger != null && this.trigger instanceof CalendarNotificationTrigger;
    }

    public boolean hasDateTimeTrigger() {
        return this.trigger != null && this.trigger instanceof TimeIntervalNotificationTrigger;
    }

    public boolean hasLocationTrigger() {
        return this.trigger != null && this.trigger instanceof LocationNotificationTrigger;
    }

    public static JSONObject toJson(Context context0, Notification notification0) {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_NOTIFICATION_IDENTIFIER_KEY"), notification0.id);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_CONTENT_TITLE_KEY"), notification0.contentTitle);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_CONTENT_TEXT_KEY"), notification0.contentText);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_TICKER_TEXT_KEY"), notification0.tickerText);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_TAG_KEY"), notification0.tag);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_BADGE_KEY"), notification0.badge);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_SOUND_FILE_NAME_KEY"), notification0.soundFileName);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_BIG_PICTURE_KEY"), notification0.bigPicture);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_LARGE_ICON_KEY"), notification0.largeIcon);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_CHANNEL_ID_KEY"), notification0.channelId);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_PRIORITY_KEY"), notification0.priority.ordinal());
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_PERSISTENCE_ID_KEY"), notification0.persistenceId);
            jSONObject0.put(ResourcesUtil.getString(context0, "NOTIFICATION_SERVICES_USER_INFO_KEY"), notification0.userInfo);
            NotificationTrigger notificationTrigger0 = notification0.trigger;
            if(notificationTrigger0 != null) {
                jSONObject0.put("trigger", notificationTrigger0.toJson());
                return jSONObject0;
            }
        }
        catch(JSONException | Exception jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }

    @Override
    @SkipInCodeGenerator
    public String toString() {
        return "id : " + this.id + "\n" + ("contentTitle : " + this.contentTitle) + "\n" + ("contentText : " + this.contentText) + "\n" + ("tickerText : " + this.tickerText) + "\n" + ("badge : " + this.badge) + "\n" + ("soundFileName : " + this.soundFileName) + "\n" + ("bigPicture : " + this.bigPicture) + "\n" + ("tag : " + this.tag) + "\n" + ("largeIcon : " + this.largeIcon) + "\n" + ("priority : " + this.priority.name()) + "\n" + ("isLaunchNotification : " + this.isLaunchNotification) + "\n" + ("isRemoteNotification : " + this.isRemoteNotification) + "\n" + ("persistenceId : " + this.persistenceId) + "\n" + ("trigger : " + this.trigger) + "\n" + ("userInfo : " + this.userInfo) + "\n";
    }

    @Override  // android.os.Parcelable
    @SkipInCodeGenerator
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.id);
        parcel0.writeString(this.contentTitle);
        parcel0.writeString(this.tickerText);
        parcel0.writeString(this.contentText);
        parcel0.writeInt(this.badge);
        parcel0.writeString(this.soundFileName);
        parcel0.writeString(this.bigPicture);
        parcel0.writeString(this.tag);
        parcel0.writeString(this.largeIcon);
        parcel0.writeString(this.channelId);
        parcel0.writeInt(this.priority.ordinal());
        parcel0.writeByte(((byte)this.isLaunchNotification));
        parcel0.writeByte(((byte)this.isRemoteNotification));
        parcel0.writeInt(this.persistenceId);
        if(this.userInfo == null) {
            parcel0.writeByte(0);
        }
        else {
            parcel0.writeByte(1);
            parcel0.writeString(this.userInfo.toString());
        }
        if(this.trigger == null) {
            parcel0.writeByte(0);
            return;
        }
        parcel0.writeByte(1);
        parcel0.writeValue(this.trigger);
    }
}

