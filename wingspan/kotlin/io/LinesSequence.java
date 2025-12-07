package kotlin.io;

import com.unity3d.player.UnityPlayerActivity;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000F\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "reader", "Ljava/io/BufferedReader;", "(Ljava/io/BufferedReader;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
final class LinesSequence implements Sequence {
    private final BufferedReader reader;

    public LinesSequence(BufferedReader bufferedReader0) {
        Intrinsics.checkNotNullParameter(bufferedReader0, UnityPlayerActivity.adjustValue("1C150C050B13"));
        super();
        this.reader = bufferedReader0;
    }

    @Override  // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new Object() {
            private boolean done;
            private String nextValue;

            @Override
            public boolean hasNext() {
                if(this.nextValue == null && !this.done) {
                    String s = LinesSequence.this.reader.readLine();
                    this.nextValue = s;
                    if(s == null) {
                        this.done = true;
                    }
                }
                return this.nextValue != null;
            }

            @Override
            public Object next() {
                return this.next();
            }

            public String next() {
                if(!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                String s = this.nextValue;
                this.nextValue = null;
                Intrinsics.checkNotNull(s);
                return s;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("210008130F150E0A1C4E191E41000E1345011B001D0E1C15020152081F1F411C0406015F011E01184E0208091E0B131908010F"));
            }
        };
    }
}

