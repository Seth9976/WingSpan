package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;

public class AccessibilityWindowInfoCompat {
    static class Api21Impl {
        static void getBoundsInScreen(AccessibilityWindowInfo accessibilityWindowInfo0, Rect rect0) {
            accessibilityWindowInfo0.getBoundsInScreen(rect0);
        }

        static AccessibilityWindowInfo getChild(AccessibilityWindowInfo accessibilityWindowInfo0, int v) {
            return accessibilityWindowInfo0.getChild(v);
        }

        static int getChildCount(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.getChildCount();
        }

        static int getId(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.getId();
        }

        static int getLayer(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.getLayer();
        }

        static AccessibilityWindowInfo getParent(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.getParent();
        }

        static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.getRoot();
        }

        static int getType(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.getType();
        }

        static boolean isAccessibilityFocused(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.isAccessibilityFocused();
        }

        static boolean isActive(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.isActive();
        }

        static boolean isFocused(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.isFocused();
        }

        static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        static AccessibilityWindowInfo obtain(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo0);
        }

        static void recycle(AccessibilityWindowInfo accessibilityWindowInfo0) {
            accessibilityWindowInfo0.recycle();
        }
    }

    static class Api24Impl {
        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.getAnchor();
        }

        static CharSequence getTitle(AccessibilityWindowInfo accessibilityWindowInfo0) {
            return accessibilityWindowInfo0.getTitle();
        }
    }

    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    private AccessibilityWindowInfoCompat(Object object0) {
        this.mInfo = object0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        return this.mInfo == null ? ((AccessibilityWindowInfoCompat)object0).mInfo == null : this.mInfo.equals(((AccessibilityWindowInfoCompat)object0).mInfo);
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        return Build.VERSION.SDK_INT < 24 ? null : AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor(((AccessibilityWindowInfo)this.mInfo)));
    }

    public void getBoundsInScreen(Rect rect0) {
        Api21Impl.getBoundsInScreen(((AccessibilityWindowInfo)this.mInfo), rect0);
    }

    public AccessibilityWindowInfoCompat getChild(int v) {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(Api21Impl.getChild(((AccessibilityWindowInfo)this.mInfo), v));
    }

    public int getChildCount() {
        return Api21Impl.getChildCount(((AccessibilityWindowInfo)this.mInfo));
    }

    public int getId() {
        return Api21Impl.getId(((AccessibilityWindowInfo)this.mInfo));
    }

    public int getLayer() {
        return Api21Impl.getLayer(((AccessibilityWindowInfo)this.mInfo));
    }

    public AccessibilityWindowInfoCompat getParent() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(Api21Impl.getParent(((AccessibilityWindowInfo)this.mInfo)));
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot(((AccessibilityWindowInfo)this.mInfo)));
    }

    public CharSequence getTitle() {
        return Build.VERSION.SDK_INT < 24 ? null : Api24Impl.getTitle(((AccessibilityWindowInfo)this.mInfo));
    }

    public int getType() {
        return Api21Impl.getType(((AccessibilityWindowInfo)this.mInfo));
    }

    @Override
    public int hashCode() {
        return this.mInfo == null ? 0 : this.mInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return Api21Impl.isAccessibilityFocused(((AccessibilityWindowInfo)this.mInfo));
    }

    public boolean isActive() {
        return Api21Impl.isActive(((AccessibilityWindowInfo)this.mInfo));
    }

    public boolean isFocused() {
        return Api21Impl.isFocused(((AccessibilityWindowInfo)this.mInfo));
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(Api21Impl.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat0) {
        return accessibilityWindowInfoCompat0 == null ? null : AccessibilityWindowInfoCompat.wrapNonNullInstance(Api21Impl.obtain(((AccessibilityWindowInfo)accessibilityWindowInfoCompat0.mInfo)));
    }

    public void recycle() {
        Api21Impl.recycle(((AccessibilityWindowInfo)this.mInfo));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect rect0 = new Rect();
        this.getBoundsInScreen(rect0);
        stringBuilder0.append(this.getId());
        stringBuilder0.append(", type=");
        stringBuilder0.append(AccessibilityWindowInfoCompat.typeToString(this.getType()));
        stringBuilder0.append(", layer=");
        stringBuilder0.append(this.getLayer());
        stringBuilder0.append(", bounds=");
        stringBuilder0.append(rect0);
        stringBuilder0.append(", focused=");
        stringBuilder0.append(this.isFocused());
        stringBuilder0.append(", active=");
        stringBuilder0.append(this.isActive());
        stringBuilder0.append(", hasParent=");
        boolean z = true;
        stringBuilder0.append(this.getParent() != null);
        stringBuilder0.append(", hasChildren=");
        if(this.getChildCount() <= 0) {
            z = false;
        }
        stringBuilder0.append(z);
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }

    private static String typeToString(int v) {
        switch(v) {
            case 1: {
                return "TYPE_APPLICATION";
            }
            case 2: {
                return "TYPE_INPUT_METHOD";
            }
            case 3: {
                return "TYPE_SYSTEM";
            }
            case 4: {
                return "TYPE_ACCESSIBILITY_OVERLAY";
            }
            default: {
                return "<UNKNOWN>";
            }
        }
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object object0) {
        return object0 == null ? null : new AccessibilityWindowInfoCompat(object0);
    }
}

