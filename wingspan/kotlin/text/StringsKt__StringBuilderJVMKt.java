package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u001A\u001F\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0087\b\u001A\u001D\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0005H\u0087\b\u001A\u001D\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0006H\u0087\b\u001A\u001D\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0007H\u0087\b\u001A\u001D\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\bH\u0087\b\u001A\u001D\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\tH\u0087\b\u001A\u001D\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\nH\u0087\b\u001A%\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000E\u0010\u0003\u001A\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001A-\u0010\u000B\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\bH\u0087\b\u001A-\u0010\u000B\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\bH\u0087\b\u001A\u0014\u0010\u0010\u001A\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u0012H\u0007\u001A\u001D\u0010\u0010\u001A\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u00122\u0006\u0010\u0003\u001A\u00020\u0013H\u0087\b\u001A\u001F\u0010\u0010\u001A\u00060\u0011j\u0002`\u0012*\u00060\u0011j\u0002`\u00122\b\u0010\u0003\u001A\u0004\u0018\u00010\u000FH\u0087\b\u001A\u0014\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001A\u001F\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0087\b\u001A\u001F\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0014H\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0015H\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0005H\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0013H\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\fH\u0087\b\u001A\u001F\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u000FH\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0006H\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0007H\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\bH\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\tH\u0087\b\u001A\u001D\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\nH\u0087\b\u001A\u001F\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0016H\u0087\b\u001A%\u0010\u0010\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000E\u0010\u0003\u001A\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001A\u0014\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001A\u001D\u0010\u0018\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001A\u00020\bH\u0087\b\u001A%\u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\bH\u0087\b\u001A5\u0010\u001B\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\bH\u0087\b\u001A5\u0010\u001B\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\bH\u0087\b\u001A!\u0010\u001C\u001A\u00020\u001D*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0013H\u0087\n\u001A-\u0010\u001E\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0016H\u0087\b\u001A7\u0010\u001F\u001A\u00020\u001D*\u00060\u0001j\u0002`\u00022\u0006\u0010 \u001A\u00020\f2\b\b\u0002\u0010!\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\bH\u0087\b\u00A8\u0006\""}, d2 = {"appendLine", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "appendRange", "", "startIndex", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "", "", "clear", "deleteAt", "index", "deleteRange", "insertRange", "set", "", "setRange", "toCharArray", "destination", "destinationOffset", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    private static final StringBuilder appendLine(StringBuilder stringBuilder0, byte b) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(((int)b));
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F13130205084F1A0E2E0B06465944"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, double f) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(f);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, float f) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(f);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, int v) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(v);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, long v) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(v);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, StringBuffer stringBuffer0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(stringBuffer0);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, StringBuilder stringBuilder1) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(stringBuilder1);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder0, short v) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(((int)v));
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F13130205084F1A0E2E0B06465944"));
        stringBuilder0.append('\n');
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F422E005744"));
        return stringBuilder0;
    }

    private static final StringBuilder appendRange(StringBuilder stringBuilder0, CharSequence charSequence0, int v, int v1) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charSequence0, UnityPlayerActivity.adjustValue("181101140B"));
        stringBuilder0.append(charSequence0, v, v1);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("1A1804124000171517001445170F0D12005E4E0319001C152E0B160B0841410B0F032C1C0A151548"));
        return stringBuilder0;
    }

    private static final StringBuilder appendRange(StringBuilder stringBuilder0, char[] arr_c, int v, int v1) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("181101140B"));
        stringBuilder0.append(arr_c, v, v1 - v);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("1A1804124000171517001445170F0D12005E4E0319001C1585E5D4165C4D0400052E0B160B084D4C4E121304001A3903050B194E"));
        return stringBuilder0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final Appendable appendln(Appendable appendable0) {
        Intrinsics.checkNotNullParameter(appendable0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Appendable appendable1 = appendable0.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(appendable1, UnityPlayerActivity.adjustValue("0F001D0400054F360B1D04080C3E130815171C0404041D4F2B2C3C2B2F3E243E20352426212244"));
        return appendable1;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable appendable0, char c) {
        Intrinsics.checkNotNullParameter(appendable0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Appendable appendable1 = appendable0.append(c);
        Intrinsics.checkNotNullExpressionValue(appendable1, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(appendable1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable appendable0, CharSequence charSequence0) {
        Intrinsics.checkNotNullParameter(appendable0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Appendable appendable1 = appendable0.append(charSequence0);
        Intrinsics.checkNotNullExpressionValue(appendable1, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(appendable1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final StringBuilder appendln(StringBuilder stringBuilder0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F360B1D04080C3E130815171C0404041D4F2B2C3C2B2F3E243E20352426212244"));
        return stringBuilder0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, byte b) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(((int)b));
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F13130205084F1A0E2E0B06465944"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, char c) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(c);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, double f) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(f);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, float f) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(f);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, int v) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(v);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, long v) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(v);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, CharSequence charSequence0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(charSequence0);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, Object object0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(object0);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, String s) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(s);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, StringBuffer stringBuffer0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(stringBuffer0);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, StringBuilder stringBuilder1) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(stringBuilder1);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, short v) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(((int)v));
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F13130205084F1A0E2E0B06465944"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, boolean z) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.append(z);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder stringBuilder0, char[] arr_c) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("181101140B"));
        stringBuilder0.append(arr_c);
        Intrinsics.checkNotNullExpressionValue(stringBuilder0, UnityPlayerActivity.adjustValue("0F001D0400054F131302050848"));
        return StringsKt.appendln(stringBuilder0);
    }

    public static final StringBuilder clear(StringBuilder stringBuilder0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.setLength(0);
        return stringBuilder0;
    }

    private static final StringBuilder deleteAt(StringBuilder stringBuilder0, int v) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        StringBuilder stringBuilder1 = stringBuilder0.deleteCharAt(v);
        Intrinsics.checkNotNullExpressionValue(stringBuilder1, UnityPlayerActivity.adjustValue("1A18041240050209171A152E090F1326115A071E09041648"));
        return stringBuilder1;
    }

    private static final StringBuilder deleteRange(StringBuilder stringBuilder0, int v, int v1) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        StringBuilder stringBuilder1 = stringBuilder0.delete(v, v1);
        Intrinsics.checkNotNullExpressionValue(stringBuilder1, UnityPlayerActivity.adjustValue("1A18041240050209171A1545121A0015113B001408194241020B16271E09041648"));
        return stringBuilder1;
    }

    private static final StringBuilder insertRange(StringBuilder stringBuilder0, int v, CharSequence charSequence0, int v1, int v2) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charSequence0, UnityPlayerActivity.adjustValue("181101140B"));
        StringBuilder stringBuilder1 = stringBuilder0.insert(v, charSequence0, v1, v2);
        Intrinsics.checkNotNullExpressionValue(stringBuilder1, UnityPlayerActivity.adjustValue("1A18041240080916171C0445080005021D5E4E060C0D1B044B45011A111F15270F03000A4250080F0A280901171659"));
        return stringBuilder1;
    }

    private static final StringBuilder insertRange(StringBuilder stringBuilder0, int v, char[] arr_c, int v1, int v2) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("181101140B"));
        StringBuilder stringBuilder1 = stringBuilder0.insert(v, arr_c, v1, v2 - v1);
        Intrinsics.checkNotNullExpressionValue(stringBuilder1, UnityPlayerActivity.adjustValue("1A18041240080916171C0445080005021D5E4E060C0D1B0485E5D4165C4D0400052E0B160B084D4C4E121304001A3903050B194E"));
        return stringBuilder1;
    }

    private static final void set(StringBuilder stringBuilder0, int v, char c) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        stringBuilder0.setCharAt(v, c);
    }

    private static final StringBuilder setRange(StringBuilder stringBuilder0, int v, int v1, String s) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("181101140B"));
        StringBuilder stringBuilder1 = stringBuilder0.replace(v, v1, s);
        Intrinsics.checkNotNullExpressionValue(stringBuilder1, UnityPlayerActivity.adjustValue("1A180412401302151E0F1308491D15061706271E0904164D47001C0A3903050B194B45040F1C180447"));
        return stringBuilder1;
    }

    private static final void toCharArray(StringBuilder stringBuilder0, char[] arr_c, int v, int v1, int v2) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("0A151E15070F06111B011E"));
        stringBuilder0.getChars(v1, v2, arr_c, v);
    }

    static void toCharArray$default(StringBuilder stringBuilder0, char[] arr_c, int v, int v1, int v2, int v3, Object object0) {
        if((v3 & 2) != 0) {
            v = 0;
        }
        if((v3 & 4) != 0) {
            v1 = 0;
        }
        if((v3 & 8) != 0) {
            v2 = stringBuilder0.length();
        }
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("0A151E15070F06111B011E"));
        stringBuilder0.getChars(v1, v2, arr_c, v);
    }
}

