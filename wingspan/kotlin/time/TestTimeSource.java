package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001B\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001A\u00020\u0004H\u0014R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000E"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    private final void overflow-LRDsOJo(long v) {
        throw new IllegalStateException(UnityPlayerActivity.adjustValue("3A151E153A080A002101051F020B41100C1E025002170B1301091D195004074E081316521C150C05070F0045") + this.reading + UnityPlayerActivity.adjustValue("00034D081D410601040F1E0E040A41051C52") + Duration.toString-impl(v) + '.');
    }

    public final void plusAssign-LRDsOJo(long v) {
        long v2;
        long v1 = Duration.toLong-impl(v, this.getUnit());
        if(v1 == 0x8000000000000000L || v1 == 0x7FFFFFFFFFFFFFFFL) {
            double f = Duration.toDouble-impl(v, this.getUnit());
            double f1 = ((double)this.reading) + f;
            if(f1 > 9223372036854776000.0 || f1 < -9223372036854776000.0) {
                this.overflow-LRDsOJo(v);
            }
            v2 = (long)f1;
        }
        else {
            v2 = this.reading + v1;
            if((v1 ^ this.reading) >= 0L && (this.reading ^ v2) < 0L) {
                this.overflow-LRDsOJo(v);
            }
        }
        this.reading = v2;
    }

    @Override  // kotlin.time.AbstractLongTimeSource
    protected long read() {
        return this.reading;
    }
}

