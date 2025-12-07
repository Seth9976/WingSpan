package com.onesignal.core.internal.database.impl;

import android.database.Cursor;
import com.onesignal.core.internal.database.ICursor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\r\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0017\u0010\u0010\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u000B\u001A\u00020\fH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u000B\u001A\u00020\fH\u0016¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\u0017\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\b\u0010\u001A\u001A\u00020\u0019H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u001B"}, d2 = {"Lcom/onesignal/core/internal/database/impl/DatabaseCursor;", "Lcom/onesignal/core/internal/database/ICursor;", "_cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "count", "", "getCount", "()I", "getFloat", "", "column", "", "getInt", "getLong", "", "getOptFloat", "(Ljava/lang/String;)Ljava/lang/Float;", "getOptInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "getOptLong", "(Ljava/lang/String;)Ljava/lang/Long;", "getOptString", "getString", "moveToFirst", "", "moveToNext", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DatabaseCursor implements ICursor {
    private final Cursor _cursor;

    public DatabaseCursor(Cursor cursor0) {
        Intrinsics.checkNotNullParameter(cursor0, "_cursor");
        super();
        this._cursor = cursor0;
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public int getCount() {
        return this._cursor.getCount();
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public float getFloat(String s) {
        Intrinsics.checkNotNullParameter(s, "column");
        int v = this._cursor.getColumnIndex(s);
        return this._cursor.getFloat(v);
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public int getInt(String s) {
        Intrinsics.checkNotNullParameter(s, "column");
        int v = this._cursor.getColumnIndex(s);
        return this._cursor.getInt(v);
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public long getLong(String s) {
        Intrinsics.checkNotNullParameter(s, "column");
        int v = this._cursor.getColumnIndex(s);
        return this._cursor.getLong(v);
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public Float getOptFloat(String s) {
        Intrinsics.checkNotNullParameter(s, "column");
        int v = this._cursor.getColumnIndex(s);
        return this._cursor.isNull(v) ? null : this._cursor.getFloat(v);
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public Integer getOptInt(String s) {
        Intrinsics.checkNotNullParameter(s, "column");
        int v = this._cursor.getColumnIndex(s);
        return this._cursor.isNull(v) ? null : this._cursor.getInt(v);
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public Long getOptLong(String s) {
        Intrinsics.checkNotNullParameter(s, "column");
        int v = this._cursor.getColumnIndex(s);
        return this._cursor.isNull(v) ? null : this._cursor.getLong(v);
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public String getOptString(String s) {
        Intrinsics.checkNotNullParameter(s, "column");
        int v = this._cursor.getColumnIndex(s);
        return this._cursor.isNull(v) ? null : this._cursor.getString(v);
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public String getString(String s) {
        Intrinsics.checkNotNullParameter(s, "column");
        int v = this._cursor.getColumnIndex(s);
        String s1 = this._cursor.getString(v);
        Intrinsics.checkNotNullExpressionValue(s1, "_cursor.getString(_cursor.getColumnIndex(column))");
        return s1;
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public boolean moveToFirst() {
        return this._cursor.moveToFirst();
    }

    @Override  // com.onesignal.core.internal.database.ICursor
    public boolean moveToNext() {
        return this._cursor.moveToNext();
    }
}

