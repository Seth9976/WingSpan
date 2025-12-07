package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController.OnConstraintUpdatedCallback;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001C\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0001\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0010\u0010\b\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0002\u0010\u000BJ\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012J\u0016\u0010\u0013\u001A\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0016\u0010\u0018\u001A\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0016\u0010\u0019\u001A\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u001AH\u0016J\b\u0010\u001B\u001A\u00020\u0014H\u0016R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2 = {"Landroidx/work/impl/constraints/WorkConstraintsTrackerImpl;", "Landroidx/work/impl/constraints/WorkConstraintsTracker;", "Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "trackers", "Landroidx/work/impl/constraints/trackers/Trackers;", "callback", "Landroidx/work/impl/constraints/WorkConstraintsCallback;", "(Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/constraints/WorkConstraintsCallback;)V", "constraintControllers", "", "Landroidx/work/impl/constraints/controllers/ConstraintController;", "(Landroidx/work/impl/constraints/WorkConstraintsCallback;[Landroidx/work/impl/constraints/controllers/ConstraintController;)V", "[Landroidx/work/impl/constraints/controllers/ConstraintController;", "lock", "", "areAllConstraintsMet", "", "workSpecId", "", "onConstraintMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onConstraintNotMet", "replace", "", "reset", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class WorkConstraintsTrackerImpl implements WorkConstraintsTracker, OnConstraintUpdatedCallback {
    private final WorkConstraintsCallback callback;
    private final ConstraintController[] constraintControllers;
    private final Object lock;

    public WorkConstraintsTrackerImpl(WorkConstraintsCallback workConstraintsCallback0, ConstraintController[] arr_constraintController) {
        Intrinsics.checkNotNullParameter(arr_constraintController, "constraintControllers");
        super();
        this.callback = workConstraintsCallback0;
        this.constraintControllers = arr_constraintController;
        this.lock = new Object();
    }

    public WorkConstraintsTrackerImpl(Trackers trackers0, WorkConstraintsCallback workConstraintsCallback0) {
        Intrinsics.checkNotNullParameter(trackers0, "trackers");
        this(workConstraintsCallback0, new ConstraintController[]{new BatteryChargingController(trackers0.getBatteryChargingTracker()), new BatteryNotLowController(trackers0.getBatteryNotLowTracker()), new StorageNotLowController(trackers0.getStorageNotLowTracker()), new NetworkConnectedController(trackers0.getNetworkStateTracker()), new NetworkUnmeteredController(trackers0.getNetworkStateTracker()), new NetworkNotRoamingController(trackers0.getNetworkStateTracker()), new NetworkMeteredController(trackers0.getNetworkStateTracker())});
    }

    public final boolean areAllConstraintsMet(String s) {
        ConstraintController constraintController0;
        Intrinsics.checkNotNullParameter(s, "workSpecId");
        synchronized(this.lock) {
            ConstraintController[] arr_constraintController = this.constraintControllers;
            boolean z = false;
            for(int v1 = 0; true; ++v1) {
                constraintController0 = null;
                if(v1 >= arr_constraintController.length) {
                    break;
                }
                ConstraintController constraintController1 = arr_constraintController[v1];
                if(constraintController1.isWorkSpecConstrained(s)) {
                    constraintController0 = constraintController1;
                    break;
                }
            }
            if(constraintController0 != null) {
                Logger.get().debug("WM-WorkConstraintsTrack", "Work " + s + " constrained by " + constraintController0.getClass().getSimpleName());
            }
            if(constraintController0 == null) {
                z = true;
            }
            return z;
        }
    }

    @Override  // androidx.work.impl.constraints.controllers.ConstraintController$OnConstraintUpdatedCallback
    public void onConstraintMet(List list0) {
        Intrinsics.checkNotNullParameter(list0, "workSpecs");
        synchronized(this.lock) {
            Collection collection0 = new ArrayList();
            for(Object object1: list0) {
                if(this.areAllConstraintsMet(((WorkSpec)object1).id)) {
                    collection0.add(object1);
                }
            }
            for(Object object2: ((List)collection0)) {
                Logger.get().debug("WM-WorkConstraintsTrack", "Constraints met for " + ((WorkSpec)object2));
            }
            WorkConstraintsCallback workConstraintsCallback0 = this.callback;
            if(workConstraintsCallback0 != null) {
                workConstraintsCallback0.onAllConstraintsMet(((List)collection0));
            }
        }
    }

    @Override  // androidx.work.impl.constraints.controllers.ConstraintController$OnConstraintUpdatedCallback
    public void onConstraintNotMet(List list0) {
        Intrinsics.checkNotNullParameter(list0, "workSpecs");
        synchronized(this.lock) {
            WorkConstraintsCallback workConstraintsCallback0 = this.callback;
            if(workConstraintsCallback0 != null) {
                workConstraintsCallback0.onAllConstraintsNotMet(list0);
            }
        }
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsTracker
    public void replace(Iterable iterable0) {
        Intrinsics.checkNotNullParameter(iterable0, "workSpecs");
        synchronized(this.lock) {
            ConstraintController[] arr_constraintController = this.constraintControllers;
            for(int v2 = 0; v2 < arr_constraintController.length; ++v2) {
                arr_constraintController[v2].setCallback(null);
            }
            ConstraintController[] arr_constraintController1 = this.constraintControllers;
            for(int v3 = 0; v3 < arr_constraintController1.length; ++v3) {
                arr_constraintController1[v3].replace(iterable0);
            }
            ConstraintController[] arr_constraintController2 = this.constraintControllers;
            for(int v1 = 0; v1 < arr_constraintController2.length; ++v1) {
                arr_constraintController2[v1].setCallback(this);
            }
        }
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsTracker
    public void reset() {
        synchronized(this.lock) {
            ConstraintController[] arr_constraintController = this.constraintControllers;
            for(int v1 = 0; v1 < arr_constraintController.length; ++v1) {
                arr_constraintController[v1].reset();
            }
        }
    }
}

