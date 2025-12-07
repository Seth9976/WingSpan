package com.onesignal.core.internal.database;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&J\u0010\u0010\n\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\tH&J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\tH&J\u0017\u0010\r\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0002\u0010\u000EJ\u0017\u0010\u000F\u001A\u0004\u0018\u00010\u00032\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001A\u0004\u0018\u00010\f2\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001A\u0004\u0018\u00010\t2\u0006\u0010\b\u001A\u00020\tH&J\u0010\u0010\u0014\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH&J\b\u0010\u0015\u001A\u00020\u0016H&J\b\u0010\u0017\u001A\u00020\u0016H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/onesignal/core/internal/database/ICursor;", "", "count", "", "getCount", "()I", "getFloat", "", "column", "", "getInt", "getLong", "", "getOptFloat", "(Ljava/lang/String;)Ljava/lang/Float;", "getOptInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "getOptLong", "(Ljava/lang/String;)Ljava/lang/Long;", "getOptString", "getString", "moveToFirst", "", "moveToNext", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ICursor {
    int getCount();

    float getFloat(String arg1);

    int getInt(String arg1);

    long getLong(String arg1);

    Float getOptFloat(String arg1);

    Integer getOptInt(String arg1);

    Long getOptLong(String arg1);

    String getOptString(String arg1);

    String getString(String arg1);

    boolean moveToFirst();

    boolean moveToNext();
}

