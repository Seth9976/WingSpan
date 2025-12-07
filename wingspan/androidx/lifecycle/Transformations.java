package androidx.lifecycle;

import androidx.arch.core.util.Function;

public class Transformations {
    public static LiveData distinctUntilChanged(LiveData liveData0) {
        LiveData liveData1 = new MediatorLiveData();
        ((MediatorLiveData)liveData1).addSource(liveData0, new Observer() {
            boolean mFirstTime;

            {
                MediatorLiveData mediatorLiveData0 = (MediatorLiveData)liveData1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.mFirstTime = true;
            }

            @Override  // androidx.lifecycle.Observer
            public void onChanged(Object object0) {
                Object object1 = ((MediatorLiveData)liveData1).getValue();
                if(this.mFirstTime || object1 == null && object0 != null || object1 != null && !object1.equals(object0)) {
                    this.mFirstTime = false;
                    ((MediatorLiveData)liveData1).setValue(object0);
                }
            }
        });
        return liveData1;
    }

    public static LiveData map(LiveData liveData0, Function function0) {
        LiveData liveData1 = new MediatorLiveData();
        ((MediatorLiveData)liveData1).addSource(liveData0, new Observer() {
            @Override  // androidx.lifecycle.Observer
            public void onChanged(Object object0) {
                Object object1 = function0.apply(object0);
                ((MediatorLiveData)liveData1).setValue(object1);
            }
        });
        return liveData1;
    }

    public static LiveData switchMap(LiveData liveData0, Function function0) {
        LiveData liveData1 = new MediatorLiveData();
        ((MediatorLiveData)liveData1).addSource(liveData0, new Observer() {
            LiveData mSource;

            @Override  // androidx.lifecycle.Observer
            public void onChanged(Object object0) {
                LiveData liveData0 = (LiveData)function0.apply(object0);
                LiveData liveData1 = this.mSource;
                if(liveData1 == liveData0) {
                    return;
                }
                if(liveData1 != null) {
                    ((MediatorLiveData)liveData1).removeSource(liveData1);
                }
                this.mSource = liveData0;
                if(liveData0 != null) {
                    androidx.lifecycle.Transformations.2.1 transformations$2$10 = new Observer() {
                        @Override  // androidx.lifecycle.Observer
                        public void onChanged(Object object0) {
                            androidx.lifecycle.Transformations.2.this.val$result.setValue(object0);
                        }
                    };
                    ((MediatorLiveData)liveData1).addSource(liveData0, transformations$2$10);
                }
            }
        });
        return liveData1;
    }
}

