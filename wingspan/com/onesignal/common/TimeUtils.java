package com.onesignal.common;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004J\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/common/TimeUtils;", "", "()V", "getTimeZoneId", "", "getTimeZoneOffset", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TimeUtils {
    public static final TimeUtils INSTANCE;

    static {
        TimeUtils.INSTANCE = new TimeUtils();
    }

    public final String getTimeZoneId() [...] // 潜在的解密器

    public final int getTimeZoneOffset() {
        TimeZone timeZone0 = Calendar.getInstance().getTimeZone();
        int v = timeZone0.getRawOffset();
        if(timeZone0.inDaylightTime(new Date())) {
            v += timeZone0.getDSTSavings();
        }
        return v / 1000;
    }
}

