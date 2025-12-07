package kotlin.reflect;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/KVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class KVariance extends Enum {
    private static final KVariance[] $VALUES;
    public static final enum KVariance IN;
    public static final enum KVariance INVARIANT;
    public static final enum KVariance OUT;

    private static final KVariance[] $values() [...] // Inlined contents

    static {
        KVariance.INVARIANT = new KVariance(UnityPlayerActivity.adjustValue("273E3B203C28262B26"), 0);
        KVariance.IN = new KVariance(UnityPlayerActivity.adjustValue("273E"), 1);
        KVariance.OUT = new KVariance(UnityPlayerActivity.adjustValue("212539"), 2);
        KVariance.$VALUES = new KVariance[]{KVariance.INVARIANT, KVariance.IN, KVariance.OUT};
    }

    private KVariance(String s, int v) {
        super(s, v);
    }

    public static KVariance valueOf(String s) {
        return (KVariance)Enum.valueOf(KVariance.class, s);
    }

    public static KVariance[] values() {
        return (KVariance[])KVariance.$VALUES.clone();
    }
}

