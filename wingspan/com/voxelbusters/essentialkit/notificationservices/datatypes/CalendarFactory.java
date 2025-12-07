package com.voxelbusters.essentialkit.notificationservices.datatypes;

import android.util.Log;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class CalendarFactory {
    private static final Map TIME_ZONE_MAP;

    static {
        HashMap hashMap0 = new HashMap();
        CalendarFactory.TIME_ZONE_MAP = hashMap0;
        hashMap0.put(CalendarType.Buddhist, "Asia/Bangkok");
        hashMap0.put(CalendarType.Chinese, "Asia/Shanghai");
        hashMap0.put(CalendarType.Coptic, "Africa/Cairo");
        hashMap0.put(CalendarType.EthiopicAmeteAlem, "Africa/Addis_Ababa");
        hashMap0.put(CalendarType.EthiopicAmeteMihret, "Africa/Addis_Ababa");
        hashMap0.put(CalendarType.Gregorian, "UTC");
        hashMap0.put(CalendarType.Hebrew, "Asia/Jerusalem");
        hashMap0.put(CalendarType.Indian, "Asia/Kolkata");
        hashMap0.put(CalendarType.Islamic, "Asia/Riyadh");
        hashMap0.put(CalendarType.IslamicCivil, "Asia/Riyadh");
        hashMap0.put(CalendarType.IslamicTabular, "Asia/Riyadh");
        hashMap0.put(CalendarType.IslamicUmmAlQura, "Asia/Riyadh");
        hashMap0.put(CalendarType.Iso8601, "UTC");
        hashMap0.put(CalendarType.Japanese, "Asia/Tokyo");
        hashMap0.put(CalendarType.Persian, "Asia/Tehran");
        hashMap0.put(CalendarType.RepublicOfChina, "Asia/Taipei");
    }

    public static Calendar createCalendar(CalendarType calendarType0) {
        if(calendarType0 == CalendarType.Default) {
            return Calendar.getInstance();
        }
        try {
            String s = (String)CalendarFactory.TIME_ZONE_MAP.get(calendarType0);
            if(s == null) {
                throw new IllegalArgumentException("Unsupported calendar type: " + calendarType0);
            }
            return Calendar.getInstance(TimeZone.getTimeZone(s));
        }
        catch(Exception exception0) {
            Log.e("CalendarFactory", exception0.getMessage());
            return Calendar.getInstance();
        }
    }
}

