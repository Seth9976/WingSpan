package com.unity3d.plugin.downloader.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class q extends SQLiteOpenHelper {
    private static final String[][][] a;
    private static final String[] b;

    static {
        q.a = new String[][][]{p.a, r.a};
        q.b = new String[]{"DownloadColumns", "MetadataColumns"};
    }

    q(Context context0) {
        super(context0, "DownloadsDB", null, 7);
    }

    private static void a(SQLiteDatabase sQLiteDatabase0) {
        String[] arr_s = q.b;
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            try {
                sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS " + s);
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase0) {
        for(int v = 0; v < q.a.length; ++v) {
            try {
                String[][] arr2_s = q.a[v];
                String s = q.b[v];
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append("CREATE TABLE ");
                stringBuilder0.append(s);
                stringBuilder0.append(" (");
                for(int v1 = 0; v1 < arr2_s.length; ++v1) {
                    String[] arr_s = arr2_s[v1];
                    stringBuilder0.append(' ');
                    stringBuilder0.append(arr_s[0]);
                    stringBuilder0.append(' ');
                    stringBuilder0.append(arr_s[1]);
                    stringBuilder0.append(',');
                }
                stringBuilder0.setLength(stringBuilder0.length() - 1);
                stringBuilder0.append(");");
                sQLiteDatabase0.execSQL(stringBuilder0.toString());
            }
            catch(Exception exception0) {
                while(true) {
                    exception0.printStackTrace();
                }
            }
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        Log.w("com.unity3d.plugin.downloader.c.q", "Upgrading database from version " + v + " to " + v1 + ", which will destroy all old data");
        q.a(sQLiteDatabase0);
        this.onCreate(sQLiteDatabase0);
    }
}

