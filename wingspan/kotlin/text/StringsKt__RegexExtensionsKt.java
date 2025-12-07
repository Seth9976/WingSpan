package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\b\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0087\b¨\u0006\u0007"}, d2 = {"toRegex", "Lkotlin/text/Regex;", "", "options", "", "Lkotlin/text/RegexOption;", "option", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__RegexExtensionsKt extends StringsKt__RegexExtensionsJVMKt {
    private static final Regex toRegex(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new Regex(s);
    }

    private static final Regex toRegex(String s, Set set0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(set0, UnityPlayerActivity.adjustValue("01001908010F14"));
        return new Regex(s, set0);
    }

    private static final Regex toRegex(String s, RegexOption regexOption0) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(regexOption0, UnityPlayerActivity.adjustValue("01001908010F"));
        return new Regex(s, regexOption0);
    }
}

