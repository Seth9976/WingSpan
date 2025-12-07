package com.gameanalytics.sdk.utilities;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TaskRunner {
    public interface Callback {
        void onComplete(Object arg1);
    }

    private static final Executor executor;
    private static final Handler handler;

    static {
        TaskRunner.executor = Executors.newSingleThreadExecutor();
        TaskRunner.handler = new Handler(Looper.getMainLooper());
    }

    public static void executeAsync(Callable callable, Callback callback) {
        TaskRunner..ExternalSyntheticLambda0 taskRunner$$ExternalSyntheticLambda00 = () -> {
            Object object0;
            try {
                object0 = callable.call();
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
                object0 = null;
            }
            TaskRunner..ExternalSyntheticLambda1 taskRunner$$ExternalSyntheticLambda10 = () -> if(taskRunner$Callback0 != null) {
                taskRunner$Callback0.onComplete(object0);
            };
            TaskRunner.handler.post(taskRunner$$ExternalSyntheticLambda10);
        };
        TaskRunner.executor.execute(taskRunner$$ExternalSyntheticLambda00);
    }

    // 检测为 Lambda 实现
    static void lambda$executeAsync$0(Callback taskRunner$Callback0, Object object0) [...]

    // 检测为 Lambda 实现
    static void lambda$executeAsync$1(Callable callable0, Callback taskRunner$Callback0) [...]
}

