package androidx.work.impl;

import androidx.room.RoomDatabase.Callback;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016R\u0011\u0010\u0003\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u000F"}, d2 = {"Landroidx/work/impl/CleanupCallback;", "Landroidx/room/RoomDatabase$Callback;", "()V", "pruneDate", "", "getPruneDate", "()J", "pruneSQL", "", "getPruneSQL", "()Ljava/lang/String;", "onOpen", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class CleanupCallback extends Callback {
    public static final CleanupCallback INSTANCE;

    static {
        CleanupCallback.INSTANCE = new CleanupCallback();
    }

    // 去混淆评级： 低(20)
    public final long getPruneDate() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    private final String getPruneSQL() [...] // 潜在的解密器

    @Override  // androidx.room.RoomDatabase$Callback
    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase0) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase0, "db");
        super.onOpen(supportSQLiteDatabase0);
        supportSQLiteDatabase0.beginTransaction();
        try {
            supportSQLiteDatabase0.execSQL("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < 1764615708855 AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            supportSQLiteDatabase0.setTransactionSuccessful();
        }
        finally {
            supportSQLiteDatabase0.endTransaction();
        }
    }
}

