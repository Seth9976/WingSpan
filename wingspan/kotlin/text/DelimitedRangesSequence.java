package kotlin.text;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012:\u0010\b\u001A6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000E¢\u0006\u0002\u0010\u000FJ\u000F\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001A6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
final class DelimitedRangesSequence implements Sequence {
    private final Function2 getNextMatch;
    private final CharSequence input;
    private final int limit;
    private final int startIndex;

    public DelimitedRangesSequence(CharSequence charSequence0, int v, int v1, Function2 function20) {
        Intrinsics.checkNotNullParameter(charSequence0, UnityPlayerActivity.adjustValue("071E1D141A"));
        Intrinsics.checkNotNullParameter(function20, UnityPlayerActivity.adjustValue("0915192F0B191328131A1305"));
        super();
        this.input = charSequence0;
        this.startIndex = v;
        this.limit = v1;
        this.getNextMatch = function20;
    }

    @Override  // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new Object() {
            private int counter;
            private int currentStartIndex;
            private IntRange nextItem;
            private int nextSearchIndex;
            private int nextState;

            {
                this.nextState = -1;
                int v = RangesKt.coerceIn(delimitedRangesSequence0.startIndex, 0, delimitedRangesSequence0.input.length());
                this.currentStartIndex = v;
                this.nextSearchIndex = v;
            }

            private final void calcNext() {
                int v = 0;
                if(this.nextSearchIndex < 0) {
                    this.nextState = 0;
                    this.nextItem = null;
                    return;
                }
                if(DelimitedRangesSequence.this.limit > 0) {
                    int v1 = this.counter + 1;
                    this.counter = v1;
                    if(v1 >= DelimitedRangesSequence.this.limit) {
                        this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.this.input));
                        this.nextSearchIndex = -1;
                        this.nextState = 1;
                        return;
                    }
                    goto label_12;
                }
                else {
                label_12:
                    if(this.nextSearchIndex > DelimitedRangesSequence.this.input.length()) {
                        this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.this.input));
                        this.nextSearchIndex = -1;
                    }
                    else {
                        Pair pair0 = (Pair)DelimitedRangesSequence.this.getNextMatch.invoke(DelimitedRangesSequence.this.input, this.nextSearchIndex);
                        if(pair0 == null) {
                            this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(DelimitedRangesSequence.this.input));
                            this.nextSearchIndex = -1;
                        }
                        else {
                            int v2 = ((Number)pair0.component1()).intValue();
                            int v3 = ((Number)pair0.component2()).intValue();
                            this.nextItem = RangesKt.until(this.currentStartIndex, v2);
                            int v4 = v2 + v3;
                            this.currentStartIndex = v4;
                            if(v3 == 0) {
                                v = 1;
                            }
                            this.nextSearchIndex = v4 + v;
                        }
                    }
                }
                this.nextState = 1;
            }

            public final int getCounter() {
                return this.counter;
            }

            public final int getCurrentStartIndex() {
                return this.currentStartIndex;
            }

            public final IntRange getNextItem() {
                return this.nextItem;
            }

            public final int getNextSearchIndex() {
                return this.nextSearchIndex;
            }

            public final int getNextState() {
                return this.nextState;
            }

            @Override
            public boolean hasNext() {
                if(this.nextState == -1) {
                    this.calcNext();
                }
                return this.nextState == 1;
            }

            @Override
            public Object next() {
                return this.next();
            }

            public IntRange next() {
                if(this.nextState == -1) {
                    this.calcNext();
                }
                if(this.nextState == 0) {
                    throw new NoSuchElementException();
                }
                IntRange intRange0 = this.nextItem;
                Intrinsics.checkNotNull(intRange0, UnityPlayerActivity.adjustValue("0005010D4E02060B1C01044D030B410404011A50190E4E0F080B5F0005010D4E151E15174E1B02150208094B000F1E0A041D4F2E0B063C1103060B"));
                this.nextItem = null;
                this.nextState = -1;
                return intRange0;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("210008130F150E0A1C4E191E41000E1345011B001D0E1C15020152081F1F411C0406015F011E01184E0208091E0B131908010F"));
            }

            public final void setCounter(int v) {
                this.counter = v;
            }

            public final void setCurrentStartIndex(int v) {
                this.currentStartIndex = v;
            }

            public final void setNextItem(IntRange intRange0) {
                this.nextItem = intRange0;
            }

            public final void setNextSearchIndex(int v) {
                this.nextSearchIndex = v;
            }

            public final void setNextState(int v) {
                this.nextState = v;
            }
        };
    }
}

