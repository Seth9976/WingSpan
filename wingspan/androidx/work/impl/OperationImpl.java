package androidx.work.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation.State.FAILURE;
import androidx.work.Operation.State.SUCCESS;
import androidx.work.Operation.State;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public class OperationImpl implements Operation {
    private final SettableFuture mOperationFuture;
    private final MutableLiveData mOperationState;

    public OperationImpl() {
        this.mOperationState = new MutableLiveData();
        this.mOperationFuture = SettableFuture.create();
        this.markState(Operation.IN_PROGRESS);
    }

    @Override  // androidx.work.Operation
    public ListenableFuture getResult() {
        return this.mOperationFuture;
    }

    @Override  // androidx.work.Operation
    public LiveData getState() {
        return this.mOperationState;
    }

    public void markState(State state) {
        this.mOperationState.postValue(state);
        if(state instanceof SUCCESS) {
            this.mOperationFuture.set(((SUCCESS)state));
            return;
        }
        if(state instanceof FAILURE) {
            Throwable throwable0 = ((FAILURE)state).getThrowable();
            this.mOperationFuture.setException(throwable0);
        }
    }
}

