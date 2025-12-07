package kotlinx.coroutines.channels;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/TickerMode;", "", "(Ljava/lang/String;I)V", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class TickerMode extends Enum {
    private static final TickerMode[] $VALUES;
    public static final enum TickerMode FIXED_DELAY;
    public static final enum TickerMode FIXED_PERIOD;

    private static final TickerMode[] $values() [...] // Inlined contents

    static {
        TickerMode.FIXED_PERIOD = new TickerMode(UnityPlayerActivity.adjustValue("283935242A3E372020273F29"), 0);
        TickerMode.FIXED_DELAY = new TickerMode(UnityPlayerActivity.adjustValue("283935242A3E23203E2F29"), 1);
        TickerMode.$VALUES = new TickerMode[]{TickerMode.FIXED_PERIOD, TickerMode.FIXED_DELAY};
    }

    private TickerMode(String s, int v) {
        super(s, v);
    }

    public static TickerMode valueOf(String s) {
        return (TickerMode)Enum.valueOf(TickerMode.class, s);
    }

    public static TickerMode[] values() {
        return (TickerMode[])TickerMode.$VALUES.clone();
    }
}

