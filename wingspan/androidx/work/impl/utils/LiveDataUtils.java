package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class LiveDataUtils {
    public static LiveData dedupedMappedLiveDataFor(LiveData inputLiveData, Function mappingMethod, TaskExecutor workTaskExecutor) {
        Object object0 = new Object();
        LiveData liveData1 = new MediatorLiveData();
        ((MediatorLiveData)liveData1).addSource(inputLiveData, new Observer() {
            Object mCurrentOutput;

            {
                TaskExecutor val$workTaskExecutor = workTaskExecutor;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                Object val$lock = object0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                Function val$mappingMethod = mappingMethod;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                MediatorLiveData val$outputLiveData = (MediatorLiveData)liveData1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.mCurrentOutput = null;
            }

            @Override  // androidx.lifecycle.Observer
            public void onChanged(Object input) {
                androidx.work.impl.utils.LiveDataUtils.1.1 liveDataUtils$1$10 = new Runnable() {
                    @Override
                    public void run() {
                        synchronized(androidx.work.impl.utils.LiveDataUtils.1.this.val$lock) {
                            Object object1 = androidx.work.impl.utils.LiveDataUtils.1.this.val$mappingMethod.apply(input);
                            if(androidx.work.impl.utils.LiveDataUtils.1.this.mCurrentOutput == null && object1 != null) {
                                androidx.work.impl.utils.LiveDataUtils.1.this.mCurrentOutput = object1;
                                androidx.work.impl.utils.LiveDataUtils.1.this.val$outputLiveData.postValue(object1);
                            }
                            else if(androidx.work.impl.utils.LiveDataUtils.1.this.mCurrentOutput != null && !androidx.work.impl.utils.LiveDataUtils.1.this.mCurrentOutput.equals(object1)) {
                                androidx.work.impl.utils.LiveDataUtils.1.this.mCurrentOutput = object1;
                                androidx.work.impl.utils.LiveDataUtils.1.this.val$outputLiveData.postValue(object1);
                            }
                        }
                    }
                };
                workTaskExecutor.executeOnTaskThread(liveDataUtils$1$10);
            }
        });
        return liveData1;
    }
}

