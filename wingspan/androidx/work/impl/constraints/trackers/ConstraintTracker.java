package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0019\u001A\u00020\u001A2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0014\u0010\u001C\u001A\u00020\u001A2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012J\b\u0010\u001D\u001A\u00020\u001AH&J\b\u0010\u001E\u001A\u00020\u001AH&R\u0014\u0010\b\u001A\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u0004\u0018\u00018\u0000X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001A\u00028\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u00008F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0016\u0010\u000F\"\u0004\b\u0017\u0010\u0018R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2 = {"Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "T", "", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "appContext", "getAppContext", "()Landroid/content/Context;", "currentState", "Ljava/lang/Object;", "initialState", "getInitialState", "()Ljava/lang/Object;", "listeners", "Ljava/util/LinkedHashSet;", "Landroidx/work/impl/constraints/ConstraintListener;", "lock", "newState", "state", "getState", "setState", "(Ljava/lang/Object;)V", "addListener", "", "listener", "removeListener", "startTracking", "stopTracking", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class ConstraintTracker {
    private final Context appContext;
    private Object currentState;
    private final LinkedHashSet listeners;
    private final Object lock;
    private final TaskExecutor taskExecutor;

    protected ConstraintTracker(Context context0, TaskExecutor taskExecutor0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Intrinsics.checkNotNullParameter(taskExecutor0, "taskExecutor");
        super();
        this.taskExecutor = taskExecutor0;
        Context context1 = context0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context1, "context.applicationContext");
        this.appContext = context1;
        this.lock = new Object();
        this.listeners = new LinkedHashSet();
    }

    // 检测为 Lambda 实现
    private static final void _set_state_$lambda$4$lambda$3(List list0, ConstraintTracker constraintTracker0) [...]

    public final void addListener(ConstraintListener constraintListener0) {
        Intrinsics.checkNotNullParameter(constraintListener0, "listener");
        synchronized(this.lock) {
            if(this.listeners.add(constraintListener0)) {
                if(this.listeners.size() == 1) {
                    this.currentState = this.getInitialState();
                    Logger.get().debug("WM-ConstraintTracker", this.getClass().getSimpleName() + ": initial state = " + this.currentState);
                    this.startTracking();
                }
                constraintListener0.onConstraintChanged(this.currentState);
            }
        }
    }

    protected final Context getAppContext() {
        return this.appContext;
    }

    public abstract Object getInitialState();

    public final Object getState() {
        return this.currentState == null ? this.getInitialState() : this.currentState;
    }

    public final void removeListener(ConstraintListener constraintListener0) {
        Intrinsics.checkNotNullParameter(constraintListener0, "listener");
        synchronized(this.lock) {
            if(this.listeners.remove(constraintListener0) && this.listeners.isEmpty()) {
                this.stopTracking();
            }
        }
    }

    public final void setState(Object object0) {
        synchronized(this.lock) {
            if(this.currentState != null && Intrinsics.areEqual(this.currentState, object0)) {
                return;
            }
            this.currentState = object0;
            List list0 = CollectionsKt.toList(this.listeners);
            this.taskExecutor.getMainThreadExecutor().execute(() -> {
                Intrinsics.checkNotNullParameter(list0, "$listenersList");
                Intrinsics.checkNotNullParameter(this, "this$0");
                for(Object object0: list0) {
                    ((ConstraintListener)object0).onConstraintChanged(this.currentState);
                }
            });
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}

