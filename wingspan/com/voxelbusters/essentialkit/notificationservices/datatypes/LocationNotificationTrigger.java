package com.voxelbusters.essentialkit.notificationservices.datatypes;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.voxelbusters.essentialkit.utilities.common.annotations.MustIncludeInCodeGenerator;
import com.voxelbusters.essentialkit.utilities.common.annotations.SkipInCodeGenerator;
import java.io.Serializable;
import org.json.JSONObject;

@MustIncludeInCodeGenerator
public class LocationNotificationTrigger extends NotificationTrigger implements Parcelable, Serializable {
    public final class a implements Parcelable.Creator {
        public a() {
            super();
        }

        @Override  // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel0) {
            return new LocationNotificationTrigger(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public final Object[] newArray(int v) {
            return new LocationNotificationTrigger[v];
        }
    }

    @SkipInCodeGenerator
    public static final Parcelable.Creator CREATOR = null;
    public static final String Type = "LOCATION";
    private PointF locationCoordinate;
    private boolean notifyOnEntry;
    private boolean notifyOnExit;
    private float radius;

    static {
        LocationNotificationTrigger.CREATOR = new a();
    }

    public LocationNotificationTrigger(double f, double f1, float f2, boolean z) {
        this.locationCoordinate = new PointF(((float)f), ((float)f1));
        this.radius = f2;
        this.repeat = z;
    }

    public LocationNotificationTrigger(Parcel parcel0) {
        this.locationCoordinate = (PointF)parcel0.readValue(PointF.class.getClassLoader());
        this.radius = parcel0.readFloat();
        boolean z = true;
        this.notifyOnEntry = parcel0.readByte() != 0;
        if(parcel0.readByte() == 0) {
            z = false;
        }
        this.notifyOnExit = z;
    }

    public void build() {
    }

    @Override  // android.os.Parcelable
    @SkipInCodeGenerator
    public int describeContents() {
        return 0;
    }

    public static LocationNotificationTrigger fromJson(JSONObject jSONObject0) {
        return new LocationNotificationTrigger(((double)(((float)jSONObject0.optLong("latitude", 0L)))), ((double)(((float)jSONObject0.optLong("longitude", 0L)))), ((float)jSONObject0.optLong("radius", 0L)), jSONObject0.optBoolean("repeat", false));
    }

    public PointF getLocationCoordinate() {
        return this.locationCoordinate;
    }

    public float getRadius() {
        return this.radius;
    }

    public boolean isNotifyOnEntry() {
        return this.notifyOnEntry;
    }

    public boolean isNotifyOnExit() {
        return this.notifyOnExit;
    }

    public void setNotifyOnEntry(boolean z) {
        this.notifyOnEntry = z;
    }

    public void setNotifyOnExit(boolean z) {
        this.notifyOnExit = z;
    }

    @Override  // com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationTrigger
    public JSONObject toJson() {
        JSONObject jSONObject0 = super.toJson();
        jSONObject0.put("type", "LOCATION");
        jSONObject0.put("latitude", ((double)this.locationCoordinate.x));
        jSONObject0.put("longitude", ((double)this.locationCoordinate.y));
        jSONObject0.put("radius", ((double)this.radius));
        jSONObject0.put("repeat", this.repeat);
        return jSONObject0;
    }

    @Override  // android.os.Parcelable
    @SkipInCodeGenerator
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeValue(this.locationCoordinate);
        parcel0.writeFloat(this.radius);
        parcel0.writeByte(((byte)this.notifyOnEntry));
        parcel0.writeByte(((byte)this.notifyOnExit));
    }
}

