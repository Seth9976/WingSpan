package androidx.browser.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityCallback.Stub;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

public class TrustedWebActivityCallbackRemote {
    private final ITrustedWebActivityCallback mCallbackBinder;

    private TrustedWebActivityCallbackRemote(ITrustedWebActivityCallback callbackBinder) {
        this.mCallbackBinder = callbackBinder;
    }

    static TrustedWebActivityCallbackRemote fromBinder(IBinder binder) {
        ITrustedWebActivityCallback iTrustedWebActivityCallback0 = binder == null ? null : Stub.asInterface(binder);
        return iTrustedWebActivityCallback0 == null ? null : new TrustedWebActivityCallbackRemote(iTrustedWebActivityCallback0);
    }

    public void runExtraCallback(String callbackName, Bundle args) throws RemoteException {
        this.mCallbackBinder.onExtraCallback(callbackName, args);
    }
}

