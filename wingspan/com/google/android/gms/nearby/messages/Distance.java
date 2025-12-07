package com.google.android.gms.nearby.messages;

import com.google.android.gms.nearby.messages.internal.zze;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Distance extends Comparable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface Accuracy {
        public static final int LOW = 1;

    }

    public static final Distance UNKNOWN;

    static {
        Distance.UNKNOWN = new zze(1, NaN);
    }

    int compareTo(Distance arg1);

    int getAccuracy();

    double getMeters();
}

