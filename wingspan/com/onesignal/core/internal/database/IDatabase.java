package com.onesignal.core.internal.database;

import android.content.ContentValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ$\u0010\n\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u000B\u001A\u0004\u0018\u00010\u00052\b\u0010\f\u001A\u0004\u0018\u00010\rH&J$\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u000B\u001A\u0004\u0018\u00010\u00052\b\u0010\f\u001A\u0004\u0018\u00010\rH&J\u0089\u0001\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0010\b\u0002\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u0016H&¢\u0006\u0002\u0010\u0018J7\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&¢\u0006\u0002\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/onesignal/core/internal/database/IDatabase;", "", "delete", "", "table", "", "whereClause", "whereArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "insert", "nullColumnHack", "values", "Landroid/content/ContentValues;", "insertOrThrow", "query", "columns", "groupBy", "having", "orderBy", "limit", "action", "Lkotlin/Function1;", "Lcom/onesignal/core/internal/database/ICursor;", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "update", "", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IDatabase {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static void query$default(IDatabase iDatabase0, String s, String[] arr_s, String s1, String[] arr_s1, String s2, String s3, String s4, String s5, Function1 function10, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
            }
            iDatabase0.query(s, ((v & 2) == 0 ? arr_s : null), ((v & 4) == 0 ? s1 : null), ((v & 8) == 0 ? arr_s1 : null), ((v & 16) == 0 ? s2 : null), ((v & 0x20) == 0 ? s3 : null), ((v & 0x40) == 0 ? s4 : null), ((v & 0x80) == 0 ? s5 : null), function10);
        }
    }

    void delete(String arg1, String arg2, String[] arg3);

    void insert(String arg1, String arg2, ContentValues arg3);

    void insertOrThrow(String arg1, String arg2, ContentValues arg3);

    void query(String arg1, String[] arg2, String arg3, String[] arg4, String arg5, String arg6, String arg7, String arg8, Function1 arg9);

    int update(String arg1, ContentValues arg2, String arg3, String[] arg4);
}

