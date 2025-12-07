package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000605j\u0002`6B\u0007\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00028\u0000H\u0001\u00A2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00028\u0000\u00A2\u0006\u0004\b\n\u0010\tJ.\u0010\u000E\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00028\u00002\u0014\u0010\r\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000BH\u0086\b\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0005J2\u0010\u0015\u001A\u0004\u0018\u00018\u00002!\u0010\u0014\u001A\u001D\u0012\u0013\u0012\u00118\u0000\u00A2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000B\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001A\u0004\u0018\u00018\u0000H\u0001\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u0004\u0018\u00018\u0000\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001AH\u0002\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u001D\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00028\u0000\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010!\u001A\u00028\u00002\u0006\u0010 \u001A\u00020\u001FH\u0001\u00A2\u0006\u0004\b!\u0010\"J&\u0010#\u001A\u0004\u0018\u00018\u00002\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000BH\u0086\b\u00A2\u0006\u0004\b#\u0010\u0016J\u000F\u0010$\u001A\u0004\u0018\u00018\u0000\u00A2\u0006\u0004\b$\u0010\u0018J\u0018\u0010&\u001A\u00020\u00072\u0006\u0010%\u001A\u00020\u001FH\u0082\u0010\u00A2\u0006\u0004\b&\u0010\'J\u0018\u0010(\u001A\u00020\u00072\u0006\u0010%\u001A\u00020\u001FH\u0082\u0010\u00A2\u0006\u0004\b(\u0010\'J\u001F\u0010*\u001A\u00020\u00072\u0006\u0010%\u001A\u00020\u001F2\u0006\u0010)\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b*\u0010+R \u0010,\u001A\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0011\u0010.\u001A\u00020\f8F\u00A2\u0006\u0006\u001A\u0004\b.\u0010/R$\u00103\u001A\u00020\u001F2\u0006\u0010\u0013\u001A\u00020\u001F8F@BX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b0\u00101\"\u0004\b2\u0010\'\u00A8\u00064"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "Lkotlin/ParameterName;", "name", "value", "predicate", "find", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class ThreadSafeHeap {
    private volatile int _size;
    private ThreadSafeHeapNode[] a;

    public ThreadSafeHeap() {
        this._size = 0;
    }

    public final void addImpl(ThreadSafeHeapNode threadSafeHeapNode0) {
        threadSafeHeapNode0.setHeap(this);
        ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.realloc();
        int v = this.getSize();
        this.setSize(v + 1);
        arr_threadSafeHeapNode[v] = threadSafeHeapNode0;
        threadSafeHeapNode0.setIndex(v);
        this.siftUpFrom(v);
    }

    public final void addLast(ThreadSafeHeapNode threadSafeHeapNode0) {
        synchronized(this) {
            this.addImpl(threadSafeHeapNode0);
        }
    }

    public final boolean addLastIf(ThreadSafeHeapNode threadSafeHeapNode0, Function1 function10) {
        boolean z;
        synchronized(this) {
            if(((Boolean)function10.invoke(this.firstImpl())).booleanValue()) {
                this.addImpl(threadSafeHeapNode0);
                z = true;
            }
            else {
                z = false;
            }
            return z;
        }
    }

    public final void clear() {
        synchronized(this) {
            ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
            if(arr_threadSafeHeapNode != null) {
                ArraysKt.fill$default(arr_threadSafeHeapNode, null, 0, 0, 6, null);
            }
            this._size = 0;
        }
    }

    public final ThreadSafeHeapNode find(Function1 function10) {
        ThreadSafeHeapNode threadSafeHeapNode0;
        synchronized(this) {
            int v1 = this.getSize();
            for(int v2 = 0; true; ++v2) {
                threadSafeHeapNode0 = null;
                if(v2 >= v1) {
                    break;
                }
                ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
                if(arr_threadSafeHeapNode != null) {
                    threadSafeHeapNode0 = arr_threadSafeHeapNode[v2];
                }
                Intrinsics.checkNotNull(threadSafeHeapNode0);
                if(((Boolean)function10.invoke(threadSafeHeapNode0)).booleanValue()) {
                    break;
                }
            }
            return threadSafeHeapNode0;
        }
    }

    public final ThreadSafeHeapNode firstImpl() {
        return this.a == null ? null : this.a[0];
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean isEmpty() {
        return this.getSize() == 0;
    }

    public final ThreadSafeHeapNode peek() {
        synchronized(this) {
            return this.firstImpl();
        }
    }

    private final ThreadSafeHeapNode[] realloc() {
        ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
        if(arr_threadSafeHeapNode == null) {
            arr_threadSafeHeapNode = new ThreadSafeHeapNode[4];
            this.a = arr_threadSafeHeapNode;
            return arr_threadSafeHeapNode;
        }
        if(this.getSize() >= arr_threadSafeHeapNode.length) {
            Object[] arr_object = Arrays.copyOf(arr_threadSafeHeapNode, this.getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(arr_object, UnityPlayerActivity.adjustValue("0D1F1D1821074F111A07034141000410361B141544"));
            arr_threadSafeHeapNode = (ThreadSafeHeapNode[])arr_object;
            this.a = arr_threadSafeHeapNode;
        }
        return arr_threadSafeHeapNode;
    }

    public final boolean remove(ThreadSafeHeapNode threadSafeHeapNode0) {
        boolean z = false;
        synchronized(this) {
            if(threadSafeHeapNode0.getHeap() != null) {
                this.removeAtImpl(threadSafeHeapNode0.getIndex());
                z = true;
            }
            return z;
        }
    }

    public final ThreadSafeHeapNode removeAtImpl(int v) {
        ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
        Intrinsics.checkNotNull(arr_threadSafeHeapNode);
        this.setSize(this.getSize() - 1);
        if(v < this.getSize()) {
            this.swap(v, this.getSize());
            int v1 = (v - 1) / 2;
            if(v > 0) {
                ThreadSafeHeapNode threadSafeHeapNode0 = arr_threadSafeHeapNode[v];
                Intrinsics.checkNotNull(threadSafeHeapNode0);
                ThreadSafeHeapNode threadSafeHeapNode1 = arr_threadSafeHeapNode[v1];
                Intrinsics.checkNotNull(threadSafeHeapNode1);
                if(((Comparable)threadSafeHeapNode0).compareTo(threadSafeHeapNode1) < 0) {
                    this.swap(v, v1);
                    this.siftUpFrom(v1);
                }
                else {
                    this.siftDownFrom(v);
                }
            }
            else {
                this.siftDownFrom(v);
            }
        }
        ThreadSafeHeapNode threadSafeHeapNode2 = arr_threadSafeHeapNode[this.getSize()];
        Intrinsics.checkNotNull(threadSafeHeapNode2);
        threadSafeHeapNode2.setHeap(null);
        threadSafeHeapNode2.setIndex(-1);
        arr_threadSafeHeapNode[this.getSize()] = null;
        return threadSafeHeapNode2;
    }

    public final ThreadSafeHeapNode removeFirstIf(Function1 function10) {
        synchronized(this) {
            ThreadSafeHeapNode threadSafeHeapNode0 = null;
            ThreadSafeHeapNode threadSafeHeapNode1 = this.firstImpl();
            if(threadSafeHeapNode1 == null) {
                return null;
            }
            if(((Boolean)function10.invoke(threadSafeHeapNode1)).booleanValue()) {
                threadSafeHeapNode0 = this.removeAtImpl(0);
            }
            return threadSafeHeapNode0;
        }
    }

    public final ThreadSafeHeapNode removeFirstOrNull() {
        synchronized(this) {
            return this.getSize() <= 0 ? null : this.removeAtImpl(0);
        }
    }

    private final void setSize(int v) {
        this._size = v;
    }

    private final void siftDownFrom(int v) {
        while(true) {
            int v1 = v * 2 + 1;
            if(v1 >= this.getSize()) {
                return;
            }
            ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
            Intrinsics.checkNotNull(arr_threadSafeHeapNode);
            if(v1 + 1 < this.getSize()) {
                ThreadSafeHeapNode threadSafeHeapNode0 = arr_threadSafeHeapNode[v1 + 1];
                Intrinsics.checkNotNull(threadSafeHeapNode0);
                ThreadSafeHeapNode threadSafeHeapNode1 = arr_threadSafeHeapNode[v1];
                Intrinsics.checkNotNull(threadSafeHeapNode1);
                if(((Comparable)threadSafeHeapNode0).compareTo(threadSafeHeapNode1) < 0) {
                    ++v1;
                }
            }
            ThreadSafeHeapNode threadSafeHeapNode2 = arr_threadSafeHeapNode[v];
            Intrinsics.checkNotNull(threadSafeHeapNode2);
            ThreadSafeHeapNode threadSafeHeapNode3 = arr_threadSafeHeapNode[v1];
            Intrinsics.checkNotNull(threadSafeHeapNode3);
            if(((Comparable)threadSafeHeapNode2).compareTo(threadSafeHeapNode3) <= 0) {
                return;
            }
            this.swap(v, v1);
            v = v1;
        }
    }

    private final void siftUpFrom(int v) {
        while(true) {
            if(v <= 0) {
                return;
            }
            ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
            Intrinsics.checkNotNull(arr_threadSafeHeapNode);
            int v1 = (v - 1) / 2;
            ThreadSafeHeapNode threadSafeHeapNode0 = arr_threadSafeHeapNode[v1];
            Intrinsics.checkNotNull(threadSafeHeapNode0);
            ThreadSafeHeapNode threadSafeHeapNode1 = arr_threadSafeHeapNode[v];
            Intrinsics.checkNotNull(threadSafeHeapNode1);
            if(((Comparable)threadSafeHeapNode0).compareTo(threadSafeHeapNode1) <= 0) {
                return;
            }
            this.swap(v, v1);
            v = v1;
        }
    }

    private final void swap(int v, int v1) {
        ThreadSafeHeapNode[] arr_threadSafeHeapNode = this.a;
        Intrinsics.checkNotNull(arr_threadSafeHeapNode);
        ThreadSafeHeapNode threadSafeHeapNode0 = arr_threadSafeHeapNode[v1];
        Intrinsics.checkNotNull(threadSafeHeapNode0);
        ThreadSafeHeapNode threadSafeHeapNode1 = arr_threadSafeHeapNode[v];
        Intrinsics.checkNotNull(threadSafeHeapNode1);
        arr_threadSafeHeapNode[v] = threadSafeHeapNode0;
        arr_threadSafeHeapNode[v1] = threadSafeHeapNode1;
        threadSafeHeapNode0.setIndex(v);
        threadSafeHeapNode1.setIndex(v1);
    }
}

