package kotlin.sequences;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001A\u00020\u0006H\u0016J\u000F\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000FH\u0096\u0002J\u0016\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001A\u00020\u0006H\u0016R\u0014\u0010\t\u001A\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubSequence implements DropTakeSequence, Sequence {
    private final int endIndex;
    private final Sequence sequence;
    private final int startIndex;

    public SubSequence(Sequence sequence0, int v, int v1) {
        Intrinsics.checkNotNullParameter(sequence0, UnityPlayerActivity.adjustValue("1D151C140B0F0400"));
        super();
        this.sequence = sequence0;
        this.startIndex = v;
        this.endIndex = v1;
        if(v < 0) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("1D040C131A2809011716501E0901140B01520C154D0F010F4A0B170911190818044B45101B044D081D41") + v).toString());
        }
        if(v1 < 0) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("0B1E09280005021D521D18021402054707174E1E020F430F0202131A191B0442410510064E191E41") + v1).toString());
        }
        if(v1 < v) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("0B1E09280005021D521D18021402054707174E1E02154E0D0216014E04050000411411131C04240F0A041F49520C05194119001445") + v1 + UnityPlayerActivity.adjustValue("4E4C4D") + v).toString());
        }
    }

    @Override  // kotlin.sequences.DropTakeSequence
    public Sequence drop(int v) {
        return v >= this.getCount() ? SequencesKt.emptySequence() : new SubSequence(this.sequence, this.startIndex + v, this.endIndex);
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    @Override  // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new Object() {
            private final Iterator iterator;
            private int position;

            {
                this.iterator = subSequence0.sequence.iterator();
            }

            private final void drop() {
                while(this.position < SubSequence.this.startIndex && this.iterator.hasNext()) {
                    this.iterator.next();
                    ++this.position;
                }
            }

            public final Iterator getIterator() {
                return this.iterator;
            }

            public final int getPosition() {
                return this.position;
            }

            @Override
            public boolean hasNext() {
                this.drop();
                return this.position < SubSequence.this.endIndex && this.iterator.hasNext();
            }

            @Override
            public Object next() {
                this.drop();
                if(this.position >= SubSequence.this.endIndex) {
                    throw new NoSuchElementException();
                }
                ++this.position;
                return this.iterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("210008130F150E0A1C4E191E41000E1345011B001D0E1C15020152081F1F411C0406015F011E01184E0208091E0B131908010F"));
            }

            public final void setPosition(int v) {
                this.position = v;
            }
        };
    }

    @Override  // kotlin.sequences.DropTakeSequence
    public Sequence take(int v) {
        return v < this.getCount() ? new SubSequence(this.sequence, this.startIndex, v + this.startIndex) : this;
    }
}

