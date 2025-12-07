package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001A\u00020\u000EJ\b\u0010\u0012\u001A\u00020\u000EH\u0002J\r\u0010\u0013\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\t\u0010\u000BR\u000E\u0010\f\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class ArrayQueue {
    private Object[] elements;
    private int head;
    private int tail;

    public ArrayQueue() {
        this.elements = new Object[16];
    }

    public final void addLast(Object object0) {
        Object[] arr_object = this.elements;
        int v = this.tail;
        arr_object[v] = object0;
        int v1 = arr_object.length - 1 & v + 1;
        this.tail = v1;
        if(v1 == this.head) {
            this.ensureCapacity();
        }
    }

    public final void clear() {
        this.head = 0;
        this.tail = 0;
        this.elements = new Object[this.elements.length];
    }

    private final void ensureCapacity() {
        Object[] arr_object = this.elements;
        Object[] arr_object1 = new Object[arr_object.length << 1];
        ArraysKt.copyInto$default(arr_object, arr_object1, 0, this.head, 0, 10, null);
        ArraysKt.copyInto$default(this.elements, arr_object1, this.elements.length - this.head, 0, this.head, 4, null);
        this.elements = arr_object1;
        this.head = 0;
        this.tail = arr_object.length;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final Object removeFirstOrNull() {
        int v = this.head;
        if(v == this.tail) {
            return null;
        }
        Object[] arr_object = this.elements;
        Object object0 = arr_object[v];
        arr_object[v] = null;
        this.head = v + 1 & arr_object.length - 1;
        if(object0 == null) {
            throw new NullPointerException(UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E244D0E08410C0A0602190319400208171D1B04040F0B12490C1C1A151F0F0F0D4924001C1114301B041200"));
        }
        return object0;
    }
}

