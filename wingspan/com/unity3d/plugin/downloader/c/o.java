package com.unity3d.plugin.downloader.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import jeb.synthetic.TWR;

public class o {
    public static final String a = "com.unity3d.plugin.downloader.c.o";
    final SQLiteOpenHelper b;
    SQLiteStatement c;
    SQLiteStatement d;
    long e;
    int f;
    int g;
    int h;
    private static o i;
    private static final String[] j;

    static {
        o.j = new String[]{"FN", "URI", "ETAG", "TOTALBYTES", "CURRENTBYTES", "LASTMOD", "STATUS", "CONTROL", "FAILCOUNT", "RETRYAFTER", "REDIRECTCOUNT", "FILEIDX"};
    }

    private o(Context context0) {
        this.e = -1L;
        this.f = -1;
        this.g = -1;
        q q0 = new q(context0);
        this.b = q0;
        Cursor cursor0 = q0.getReadableDatabase().rawQuery("SELECT APKVERSION,_id,DOWNLOADSTATUS,DOWNLOADFLAGS FROM MetadataColumns LIMIT 1", null);
        if(cursor0 != null && cursor0.moveToFirst()) {
            this.f = cursor0.getInt(0);
            this.e = cursor0.getLong(1);
            this.g = cursor0.getInt(2);
            this.h = cursor0.getInt(3);
            cursor0.close();
        }
        o.i = this;
    }

    private long a(int v) {
        if(this.c == null) {
            this.c = this.b.getReadableDatabase().compileStatement("SELECT _id FROM DownloadColumns WHERE FILEIDX = ?");
        }
        SQLiteStatement sQLiteStatement0 = this.c;
        sQLiteStatement0.clearBindings();
        sQLiteStatement0.bindLong(1, ((long)v));
        try {
            return sQLiteStatement0.simpleQueryForLong();
        }
        catch(SQLiteDoneException unused_ex) {
            return -1L;
        }
    }

    private c a(Cursor cursor0) {
        int v = cursor0.getInt(11);
        String s = cursor0.getString(0);
        this.getClass().getPackage().getName();
        c c0 = new c(v, s);
        o.a(c0, cursor0);
        return c0;
    }

    public static o a(Context context0) {
        synchronized(o.class) {
            o o0 = o.i;
            return o0 == null ? new o(context0) : o0;
        }
    }

    private static void a(c c0, Cursor cursor0) {
        c0.a = cursor0.getString(1);
        c0.d = cursor0.getString(2);
        c0.e = cursor0.getLong(3);
        c0.f = cursor0.getLong(4);
        c0.g = cursor0.getLong(5);
        c0.h = cursor0.getInt(6);
        c0.i = cursor0.getInt(7);
        c0.j = cursor0.getInt(8);
        c0.k = cursor0.getInt(9);
        c0.l = cursor0.getInt(10);
    }

    private boolean a(c c0, ContentValues contentValues0) {
        long v = c0 == null ? -1L : this.a(c0.b);
        try {
            SQLiteDatabase sQLiteDatabase0 = this.b.getWritableDatabase();
            if(Long.compare(v, -1L) != 0) {
                sQLiteDatabase0.update("DownloadColumns", contentValues0, "DownloadColumns._id = " + v, null);
                return false;
            }
            if(-1L != sQLiteDatabase0.insert("DownloadColumns", "URI", contentValues0)) {
                return true;
            }
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException0.printStackTrace();
        }
        return false;
    }

    protected final c a(String s) {
        c c0;
        Cursor cursor0 = this.b.getReadableDatabase().query("DownloadColumns", o.j, "FN = ?", new String[]{s}, null, null, null);
        if(cursor0 != null) {
            try {
                if(cursor0.moveToFirst()) {
                    c0 = this.a(cursor0);
                    goto label_8;
                }
                goto label_10;
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
        label_8:
            cursor0.close();
            return c0;
        }
    label_10:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    public final boolean a(int v, int v1) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("APKVERSION", v);
        contentValues0.put("DOWNLOADSTATUS", v1);
        if(this.a(contentValues0)) {
            this.f = v;
            this.g = v1;
            return true;
        }
        return false;
    }

    public final boolean a(ContentValues contentValues0) {
        SQLiteDatabase sQLiteDatabase0 = this.b.getWritableDatabase();
        if(Long.compare(-1L, this.e) == 0) {
            long v = sQLiteDatabase0.insert("MetadataColumns", "APKVERSION", contentValues0);
            if(-1L == v) {
                return false;
            }
            this.e = v;
            return true;
        }
        return sQLiteDatabase0.update("MetadataColumns", contentValues0, "_id = " + this.e, null) != 0;
    }

    public final boolean a(c c0) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("FILEIDX", c0.b);
        contentValues0.put("FN", c0.c);
        contentValues0.put("URI", c0.a);
        contentValues0.put("ETAG", c0.d);
        contentValues0.put("TOTALBYTES", c0.e);
        contentValues0.put("CURRENTBYTES", c0.f);
        contentValues0.put("LASTMOD", c0.g);
        contentValues0.put("STATUS", c0.h);
        contentValues0.put("CONTROL", c0.i);
        contentValues0.put("FAILCOUNT", c0.j);
        contentValues0.put("RETRYAFTER", c0.k);
        contentValues0.put("REDIRECTCOUNT", c0.l);
        return this.a(c0, contentValues0);
    }

    public final c[] a() {
        c[] arr_c;
        Cursor cursor0 = this.b.getReadableDatabase().query("DownloadColumns", o.j, null, null, null, null, null);
        if(cursor0 != null) {
            try {
                if(cursor0.moveToFirst()) {
                    arr_c = new c[cursor0.getCount()];
                    int v = 0;
                    while(true) {
                        arr_c[v] = this.a(cursor0);
                        if(!cursor0.moveToNext()) {
                            goto label_12;
                        }
                        ++v;
                    }
                }
                goto label_14;
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
        label_12:
            cursor0.close();
            return arr_c;
        }
    label_14:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    public final boolean b(c c0) {
        SQLiteDatabase sQLiteDatabase0 = this.b.getReadableDatabase();
        Cursor cursor0 = null;
        try {
            cursor0 = sQLiteDatabase0.query("DownloadColumns", o.j, "FN= ?", new String[]{c0.c}, null, null, null);
            if(cursor0 != null && cursor0.moveToFirst()) {
                o.a(c0, cursor0);
                goto label_9;
            }
            goto label_11;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    label_9:
        cursor0.close();
        return true;
    label_11:
        if(cursor0 != null) {
            cursor0.close();
        }
        return false;
    }
}

