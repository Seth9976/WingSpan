package com.voxelbusters.essentialkit.utilities;

import android.content.Context;
import android.net.Uri;

public class FileAttachment {
    public String mimeType;
    public Uri uri;

    private FileAttachment(Uri uri0, String s) {
        this.uri = uri0;
        this.mimeType = s;
    }

    public static FileAttachment create(Context context0, byte[] arr_b, String s, String s1) {
        Logger.error(("fileName : " + s1));
        return arr_b == null ? null : new FileAttachment(FileUtil.createLocalCacheFileUri(context0, arr_b, arr_b.length, "sharing", s1), s);
    }

    public static FileAttachment create(Uri uri0, String s) {
        return new FileAttachment(uri0, s);
    }
}

