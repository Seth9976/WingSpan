package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityService.Stub;
import androidx.concurrent.futures.CallbackToFutureAdapter.Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

class ConnectionHolder implements ServiceConnection {
    static class WrapperFactory {
        TrustedWebActivityServiceConnection create(ComponentName name, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(Stub.asInterface(iBinder), name);
        }
    }

    private static final int STATE_AWAITING_CONNECTION = 0;
    private static final int STATE_CANCELLED = 3;
    private static final int STATE_CONNECTED = 1;
    private static final int STATE_DISCONNECTED = 2;
    private Exception mCancellationException;
    private final Runnable mCloseRunnable;
    private List mCompleters;
    private TrustedWebActivityServiceConnection mService;
    private int mState;
    private final WrapperFactory mWrapperFactory;

    ConnectionHolder(Runnable closeRunnable) {
        this(closeRunnable, new WrapperFactory());
    }

    ConnectionHolder(Runnable closeRunnable, WrapperFactory factory) {
        this.mState = 0;
        this.mCompleters = new ArrayList();
        this.mCloseRunnable = closeRunnable;
        this.mWrapperFactory = factory;
    }

    public void cancel(Exception exception) {
        for(Object object0: this.mCompleters) {
            ((Completer)object0).setException(exception);
        }
        this.mCompleters.clear();
        this.mCloseRunnable.run();
        this.mState = 3;
        this.mCancellationException = exception;
    }

    public ListenableFuture getServiceWrapper() {
        return CallbackToFutureAdapter.getFuture((Completer callbackToFutureAdapter$Completer0) -> switch(this.mState) {
            case 0: {
                this.mCompleters.add(callbackToFutureAdapter$Completer0);
                return "ConnectionHolder, state = " + this.mState;
            }
            case 1: {
                TrustedWebActivityServiceConnection trustedWebActivityServiceConnection0 = this.mService;
                if(trustedWebActivityServiceConnection0 == null) {
                    throw new IllegalStateException("ConnectionHolder state is incorrect.");
                }
                callbackToFutureAdapter$Completer0.set(trustedWebActivityServiceConnection0);
                return "ConnectionHolder, state = " + this.mState;
            }
            case 2: {
                throw new IllegalStateException("Service has been disconnected.");
            }
            case 3: {
                throw this.mCancellationException;
            }
            default: {
                throw new IllegalStateException("Connection state is invalid");
            }
        });
    }

    // 检测为 Lambda 实现
    Object lambda$getServiceWrapper$0$androidx-browser-trusted-ConnectionHolder(Completer callbackToFutureAdapter$Completer0) throws Exception [...]

    @Override  // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = this.mWrapperFactory.create(componentName, iBinder);
        for(Object object0: this.mCompleters) {
            ((Completer)object0).set(this.mService);
        }
        this.mCompleters.clear();
        this.mState = 1;
    }

    @Override  // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.mCloseRunnable.run();
        this.mState = 2;
    }
}

