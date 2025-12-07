package com.gameanalytics.sdk.utilities;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.concurrent.TimeUnit;

public class Timer implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private long highResTime;
    private long timeInMicros;

    static {
        Timer.CREATOR = new Parcelable.Creator() {
            public Timer createFromParcel(Parcel in) {
                return new Timer(in, null);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel in) {
                return this.createFromParcel(in);
            }

            public Timer[] newArray(int size) {
                return new Timer[size];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int size) {
                return this.newArray(size);
            }
        };
    }

    public Timer() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    public Timer(long time, long highResTime) {
        this.timeInMicros = time;
        this.highResTime = highResTime;
    }

    private Timer(Parcel in) {
        this.timeInMicros = in.readLong();
        this.highResTime = in.readLong();
    }

    Timer(Parcel parcel0, com.gameanalytics.sdk.utilities.Timer.1 timer$10) {
        this(parcel0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCurrentTimestampMicros() {
        return this.timeInMicros + this.getDurationMicros();
    }

    public long getDurationMicros() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.highResTime);
    }

    public long getDurationMicros(Timer end) {
        return TimeUnit.NANOSECONDS.toMicros(end.highResTime - this.highResTime);
    }

    public long getHighResTime() {
        return TimeUnit.NANOSECONDS.toMicros(this.highResTime);
    }

    public long getMicros() {
        return this.timeInMicros;
    }

    public void reset() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(this.timeInMicros);
        out.writeLong(this.highResTime);
    }
}

