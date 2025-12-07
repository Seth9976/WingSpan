package androidx.core.os;

public final class CancellationSignal {
    static class Api16Impl {
        static void cancel(Object object0) {
            ((android.os.CancellationSignal)object0).cancel();
        }

        static android.os.CancellationSignal createCancellationSignal() {
            return new android.os.CancellationSignal();
        }
    }

    public interface OnCancelListener {
        void onCancel();
    }

    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public void cancel() {
        Object object0;
        OnCancelListener cancellationSignal$OnCancelListener0;
        synchronized(this) {
            if(this.mIsCanceled) {
                return;
            }
            this.mIsCanceled = true;
            this.mCancelInProgress = true;
            cancellationSignal$OnCancelListener0 = this.mOnCancelListener;
            object0 = this.mCancellationSignalObj;
        }
        try {
            if(cancellationSignal$OnCancelListener0 != null) {
                cancellationSignal$OnCancelListener0.onCancel();
            }
            if(object0 != null) {
                Api16Impl.cancel(object0);
            }
            goto label_24;
        }
        catch(Throwable throwable0) {
        }
        synchronized(this) {
            this.mCancelInProgress = false;
            this.notifyAll();
        }
        throw throwable0;
    label_24:
        synchronized(this) {
            this.mCancelInProgress = false;
            this.notifyAll();
        }
    }

    public Object getCancellationSignalObject() {
        synchronized(this) {
            if(this.mCancellationSignalObj == null) {
                android.os.CancellationSignal cancellationSignal0 = Api16Impl.createCancellationSignal();
                this.mCancellationSignalObj = cancellationSignal0;
                if(this.mIsCanceled) {
                    Api16Impl.cancel(cancellationSignal0);
                }
            }
            return this.mCancellationSignalObj;
        }
    }

    public boolean isCanceled() {
        synchronized(this) {
        }
        return this.mIsCanceled;
    }

    public void setOnCancelListener(OnCancelListener cancellationSignal$OnCancelListener0) {
        synchronized(this) {
            this.waitForCancelFinishedLocked();
            if(this.mOnCancelListener == cancellationSignal$OnCancelListener0) {
                return;
            }
            this.mOnCancelListener = cancellationSignal$OnCancelListener0;
            if(this.mIsCanceled && cancellationSignal$OnCancelListener0 != null) {
                cancellationSignal$OnCancelListener0.onCancel();
            }
        }
    }

    public void throwIfCanceled() {
        if(this.isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    private void waitForCancelFinishedLocked() {
        while(this.mCancelInProgress) {
            try {
                this.wait();
            }
            catch(InterruptedException unused_ex) {
            }
        }
    }
}

