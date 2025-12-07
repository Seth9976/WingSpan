package androidx.work.impl.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"generationalId", "Landroidx/work/impl/model/WorkGenerationalId;", "Landroidx/work/impl/model/WorkSpec;", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class WorkSpecKt {
    public static final WorkGenerationalId generationalId(WorkSpec workSpec0) {
        Intrinsics.checkNotNullParameter(workSpec0, "<this>");
        return new WorkGenerationalId(workSpec0.id, workSpec0.getGeneration());
    }
}

