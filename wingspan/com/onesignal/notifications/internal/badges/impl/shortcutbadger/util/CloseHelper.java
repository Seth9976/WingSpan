package com.onesignal.notifications.internal.badges.impl.shortcutbadger.util;

import android.database.Cursor;
import java.io.Closeable;
import java.io.IOException;

public class CloseHelper {
    public static void close(Cursor cursor0) {
        if(cursor0 != null && !cursor0.isClosed()) {
            cursor0.close();
        }
    }

    public static void closeQuietly(Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }
}

