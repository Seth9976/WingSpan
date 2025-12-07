package androidx.work.impl.model;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class WorkSpec..ExternalSyntheticBackport0 {
    public static int m(long v) {
        return (int)(v ^ v >>> 0x20);
    }

    // 去混淆评级： 低(20)
    public static int m(boolean z) {
        return z ? 0x4CF : 0x4D5;
    }

    public static boolean m(AtomicReference atomicReference0, Object object0, Object object1) {
        do {
            if(atomicReference0.compareAndSet(object0, object1)) {
                return true;
            }
        }
        while(atomicReference0.get() == object0);
        return false;
    }

    public static boolean m(AtomicReferenceArray atomicReferenceArray0, int v, Object object0, Object object1) {
        do {
            if(atomicReferenceArray0.compareAndSet(v, object0, object1)) {
                return true;
            }
        }
        while(atomicReferenceArray0.get(v) == object0);
        return false;
    }

    public static boolean m(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0, Object object0, Object object1, Object object2) {
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(object0, object1, object2)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(object0) == object1);
        return false;
    }
}

