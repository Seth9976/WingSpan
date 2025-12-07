package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0007H\u0000\u001A\u0010\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0007H\u0000\"\u0016\u0010\u0000\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001A\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000*\u001E\b\u0002\u0010\u0012\u001A\u0004\b\u0000\u0010\u0013\"\b\u0012\u0004\u0012\u0002H\u00130\u00142\b\u0012\u0004\u0012\u0002H\u00130\u0014¨\u0006\u0015"}, d2 = {"CLOSED_EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "getCLOSED_EMPTY$annotations", "()V", "DISPOSED_TASK", "getDISPOSED_TASK$annotations", "MAX_DELAY_NS", "", "MAX_MS", "MS_TO_NS", "SCHEDULE_COMPLETED", "", "SCHEDULE_DISPOSED", "SCHEDULE_OK", "delayNanosToMillis", "timeNanos", "delayToNanos", "timeMillis", "Queue", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class EventLoop_commonKt {
    private static final Symbol CLOSED_EMPTY = null;
    private static final Symbol DISPOSED_TASK = null;
    private static final long MAX_DELAY_NS = 0x3FFFFFFFFFFFFFFFL;
    private static final long MAX_MS = 0x8637BD05AF6L;
    private static final long MS_TO_NS = 1000000L;
    private static final int SCHEDULE_COMPLETED = 1;
    private static final int SCHEDULE_DISPOSED = 2;
    private static final int SCHEDULE_OK;

    static {
        EventLoop_commonKt.DISPOSED_TASK = new Symbol(UnityPlayerActivity.adjustValue("3C35202E3824233A262F2326"));
        EventLoop_commonKt.CLOSED_EMPTY = new Symbol(UnityPlayerActivity.adjustValue("2D3C22322B2538203F3E2434"));
    }

    public static final Symbol access$getCLOSED_EMPTY$p() {
        return EventLoop_commonKt.CLOSED_EMPTY;
    }

    public static final Symbol access$getDISPOSED_TASK$p() {
        return EventLoop_commonKt.DISPOSED_TASK;
    }

    public static final long delayNanosToMillis(long v) [...] // Inlined contents

    public static final long delayToNanos(long v) {
        if(v > 0L) {
            return v < 0x8637BD05AF6L ? 1000000L * v : 0x7FFFFFFFFFFFFFFFL;
        }
        return 0L;
    }

    private static void getCLOSED_EMPTY$annotations() {
    }

    private static void getDISPOSED_TASK$annotations() {
    }
}

