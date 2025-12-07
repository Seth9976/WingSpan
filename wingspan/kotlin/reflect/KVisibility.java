package kotlin.reflect;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/KVisibility;", "", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class KVisibility extends Enum {
    private static final KVisibility[] $VALUES;
    public static final enum KVisibility INTERNAL;
    public static final enum KVisibility PRIVATE;
    public static final enum KVisibility PROTECTED;
    public static final enum KVisibility PUBLIC;

    private static final KVisibility[] $values() [...] // Inlined contents

    static {
        KVisibility.PUBLIC = new KVisibility(UnityPlayerActivity.adjustValue("3E252F2D2722"), 0);
        KVisibility.PROTECTED = new KVisibility(UnityPlayerActivity.adjustValue("3E2222352B22332036"), 1);
        KVisibility.INTERNAL = new KVisibility(UnityPlayerActivity.adjustValue("273E39243C2F2629"), 2);
        KVisibility.PRIVATE = new KVisibility(UnityPlayerActivity.adjustValue("3E2224372F3522"), 3);
        KVisibility.$VALUES = new KVisibility[]{KVisibility.PUBLIC, KVisibility.PROTECTED, KVisibility.INTERNAL, KVisibility.PRIVATE};
    }

    private KVisibility(String s, int v) {
        super(s, v);
    }

    public static KVisibility valueOf(String s) {
        return (KVisibility)Enum.valueOf(KVisibility.class, s);
    }

    public static KVisibility[] values() {
        return (KVisibility[])KVisibility.$VALUES.clone();
    }
}

