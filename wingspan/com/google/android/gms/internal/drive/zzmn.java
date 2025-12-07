package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzmn implements Iterator {
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

