package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001D\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000EJ\b\u0010\u000F\u001A\u00020\u000BH\u0016J\u0016\u0010\u0010\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u001E\u0010\u0013\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
final class ReversedList extends AbstractMutableList {
    private final List delegate;

    public ReversedList(List list0) {
        Intrinsics.checkNotNullParameter(list0, "delegate");
        super();
        this.delegate = list0;
    }

    @Override  // kotlin.collections.AbstractMutableList
    public void add(int v, Object object0) {
        int v1 = CollectionsKt__ReversedViewsKt.reversePositionIndex$CollectionsKt__ReversedViewsKt(this, v);
        this.delegate.add(v1, object0);
    }

    @Override
    public void clear() {
        this.delegate.clear();
    }

    @Override
    public Object get(int v) {
        int v1 = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, v);
        return this.delegate.get(v1);
    }

    @Override  // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.delegate.size();
    }

    @Override  // kotlin.collections.AbstractMutableList
    public Object removeAt(int v) {
        int v1 = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, v);
        return this.delegate.remove(v1);
    }

    @Override  // kotlin.collections.AbstractMutableList
    public Object set(int v, Object object0) {
        int v1 = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, v);
        return this.delegate.set(v1, object0);
    }
}

