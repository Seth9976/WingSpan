package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

final class zzq implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        Preconditions.checkNotNull(((DetectedActivity)object0));
        Preconditions.checkNotNull(((DetectedActivity)object1));
        int v = ((DetectedActivity)object1).getConfidence().compareTo(((DetectedActivity)object0).getConfidence());
        return v == 0 ? ((DetectedActivity)object0).getType().compareTo(((DetectedActivity)object1).getType()) : v;
    }
}

