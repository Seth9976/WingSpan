package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0011\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0087\b¨\u0006\u0004"}, d2 = {"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class CharsetsKt {
    private static final Charset charset(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("0D180C131D04132B130315"));
        Charset charset0 = Charset.forName(s);
        Intrinsics.checkNotNullExpressionValue(charset0, UnityPlayerActivity.adjustValue("081F1F2F0F0C024D1106111F120B1529041F0B59"));
        return charset0;
    }
}

