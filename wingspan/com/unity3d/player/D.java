package com.unity3d.player;

class d implements Runnable {
    private IAssetPackManagerMobileDataConfirmationCallback a;
    private boolean b;

    d(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback0, boolean z) {
        this.a = iAssetPackManagerMobileDataConfirmationCallback0;
        this.b = z;
    }

    @Override
    public void run() {
        this.a.onMobileDataConfirmationResult(this.b);
    }
}

