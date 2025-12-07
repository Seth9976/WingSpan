package androidx.work.impl.constraints.controllers;

import android.os.Build.VERSION;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0010\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Landroidx/work/impl/constraints/controllers/NetworkConnectedController;", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "Landroidx/work/impl/constraints/NetworkState;", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "hasConstraint", "", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "isConstrained", "value", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NetworkConnectedController extends ConstraintController {
    public NetworkConnectedController(ConstraintTracker constraintTracker0) {
        Intrinsics.checkNotNullParameter(constraintTracker0, "tracker");
        super(constraintTracker0);
    }

    @Override  // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec workSpec0) {
        Intrinsics.checkNotNullParameter(workSpec0, "workSpec");
        return workSpec0.constraints.getRequiredNetworkType() == NetworkType.CONNECTED;
    }

    public boolean isConstrained(NetworkState networkState0) {
        Intrinsics.checkNotNullParameter(networkState0, "value");
        return Build.VERSION.SDK_INT < 26 ? !networkState0.isConnected() : !networkState0.isConnected() || !networkState0.isValidated();
    }

    @Override  // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isConstrained(Object object0) {
        return this.isConstrained(((NetworkState)object0));
    }
}

