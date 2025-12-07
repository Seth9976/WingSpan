package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0001\u001A\u0018\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0000\u001A\r\u0010\u000E\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0010\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0011\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0012\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0013\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0014\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0015\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0016\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0017\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0018\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u0019\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u001A\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\r\u0010\u001B\u001A\u00020\u000F*\u00020\u0002H\u0087\b\u001A\n\u0010\u001C\u001A\u00020\u000F*\u00020\u0002\u001A\r\u0010\u001D\u001A\u00020\u001E*\u00020\u0002H\u0087\b\u001A\u0014\u0010\u001D\u001A\u00020\u001E*\u00020\u00022\u0006\u0010\u001F\u001A\u00020 H\u0007\u001A\r\u0010!\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\u0014\u0010\"\u001A\u00020\u001E*\u00020\u00022\u0006\u0010\u001F\u001A\u00020 H\u0007\u001A\r\u0010#\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\r\u0010$\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\r\u0010%\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\r\u0010&\u001A\u00020\u0002*\u00020\u0002H\u0087\b\u001A\r\u0010\'\u001A\u00020\u001E*\u00020\u0002H\u0087\b\u001A\u0014\u0010\'\u001A\u00020\u001E*\u00020\u00022\u0006\u0010\u001F\u001A\u00020 H\u0007\u001A\r\u0010(\u001A\u00020\u0002*\u00020\u0002H\u0087\b\"\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00028F\u00A2\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001A\u00020\u0006*\u00020\u00028F\u00A2\u0006\u0006\u001A\u0004\b\u0007\u0010\b\u00A8\u0006)"}, d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    public static final int checkRadix(int v) {
        if(!new IntRange(2, 36).contains(v)) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("1C1109081641") + v + UnityPlayerActivity.adjustValue("4E070C124E0F081152071E4D170F0D0E01521C1103060B41") + new IntRange(2, 36));
        }
        return v;
    }

    public static final int digitOf(char c, int v) {
        return Character.digit(c, v);
    }

    public static final CharCategory getCategory(char c) {
        return CharCategory.Companion.valueOf(Character.getType(c));
    }

    public static final CharDirectionality getDirectionality(char c) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(c));
    }

    private static final boolean isDefined(char c) {
        return Character.isDefined(c);
    }

    private static final boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static final boolean isHighSurrogate(char c) {
        return Character.isHighSurrogate(c);
    }

    private static final boolean isISOControl(char c) {
        return Character.isISOControl(c);
    }

    private static final boolean isIdentifierIgnorable(char c) {
        return Character.isIdentifierIgnorable(c);
    }

    private static final boolean isJavaIdentifierPart(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    private static final boolean isJavaIdentifierStart(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    private static final boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    private static final boolean isLetterOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static final boolean isLowSurrogate(char c) {
        return Character.isLowSurrogate(c);
    }

    private static final boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    private static final boolean isTitleCase(char c) {
        return Character.isTitleCase(c);
    }

    private static final boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    // 去混淆评级： 低(20)
    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    private static final String lowercase(char c) {
        String s = String.valueOf(c);
        Intrinsics.checkNotNull(s, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
        String s1 = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B58210E0D000B005C3C3F223547"));
        return s1;
    }

    public static final String lowercase(char c, Locale locale0) {
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        String s = String.valueOf(c);
        Intrinsics.checkNotNull(s, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
        String s1 = s.toLowerCase(locale0);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B58010E0D000B005B"));
        return s1;
    }

    private static final char lowercaseChar(char c) {
        return Character.toLowerCase(c);
    }

    public static final String titlecase(char c, Locale locale0) {
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        String s = CharsKt.uppercase(c, locale0);
        String s1 = UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902");
        if(s.length() > 1) {
            if(c != 329) {
                Intrinsics.checkNotNull(s, s1);
                String s2 = s.substring(1);
                Intrinsics.checkNotNullExpressionValue(s2, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B011B121E151C0809025A1D040C131A280901171659"));
                Intrinsics.checkNotNull(s2, s1);
                String s3 = s2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(s3, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B58210E0D000B005C3C3F223547"));
                return s.charAt(0) + s3;
            }
            return s;
        }
        String s4 = String.valueOf(c);
        Intrinsics.checkNotNull(s4, s1);
        String s5 = s4.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(s5, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B58210E0D000B005C3C3F223547"));
        return Intrinsics.areEqual(s, s5) ? String.valueOf(Character.toTitleCase(c)) : s;
    }

    private static final char titlecaseChar(char c) {
        return Character.toTitleCase(c);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toTitleCase(char c) {
        return Character.toTitleCase(c);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toUpperCase(char c) {
        return Character.toUpperCase(c);
    }

    private static final String uppercase(char c) {
        String s = String.valueOf(c);
        Intrinsics.checkNotNull(s, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
        String s1 = s.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B58210E0D000B005C3C3F223547"));
        return s1;
    }

    public static final String uppercase(char c, Locale locale0) {
        Intrinsics.checkNotNullParameter(locale0, UnityPlayerActivity.adjustValue("021F0E000204"));
        String s = String.valueOf(c);
        Intrinsics.checkNotNull(s, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
        String s1 = s.toUpperCase(locale0);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B58010E0D000B005B"));
        return s1;
    }

    private static final char uppercaseChar(char c) {
        return Character.toUpperCase(c);
    }
}

