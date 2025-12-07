package kotlinx.coroutines.scheduling;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001A\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u0000¢\u0006\u0004\b\u001A\u0010\u0019J\u001F\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00002\u0006\u0010\u001B\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u001C\u0010\u001DJ\u0015\u0010\u001E\u001A\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001E\u0010\u001FR\u001C\u0010!\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001A\u00020#8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%R\u0014\u0010(\u001A\u00020#8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class WorkQueue {
    private volatile int blockingTasksInBuffer;
    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU;
    private final AtomicReferenceArray buffer;
    private volatile int consumerIndex;
    private static final AtomicIntegerFieldUpdater consumerIndex$FU;
    private volatile Object lastScheduledTask;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU;
    private volatile int producerIndex;
    private static final AtomicIntegerFieldUpdater producerIndex$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("02111E153D020F00161B1C08053A00140E");
        WorkQueue.lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, s);
        String s1 = UnityPlayerActivity.adjustValue("1E0202051B0202173B00140819");
        WorkQueue.producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, s1);
        String s2 = UnityPlayerActivity.adjustValue("0D1F03121B0C02173B00140819");
        WorkQueue.consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, s2);
        String s3 = UnityPlayerActivity.adjustValue("0C1C020205080902260F030612270F25101408151F");
        WorkQueue.blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, s3);
    }

    public WorkQueue() {
        this.buffer = new AtomicReferenceArray(0x80);
        this.lastScheduledTask = null;
        this.producerIndex = 0;
        this.consumerIndex = 0;
        this.blockingTasksInBuffer = 0;
    }

    public final Task add(Task task0, boolean z) {
        if(z) {
            return this.addLast(task0);
        }
        Task task1 = (Task)WorkQueue.lastScheduledTask$FU.getAndSet(this, task0);
        return task1 == null ? null : this.addLast(task1);
    }

    public static Task add$default(WorkQueue workQueue0, Task task0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return workQueue0.add(task0, z);
    }

    private final Task addLast(Task task0) {
        if(task0.taskContext.getTaskMode() == 1) {
            WorkQueue.blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        if(this.getBufferSize$kotlinx_coroutines_core() == 0x7F) {
            return task0;
        }
        int v = this.producerIndex & 0x7F;
        while(this.buffer.get(v) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(v, task0);
        WorkQueue.producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task0) {
        if(task0 != null) {
            boolean z = task0.taskContext.getTaskMode() != 1;
        }
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int getSize$kotlinx_coroutines_core() {
        return this.lastScheduledTask == null ? this.getBufferSize$kotlinx_coroutines_core() : this.getBufferSize$kotlinx_coroutines_core() + 1;
    }

    public final void offloadAllWorkTo(GlobalQueue globalQueue0) {
        Task task0 = (Task)WorkQueue.lastScheduledTask$FU.getAndSet(this, null);
        if(task0 != null) {
            globalQueue0.addLast(task0);
        }
        while(this.pollTo(globalQueue0)) {
        }
    }

    public final Task poll() {
        Task task0 = (Task)WorkQueue.lastScheduledTask$FU.getAndSet(this, null);
        return task0 == null ? this.pollBuffer() : task0;
    }

    private final Task pollBuffer() {
        Task task0;
        int v;
        do {
            do {
                v = this.consumerIndex;
                if(v - this.producerIndex == 0) {
                    return null;
                }
            }
            while(!WorkQueue.consumerIndex$FU.compareAndSet(this, v, v + 1));
            task0 = (Task)this.buffer.getAndSet(v & 0x7F, null);
        }
        while(task0 == null);
        this.decrementIfBlocking(task0);
        return task0;
    }

    private final boolean pollTo(GlobalQueue globalQueue0) {
        Task task0 = this.pollBuffer();
        if(task0 == null) {
            return false;
        }
        globalQueue0.addLast(task0);
        return true;
    }

    public final long tryStealBlockingFrom(WorkQueue workQueue0) {
        int v = workQueue0.consumerIndex;
        int v1 = workQueue0.producerIndex;
        AtomicReferenceArray atomicReferenceArray0 = workQueue0.buffer;
        while(v != v1 && workQueue0.blockingTasksInBuffer != 0) {
            Task task0 = (Task)atomicReferenceArray0.get(v & 0x7F);
            if(task0 != null && (task0.taskContext.getTaskMode() == 1 && WorkSpec..ExternalSyntheticBackport0.m(atomicReferenceArray0, v & 0x7F, task0, null))) {
                WorkQueue.blockingTasksInBuffer$FU.decrementAndGet(workQueue0);
                WorkQueue.add$default(this, task0, false, 2, null);
                return -1L;
            }
            ++v;
        }
        return this.tryStealLastScheduled(workQueue0, true);
    }

    // 去混淆评级： 中等(60)
    public final long tryStealFrom(WorkQueue workQueue0) {
        return workQueue0.pollBuffer() == null ? this.tryStealLastScheduled(workQueue0, false) : -1L;
    }

    private final long tryStealLastScheduled(WorkQueue workQueue0, boolean z) {
        Task task0;
        do {
            task0 = (Task)workQueue0.lastScheduledTask;
            if(task0 == null) {
                return -2L;
            }
            if(z && task0.taskContext.getTaskMode() != 1) {
                return -2L;
            }
            long v = TasksKt.schedulerTimeSource.nanoTime() - task0.submissionTime;
            if(v < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) {
                return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - v;
            }
        }
        while(!WorkSpec..ExternalSyntheticBackport0.m(WorkQueue.lastScheduledTask$FU, workQueue0, task0, null));
        WorkQueue.add$default(this, task0, false, 2, null);
        return -1L;
    }
}

