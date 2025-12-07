package kotlin.sequences;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B;\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0002\u0010\tJ\u000F\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00020\u000BH\u0096\u0002R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/sequences/MergingSequence;", "T1", "T2", "V", "Lkotlin/sequences/Sequence;", "sequence1", "sequence2", "transform", "Lkotlin/Function2;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MergingSequence implements Sequence {
    private final Sequence sequence1;
    private final Sequence sequence2;
    private final Function2 transform;

    public MergingSequence(Sequence sequence0, Sequence sequence1, Function2 function20) {
        Intrinsics.checkNotNullParameter(sequence0, UnityPlayerActivity.adjustValue("1D151C140B0F040043"));
        Intrinsics.checkNotNullParameter(sequence1, UnityPlayerActivity.adjustValue("1D151C140B0F040040"));
        Intrinsics.checkNotNullParameter(function20, UnityPlayerActivity.adjustValue("1A020C0F1D0708171F"));
        super();
        this.sequence1 = sequence0;
        this.sequence2 = sequence1;
        this.transform = function20;
    }

    @Override  // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new Object() {
            private final Iterator iterator1;
            private final Iterator iterator2;

            {
                this.iterator1 = mergingSequence0.sequence1.iterator();
                this.iterator2 = mergingSequence0.sequence2.iterator();
            }

            public final Iterator getIterator1() {
                return this.iterator1;
            }

            public final Iterator getIterator2() {
                return this.iterator2;
            }

            // 去混淆评级： 低(20)
            @Override
            public boolean hasNext() {
                return this.iterator1.hasNext() && this.iterator2.hasNext();
            }

            @Override
            public Object next() {
                Function2 function20 = MergingSequence.this.transform;
                Object object0 = this.iterator1.next();
                Object object1 = this.iterator2.next();
                return function20.invoke(object0, object1);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("210008130F150E0A1C4E191E41000E1345011B001D0E1C15020152081F1F411C0406015F011E01184E0208091E0B131908010F"));
            }
        };
    }
}

