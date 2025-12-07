package androidx.core.os;

import android.os.Environment;
import java.io.File;

public final class EnvironmentCompat {
    static class Api19Impl {
        static String getStorageState(File file0) {
            return Environment.getStorageState(file0);
        }
    }

    static class Api21Impl {
        static String getExternalStorageState(File file0) {
            return Environment.getExternalStorageState(file0);
        }
    }

    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static String getStorageState(File file0) {
        return Api21Impl.getExternalStorageState(file0);
    }
}

