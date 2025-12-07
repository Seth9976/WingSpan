package kotlinx.coroutines.flow;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "", "(Ljava/lang/String;I)V", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class SharingCommand extends Enum {
    private static final SharingCommand[] $VALUES;
    public static final enum SharingCommand START;
    public static final enum SharingCommand STOP;
    public static final enum SharingCommand STOP_AND_RESET_REPLAY_CACHE;

    private static final SharingCommand[] $values() [...] // Inlined contents

    static {
        SharingCommand.START = new SharingCommand(UnityPlayerActivity.adjustValue("3D242C333A"), 0);
        SharingCommand.STOP = new SharingCommand(UnityPlayerActivity.adjustValue("3D242231"), 1);
        SharingCommand.STOP_AND_RESET_REPLAY_CACHE = new SharingCommand(UnityPlayerActivity.adjustValue("3D242231312029212D3C353E243A3E3520222231343E2D20242D37"), 2);
        SharingCommand.$VALUES = new SharingCommand[]{SharingCommand.START, SharingCommand.STOP, SharingCommand.STOP_AND_RESET_REPLAY_CACHE};
    }

    private SharingCommand(String s, int v) {
        super(s, v);
    }

    public static SharingCommand valueOf(String s) {
        return (SharingCommand)Enum.valueOf(SharingCommand.class, s);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[])SharingCommand.$VALUES.clone();
    }
}

