package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001A\u00020\u0006J\u0016\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/work/impl/utils/IdGenerator;", "", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "(Landroidx/work/impl/WorkDatabase;)V", "nextAlarmManagerId", "", "nextJobSchedulerIdWithRange", "minInclusive", "maxInclusive", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class IdGenerator {
    private final WorkDatabase workDatabase;

    public IdGenerator(WorkDatabase workDatabase0) {
        Intrinsics.checkNotNullParameter(workDatabase0, "workDatabase");
        super();
        this.workDatabase = workDatabase0;
    }

    public final int nextAlarmManagerId() {
        IdGenerator..ExternalSyntheticLambda0 idGenerator$$ExternalSyntheticLambda00 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            return IdGeneratorKt.nextId(this.workDatabase, "next_alarm_manager_id");
        };
        Object object0 = this.workDatabase.runInTransaction(idGenerator$$ExternalSyntheticLambda00);
        Intrinsics.checkNotNullExpressionValue(object0, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number)object0).intValue();
    }

    // 检测为 Lambda 实现
    private static final Integer nextAlarmManagerId$lambda$1(IdGenerator idGenerator0) [...]

    public final int nextJobSchedulerIdWithRange(int v, int v1) {
        IdGenerator..ExternalSyntheticLambda1 idGenerator$$ExternalSyntheticLambda10 = () -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            int v2 = IdGeneratorKt.nextId(this.workDatabase, "next_job_scheduler_id");
            if(v > v2 || v2 > v1) {
                IdGeneratorKt.updatePreference(this.workDatabase, "next_job_scheduler_id", v + 1);
                return v;
            }
            return v2;
        };
        Object object0 = this.workDatabase.runInTransaction(idGenerator$$ExternalSyntheticLambda10);
        Intrinsics.checkNotNullExpressionValue(object0, "workDatabase.runInTransa…            id\n        })");
        return ((Number)object0).intValue();
    }

    // 检测为 Lambda 实现
    private static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator idGenerator0, int v, int v1) [...]
}

