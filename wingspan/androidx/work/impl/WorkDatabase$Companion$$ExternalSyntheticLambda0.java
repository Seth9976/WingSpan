package androidx.work.impl;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public final class WorkDatabase.Companion..ExternalSyntheticLambda0 implements Factory {
    public final Context f$0;

    public WorkDatabase.Companion..ExternalSyntheticLambda0(Context context0) {
        this.f$0 = context0;
    }

    @Override  // androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
    public final SupportSQLiteOpenHelper create(Configuration supportSQLiteOpenHelper$Configuration0) {
        return Companion.create$lambda$0(this.f$0, supportSQLiteOpenHelper$Configuration0);
    }
}

