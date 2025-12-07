package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001:\u0001\u000BB\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001A\u00020\bH\u0016J\b\u0010\t\u001A\u00020\nH$R\u0014\u0010\u0002\u001A\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "DoubleTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class AbstractDoubleTimeSource implements TimeSource {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0015\u0010\n\u001A\u00020\u0007H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000B\u0010\fJ\u001B\u0010\r\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u0007H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0006\u001A\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    static final class DoubleTimeMark implements TimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        private DoubleTimeMark(double f, AbstractDoubleTimeSource abstractDoubleTimeSource0, long v) {
            this.startedAt = f;
            this.timeSource = abstractDoubleTimeSource0;
            this.offset = v;
        }

        public DoubleTimeMark(double f, AbstractDoubleTimeSource abstractDoubleTimeSource0, long v, DefaultConstructorMarker defaultConstructorMarker0) {
            this(f, abstractDoubleTimeSource0, v);
        }

        @Override  // kotlin.time.TimeMark
        public long elapsedNow-UwyO8pc() {
            double f = this.timeSource.read();
            DurationUnit durationUnit0 = this.timeSource.getUnit();
            return Duration.minus-LRDsOJo(DurationKt.toDuration(f - this.startedAt, durationUnit0), this.offset);
        }

        @Override  // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return DefaultImpls.hasNotPassedNow(this);
        }

        @Override  // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return DefaultImpls.hasPassedNow(this);
        }

        @Override  // kotlin.time.TimeMark
        public TimeMark minus-LRDsOJo(long v) {
            return DefaultImpls.minus-LRDsOJo(this, v);
        }

        @Override  // kotlin.time.TimeMark
        public TimeMark plus-LRDsOJo(long v) {
            long v1 = Duration.plus-LRDsOJo(this.offset, v);
            return new DoubleTimeMark(this.startedAt, this.timeSource, v1, null);
        }
    }

    private final DurationUnit unit;

    public AbstractDoubleTimeSource(DurationUnit durationUnit0) {
        Intrinsics.checkNotNullParameter(durationUnit0, UnityPlayerActivity.adjustValue("1B1E0415"));
        super();
        this.unit = durationUnit0;
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlin.time.TimeSource
    public TimeMark markNow() {
        return new DoubleTimeMark(this.read(), this, 0L, null);
    }

    protected abstract double read();
}

