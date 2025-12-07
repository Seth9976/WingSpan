package kotlin.io;

import com.unity3d.player.UnityPlayerActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001A\u0011\u0010\u000B\u001A\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001A\u001C\u0010\u000E\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0000\u001A\f\u0010\u0011\u001A\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001A\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001A\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt {
    public static final File getRoot(File file0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new File(FilesKt.getRootName(file0));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String s) {
        int v = StringsKt.indexOf$default(s, File.separatorChar, 0, false, 4, null);
        if(v == 0) {
            if(s.length() > 1 && s.charAt(1) == File.separatorChar) {
                int v1 = StringsKt.indexOf$default(s, File.separatorChar, 2, false, 4, null);
                if(v1 >= 0) {
                    int v2 = StringsKt.indexOf$default(s, File.separatorChar, v1 + 1, false, 4, null);
                    return v2 < 0 ? s.length() : v2 + 1;
                }
            }
            return 1;
        }
        if(v > 0 && s.charAt(v - 1) == 58) {
            return v + 1;
        }
        return v != -1 || !StringsKt.endsWith$default(s, ':', false, 2, null) ? 0 : s.length();
    }

    public static final String getRootName(File file0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s = file0.getPath();
        String s1 = UnityPlayerActivity.adjustValue("1E111909");
        Intrinsics.checkNotNullExpressionValue(s, s1);
        String s2 = file0.getPath();
        Intrinsics.checkNotNullExpressionValue(s2, s1);
        String s3 = s.substring(0, FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(s2));
        Intrinsics.checkNotNullExpressionValue(s3, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
        return s3;
    }

    public static final boolean isRooted(File file0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s = file0.getPath();
        Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("1E111909"));
        return FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(s) > 0;
    }

    public static final File subPath(File file0, int v, int v1) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return FilesKt.toComponents(file0).subPath(v, v1);
    }

    public static final FilePathComponents toComponents(File file0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        String s = file0.getPath();
        Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("1E111909"));
        int v = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt(s);
        String s1 = s.substring(0, v);
        Intrinsics.checkNotNullExpressionValue(s1, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F08000685E5D4071E0A491D15061706271E0904164D47001C0A3903050B194E"));
        String s2 = s.substring(v);
        Intrinsics.checkNotNullExpressionValue(s2, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B011B121E151C0809025A1D040C131A280901171659"));
        if(s2.length() == 0) {
            List list0 = CollectionsKt.emptyList();
            return new FilePathComponents(new File(s1), list0);
        }
        Iterable iterable0 = StringsKt.split$default(s2, new char[]{File.separatorChar}, false, 0, 6, null);
        ArrayList arrayList0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable0, 10));
        for(Object object0: iterable0) {
            arrayList0.add(new File(((String)object0)));
        }
        return new FilePathComponents(new File(s1), arrayList0);
    }
}

