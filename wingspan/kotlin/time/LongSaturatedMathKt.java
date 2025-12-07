package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001A*\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001A\"\u0010\b\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001A\"\u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001A \u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"checkInfiniteSumDefined", "", "longNs", "duration", "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class LongSaturatedMathKt {
    private static final long checkInfiniteSumDefined-PjuGub4(long v, long v1, long v2) {
        if(Duration.isInfinite-impl(v1) && (v ^ v2) < 0L) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("3D05000C070F00451B0016040F07150E00014E1F0B410A080103171C1503154E120E021C1D"));
        }
        return v;
    }

    public static final long saturatingAdd-pTJri5U(long v, long v1) {
        long v2 = Duration.getInWholeNanoseconds-impl(v1);
        if((v - 1L | 1L) == 0x7FFFFFFFFFFFFFFFL) {
            return LongSaturatedMathKt.checkInfiniteSumDefined-PjuGub4(v, v1, v2);
        }
        if((1L | v2 - 1L) == 0x7FFFFFFFFFFFFFFFL) {
            return LongSaturatedMathKt.saturatingAddInHalves-pTJri5U(v, v1);
        }
        long v3 = v + v2;
        if(((v ^ v3) & (v2 ^ v3)) < 0L) {
            return v >= 0L ? 0x7FFFFFFFFFFFFFFFL : 0x8000000000000000L;
        }
        return v3;
    }

    private static final long saturatingAddInHalves-pTJri5U(long v, long v1) {
        long v2 = Duration.div-UwyO8pc(v1, 2);
        return (Duration.getInWholeNanoseconds-impl(v2) - 1L | 1L) == 0x7FFFFFFFFFFFFFFFL ? ((long)(((double)v) + Duration.toDouble-impl(v1, DurationUnit.NANOSECONDS))) : LongSaturatedMathKt.saturatingAdd-pTJri5U(LongSaturatedMathKt.saturatingAdd-pTJri5U(v, v2), v2);
    }

    public static final long saturatingDiff(long v, long v1) {
        if((1L | v1 - 1L) == 0x7FFFFFFFFFFFFFFFL) {
            return Duration.unaryMinus-UwyO8pc(DurationKt.toDuration(v1, DurationUnit.DAYS));
        }
        long v2 = v - v1;
        return ((v2 ^ v) & ~(v2 ^ v1)) >= 0L ? DurationKt.toDuration(v2, DurationUnit.NANOSECONDS) : Duration.plus-LRDsOJo(DurationKt.toDuration(v / 1000000L - v1 / 1000000L, DurationUnit.MILLISECONDS), DurationKt.toDuration(v % 1000000L - v1 % 1000000L, DurationUnit.NANOSECONDS));
    }
}

