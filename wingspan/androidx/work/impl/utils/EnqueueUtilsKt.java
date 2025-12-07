package androidx.work.impl.utils;

import android.os.Build.VERSION;
import androidx.work.Constraints;
import androidx.work.Data.Builder;
import androidx.work.Data;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0000\u001A\u001E\u0010\u0003\u001A\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001A\u00020\tH\u0002\u001A\u001E\u0010\n\u001A\u00020\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¨\u0006\u000B"}, d2 = {"tryDelegateConstrainedWorkSpec", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "usesScheduler", "", "schedulers", "", "Landroidx/work/impl/Scheduler;", "className", "", "wrapInConstraintTrackingWorkerIfNeeded", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class EnqueueUtilsKt {
    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec0) {
        Intrinsics.checkNotNullParameter(workSpec0, "workSpec");
        Constraints constraints0 = workSpec0.constraints;
        String s = workSpec0.workerClassName;
        if(!Intrinsics.areEqual(s, "androidx.work.impl.workers.ConstraintTrackingWorker") && (constraints0.requiresBatteryNotLow() || constraints0.requiresStorageNotLow())) {
            Data data0 = new Builder().putAll(workSpec0.input).putString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", s).build();
            Intrinsics.checkNotNullExpressionValue(data0, "Builder().putAll(workSpe…ame)\n            .build()");
            Intrinsics.checkNotNullExpressionValue("androidx.work.impl.workers.ConstraintTrackingWorker", "name");
            return WorkSpec.copy$default(workSpec0, null, null, "androidx.work.impl.workers.ConstraintTrackingWorker", null, data0, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0xFFFEB, null);
        }
        return workSpec0;
    }

    private static final boolean usesScheduler(List list0, String s) {
        try {
            Class class0 = Class.forName(s);
            if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                for(Object object0: list0) {
                    if(!class0.isAssignableFrom(((Scheduler)object0).getClass())) {
                        continue;
                    }
                    return true;
                }
            }
        }
        catch(ClassNotFoundException unused_ex) {
        }
        return false;
    }

    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(List list0, WorkSpec workSpec0) {
        Intrinsics.checkNotNullParameter(list0, "schedulers");
        Intrinsics.checkNotNullParameter(workSpec0, "workSpec");
        return Build.VERSION.SDK_INT >= 26 ? EnqueueUtilsKt.tryDelegateConstrainedWorkSpec(workSpec0) : workSpec0;
    }
}

