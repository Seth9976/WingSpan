package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\r\n\u0000\u001A>\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u001B\u0010\u0004\u001A\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00A2\u0006\u0002\b\tH\u0087\b\u00F8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A6\u0010\u0000\u001A\u00020\u00012\u001B\u0010\u0004\u001A\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00A2\u0006\u0002\b\tH\u0087\b\u00F8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A\u001F\u0010\n\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0087\b\u001A/\u0010\n\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000E\"\u0004\u0018\u00010\f\u00A2\u0006\u0002\u0010\u000F\u001A/\u0010\n\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000E\"\u0004\u0018\u00010\u0001\u00A2\u0006\u0002\u0010\u0010\u001A\u0015\u0010\u0011\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0087\b\u001A\u001F\u0010\u0011\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0087\b\u001A\u001D\u0010\u0011\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001A\u00020\u0012H\u0087\b\u001A\u001D\u0010\u0011\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001A\u00020\u0013H\u0087\b\u001A\u001D\u0010\u0011\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001A\u00020\u0014H\u0087\b\u001A\u001F\u0010\u0011\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001A\u0004\u0018\u00010\u0015H\u0087\b\u001A\u001F\u0010\u0011\u001A\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u0006\u0016"}, d2 = {"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "", "", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    private static final StringBuilder append(StringBuilder stringBuilder0, Object object0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(object0);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("1A18041240001715170014450E0C0B4E"));
        return stringBuilder0;
    }

    public static final StringBuilder append(StringBuilder stringBuilder0, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_object, UnityPlayerActivity.adjustValue("181101140B"));
        for(int v = 0; v < arr_object.length; ++v) {
            stringBuilder0.append(arr_object[v]);
        }
        return stringBuilder0;
    }

    public static final StringBuilder append(StringBuilder stringBuilder0, String[] arr_s) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_s, UnityPlayerActivity.adjustValue("181101140B"));
        for(int v = 0; v < arr_s.length; ++v) {
            stringBuilder0.append(arr_s[v]);
        }
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, char c) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(c);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, CharSequence charSequence0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(charSequence0);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, Object object0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(object0);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, String s) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(s);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, boolean z) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(z);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, char[] arr_c) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("181101140B"));
        stringBuilder0.append(arr_c);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final String buildString(int v, Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, UnityPlayerActivity.adjustValue("0C05040D0A041524111A19020F"));
        StringBuilder stringBuilder0 = new StringBuilder(v);
        function10.invoke(stringBuilder0);
        String s = stringBuilder0.toString();
        Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("3D041F08000625101B0214081346020615130D191918474F85E5D40C05040D0A041524111A19020F474F130A211A02040F09494E"));
        return s;
    }

    private static final String buildString(Function1 function10) {
        Intrinsics.checkNotNullParameter(function10, UnityPlayerActivity.adjustValue("0C05040D0A041524111A19020F"));
        StringBuilder stringBuilder0 = new StringBuilder();
        function10.invoke(stringBuilder0);
        String s = stringBuilder0.toString();
        Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("3D041F08000625101B0214081346484904021E1C14490C140E09160B022C021A08080B5B400402321A130E0B154659"));
        return s;
    }
}

