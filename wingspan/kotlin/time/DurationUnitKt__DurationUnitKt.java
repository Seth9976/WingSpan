package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0001\u001A\u0010\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\bH\u0001\u001A\f\u0010\u0007\u001A\u00020\b*\u00020\u0001H\u0001¨\u0006\t"}, d2 = {"durationUnitByIsoChar", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[DurationUnit.values().length];
            try {
                arr_v[DurationUnit.NANOSECONDS.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[DurationUnit.MICROSECONDS.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[DurationUnit.MILLISECONDS.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[DurationUnit.SECONDS.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[DurationUnit.MINUTES.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[DurationUnit.HOURS.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[DurationUnit.DAYS.ordinal()] = 7;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final DurationUnit durationUnitByIsoChar(char c, boolean z) {
        if(!z) {
            if(c != 68) {
                throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("271E1B00020803451D1C50180F1D1417151D1C0408054E051217131A19020F4E28342A52001F034C1A080A00521B1E04155441") + c);
            }
            return DurationUnit.DAYS;
        }
        switch(c) {
            case 72: {
                return DurationUnit.HOURS;
            }
            case 77: {
                return DurationUnit.MINUTES;
            }
            case 83: {
                return DurationUnit.SECONDS;
            }
            default: {
                throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("271E1B0002080345161B020C15070E09453B3D3F4D15070C0245070019195B4E") + c);
            }
        }
    }

    public static final DurationUnit durationUnitByShortName(String s) {
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("1D1802131A2F060817"));
        switch(s.hashCode()) {
            case 100: {
                if(s.equals(UnityPlayerActivity.adjustValue("0A"))) {
                    return DurationUnit.DAYS;
                }
                break;
            }
            case 104: {
                if(s.equals(UnityPlayerActivity.adjustValue("06"))) {
                    return DurationUnit.HOURS;
                }
                break;
            }
            case 109: {
                if(s.equals(UnityPlayerActivity.adjustValue("03"))) {
                    return DurationUnit.MINUTES;
                }
                break;
            }
            case 0x73: {
                if(s.equals(UnityPlayerActivity.adjustValue("1D"))) {
                    return DurationUnit.SECONDS;
                }
                break;
            }
            case 0xDA6: {
                if(s.equals(UnityPlayerActivity.adjustValue("0303"))) {
                    return DurationUnit.MILLISECONDS;
                }
                break;
            }
            case 0xDC5: {
                if(s.equals(UnityPlayerActivity.adjustValue("0003"))) {
                    return DurationUnit.NANOSECONDS;
                }
                break;
            }
            case 0xE9E: {
                if(s.equals(UnityPlayerActivity.adjustValue("1B03"))) {
                    return DurationUnit.MICROSECONDS;
                }
            }
        }
        throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("3B1E060F01160945161B020C15070E094507001919411D090817064E1E0C0C0B5B47") + s);
    }

    public static final String shortName(DurationUnit durationUnit0) {
        Intrinsics.checkNotNullParameter(durationUnit0, UnityPlayerActivity.adjustValue("520405081D5F"));
        switch(WhenMappings.$EnumSwitchMapping$0[durationUnit0.ordinal()]) {
            case 1: {
                return UnityPlayerActivity.adjustValue("0003");
            }
            case 2: {
                return UnityPlayerActivity.adjustValue("1B03");
            }
            case 3: {
                return UnityPlayerActivity.adjustValue("0303");
            }
            case 4: {
                return UnityPlayerActivity.adjustValue("1D");
            }
            case 5: {
                return UnityPlayerActivity.adjustValue("03");
            }
            case 6: {
                return UnityPlayerActivity.adjustValue("06");
            }
            case 7: {
                return UnityPlayerActivity.adjustValue("0A");
            }
            default: {
                throw new IllegalStateException((UnityPlayerActivity.adjustValue("3B1E060F01160945070019195B4E") + durationUnit0).toString());
            }
        }
    }
}

