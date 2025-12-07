package androidx.activity;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList mCancellables;
    private boolean mEnabled;

    public OnBackPressedCallback(boolean z) {
        this.mCancellables = new CopyOnWriteArrayList();
        this.mEnabled = z;
    }

    void addCancellable(Cancellable cancellable0) {
        this.mCancellables.add(cancellable0);
    }

    public abstract void handleOnBackPressed();

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        for(Object object0: this.mCancellables) {
            ((Cancellable)object0).cancel();
        }
    }

    void removeCancellable(Cancellable cancellable0) {
        this.mCancellables.remove(cancellable0);
    }

    public final void setEnabled(boolean z) {
        this.mEnabled = z;
    }
}

