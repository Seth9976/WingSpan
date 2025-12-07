package kotlin.io.path;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/io/path/PathWalkOption;", "", "(Ljava/lang/String;I)V", "INCLUDE_DIRECTORIES", "BREADTH_FIRST", "FOLLOW_LINKS", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PathWalkOption extends Enum {
    private static final PathWalkOption[] $VALUES;
    public static final enum PathWalkOption BREADTH_FIRST;
    public static final enum PathWalkOption FOLLOW_LINKS;
    public static final enum PathWalkOption INCLUDE_DIRECTORIES;

    private static final PathWalkOption[] $values() [...] // Inlined contents

    static {
        PathWalkOption.INCLUDE_DIRECTORIES = new PathWalkOption(UnityPlayerActivity.adjustValue("273E2E2D3B25223A36272228223A2E352C373D"), 0);
        PathWalkOption.BREADTH_FIRST = new PathWalkOption(UnityPlayerActivity.adjustValue("2C2228202A352F3A3427223E35"), 1);
        PathWalkOption.FOLLOW_LINKS = new PathWalkOption(UnityPlayerActivity.adjustValue("283F212D213638293B203B3E"), 2);
        PathWalkOption.$VALUES = new PathWalkOption[]{PathWalkOption.INCLUDE_DIRECTORIES, PathWalkOption.BREADTH_FIRST, PathWalkOption.FOLLOW_LINKS};
    }

    private PathWalkOption(String s, int v) {
        super(s, v);
    }

    public static PathWalkOption valueOf(String s) {
        return (PathWalkOption)Enum.valueOf(PathWalkOption.class, s);
    }

    public static PathWalkOption[] values() {
        return (PathWalkOption[])PathWalkOption.$VALUES.clone();
    }
}

