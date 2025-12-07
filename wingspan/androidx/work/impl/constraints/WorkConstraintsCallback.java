package androidx.work.impl.constraints;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Landroidx/work/impl/constraints/WorkConstraintsCallback;", "", "onAllConstraintsMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onAllConstraintsNotMet", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface WorkConstraintsCallback {
    void onAllConstraintsMet(List arg1);

    void onAllConstraintsNotMet(List arg1);
}

