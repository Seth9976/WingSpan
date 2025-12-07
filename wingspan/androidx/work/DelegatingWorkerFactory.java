package androidx.work;

import android.content.Context;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DelegatingWorkerFactory extends WorkerFactory {
    private static final String TAG;
    private final List mFactories;

    static {
        DelegatingWorkerFactory.TAG = "WM-DelegatingWkrFctry";
    }

    public DelegatingWorkerFactory() {
        this.mFactories = new CopyOnWriteArrayList();
    }

    public final void addFactory(WorkerFactory workerFactory) {
        this.mFactories.add(workerFactory);
    }

    @Override  // androidx.work.WorkerFactory
    public final ListenableWorker createWorker(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        for(Object object0: this.mFactories) {
            WorkerFactory workerFactory0 = (WorkerFactory)object0;
            try {
                ListenableWorker listenableWorker0 = workerFactory0.createWorker(appContext, workerClassName, workerParameters);
                if(listenableWorker0 != null) {
                    return listenableWorker0;
                }
            }
            catch(Throwable throwable0) {
                Logger.get().error("WM-DelegatingWkrFctry", "Unable to instantiate a ListenableWorker (" + workerClassName + ")", throwable0);
                throw throwable0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    List getFactories() {
        return this.mFactories;
    }
}

