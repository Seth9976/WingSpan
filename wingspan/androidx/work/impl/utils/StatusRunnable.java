package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec.WorkInfoPojo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;

public abstract class StatusRunnable implements Runnable {
    private final SettableFuture mFuture;

    public StatusRunnable() {
        this.mFuture = SettableFuture.create();
    }

    public static StatusRunnable forStringIds(WorkManagerImpl workManager, List ids) {
        return new StatusRunnable() {
            @Override  // androidx.work.impl.utils.StatusRunnable
            public Object runInternal() {
                return this.runInternal();
            }

            public List runInternal() {
                List list0 = workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForIds(ids);
                return (List)WorkSpec.WORK_INFO_MAPPER.apply(list0);
            }
        };
    }

    public static StatusRunnable forTag(WorkManagerImpl workManager, String tag) {
        return new StatusRunnable() {
            @Override  // androidx.work.impl.utils.StatusRunnable
            Object runInternal() {
                return this.runInternal();
            }

            List runInternal() {
                List list0 = workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForTag(tag);
                return (List)WorkSpec.WORK_INFO_MAPPER.apply(list0);
            }
        };
    }

    public static StatusRunnable forUUID(WorkManagerImpl workManager, UUID id) {
        return new StatusRunnable() {
            WorkInfo runInternal() {
                WorkInfoPojo workSpec$WorkInfoPojo0 = workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForId(id.toString());
                return workSpec$WorkInfoPojo0 == null ? null : workSpec$WorkInfoPojo0.toWorkInfo();
            }

            @Override  // androidx.work.impl.utils.StatusRunnable
            Object runInternal() {
                return this.runInternal();
            }
        };
    }

    public static StatusRunnable forUniqueWork(WorkManagerImpl workManager, String name) {
        return new StatusRunnable() {
            @Override  // androidx.work.impl.utils.StatusRunnable
            Object runInternal() {
                return this.runInternal();
            }

            List runInternal() {
                List list0 = workManager.getWorkDatabase().workSpecDao().getWorkStatusPojoForName(name);
                return (List)WorkSpec.WORK_INFO_MAPPER.apply(list0);
            }
        };
    }

    public static StatusRunnable forWorkQuerySpec(WorkManagerImpl workManager, WorkQuery querySpec) {
        return new StatusRunnable() {
            @Override  // androidx.work.impl.utils.StatusRunnable
            Object runInternal() {
                return this.runInternal();
            }

            List runInternal() {
                List list0 = workManager.getWorkDatabase().rawWorkInfoDao().getWorkInfoPojos(RawQueries.toRawQuery(querySpec));
                return (List)WorkSpec.WORK_INFO_MAPPER.apply(list0);
            }
        };
    }

    public ListenableFuture getFuture() {
        return this.mFuture;
    }

    @Override
    public void run() {
        try {
            Object object0 = this.runInternal();
            this.mFuture.set(object0);
        }
        catch(Throwable throwable0) {
            this.mFuture.setException(throwable0);
        }
    }

    abstract Object runInternal();
}

