package com.google.android.gms.games;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PageDirection {
    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
    }

    public static final int NEXT = 0;
    public static final int NONE = -1;
    public static final int PREV = 1;

    private PageDirection() {
        throw new AssertionError("Uninstantiable");
    }
}

