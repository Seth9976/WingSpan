package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ComputableLiveData {
    final AtomicBoolean mComputing;
    final Executor mExecutor;
    final AtomicBoolean mInvalid;
    final Runnable mInvalidationRunnable;
    final LiveData mLiveData;
    final Runnable mRefreshRunnable;

    public ComputableLiveData() {
        this(ArchTaskExecutor.getIOThreadExecutor());
    }

    public ComputableLiveData(Executor executor0) {
        this.mInvalid = new AtomicBoolean(true);
        this.mComputing = new AtomicBoolean(false);
        this.mRefreshRunnable = new Runnable() {
            @Override
            public void run() {
                int v2;
                do {
                    if(ComputableLiveData.this.mComputing.compareAndSet(false, true)) {
                        Object object0 = null;
                        int v = 0;
                        try {
                            while(ComputableLiveData.this.mInvalid.compareAndSet(true, false)) {
                                object0 = ComputableLiveData.this.compute();
                                v = 1;
                            }
                            if(v != 0) {
                                ComputableLiveData.this.mLiveData.postValue(object0);
                            }
                        }
                        finally {
                            ComputableLiveData.this.mComputing.set(false);
                        }
                        v2 = v;
                    }
                    if(v2 == 0) {
                        break;
                    }
                    v2 = 0;
                }
                while(ComputableLiveData.this.mInvalid.get());
            }
        };
        this.mInvalidationRunnable = new Runnable() {
            @Override
            public void run() {
                boolean z = ComputableLiveData.this.mLiveData.hasActiveObservers();
                if(ComputableLiveData.this.mInvalid.compareAndSet(false, true) && z) {
                    ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.mRefreshRunnable);
                }
            }
        };
        this.mExecutor = executor0;
        this.mLiveData = new LiveData() {
            @Override  // androidx.lifecycle.LiveData
            protected void onActive() {
                ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.mRefreshRunnable);
            }
        };
    }

    protected abstract Object compute();

    public LiveData getLiveData() {
        return this.mLiveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.mInvalidationRunnable);
    }
}

