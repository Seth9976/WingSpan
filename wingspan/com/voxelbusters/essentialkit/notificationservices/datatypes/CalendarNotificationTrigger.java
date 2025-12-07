package com.voxelbusters.essentialkit.notificationservices.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Log;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.annotations.MustIncludeInCodeGenerator;
import com.voxelbusters.essentialkit.utilities.common.annotations.SkipInCodeGenerator;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

@MustIncludeInCodeGenerator
public class CalendarNotificationTrigger extends NotificationTrigger implements Parcelable, Serializable {
    public final class a implements Parcelable.Creator {
        public a() {
            super();
        }

        @Override  // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel0) {
            return new CalendarNotificationTrigger(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public final Object[] newArray(int v) {
            return new CalendarNotificationTrigger[v];
        }
    }

    public static final class b {
        public static final int[] a;

        static {
            int[] arr_v = new int[RepeatInterval.values().length];
            b.a = arr_v;
            try {
                arr_v[RepeatInterval.Secondly.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[RepeatInterval.Minutely.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[RepeatInterval.Hourly.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[RepeatInterval.Daily.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[RepeatInterval.Weekly.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[RepeatInterval.Monthly.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                b.a[RepeatInterval.Yearly.ordinal()] = 7;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

    @SkipInCodeGenerator
    public static final Parcelable.Creator CREATOR = null;
    public static String Type = "CALENDAR";
    private static final int UNDEFINED = -1;
    private CalendarType calendarType;
    private int day;
    private int hour;
    private int minute;
    private int month;
    private int nanosecond;
    private int second;
    private int weekOfMonth;
    private int weekOfYear;
    private int weekday;
    private int year;

    static {
        CalendarNotificationTrigger.CREATOR = new a();
    }

    public CalendarNotificationTrigger(int v, boolean z) {
        this.year = -1;
        this.month = -1;
        this.day = -1;
        this.hour = -1;
        this.minute = -1;
        this.second = -1;
        this.nanosecond = -1;
        this.weekday = -1;
        this.weekOfMonth = -1;
        this.weekOfYear = -1;
        this.calendarType = CalendarType.values()[v];
        this.repeat = z;
    }

    public CalendarNotificationTrigger(Parcel parcel0) {
        this.calendarType = CalendarType.Default;
        this.year = -1;
        this.month = -1;
        this.day = -1;
        this.hour = -1;
        this.minute = -1;
        this.second = -1;
        this.nanosecond = -1;
        this.weekday = -1;
        this.weekOfMonth = -1;
        this.weekOfYear = -1;
        CalendarType[] arr_calendarType = CalendarType.values();
        this.calendarType = arr_calendarType[parcel0.readInt()];
        this.year = parcel0.readInt();
        this.month = parcel0.readInt();
        this.day = parcel0.readInt();
        this.hour = parcel0.readInt();
        this.minute = parcel0.readInt();
        this.second = parcel0.readInt();
        this.nanosecond = parcel0.readInt();
        this.weekday = parcel0.readInt();
        this.weekOfMonth = parcel0.readInt();
        this.weekOfYear = parcel0.readInt();
        this.repeat = parcel0.readInt() == 1;
    }

    public int GetCalendarType() {
        return this.calendarType.ordinal();
    }

    private long GetNextTriggerTimestamp(long v) {
        RepeatInterval repeatInterval0 = this.nanosecond == -1 ? RepeatInterval.None : RepeatInterval.Secondly;
        if(this.second != -1) {
            repeatInterval0 = RepeatInterval.Minutely;
        }
        if(this.minute != -1) {
            repeatInterval0 = RepeatInterval.Hourly;
        }
        if(this.hour != -1) {
            repeatInterval0 = RepeatInterval.Daily;
        }
        if(this.weekday != -1) {
            repeatInterval0 = RepeatInterval.Weekly;
        }
        if(this.day != -1 || this.weekOfMonth != -1) {
            repeatInterval0 = RepeatInterval.Monthly;
        }
        if(this.month != -1 || this.weekOfYear != -1) {
            repeatInterval0 = RepeatInterval.Yearly;
        }
        if(this.year != -1) {
            repeatInterval0 = RepeatInterval.Yearly;
            this.year = -1;
        }
        Calendar calendar0 = Calendar.getInstance();
        calendar0.setTimeInMillis(v);
        switch(b.a[repeatInterval0.ordinal()]) {
            case 1: {
                calendar0.add(13, 1);
                break;
            }
            case 2: {
                calendar0.add(12, 1);
                break;
            }
            case 3: {
                calendar0.add(10, 1);
                break;
            }
            case 4: {
                calendar0.add(6, 1);
                break;
            }
            case 5: {
                calendar0.add(3, 1);
                break;
            }
            case 6: {
                calendar0.add(2, 1);
                break;
            }
            case 7: {
                calendar0.add(1, 1);
                break;
            }
            default: {
                Log.w("CalendarNotification", "No repeat interval setup found. So not repeating!");
            }
        }
        long v1 = calendar0.getTimeInMillis();
        Logger.debug(("old timestamp : " + v + "new timestamp : " + v1));
        return v1;
    }

    @Override  // android.os.Parcelable
    @SkipInCodeGenerator
    public int describeContents() {
        return 0;
    }

    public static CalendarNotificationTrigger fromJson(JSONObject jSONObject0) {
        boolean z = jSONObject0.optBoolean("repeat", false);
        CalendarNotificationTrigger calendarNotificationTrigger0 = new CalendarNotificationTrigger(jSONObject0.optInt("calendarType", 0), z);
        calendarNotificationTrigger0.year = jSONObject0.optInt("year", -1);
        calendarNotificationTrigger0.month = jSONObject0.optInt("month", -1);
        calendarNotificationTrigger0.day = jSONObject0.optInt("day", -1);
        calendarNotificationTrigger0.hour = jSONObject0.optInt("hour", -1);
        calendarNotificationTrigger0.minute = jSONObject0.optInt("minute", -1);
        calendarNotificationTrigger0.second = jSONObject0.optInt("second", -1);
        calendarNotificationTrigger0.nanosecond = jSONObject0.optInt("nanosecond", -1);
        calendarNotificationTrigger0.weekday = jSONObject0.optInt("weekday", -1);
        calendarNotificationTrigger0.weekOfMonth = jSONObject0.optInt("weekOfMonth", -1);
        calendarNotificationTrigger0.weekOfYear = jSONObject0.optInt("weekOfYear", -1);
        return calendarNotificationTrigger0;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getMonth() {
        return this.month;
    }

    public int getNanosecond() {
        return this.nanosecond;
    }

    public Date getNextTriggerDate() {
        Calendar calendar0 = CalendarFactory.createCalendar(this.calendarType);
        int v = this.year;
        if(v != -1) {
            calendar0.set(1, v);
        }
        int v1 = this.month;
        if(v1 != -1) {
            calendar0.set(2, v1);
        }
        int v2 = this.day;
        if(v2 != -1) {
            calendar0.set(5, v2);
        }
        int v3 = this.hour;
        if(v3 != -1) {
            calendar0.set(11, v3);
        }
        int v4 = this.minute;
        if(v4 != -1) {
            calendar0.set(12, v4);
        }
        int v5 = this.second;
        if(v5 != -1) {
            calendar0.set(13, v5);
        }
        int v6 = this.nanosecond;
        if(v6 != -1) {
            calendar0.set(14, v6 / 1000000);
        }
        int v7 = this.weekday;
        if(v7 != -1) {
            calendar0.set(7, v7);
        }
        int v8 = this.weekOfMonth;
        if(v8 != -1) {
            calendar0.set(4, v8);
        }
        int v9 = this.weekOfYear;
        if(v9 != -1) {
            calendar0.set(3, v9);
        }
        long v10 = calendar0.getTimeInMillis();
        if(v10 - System.currentTimeMillis() < 0L && this.repeat) {
            return new Date(this.GetNextTriggerTimestamp(v10));
        }
        Log.w("CalendarNotification", "Issued to trigger a notification in past. This may not get triggered!");
        return new Date(v10);
    }

    public int getSecond() {
        return this.second;
    }

    public int getWeekOfMonth() {
        return this.weekOfMonth;
    }

    public int getWeekOfYear() {
        return this.weekOfYear;
    }

    public int getWeekday() {
        return this.weekday;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int v) {
        this.day = v;
    }

    public void setHour(int v) {
        this.hour = v;
    }

    public void setMinute(int v) {
        this.minute = v;
    }

    public void setMonth(int v) {
        this.month = v;
    }

    public void setNanosecond(int v) {
        this.nanosecond = v;
    }

    public void setSecond(int v) {
        this.second = v;
    }

    public void setWeekOfMonth(int v) {
        this.weekOfMonth = v;
    }

    public void setWeekOfYear(int v) {
        this.weekOfYear = v;
    }

    public void setWeekday(int v) {
        this.weekday = v;
    }

    public void setYear(int v) {
        this.year = v;
    }

    @Override  // com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationTrigger
    public JSONObject toJson() {
        JSONObject jSONObject0 = super.toJson();
        jSONObject0.put("type", "CALENDAR");
        jSONObject0.put("calendarType", this.calendarType.ordinal());
        jSONObject0.put("year", this.year);
        jSONObject0.put("month", this.month);
        jSONObject0.put("day", this.day);
        jSONObject0.put("hour", this.hour);
        jSONObject0.put("minute", this.minute);
        jSONObject0.put("second", this.second);
        jSONObject0.put("nanosecond", this.nanosecond);
        jSONObject0.put("weekday", this.weekday);
        jSONObject0.put("weekOfMonth", this.weekOfMonth);
        jSONObject0.put("weekOfYear", this.weekOfYear);
        jSONObject0.put("repeat", this.repeat);
        return jSONObject0;
    }

    @Override  // android.os.Parcelable
    @SkipInCodeGenerator
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.calendarType.ordinal());
        parcel0.writeInt(this.year);
        parcel0.writeInt(this.month);
        parcel0.writeInt(this.day);
        parcel0.writeInt(this.hour);
        parcel0.writeInt(this.minute);
        parcel0.writeInt(this.second);
        parcel0.writeInt(this.nanosecond);
        parcel0.writeInt(this.weekday);
        parcel0.writeInt(this.weekOfMonth);
        parcel0.writeInt(this.weekOfYear);
        parcel0.writeInt(((int)this.repeat));
    }
}

