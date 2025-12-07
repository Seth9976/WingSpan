package com.voxelbusters.essentialkit.notificationservices.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.voxelbusters.essentialkit.utilities.common.annotations.MustIncludeInCodeGenerator;
import com.voxelbusters.essentialkit.utilities.common.annotations.SkipInCodeGenerator;
import java.io.Serializable;
import java.util.Date;
import org.json.JSONObject;

@MustIncludeInCodeGenerator
public class TimeIntervalNotificationTrigger extends NotificationTrigger implements Parcelable, Serializable {
    public final class a implements Parcelable.Creator {
        public a() {
            super();
        }

        @Override  // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel0) {
            return new TimeIntervalNotificationTrigger(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public final Object[] newArray(int v) {
            return new TimeIntervalNotificationTrigger[v];
        }
    }

    @SkipInCodeGenerator
    public static final Parcelable.Creator CREATOR = null;
    public static final String Type = "TIME_INTERVAL";
    private long startTimestamp;
    public long timeInterval;

    static {
        TimeIntervalNotificationTrigger.CREATOR = new a();
    }

    public TimeIntervalNotificationTrigger(long v, boolean z) {
        this.repeat = z;
        this.timeInterval = v;
        this.startTimestamp = System.currentTimeMillis();
    }

    public TimeIntervalNotificationTrigger(Parcel parcel0) {
        this.startTimestamp = parcel0.readLong();
        this.timeInterval = parcel0.readLong();
        this.repeat = parcel0.readInt() == 1;
    }

    @Override  // android.os.Parcelable
    @SkipInCodeGenerator
    public int describeContents() {
        return 0;
    }

    public static TimeIntervalNotificationTrigger fromJson(JSONObject jSONObject0) {
        boolean z = jSONObject0.optBoolean("repeat", false);
        long v = jSONObject0.optLong("timeInterval", 0L);
        long v1 = jSONObject0.optLong("startTimestamp", 0L);
        TimeIntervalNotificationTrigger timeIntervalNotificationTrigger0 = new TimeIntervalNotificationTrigger(v, z);
        timeIntervalNotificationTrigger0.startTimestamp = v1;
        return timeIntervalNotificationTrigger0;
    }

    public Date getNextTriggerDate() {
        return new Date(this.startTimestamp + this.timeInterval);
    }

    @Override  // com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationTrigger
    public JSONObject toJson() {
        JSONObject jSONObject0 = super.toJson();
        jSONObject0.put("type", "TIME_INTERVAL");
        jSONObject0.put("timeInterval", this.timeInterval);
        jSONObject0.put("startTimestamp", this.startTimestamp);
        jSONObject0.put("repeat", this.repeat);
        return jSONObject0;
    }

    public void updateStartTimestamp(long v) {
        this.startTimestamp = v;
    }

    @Override  // android.os.Parcelable
    @SkipInCodeGenerator
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.startTimestamp);
        parcel0.writeLong(this.timeInterval);
        parcel0.writeInt(((int)this.repeat));
    }
}

