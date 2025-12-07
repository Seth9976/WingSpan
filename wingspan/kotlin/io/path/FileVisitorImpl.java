package kotlin.io.path;

import com.unity3d.player.UnityPlayerActivity;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bw\u0012\u001A\u0010\u0003\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001A\u0010\u0007\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001C\u0010\n\u001A\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u000BJ\u001A\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00022\b\u0010\u000E\u001A\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000F\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u0005H\u0016J\u0018\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u0005H\u0016J\u0018\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\tH\u0016R$\u0010\n\u001A\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0003\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "postVisitDirectory", "dir", "exc", "preVisitDirectory", "attrs", "visitFile", "file", "visitFileFailed", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
final class FileVisitorImpl extends SimpleFileVisitor {
    private final Function2 onPostVisitDirectory;
    private final Function2 onPreVisitDirectory;
    private final Function2 onVisitFile;
    private final Function2 onVisitFileFailed;

    public FileVisitorImpl(Function2 function20, Function2 function21, Function2 function22, Function2 function23) {
        this.onPreVisitDirectory = function20;
        this.onVisitFile = function21;
        this.onVisitFileFailed = function22;
        this.onPostVisitDirectory = function23;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object object0, IOException iOException0) {
        return this.postVisitDirectory(((Path)object0), iOException0);
    }

    public FileVisitResult postVisitDirectory(Path path0, IOException iOException0) {
        FileVisitResult fileVisitResult0;
        Intrinsics.checkNotNullParameter(path0, UnityPlayerActivity.adjustValue("0A191F"));
        Function2 function20 = this.onPostVisitDirectory;
        if(function20 == null) {
            fileVisitResult0 = super.postVisitDirectory(path0, iOException0);
            Intrinsics.checkNotNullExpressionValue(fileVisitResult0, UnityPlayerActivity.adjustValue("1D051D041C4F170A011A2604120715230C000B13190E1C184F011B1C5C4D0416024E"));
        }
        else {
            fileVisitResult0 = (FileVisitResult)function20.invoke(path0, iOException0);
            if(fileVisitResult0 == null) {
                fileVisitResult0 = super.postVisitDirectory(path0, iOException0);
                Intrinsics.checkNotNullExpressionValue(fileVisitResult0, UnityPlayerActivity.adjustValue("1D051D041C4F170A011A2604120715230C000B13190E1C184F011B1C5C4D0416024E"));
                return fileVisitResult0;
            }
        }
        return fileVisitResult0;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object object0, BasicFileAttributes basicFileAttributes0) {
        return this.preVisitDirectory(((Path)object0), basicFileAttributes0);
    }

    public FileVisitResult preVisitDirectory(Path path0, BasicFileAttributes basicFileAttributes0) {
        FileVisitResult fileVisitResult0;
        Intrinsics.checkNotNullParameter(path0, UnityPlayerActivity.adjustValue("0A191F"));
        Intrinsics.checkNotNullParameter(basicFileAttributes0, UnityPlayerActivity.adjustValue("0F0419131D"));
        Function2 function20 = this.onPreVisitDirectory;
        if(function20 == null) {
            fileVisitResult0 = super.preVisitDirectory(path0, basicFileAttributes0);
            Intrinsics.checkNotNullExpressionValue(fileVisitResult0, UnityPlayerActivity.adjustValue("1D051D041C4F17171738191E081A250E17170D0402131749030C0042500C151A13144C"));
        }
        else {
            fileVisitResult0 = (FileVisitResult)function20.invoke(path0, basicFileAttributes0);
            if(fileVisitResult0 == null) {
                fileVisitResult0 = super.preVisitDirectory(path0, basicFileAttributes0);
                Intrinsics.checkNotNullExpressionValue(fileVisitResult0, UnityPlayerActivity.adjustValue("1D051D041C4F17171738191E081A250E17170D0402131749030C0042500C151A13144C"));
                return fileVisitResult0;
            }
        }
        return fileVisitResult0;
    }

    @Override
    public FileVisitResult visitFile(Object object0, BasicFileAttributes basicFileAttributes0) {
        return this.visitFile(((Path)object0), basicFileAttributes0);
    }

    public FileVisitResult visitFile(Path path0, BasicFileAttributes basicFileAttributes0) {
        FileVisitResult fileVisitResult0;
        Intrinsics.checkNotNullParameter(path0, UnityPlayerActivity.adjustValue("08190104"));
        Intrinsics.checkNotNullParameter(basicFileAttributes0, UnityPlayerActivity.adjustValue("0F0419131D"));
        Function2 function20 = this.onVisitFile;
        if(function20 == null) {
            fileVisitResult0 = super.visitFile(path0, basicFileAttributes0);
            Intrinsics.checkNotNullExpressionValue(fileVisitResult0, UnityPlayerActivity.adjustValue("1D051D041C4F110C0107042B0802044F031B021541410F1513170147"));
        }
        else {
            fileVisitResult0 = (FileVisitResult)function20.invoke(path0, basicFileAttributes0);
            if(fileVisitResult0 == null) {
                fileVisitResult0 = super.visitFile(path0, basicFileAttributes0);
                Intrinsics.checkNotNullExpressionValue(fileVisitResult0, UnityPlayerActivity.adjustValue("1D051D041C4F110C0107042B0802044F031B021541410F1513170147"));
                return fileVisitResult0;
            }
        }
        return fileVisitResult0;
    }

    @Override
    public FileVisitResult visitFileFailed(Object object0, IOException iOException0) {
        return this.visitFileFailed(((Path)object0), iOException0);
    }

    public FileVisitResult visitFileFailed(Path path0, IOException iOException0) {
        FileVisitResult fileVisitResult0;
        Intrinsics.checkNotNullParameter(path0, UnityPlayerActivity.adjustValue("08190104"));
        Intrinsics.checkNotNullParameter(iOException0, UnityPlayerActivity.adjustValue("0B080E"));
        Function2 function20 = this.onVisitFileFailed;
        if(function20 == null) {
            fileVisitResult0 = super.visitFileFailed(path0, iOException0);
            Intrinsics.checkNotNullExpressionValue(fileVisitResult0, UnityPlayerActivity.adjustValue("1D051D041C4F110C0107042B08020421041B0215094908080B005E4E15150247"));
        }
        else {
            fileVisitResult0 = (FileVisitResult)function20.invoke(path0, iOException0);
            if(fileVisitResult0 == null) {
                fileVisitResult0 = super.visitFileFailed(path0, iOException0);
                Intrinsics.checkNotNullExpressionValue(fileVisitResult0, UnityPlayerActivity.adjustValue("1D051D041C4F110C0107042B08020421041B0215094908080B005E4E15150247"));
                return fileVisitResult0;
            }
        }
        return fileVisitResult0;
    }
}

