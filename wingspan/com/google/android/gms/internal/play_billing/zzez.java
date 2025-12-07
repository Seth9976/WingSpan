package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzez implements Iterator {
    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

