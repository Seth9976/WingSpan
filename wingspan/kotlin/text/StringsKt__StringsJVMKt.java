package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\u001A\u0011\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\tH\u0087\b\u001A\u0011\u0010\u0007\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u000BH\u0087\b\u001A\u0011\u0010\u0007\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\rH\u0087\b\u001A\u0019\u0010\u0007\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0087\b\u001A!\u0010\u0007\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0087\b\u001A)\u0010\u0007\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\u000FH\u0087\b\u001A\u0011\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u0014H\u0087\b\u001A!\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0087\b\u001A!\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0087\b\u001A\f\u0010\u0017\u001A\u00020\u0002*\u00020\u0002H\u0007\u001A\u0014\u0010\u0017\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0019H\u0007\u001A\u0015\u0010\u001A\u001A\u00020\u0011*\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u0011H\u0087\b\u001A\u0015\u0010\u001C\u001A\u00020\u0011*\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u0011H\u0087\b\u001A\u001D\u0010\u001D\u001A\u00020\u0011*\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020\u0011H\u0087\b\u001A\u001C\u0010 \u001A\u00020\u0011*\u00020\u00022\u0006\u0010!\u001A\u00020\u00022\b\b\u0002\u0010\"\u001A\u00020#\u001A\f\u0010$\u001A\u00020\u0002*\u00020\u0014H\u0007\u001A \u0010$\u001A\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001A\u00020\u00112\b\b\u0002\u0010\u001F\u001A\u00020\u0011H\u0007\u001A\u0019\u0010&\u001A\u00020#*\u0004\u0018\u00010\'2\b\u0010!\u001A\u0004\u0018\u00010\'H\u0087\u0004\u001A \u0010&\u001A\u00020#*\u0004\u0018\u00010\'2\b\u0010!\u001A\u0004\u0018\u00010\'2\u0006\u0010\"\u001A\u00020#H\u0007\u001A\u0015\u0010&\u001A\u00020#*\u00020\u00022\u0006\u0010\n\u001A\u00020\tH\u0087\b\u001A\u0015\u0010&\u001A\u00020#*\u00020\u00022\u0006\u0010(\u001A\u00020\'H\u0087\b\u001A\f\u0010)\u001A\u00020\u0002*\u00020\u0002H\u0007\u001A\u0014\u0010)\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0019H\u0007\u001A\f\u0010*\u001A\u00020\u0002*\u00020\rH\u0007\u001A*\u0010*\u001A\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001A\u00020\u00112\b\b\u0002\u0010\u001F\u001A\u00020\u00112\b\b\u0002\u0010+\u001A\u00020#H\u0007\u001A\f\u0010,\u001A\u00020\r*\u00020\u0002H\u0007\u001A*\u0010,\u001A\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001A\u00020\u00112\b\b\u0002\u0010\u001F\u001A\u00020\u00112\b\b\u0002\u0010+\u001A\u00020#H\u0007\u001A\u001C\u0010-\u001A\u00020#*\u00020\u00022\u0006\u0010.\u001A\u00020\u00022\b\b\u0002\u0010\"\u001A\u00020#\u001A \u0010/\u001A\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001A\u00020#\u001A2\u00100\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u00192\u0016\u00101\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00A2\u0006\u0002\u00104\u001A6\u00100\u001A\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001A\u0004\u0018\u00010\u00192\u0016\u00101\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00A2\u0006\u0004\b5\u00104\u001A*\u00100\u001A\u00020\u0002*\u00020\u00022\u0016\u00101\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00A2\u0006\u0002\u00106\u001A:\u00100\u001A\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u00100\u001A\u00020\u00022\u0016\u00101\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00A2\u0006\u0002\u00107\u001A>\u00100\u001A\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001A\u0004\u0018\u00010\u00192\u0006\u00100\u001A\u00020\u00022\u0016\u00101\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00A2\u0006\u0004\b5\u00107\u001A2\u00100\u001A\u00020\u0002*\u00020\u00042\u0006\u00100\u001A\u00020\u00022\u0016\u00101\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b\u00A2\u0006\u0002\u00108\u001A\r\u00109\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\n\u0010:\u001A\u00020#*\u00020\'\u001A\r\u0010;\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\u0015\u0010;\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0019H\u0087\b\u001A\u001D\u0010<\u001A\u00020\u0011*\u00020\u00022\u0006\u0010=\u001A\u00020>2\u0006\u0010?\u001A\u00020\u0011H\u0081\b\u001A\u001D\u0010<\u001A\u00020\u0011*\u00020\u00022\u0006\u0010@\u001A\u00020\u00022\u0006\u0010?\u001A\u00020\u0011H\u0081\b\u001A\u001D\u0010A\u001A\u00020\u0011*\u00020\u00022\u0006\u0010=\u001A\u00020>2\u0006\u0010?\u001A\u00020\u0011H\u0081\b\u001A\u001D\u0010A\u001A\u00020\u0011*\u00020\u00022\u0006\u0010@\u001A\u00020\u00022\u0006\u0010?\u001A\u00020\u0011H\u0081\b\u001A\u001D\u0010B\u001A\u00020\u0011*\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u00112\u0006\u0010C\u001A\u00020\u0011H\u0087\b\u001A4\u0010D\u001A\u00020#*\u00020\'2\u0006\u0010E\u001A\u00020\u00112\u0006\u0010!\u001A\u00020\'2\u0006\u0010F\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\"\u001A\u00020#\u001A4\u0010D\u001A\u00020#*\u00020\u00022\u0006\u0010E\u001A\u00020\u00112\u0006\u0010!\u001A\u00020\u00022\u0006\u0010F\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\"\u001A\u00020#\u001A\u0012\u0010G\u001A\u00020\u0002*\u00020\'2\u0006\u0010H\u001A\u00020\u0011\u001A$\u0010I\u001A\u00020\u0002*\u00020\u00022\u0006\u0010J\u001A\u00020>2\u0006\u0010K\u001A\u00020>2\b\b\u0002\u0010\"\u001A\u00020#\u001A$\u0010I\u001A\u00020\u0002*\u00020\u00022\u0006\u0010L\u001A\u00020\u00022\u0006\u0010M\u001A\u00020\u00022\b\b\u0002\u0010\"\u001A\u00020#\u001A$\u0010N\u001A\u00020\u0002*\u00020\u00022\u0006\u0010J\u001A\u00020>2\u0006\u0010K\u001A\u00020>2\b\b\u0002\u0010\"\u001A\u00020#\u001A$\u0010N\u001A\u00020\u0002*\u00020\u00022\u0006\u0010L\u001A\u00020\u00022\u0006\u0010M\u001A\u00020\u00022\b\b\u0002\u0010\"\u001A\u00020#\u001A\"\u0010O\u001A\b\u0012\u0004\u0012\u00020\u00020P*\u00020\'2\u0006\u0010Q\u001A\u00020R2\b\b\u0002\u0010S\u001A\u00020\u0011\u001A\u001C\u0010T\u001A\u00020#*\u00020\u00022\u0006\u0010U\u001A\u00020\u00022\b\b\u0002\u0010\"\u001A\u00020#\u001A$\u0010T\u001A\u00020#*\u00020\u00022\u0006\u0010U\u001A\u00020\u00022\u0006\u0010%\u001A\u00020\u00112\b\b\u0002\u0010\"\u001A\u00020#\u001A\u0015\u0010V\u001A\u00020\u0002*\u00020\u00022\u0006\u0010%\u001A\u00020\u0011H\u0087\b\u001A\u001D\u0010V\u001A\u00020\u0002*\u00020\u00022\u0006\u0010%\u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020\u0011H\u0087\b\u001A\u0017\u0010W\u001A\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0087\b\u001A\r\u0010X\u001A\u00020\u0014*\u00020\u0002H\u0087\b\u001A3\u0010X\u001A\u00020\u0014*\u00020\u00022\u0006\u0010Y\u001A\u00020\u00142\b\b\u0002\u0010Z\u001A\u00020\u00112\b\b\u0002\u0010%\u001A\u00020\u00112\b\b\u0002\u0010\u001F\u001A\u00020\u0011H\u0087\b\u001A \u0010X\u001A\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001A\u00020\u00112\b\b\u0002\u0010\u001F\u001A\u00020\u0011H\u0007\u001A\r\u0010[\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\u0015\u0010[\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0019H\u0087\b\u001A\u0017\u0010\\\u001A\u00020R*\u00020\u00022\b\b\u0002\u0010]\u001A\u00020\u0011H\u0087\b\u001A\r\u0010^\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\u0015\u0010^\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0019H\u0087\b\u001A\r\u0010_\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\u0015\u0010_\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0019H\u0087\b\"%\u0010\u0000\u001A\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F\u00A2\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\u00A8\u0006`"}, d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    private static final String String(StringBuffer stringBuffer0) {
        Intrinsics.checkNotNullParameter(stringBuffer0, UnityPlayerActivity.adjustValue("1D041F08000625101408151F"));
        return new String(stringBuffer0);
    }

    private static final String String(StringBuilder stringBuilder0) {
        Intrinsics.checkNotNullParameter(stringBuilder0, UnityPlayerActivity.adjustValue("1D041F08000625101B02140813"));
        return new String(stringBuilder0);
    }

    private static final String String(byte[] arr_b) {
        Intrinsics.checkNotNullParameter(arr_b, UnityPlayerActivity.adjustValue("0C0919041D"));
        return new String(arr_b, Charsets.UTF_8);
    }

    private static final String String(byte[] arr_b, int v, int v1) {
        Intrinsics.checkNotNullParameter(arr_b, UnityPlayerActivity.adjustValue("0C0919041D"));
        return new String(arr_b, v, v1, Charsets.UTF_8);
    }

    private static final String String(byte[] arr_b, int v, int v1, Charset charset0) {
        Intrinsics.checkNotNullParameter(arr_b, UnityPlayerActivity.adjustValue("0C0919041D"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        return new String(arr_b, v, v1, charset0);
    }

    private static final String String(byte[] arr_b, Charset charset0) {
        Intrinsics.checkNotNullParameter(arr_b, UnityPlayerActivity.adjustValue("0C0919041D"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        return new String(arr_b, charset0);
    }

    private static final String String(char[] arr_c) {
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("0D180C131D"));
        return new String(arr_c);
    }

    private static final String String(char[] arr_c, int v, int v1) {
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("0D180C131D"));
        return new String(arr_c, v, v1);
    }

    private static final String String(int[] arr_v, int v, int v1) {
        Intrinsics.checkNotNullParameter(arr_v, UnityPlayerActivity.adjustValue("0D1F09043E0E0E0B061D"));
        return new String(arr_v, v, v1);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Locale locale0 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale0, UnityPlayerActivity.adjustValue("091519250B0706101E1A5844"));
        return StringsKt.capitalize(s, locale0);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String s, Locale locale0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        if(s.length() > 0) {
            int v = s.charAt(0);
            if(Character.isLowerCase(((char)v))) {
                StringBuilder stringBuilder0 = new StringBuilder();
                int v1 = Character.toTitleCase(((char)v));
                if(v1 == Character.toUpperCase(((char)v))) {
                    String s1 = s.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
                    Intrinsics.checkNotNull(s1, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
                    String s2 = s1.toUpperCase(locale0);
                    Intrinsics.checkNotNullExpressionValue(s2, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B58010E0D000B005B"));
                    stringBuilder0.append(s2);
                }
                else {
                    stringBuilder0.append(((char)v1));
                }
                String s3 = s.substring(1);
                Intrinsics.checkNotNullExpressionValue(s3, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B011B121E151C0809025A1D040C131A280901171659"));
                stringBuilder0.append(s3);
                s = stringBuilder0.toString();
                Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("3D041F08000625101B0214081346484904021E1C14490C140E09160B022C021A08080B5B400402321A130E0B154659"));
            }
        }
        return s;
    }

    private static final int codePointAt(String s, int v) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        return s.codePointAt(v);
    }

    private static final int codePointBefore(String s, int v) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        return s.codePointBefore(v);
    }

    private static final int codePointCount(String s, int v, int v1) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        return s.codePointCount(v, v1);
    }

    public static final int compareTo(String s, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("010405041C"));
        return z ? s.compareToIgnoreCase(s1) : s.compareTo(s1);
    }

    public static int compareTo$default(String s, String s1, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return StringsKt.compareTo(s, s1, z);
    }

    public static final String concatToString(char[] arr_c) {
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new String(arr_c);
    }

    public static final String concatToString(char[] arr_c, int v, int v1) {
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("520405081D5F"));
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(v, v1, arr_c.length);
        return new String(arr_c, v, v1 - v);
    }

    public static String concatToString$default(char[] arr_c, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = arr_c.length;
        }
        return StringsKt.concatToString(arr_c, v, v1);
    }

    public static final boolean contentEquals(CharSequence charSequence0, CharSequence charSequence1) {
        return !(charSequence0 instanceof String) || charSequence1 == null ? StringsKt.contentEqualsImpl(charSequence0, charSequence1) : ((String)charSequence0).contentEquals(charSequence1);
    }

    // 去混淆评级： 低(20)
    public static final boolean contentEquals(CharSequence charSequence0, CharSequence charSequence1, boolean z) {
        return z ? StringsKt.contentEqualsIgnoreCaseImpl(charSequence0, charSequence1) : StringsKt.contentEquals(charSequence0, charSequence1);
    }

    private static final boolean contentEquals(String s, CharSequence charSequence0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charSequence0, UnityPlayerActivity.adjustValue("0D180C133D04161017001308"));
        return s.contentEquals(charSequence0);
    }

    private static final boolean contentEquals(String s, StringBuffer stringBuffer0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(stringBuffer0, UnityPlayerActivity.adjustValue("1D041F08000625101B02140813"));
        return s.contentEquals(stringBuffer0);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(s.length() > 0 && !Character.isLowerCase(s.charAt(0))) {
            String s1 = s.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
            Intrinsics.checkNotNull(s1, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
            String s2 = s1.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(s2, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B5844"));
            String s3 = s.substring(1);
            Intrinsics.checkNotNullExpressionValue(s3, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B011B121E151C0809025A1D040C131A280901171659"));
            return s2 + s3;
        }
        return s;
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String s, Locale locale0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        if(s.length() > 0 && !Character.isLowerCase(s.charAt(0))) {
            String s1 = s.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
            Intrinsics.checkNotNull(s1, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
            String s2 = s1.toLowerCase(locale0);
            Intrinsics.checkNotNullExpressionValue(s2, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B58010E0D000B005B"));
            String s3 = s.substring(1);
            Intrinsics.checkNotNullExpressionValue(s3, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B011B121E151C0809025A1D040C131A280901171659"));
            return s2 + s3;
        }
        return s;
    }

    public static final String decodeToString(byte[] arr_b) {
        Intrinsics.checkNotNullParameter(arr_b, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new String(arr_b, Charsets.UTF_8);
    }

    public static final String decodeToString(byte[] arr_b, int v, int v1, boolean z) {
        Intrinsics.checkNotNullParameter(arr_b, UnityPlayerActivity.adjustValue("520405081D5F"));
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(v, v1, arr_b.length);
        if(!z) {
            return new String(arr_b, v, v1 - v, Charsets.UTF_8);
        }
        String s = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(arr_b, v, v1 - v)).toString();
        Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("0A150E0E0A04154B160B1302050B49251C060B321807080485E5D443501E150F13132C1C0A151548474F130A211A02040F09494E"));
        return s;
    }

    public static String decodeToString$default(byte[] arr_b, int v, int v1, boolean z, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = arr_b.length;
        }
        if((v2 & 4) != 0) {
            z = false;
        }
        return StringsKt.decodeToString(arr_b, v, v1, z);
    }

    public static final byte[] encodeToByteArray(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        byte[] arr_b = s.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(arr_b, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B150B042F181A04144D1106111F120B154E"));
        return arr_b;
    }

    public static final byte[] encodeToByteArray(String s, int v, int v1, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(v, v1, s.length());
        if(!z) {
            String s1 = s.substring(v, v1);
            Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
            Intrinsics.checkNotNull(s1, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
            byte[] arr_b = s1.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(arr_b, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B150B042F181A04144D1106111F120B154E"));
            return arr_b;
        }
        ByteBuffer byteBuffer0 = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(s, v, v1));
        if(byteBuffer0.hasArray() && byteBuffer0.arrayOffset() == 0) {
            byte[] arr_b1 = byteBuffer0.array();
            Intrinsics.checkNotNull(arr_b1);
            if(byteBuffer0.remaining() == arr_b1.length) {
                byte[] arr_b2 = byteBuffer0.array();
                Intrinsics.checkNotNullExpressionValue(arr_b2, UnityPlayerActivity.adjustValue("157A4D414E414745524E1214150B231203140B0243001C13061C5A477A4D414E411A"));
                return arr_b2;
            }
        }
        byte[] arr_b3 = new byte[byteBuffer0.remaining()];
        byteBuffer0.get(arr_b3);
        return arr_b3;
    }

    public static byte[] encodeToByteArray$default(String s, int v, int v1, boolean z, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = s.length();
        }
        if((v2 & 4) != 0) {
            z = false;
        }
        return StringsKt.encodeToByteArray(s, v, v1, z);
    }

    public static final boolean endsWith(String s, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("1D050B070719"));
        return z ? StringsKt.regionMatches(s, s.length() - s1.length(), s1, 0, s1.length(), true) : s.endsWith(s1);
    }

    public static boolean endsWith$default(String s, String s1, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(s, s1, z);
    }

    public static final boolean equals(String s, String s1, boolean z) {
        if(s == null) {
            return s1 == null;
        }
        return z ? s.equalsIgnoreCase(s1) : s.equals(s1);
    }

    public static boolean equals$default(String s, String s1, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return StringsKt.equals(s, s1, z);
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    private static final String format(String s, Locale locale0, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        Intrinsics.checkNotNullParameter(arr_object, UnityPlayerActivity.adjustValue("0F020A12"));
        String s1 = String.format(locale0, s, Arrays.copyOf(arr_object, arr_object.length));
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("081F1F0C0F154F091D0D1101044241130D1B1D5C4D4B0F1300165B"));
        return s1;
    }

    private static final String format(String s, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_object, UnityPlayerActivity.adjustValue("0F020A12"));
        String s1 = String.format(s, Arrays.copyOf(arr_object, arr_object.length));
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("081F1F0C0F154F111A07034141440015020147"));
        return s1;
    }

    private static final String format(StringCompanionObject stringCompanionObject0, String s, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(stringCompanionObject0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("081F1F0C0F15"));
        Intrinsics.checkNotNullParameter(arr_object, UnityPlayerActivity.adjustValue("0F020A12"));
        String s1 = String.format(s, Arrays.copyOf(arr_object, arr_object.length));
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("081F1F0C0F154F031D1C1D0C1542414D0400090344"));
        return s1;
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    private static final String format(StringCompanionObject stringCompanionObject0, Locale locale0, String s, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(stringCompanionObject0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("081F1F0C0F15"));
        Intrinsics.checkNotNullParameter(arr_object, UnityPlayerActivity.adjustValue("0F020A12"));
        String s1 = String.format(locale0, s, Arrays.copyOf(arr_object, arr_object.length));
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("081F1F0C0F154F091D0D1101044241010A000311194D4E4B0617151D59"));
        return s1;
    }

    private static final String formatNullable(String s, Locale locale0, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_object, UnityPlayerActivity.adjustValue("0F020A12"));
        String s1 = String.format(locale0, s, Arrays.copyOf(arr_object, arr_object.length));
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("081F1F0C0F154F091D0D1101044241130D1B1D5C4D4B0F1300165B"));
        return s1;
    }

    private static final String formatNullable(StringCompanionObject stringCompanionObject0, Locale locale0, String s, Object[] arr_object) {
        Intrinsics.checkNotNullParameter(stringCompanionObject0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("081F1F0C0F15"));
        Intrinsics.checkNotNullParameter(arr_object, UnityPlayerActivity.adjustValue("0F020A12"));
        String s1 = String.format(locale0, s, Arrays.copyOf(arr_object, arr_object.length));
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("081F1F0C0F154F091D0D1101044241010A000311194D4E4B0617151D59"));
        return s1;
    }

    public static final Comparator getCASE_INSENSITIVE_ORDER(StringCompanionObject stringCompanionObject0) {
        Intrinsics.checkNotNullParameter(stringCompanionObject0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Comparator comparator0 = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(comparator0, UnityPlayerActivity.adjustValue("2D313E243128293637202324352737223A3D3C342833"));
        return comparator0;
    }

    private static final String intern(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s1 = s.intern();
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B1B0004081300494E"));
        return s1;
    }

    public static final boolean isBlank(CharSequence charSequence0) {
        Intrinsics.checkNotNullParameter(charSequence0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(charSequence0.length() != 0) {
            Iterable iterable0 = StringsKt.getIndices(charSequence0);
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                Iterator iterator0 = iterable0.iterator();
                while(iterator0.hasNext()) {
                    if(!CharsKt.isWhitespace(charSequence0.charAt(((IntIterator)iterator0).nextInt()))) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return true;
        }
        return true;
    }

    private static final String lowercase(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s1 = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B58210E0D000B005C3C3F223547"));
        return s1;
    }

    private static final String lowercase(String s, Locale locale0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        String s1 = s.toLowerCase(locale0);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B58010E0D000B005B"));
        return s1;
    }

    private static final int nativeIndexOf(String s, char c, int v) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        return s.indexOf(((int)c), v);
    }

    private static final int nativeIndexOf(String s, String s1, int v) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("1D041F"));
        return s.indexOf(s1, v);
    }

    private static final int nativeLastIndexOf(String s, char c, int v) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        return s.lastIndexOf(((int)c), v);
    }

    private static final int nativeLastIndexOf(String s, String s1, int v) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("1D041F"));
        return s.lastIndexOf(s1, v);
    }

    private static final int offsetByCodePoints(String s, int v, int v1) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        return s.offsetByCodePoints(v, v1);
    }

    public static final boolean regionMatches(CharSequence charSequence0, int v, CharSequence charSequence1, int v1, int v2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charSequence1, UnityPlayerActivity.adjustValue("010405041C"));
        return !(charSequence0 instanceof String) || !(charSequence1 instanceof String) ? StringsKt.regionMatchesImpl(charSequence0, v, charSequence1, v1, v2, z) : StringsKt.regionMatches(((String)charSequence0), v, ((String)charSequence1), v1, v2, z);
    }

    public static final boolean regionMatches(String s, int v, String s1, int v1, int v2, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("010405041C"));
        return z ? s.regionMatches(true, v, s1, v1, v2) : s.regionMatches(v, s1, v1, v2);
    }

    public static boolean regionMatches$default(CharSequence charSequence0, int v, CharSequence charSequence1, int v1, int v2, boolean z, int v3, Object object0) {
        if((v3 & 16) != 0) {
            z = false;
        }
        return StringsKt.regionMatches(charSequence0, v, charSequence1, v1, v2, z);
    }

    public static boolean regionMatches$default(String s, int v, String s1, int v1, int v2, boolean z, int v3, Object object0) {
        if((v3 & 16) != 0) {
            z = false;
        }
        return StringsKt.regionMatches(s, v, s1, v1, v2, z);
    }

    public static final String repeat(CharSequence charSequence0, int v) {
        Intrinsics.checkNotNullParameter(charSequence0, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(v >= 0) {
            String s = UnityPlayerActivity.adjustValue("");
            switch(v) {
                case 0: {
                    return s;
                label_18:
                    char c = charSequence0.charAt(0);
                    char[] arr_c = new char[v];
                    for(int v1 = 0; v1 < v; ++v1) {
                        arr_c[v1] = c;
                    }
                    return new String(arr_c);
                }
                case 1: {
                    return charSequence0.toString();
                label_7:
                    switch(charSequence0.length()) {
                        case 0: {
                            return s;
                        }
                        case 1: {
                            goto label_18;
                        }
                        default: {
                            StringBuilder stringBuilder0 = new StringBuilder(charSequence0.length() * v);
                            IntIterator intIterator0 = new IntRange(1, v).iterator();
                            while(intIterator0.hasNext()) {
                                intIterator0.nextInt();
                                stringBuilder0.append(charSequence0);
                            }
                            s = stringBuilder0.toString();
                            Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("157A4D414E414745524E504D414E414745524E504D41180085E5D41A02040F09494E6F524E504D414E414745524E504D414E411A"));
                            return s;
                        }
                    }
                }
                default: {
                    goto label_7;
                }
            }
        }
        throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("2D1F180F1A41400B554E1D18121A41050052001F034C00040004060706084D4E0312115219111E41") + v + '.').toString());
    }

    public static final String replace(String s, char c, char c1, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        if(!z) {
            String s1 = s.replace(c, c1);
            Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D41C151D0D0F02024D1D02142E090F134B451C0B072E090F134E"));
            return s1;
        }
        StringBuilder stringBuilder0 = new StringBuilder(s.length());
        for(int v = 0; v < s.length(); ++v) {
            int v1 = s.charAt(v);
            if(CharsKt.equals(((char)v1), c, true)) {
                v1 = c1;
            }
            stringBuilder0.append(((char)v1));
        }
        String s2 = stringBuilder0.toString();
        Intrinsics.checkNotNullExpressionValue(s2, UnityPlayerActivity.adjustValue("3D041F08000625101B0214081346020615130D191918474F85E5D40C05040D0A041524111A19020F474F130A211A02040F09494E"));
        return s2;
    }

    public static final String replace(String s, String s1, String s2, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("011C09370F0D1200"));
        Intrinsics.checkNotNullParameter(s2, UnityPlayerActivity.adjustValue("00151A370F0D1200"));
        int v = 0;
        int v1 = StringsKt.indexOf(s, s1, 0, z);
        if(v1 < 0) {
            return s;
        }
        int v2 = s1.length();
        int v3 = RangesKt.coerceAtLeast(v2, 1);
        int v4 = s.length() - v2 + s2.length();
        if(v4 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder stringBuilder0 = new StringBuilder(v4);
        do {
            stringBuilder0.append(s, v, v1);
            stringBuilder0.append(s2);
            v = v1 + v2;
            if(v1 >= s.length()) {
                break;
            }
            v1 = StringsKt.indexOf(s, s1, v1 + v3, z);
        }
        while(v1 > 0);
        stringBuilder0.append(s, v, s.length());
        String s3 = stringBuilder0.toString();
        Intrinsics.checkNotNullExpressionValue(s3, UnityPlayerActivity.adjustValue("1D041F08000625101B021408134000171517001445150608144952075C4D0D0B0F00111A475E190E3D15150C1C095844"));
        return s3;
    }

    public static String replace$default(String s, char c, char c1, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(s, c, c1, z);
    }

    public static String replace$default(String s, String s1, String s2, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(s, s1, s2, z);
    }

    public static final String replaceFirst(String s, char c, char c1, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        int v = StringsKt.indexOf$default(s, c, 0, z, 2, null);
        return v < 0 ? s : StringsKt.replaceRange(s, v, v + 1, String.valueOf(c1)).toString();
    }

    public static final String replaceFirst(String s, String s1, String s2, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("011C09370F0D1200"));
        Intrinsics.checkNotNullParameter(s2, UnityPlayerActivity.adjustValue("00151A370F0D1200"));
        int v = StringsKt.indexOf$default(s, s1, 0, z, 2, null);
        return v < 0 ? s : StringsKt.replaceRange(s, v, s1.length() + v, s2).toString();
    }

    public static String replaceFirst$default(String s, char c, char c1, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        return StringsKt.replaceFirst(s, c, c1, z);
    }

    public static String replaceFirst$default(String s, String s1, String s2, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        return StringsKt.replaceFirst(s, s1, s2, z);
    }

    public static final List split(CharSequence charSequence0, Pattern pattern0, int v) {
        Intrinsics.checkNotNullParameter(charSequence0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(pattern0, UnityPlayerActivity.adjustValue("1C150A0416"));
        StringsKt.requireNonNegativeLimit(v);
        if(v == 0) {
            v = -1;
        }
        String[] arr_s = pattern0.split(charSequence0, v);
        Intrinsics.checkNotNullExpressionValue(arr_s, UnityPlayerActivity.adjustValue("1C150A04164F14151E07044515060814495207164D4902080A0C064E4D50415E484748434E1501120B410B0C1F070444"));
        return ArraysKt.asList(arr_s);
    }

    public static List split$default(CharSequence charSequence0, Pattern pattern0, int v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        return StringsKt.split(charSequence0, pattern0, v);
    }

    public static final boolean startsWith(String s, String s1, int v, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("1E0208070719"));
        return z ? StringsKt.regionMatches(s, v, s1, 0, s1.length(), true) : s.startsWith(s1, v);
    }

    public static final boolean startsWith(String s, String s1, boolean z) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s1, UnityPlayerActivity.adjustValue("1E0208070719"));
        return z ? StringsKt.regionMatches(s, 0, s1, 0, s1.length(), true) : s.startsWith(s1);
    }

    public static boolean startsWith$default(String s, String s1, int v, boolean z, int v1, Object object0) {
        if((v1 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(s, s1, v, z);
    }

    public static boolean startsWith$default(String s, String s1, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(s, s1, z);
    }

    private static final String substring(String s, int v) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s1 = s.substring(v);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B011B121E151C0809025A1D040C131A280901171659"));
        return s1;
    }

    private static final String substring(String s, int v, int v1) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s1 = s.substring(v, v1);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
        return s1;
    }

    private static final byte[] toByteArray(String s, Charset charset0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        byte[] arr_b = s.getBytes(charset0);
        Intrinsics.checkNotNullExpressionValue(arr_b, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B150B042F181A04144D1106111F120B154E"));
        return arr_b;
    }

    static byte[] toByteArray$default(String s, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        byte[] arr_b = s.getBytes(charset0);
        Intrinsics.checkNotNullExpressionValue(arr_b, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B150B042F181A04144D1106111F120B154E"));
        return arr_b;
    }

    private static final char[] toCharArray(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        char[] arr_c = s.toCharArray();
        Intrinsics.checkNotNullExpressionValue(arr_c, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013305001C20151713175844"));
        return arr_c;
    }

    public static final char[] toCharArray(String s, int v, int v1) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(v, v1, s.length());
        return new char[v1 - v];
    }

    private static final char[] toCharArray(String s, char[] arr_c, int v, int v1, int v2) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("0A151E15070F06111B011E"));
        s.getChars(v1, v2, arr_c, v);
        return arr_c;
    }

    public static char[] toCharArray$default(String s, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = s.length();
        }
        return StringsKt.toCharArray(s, v, v1);
    }

    static char[] toCharArray$default(String s, char[] arr_c, int v, int v1, int v2, int v3, Object object0) {
        if((v3 & 2) != 0) {
            v = 0;
        }
        if((v3 & 4) != 0) {
            v1 = 0;
        }
        if((v3 & 8) != 0) {
            v2 = s.length();
        }
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_c, UnityPlayerActivity.adjustValue("0A151E15070F06111B011E"));
        s.getChars(v1, v2, arr_c, v);
        return arr_c;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s1 = s.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B5844"));
        return s1;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String s, Locale locale0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        String s1 = s.toLowerCase(locale0);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B58010E0D000B005B"));
        return s1;
    }

    private static final Pattern toPattern(String s, int v) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Pattern pattern0 = Pattern.compile(s, v);
        Intrinsics.checkNotNullExpressionValue(pattern0, UnityPlayerActivity.adjustValue("0D1F0011070D024D0606191E4D4E070B04151D59"));
        return pattern0;
    }

    static Pattern toPattern$default(String s, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = 0;
        }
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Pattern pattern0 = Pattern.compile(s, v);
        Intrinsics.checkNotNullExpressionValue(pattern0, UnityPlayerActivity.adjustValue("0D1F0011070D024D0606191E4D4E070B04151D59"));
        return pattern0;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s1 = s.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B5844"));
        return s1;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String s, Locale locale0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        String s1 = s.toUpperCase(locale0);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B58010E0D000B005B"));
        return s1;
    }

    private static final String uppercase(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s1 = s.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B58210E0D000B005C3C3F223547"));
        return s1;
    }

    private static final String uppercase(String s, Locale locale0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        String s1 = s.toUpperCase(locale0);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B58010E0D000B005B"));
        return s1;
    }
}

