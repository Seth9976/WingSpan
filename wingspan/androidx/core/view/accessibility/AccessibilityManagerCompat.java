package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

public final class AccessibilityManagerCompat {
    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean arg1);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        AccessibilityStateChangeListenerWrapper(AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener0) {
            this.mListener = accessibilityManagerCompat$AccessibilityStateChangeListener0;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof AccessibilityStateChangeListenerWrapper ? this.mListener.equals(((AccessibilityStateChangeListenerWrapper)object0).mListener) : false;
        }

        @Override
        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override  // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            this.mListener.onAccessibilityStateChanged(z);
        }
    }

    static class Api19Impl {
        static boolean addTouchExplorationStateChangeListenerWrapper(AccessibilityManager accessibilityManager0, TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener0) {
            return accessibilityManager0.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(accessibilityManagerCompat$TouchExplorationStateChangeListener0));
        }

        static boolean removeTouchExplorationStateChangeListenerWrapper(AccessibilityManager accessibilityManager0, TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener0) {
            return accessibilityManager0.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(accessibilityManagerCompat$TouchExplorationStateChangeListener0));
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean arg1);
    }

    static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        TouchExplorationStateChangeListenerWrapper(TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener0) {
            this.mListener = accessibilityManagerCompat$TouchExplorationStateChangeListener0;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof TouchExplorationStateChangeListenerWrapper ? this.mListener.equals(((TouchExplorationStateChangeListenerWrapper)object0).mListener) : false;
        }

        @Override
        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override  // android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.mListener.onTouchExplorationStateChanged(z);
        }
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager0, AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener0) {
        return accessibilityManagerCompat$AccessibilityStateChangeListener0 == null ? false : accessibilityManager0.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(accessibilityManagerCompat$AccessibilityStateChangeListener0));
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager0, TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener0) {
        return Api19Impl.addTouchExplorationStateChangeListenerWrapper(accessibilityManager0, accessibilityManagerCompat$TouchExplorationStateChangeListener0);
    }

    @Deprecated
    public static List getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager0, int v) {
        return accessibilityManager0.getEnabledAccessibilityServiceList(v);
    }

    @Deprecated
    public static List getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager0) {
        return accessibilityManager0.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager0) {
        return accessibilityManager0.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager0, AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener0) {
        return accessibilityManagerCompat$AccessibilityStateChangeListener0 == null ? false : accessibilityManager0.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(accessibilityManagerCompat$AccessibilityStateChangeListener0));
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager0, TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener0) {
        return Api19Impl.removeTouchExplorationStateChangeListenerWrapper(accessibilityManager0, accessibilityManagerCompat$TouchExplorationStateChangeListener0);
    }
}

