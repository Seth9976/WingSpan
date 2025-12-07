package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

final class zzn implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        Preconditions.checkNotNull(((ActivityTransition)object0));
        Preconditions.checkNotNull(((ActivityTransition)object1));
        int v = ((ActivityTransition)object0).getActivityType();
        int v1 = ((ActivityTransition)object1).getActivityType();
        if(v != v1) {
            return v >= v1 ? 1 : -1;
        }
        int v2 = ((ActivityTransition)object0).getTransitionType();
        int v3 = ((ActivityTransition)object1).getTransitionType();
        if(v2 == v3) {
            return 0;
        }
        return v2 >= v3 ? 1 : -1;
    }
}

