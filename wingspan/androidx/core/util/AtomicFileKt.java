package androidx.core.util;

import android.util.AtomicFile;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\b\u001A\u0016\u0010\u0003\u001A\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0007\u001A0\u0010\u0007\u001A\u00020\b*\u00020\u00022!\u0010\t\u001A\u001D\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\b0\nH\u0087\b\u001A\u0014\u0010\u000F\u001A\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u0001H\u0007\u001A\u001E\u0010\u0011\u001A\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0007¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class AtomicFileKt {
    public static final byte[] readBytes(AtomicFile atomicFile0) {
        Intrinsics.checkParameterIsNotNull(atomicFile0, "$this$readBytes");
        byte[] arr_b = atomicFile0.readFully();
        Intrinsics.checkExpressionValueIsNotNull(arr_b, "readFully()");
        return arr_b;
    }

    public static final String readText(AtomicFile atomicFile0, Charset charset0) {
        Intrinsics.checkParameterIsNotNull(atomicFile0, "$this$readText");
        Intrinsics.checkParameterIsNotNull(charset0, "charset");
        byte[] arr_b = atomicFile0.readFully();
        Intrinsics.checkExpressionValueIsNotNull(arr_b, "readFully()");
        return new String(arr_b, charset0);
    }

    public static String readText$default(AtomicFile atomicFile0, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        return AtomicFileKt.readText(atomicFile0, charset0);
    }

    public static final void tryWrite(AtomicFile atomicFile0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(atomicFile0, "$this$tryWrite");
        Intrinsics.checkParameterIsNotNull(function10, "block");
        FileOutputStream fileOutputStream0 = atomicFile0.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(fileOutputStream0, "stream");
            function10.invoke(fileOutputStream0);
        }
        catch(Throwable throwable0) {
            atomicFile0.failWrite(fileOutputStream0);
            throw throwable0;
        }
        atomicFile0.finishWrite(fileOutputStream0);
    }

    public static final void writeBytes(AtomicFile atomicFile0, byte[] arr_b) {
        Intrinsics.checkParameterIsNotNull(atomicFile0, "$this$writeBytes");
        Intrinsics.checkParameterIsNotNull(arr_b, "array");
        FileOutputStream fileOutputStream0 = atomicFile0.startWrite();
        try {
            Intrinsics.checkExpressionValueIsNotNull(fileOutputStream0, "stream");
            fileOutputStream0.write(arr_b);
        }
        catch(Throwable throwable0) {
            atomicFile0.failWrite(fileOutputStream0);
            throw throwable0;
        }
        atomicFile0.finishWrite(fileOutputStream0);
    }

    public static final void writeText(AtomicFile atomicFile0, String s, Charset charset0) {
        Intrinsics.checkParameterIsNotNull(atomicFile0, "$this$writeText");
        Intrinsics.checkParameterIsNotNull(s, "text");
        Intrinsics.checkParameterIsNotNull(charset0, "charset");
        byte[] arr_b = s.getBytes(charset0);
        Intrinsics.checkExpressionValueIsNotNull(arr_b, "(this as java.lang.String).getBytes(charset)");
        AtomicFileKt.writeBytes(atomicFile0, arr_b);
    }

    public static void writeText$default(AtomicFile atomicFile0, String s, Charset charset0, int v, Object object0) {
        if((v & 2) != 0) {
            charset0 = Charsets.UTF_8;
        }
        AtomicFileKt.writeText(atomicFile0, s, charset0);
    }
}

