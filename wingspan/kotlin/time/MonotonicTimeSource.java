package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000BJ\u0018\u0010\f\u001A\u00020\t2\u0006\u0010\u0007\u001A\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u000F\u001A\u00020\u0006H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001A\u00020\u0004H\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource;", "()V", "zero", "", "adjustReading", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "timeMark", "duration", "Lkotlin/time/Duration;", "adjustReading-6QKq23U", "(JJ)J", "elapsedFrom", "elapsedFrom-6eNON_k", "(J)J", "markNow", "markNow-z9LOYto", "()J", "read", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MonotonicTimeSource implements TimeSource {
    public static final MonotonicTimeSource INSTANCE;
    private static final long zero;

    static {
        MonotonicTimeSource.INSTANCE = new MonotonicTimeSource();
        MonotonicTimeSource.zero = System.nanoTime();
    }

    public final long adjustReading-6QKq23U(long v, long v1) {
        return ValueTimeMark.constructor-impl(LongSaturatedMathKt.saturatingAdd-pTJri5U(v, v1));
    }

    // 去混淆评级： 低(20)
    public final long elapsedFrom-6eNON_k(long v) {
        return LongSaturatedMathKt.saturatingDiff(-4651500L, v);
    }

    // 去混淆评级： 低(20)
    @Override  // kotlin.time.TimeSource
    public TimeMark markNow() {
        return ValueTimeMark.box-impl(-4660000L);
    }

    // 去混淆评级： 低(20)
    public long markNow-z9LOYto() [...] // 潜在的解密器

    private final long read() [...] // 潜在的解密器

    @Override
    public String toString() {
        return UnityPlayerActivity.adjustValue("3A1900043D0E1217110B583E181D1502085C0011030E3A080A005A4759");
    }
}

