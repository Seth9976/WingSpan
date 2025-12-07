package kotlin.io;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/FileWalkDirection;", "", "(Ljava/lang/String;I)V", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class FileWalkDirection extends Enum {
    private static final FileWalkDirection[] $VALUES;
    public static final enum FileWalkDirection BOTTOM_UP;
    public static final enum FileWalkDirection TOP_DOWN;

    private static final FileWalkDirection[] $values() [...] // Inlined contents

    static {
        FileWalkDirection.TOP_DOWN = new FileWalkDirection(UnityPlayerActivity.adjustValue("3A3F3D3E2A2E302B"), 0);
        FileWalkDirection.BOTTOM_UP = new FileWalkDirection(UnityPlayerActivity.adjustValue("2C3F3935212C383022"), 1);
        FileWalkDirection.$VALUES = new FileWalkDirection[]{FileWalkDirection.TOP_DOWN, FileWalkDirection.BOTTOM_UP};
    }

    private FileWalkDirection(String s, int v) {
        super(s, v);
    }

    public static FileWalkDirection valueOf(String s) {
        return (FileWalkDirection)Enum.valueOf(FileWalkDirection.class, s);
    }

    public static FileWalkDirection[] values() {
        return (FileWalkDirection[])FileWalkDirection.$VALUES.clone();
    }
}

