package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001A\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface TimeSource {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001A\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\bH\u0016\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Monotonic implements TimeSource {
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0018\b\u0000\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u00020\bH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001A\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001A\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001B\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u001A\u001A\u00020\bH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001B\u0010\u001CJ\u001B\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u001A\u001A\u00020\bH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001E\u0010\u001CJ\u0010\u0010\u001F\u001A\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0012\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006#"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/TimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "equals", "", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "(J)Z", "hasPassedNow", "hasPassedNow-impl", "hashCode", "", "hashCode-impl", "(J)I", "minus", "duration", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
        @JvmInline
        public static final class ValueTimeMark implements TimeMark {
            private final long reading;

            private ValueTimeMark(long v) {
                this.reading = v;
            }

            public static final ValueTimeMark box-impl(long v) {
                return new ValueTimeMark(v);
            }

            public static long constructor-impl(long v) [...] // Inlined contents

            public static long elapsedNow-UwyO8pc(long v) {
                return MonotonicTimeSource.INSTANCE.elapsedFrom-6eNON_k(v);
            }

            @Override  // kotlin.time.TimeMark
            public long elapsedNow-UwyO8pc() {
                return ValueTimeMark.elapsedNow-UwyO8pc(this.reading);
            }

            @Override
            public boolean equals(Object object0) {
                return ValueTimeMark.equals-impl(this.reading, object0);
            }

            public static boolean equals-impl(long v, Object object0) {
                return object0 instanceof ValueTimeMark ? v == ((ValueTimeMark)object0).unbox-impl() : false;
            }

            public static final boolean equals-impl0(long v, long v1) {
                return v == v1;
            }

            @Override  // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return ValueTimeMark.hasNotPassedNow-impl(this.reading);
            }

            public static boolean hasNotPassedNow-impl(long v) {
                return Duration.isNegative-impl(ValueTimeMark.elapsedNow-UwyO8pc(v));
            }

            @Override  // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return ValueTimeMark.hasPassedNow-impl(this.reading);
            }

            public static boolean hasPassedNow-impl(long v) {
                return !Duration.isNegative-impl(ValueTimeMark.elapsedNow-UwyO8pc(v));
            }

            @Override
            public int hashCode() {
                return ValueTimeMark.hashCode-impl(this.reading);
            }

            public static int hashCode-impl(long v) {
                return (int)(v ^ v >>> 0x20);
            }

            public static long minus-LRDsOJo(long v, long v1) {
                long v2 = Duration.unaryMinus-UwyO8pc(v1);
                return MonotonicTimeSource.INSTANCE.adjustReading-6QKq23U(v, v2);
            }

            public long minus-LRDsOJo(long v) {
                return ValueTimeMark.minus-LRDsOJo(this.reading, v);
            }

            @Override  // kotlin.time.TimeMark
            public TimeMark minus-LRDsOJo(long v) {
                return ValueTimeMark.box-impl(this.minus-LRDsOJo(v));
            }

            public static long plus-LRDsOJo(long v, long v1) {
                return MonotonicTimeSource.INSTANCE.adjustReading-6QKq23U(v, v1);
            }

            public long plus-LRDsOJo(long v) {
                return ValueTimeMark.plus-LRDsOJo(this.reading, v);
            }

            @Override  // kotlin.time.TimeMark
            public TimeMark plus-LRDsOJo(long v) {
                return ValueTimeMark.box-impl(this.plus-LRDsOJo(v));
            }

            @Override
            public String toString() {
                return ValueTimeMark.toString-impl(this.reading);
            }

            public static String toString-impl(long v) {
                return UnityPlayerActivity.adjustValue("381101140B350E081723111F0A4613020416071E0A5C") + v + ')';
            }

            public final long unbox-impl() {
                return this.reading;
            }
        }

        public static final Monotonic INSTANCE;

        static {
            Monotonic.INSTANCE = new Monotonic();
        }

        // 去混淆评级： 低(20)
        @Override  // kotlin.time.TimeSource
        public TimeMark markNow() {
            return ValueTimeMark.box-impl(5210700L);
        }

        // 去混淆评级： 低(20)
        public long markNow-z9LOYto() [...] // 潜在的解密器

        @Override
        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
    }

    public static final Companion Companion;

    static {
        TimeSource.Companion = Companion.$$INSTANCE;
    }

    TimeMark markNow();
}

