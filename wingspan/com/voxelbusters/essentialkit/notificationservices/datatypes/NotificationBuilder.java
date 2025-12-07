package com.voxelbusters.essentialkit.notificationservices.datatypes;

import com.voxelbusters.essentialkit.utilities.StringUtil;
import com.voxelbusters.essentialkit.utilities.common.annotations.MustIncludeInCodeGenerator;
import org.json.JSONException;
import org.json.JSONObject;

@MustIncludeInCodeGenerator
public class NotificationBuilder {
    private Notification notification;

    public NotificationBuilder(String s) {
        this.notification = new Notification(s);
    }

    public Notification build() {
        return this.notification;
    }

    public void setBadge(int v) {
        this.notification.badge = v;
    }

    public void setBigPicture(String s) {
        this.notification.bigPicture = s;
    }

    public void setBody(String s) {
        this.setBody(s, true);
    }

    public void setBody(String s, boolean z) {
        Notification notification0 = this.notification;
        if(z) {
            s = StringUtil.fromBase64EncodedString(s);
        }
        notification0.contentText = s;
    }

    public void setLargeIcon(String s) {
        this.notification.largeIcon = s;
    }

    public void setSoundFileName(String s) {
        this.notification.soundFileName = s;
    }

    public void setTag(String s) {
        this.notification.tag = s;
    }

    public void setTitle(String s) {
        this.setTitle(s, true);
    }

    public void setTitle(String s, boolean z) {
        Notification notification0 = this.notification;
        if(z) {
            s = StringUtil.fromBase64EncodedString(s);
        }
        notification0.contentTitle = s;
    }

    public void setTrigger(CalendarNotificationTrigger calendarNotificationTrigger0) {
        this.notification.trigger = calendarNotificationTrigger0;
    }

    public void setTrigger(LocationNotificationTrigger locationNotificationTrigger0) {
        this.notification.trigger = locationNotificationTrigger0;
    }

    public void setTrigger(TimeIntervalNotificationTrigger timeIntervalNotificationTrigger0) {
        this.notification.trigger = timeIntervalNotificationTrigger0;
    }

    public void setUserInfo(String s) {
        try {
            Notification notification0 = this.notification;
            notification0.userInfo = new JSONObject(s);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }
}

