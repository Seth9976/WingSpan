package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A \u0010#\u001A\u00020\u00072\u0006\u0010$\u001A\u00020\u00012\u0006\u0010%\u001A\u00020\u0005H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010&\u001A\u0018\u0010\'\u001A\u00020\u00072\u0006\u0010(\u001A\u00020\u0001H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0010\u001A\u0018\u0010)\u001A\u00020\u00072\u0006\u0010*\u001A\u00020\u0001H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0010\u001A\u0018\u0010+\u001A\u00020\u00072\u0006\u0010,\u001A\u00020\u0001H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0010\u001A\u0018\u0010-\u001A\u00020\u00072\u0006\u0010.\u001A\u00020\u0001H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0010\u001A\u0010\u0010/\u001A\u00020\u00012\u0006\u0010*\u001A\u00020\u0001H\u0002\u001A\u0010\u00100\u001A\u00020\u00012\u0006\u0010.\u001A\u00020\u0001H\u0002\u001A \u00101\u001A\u00020\u00072\u0006\u00102\u001A\u0002032\u0006\u00104\u001A\u000205H\u0002\u00F8\u0001\u0000\u00A2\u0006\u0002\u00106\u001A\u0010\u00107\u001A\u00020\u00012\u0006\u00102\u001A\u000203H\u0002\u001A)\u00108\u001A\u00020\u0005*\u0002032\u0006\u00109\u001A\u00020\u00052\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001A)\u0010=\u001A\u000203*\u0002032\u0006\u00109\u001A\u00020\u00052\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001A\u001F\u0010>\u001A\u00020\u0007*\u00020\b2\u0006\u0010?\u001A\u00020\u0007H\u0087\n\u00F8\u0001\u0000\u00A2\u0006\u0004\b@\u0010A\u001A\u001F\u0010>\u001A\u00020\u0007*\u00020\u00052\u0006\u0010?\u001A\u00020\u0007H\u0087\n\u00F8\u0001\u0000\u00A2\u0006\u0004\bB\u0010C\u001A\u001C\u0010D\u001A\u00020\u0007*\u00020\b2\u0006\u0010E\u001A\u00020FH\u0007\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010G\u001A\u001C\u0010D\u001A\u00020\u0007*\u00020\u00052\u0006\u0010E\u001A\u00020FH\u0007\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010H\u001A\u001C\u0010D\u001A\u00020\u0007*\u00020\u00012\u0006\u0010E\u001A\u00020FH\u0007\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010I\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T\u00A2\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T\u00A2\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T\u00A2\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T\u00A2\u0006\u0002\n\u0000\"!\u0010\u0006\u001A\u00020\u0007*\u00020\b8FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f\"!\u0010\u0006\u001A\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\t\u0010\r\u001A\u0004\b\u000B\u0010\u000E\"!\u0010\u0006\u001A\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\t\u0010\u000F\u001A\u0004\b\u000B\u0010\u0010\"!\u0010\u0011\u001A\u00020\u0007*\u00020\b8FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0012\u0010\n\u001A\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001A\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0012\u0010\r\u001A\u0004\b\u0013\u0010\u000E\"!\u0010\u0011\u001A\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0012\u0010\u000F\u001A\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001A\u00020\u0007*\u00020\b8FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0015\u0010\n\u001A\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001A\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0015\u0010\r\u001A\u0004\b\u0016\u0010\u000E\"!\u0010\u0014\u001A\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0015\u0010\u000F\u001A\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001A\u00020\u0007*\u00020\b8FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0018\u0010\n\u001A\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001A\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0018\u0010\r\u001A\u0004\b\u0019\u0010\u000E\"!\u0010\u0017\u001A\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u0018\u0010\u000F\u001A\u0004\b\u0019\u0010\u0010\"!\u0010\u001A\u001A\u00020\u0007*\u00020\b8FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u001B\u0010\n\u001A\u0004\b\u001C\u0010\f\"!\u0010\u001A\u001A\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u001B\u0010\r\u001A\u0004\b\u001C\u0010\u000E\"!\u0010\u001A\u001A\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u001B\u0010\u000F\u001A\u0004\b\u001C\u0010\u0010\"!\u0010\u001D\u001A\u00020\u0007*\u00020\b8FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u001E\u0010\n\u001A\u0004\b\u001F\u0010\f\"!\u0010\u001D\u001A\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u001E\u0010\r\u001A\u0004\b\u001F\u0010\u000E\"!\u0010\u001D\u001A\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b\u001E\u0010\u000F\u001A\u0004\b\u001F\u0010\u0010\"!\u0010 \u001A\u00020\u0007*\u00020\b8FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b!\u0010\n\u001A\u0004\b\"\u0010\f\"!\u0010 \u001A\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b!\u0010\r\u001A\u0004\b\"\u0010\u000E\"!\u0010 \u001A\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00F8\u0001\u0000\u00A2\u0006\f\u0012\u0004\b!\u0010\u000F\u001A\u0004\b\"\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class DurationKt {
    public static final long MAX_MILLIS = 0x3FFFFFFFFFFFFFFFL;
    public static final long MAX_NANOS = 0x3FFFFFFFFFFA14BFL;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final long access$millisToNanos(long v) {
        return v * 1000000L;
    }

    public static final long access$nanosToMillis(long v) {
        return v / 1000000L;
    }

    private static final long durationOf(long v, int v1) {
        return Duration.constructor-impl((v << 1) + ((long)v1));
    }

    private static final long durationOfMillis(long v) {
        return Duration.constructor-impl((v << 1) + 1L);
    }

    // 去混淆评级： 低(20)
    private static final long durationOfMillisNormalized(long v) {
        return new LongRange(-4611686018426L, 4611686018426L).contains(v) ? DurationKt.durationOfNanos(v * 1000000L) : DurationKt.durationOfMillis(RangesKt.coerceIn(v, 0xC000000000000001L, 0x3FFFFFFFFFFFFFFFL));
    }

    private static final long durationOfNanos(long v) {
        return Duration.constructor-impl(v << 1);
    }

    // 去混淆评级： 低(20)
    private static final long durationOfNanosNormalized(long v) {
        return new LongRange(0xC00000000005EB41L, 0x3FFFFFFFFFFA14BFL).contains(v) ? DurationKt.durationOfNanos(v) : DurationKt.durationOfMillis(v / 1000000L);
    }

    public static final long getDays(double f) {
        return DurationKt.toDuration(f, DurationUnit.DAYS);
    }

    public static final long getDays(int v) {
        return DurationKt.toDuration(v, DurationUnit.DAYS);
    }

    public static final long getDays(long v) {
        return DurationKt.toDuration(v, DurationUnit.DAYS);
    }

    @Deprecated(message = "Use \'Double.days\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getDays$annotations(double f) {
    }

    @Deprecated(message = "Use \'Int.days\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getDays$annotations(int v) {
    }

    @Deprecated(message = "Use \'Long.days\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getDays$annotations(long v) {
    }

    public static final long getHours(double f) {
        return DurationKt.toDuration(f, DurationUnit.HOURS);
    }

    public static final long getHours(int v) {
        return DurationKt.toDuration(v, DurationUnit.HOURS);
    }

    public static final long getHours(long v) {
        return DurationKt.toDuration(v, DurationUnit.HOURS);
    }

    @Deprecated(message = "Use \'Double.hours\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getHours$annotations(double f) {
    }

    @Deprecated(message = "Use \'Int.hours\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getHours$annotations(int v) {
    }

    @Deprecated(message = "Use \'Long.hours\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getHours$annotations(long v) {
    }

    public static final long getMicroseconds(double f) {
        return DurationKt.toDuration(f, DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(int v) {
        return DurationKt.toDuration(v, DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(long v) {
        return DurationKt.toDuration(v, DurationUnit.MICROSECONDS);
    }

    @Deprecated(message = "Use \'Double.microseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMicroseconds$annotations(double f) {
    }

    @Deprecated(message = "Use \'Int.microseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMicroseconds$annotations(int v) {
    }

    @Deprecated(message = "Use \'Long.microseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMicroseconds$annotations(long v) {
    }

    public static final long getMilliseconds(double f) {
        return DurationKt.toDuration(f, DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(int v) {
        return DurationKt.toDuration(v, DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(long v) {
        return DurationKt.toDuration(v, DurationUnit.MILLISECONDS);
    }

    @Deprecated(message = "Use \'Double.milliseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMilliseconds$annotations(double f) {
    }

    @Deprecated(message = "Use \'Int.milliseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMilliseconds$annotations(int v) {
    }

    @Deprecated(message = "Use \'Long.milliseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMilliseconds$annotations(long v) {
    }

    public static final long getMinutes(double f) {
        return DurationKt.toDuration(f, DurationUnit.MINUTES);
    }

    public static final long getMinutes(int v) {
        return DurationKt.toDuration(v, DurationUnit.MINUTES);
    }

    public static final long getMinutes(long v) {
        return DurationKt.toDuration(v, DurationUnit.MINUTES);
    }

    @Deprecated(message = "Use \'Double.minutes\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMinutes$annotations(double f) {
    }

    @Deprecated(message = "Use \'Int.minutes\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMinutes$annotations(int v) {
    }

    @Deprecated(message = "Use \'Long.minutes\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getMinutes$annotations(long v) {
    }

    public static final long getNanoseconds(double f) {
        return DurationKt.toDuration(f, DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(int v) {
        return DurationKt.toDuration(v, DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(long v) {
        return DurationKt.toDuration(v, DurationUnit.NANOSECONDS);
    }

    @Deprecated(message = "Use \'Double.nanoseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getNanoseconds$annotations(double f) {
    }

    @Deprecated(message = "Use \'Int.nanoseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getNanoseconds$annotations(int v) {
    }

    @Deprecated(message = "Use \'Long.nanoseconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getNanoseconds$annotations(long v) {
    }

    public static final long getSeconds(double f) {
        return DurationKt.toDuration(f, DurationUnit.SECONDS);
    }

    public static final long getSeconds(int v) {
        return DurationKt.toDuration(v, DurationUnit.SECONDS);
    }

    public static final long getSeconds(long v) {
        return DurationKt.toDuration(v, DurationUnit.SECONDS);
    }

    @Deprecated(message = "Use \'Double.seconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getSeconds$annotations(double f) {
    }

    @Deprecated(message = "Use \'Int.seconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getSeconds$annotations(int v) {
    }

    @Deprecated(message = "Use \'Long.seconds\' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static void getSeconds$annotations(long v) {
    }

    private static final long millisToNanos(long v) [...] // Inlined contents

    private static final long nanosToMillis(long v) [...] // Inlined contents

    private static final long parseDuration(String s, boolean z) {
        int v13;
        int v8;
        int v2;
        int v = s.length();
        if(v == 0) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("3A1808411D15150C1C095004124E040A150617"));
        }
        long v1 = 0L;
        String s1 = UnityPlayerActivity.adjustValue("271E0B080008131C");
        switch(s.charAt(0)) {
            case 43: {
                v2 = 1;
                break;
            }
            case 45: {
                v2 = 1;
                break;
            }
            default: {
                v2 = 0;
            }
        }
        int v3 = v2 <= 0 ? 0 : 1;
        int v4 = v3 == 0 || !StringsKt.startsWith$default(s, '-', false, 2, null) ? 0 : 1;
        String s2 = UnityPlayerActivity.adjustValue("201F4D02010C170A1C0B1E1912");
        if(v <= v2) {
            throw new IllegalArgumentException(s2);
        }
        String s3 = UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B011B121E151C0809025A1D040C131A280901171659");
        String s4 = UnityPlayerActivity.adjustValue("3B1E08191E040411170A5002130A0415451D085009141C00130C1D00500E0E0311080B1700041E");
        String s5 = UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E");
        if(s.charAt(v2) == 80) {
            int v5 = v2 + 1;
            if(v5 == v) {
                throw new IllegalArgumentException();
            }
            boolean z1 = false;
            DurationUnit durationUnit0 = null;
            while(v5 < v) {
                if(s.charAt(v5) == 84) {
                    if(!z1) {
                        ++v5;
                        if(v5 != v) {
                            z1 = true;
                            continue;
                        }
                    }
                    throw new IllegalArgumentException();
                }
                int v6 = v5;
                while(true) {
                    if(v6 < s.length()) {
                        int v7 = s.charAt(v6);
                        v8 = v4;
                        if(new CharRange('0', '9').contains(((char)v7)) || StringsKt.contains$default(UnityPlayerActivity.adjustValue("455D43"), ((char)v7), false, 2, null)) {
                            ++v6;
                            v4 = v8;
                            continue;
                        }
                        else {
                            break;
                        }
                    }
                    v8 = v4;
                    break;
                }
                Intrinsics.checkNotNull(s, "null cannot be cast to non-null type java.lang.String");
                String s6 = s.substring(v5, v6);
                Intrinsics.checkNotNullExpressionValue(s6, s5);
                if(s6.length() == 0) {
                    throw new IllegalArgumentException();
                }
                int v9 = v5 + s6.length();
                if(v9 < 0 || v9 > StringsKt.getLastIndex(s)) {
                    throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("23191E12070F00450700191941080E1545040F1C18044E") + s6);
                }
                v5 = v9 + 1;
                DurationUnit durationUnit1 = DurationUnitKt.durationUnitByIsoChar(s.charAt(v9), z1);
                if(durationUnit0 != null && durationUnit0.compareTo(durationUnit1) <= 0) {
                    throw new IllegalArgumentException(s4);
                }
                int v10 = StringsKt.indexOf$default(s6, '.', 0, false, 6, null);
                if(durationUnit1 != DurationUnit.SECONDS || v10 <= 0) {
                    v1 = Duration.plus-LRDsOJo(v1, DurationKt.toDuration(DurationKt.parseOverLongIsoComponent(s6), durationUnit1));
                }
                else {
                    Intrinsics.checkNotNull(s6, "null cannot be cast to non-null type java.lang.String");
                    String s7 = s6.substring(0, v10);
                    Intrinsics.checkNotNullExpressionValue(s7, s5);
                    long v11 = Duration.plus-LRDsOJo(v1, DurationKt.toDuration(DurationKt.parseOverLongIsoComponent(s7), durationUnit1));
                    Intrinsics.checkNotNull(s6, "null cannot be cast to non-null type java.lang.String");
                    String s8 = s6.substring(v10);
                    Intrinsics.checkNotNullExpressionValue(s8, s3);
                    v1 = Duration.plus-LRDsOJo(v11, DurationKt.toDuration(Double.parseDouble(s8), durationUnit1));
                }
                durationUnit0 = durationUnit1;
                v4 = v8;
            }
            return v4 == 0 ? v1 : Duration.unaryMinus-UwyO8pc(v1);
        }
        if(z) {
            throw new IllegalArgumentException();
        }
        if(StringsKt.regionMatches(s, v2, s1, 0, Math.max(v - v2, 8), true)) {
            return v4 == 0 ? 0x7FFFFFFFFFFFFFFFL : Duration.unaryMinus-UwyO8pc(0x7FFFFFFFFFFFFFFFL);
        }
        int v12 = v3 ^ 1;
        if(v3 == 0 || s.charAt(v2) != 40 || StringsKt.last(s) != 41) {
            v13 = v;
        }
        else {
            ++v2;
            if(v2 == v - 1) {
                throw new IllegalArgumentException(s2);
            }
            v13 = v - 1;
            v12 = 1;
        }
        DurationUnit durationUnit2 = null;
        for(boolean z2 = false; v2 < v13; z2 = true) {
            if(z2 && v12 != 0) {
                while(v2 < s.length() && s.charAt(v2) == 0x20) {
                    ++v2;
                }
            }
            int v14;
            for(v14 = v2; v14 < s.length(); ++v14) {
                int v15 = s.charAt(v14);
                if(!new CharRange('0', '9').contains(((char)v15)) && v15 != 46) {
                    break;
                }
            }
            Intrinsics.checkNotNull(s, "null cannot be cast to non-null type java.lang.String");
            String s9 = s.substring(v2, v14);
            Intrinsics.checkNotNullExpressionValue(s9, s5);
            if(s9.length() == 0) {
                throw new IllegalArgumentException();
            }
            int v16 = v2 + s9.length();
            int v17;
            for(v17 = v16; v17 < s.length() && new CharRange('a', 'z').contains(s.charAt(v17)); ++v17) {
            }
            Intrinsics.checkNotNull(s, "null cannot be cast to non-null type java.lang.String");
            String s10 = s.substring(v16, v17);
            Intrinsics.checkNotNullExpressionValue(s10, s5);
            v2 = v16 + s10.length();
            DurationUnit durationUnit3 = DurationUnitKt.durationUnitByShortName(s10);
            if(durationUnit2 != null && durationUnit2.compareTo(durationUnit3) <= 0) {
                throw new IllegalArgumentException(s4);
            }
            int v18 = StringsKt.indexOf$default(s9, '.', 0, false, 6, null);
            if(v18 > 0) {
                Intrinsics.checkNotNull(s9, "null cannot be cast to non-null type java.lang.String");
                String s11 = s9.substring(0, v18);
                Intrinsics.checkNotNullExpressionValue(s11, s5);
                long v19 = Duration.plus-LRDsOJo(v1, DurationKt.toDuration(Long.parseLong(s11), durationUnit3));
                Intrinsics.checkNotNull(s9, "null cannot be cast to non-null type java.lang.String");
                String s12 = s9.substring(v18);
                Intrinsics.checkNotNullExpressionValue(s12, s3);
                v1 = Duration.plus-LRDsOJo(v19, DurationKt.toDuration(Double.parseDouble(s12), durationUnit3));
                if(v2 < v13) {
                    throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("28020C021A08080B1302500E0E0311080B1700044D0C1B121345100B5001001D15"));
                }
            }
            else {
                v1 = Duration.plus-LRDsOJo(v1, DurationKt.toDuration(Long.parseLong(s9), durationUnit3));
            }
            durationUnit2 = durationUnit3;
        }
        return v4 == 0 ? v1 : Duration.unaryMinus-UwyO8pc(v1);
    }

    private static final long parseOverLongIsoComponent(String s) {
        int v = s.length();
        int v1 = v <= 0 || !StringsKt.contains$default(UnityPlayerActivity.adjustValue("455D"), s.charAt(0), false, 2, null) ? 0 : 1;
        if(v - v1 > 16) {
            boolean z = true;
            IntRange intRange0 = new IntRange(v1, StringsKt.getLastIndex(s));
            if(!(intRange0 instanceof Collection) || !((Collection)intRange0).isEmpty()) {
                Iterator iterator0 = intRange0.iterator();
                while(iterator0.hasNext()) {
                    int v2 = ((IntIterator)iterator0).nextInt();
                    if(!new CharRange('0', '9').contains(s.charAt(v2))) {
                        z = false;
                        break;
                    }
                }
            }
            if(z) {
                return s.charAt(0) == 45 ? 0x8000000000000000L : 0x7FFFFFFFFFFFFFFFL;
            }
        }
        if(StringsKt.startsWith$default(s, UnityPlayerActivity.adjustValue("45"), false, 2, null)) {
            s = StringsKt.drop(s, 1);
        }
        return Long.parseLong(s);
    }

    private static final int skipWhile(String s, int v, Function1 function10) {
        while(v < s.length() && ((Boolean)function10.invoke(Character.valueOf(s.charAt(v)))).booleanValue()) {
            ++v;
        }
        return v;
    }

    private static final String substringWhile(String s, int v, Function1 function10) {
        int v1;
        for(v1 = v; v1 < s.length() && ((Boolean)function10.invoke(Character.valueOf(s.charAt(v1)))).booleanValue(); ++v1) {
        }
        Intrinsics.checkNotNull(s, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3E151C080902"));
        String s1 = s.substring(v, v1);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
        return s1;
    }

    private static final long times-kIfJnKk(double f, long v) {
        return Duration.times-UwyO8pc(v, f);
    }

    private static final long times-mvk6XK0(int v, long v1) {
        return Duration.times-UwyO8pc(v1, v);
    }

    public static final long toDuration(double f, DurationUnit durationUnit0) {
        Intrinsics.checkNotNullParameter(durationUnit0, UnityPlayerActivity.adjustValue("1B1E0415"));
        double f1 = DurationUnitKt.convertDurationUnit(f, durationUnit0, DurationUnit.NANOSECONDS);
        if(!Double.isNaN(f1) == 0) {
            throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2A051F001A08080B52181101140B4104041C001F19410C04472B13205E").toString());
        }
        long v = MathKt.roundToLong(f1);
        return new LongRange(0xC00000000005EB41L, 0x3FFFFFFFFFFA14BFL).contains(v) ? DurationKt.durationOfNanos(v) : DurationKt.durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(f, durationUnit0, DurationUnit.MILLISECONDS)));
    }

    public static final long toDuration(int v, DurationUnit durationUnit0) {
        Intrinsics.checkNotNullParameter(durationUnit0, UnityPlayerActivity.adjustValue("1B1E0415"));
        return durationUnit0.compareTo(DurationUnit.SECONDS) > 0 ? DurationKt.toDuration(v, durationUnit0) : DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(v, durationUnit0, DurationUnit.NANOSECONDS));
    }

    public static final long toDuration(long v, DurationUnit durationUnit0) {
        Intrinsics.checkNotNullParameter(durationUnit0, UnityPlayerActivity.adjustValue("1B1E0415"));
        long v1 = DurationUnitKt.convertDurationUnitOverflow(0x3FFFFFFFFFFA14BFL, DurationUnit.NANOSECONDS, durationUnit0);
        return new LongRange(-v1, v1).contains(v) ? DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(v, durationUnit0, DurationUnit.NANOSECONDS)) : DurationKt.durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(v, durationUnit0, DurationUnit.MILLISECONDS), 0xC000000000000001L, 0x3FFFFFFFFFFFFFFFL));
    }
}

