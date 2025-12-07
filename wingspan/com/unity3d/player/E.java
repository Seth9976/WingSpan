package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnSuccessListener;

class e implements OnSuccessListener {
    private IAssetPackManagerMobileDataConfirmationCallback a;
    private Looper b;

    public e(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback0) {
        this.a = iAssetPackManagerMobileDataConfirmationCallback0;
        this.b = Looper.myLooper();
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object object0) {
        if(this.a != null) {
            new Handler(this.b).post(new d(this.a, ((int)(((Integer)object0))) == -1));
        }
    }
}

