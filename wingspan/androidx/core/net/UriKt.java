package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\r\u0010\u0003\u001A\u00020\u0002*\u00020\u0001H\u0086\b\u001A\r\u0010\u0003\u001A\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class UriKt {
    public static final File toFile(Uri uri0) {
        Intrinsics.checkParameterIsNotNull(uri0, "$this$toFile");
        if(!Intrinsics.areEqual(uri0.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks \'file\' scheme: " + uri0).toString());
        }
        String s = uri0.getPath();
        if(s == null) {
            throw new IllegalArgumentException(("Uri path is null: " + uri0).toString());
        }
        return new File(s);
    }

    public static final Uri toUri(File file0) {
        Intrinsics.checkParameterIsNotNull(file0, "$this$toUri");
        Uri uri0 = Uri.fromFile(file0);
        Intrinsics.checkExpressionValueIsNotNull(uri0, "Uri.fromFile(this)");
        return uri0;
    }

    public static final Uri toUri(String s) {
        Intrinsics.checkParameterIsNotNull(s, "$this$toUri");
        Uri uri0 = Uri.parse(s);
        Intrinsics.checkExpressionValueIsNotNull(uri0, "Uri.parse(this)");
        return uri0;
    }
}

