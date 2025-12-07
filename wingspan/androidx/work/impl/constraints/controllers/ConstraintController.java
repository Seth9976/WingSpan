package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001C\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001%B\u0015\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0013H&J\u0015\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0006\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0018J\u000E\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u001A\u001A\u00020\u0011J\u0015\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001EJ\u0014\u0010\u001F\u001A\u00020\u001C2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00130!J\u0006\u0010\"\u001A\u00020\u001CJ!\u0010#\u001A\u00020\u001C2\b\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\r\u001A\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010$R(\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0012\u0010\r\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/work/impl/constraints/controllers/ConstraintController;", "T", "Landroidx/work/impl/constraints/ConstraintListener;", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "value", "Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "callback", "getCallback", "()Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "setCallback", "(Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;)V", "currentValue", "Ljava/lang/Object;", "matchingWorkSpecIds", "", "", "matchingWorkSpecs", "Landroidx/work/impl/model/WorkSpec;", "hasConstraint", "", "workSpec", "isConstrained", "(Ljava/lang/Object;)Z", "isWorkSpecConstrained", "workSpecId", "onConstraintChanged", "", "newValue", "(Ljava/lang/Object;)V", "replace", "workSpecs", "", "reset", "updateCallback", "(Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;Ljava/lang/Object;)V", "OnConstraintUpdatedCallback", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class ConstraintController implements ConstraintListener {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "", "onConstraintMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onConstraintNotMet", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(List arg1);

        void onConstraintNotMet(List arg1);
    }

    private OnConstraintUpdatedCallback callback;
    private Object currentValue;
    private final List matchingWorkSpecIds;
    private final List matchingWorkSpecs;
    private final ConstraintTracker tracker;

    public ConstraintController(ConstraintTracker constraintTracker0) {
        Intrinsics.checkNotNullParameter(constraintTracker0, "tracker");
        super();
        this.tracker = constraintTracker0;
        this.matchingWorkSpecs = new ArrayList();
        this.matchingWorkSpecIds = new ArrayList();
    }

    public final OnConstraintUpdatedCallback getCallback() {
        return this.callback;
    }

    public abstract boolean hasConstraint(WorkSpec arg1);

    public abstract boolean isConstrained(Object arg1);

    public final boolean isWorkSpecConstrained(String s) {
        Intrinsics.checkNotNullParameter(s, "workSpecId");
        return this.currentValue != null && this.isConstrained(this.currentValue) && this.matchingWorkSpecIds.contains(s);
    }

    @Override  // androidx.work.impl.constraints.ConstraintListener
    public void onConstraintChanged(Object object0) {
        this.currentValue = object0;
        this.updateCallback(this.callback, object0);
    }

    public final void replace(Iterable iterable0) {
        Intrinsics.checkNotNullParameter(iterable0, "workSpecs");
        this.matchingWorkSpecs.clear();
        this.matchingWorkSpecIds.clear();
        Collection collection0 = this.matchingWorkSpecs;
        for(Object object0: iterable0) {
            if(this.hasConstraint(((WorkSpec)object0))) {
                collection0.add(object0);
            }
        }
        Collection collection1 = this.matchingWorkSpecIds;
        for(Object object1: this.matchingWorkSpecs) {
            collection1.add(((WorkSpec)object1).id);
        }
        if(this.matchingWorkSpecs.isEmpty()) {
            this.tracker.removeListener(this);
        }
        else {
            this.tracker.addListener(this);
        }
        this.updateCallback(this.callback, this.currentValue);
    }

    public final void reset() {
        if(!this.matchingWorkSpecs.isEmpty() != 0) {
            this.matchingWorkSpecs.clear();
            this.tracker.removeListener(this);
        }
    }

    public final void setCallback(OnConstraintUpdatedCallback constraintController$OnConstraintUpdatedCallback0) {
        if(this.callback != constraintController$OnConstraintUpdatedCallback0) {
            this.callback = constraintController$OnConstraintUpdatedCallback0;
            this.updateCallback(constraintController$OnConstraintUpdatedCallback0, this.currentValue);
        }
    }

    private final void updateCallback(OnConstraintUpdatedCallback constraintController$OnConstraintUpdatedCallback0, Object object0) {
        if(!this.matchingWorkSpecs.isEmpty() && constraintController$OnConstraintUpdatedCallback0 != null) {
            if(object0 != null && !this.isConstrained(object0)) {
                constraintController$OnConstraintUpdatedCallback0.onConstraintMet(this.matchingWorkSpecs);
                return;
            }
            constraintController$OnConstraintUpdatedCallback0.onConstraintNotMet(this.matchingWorkSpecs);
        }
    }
}

