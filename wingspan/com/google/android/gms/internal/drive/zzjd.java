package com.google.android.gms.internal.drive;

import java.util.NoSuchElementException;

final class zzjd extends zzjf {
    private final int limit;
    private int position;
    private final zzjc zznu;

    zzjd(zzjc zzjc0) {
        this.zznu = zzjc0;
        super();
        this.position = 0;
        this.limit = zzjc0.size();
    }

    @Override
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override  // com.google.android.gms.internal.drive.zzjj
    public final byte nextByte() {
        int v = this.position;
        if(v >= this.limit) {
            throw new NoSuchElementException();
        }
        this.position = v + 1;
        return this.zznu.zzt(v);
    }
}

