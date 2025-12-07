package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0010\u0010\t\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u0002H\u0016¨\u0006\u000B"}, d2 = {"Landroidx/work/impl/constraints/controllers/BatteryChargingController;", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "hasConstraint", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "isConstrained", "value", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class BatteryChargingController extends ConstraintController {
    public BatteryChargingController(ConstraintTracker constraintTracker0) {
        Intrinsics.checkNotNullParameter(constraintTracker0, "tracker");
        super(constraintTracker0);
    }

    @Override  // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec workSpec0) {
        Intrinsics.checkNotNullParameter(workSpec0, "workSpec");
        return workSpec0.constraints.requiresCharging();
    }

    @Override  // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isConstrained(Object object0) {
        return this.isConstrained(((Boolean)object0).booleanValue());
    }

    public boolean isConstrained(boolean z) {
        return !z;
    }
}

