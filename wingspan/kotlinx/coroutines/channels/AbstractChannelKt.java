package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\u001A#\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u0004\u0018\u00010\u0014H\u0082\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001A%\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u0013*\u0006\u0012\u0002\b\u00030\u0016H\u0082\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\"\u0016\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000B\u0010\u0003\"\u0016\u0010\f\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0003\"\u000E\u0010\u000E\u001A\u00020\u000FX\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u000FX\u0080T¢\u0006\u0002\n\u0000*(\b\u0000\u0010\u0018\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0012\u0004\u0012\u00020\u001B0\u00192\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001A\u0012\u0004\u0012\u00020\u001B0\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001C"}, d2 = {"EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "getEMPTY$annotations", "()V", "ENQUEUE_FAILED", "getENQUEUE_FAILED$annotations", "HANDLER_INVOKED", "getHANDLER_INVOKED$annotations", "OFFER_FAILED", "getOFFER_FAILED$annotations", "OFFER_SUCCESS", "getOFFER_SUCCESS$annotations", "POLL_FAILED", "getPOLL_FAILED$annotations", "RECEIVE_RESULT", "", "RECEIVE_THROWS_ON_CLOSE", "toResult", "Lkotlinx/coroutines/channels/ChannelResult;", "E", "", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Closed;", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Object;", "Handler", "Lkotlin/Function1;", "", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class AbstractChannelKt {
    public static final Symbol EMPTY = null;
    public static final Symbol ENQUEUE_FAILED = null;
    public static final Symbol HANDLER_INVOKED = null;
    public static final Symbol OFFER_FAILED = null;
    public static final Symbol OFFER_SUCCESS = null;
    public static final Symbol POLL_FAILED = null;
    public static final int RECEIVE_RESULT = 1;
    public static final int RECEIVE_THROWS_ON_CLOSE;

    static {
        AbstractChannelKt.EMPTY = new Symbol(UnityPlayerActivity.adjustValue("2B3D3D3537"));
        AbstractChannelKt.OFFER_SUCCESS = new Symbol(UnityPlayerActivity.adjustValue("21362B243C3E3430312D353E32"));
        AbstractChannelKt.OFFER_FAILED = new Symbol(UnityPlayerActivity.adjustValue("21362B243C3E21243B223529"));
        AbstractChannelKt.POLL_FAILED = new Symbol(UnityPlayerActivity.adjustValue("3E3F212D3127262C3E2B34"));
        AbstractChannelKt.ENQUEUE_FAILED = new Symbol(UnityPlayerActivity.adjustValue("2B3E3C342B34223A342F3921242A"));
        AbstractChannelKt.HANDLER_INVOKED = new Symbol(UnityPlayerActivity.adjustValue("213E3222222E34202D263123252224353A3B2026222A2B25"));
    }

    public static void getEMPTY$annotations() {
    }

    public static void getENQUEUE_FAILED$annotations() {
    }

    public static void getHANDLER_INVOKED$annotations() {
    }

    public static void getOFFER_FAILED$annotations() {
    }

    public static void getOFFER_SUCCESS$annotations() {
    }

    public static void getPOLL_FAILED$annotations() {
    }

    // 去混淆评级： 低(20)
    private static final Object toResult(Object object0) {
        return object0 instanceof Closed ? ChannelResult.Companion.closed-JP2dKIU(((Closed)object0).closeCause) : ChannelResult.Companion.success-JP2dKIU(object0);
    }

    private static final Object toResult(Closed closed0) {
        return ChannelResult.Companion.closed-JP2dKIU(closed0.closeCause);
    }
}

