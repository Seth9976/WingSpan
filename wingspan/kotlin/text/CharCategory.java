package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\f\n\u0002\b \b\u0086\u0001\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001-B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0086\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nj\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001Bj\u0002\b\u001Cj\u0002\b\u001Dj\u0002\b\u001Ej\u0002\b\u001Fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b\'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006."}, d2 = {"Lkotlin/text/CharCategory;", "", "value", "", "code", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getValue", "()I", "contains", "", "char", "", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public enum CharCategory {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/text/CharCategory$Companion;", "", "()V", "valueOf", "Lkotlin/text/CharCategory;", "category", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final CharCategory valueOf(int v) {
            if(new IntRange(0, 16).contains(v)) {
                return CharCategory.values()[v];
            }
            if(!new IntRange(18, 30).contains(v)) {
                throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2D111904090E151C524D") + v + UnityPlayerActivity.adjustValue("4E191E41000E1345160B16040F0B0549"));
            }
            return CharCategory.values()[v - 1];
        }
    }

    UNASSIGNED(0, UnityPlayerActivity.adjustValue("2D1E")),
    UPPERCASE_LETTER(1, UnityPlayerActivity.adjustValue("2205")),
    LOWERCASE_LETTER(2, UnityPlayerActivity.adjustValue("221C")),
    TITLECASE_LETTER(3, UnityPlayerActivity.adjustValue("2204")),
    MODIFIER_LETTER(4, UnityPlayerActivity.adjustValue("221D")),
    OTHER_LETTER(5, UnityPlayerActivity.adjustValue("221F")),
    NON_SPACING_MARK(6, UnityPlayerActivity.adjustValue("231E")),
    ENCLOSING_MARK(7, UnityPlayerActivity.adjustValue("2315")),
    COMBINING_SPACING_MARK(8, UnityPlayerActivity.adjustValue("2313")),
    DECIMAL_DIGIT_NUMBER(9, UnityPlayerActivity.adjustValue("2014")),
    LETTER_NUMBER(10, UnityPlayerActivity.adjustValue("201C")),
    OTHER_NUMBER(11, UnityPlayerActivity.adjustValue("201F")),
    SPACE_SEPARATOR(12, UnityPlayerActivity.adjustValue("3403")),
    LINE_SEPARATOR(13, UnityPlayerActivity.adjustValue("341C")),
    PARAGRAPH_SEPARATOR(14, UnityPlayerActivity.adjustValue("3400")),
    CONTROL(15, UnityPlayerActivity.adjustValue("2D13")),
    FORMAT(16, UnityPlayerActivity.adjustValue("2D16")),
    PRIVATE_USE(18, UnityPlayerActivity.adjustValue("2D1F")),
    SURROGATE(19, UnityPlayerActivity.adjustValue("2D03")),
    DASH_PUNCTUATION(20, UnityPlayerActivity.adjustValue("3E14")),
    START_PUNCTUATION(21, UnityPlayerActivity.adjustValue("3E03")),
    END_PUNCTUATION(22, UnityPlayerActivity.adjustValue("3E15")),
    CONNECTOR_PUNCTUATION(23, UnityPlayerActivity.adjustValue("3E13")),
    OTHER_PUNCTUATION(24, UnityPlayerActivity.adjustValue("3E1F")),
    MATH_SYMBOL(25, UnityPlayerActivity.adjustValue("3D1D")),
    CURRENCY_SYMBOL(26, UnityPlayerActivity.adjustValue("3D13")),
    MODIFIER_SYMBOL(27, UnityPlayerActivity.adjustValue("3D1B")),
    OTHER_SYMBOL(28, UnityPlayerActivity.adjustValue("3D1F")),
    INITIAL_QUOTE_PUNCTUATION(29, UnityPlayerActivity.adjustValue("3E19")),
    FINAL_QUOTE_PUNCTUATION(30, UnityPlayerActivity.adjustValue("3E16"));

    public static final Companion Companion;
    private final String code;
    private final int value;

    private static final CharCategory[] $values() [...] // Inlined contents

    static {
        CharCategory.Companion = new Companion(null);
    }

    private CharCategory(int v1, String s1) {
        this.value = v1;
        this.code = s1;
    }

    public final boolean contains(char c) {
        return Character.getType(c) == this.value;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}

