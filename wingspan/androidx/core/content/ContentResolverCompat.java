package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

public final class ContentResolverCompat {
    static class Api16Impl {
        static Cursor query(ContentResolver contentResolver0, Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1, CancellationSignal cancellationSignal0) {
            return contentResolver0.query(uri0, arr_s, s, arr_s1, s1, cancellationSignal0);
        }
    }

    public static Cursor query(ContentResolver contentResolver0, Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1, androidx.core.os.CancellationSignal cancellationSignal0) {
        try {
            return Api16Impl.query(contentResolver0, uri0, arr_s, s, arr_s1, s1, ((CancellationSignal)(cancellationSignal0 == null ? null : cancellationSignal0.getCancellationSignalObject())));
        label_2:
            if(!(exception0 instanceof OperationCanceledException)) {
                throw exception0;
            }
            throw new androidx.core.os.OperationCanceledException();
        }
        catch(Exception exception0) {
            goto label_2;
        }
        throw new androidx.core.os.OperationCanceledException();
    }
}

