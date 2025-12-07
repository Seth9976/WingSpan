package kotlin.text.jdk8;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0017\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0002¨\u0006\u0005"}, d2 = {"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 7, 1}, pn = "kotlin.text", xi = 0x30)
public final class RegexExtensionsJDK8Kt {
    public static final MatchGroup get(MatchGroupCollection matchGroupCollection0, String s) {
        Intrinsics.checkNotNullParameter(matchGroupCollection0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("00110004"));
        MatchNamedGroupCollection matchNamedGroupCollection0 = matchGroupCollection0 instanceof MatchNamedGroupCollection ? ((MatchNamedGroupCollection)matchGroupCollection0) : null;
        if(matchNamedGroupCollection0 == null) {
            throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3C1519130704110C1C09500A1301141716520C094D0F0F0C02451B1D50030E1A411410021E1F1F150B05470A1C4E0405081D411709131A160213034F"));
        }
        return matchNamedGroupCollection0.get(s);
    }
}

