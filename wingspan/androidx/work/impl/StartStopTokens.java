package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000E\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0006J\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u00072\u0006\u0010\n\u001A\u00020\u0006J\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u00072\u0006\u0010\f\u001A\u00020\rJ\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00070\u000E2\u0006\u0010\u000F\u001A\u00020\u0010J\u000E\u0010\u0011\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0006J\u000E\u0010\u0011\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/work/impl/StartStopTokens;", "", "()V", "lock", "runs", "", "Landroidx/work/impl/model/WorkGenerationalId;", "Landroidx/work/impl/StartStopToken;", "contains", "", "id", "remove", "spec", "Landroidx/work/impl/model/WorkSpec;", "", "workSpecId", "", "tokenFor", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class StartStopTokens {
    private final Object lock;
    private final Map runs;

    public StartStopTokens() {
        this.lock = new Object();
        this.runs = new LinkedHashMap();
    }

    public final boolean contains(WorkGenerationalId workGenerationalId0) {
        Intrinsics.checkNotNullParameter(workGenerationalId0, "id");
        synchronized(this.lock) {
            return this.runs.containsKey(workGenerationalId0);
        }
    }

    public final StartStopToken remove(WorkGenerationalId workGenerationalId0) {
        Intrinsics.checkNotNullParameter(workGenerationalId0, "id");
        synchronized(this.lock) {
            return (StartStopToken)this.runs.remove(workGenerationalId0);
        }
    }

    public final StartStopToken remove(WorkSpec workSpec0) {
        Intrinsics.checkNotNullParameter(workSpec0, "spec");
        return this.remove(WorkSpecKt.generationalId(workSpec0));
    }

    public final List remove(String s) {
        Intrinsics.checkNotNullParameter(s, "workSpecId");
        synchronized(this.lock) {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            for(Object object1: this.runs.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object1;
                if(Intrinsics.areEqual(((WorkGenerationalId)map$Entry0.getKey()).getWorkSpecId(), s)) {
                    linkedHashMap0.put(map$Entry0.getKey(), map$Entry0.getValue());
                }
            }
            for(Object object2: linkedHashMap0.keySet()) {
                this.runs.remove(((WorkGenerationalId)object2));
            }
            return CollectionsKt.toList(linkedHashMap0.values());
        }
    }

    public final StartStopToken tokenFor(WorkGenerationalId workGenerationalId0) {
        Intrinsics.checkNotNullParameter(workGenerationalId0, "id");
        synchronized(this.lock) {
            Map map0 = this.runs;
            StartStopToken startStopToken0 = map0.get(workGenerationalId0);
            if(startStopToken0 == null) {
                startStopToken0 = new StartStopToken(workGenerationalId0);
                map0.put(workGenerationalId0, startStopToken0);
            }
            return startStopToken0;
        }
    }

    public final StartStopToken tokenFor(WorkSpec workSpec0) {
        Intrinsics.checkNotNullParameter(workSpec0, "spec");
        return this.tokenFor(WorkSpecKt.generationalId(workSpec0));
    }
}

