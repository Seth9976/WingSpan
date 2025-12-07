package kotlin.ranges;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B \u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001A\u00020\u000BH\u0096\u0002J\u0016\u0010\f\u001A\u00020\u0002H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000ER\u0016\u0010\b\u001A\u00020\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001A\u00020\u0002X\u0082\u000Eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001A\u00020\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000F"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "", "Lkotlin/UInt;", "first", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "next-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
final class UIntProgressionIterator implements Iterator, KMappedMarker {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    private UIntProgressionIterator(int v, int v1, int v2) {
        this.finalElement = v1;
        boolean z = true;
        int v3 = UnsignedKt.uintCompare(v, v1);
        if(!(v2 <= 0 ? v3 >= 0 : v3 <= 0)) {
            z = false;
        }
        this.hasNext = z;
        this.step = v2;
        if(!this.hasNext) {
            v = v1;
        }
        this.next = v;
    }

    public UIntProgressionIterator(int v, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, v1, v2);
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public Object next() {
        return UInt.box-impl(this.next-pVg5ArA());
    }

    public int next-pVg5ArA() {
        int v = this.next;
        if(v == this.finalElement) {
            if(!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
            return v;
        }
        this.next = this.step + v;
        return v;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("210008130F150E0A1C4E191E41000E1345011B001D0E1C15020152081F1F411C0406015F011E01184E0208091E0B131908010F"));
    }
}

