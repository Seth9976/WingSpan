package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\r¨\u0006\u000E"}, d2 = {"Lkotlin/time/DurationUnit;", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/lang/String;ILjava/util/concurrent/TimeUnit;)V", "getTimeUnit$kotlin_stdlib", "()Ljava/util/concurrent/TimeUnit;", "NANOSECONDS", "MICROSECONDS", "MILLISECONDS", "SECONDS", "MINUTES", "HOURS", "DAYS", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DurationUnit extends Enum {
    private static final DurationUnit[] $VALUES;
    public static final enum DurationUnit DAYS;
    public static final enum DurationUnit HOURS;
    public static final enum DurationUnit MICROSECONDS;
    public static final enum DurationUnit MILLISECONDS;
    public static final enum DurationUnit MINUTES;
    public static final enum DurationUnit NANOSECONDS;
    public static final enum DurationUnit SECONDS;
    private final TimeUnit timeUnit;

    private static final DurationUnit[] $values() [...] // Inlined contents

    static {
        TimeUnit timeUnit0 = TimeUnit.NANOSECONDS;
        DurationUnit.NANOSECONDS = new DurationUnit(UnityPlayerActivity.adjustValue("2031232E3D24242A3C2A23"), 0, timeUnit0);
        TimeUnit timeUnit1 = TimeUnit.MICROSECONDS;
        DurationUnit.MICROSECONDS = new DurationUnit(UnityPlayerActivity.adjustValue("23392E33213222263D20343E"), 1, timeUnit1);
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        DurationUnit.MILLISECONDS = new DurationUnit(UnityPlayerActivity.adjustValue("2339212D273222263D20343E"), 2, timeUnit2);
        TimeUnit timeUnit3 = TimeUnit.SECONDS;
        DurationUnit.SECONDS = new DurationUnit(UnityPlayerActivity.adjustValue("3D352E2E202534"), 3, timeUnit3);
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        DurationUnit.MINUTES = new DurationUnit(UnityPlayerActivity.adjustValue("233923343A2434"), 4, timeUnit4);
        TimeUnit timeUnit5 = TimeUnit.HOURS;
        DurationUnit.HOURS = new DurationUnit(UnityPlayerActivity.adjustValue("263F38333D"), 5, timeUnit5);
        TimeUnit timeUnit6 = TimeUnit.DAYS;
        DurationUnit.DAYS = new DurationUnit(UnityPlayerActivity.adjustValue("2A313432"), 6, timeUnit6);
        DurationUnit.$VALUES = new DurationUnit[]{DurationUnit.NANOSECONDS, DurationUnit.MICROSECONDS, DurationUnit.MILLISECONDS, DurationUnit.SECONDS, DurationUnit.MINUTES, DurationUnit.HOURS, DurationUnit.DAYS};
    }

    private DurationUnit(String s, int v, TimeUnit timeUnit0) {
        super(s, v);
        this.timeUnit = timeUnit0;
    }

    public final TimeUnit getTimeUnit$kotlin_stdlib() {
        return this.timeUnit;
    }

    public static DurationUnit valueOf(String s) {
        return (DurationUnit)Enum.valueOf(DurationUnit.class, s);
    }

    public static DurationUnit[] values() {
        return (DurationUnit[])DurationUnit.$VALUES.clone();
    }
}

