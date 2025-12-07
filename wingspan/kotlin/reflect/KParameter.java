package kotlin.reflect;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0018R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\bR\u001A\u0010\t\u001A\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\t\u0010\bR\u0012\u0010\f\u001A\u00020\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001A\u00020\u0015X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", "index", "", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "isVararg$annotations", "()V", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "Kind", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface KParameter extends KAnnotatedElement {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static void isVararg$annotations() {
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/KParameter$Kind;", "", "(Ljava/lang/String;I)V", "INSTANCE", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Kind extends Enum {
        private static final Kind[] $VALUES;
        public static final enum Kind EXTENSION_RECEIVER;
        public static final enum Kind INSTANCE;
        public static final enum Kind VALUE;

        private static final Kind[] $values() [...] // Inlined contents

        static {
            Kind.INSTANCE = new Kind(UnityPlayerActivity.adjustValue("273E3E352F2F2420"), 0);
            Kind.EXTENSION_RECEIVER = new Kind(UnityPlayerActivity.adjustValue("2B28392420322E2A3C312228222B28312020"), 1);
            Kind.VALUE = new Kind(UnityPlayerActivity.adjustValue("383121342B"), 2);
            Kind.$VALUES = new Kind[]{Kind.INSTANCE, Kind.EXTENSION_RECEIVER, Kind.VALUE};
        }

        private Kind(String s, int v) {
            super(s, v);
        }

        public static Kind valueOf(String s) {
            return (Kind)Enum.valueOf(Kind.class, s);
        }

        public static Kind[] values() {
            return (Kind[])Kind.$VALUES.clone();
        }
    }

    int getIndex();

    Kind getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}

