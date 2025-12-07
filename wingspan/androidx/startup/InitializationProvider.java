package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class InitializationProvider extends ContentProvider {
    @Override  // android.content.ContentProvider
    public int delete(Uri uri0, String s, String[] arr_s) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override  // android.content.ContentProvider
    public String getType(Uri uri0) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override  // android.content.ContentProvider
    public Uri insert(Uri uri0, ContentValues contentValues0) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override  // android.content.ContentProvider
    public boolean onCreate() {
        Context context0 = this.getContext();
        if(context0 == null) {
            throw new StartupException("Context cannot be null");
        }
        AppInitializer.getInstance(context0).discoverAndInitialize();
        return true;
    }

    @Override  // android.content.ContentProvider
    public Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override  // android.content.ContentProvider
    public int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        throw new IllegalStateException("Not allowed.");
    }
}

