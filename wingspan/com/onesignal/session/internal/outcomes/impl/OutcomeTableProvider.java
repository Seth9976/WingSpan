package com.onesignal.session.internal.outcomes.impl;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.onesignal.session.internal.influence.InfluenceChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\b\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\t\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeTableProvider;", "", "()V", "upgradeCacheOutcomeTableRevision1To2", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "upgradeOutcomeTableRevision1To2", "upgradeOutcomeTableRevision2To3", "upgradeOutcomeTableRevision3To4", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeTableProvider {
    public final void upgradeCacheOutcomeTableRevision1To2(SQLiteDatabase sQLiteDatabase0) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase0, "db");
        try {
            sQLiteDatabase0.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase0.execSQL("CREATE TABLE cached_unique_outcome (_id INTEGER PRIMARY KEY,channel_influence_id TEXT,channel_type TEXT,name TEXT);");
            sQLiteDatabase0.execSQL("INSERT INTO cached_unique_outcome(_id,name,channel_influence_id) SELECT _id,name,notification_id FROM cached_unique_outcome_notification;");
            sQLiteDatabase0.execSQL("UPDATE cached_unique_outcome SET channel_type = \'" + InfluenceChannel.NOTIFICATION + "\';");
            sQLiteDatabase0.execSQL("DROP TABLE cached_unique_outcome_notification;");
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException0.printStackTrace();
        }
        finally {
            sQLiteDatabase0.execSQL("COMMIT;");
        }
    }

    public final void upgradeOutcomeTableRevision1To2(SQLiteDatabase sQLiteDatabase0) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase0, "db");
        try {
            sQLiteDatabase0.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase0.execSQL("CREATE TEMPORARY TABLE outcome_backup(_id,session,notification_ids,name,timestamp);");
            sQLiteDatabase0.execSQL("INSERT INTO outcome_backup SELECT _id,session,notification_ids,name,timestamp FROM outcome;");
            sQLiteDatabase0.execSQL("DROP TABLE outcome;");
            sQLiteDatabase0.execSQL("CREATE TABLE outcome (_id INTEGER PRIMARY KEY,session TEXT,notification_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);");
            sQLiteDatabase0.execSQL("INSERT INTO outcome (_id,session,notification_ids,name,timestamp, weight) SELECT _id,session,notification_ids,name,timestamp, 0 FROM outcome_backup;");
            sQLiteDatabase0.execSQL("DROP TABLE outcome_backup;");
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException0.printStackTrace();
        }
        finally {
            sQLiteDatabase0.execSQL("COMMIT;");
        }
    }

    public final void upgradeOutcomeTableRevision2To3(SQLiteDatabase sQLiteDatabase0) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase0, "db");
        try {
            sQLiteDatabase0.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase0.execSQL("ALTER TABLE outcome RENAME TO outcome_aux;");
            sQLiteDatabase0.execSQL("CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_influence_type TEXT,iam_influence_type TEXT,notification_ids TEXT,iam_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);");
            sQLiteDatabase0.execSQL("INSERT INTO outcome(_id,name,timestamp,notification_ids,weight,notification_influence_type) SELECT _id,name,timestamp,notification_ids,weight,session FROM outcome_aux;");
            sQLiteDatabase0.execSQL("DROP TABLE outcome_aux;");
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException0.printStackTrace();
        }
        finally {
            sQLiteDatabase0.execSQL("COMMIT;");
        }
    }

    public final void upgradeOutcomeTableRevision3To4(SQLiteDatabase sQLiteDatabase0) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase0, "db");
        try {
            sQLiteDatabase0.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase0.execSQL("ALTER TABLE outcome ADD COLUMN session_time INTEGER DEFAULT 1;");
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException0.printStackTrace();
        }
        finally {
            sQLiteDatabase0.execSQL("COMMIT;");
        }
    }
}

