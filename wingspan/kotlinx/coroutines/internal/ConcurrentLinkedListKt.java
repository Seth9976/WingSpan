package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001A#\u0010\u0002\u001A\u00028\u0000\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001Ao\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\r\"\u000E\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u00028\u00002\u0006\u0010\u0007\u001A\u00020\u000628\u0010\f\u001A4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0004\u0012\u00028\u00000\bH\u0082\bø\u0001\u0000¢\u0006\u0004\b\u000E\u0010\u000F\"\u001A\u0010\u0011\u001A\u00020\u00108\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/internal/Segment;", "S", "", "id", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "createNewSegment", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "getCLOSED$annotations", "()V", "", "POINTERS_SHIFT", "I", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = null;
    private static final int POINTERS_SHIFT = 16;

    static {
        ConcurrentLinkedListKt.CLOSED = new Symbol(UnityPlayerActivity.adjustValue("2D3C22322B25"));
    }

    public static final ConcurrentLinkedListNode close(ConcurrentLinkedListNode concurrentLinkedListNode0) {
        while(true) {
            Object object0 = ConcurrentLinkedListNode.access$getNextOrClosed(concurrentLinkedListNode0);
            if(object0 == ConcurrentLinkedListKt.CLOSED) {
                return concurrentLinkedListNode0;
            }
            if(((ConcurrentLinkedListNode)object0) == null) {
                if(!concurrentLinkedListNode0.markAsClosed()) {
                    continue;
                }
                return concurrentLinkedListNode0;
            }
            concurrentLinkedListNode0 = (ConcurrentLinkedListNode)object0;
        }
    }

    private static final Object findSegmentInternal(Segment segment0, long v, Function2 function20) {
        while(true) {
            if(segment0.getId() >= v && !segment0.getRemoved()) {
                return segment0;
            }
            Object object0 = ConcurrentLinkedListNode.access$getNextOrClosed(segment0);
            if(object0 == ConcurrentLinkedListKt.CLOSED) {
                return ConcurrentLinkedListKt.CLOSED;
            }
            Segment segment1 = (Segment)(((ConcurrentLinkedListNode)object0));
            if(segment1 == null) {
                segment1 = (Segment)function20.invoke(((long)(segment0.getId() + 1L)), segment0);
                if(!segment0.trySetNext(segment1)) {
                    continue;
                }
                if(segment0.getRemoved()) {
                    segment0.remove();
                }
            }
            segment0 = segment1;
        }
    }

    private static void getCLOSED$annotations() {
    }
}

