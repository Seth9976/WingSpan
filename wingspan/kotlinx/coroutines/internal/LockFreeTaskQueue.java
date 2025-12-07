package kotlinx.coroutines.internal;

import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import com.unity3d.player.UnityPlayerActivity;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\u0003¢\u0006\u0004\b\r\u0010\u000EJ-\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0001\u0010\u000F2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u000ER\u0011\u0010\u001B\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class LockFreeTaskQueue {
    private volatile Object _cur;
    private static final AtomicReferenceFieldUpdater _cur$FU;

    static {
        String s = UnityPlayerActivity.adjustValue("31131813");
        LockFreeTaskQueue._cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, s);
    }

    public LockFreeTaskQueue(boolean z) {
        this._cur = new LockFreeTaskQueueCore(8, z);
    }

    public final boolean addLast(Object object0) {
        while(true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = (LockFreeTaskQueueCore)this._cur;
            int v = lockFreeTaskQueueCore0.addLast(object0);
            switch(v) {
                case 0: {
                    return true;
                label_5:
                    if(v != 2) {
                        break;
                    }
                    return false;
                }
                case 1: {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore1 = lockFreeTaskQueueCore0.next();
                    WorkSpec..ExternalSyntheticBackport0.m(LockFreeTaskQueue._cur$FU, this, lockFreeTaskQueueCore0, lockFreeTaskQueueCore1);
                    break;
                }
                default: {
                    goto label_5;
                }
            }
        }
    }

    public final void close() {
        while(true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = (LockFreeTaskQueueCore)this._cur;
            if(lockFreeTaskQueueCore0.close()) {
                break;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore1 = lockFreeTaskQueueCore0.next();
            WorkSpec..ExternalSyntheticBackport0.m(LockFreeTaskQueue._cur$FU, this, lockFreeTaskQueueCore0, lockFreeTaskQueueCore1);
        }
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore)this._cur).getSize();
    }

    public final boolean isClosed() {
        return ((LockFreeTaskQueueCore)this._cur).isClosed();
    }

    public final boolean isEmpty() {
        return ((LockFreeTaskQueueCore)this._cur).isEmpty();
    }

    public final List map(Function1 function10) {
        return ((LockFreeTaskQueueCore)this._cur).map(function10);
    }

    public final Object removeFirstOrNull() {
        Object object0;
        while(true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = (LockFreeTaskQueueCore)this._cur;
            object0 = lockFreeTaskQueueCore0.removeFirstOrNull();
            if(object0 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                break;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore1 = lockFreeTaskQueueCore0.next();
            WorkSpec..ExternalSyntheticBackport0.m(LockFreeTaskQueue._cur$FU, this, lockFreeTaskQueueCore0, lockFreeTaskQueueCore1);
        }
        return object0;
    }
}

