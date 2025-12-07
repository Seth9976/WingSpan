package androidx.work.impl.workers;

import androidx.work.ListenableWorker.Result;
import androidx.work.impl.utils.futures.SettableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0012\u0010\u0003\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001A\u0012\u0010\u0007\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ARGUMENT_CLASS_NAME", "", "TAG", "setFailed", "", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "setRetry", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class ConstraintTrackingWorkerKt {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    private static final String TAG;

    // 去混淆评级： 低(20)
    static {
        Intrinsics.checkNotNullExpressionValue("WM-ConstraintTrkngWrkr", "tagWithPrefix(\"ConstraintTrkngWrkr\")");
        ConstraintTrackingWorkerKt.TAG = "WM-ConstraintTrkngWrkr";
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$p() [...] // 潜在的解密器

    private static final boolean setFailed(SettableFuture settableFuture0) {
        return settableFuture0.set(Result.failure());
    }

    private static final boolean setRetry(SettableFuture settableFuture0) {
        return settableFuture0.set(Result.retry());
    }
}

