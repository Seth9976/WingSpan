package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int v, int v1) {
        this.startVersion = v;
        this.endVersion = v1;
    }

    public abstract void migrate(SupportSQLiteDatabase arg1);
}

