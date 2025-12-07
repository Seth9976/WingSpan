package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;

class CallbackWithHandler {
    private final FontRequestCallback mCallback;
    private final Handler mCallbackHandler;

    CallbackWithHandler(FontRequestCallback fontsContractCompat$FontRequestCallback0) {
        this.mCallback = fontsContractCompat$FontRequestCallback0;
        this.mCallbackHandler = CalleeHandler.create();
    }

    CallbackWithHandler(FontRequestCallback fontsContractCompat$FontRequestCallback0, Handler handler0) {
        this.mCallback = fontsContractCompat$FontRequestCallback0;
        this.mCallbackHandler = handler0;
    }

    private void onTypefaceRequestFailed(int v) {
        androidx.core.provider.CallbackWithHandler.2 callbackWithHandler$20 = new Runnable() {
            @Override
            public void run() {
                this.mCallback.onTypefaceRequestFailed(v);
            }
        };
        this.mCallbackHandler.post(callbackWithHandler$20);
    }

    void onTypefaceResult(TypefaceResult fontRequestWorker$TypefaceResult0) {
        if(fontRequestWorker$TypefaceResult0.isSuccess()) {
            this.onTypefaceRetrieved(fontRequestWorker$TypefaceResult0.mTypeface);
            return;
        }
        this.onTypefaceRequestFailed(fontRequestWorker$TypefaceResult0.mResult);
    }

    private void onTypefaceRetrieved(Typeface typeface0) {
        androidx.core.provider.CallbackWithHandler.1 callbackWithHandler$10 = new Runnable() {
            @Override
            public void run() {
                this.mCallback.onTypefaceRetrieved(typeface0);
            }
        };
        this.mCallbackHandler.post(callbackWithHandler$10);
    }
}

