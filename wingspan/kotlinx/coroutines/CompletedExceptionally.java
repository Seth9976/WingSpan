package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0010\u0018\u00002\u00020\u000FB\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u0002\u001A\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\r\u0010\b¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class CompletedExceptionally {
    private volatile int _handled;
    private static final AtomicIntegerFieldUpdater _handled$FU;
    public final Throwable cause;

    static {
        String s = UnityPlayerActivity.adjustValue("31180C0F0A0D0201");
        CompletedExceptionally._handled$FU = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, s);
    }

    public CompletedExceptionally(Throwable throwable0, boolean z) {
        this.cause = throwable0;
        this._handled = z;
    }

    public CompletedExceptionally(Throwable throwable0, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            z = false;
        }
        this(throwable0, z);
    }

    public final boolean getHandled() {
        return this._handled;
    }

    public final boolean makeHandled() {
        return CompletedExceptionally._handled$FU.compareAndSet(this, 0, 1);
    }

    @Override
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '[' + this.cause + ']';
    }
}

