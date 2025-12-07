package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\u001A\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\"\u0016\u0010\u0000\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001A\u00020\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000B\u001A\u00020\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u000E\u0010\r\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003\"\u0016\u0010\u0012\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003\"\u000E\u0010\u0014\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "getCOMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "getCOMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "getEMPTY_ACTIVE$annotations", "EMPTY_NEW", "getEMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "getSEALED$annotations", "TOO_LATE_TO_CANCEL", "getTOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class JobSupportKt {
    private static final Symbol COMPLETING_ALREADY = null;
    private static final Symbol COMPLETING_RETRY = null;
    public static final Symbol COMPLETING_WAITING_CHILDREN = null;
    private static final Empty EMPTY_ACTIVE = null;
    private static final Empty EMPTY_NEW = null;
    private static final int FALSE = 0;
    private static final int RETRY = -1;
    private static final Symbol SEALED = null;
    private static final Symbol TOO_LATE_TO_CANCEL = null;
    private static final int TRUE = 1;

    static {
        JobSupportKt.COMPLETING_ALREADY = new Symbol(UnityPlayerActivity.adjustValue("2D3F20312224332C3C292F2C2D3C2426212B"));
        JobSupportKt.COMPLETING_WAITING_CHILDREN = new Symbol(UnityPlayerActivity.adjustValue("2D3F20312224332C3C292F3A2027352E2B3531332528222535203C"));
        JobSupportKt.COMPLETING_RETRY = new Symbol(UnityPlayerActivity.adjustValue("2D3F20312224332C3C292F3F243A333E"));
        JobSupportKt.TOO_LATE_TO_CANCEL = new Symbol(UnityPlayerActivity.adjustValue("3A3F223E222033202D3A3F32222F2F24203E"));
        JobSupportKt.SEALED = new Symbol(UnityPlayerActivity.adjustValue("3D352C2D2B25"));
        JobSupportKt.EMPTY_NEW = new Empty(false);
        JobSupportKt.EMPTY_ACTIVE = new Empty(true);
    }

    public static final Symbol access$getCOMPLETING_ALREADY$p() {
        return JobSupportKt.COMPLETING_ALREADY;
    }

    public static final Symbol access$getCOMPLETING_RETRY$p() {
        return JobSupportKt.COMPLETING_RETRY;
    }

    public static final Empty access$getEMPTY_ACTIVE$p() {
        return JobSupportKt.EMPTY_ACTIVE;
    }

    public static final Empty access$getEMPTY_NEW$p() {
        return JobSupportKt.EMPTY_NEW;
    }

    public static final Symbol access$getSEALED$p() {
        return JobSupportKt.SEALED;
    }

    public static final Symbol access$getTOO_LATE_TO_CANCEL$p() {
        return JobSupportKt.TOO_LATE_TO_CANCEL;
    }

    public static final Object boxIncomplete(Object object0) {
        return object0 instanceof Incomplete ? new IncompleteStateBox(((Incomplete)object0)) : object0;
    }

    private static void getCOMPLETING_ALREADY$annotations() {
    }

    private static void getCOMPLETING_RETRY$annotations() {
    }

    public static void getCOMPLETING_WAITING_CHILDREN$annotations() {
    }

    private static void getEMPTY_ACTIVE$annotations() {
    }

    private static void getEMPTY_NEW$annotations() {
    }

    private static void getSEALED$annotations() {
    }

    private static void getTOO_LATE_TO_CANCEL$annotations() {
    }

    public static final Object unboxState(Object object0) {
        IncompleteStateBox incompleteStateBox0 = object0 instanceof IncompleteStateBox ? ((IncompleteStateBox)object0) : null;
        if(incompleteStateBox0 != null) {
            Incomplete incomplete0 = incompleteStateBox0.state;
            if(incomplete0 != null) {
                return incomplete0;
            }
        }
        return object0;
    }
}

