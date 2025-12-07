package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\f\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char c) {
        String s = String.valueOf(c);
        String s1 = UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902");
        Intrinsics.checkNotNull(s, s1);
        String s2 = s.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(s2, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B0601251D110B132404010B58210E0D000B005C3C3F223547"));
        if(s2.length() > 1) {
            if(c != 329) {
                Intrinsics.checkNotNull(s2, s1);
                String s3 = s2.substring(1);
                Intrinsics.checkNotNullExpressionValue(s3, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B011B121E151C0809025A1D040C131A280901171659"));
                Intrinsics.checkNotNull(s3, s1);
                String s4 = s3.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(s4, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B06013C02160B132404010B58210E0D000B005C3C3F223547"));
                return s2.charAt(0) + s4;
            }
            return s2;
        }
        return String.valueOf(Character.toTitleCase(c));
    }
}

