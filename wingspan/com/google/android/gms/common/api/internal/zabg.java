package com.google.android.gms.common.api.internal;

abstract class zabg {
    private final zabf zaa;

    protected zabg(zabf zabf0) {
        this.zaa = zabf0;
    }

    protected abstract void zaa();

    public final void zab(zabi zabi0) {
        zabi0.zai.lock();
        try {
            if(zabi0.zan == this.zaa) {
                this.zaa();
            }
        }
        finally {
            zabi0.zai.unlock();
        }
    }
}

