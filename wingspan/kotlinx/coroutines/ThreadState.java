package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u001C\u0012\b\b\u001D\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u00050\u001Bj\u0002`\u001EB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u001A\u0010\u000F\u001A\u00020\u00052\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0007R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001A\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0015R\u001C\u0010\u0018\u001A\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "clearInterrupt", "()V", "", "state", "", "invalidState", "(I)Ljava/lang/Void;", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "setup", "Lkotlinx/coroutines/DisposableHandle;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "targetThread", "Ljava/lang/Thread;", "kotlinx-coroutines-core", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
final class ThreadState implements Function1 {
    private volatile int _state;
    private static final AtomicIntegerFieldUpdater _state$FU;
    private DisposableHandle cancelHandle;
    private final Job job;
    private final Thread targetThread;

    static {
        String s = UnityPlayerActivity.adjustValue("310319001A04");
        ThreadState._state$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, s);
    }

    public ThreadState(Job job0) {
        this.job = job0;
        this._state = 0;
        this.targetThread = Thread.currentThread();
    }

    public final void clearInterrupt() {
        while(true) {
            int v = this._state;
            switch(v) {
                case 0: {
                    if(ThreadState._state$FU.compareAndSet(this, 0, 1)) {
                        DisposableHandle disposableHandle0 = this.cancelHandle;
                        if(disposableHandle0 != null) {
                            disposableHandle0.dispose();
                        }
                        return;
                    }
                    if(false) {
                        Thread.interrupted();
                        return;
                    }
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    Thread.interrupted();
                    return;
                }
                default: {
                    this.invalidState(v);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    private final Void invalidState(int v) {
        throw new IllegalStateException((UnityPlayerActivity.adjustValue("271C010409000B45011A1119044E") + v).toString());
    }

    @Override  // kotlin.jvm.functions.Function1
    public Object invoke(Object object0) {
        this.invoke(((Throwable)object0));
        return Unit.INSTANCE;
    }

    public void invoke(Throwable throwable0) {
        do {
            int v = this._state;
            if(v != 0) {
                if(v != 1 && v != 2 && v != 3) {
                    this.invalidState(v);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        }
        while(!ThreadState._state$FU.compareAndSet(this, 0, 2));
        this.targetThread.interrupt();
        this._state = 3;
    }

    public final void setup() {
        this.cancelHandle = this.job.invokeOnCompletion(true, true, this);
    alab1:
        while(true) {
            int v = this._state;
            switch(v) {
                case 0: {
                    if(!ThreadState._state$FU.compareAndSet(this, 0, 0)) {
                        break;
                    }
                    break alab1;
                }
                case 2: 
                case 3: {
                    return;
                }
                default: {
                    this.invalidState(v);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }
}

