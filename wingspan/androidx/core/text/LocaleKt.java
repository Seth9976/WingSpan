package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"layoutDirection", "", "Ljava/util/Locale;", "getLayoutDirection", "(Ljava/util/Locale;)I", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class LocaleKt {
    public static final int getLayoutDirection(Locale locale0) {
        Intrinsics.checkParameterIsNotNull(locale0, "$this$layoutDirection");
        return TextUtils.getLayoutDirectionFromLocale(locale0);
    }
}

