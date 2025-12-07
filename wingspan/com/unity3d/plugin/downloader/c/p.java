package com.unity3d.plugin.downloader.c;

import android.provider.BaseColumns;

public final class p implements BaseColumns {
    public static final String[][] a;

    static {
        p.a = new String[][]{new String[]{"_id", "INTEGER PRIMARY KEY"}, new String[]{"FILEIDX", "INTEGER UNIQUE"}, new String[]{"URI", "TEXT"}, new String[]{"FN", "TEXT UNIQUE"}, new String[]{"ETAG", "TEXT"}, new String[]{"TOTALBYTES", "INTEGER"}, new String[]{"CURRENTBYTES", "INTEGER"}, new String[]{"LASTMOD", "INTEGER"}, new String[]{"STATUS", "INTEGER"}, new String[]{"CONTROL", "INTEGER"}, new String[]{"FAILCOUNT", "INTEGER"}, new String[]{"RETRYAFTER", "INTEGER"}, new String[]{"REDIRECTCOUNT", "INTEGER"}};
    }
}

