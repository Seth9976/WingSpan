package androidx.work.impl;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest.Builder;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.workers.CombineContinuationsWorker;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkContinuationImpl extends WorkContinuation {
    private static final String TAG;
    private final List mAllIds;
    private boolean mEnqueued;
    private final ExistingWorkPolicy mExistingWorkPolicy;
    private final List mIds;
    private final String mName;
    private Operation mOperation;
    private final List mParents;
    private final List mWork;
    private final WorkManagerImpl mWorkManagerImpl;

    static {
        WorkContinuationImpl.TAG = "WM-WorkContinuationImpl";
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String name, ExistingWorkPolicy existingWorkPolicy, List work) {
        this(workManagerImpl, name, existingWorkPolicy, work, null);
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String name, ExistingWorkPolicy existingWorkPolicy, List work, List parents) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mName = name;
        this.mExistingWorkPolicy = existingWorkPolicy;
        this.mWork = work;
        this.mParents = parents;
        this.mIds = new ArrayList(work.size());
        this.mAllIds = new ArrayList();
        if(parents != null) {
            for(Object object0: parents) {
                this.mAllIds.addAll(((WorkContinuationImpl)object0).mAllIds);
            }
        }
        for(int v = 0; v < work.size(); ++v) {
            String s1 = ((WorkRequest)work.get(v)).getStringId();
            this.mIds.add(s1);
            this.mAllIds.add(s1);
        }
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List work) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, work, null);
    }

    @Override  // androidx.work.WorkContinuation
    protected WorkContinuation combineInternal(List continuations) {
        OneTimeWorkRequest oneTimeWorkRequest0 = (OneTimeWorkRequest)new Builder(CombineContinuationsWorker.class).setInputMerger(ArrayCreatingInputMerger.class).build();
        ArrayList arrayList0 = new ArrayList(continuations.size());
        for(Object object0: continuations) {
            arrayList0.add(((WorkContinuationImpl)(((WorkContinuation)object0))));
        }
        List list1 = Collections.singletonList(oneTimeWorkRequest0);
        return new WorkContinuationImpl(this.mWorkManagerImpl, null, ExistingWorkPolicy.KEEP, list1, arrayList0);
    }

    @Override  // androidx.work.WorkContinuation
    public Operation enqueue() {
        if(!this.mEnqueued) {
            EnqueueRunnable enqueueRunnable0 = new EnqueueRunnable(this);
            this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(enqueueRunnable0);
            this.mOperation = enqueueRunnable0.getOperation();
            return this.mOperation;
        }
        Logger.get().warning("WM-WorkContinuationImpl", "Already enqueued work ids (" + TextUtils.join(", ", this.mIds) + ")");
        return this.mOperation;
    }

    public List getAllIds() {
        return this.mAllIds;
    }

    public ExistingWorkPolicy getExistingWorkPolicy() {
        return this.mExistingWorkPolicy;
    }

    public List getIds() {
        return this.mIds;
    }

    public String getName() {
        return this.mName;
    }

    public List getParents() {
        return this.mParents;
    }

    public List getWork() {
        return this.mWork;
    }

    @Override  // androidx.work.WorkContinuation
    public ListenableFuture getWorkInfos() {
        StatusRunnable statusRunnable0 = StatusRunnable.forStringIds(this.mWorkManagerImpl, this.mAllIds);
        this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(statusRunnable0);
        return statusRunnable0.getFuture();
    }

    @Override  // androidx.work.WorkContinuation
    public LiveData getWorkInfosLiveData() {
        return this.mWorkManagerImpl.getWorkInfosById(this.mAllIds);
    }

    public WorkManagerImpl getWorkManagerImpl() {
        return this.mWorkManagerImpl;
    }

    private static boolean hasCycles(WorkContinuationImpl continuation, Set visited) {
        visited.addAll(continuation.getIds());
        Set set1 = WorkContinuationImpl.prerequisitesFor(continuation);
        for(Object object0: visited) {
            if(set1.contains(((String)object0))) {
                return true;
            }
            if(false) {
                break;
            }
        }
        List list0 = continuation.getParents();
        if(list0 != null && !list0.isEmpty()) {
            for(Object object1: list0) {
                if(WorkContinuationImpl.hasCycles(((WorkContinuationImpl)object1), visited)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        visited.removeAll(continuation.getIds());
        return false;
    }

    public boolean hasCycles() {
        return WorkContinuationImpl.hasCycles(this, new HashSet());
    }

    public boolean isEnqueued() {
        return this.mEnqueued;
    }

    public void markEnqueued() {
        this.mEnqueued = true;
    }

    public static Set prerequisitesFor(WorkContinuationImpl continuation) {
        Set set0 = new HashSet();
        List list0 = continuation.getParents();
        if(list0 != null && !list0.isEmpty()) {
            for(Object object0: list0) {
                set0.addAll(((WorkContinuationImpl)object0).getIds());
            }
        }
        return set0;
    }

    @Override  // androidx.work.WorkContinuation
    public WorkContinuation then(List work) {
        if(work.isEmpty()) {
            return this;
        }
        List list1 = Collections.singletonList(this);
        return new WorkContinuationImpl(this.mWorkManagerImpl, this.mName, ExistingWorkPolicy.KEEP, work, list1);
    }
}

