package kotlinx.coroutines;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import jeb.synthetic.FIN;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007\u00A2\u0006\u0004\b\u0001\u0010\u0002J\u000F\u0010\u0004\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001A\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\t2\n\u0010\u000B\u001A\u00060\u0005j\u0002`\u0006\u00A2\u0006\u0004\b\f\u0010\rJ\u001B\u0010\u000F\u001A\u00020\u00032\n\u0010\u000E\u001A\u00060\u0005j\u0002`\u0006H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001B\u0010\u0012\u001A\u00020\u00112\n\u0010\u000E\u001A\u00060\u0005j\u0002`\u0006H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0002J\u000F\u0010\u0018\u001A\u00020\u0003H\u0004\u00A2\u0006\u0004\b\u0018\u0010\u0002J\u001D\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u001B\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b\u001F\u0010 J#\u0010#\u001A\u00020\"2\u0006\u0010!\u001A\u00020\u00142\n\u0010\u000B\u001A\u00060\u0005j\u0002`\u0006H\u0004\u00A2\u0006\u0004\b#\u0010$J%\u0010\'\u001A\u00020\u00032\u0006\u0010!\u001A\u00020\u00142\f\u0010&\u001A\b\u0012\u0004\u0012\u00020\u00030%H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b+\u0010\u0002R$\u0010-\u001A\u00020\u00112\u0006\u0010,\u001A\u00020\u00118B@BX\u0082\u000E\u00A2\u0006\f\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001A\u00020\u00118TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\b1\u0010.R\u0014\u00103\u001A\u00020\u00148TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\b2\u0010\u0016\u00A8\u00068"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001A\u00020\u0006H\u0016J\b\u0010\t\u001A\u00020\nH\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation cont;

        public DelayedResumeTask(long v, CancellableContinuation cancellableContinuation0) {
            super(v);
            this.cont = cancellableContinuation0;
        }

        @Override
        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        @Override  // kotlinx.coroutines.EventLoopImplBase$DelayedTask
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001A\u00020\tH\u0016J\b\u0010\n\u001A\u00020\u000BH\u0016R\u0012\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long v, Runnable runnable0) {
            super(v);
            this.block = runnable0;
        }

        @Override
        public void run() {
            this.block.run();
        }

        @Override  // kotlinx.coroutines.EventLoopImplBase$DelayedTask
        public String toString() {
            return super.toString() + this.block;
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u0000H\u0096\u0002J\u0006\u0010\u001A\u001A\u00020\u001BJ\u001E\u0010\u001C\u001A\u00020\u00132\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!J\u000E\u0010\"\u001A\u00020#2\u0006\u0010\u001D\u001A\u00020\u0007J\b\u0010$\u001A\u00020%H\u0016R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R0\u0010\r\u001A\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000B\u001A\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u00020\u0013X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001A\u00020\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static abstract class DelayedTask implements Comparable, Runnable, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;
        private int index;
        public long nanoTime;

        public DelayedTask(long v) {
            this.nanoTime = v;
            this.index = -1;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((DelayedTask)object0));
        }

        public int compareTo(DelayedTask eventLoopImplBase$DelayedTask0) {
            int v = Long.compare(this.nanoTime - eventLoopImplBase$DelayedTask0.nanoTime, 0L);
            if(v > 0) {
                return 1;
            }
            return v >= 0 ? 0 : -1;
        }

        @Override  // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            synchronized(this) {
                Object object0 = this._heap;
                if(object0 == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    return;
                }
                DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = object0 instanceof DelayedTaskQueue ? ((DelayedTaskQueue)object0) : null;
                if(eventLoopImplBase$DelayedTaskQueue0 != null) {
                    eventLoopImplBase$DelayedTaskQueue0.remove(this);
                }
                this._heap = EventLoop_commonKt.access$getDISPOSED_TASK$p();
            }
        }

        // 去混淆评级： 低(20)
        @Override  // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap getHeap() {
            return this._heap instanceof ThreadSafeHeap ? ((ThreadSafeHeap)this._heap) : null;
        }

        @Override  // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        public final int scheduleTask(long v, DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0, EventLoopImplBase eventLoopImplBase0) {
            synchronized(this) {
                if(this._heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    return 2;
                }
                synchronized(eventLoopImplBase$DelayedTaskQueue0) {
                    DelayedTask eventLoopImplBase$DelayedTask0 = (DelayedTask)eventLoopImplBase$DelayedTaskQueue0.firstImpl();
                    if(eventLoopImplBase0.isCompleted()) {
                        return 1;
                    }
                    if(eventLoopImplBase$DelayedTask0 == null) {
                        eventLoopImplBase$DelayedTaskQueue0.timeNow = v;
                    }
                    else {
                        long v3 = eventLoopImplBase$DelayedTask0.nanoTime;
                        if(v3 - v < 0L) {
                            v = v3;
                        }
                        if(v - eventLoopImplBase$DelayedTaskQueue0.timeNow > 0L) {
                            eventLoopImplBase$DelayedTaskQueue0.timeNow = v;
                        }
                    }
                    if(this.nanoTime - eventLoopImplBase$DelayedTaskQueue0.timeNow < 0L) {
                        this.nanoTime = eventLoopImplBase$DelayedTaskQueue0.timeNow;
                    }
                    eventLoopImplBase$DelayedTaskQueue0.addImpl(this);
                    return 0;
                }
            }
        }

        @Override  // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(ThreadSafeHeap threadSafeHeap0) {
            if(this._heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("2811040D0B054717171F0504130B0C020B0640").toString());
            }
            this._heap = threadSafeHeap0;
        }

        @Override  // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int v) {
            this.index = v;
        }

        public final boolean timeToExecute(long v) {
            return v - this.nanoTime >= 0L;
        }

        @Override
        public String toString() {
            return UnityPlayerActivity.adjustValue("2A1501001704033E1C0F1E021253") + this.nanoTime + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
    public static final class DelayedTaskQueue extends ThreadSafeHeap {
        public long timeNow;

        public DelayedTaskQueue(long v) {
            this.timeNow = v;
        }
    }

    private volatile Object _delayed;
    private static final AtomicReferenceFieldUpdater _delayed$FU;
    private volatile int _isCompleted;
    private volatile Object _queue;
    private static final AtomicReferenceFieldUpdater _queue$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("310118041B04");
        EventLoopImplBase._queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, s);
        String s1 = UnityPlayerActivity.adjustValue("3114080D0F180201");
        EventLoopImplBase._delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, s1);
    }

    public EventLoopImplBase() {
        this._queue = null;
        this._delayed = null;
        this._isCompleted = 0;
    }

    private final void closeQueue() {
        Object object0;
        if(DebugKt.getASSERTIONS_ENABLED() && !this.isCompleted()) {
            throw new AssertionError();
        }
        while(true) {
            while(true) {
                object0 = this._queue;
                if(object0 != null) {
                    break;
                }
                if(WorkSpec..ExternalSyntheticBackport0.m(EventLoopImplBase._queue$FU, this, null, EventLoop_commonKt.access$getCLOSED_EMPTY$p())) {
                    return;
                }
            }
            if(object0 instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore)object0).close();
                return;
            }
            if(object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = new LockFreeTaskQueueCore(8, true);
            if(object0 == null) {
                break;
            }
            lockFreeTaskQueueCore0.addLast(((Runnable)object0));
            if(WorkSpec..ExternalSyntheticBackport0.m(EventLoopImplBase._queue$FU, this, object0, lockFreeTaskQueueCore0)) {
                return;
            }
        }
        throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3F14000F06071E0B0B4D0A01150B0C1C165E0E0E1C0E12111B00151E4F3C14090B130C1C082A1A4F35101C00110F0D0B411A"));
    }

    @Override  // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long v, Continuation continuation0) {
        return DefaultImpls.delay(this, v, continuation0);
    }

    private final Runnable dequeue() {
        Object object0;
        while(true) {
            object0 = this._queue;
            if(object0 == null) {
                return null;
            }
            if(object0 instanceof LockFreeTaskQueueCore) {
                if(object0 == null) {
                    throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E040F1A04150B13025E210E0D0A2117170B240C1205301200070B3302130B5D0D04040F5E01000006493707001E0C0302041C451901040108001949061D1C1F1815070F02165C3C05030F0F030B00391A5E3F14000F06071E0B50105F15410C0A0602190319400208171D1B04040F0B124920040B1E192D010E173A11011D000E002A134B231B151804520B061313401C0C0F094F35101C00110F0D0B1A470E1D1A1C040F164F040A00010519080004144B201B1E03000C0D022E064022180F00000509174E0D534113"));
                }
                Object object1 = ((LockFreeTaskQueueCore)object0).removeFirstOrNull();
                if(object1 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable)object1;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore0 = ((LockFreeTaskQueueCore)object0).next();
                WorkSpec..ExternalSyntheticBackport0.m(EventLoopImplBase._queue$FU, this, object0, lockFreeTaskQueueCore0);
            }
            else {
                if(object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    return null;
                }
                if(WorkSpec..ExternalSyntheticBackport0.m(EventLoopImplBase._queue$FU, this, object0, null)) {
                    break;
                }
            }
        }
        if(object0 == null) {
            throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3F14000F06071E0B0B4D0A01150B0C1C165E0E0E1C0E12111B00151E4F3C14090B130C1C082A1A4F35101C00110F0D0B411A"));
        }
        return (Runnable)object0;
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext0, Runnable runnable0) {
        this.enqueue(runnable0);
    }

    public void enqueue(Runnable runnable0) {
        if(this.enqueueImpl(runnable0)) {
            this.unpark();
            return;
        }
        DefaultExecutor.INSTANCE.enqueue(runnable0);
    }

    private final boolean enqueueImpl(Runnable runnable0) {
        Object object0;
        while(true) {
        alab1:
            while(true) {
                while(true) {
                label_0:
                    object0 = this._queue;
                    if(this.isCompleted()) {
                        return false;
                    }
                    if(object0 != null) {
                        break;
                    }
                    if(WorkSpec..ExternalSyntheticBackport0.m(EventLoopImplBase._queue$FU, this, null, runnable0)) {
                        return true;
                    }
                }
                if(!(object0 instanceof LockFreeTaskQueueCore)) {
                    goto label_19;
                }
                if(object0 == null) {
                    throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208091D5C0D1F1F0E1B150E0B171D5E040F1A04150B13025E210E0D0A2117170B240C1205301200070B3302130B5D0D04040F5E01000006493707001E0C0302041C451901040108001949061D1C1F1815070F02165C3C05030F0F030B00391A5E3F14000F06071E0B50105F15410C0A0602190319400208171D1B04040F0B124920040B1E192D010E173A11011D000E002A134B231B151804520B061313401C0C0F094F35101C00110F0D0B1A470E1D1A1C040F164F040A00010519080004144B201B1E03000C0D022E064022180F00000509174E0D534113"));
                }
                int v = ((LockFreeTaskQueueCore)object0).addLast(runnable0);
                switch(v) {
                    case 0: {
                        return true;
                    label_13:
                        if(v != 2) {
                            break;
                        }
                        break alab1;
                    }
                    case 1: {
                        goto label_15;
                    }
                    default: {
                        goto label_13;
                    }
                }
            }
            return false;
        label_15:
            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = ((LockFreeTaskQueueCore)object0).next();
            WorkSpec..ExternalSyntheticBackport0.m(EventLoopImplBase._queue$FU, this, object0, lockFreeTaskQueueCore0);
            goto label_0;
        label_19:
            if(object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return false;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore1 = new LockFreeTaskQueueCore(8, true);
            if(object0 == null) {
                break;
            }
            lockFreeTaskQueueCore1.addLast(((Runnable)object0));
            lockFreeTaskQueueCore1.addLast(runnable0);
            if(WorkSpec..ExternalSyntheticBackport0.m(EventLoopImplBase._queue$FU, this, object0, lockFreeTaskQueueCore1)) {
                return true;
            }
        }
        throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1A0C170F4F0B041C095E3F14000F06071E0B0B4D0A01150B0C1C165E0E0E1C0E12111B00151E4F3C14090B130C1C082A1A4F35101C00110F0D0B411A"));
    }

    @Override  // kotlinx.coroutines.EventLoop
    protected long getNextTime() {
        if(super.getNextTime() == 0L) {
            return 0L;
        }
        Object object0 = this._queue;
        if(object0 != null) {
            if(!(object0 instanceof LockFreeTaskQueueCore)) {
                return object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p() ? 0x7FFFFFFFFFFFFFFFL : 0L;
            }
            else if(!((LockFreeTaskQueueCore)object0).isEmpty()) {
                return 0L;
            }
        }
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)this._delayed;
        if(eventLoopImplBase$DelayedTaskQueue0 != null) {
            DelayedTask eventLoopImplBase$DelayedTask0 = (DelayedTask)eventLoopImplBase$DelayedTaskQueue0.peek();
            if(eventLoopImplBase$DelayedTask0 != null) {
                long v = eventLoopImplBase$DelayedTask0.nanoTime;
                AbstractTimeSource abstractTimeSource0 = AbstractTimeSourceKt.getTimeSource();
                return abstractTimeSource0 == null ? RangesKt.coerceAtLeast(v - System.nanoTime(), 0L) : RangesKt.coerceAtLeast(v - abstractTimeSource0.nanoTime(), 0L);
            }
        }
        return 0x7FFFFFFFFFFFFFFFL;
    }

    @Override  // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long v, Runnable runnable0, CoroutineContext coroutineContext0) {
        return DefaultImpls.invokeOnTimeout(this, v, runnable0, coroutineContext0);
    }

    private final boolean isCompleted() {
        return this._isCompleted;
    }

    @Override  // kotlinx.coroutines.EventLoop
    protected boolean isEmpty() {
        if(!this.isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)this._delayed;
        if(eventLoopImplBase$DelayedTaskQueue0 != null && !eventLoopImplBase$DelayedTaskQueue0.isEmpty()) {
            return false;
        }
        Object object0 = this._queue;
        if(object0 == null) {
            return true;
        }
        return object0 instanceof LockFreeTaskQueueCore ? ((LockFreeTaskQueueCore)object0).isEmpty() : object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p();
    }

    @Override  // kotlinx.coroutines.EventLoop
    public long processNextEvent() {
        if(this.processUnconfinedEvent()) {
            return 0L;
        }
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)this._delayed;
        if(eventLoopImplBase$DelayedTaskQueue0 != null && !eventLoopImplBase$DelayedTaskQueue0.isEmpty()) {
            AbstractTimeSource abstractTimeSource0 = AbstractTimeSourceKt.getTimeSource();
            long v = abstractTimeSource0 == null ? System.nanoTime() : abstractTimeSource0.nanoTime();
            while(true) {
                __monitor_enter(eventLoopImplBase$DelayedTaskQueue0);
                int v1 = FIN.finallyOpen$NT();
                ThreadSafeHeapNode threadSafeHeapNode0 = null;
                ThreadSafeHeapNode threadSafeHeapNode1 = eventLoopImplBase$DelayedTaskQueue0.firstImpl();
                if(threadSafeHeapNode1 == null) {
                    FIN.finallyExec$NT(v1);
                }
                else {
                    if((((DelayedTask)threadSafeHeapNode1).timeToExecute(v) ? this.enqueueImpl(((DelayedTask)threadSafeHeapNode1)) : false)) {
                        threadSafeHeapNode0 = eventLoopImplBase$DelayedTaskQueue0.removeAtImpl(0);
                    }
                    FIN.finallyCodeBegin$NT(v1);
                    __monitor_exit(eventLoopImplBase$DelayedTaskQueue0);
                    FIN.finallyCodeEnd$NT(v1);
                }
                if(((DelayedTask)threadSafeHeapNode0) == null) {
                    break;
                }
            }
        }
        Runnable runnable0 = this.dequeue();
        if(runnable0 != null) {
            runnable0.run();
            return 0L;
        }
        return this.getNextTime();
    }

    private final void rescheduleAllDelayed() {
        AbstractTimeSource abstractTimeSource0 = AbstractTimeSourceKt.getTimeSource();
        long v = abstractTimeSource0 == null ? System.nanoTime() : abstractTimeSource0.nanoTime();
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0;
        while((eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)this._delayed) != null) {
            DelayedTask eventLoopImplBase$DelayedTask0 = (DelayedTask)eventLoopImplBase$DelayedTaskQueue0.removeFirstOrNull();
            if(eventLoopImplBase$DelayedTask0 == null) {
                break;
            }
            this.reschedule(v, eventLoopImplBase$DelayedTask0);
        }
    }

    protected final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    public final void schedule(long v, DelayedTask eventLoopImplBase$DelayedTask0) {
        switch(this.scheduleImpl(v, eventLoopImplBase$DelayedTask0)) {
            case 0: {
                if(this.shouldUnpark(eventLoopImplBase$DelayedTask0)) {
                    this.unpark();
                }
                break;
            }
            case 1: {
                this.reschedule(v, eventLoopImplBase$DelayedTask0);
                return;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException(UnityPlayerActivity.adjustValue("1B1E08191E040411170A501F041D140B11").toString());
            }
        }
    }

    private final int scheduleImpl(long v, DelayedTask eventLoopImplBase$DelayedTask0) {
        if(this.isCompleted()) {
            return 1;
        }
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)this._delayed;
        if(eventLoopImplBase$DelayedTaskQueue0 == null) {
            DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue1 = new DelayedTaskQueue(v);
            WorkSpec..ExternalSyntheticBackport0.m(EventLoopImplBase._delayed$FU, this, null, eventLoopImplBase$DelayedTaskQueue1);
            Object object0 = this._delayed;
            Intrinsics.checkNotNull(object0);
            eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)object0;
        }
        return eventLoopImplBase$DelayedTask0.scheduleTask(v, eventLoopImplBase$DelayedTaskQueue0, this);
    }

    protected final DisposableHandle scheduleInvokeOnTimeout(long v, Runnable runnable0) {
        long v1 = EventLoop_commonKt.delayToNanos(v);
        if(v1 < 0x3FFFFFFFFFFFFFFFL) {
            AbstractTimeSource abstractTimeSource0 = AbstractTimeSourceKt.getTimeSource();
            long v2 = abstractTimeSource0 == null ? System.nanoTime() : abstractTimeSource0.nanoTime();
            DelayedRunnableTask eventLoopImplBase$DelayedRunnableTask0 = new DelayedRunnableTask(v1 + v2, runnable0);
            this.schedule(v2, eventLoopImplBase$DelayedRunnableTask0);
            return eventLoopImplBase$DelayedRunnableTask0;
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override  // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long v, CancellableContinuation cancellableContinuation0) {
        long v1 = EventLoop_commonKt.delayToNanos(v);
        if(v1 < 0x3FFFFFFFFFFFFFFFL) {
            AbstractTimeSource abstractTimeSource0 = AbstractTimeSourceKt.getTimeSource();
            long v2 = abstractTimeSource0 == null ? System.nanoTime() : abstractTimeSource0.nanoTime();
            DelayedResumeTask eventLoopImplBase$DelayedResumeTask0 = new DelayedResumeTask(this, v1 + v2, cancellableContinuation0);
            this.schedule(v2, eventLoopImplBase$DelayedResumeTask0);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation0, eventLoopImplBase$DelayedResumeTask0);
        }
    }

    private final void setCompleted(boolean z) {
        this._isCompleted = z;
    }

    private final boolean shouldUnpark(DelayedTask eventLoopImplBase$DelayedTask0) {
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)this._delayed;
        return (eventLoopImplBase$DelayedTaskQueue0 == null ? null : ((DelayedTask)eventLoopImplBase$DelayedTaskQueue0.peek())) == eventLoopImplBase$DelayedTask0;
    }

    @Override  // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.setCompleted(true);
        this.closeQueue();
        while(this.processNextEvent() <= 0L) {
        }
        this.rescheduleAllDelayed();
    }
}

