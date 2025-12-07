package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH&J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u000F\u001A\u00020\u0010H&J\u0010\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u0013H&J\b\u0010\u0014\u001A\u00020\bH&J\u001A\u0010\u0015\u001A\u0004\u0018\u00010\u00022\u000E\u0010\u0016\u001A\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018H&R\u0018\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/selects/SelectInstance;", "R", "", "completion", "Lkotlin/coroutines/Continuation;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "isSelected", "", "()Z", "disposeOnSelect", "", "handle", "Lkotlinx/coroutines/DisposableHandle;", "performAtomicTrySelect", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "resumeSelectWithException", "exception", "", "trySelect", "trySelectOther", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public interface SelectInstance {
    void disposeOnSelect(DisposableHandle arg1);

    Continuation getCompletion();

    boolean isSelected();

    Object performAtomicTrySelect(AtomicDesc arg1);

    void resumeSelectWithException(Throwable arg1);

    boolean trySelect();

    Object trySelectOther(PrepareOp arg1);
}

