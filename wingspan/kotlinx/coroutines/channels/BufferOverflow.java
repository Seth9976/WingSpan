package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class BufferOverflow extends Enum {
    private static final BufferOverflow[] $VALUES;
    public static final enum BufferOverflow DROP_LATEST;
    public static final enum BufferOverflow DROP_OLDEST;
    public static final enum BufferOverflow SUSPEND;

    private static final BufferOverflow[] $values() [...] // Inlined contents

    static {
        BufferOverflow.SUSPEND = new BufferOverflow(UnityPlayerActivity.adjustValue("3D253E312B2F23"), 0);
        BufferOverflow.DROP_OLDEST = new BufferOverflow(UnityPlayerActivity.adjustValue("2A222231312E2B21373D24"), 1);
        BufferOverflow.DROP_LATEST = new BufferOverflow(UnityPlayerActivity.adjustValue("2A222231312D2631373D24"), 2);
        BufferOverflow.$VALUES = new BufferOverflow[]{BufferOverflow.SUSPEND, BufferOverflow.DROP_OLDEST, BufferOverflow.DROP_LATEST};
    }

    private BufferOverflow(String s, int v) {
        super(s, v);
    }

    public static BufferOverflow valueOf(String s) {
        return (BufferOverflow)Enum.valueOf(BufferOverflow.class, s);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[])BufferOverflow.$VALUES.clone();
    }
}

