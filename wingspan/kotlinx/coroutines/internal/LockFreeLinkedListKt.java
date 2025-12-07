package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0010\u001A\u00060\u0011j\u0002`\u0012*\u00020\u0001H\u0001\"\u001C\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001A\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001A\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u001C\u0010\t\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\u0005\"\u0016\u0010\f\u001A\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0003\"\u0016\u0010\u000E\u001A\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000F\u0010\u0003*\n\u0010\u0013\"\u00020\u00142\u00020\u0014*\u001C\u0010\u0015\u001A\u0004\b\u0000\u0010\u0016\"\b\u0012\u0004\u0012\u0002H\u00160\u00172\b\u0012\u0004\u0012\u0002H\u00160\u0017*\f\b\u0002\u0010\u0018\"\u00020\u00112\u00020\u0011*\n\u0010\u0019\"\u00020\u001A2\u00020\u001A*\u001C\u0010\u001B\u001A\u0004\b\u0000\u0010\u0016\"\b\u0012\u0004\u0012\u0002H\u00160\u001C2\b\u0012\u0004\u0012\u0002H\u00160\u001C¨\u0006\u001D"}, d2 = {"CONDITION_FALSE", "", "getCONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "getFAILURE$annotations", "LIST_EMPTY", "getLIST_EMPTY$annotations", "getLIST_EMPTY", "SUCCESS", "getSUCCESS$annotations", "UNDECIDED", "getUNDECIDED$annotations", "unwrap", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "AbstractAtomicDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AddLastDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Node", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "RemoveFirstDesc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class LockFreeLinkedListKt {
    private static final Object CONDITION_FALSE = null;
    public static final int FAILURE = 2;
    private static final Object LIST_EMPTY = null;
    public static final int SUCCESS = 1;
    public static final int UNDECIDED;

    static {
        LockFreeLinkedListKt.CONDITION_FALSE = new Symbol(UnityPlayerActivity.adjustValue("2D3F232527352E2A3C31362C2D3D24"));
        LockFreeLinkedListKt.LIST_EMPTY = new Symbol(UnityPlayerActivity.adjustValue("22393E3531242A352637"));
    }

    public static final Object getCONDITION_FALSE() {
        return LockFreeLinkedListKt.CONDITION_FALSE;
    }

    public static void getCONDITION_FALSE$annotations() {
    }

    public static void getFAILURE$annotations() {
    }

    public static final Object getLIST_EMPTY() {
        return LockFreeLinkedListKt.LIST_EMPTY;
    }

    public static void getLIST_EMPTY$annotations() {
    }

    public static void getSUCCESS$annotations() {
    }

    public static void getUNDECIDED$annotations() {
    }

    public static final LockFreeLinkedListNode unwrap(Object object0) {
        Removed removed0 = object0 instanceof Removed ? ((Removed)object0) : null;
        if(removed0 != null) {
            return removed0.ref == null ? ((LockFreeLinkedListNode)object0) : removed0.ref;
        }
        return (LockFreeLinkedListNode)object0;
    }
}

