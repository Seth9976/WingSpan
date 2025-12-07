package androidx.work;

import android.content.Context;

public abstract class WorkerFactory {
    private static final String TAG;

    static {
        WorkerFactory.TAG = "WM-WorkerFactory";
    }

    public abstract ListenableWorker createWorker(Context arg1, String arg2, WorkerParameters arg3);

    public final ListenableWorker createWorkerWithDefaultFallback(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        Class class0;
        ListenableWorker listenableWorker0 = this.createWorker(appContext, workerClassName, workerParameters);
        if(listenableWorker0 == null) {
            try {
                class0 = Class.forName(workerClassName).asSubclass(ListenableWorker.class);
            }
            catch(Throwable throwable0) {
                Logger.get().error("WM-WorkerFactory", "Invalid class: " + workerClassName, throwable0);
                class0 = null;
            }
            if(class0 != null) {
                try {
                    listenableWorker0 = (ListenableWorker)class0.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(appContext, workerParameters);
                }
                catch(Throwable throwable1) {
                    Logger.get().error("WM-WorkerFactory", "Could not instantiate " + workerClassName, throwable1);
                }
            }
        }
        if(listenableWorker0 != null && listenableWorker0.isUsed()) {
            throw new IllegalStateException("WorkerFactory (" + this.getClass().getName() + ") returned an instance of a ListenableWorker (" + workerClassName + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
        }
        return listenableWorker0;
    }

    public static WorkerFactory getDefaultWorkerFactory() {
        return new WorkerFactory() {
            @Override  // androidx.work.WorkerFactory
            public ListenableWorker createWorker(Context appContext, String workerClassName, WorkerParameters workerParameters) {
                return null;
            }
        };
    }
}

