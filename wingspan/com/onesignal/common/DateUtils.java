package com.onesignal.common;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/onesignal/common/DateUtils;", "", "()V", "iso8601Format", "Ljava/text/SimpleDateFormat;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DateUtils {
    public static final DateUtils INSTANCE;

    static {
        DateUtils.INSTANCE = new DateUtils();
    }

    public final SimpleDateFormat iso8601Format() {
        return new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'", Locale.US);
    }
}

