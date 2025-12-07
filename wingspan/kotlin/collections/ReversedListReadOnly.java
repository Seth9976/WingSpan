package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
class ReversedListReadOnly extends AbstractList {
    private final List delegate;

    public ReversedListReadOnly(List list0) {
        Intrinsics.checkNotNullParameter(list0, "delegate");
        super();
        this.delegate = list0;
    }

    @Override  // kotlin.collections.AbstractList
    public Object get(int v) {
        int v1 = CollectionsKt__ReversedViewsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(this, v);
        return this.delegate.get(v1);
    }

    @Override  // kotlin.collections.AbstractList
    public int getSize() {
        return this.delegate.size();
    }
}

