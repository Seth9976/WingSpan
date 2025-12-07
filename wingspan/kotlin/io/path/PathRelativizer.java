package kotlin.io.path;

import com.unity3d.player.UnityPlayerActivity;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0004R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
final class PathRelativizer {
    public static final PathRelativizer INSTANCE;
    private static final Path emptyPath;
    private static final Path parentPath;

    static {
        PathRelativizer.INSTANCE = new PathRelativizer();
        PathRelativizer.emptyPath = Paths.get(UnityPlayerActivity.adjustValue(""), new String[0]);
        PathRelativizer.parentPath = Paths.get(UnityPlayerActivity.adjustValue("405E"), new String[0]);
    }

    public final Path tryRelativeTo(Path path0, Path path1) {
        Intrinsics.checkNotNullParameter(path0, UnityPlayerActivity.adjustValue("1E111909"));
        Intrinsics.checkNotNullParameter(path1, UnityPlayerActivity.adjustValue("0C111E04"));
        Path path2 = path1.normalize();
        Path path3 = path0.normalize();
        Path path4 = path2.relativize(path3);
        int v = Math.min(path2.getNameCount(), path3.getNameCount());
        for(int v1 = 0; v1 < v; ++v1) {
            Path path5 = path2.getName(v1);
            Path path6 = PathRelativizer.parentPath;
            if(!Intrinsics.areEqual(path5, path6)) {
                break;
            }
            if(!Intrinsics.areEqual(path3.getName(v1), path6)) {
                throw new IllegalArgumentException(UnityPlayerActivity.adjustValue("3B1E0C03020447111D4E13020C1E141300521C1501001A081100521E111909"));
            }
        }
        if(Intrinsics.areEqual(path3, path2) || !Intrinsics.areEqual(path2, PathRelativizer.emptyPath)) {
            String s = path4.toString();
            String s1 = path4.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1C1E4307070D02360B1D04080C40120215131C11190E1C"));
            path3 = StringsKt.endsWith$default(s, s1, false, 2, null) ? path4.getFileSystem().getPath(StringsKt.dropLast(s, path4.getFileSystem().getSeparator().length()), new String[0]) : path4;
        }
        Intrinsics.checkNotNullExpressionValue(path3, UnityPlayerActivity.adjustValue("1C"));
        return path3;
    }
}

