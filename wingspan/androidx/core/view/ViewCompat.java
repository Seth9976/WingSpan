package androidx.core.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View.AccessibilityDelegate;
import android.view.View.DragShadowBuilder;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnUnhandledKeyEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.collection.SimpleArrayMap;
import androidx.core.R.id;
import androidx.core.util.Preconditions;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewCompat {
    static class AccessibilityPaneVisibilityManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakHashMap mPanesToVisible;

        AccessibilityPaneVisibilityManager() {
            this.mPanesToVisible = new WeakHashMap();
        }

        void addAccessibilityPane(View view0) {
            boolean z = view0.isShown() && view0.getWindowVisibility() == 0;
            this.mPanesToVisible.put(view0, Boolean.valueOf(z));
            view0.addOnAttachStateChangeListener(this);
            if(Api19Impl.isAttachedToWindow(view0)) {
                this.registerForLayoutCallback(view0);
            }
        }

        private void checkPaneVisibility(View view0, boolean z) {
            boolean z1 = view0.isShown() && view0.getWindowVisibility() == 0;
            if(z != z1) {
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view0, (z1 ? 16 : 0x20));
                this.mPanesToVisible.put(view0, Boolean.valueOf(z1));
            }
        }

        @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            if(Build.VERSION.SDK_INT < 28) {
                for(Object object0: this.mPanesToVisible.entrySet()) {
                    this.checkPaneVisibility(((View)((Map.Entry)object0).getKey()), ((Boolean)((Map.Entry)object0).getValue()).booleanValue());
                }
            }
        }

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view0) {
            this.registerForLayoutCallback(view0);
        }

        @Override  // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view0) {
        }

        private void registerForLayoutCallback(View view0) {
            view0.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        void removeAccessibilityPane(View view0) {
            this.mPanesToVisible.remove(view0);
            view0.removeOnAttachStateChangeListener(this);
            this.unregisterForLayoutCallback(view0);
        }

        private void unregisterForLayoutCallback(View view0) {
            Api16Impl.removeOnGlobalLayoutListener(view0.getViewTreeObserver(), this);
        }
    }

    static abstract class AccessibilityViewProperty {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class mType;

        AccessibilityViewProperty(int v, Class class0, int v1) {
            this(v, class0, 0, v1);
        }

        AccessibilityViewProperty(int v, Class class0, int v1, int v2) {
            this.mTagKey = v;
            this.mType = class0;
            this.mContentChangeType = v1;
            this.mFrameworkMinimumSdk = v2;
        }

        // 去混淆评级： 低(20)
        boolean booleanNullToFalseEquals(Boolean boolean0, Boolean boolean1) {
            return (boolean0 == null || !boolean0.booleanValue() ? 0 : 1) == (boolean1 == null || !boolean1.booleanValue() ? 0 : 1);
        }

        private boolean extrasAvailable() [...] // Inlined contents

        private boolean frameworkAvailable() {
            return Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
        }

        abstract Object frameworkGet(View arg1);

        abstract void frameworkSet(View arg1, Object arg2);

        Object get(View view0) {
            if(this.frameworkAvailable()) {
                return this.frameworkGet(view0);
            }
            Object object0 = view0.getTag(this.mTagKey);
            return this.mType.isInstance(object0) ? object0 : null;
        }

        void set(View view0, Object object0) {
            if(this.frameworkAvailable()) {
                this.frameworkSet(view0, object0);
                return;
            }
            if(this.shouldUpdate(this.get(view0), object0)) {
                ViewCompat.ensureAccessibilityDelegateCompat(view0);
                view0.setTag(this.mTagKey, object0);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view0, this.mContentChangeType);
            }
        }

        boolean shouldUpdate(Object object0, Object object1) {
            return !object1.equals(object0);
        }
    }

    static class Api15Impl {
        static boolean hasOnClickListeners(View view0) {
            return view0.hasOnClickListeners();
        }
    }

    static class Api16Impl {
        static AccessibilityNodeProvider getAccessibilityNodeProvider(View view0) {
            return view0.getAccessibilityNodeProvider();
        }

        static boolean getFitsSystemWindows(View view0) {
            return view0.getFitsSystemWindows();
        }

        static int getImportantForAccessibility(View view0) {
            return view0.getImportantForAccessibility();
        }

        static int getMinimumHeight(View view0) {
            return view0.getMinimumHeight();
        }

        static int getMinimumWidth(View view0) {
            return view0.getMinimumWidth();
        }

        static ViewParent getParentForAccessibility(View view0) {
            return view0.getParentForAccessibility();
        }

        static int getWindowSystemUiVisibility(View view0) {
            return view0.getWindowSystemUiVisibility();
        }

        static boolean hasOverlappingRendering(View view0) {
            return view0.hasOverlappingRendering();
        }

        static boolean hasTransientState(View view0) {
            return view0.hasTransientState();
        }

        static boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
            return view0.performAccessibilityAction(v, bundle0);
        }

        static void postInvalidateOnAnimation(View view0) {
            view0.postInvalidateOnAnimation();
        }

        static void postInvalidateOnAnimation(View view0, int v, int v1, int v2, int v3) {
            view0.postInvalidateOnAnimation(v, v1, v2, v3);
        }

        static void postOnAnimation(View view0, Runnable runnable0) {
            view0.postOnAnimation(runnable0);
        }

        static void postOnAnimationDelayed(View view0, Runnable runnable0, long v) {
            view0.postOnAnimationDelayed(runnable0, v);
        }

        static void removeOnGlobalLayoutListener(ViewTreeObserver viewTreeObserver0, ViewTreeObserver.OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener0) {
            viewTreeObserver0.removeOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListener0);
        }

        static void requestFitSystemWindows(View view0) {
            view0.requestFitSystemWindows();
        }

        static void setBackground(View view0, Drawable drawable0) {
            view0.setBackground(drawable0);
        }

        static void setHasTransientState(View view0, boolean z) {
            view0.setHasTransientState(z);
        }

        static void setImportantForAccessibility(View view0, int v) {
            view0.setImportantForAccessibility(v);
        }
    }

    static class Api17Impl {
        static int generateViewId() {
            return View.generateViewId();
        }

        static Display getDisplay(View view0) {
            return view0.getDisplay();
        }

        static int getLabelFor(View view0) {
            return view0.getLabelFor();
        }

        static int getLayoutDirection(View view0) {
            return view0.getLayoutDirection();
        }

        static int getPaddingEnd(View view0) {
            return view0.getPaddingEnd();
        }

        static int getPaddingStart(View view0) {
            return view0.getPaddingStart();
        }

        static boolean isPaddingRelative(View view0) {
            return view0.isPaddingRelative();
        }

        static void setLabelFor(View view0, int v) {
            view0.setLabelFor(v);
        }

        static void setLayerPaint(View view0, Paint paint0) {
            view0.setLayerPaint(paint0);
        }

        static void setLayoutDirection(View view0, int v) {
            view0.setLayoutDirection(v);
        }

        static void setPaddingRelative(View view0, int v, int v1, int v2, int v3) {
            view0.setPaddingRelative(v, v1, v2, v3);
        }
    }

    static class Api18Impl {
        static Rect getClipBounds(View view0) {
            return view0.getClipBounds();
        }

        static boolean isInLayout(View view0) {
            return view0.isInLayout();
        }

        static void setClipBounds(View view0, Rect rect0) {
            view0.setClipBounds(rect0);
        }
    }

    static class Api19Impl {
        static int getAccessibilityLiveRegion(View view0) {
            return view0.getAccessibilityLiveRegion();
        }

        static boolean isAttachedToWindow(View view0) {
            return view0.isAttachedToWindow();
        }

        static boolean isLaidOut(View view0) {
            return view0.isLaidOut();
        }

        static boolean isLayoutDirectionResolved(View view0) {
            return view0.isLayoutDirectionResolved();
        }

        static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent0, View view0, View view1, int v) {
            viewParent0.notifySubtreeAccessibilityStateChanged(view0, view1, v);
        }

        static void setAccessibilityLiveRegion(View view0, int v) {
            view0.setAccessibilityLiveRegion(v);
        }

        static void setContentChangeTypes(AccessibilityEvent accessibilityEvent0, int v) {
            accessibilityEvent0.setContentChangeTypes(v);
        }
    }

    static class Api20Impl {
        static WindowInsets dispatchApplyWindowInsets(View view0, WindowInsets windowInsets0) {
            return view0.dispatchApplyWindowInsets(windowInsets0);
        }

        static WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
            return view0.onApplyWindowInsets(windowInsets0);
        }

        static void requestApplyInsets(View view0) {
            view0.requestApplyInsets();
        }
    }

    static class Api21Impl {
        static void callCompatInsetAnimationCallback(WindowInsets windowInsets0, View view0) {
            View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener0 = (View.OnApplyWindowInsetsListener)view0.getTag(id.tag_window_insets_animation_callback);
            if(view$OnApplyWindowInsetsListener0 != null) {
                view$OnApplyWindowInsetsListener0.onApplyWindowInsets(view0, windowInsets0);
            }
        }

        static WindowInsetsCompat computeSystemWindowInsets(View view0, WindowInsetsCompat windowInsetsCompat0, Rect rect0) {
            WindowInsets windowInsets0 = windowInsetsCompat0.toWindowInsets();
            if(windowInsets0 != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view0.computeSystemWindowInsets(windowInsets0, rect0), view0);
            }
            rect0.setEmpty();
            return windowInsetsCompat0;
        }

        static boolean dispatchNestedFling(View view0, float f, float f1, boolean z) {
            return view0.dispatchNestedFling(f, f1, z);
        }

        static boolean dispatchNestedPreFling(View view0, float f, float f1) {
            return view0.dispatchNestedPreFling(f, f1);
        }

        static boolean dispatchNestedPreScroll(View view0, int v, int v1, int[] arr_v, int[] arr_v1) {
            return view0.dispatchNestedPreScroll(v, v1, arr_v, arr_v1);
        }

        static boolean dispatchNestedScroll(View view0, int v, int v1, int v2, int v3, int[] arr_v) {
            return view0.dispatchNestedScroll(v, v1, v2, v3, arr_v);
        }

        static ColorStateList getBackgroundTintList(View view0) {
            return view0.getBackgroundTintList();
        }

        static PorterDuff.Mode getBackgroundTintMode(View view0) {
            return view0.getBackgroundTintMode();
        }

        static float getElevation(View view0) {
            return view0.getElevation();
        }

        public static WindowInsetsCompat getRootWindowInsets(View view0) {
            return Api21ReflectionHolder.getRootWindowInsets(view0);
        }

        static String getTransitionName(View view0) {
            return view0.getTransitionName();
        }

        static float getTranslationZ(View view0) {
            return view0.getTranslationZ();
        }

        static float getZ(View view0) {
            return view0.getZ();
        }

        static boolean hasNestedScrollingParent(View view0) {
            return view0.hasNestedScrollingParent();
        }

        static boolean isImportantForAccessibility(View view0) {
            return view0.isImportantForAccessibility();
        }

        static boolean isNestedScrollingEnabled(View view0) {
            return view0.isNestedScrollingEnabled();
        }

        static void setBackgroundTintList(View view0, ColorStateList colorStateList0) {
            view0.setBackgroundTintList(colorStateList0);
        }

        static void setBackgroundTintMode(View view0, PorterDuff.Mode porterDuff$Mode0) {
            view0.setBackgroundTintMode(porterDuff$Mode0);
        }

        static void setElevation(View view0, float f) {
            view0.setElevation(f);
        }

        static void setNestedScrollingEnabled(View view0, boolean z) {
            view0.setNestedScrollingEnabled(z);
        }

        static void setOnApplyWindowInsetsListener(View view0, OnApplyWindowInsetsListener onApplyWindowInsetsListener0) {
            if(Build.VERSION.SDK_INT < 30) {
                view0.setTag(id.tag_on_apply_window_listener, onApplyWindowInsetsListener0);
            }
            if(onApplyWindowInsetsListener0 == null) {
                view0.setOnApplyWindowInsetsListener(((View.OnApplyWindowInsetsListener)view0.getTag(id.tag_window_insets_animation_callback)));
                return;
            }
            view0.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                WindowInsetsCompat mLastInsets;

                {
                    View view0 = view0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    OnApplyWindowInsetsListener onApplyWindowInsetsListener0 = onApplyWindowInsetsListener0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.mLastInsets = null;
                }

                @Override  // android.view.View$OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
                    WindowInsetsCompat windowInsetsCompat0 = WindowInsetsCompat.toWindowInsetsCompat(windowInsets0, view0);
                    if(Build.VERSION.SDK_INT < 30) {
                        Api21Impl.callCompatInsetAnimationCallback(windowInsets0, view0);
                        if(windowInsetsCompat0.equals(this.mLastInsets)) {
                            return onApplyWindowInsetsListener0.onApplyWindowInsets(view0, windowInsetsCompat0).toWindowInsets();
                        }
                    }
                    this.mLastInsets = windowInsetsCompat0;
                    WindowInsetsCompat windowInsetsCompat1 = onApplyWindowInsetsListener0.onApplyWindowInsets(view0, windowInsetsCompat0);
                    if(Build.VERSION.SDK_INT >= 30) {
                        return windowInsetsCompat1.toWindowInsets();
                    }
                    ViewCompat.requestApplyInsets(view0);
                    return windowInsetsCompat1.toWindowInsets();
                }
            });
        }

        static void setTransitionName(View view0, String s) {
            view0.setTransitionName(s);
        }

        static void setTranslationZ(View view0, float f) {
            view0.setTranslationZ(f);
        }

        static void setZ(View view0, float f) {
            view0.setZ(f);
        }

        static boolean startNestedScroll(View view0, int v) {
            return view0.startNestedScroll(v);
        }

        static void stopNestedScroll(View view0) {
            view0.stopNestedScroll();
        }
    }

    static class Api23Impl {
        public static WindowInsetsCompat getRootWindowInsets(View view0) {
            WindowInsets windowInsets0 = view0.getRootWindowInsets();
            if(windowInsets0 == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat0 = WindowInsetsCompat.toWindowInsetsCompat(windowInsets0);
            windowInsetsCompat0.setRootWindowInsets(windowInsetsCompat0);
            windowInsetsCompat0.copyRootViewBounds(view0.getRootView());
            return windowInsetsCompat0;
        }

        static int getScrollIndicators(View view0) {
            return view0.getScrollIndicators();
        }

        static void setScrollIndicators(View view0, int v) {
            view0.setScrollIndicators(v);
        }

        static void setScrollIndicators(View view0, int v, int v1) {
            view0.setScrollIndicators(v, v1);
        }
    }

    static class Api24Impl {
        static void cancelDragAndDrop(View view0) {
            view0.cancelDragAndDrop();
        }

        static void dispatchFinishTemporaryDetach(View view0) {
            view0.dispatchFinishTemporaryDetach();
        }

        static void dispatchStartTemporaryDetach(View view0) {
            view0.dispatchStartTemporaryDetach();
        }

        static void setPointerIcon(View view0, PointerIcon pointerIcon0) {
            view0.setPointerIcon(pointerIcon0);
        }

        static boolean startDragAndDrop(View view0, ClipData clipData0, View.DragShadowBuilder view$DragShadowBuilder0, Object object0, int v) {
            return view0.startDragAndDrop(clipData0, view$DragShadowBuilder0, object0, v);
        }

        static void updateDragShadow(View view0, View.DragShadowBuilder view$DragShadowBuilder0) {
            view0.updateDragShadow(view$DragShadowBuilder0);
        }
    }

    static class Api26Impl {
        static void addKeyboardNavigationClusters(View view0, Collection collection0, int v) {
            view0.addKeyboardNavigationClusters(collection0, v);
        }

        static int getImportantForAutofill(View view0) {
            return view0.getImportantForAutofill();
        }

        static int getNextClusterForwardId(View view0) {
            return view0.getNextClusterForwardId();
        }

        static boolean hasExplicitFocusable(View view0) {
            return view0.hasExplicitFocusable();
        }

        static boolean isFocusedByDefault(View view0) {
            return view0.isFocusedByDefault();
        }

        static boolean isImportantForAutofill(View view0) {
            return view0.isImportantForAutofill();
        }

        static boolean isKeyboardNavigationCluster(View view0) {
            return view0.isKeyboardNavigationCluster();
        }

        static View keyboardNavigationClusterSearch(View view0, View view1, int v) {
            return view0.keyboardNavigationClusterSearch(view1, v);
        }

        static boolean restoreDefaultFocus(View view0) {
            return view0.restoreDefaultFocus();
        }

        static void setAutofillHints(View view0, String[] arr_s) {
            view0.setAutofillHints(arr_s);
        }

        static void setFocusedByDefault(View view0, boolean z) {
            view0.setFocusedByDefault(z);
        }

        static void setImportantForAutofill(View view0, int v) {
            view0.setImportantForAutofill(v);
        }

        static void setKeyboardNavigationCluster(View view0, boolean z) {
            view0.setKeyboardNavigationCluster(z);
        }

        static void setNextClusterForwardId(View view0, int v) {
            view0.setNextClusterForwardId(v);
        }

        static void setTooltipText(View view0, CharSequence charSequence0) {
            view0.setTooltipText(charSequence0);
        }
    }

    static class Api28Impl {
        static void addOnUnhandledKeyEventListener(View view0, OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat0) {
            SimpleArrayMap simpleArrayMap0 = (SimpleArrayMap)view0.getTag(id.tag_unhandled_key_listeners);
            if(simpleArrayMap0 == null) {
                simpleArrayMap0 = new SimpleArrayMap();
                view0.setTag(id.tag_unhandled_key_listeners, simpleArrayMap0);
            }
            Objects.requireNonNull(viewCompat$OnUnhandledKeyEventListenerCompat0);
            ViewCompat.Api28Impl..ExternalSyntheticLambda0 viewCompat$Api28Impl$$ExternalSyntheticLambda00 = new ViewCompat.Api28Impl..ExternalSyntheticLambda0(viewCompat$OnUnhandledKeyEventListenerCompat0);
            simpleArrayMap0.put(viewCompat$OnUnhandledKeyEventListenerCompat0, viewCompat$Api28Impl$$ExternalSyntheticLambda00);
            view0.addOnUnhandledKeyEventListener(viewCompat$Api28Impl$$ExternalSyntheticLambda00);
        }

        static CharSequence getAccessibilityPaneTitle(View view0) {
            return view0.getAccessibilityPaneTitle();
        }

        static boolean isAccessibilityHeading(View view0) {
            return view0.isAccessibilityHeading();
        }

        static boolean isScreenReaderFocusable(View view0) {
            return view0.isScreenReaderFocusable();
        }

        static void removeOnUnhandledKeyEventListener(View view0, OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat0) {
            SimpleArrayMap simpleArrayMap0 = (SimpleArrayMap)view0.getTag(id.tag_unhandled_key_listeners);
            if(simpleArrayMap0 == null) {
                return;
            }
            View.OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener0 = (View.OnUnhandledKeyEventListener)simpleArrayMap0.get(viewCompat$OnUnhandledKeyEventListenerCompat0);
            if(view$OnUnhandledKeyEventListener0 != null) {
                view0.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener0);
            }
        }

        static Object requireViewById(View view0, int v) {
            return view0.requireViewById(v);
        }

        static void setAccessibilityHeading(View view0, boolean z) {
            view0.setAccessibilityHeading(z);
        }

        static void setAccessibilityPaneTitle(View view0, CharSequence charSequence0) {
            view0.setAccessibilityPaneTitle(charSequence0);
        }

        static void setScreenReaderFocusable(View view0, boolean z) {
            view0.setScreenReaderFocusable(z);
        }
    }

    static class Api29Impl {
        static View.AccessibilityDelegate getAccessibilityDelegate(View view0) {
            return view0.getAccessibilityDelegate();
        }

        static List getSystemGestureExclusionRects(View view0) {
            return view0.getSystemGestureExclusionRects();
        }

        static void saveAttributeDataForStyleable(View view0, Context context0, int[] arr_v, AttributeSet attributeSet0, TypedArray typedArray0, int v, int v1) {
            view0.saveAttributeDataForStyleable(context0, arr_v, attributeSet0, typedArray0, v, v1);
        }

        static void setSystemGestureExclusionRects(View view0, List list0) {
            view0.setSystemGestureExclusionRects(list0);
        }
    }

    static class Api30Impl {
        static CharSequence getStateDescription(View view0) {
            return view0.getStateDescription();
        }

        public static WindowInsetsControllerCompat getWindowInsetsController(View view0) {
            WindowInsetsController windowInsetsController0 = view0.getWindowInsetsController();
            return windowInsetsController0 == null ? null : WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController0);
        }

        static void setStateDescription(View view0, CharSequence charSequence0) {
            view0.setStateDescription(charSequence0);
        }
    }

    static final class Api31Impl {
        public static String[] getReceiveContentMimeTypes(View view0) {
            return view0.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View view0, ContentInfoCompat contentInfoCompat0) {
            ContentInfo contentInfo0 = contentInfoCompat0.toContentInfo();
            ContentInfo contentInfo1 = view0.performReceiveContent(contentInfo0);
            if(contentInfo1 == null) {
                return null;
            }
            return contentInfo1 == contentInfo0 ? contentInfoCompat0 : ContentInfoCompat.toContentInfoCompat(contentInfo1);
        }

        public static void setOnReceiveContentListener(View view0, String[] arr_s, OnReceiveContentListener onReceiveContentListener0) {
            if(onReceiveContentListener0 == null) {
                view0.setOnReceiveContentListener(arr_s, null);
                return;
            }
            view0.setOnReceiveContentListener(arr_s, new OnReceiveContentListenerAdapter(onReceiveContentListener0));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {
        private final OnReceiveContentListener mJetpackListener;

        OnReceiveContentListenerAdapter(OnReceiveContentListener onReceiveContentListener0) {
            this.mJetpackListener = onReceiveContentListener0;
        }

        @Override  // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view0, ContentInfo contentInfo0) {
            ContentInfoCompat contentInfoCompat0 = ContentInfoCompat.toContentInfoCompat(contentInfo0);
            ContentInfoCompat contentInfoCompat1 = this.mJetpackListener.onReceiveContent(view0, contentInfoCompat0);
            if(contentInfoCompat1 == null) {
                return null;
            }
            return contentInfoCompat1 == contentInfoCompat0 ? contentInfo0 : contentInfoCompat1.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View arg1, KeyEvent arg2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {
        private SparseArray mCapturedKeys;
        private WeakReference mLastDispatchedPreViewKeyEvent;
        private WeakHashMap mViewsContainingListeners;
        private static final ArrayList sViewsWithListeners;

        static {
            UnhandledKeyEventManager.sViewsWithListeners = new ArrayList();
        }

        UnhandledKeyEventManager() {
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        static UnhandledKeyEventManager at(View view0) {
            UnhandledKeyEventManager viewCompat$UnhandledKeyEventManager0 = (UnhandledKeyEventManager)view0.getTag(id.tag_unhandled_key_event_manager);
            if(viewCompat$UnhandledKeyEventManager0 == null) {
                viewCompat$UnhandledKeyEventManager0 = new UnhandledKeyEventManager();
                view0.setTag(id.tag_unhandled_key_event_manager, viewCompat$UnhandledKeyEventManager0);
            }
            return viewCompat$UnhandledKeyEventManager0;
        }

        boolean dispatch(View view0, KeyEvent keyEvent0) {
            if(keyEvent0.getAction() == 0) {
                this.recalcViewsWithUnhandled();
            }
            View view1 = this.dispatchInOrder(view0, keyEvent0);
            if(keyEvent0.getAction() == 0) {
                int v = keyEvent0.getKeyCode();
                if(view1 != null && !KeyEvent.isModifierKey(v)) {
                    this.getCapturedKeys().put(v, new WeakReference(view1));
                }
            }
            return view1 != null;
        }

        private View dispatchInOrder(View view0, KeyEvent keyEvent0) {
            if(this.mViewsContainingListeners != null && this.mViewsContainingListeners.containsKey(view0)) {
                if(view0 instanceof ViewGroup) {
                    for(int v = ((ViewGroup)view0).getChildCount() - 1; v >= 0; --v) {
                        View view1 = this.dispatchInOrder(((ViewGroup)view0).getChildAt(v), keyEvent0);
                        if(view1 != null) {
                            return view1;
                        }
                    }
                }
                return this.onUnhandledKeyEvent(view0, keyEvent0) ? view0 : null;
            }
            return null;
        }

        private SparseArray getCapturedKeys() {
            if(this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray();
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(View view0, KeyEvent keyEvent0) {
            ArrayList arrayList0 = (ArrayList)view0.getTag(id.tag_unhandled_key_listeners);
            if(arrayList0 != null) {
                for(int v = arrayList0.size() - 1; v >= 0; --v) {
                    if(((OnUnhandledKeyEventListenerCompat)arrayList0.get(v)).onUnhandledKeyEvent(view0, keyEvent0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean preDispatch(KeyEvent keyEvent0) {
            WeakReference weakReference0;
            if(this.mLastDispatchedPreViewKeyEvent != null && this.mLastDispatchedPreViewKeyEvent.get() == keyEvent0) {
                return false;
            }
            this.mLastDispatchedPreViewKeyEvent = new WeakReference(keyEvent0);
            SparseArray sparseArray0 = this.getCapturedKeys();
            if(keyEvent0.getAction() == 1) {
                int v = sparseArray0.indexOfKey(keyEvent0.getKeyCode());
                if(v >= 0) {
                    weakReference0 = (WeakReference)sparseArray0.valueAt(v);
                    sparseArray0.removeAt(v);
                }
                else {
                    weakReference0 = null;
                }
            }
            else {
                weakReference0 = null;
            }
            if(weakReference0 == null) {
                weakReference0 = (WeakReference)sparseArray0.get(keyEvent0.getKeyCode());
            }
            if(weakReference0 != null) {
                View view0 = (View)weakReference0.get();
                if(view0 != null && ViewCompat.isAttachedToWindow(view0)) {
                    this.onUnhandledKeyEvent(view0, keyEvent0);
                }
                return true;
            }
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap weakHashMap0 = this.mViewsContainingListeners;
            if(weakHashMap0 != null) {
                weakHashMap0.clear();
            }
            ArrayList arrayList0 = UnhandledKeyEventManager.sViewsWithListeners;
            if(arrayList0.isEmpty()) {
                return;
            }
            synchronized(arrayList0) {
                if(this.mViewsContainingListeners == null) {
                    this.mViewsContainingListeners = new WeakHashMap();
                }
                for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
                    ArrayList arrayList1 = UnhandledKeyEventManager.sViewsWithListeners;
                    View view0 = (View)((WeakReference)arrayList1.get(v1)).get();
                    if(view0 == null) {
                        arrayList1.remove(v1);
                    }
                    else {
                        this.mViewsContainingListeners.put(view0, Boolean.TRUE);
                        for(ViewParent viewParent0 = view0.getParent(); viewParent0 instanceof View; viewParent0 = viewParent0.getParent()) {
                            this.mViewsContainingListeners.put(((View)viewParent0), Boolean.TRUE);
                        }
                    }
                }
            }
        }

        static void registerListeningView(View view0) {
            ArrayList arrayList0 = UnhandledKeyEventManager.sViewsWithListeners;
            synchronized(arrayList0) {
                for(Object object0: arrayList0) {
                    if(((WeakReference)object0).get() == view0) {
                        return;
                    }
                    if(false) {
                        break;
                    }
                }
                WeakReference weakReference0 = new WeakReference(view0);
                UnhandledKeyEventManager.sViewsWithListeners.add(weakReference0);
            }
        }

        static void unregisterListeningView(View view0) {
            synchronized(UnhandledKeyEventManager.sViewsWithListeners) {
                for(int v1 = 0; true; ++v1) {
                    ArrayList arrayList1 = UnhandledKeyEventManager.sViewsWithListeners;
                    if(v1 >= arrayList1.size()) {
                        break;
                    }
                    if(((WeakReference)arrayList1.get(v1)).get() == view0) {
                        arrayList1.remove(v1);
                        return;
                    }
                }
            }
        }
    }

    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = null;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 0xFFFFFF;
    @Deprecated
    public static final int MEASURED_STATE_MASK = 0xFF000000;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 0x1000000;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = null;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 0x20;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId;
    private static boolean sTempDetachBound;
    private static ThreadLocal sThreadLocalRect;
    private static WeakHashMap sTransitionNameMap;
    private static WeakHashMap sViewPropertyAnimatorMap;

    static {
        ViewCompat.sNextGeneratedId = new AtomicInteger(1);
        ViewCompat.sViewPropertyAnimatorMap = null;
        ViewCompat.sAccessibilityDelegateCheckFailed = false;
        ViewCompat.ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{id.accessibility_custom_action_0, id.accessibility_custom_action_1, id.accessibility_custom_action_2, id.accessibility_custom_action_3, id.accessibility_custom_action_4, id.accessibility_custom_action_5, id.accessibility_custom_action_6, id.accessibility_custom_action_7, id.accessibility_custom_action_8, id.accessibility_custom_action_9, id.accessibility_custom_action_10, id.accessibility_custom_action_11, id.accessibility_custom_action_12, id.accessibility_custom_action_13, id.accessibility_custom_action_14, id.accessibility_custom_action_15, id.accessibility_custom_action_16, id.accessibility_custom_action_17, id.accessibility_custom_action_18, id.accessibility_custom_action_19, id.accessibility_custom_action_20, id.accessibility_custom_action_21, id.accessibility_custom_action_22, id.accessibility_custom_action_23, id.accessibility_custom_action_24, id.accessibility_custom_action_25, id.accessibility_custom_action_26, id.accessibility_custom_action_27, id.accessibility_custom_action_28, id.accessibility_custom_action_29, id.accessibility_custom_action_30, id.accessibility_custom_action_31};
        ViewCompat.NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new ViewCompat..ExternalSyntheticLambda0();
        ViewCompat.sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    private static AccessibilityViewProperty accessibilityHeadingProperty() {
        return new AccessibilityViewProperty(id.tag_accessibility_heading, Boolean.class, 28) {
            Boolean frameworkGet(View view0) {
                return Boolean.valueOf(Api28Impl.isAccessibilityHeading(view0));
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            Object frameworkGet(View view0) {
                return this.frameworkGet(view0);
            }

            void frameworkSet(View view0, Boolean boolean0) {
                Api28Impl.setAccessibilityHeading(view0, boolean0.booleanValue());
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            void frameworkSet(View view0, Object object0) {
                this.frameworkSet(view0, ((Boolean)object0));
            }

            boolean shouldUpdate(Boolean boolean0, Boolean boolean1) {
                return !this.booleanNullToFalseEquals(boolean0, boolean1);
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            boolean shouldUpdate(Object object0, Object object1) {
                return this.shouldUpdate(((Boolean)object0), ((Boolean)object1));
            }
        };
    }

    public static int addAccessibilityAction(View view0, CharSequence charSequence0, AccessibilityViewCommand accessibilityViewCommand0) {
        int v = ViewCompat.getAvailableActionIdFromResources(view0, charSequence0);
        if(v != -1) {
            ViewCompat.addAccessibilityAction(view0, new AccessibilityActionCompat(v, charSequence0, accessibilityViewCommand0));
        }
        return v;
    }

    private static void addAccessibilityAction(View view0, AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat0) {
        ViewCompat.ensureAccessibilityDelegateCompat(view0);
        ViewCompat.removeActionWithId(accessibilityNodeInfoCompat$AccessibilityActionCompat0.getId(), view0);
        ViewCompat.getActionList(view0).add(accessibilityNodeInfoCompat$AccessibilityActionCompat0);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view0, 0);
    }

    public static void addKeyboardNavigationClusters(View view0, Collection collection0, int v) {
        if(Build.VERSION.SDK_INT >= 26) {
            Api26Impl.addKeyboardNavigationClusters(view0, collection0, v);
        }
    }

    public static void addOnUnhandledKeyEventListener(View view0, OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat0) {
        if(Build.VERSION.SDK_INT >= 28) {
            Api28Impl.addOnUnhandledKeyEventListener(view0, viewCompat$OnUnhandledKeyEventListenerCompat0);
            return;
        }
        ArrayList arrayList0 = (ArrayList)view0.getTag(id.tag_unhandled_key_listeners);
        if(arrayList0 == null) {
            arrayList0 = new ArrayList();
            view0.setTag(id.tag_unhandled_key_listeners, arrayList0);
        }
        arrayList0.add(viewCompat$OnUnhandledKeyEventListenerCompat0);
        if(arrayList0.size() == 1) {
            UnhandledKeyEventManager.registerListeningView(view0);
        }
    }

    public static ViewPropertyAnimatorCompat animate(View view0) {
        if(ViewCompat.sViewPropertyAnimatorMap == null) {
            ViewCompat.sViewPropertyAnimatorMap = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat0 = (ViewPropertyAnimatorCompat)ViewCompat.sViewPropertyAnimatorMap.get(view0);
        if(viewPropertyAnimatorCompat0 == null) {
            viewPropertyAnimatorCompat0 = new ViewPropertyAnimatorCompat(view0);
            ViewCompat.sViewPropertyAnimatorMap.put(view0, viewPropertyAnimatorCompat0);
        }
        return viewPropertyAnimatorCompat0;
    }

    private static void bindTempDetach() {
        try {
            ViewCompat.sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach");
            ViewCompat.sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach");
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            Log.e("ViewCompat", "Couldn\'t find method", noSuchMethodException0);
        }
        ViewCompat.sTempDetachBound = true;
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view0, int v) {
        return view0.canScrollHorizontally(v);
    }

    @Deprecated
    public static boolean canScrollVertically(View view0, int v) {
        return view0.canScrollVertically(v);
    }

    public static void cancelDragAndDrop(View view0) {
        if(Build.VERSION.SDK_INT >= 24) {
            Api24Impl.cancelDragAndDrop(view0);
        }
    }

    @Deprecated
    public static int combineMeasuredStates(int v, int v1) {
        return View.combineMeasuredStates(v, v1);
    }

    private static void compatOffsetLeftAndRight(View view0, int v) {
        view0.offsetLeftAndRight(v);
        if(view0.getVisibility() == 0) {
            ViewCompat.tickleInvalidationFlag(view0);
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 instanceof View) {
                ViewCompat.tickleInvalidationFlag(((View)viewParent0));
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view0, int v) {
        view0.offsetTopAndBottom(v);
        if(view0.getVisibility() == 0) {
            ViewCompat.tickleInvalidationFlag(view0);
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 instanceof View) {
                ViewCompat.tickleInvalidationFlag(((View)viewParent0));
            }
        }
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View view0, WindowInsetsCompat windowInsetsCompat0, Rect rect0) {
        return Api21Impl.computeSystemWindowInsets(view0, windowInsetsCompat0, rect0);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view0, WindowInsetsCompat windowInsetsCompat0) {
        WindowInsets windowInsets0 = windowInsetsCompat0.toWindowInsets();
        if(windowInsets0 != null) {
            WindowInsets windowInsets1 = Api20Impl.dispatchApplyWindowInsets(view0, windowInsets0);
            return windowInsets1.equals(windowInsets0) ? windowInsetsCompat0 : WindowInsetsCompat.toWindowInsetsCompat(windowInsets1, view0);
        }
        return windowInsetsCompat0;
    }

    public static void dispatchFinishTemporaryDetach(View view0) {
        if(Build.VERSION.SDK_INT >= 24) {
            Api24Impl.dispatchFinishTemporaryDetach(view0);
            return;
        }
        if(!ViewCompat.sTempDetachBound) {
            ViewCompat.bindTempDetach();
        }
        Method method0 = ViewCompat.sDispatchFinishTemporaryDetach;
        if(method0 != null) {
            try {
                method0.invoke(view0);
            }
            catch(Exception exception0) {
                Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", exception0);
            }
            return;
        }
        view0.onFinishTemporaryDetach();
    }

    public static boolean dispatchNestedFling(View view0, float f, float f1, boolean z) {
        return Api21Impl.dispatchNestedFling(view0, f, f1, z);
    }

    public static boolean dispatchNestedPreFling(View view0, float f, float f1) {
        return Api21Impl.dispatchNestedPreFling(view0, f, f1);
    }

    public static boolean dispatchNestedPreScroll(View view0, int v, int v1, int[] arr_v, int[] arr_v1) {
        return Api21Impl.dispatchNestedPreScroll(view0, v, v1, arr_v, arr_v1);
    }

    public static boolean dispatchNestedPreScroll(View view0, int v, int v1, int[] arr_v, int[] arr_v1, int v2) {
        if(view0 instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view0).dispatchNestedPreScroll(v, v1, arr_v, arr_v1, v2);
        }
        return v2 == 0 ? ViewCompat.dispatchNestedPreScroll(view0, v, v1, arr_v, arr_v1) : false;
    }

    public static void dispatchNestedScroll(View view0, int v, int v1, int v2, int v3, int[] arr_v, int v4, int[] arr_v1) {
        if(view0 instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3)view0).dispatchNestedScroll(v, v1, v2, v3, arr_v, v4, arr_v1);
            return;
        }
        ViewCompat.dispatchNestedScroll(view0, v, v1, v2, v3, arr_v, v4);
    }

    public static boolean dispatchNestedScroll(View view0, int v, int v1, int v2, int v3, int[] arr_v) {
        return Api21Impl.dispatchNestedScroll(view0, v, v1, v2, v3, arr_v);
    }

    public static boolean dispatchNestedScroll(View view0, int v, int v1, int v2, int v3, int[] arr_v, int v4) {
        if(view0 instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view0).dispatchNestedScroll(v, v1, v2, v3, arr_v, v4);
        }
        return v4 == 0 ? ViewCompat.dispatchNestedScroll(view0, v, v1, v2, v3, arr_v) : false;
    }

    public static void dispatchStartTemporaryDetach(View view0) {
        if(Build.VERSION.SDK_INT >= 24) {
            Api24Impl.dispatchStartTemporaryDetach(view0);
            return;
        }
        if(!ViewCompat.sTempDetachBound) {
            ViewCompat.bindTempDetach();
        }
        Method method0 = ViewCompat.sDispatchStartTemporaryDetach;
        if(method0 != null) {
            try {
                method0.invoke(view0);
            }
            catch(Exception exception0) {
                Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", exception0);
            }
            return;
        }
        view0.onStartTemporaryDetach();
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View view0, KeyEvent keyEvent0) {
        return Build.VERSION.SDK_INT < 28 ? UnhandledKeyEventManager.at(view0).dispatch(view0, keyEvent0) : false;
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view0, KeyEvent keyEvent0) {
        return Build.VERSION.SDK_INT < 28 ? UnhandledKeyEventManager.at(view0).preDispatch(keyEvent0) : false;
    }

    public static void enableAccessibleClickableSpanSupport(View view0) {
        ViewCompat.ensureAccessibilityDelegateCompat(view0);
    }

    static void ensureAccessibilityDelegateCompat(View view0) {
        AccessibilityDelegateCompat accessibilityDelegateCompat0 = ViewCompat.getAccessibilityDelegate(view0);
        if(accessibilityDelegateCompat0 == null) {
            accessibilityDelegateCompat0 = new AccessibilityDelegateCompat();
        }
        ViewCompat.setAccessibilityDelegate(view0, accessibilityDelegateCompat0);
    }

    public static int generateViewId() {
        return Api17Impl.generateViewId();
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View view0) {
        View.AccessibilityDelegate view$AccessibilityDelegate0 = ViewCompat.getAccessibilityDelegateInternal(view0);
        if(view$AccessibilityDelegate0 == null) {
            return null;
        }
        return view$AccessibilityDelegate0 instanceof AccessibilityDelegateAdapter ? ((AccessibilityDelegateAdapter)view$AccessibilityDelegate0).mCompat : new AccessibilityDelegateCompat(view$AccessibilityDelegate0);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(View view0) {
        return Build.VERSION.SDK_INT < 29 ? ViewCompat.getAccessibilityDelegateThroughReflection(view0) : Api29Impl.getAccessibilityDelegate(view0);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(View view0) {
        if(ViewCompat.sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if(ViewCompat.sAccessibilityDelegateField == null) {
            try {
                Field field0 = View.class.getDeclaredField("mAccessibilityDelegate");
                ViewCompat.sAccessibilityDelegateField = field0;
                field0.setAccessible(true);
            }
            catch(Throwable unused_ex) {
                ViewCompat.sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object object0 = ViewCompat.sAccessibilityDelegateField.get(view0);
            return object0 instanceof View.AccessibilityDelegate ? ((View.AccessibilityDelegate)object0) : null;
        }
        catch(Throwable unused_ex) {
            ViewCompat.sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static int getAccessibilityLiveRegion(View view0) {
        return Api19Impl.getAccessibilityLiveRegion(view0);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view0) {
        AccessibilityNodeProvider accessibilityNodeProvider0 = Api16Impl.getAccessibilityNodeProvider(view0);
        return accessibilityNodeProvider0 == null ? null : new AccessibilityNodeProviderCompat(accessibilityNodeProvider0);
    }

    public static CharSequence getAccessibilityPaneTitle(View view0) {
        return (CharSequence)ViewCompat.paneTitleProperty().get(view0);
    }

    private static List getActionList(View view0) {
        List list0 = (ArrayList)view0.getTag(id.tag_accessibility_actions);
        if(list0 == null) {
            list0 = new ArrayList();
            view0.setTag(id.tag_accessibility_actions, list0);
        }
        return list0;
    }

    @Deprecated
    public static float getAlpha(View view0) {
        return view0.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View view0, CharSequence charSequence0) {
        List list0 = ViewCompat.getActionList(view0);
        for(int v = 0; v < list0.size(); ++v) {
            if(TextUtils.equals(charSequence0, ((AccessibilityActionCompat)list0.get(v)).getLabel())) {
                return ((AccessibilityActionCompat)list0.get(v)).getId();
            }
        }
        int v1 = -1;
        for(int v2 = 0; true; ++v2) {
            int[] arr_v = ViewCompat.ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if(v2 >= arr_v.length || v1 != -1) {
                break;
            }
            int v3 = arr_v[v2];
            int v5 = 1;
            for(int v4 = 0; v4 < list0.size(); ++v4) {
                v5 &= (((AccessibilityActionCompat)list0.get(v4)).getId() == v3 ? 0 : 1);
            }
            if(v5 != 0) {
                v1 = v3;
            }
        }
        return v1;
    }

    public static ColorStateList getBackgroundTintList(View view0) {
        return Api21Impl.getBackgroundTintList(view0);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view0) {
        return Api21Impl.getBackgroundTintMode(view0);
    }

    public static Rect getClipBounds(View view0) {
        return Api18Impl.getClipBounds(view0);
    }

    public static Display getDisplay(View view0) {
        return Api17Impl.getDisplay(view0);
    }

    public static float getElevation(View view0) {
        return Api21Impl.getElevation(view0);
    }

    private static Rect getEmptyTempRect() {
        if(ViewCompat.sThreadLocalRect == null) {
            ViewCompat.sThreadLocalRect = new ThreadLocal();
        }
        Rect rect0 = (Rect)ViewCompat.sThreadLocalRect.get();
        if(rect0 == null) {
            rect0 = new Rect();
            ViewCompat.sThreadLocalRect.set(rect0);
        }
        rect0.setEmpty();
        return rect0;
    }

    // 去混淆评级： 低(20)
    private static OnReceiveContentViewBehavior getFallback(View view0) {
        return view0 instanceof OnReceiveContentViewBehavior ? ((OnReceiveContentViewBehavior)view0) : ViewCompat.NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(View view0) {
        return Api16Impl.getFitsSystemWindows(view0);
    }

    public static int getImportantForAccessibility(View view0) {
        return Api16Impl.getImportantForAccessibility(view0);
    }

    public static int getImportantForAutofill(View view0) {
        return Build.VERSION.SDK_INT < 26 ? 0 : Api26Impl.getImportantForAutofill(view0);
    }

    public static int getLabelFor(View view0) {
        return Api17Impl.getLabelFor(view0);
    }

    @Deprecated
    public static int getLayerType(View view0) {
        return view0.getLayerType();
    }

    public static int getLayoutDirection(View view0) {
        return Api17Impl.getLayoutDirection(view0);
    }

    @Deprecated
    public static Matrix getMatrix(View view0) {
        return view0.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view0) {
        return view0.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view0) {
        return view0.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view0) {
        return view0.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(View view0) {
        return Api16Impl.getMinimumHeight(view0);
    }

    public static int getMinimumWidth(View view0) {
        return Api16Impl.getMinimumWidth(view0);
    }

    public static int getNextClusterForwardId(View view0) {
        return Build.VERSION.SDK_INT < 26 ? -1 : Api26Impl.getNextClusterForwardId(view0);
    }

    public static String[] getOnReceiveContentMimeTypes(View view0) {
        return Build.VERSION.SDK_INT < 0x1F ? ((String[])view0.getTag(id.tag_on_receive_content_mime_types)) : Api31Impl.getReceiveContentMimeTypes(view0);
    }

    @Deprecated
    public static int getOverScrollMode(View view0) {
        return view0.getOverScrollMode();
    }

    public static int getPaddingEnd(View view0) {
        return Api17Impl.getPaddingEnd(view0);
    }

    public static int getPaddingStart(View view0) {
        return Api17Impl.getPaddingStart(view0);
    }

    public static ViewParent getParentForAccessibility(View view0) {
        return Api16Impl.getParentForAccessibility(view0);
    }

    @Deprecated
    public static float getPivotX(View view0) {
        return view0.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view0) {
        return view0.getPivotY();
    }

    public static WindowInsetsCompat getRootWindowInsets(View view0) {
        return Api23Impl.getRootWindowInsets(view0);
    }

    @Deprecated
    public static float getRotation(View view0) {
        return view0.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view0) {
        return view0.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view0) {
        return view0.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view0) {
        return view0.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view0) {
        return view0.getScaleY();
    }

    public static int getScrollIndicators(View view0) {
        return Api23Impl.getScrollIndicators(view0);
    }

    public static CharSequence getStateDescription(View view0) {
        return (CharSequence)ViewCompat.stateDescriptionProperty().get(view0);
    }

    public static List getSystemGestureExclusionRects(View view0) {
        return Build.VERSION.SDK_INT < 29 ? Collections.emptyList() : Api29Impl.getSystemGestureExclusionRects(view0);
    }

    public static String getTransitionName(View view0) {
        return Api21Impl.getTransitionName(view0);
    }

    @Deprecated
    public static float getTranslationX(View view0) {
        return view0.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view0) {
        return view0.getTranslationY();
    }

    public static float getTranslationZ(View view0) {
        return Api21Impl.getTranslationZ(view0);
    }

    @Deprecated
    public static WindowInsetsControllerCompat getWindowInsetsController(View view0) {
        if(Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getWindowInsetsController(view0);
        }
        for(Context context0 = view0.getContext(); context0 instanceof ContextWrapper; context0 = ((ContextWrapper)context0).getBaseContext()) {
            if(context0 instanceof Activity) {
                Window window0 = ((Activity)context0).getWindow();
                return window0 == null ? null : WindowCompat.getInsetsController(window0, view0);
            }
        }
        return null;
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(View view0) {
        return Api16Impl.getWindowSystemUiVisibility(view0);
    }

    @Deprecated
    public static float getX(View view0) {
        return view0.getX();
    }

    @Deprecated
    public static float getY(View view0) {
        return view0.getY();
    }

    public static float getZ(View view0) {
        return Api21Impl.getZ(view0);
    }

    public static boolean hasAccessibilityDelegate(View view0) {
        return ViewCompat.getAccessibilityDelegateInternal(view0) != null;
    }

    public static boolean hasExplicitFocusable(View view0) {
        return Build.VERSION.SDK_INT < 26 ? view0.hasFocusable() : Api26Impl.hasExplicitFocusable(view0);
    }

    public static boolean hasNestedScrollingParent(View view0) {
        return Api21Impl.hasNestedScrollingParent(view0);
    }

    public static boolean hasNestedScrollingParent(View view0, int v) {
        if(view0 instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2)view0).hasNestedScrollingParent(v);
            return false;
        }
        return v == 0 ? ViewCompat.hasNestedScrollingParent(view0) : false;
    }

    public static boolean hasOnClickListeners(View view0) {
        return Api15Impl.hasOnClickListeners(view0);
    }

    public static boolean hasOverlappingRendering(View view0) {
        return Api16Impl.hasOverlappingRendering(view0);
    }

    public static boolean hasTransientState(View view0) {
        return Api16Impl.hasTransientState(view0);
    }

    public static boolean isAccessibilityHeading(View view0) {
        Boolean boolean0 = (Boolean)ViewCompat.accessibilityHeadingProperty().get(view0);
        return boolean0 != null && boolean0.booleanValue();
    }

    public static boolean isAttachedToWindow(View view0) {
        return Api19Impl.isAttachedToWindow(view0);
    }

    public static boolean isFocusedByDefault(View view0) {
        return Build.VERSION.SDK_INT < 26 ? false : Api26Impl.isFocusedByDefault(view0);
    }

    public static boolean isImportantForAccessibility(View view0) {
        return Api21Impl.isImportantForAccessibility(view0);
    }

    public static boolean isImportantForAutofill(View view0) {
        return Build.VERSION.SDK_INT < 26 ? true : Api26Impl.isImportantForAutofill(view0);
    }

    public static boolean isInLayout(View view0) {
        return Api18Impl.isInLayout(view0);
    }

    public static boolean isKeyboardNavigationCluster(View view0) {
        return Build.VERSION.SDK_INT < 26 ? false : Api26Impl.isKeyboardNavigationCluster(view0);
    }

    public static boolean isLaidOut(View view0) {
        return Api19Impl.isLaidOut(view0);
    }

    public static boolean isLayoutDirectionResolved(View view0) {
        return Api19Impl.isLayoutDirectionResolved(view0);
    }

    public static boolean isNestedScrollingEnabled(View view0) {
        return Api21Impl.isNestedScrollingEnabled(view0);
    }

    @Deprecated
    public static boolean isOpaque(View view0) {
        return view0.isOpaque();
    }

    public static boolean isPaddingRelative(View view0) {
        return Api17Impl.isPaddingRelative(view0);
    }

    public static boolean isScreenReaderFocusable(View view0) {
        Boolean boolean0 = (Boolean)ViewCompat.screenReaderFocusableProperty().get(view0);
        return boolean0 != null && boolean0.booleanValue();
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view0) {
        view0.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view0, View view1, int v) {
        return Build.VERSION.SDK_INT < 26 ? null : Api26Impl.keyboardNavigationClusterSearch(view0, view1, v);
    }

    static ContentInfoCompat lambda$static$0(ContentInfoCompat contentInfoCompat0) [...] // Inlined contents

    static void notifyViewAccessibilityStateChangedIfNeeded(View view0, int v) {
        AccessibilityManager accessibilityManager0 = (AccessibilityManager)view0.getContext().getSystemService("accessibility");
        if(!accessibilityManager0.isEnabled()) {
            return;
        }
        boolean z = ViewCompat.getAccessibilityPaneTitle(view0) != null && view0.isShown() && view0.getWindowVisibility() == 0;
        int v1 = 0x20;
        if(ViewCompat.getAccessibilityLiveRegion(view0) != 0 || z) {
            AccessibilityEvent accessibilityEvent1 = AccessibilityEvent.obtain();
            if(!z) {
                v1 = 0x800;
            }
            accessibilityEvent1.setEventType(v1);
            Api19Impl.setContentChangeTypes(accessibilityEvent1, v);
            if(z) {
                accessibilityEvent1.getText().add(ViewCompat.getAccessibilityPaneTitle(view0));
                ViewCompat.setViewImportanceForAccessibilityIfNeeded(view0);
            }
            view0.sendAccessibilityEventUnchecked(accessibilityEvent1);
        }
        else {
            if(v == 0x20) {
                AccessibilityEvent accessibilityEvent0 = AccessibilityEvent.obtain();
                view0.onInitializeAccessibilityEvent(accessibilityEvent0);
                accessibilityEvent0.setEventType(0x20);
                Api19Impl.setContentChangeTypes(accessibilityEvent0, 0x20);
                accessibilityEvent0.setSource(view0);
                view0.onPopulateAccessibilityEvent(accessibilityEvent0);
                accessibilityEvent0.getText().add(ViewCompat.getAccessibilityPaneTitle(view0));
                accessibilityManager0.sendAccessibilityEvent(accessibilityEvent0);
                return;
            }
            if(view0.getParent() != null) {
                ViewParent viewParent0 = view0.getParent();
                try {
                    Api19Impl.notifySubtreeAccessibilityStateChanged(viewParent0, view0, view0, v);
                }
                catch(AbstractMethodError abstractMethodError0) {
                    Log.e("ViewCompat", view0.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", abstractMethodError0);
                }
            }
        }
    }

    public static void offsetLeftAndRight(View view0, int v) {
        view0.offsetLeftAndRight(v);
    }

    public static void offsetTopAndBottom(View view0, int v) {
        view0.offsetTopAndBottom(v);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view0, WindowInsetsCompat windowInsetsCompat0) {
        WindowInsets windowInsets0 = windowInsetsCompat0.toWindowInsets();
        if(windowInsets0 != null) {
            WindowInsets windowInsets1 = Api20Impl.onApplyWindowInsets(view0, windowInsets0);
            return windowInsets1.equals(windowInsets0) ? windowInsetsCompat0 : WindowInsetsCompat.toWindowInsetsCompat(windowInsets1, view0);
        }
        return windowInsetsCompat0;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        view0.onInitializeAccessibilityEvent(accessibilityEvent0);
    }

    public static void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat0) {
        view0.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat0.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        view0.onPopulateAccessibilityEvent(accessibilityEvent0);
    }

    private static AccessibilityViewProperty paneTitleProperty() {
        return new AccessibilityViewProperty(id.tag_accessibility_pane_title, CharSequence.class, 8, 28) {
            CharSequence frameworkGet(View view0) {
                return Api28Impl.getAccessibilityPaneTitle(view0);
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            Object frameworkGet(View view0) {
                return this.frameworkGet(view0);
            }

            void frameworkSet(View view0, CharSequence charSequence0) {
                Api28Impl.setAccessibilityPaneTitle(view0, charSequence0);
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            void frameworkSet(View view0, Object object0) {
                this.frameworkSet(view0, ((CharSequence)object0));
            }

            boolean shouldUpdate(CharSequence charSequence0, CharSequence charSequence1) {
                return !TextUtils.equals(charSequence0, charSequence1);
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            boolean shouldUpdate(Object object0, Object object1) {
                return this.shouldUpdate(((CharSequence)object0), ((CharSequence)object1));
            }
        };
    }

    public static boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        return Api16Impl.performAccessibilityAction(view0, v, bundle0);
    }

    public static ContentInfoCompat performReceiveContent(View view0, ContentInfoCompat contentInfoCompat0) {
        if(Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + contentInfoCompat0 + ", view=" + view0.getClass().getSimpleName() + "[" + view0.getId() + "]");
        }
        if(Build.VERSION.SDK_INT >= 0x1F) {
            return Api31Impl.performReceiveContent(view0, contentInfoCompat0);
        }
        OnReceiveContentListener onReceiveContentListener0 = (OnReceiveContentListener)view0.getTag(id.tag_on_receive_content_listener);
        if(onReceiveContentListener0 != null) {
            ContentInfoCompat contentInfoCompat1 = onReceiveContentListener0.onReceiveContent(view0, contentInfoCompat0);
            return contentInfoCompat1 == null ? null : ViewCompat.getFallback(view0).onReceiveContent(contentInfoCompat1);
        }
        return ViewCompat.getFallback(view0).onReceiveContent(contentInfoCompat0);
    }

    public static void postInvalidateOnAnimation(View view0) {
        Api16Impl.postInvalidateOnAnimation(view0);
    }

    public static void postInvalidateOnAnimation(View view0, int v, int v1, int v2, int v3) {
        Api16Impl.postInvalidateOnAnimation(view0, v, v1, v2, v3);
    }

    public static void postOnAnimation(View view0, Runnable runnable0) {
        Api16Impl.postOnAnimation(view0, runnable0);
    }

    public static void postOnAnimationDelayed(View view0, Runnable runnable0, long v) {
        Api16Impl.postOnAnimationDelayed(view0, runnable0, v);
    }

    public static void removeAccessibilityAction(View view0, int v) {
        ViewCompat.removeActionWithId(v, view0);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view0, 0);
    }

    private static void removeActionWithId(int v, View view0) {
        List list0 = ViewCompat.getActionList(view0);
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            if(((AccessibilityActionCompat)list0.get(v1)).getId() == v) {
                list0.remove(v1);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(View view0, OnUnhandledKeyEventListenerCompat viewCompat$OnUnhandledKeyEventListenerCompat0) {
        if(Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeOnUnhandledKeyEventListener(view0, viewCompat$OnUnhandledKeyEventListenerCompat0);
            return;
        }
        ArrayList arrayList0 = (ArrayList)view0.getTag(id.tag_unhandled_key_listeners);
        if(arrayList0 != null) {
            arrayList0.remove(viewCompat$OnUnhandledKeyEventListenerCompat0);
            if(arrayList0.size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(view0);
            }
        }
    }

    public static void replaceAccessibilityAction(View view0, AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat0, CharSequence charSequence0, AccessibilityViewCommand accessibilityViewCommand0) {
        if(accessibilityViewCommand0 == null && charSequence0 == null) {
            ViewCompat.removeAccessibilityAction(view0, accessibilityNodeInfoCompat$AccessibilityActionCompat0.getId());
            return;
        }
        ViewCompat.addAccessibilityAction(view0, accessibilityNodeInfoCompat$AccessibilityActionCompat0.createReplacementAction(charSequence0, accessibilityViewCommand0));
    }

    public static void requestApplyInsets(View view0) {
        Api20Impl.requestApplyInsets(view0);
    }

    public static View requireViewById(View view0, int v) {
        if(Build.VERSION.SDK_INT >= 28) {
            return (View)Api28Impl.requireViewById(view0, v);
        }
        View view1 = view0.findViewById(v);
        if(view1 == null) {
            throw new IllegalArgumentException("ID does not reference a View inside this View");
        }
        return view1;
    }

    @Deprecated
    public static int resolveSizeAndState(int v, int v1, int v2) {
        return View.resolveSizeAndState(v, v1, v2);
    }

    public static boolean restoreDefaultFocus(View view0) {
        return Build.VERSION.SDK_INT < 26 ? view0.requestFocus() : Api26Impl.restoreDefaultFocus(view0);
    }

    public static void saveAttributeDataForStyleable(View view0, Context context0, int[] arr_v, AttributeSet attributeSet0, TypedArray typedArray0, int v, int v1) {
        if(Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view0, context0, arr_v, attributeSet0, typedArray0, v, v1);
        }
    }

    private static AccessibilityViewProperty screenReaderFocusableProperty() {
        return new AccessibilityViewProperty(id.tag_screen_reader_focusable, Boolean.class, 28) {
            Boolean frameworkGet(View view0) {
                return Boolean.valueOf(Api28Impl.isScreenReaderFocusable(view0));
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            Object frameworkGet(View view0) {
                return this.frameworkGet(view0);
            }

            void frameworkSet(View view0, Boolean boolean0) {
                Api28Impl.setScreenReaderFocusable(view0, boolean0.booleanValue());
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            void frameworkSet(View view0, Object object0) {
                this.frameworkSet(view0, ((Boolean)object0));
            }

            boolean shouldUpdate(Boolean boolean0, Boolean boolean1) {
                return !this.booleanNullToFalseEquals(boolean0, boolean1);
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            boolean shouldUpdate(Object object0, Object object1) {
                return this.shouldUpdate(((Boolean)object0), ((Boolean)object1));
            }
        };
    }

    public static void setAccessibilityDelegate(View view0, AccessibilityDelegateCompat accessibilityDelegateCompat0) {
        if(accessibilityDelegateCompat0 == null && ViewCompat.getAccessibilityDelegateInternal(view0) instanceof AccessibilityDelegateAdapter) {
            accessibilityDelegateCompat0 = new AccessibilityDelegateCompat();
        }
        view0.setAccessibilityDelegate((accessibilityDelegateCompat0 == null ? null : accessibilityDelegateCompat0.getBridge()));
    }

    public static void setAccessibilityHeading(View view0, boolean z) {
        ViewCompat.accessibilityHeadingProperty().set(view0, Boolean.valueOf(z));
    }

    public static void setAccessibilityLiveRegion(View view0, int v) {
        Api19Impl.setAccessibilityLiveRegion(view0, v);
    }

    public static void setAccessibilityPaneTitle(View view0, CharSequence charSequence0) {
        ViewCompat.paneTitleProperty().set(view0, charSequence0);
        if(charSequence0 != null) {
            ViewCompat.sAccessibilityPaneVisibilityManager.addAccessibilityPane(view0);
            return;
        }
        ViewCompat.sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view0);
    }

    @Deprecated
    public static void setActivated(View view0, boolean z) {
        view0.setActivated(z);
    }

    @Deprecated
    public static void setAlpha(View view0, float f) {
        view0.setAlpha(f);
    }

    public static void setAutofillHints(View view0, String[] arr_s) {
        if(Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setAutofillHints(view0, arr_s);
        }
    }

    public static void setBackground(View view0, Drawable drawable0) {
        Api16Impl.setBackground(view0, drawable0);
    }

    public static void setBackgroundTintList(View view0, ColorStateList colorStateList0) {
        Api21Impl.setBackgroundTintList(view0, colorStateList0);
    }

    public static void setBackgroundTintMode(View view0, PorterDuff.Mode porterDuff$Mode0) {
        Api21Impl.setBackgroundTintMode(view0, porterDuff$Mode0);
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup0, boolean z) {
        if(ViewCompat.sChildrenDrawingOrderMethod == null) {
            try {
                ViewCompat.sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", noSuchMethodException0);
            }
            ViewCompat.sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            ViewCompat.sChildrenDrawingOrderMethod.invoke(viewGroup0, Boolean.valueOf(z));
        }
        catch(IllegalAccessException illegalAccessException0) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", illegalAccessException0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", illegalArgumentException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", invocationTargetException0);
        }
    }

    public static void setClipBounds(View view0, Rect rect0) {
        Api18Impl.setClipBounds(view0, rect0);
    }

    public static void setElevation(View view0, float f) {
        Api21Impl.setElevation(view0, f);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view0, boolean z) {
        view0.setFitsSystemWindows(z);
    }

    public static void setFocusedByDefault(View view0, boolean z) {
        if(Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setFocusedByDefault(view0, z);
        }
    }

    public static void setHasTransientState(View view0, boolean z) {
        Api16Impl.setHasTransientState(view0, z);
    }

    public static void setImportantForAccessibility(View view0, int v) {
        Api16Impl.setImportantForAccessibility(view0, v);
    }

    public static void setImportantForAutofill(View view0, int v) {
        if(Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setImportantForAutofill(view0, v);
        }
    }

    public static void setKeyboardNavigationCluster(View view0, boolean z) {
        if(Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setKeyboardNavigationCluster(view0, z);
        }
    }

    public static void setLabelFor(View view0, int v) {
        Api17Impl.setLabelFor(view0, v);
    }

    public static void setLayerPaint(View view0, Paint paint0) {
        Api17Impl.setLayerPaint(view0, paint0);
    }

    @Deprecated
    public static void setLayerType(View view0, int v, Paint paint0) {
        view0.setLayerType(v, paint0);
    }

    public static void setLayoutDirection(View view0, int v) {
        Api17Impl.setLayoutDirection(view0, v);
    }

    public static void setNestedScrollingEnabled(View view0, boolean z) {
        Api21Impl.setNestedScrollingEnabled(view0, z);
    }

    public static void setNextClusterForwardId(View view0, int v) {
        if(Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setNextClusterForwardId(view0, v);
        }
    }

    public static void setOnApplyWindowInsetsListener(View view0, OnApplyWindowInsetsListener onApplyWindowInsetsListener0) {
        Api21Impl.setOnApplyWindowInsetsListener(view0, onApplyWindowInsetsListener0);
    }

    public static void setOnReceiveContentListener(View view0, String[] arr_s, OnReceiveContentListener onReceiveContentListener0) {
        if(Build.VERSION.SDK_INT >= 0x1F) {
            Api31Impl.setOnReceiveContentListener(view0, arr_s, onReceiveContentListener0);
            return;
        }
        if(arr_s == null || arr_s.length == 0) {
            arr_s = null;
        }
        int v = 0;
        if(onReceiveContentListener0 != null) {
            Preconditions.checkArgument(arr_s != null, "When the listener is set, MIME types must also be set");
        }
        if(arr_s != null) {
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                if(arr_s[v1].startsWith("*")) {
                    v = 1;
                    break;
                }
            }
            Preconditions.checkArgument(((boolean)(v ^ 1)), "A MIME type set here must not start with *: " + Arrays.toString(arr_s));
        }
        view0.setTag(id.tag_on_receive_content_mime_types, arr_s);
        view0.setTag(id.tag_on_receive_content_listener, onReceiveContentListener0);
    }

    @Deprecated
    public static void setOverScrollMode(View view0, int v) {
        view0.setOverScrollMode(v);
    }

    public static void setPaddingRelative(View view0, int v, int v1, int v2, int v3) {
        Api17Impl.setPaddingRelative(view0, v, v1, v2, v3);
    }

    @Deprecated
    public static void setPivotX(View view0, float f) {
        view0.setPivotX(f);
    }

    @Deprecated
    public static void setPivotY(View view0, float f) {
        view0.setPivotY(f);
    }

    public static void setPointerIcon(View view0, PointerIconCompat pointerIconCompat0) {
        if(Build.VERSION.SDK_INT >= 24) {
            Api24Impl.setPointerIcon(view0, ((PointerIcon)(pointerIconCompat0 == null ? null : pointerIconCompat0.getPointerIcon())));
        }
    }

    @Deprecated
    public static void setRotation(View view0, float f) {
        view0.setRotation(f);
    }

    @Deprecated
    public static void setRotationX(View view0, float f) {
        view0.setRotationX(f);
    }

    @Deprecated
    public static void setRotationY(View view0, float f) {
        view0.setRotationY(f);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view0, boolean z) {
        view0.setSaveFromParentEnabled(z);
    }

    @Deprecated
    public static void setScaleX(View view0, float f) {
        view0.setScaleX(f);
    }

    @Deprecated
    public static void setScaleY(View view0, float f) {
        view0.setScaleY(f);
    }

    public static void setScreenReaderFocusable(View view0, boolean z) {
        ViewCompat.screenReaderFocusableProperty().set(view0, Boolean.valueOf(z));
    }

    public static void setScrollIndicators(View view0, int v) {
        Api23Impl.setScrollIndicators(view0, v);
    }

    public static void setScrollIndicators(View view0, int v, int v1) {
        Api23Impl.setScrollIndicators(view0, v, v1);
    }

    public static void setStateDescription(View view0, CharSequence charSequence0) {
        ViewCompat.stateDescriptionProperty().set(view0, charSequence0);
    }

    public static void setSystemGestureExclusionRects(View view0, List list0) {
        if(Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setSystemGestureExclusionRects(view0, list0);
        }
    }

    public static void setTooltipText(View view0, CharSequence charSequence0) {
        if(Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setTooltipText(view0, charSequence0);
        }
    }

    public static void setTransitionName(View view0, String s) {
        Api21Impl.setTransitionName(view0, s);
    }

    @Deprecated
    public static void setTranslationX(View view0, float f) {
        view0.setTranslationX(f);
    }

    @Deprecated
    public static void setTranslationY(View view0, float f) {
        view0.setTranslationY(f);
    }

    public static void setTranslationZ(View view0, float f) {
        Api21Impl.setTranslationZ(view0, f);
    }

    private static void setViewImportanceForAccessibilityIfNeeded(View view0) {
        if(ViewCompat.getImportantForAccessibility(view0) == 0) {
            ViewCompat.setImportantForAccessibility(view0, 1);
        }
        for(ViewParent viewParent0 = view0.getParent(); viewParent0 instanceof View; viewParent0 = viewParent0.getParent()) {
            if(ViewCompat.getImportantForAccessibility(((View)viewParent0)) == 4) {
                ViewCompat.setImportantForAccessibility(view0, 2);
                return;
            }
        }
    }

    public static void setWindowInsetsAnimationCallback(View view0, Callback windowInsetsAnimationCompat$Callback0) {
        WindowInsetsAnimationCompat.setCallback(view0, windowInsetsAnimationCompat$Callback0);
    }

    @Deprecated
    public static void setX(View view0, float f) {
        view0.setX(f);
    }

    @Deprecated
    public static void setY(View view0, float f) {
        view0.setY(f);
    }

    public static void setZ(View view0, float f) {
        Api21Impl.setZ(view0, f);
    }

    public static boolean startDragAndDrop(View view0, ClipData clipData0, View.DragShadowBuilder view$DragShadowBuilder0, Object object0, int v) {
        return Build.VERSION.SDK_INT < 24 ? view0.startDrag(clipData0, view$DragShadowBuilder0, object0, v) : Api24Impl.startDragAndDrop(view0, clipData0, view$DragShadowBuilder0, object0, v);
    }

    public static boolean startNestedScroll(View view0, int v) {
        return Api21Impl.startNestedScroll(view0, v);
    }

    public static boolean startNestedScroll(View view0, int v, int v1) {
        if(view0 instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view0).startNestedScroll(v, v1);
        }
        return v1 == 0 ? ViewCompat.startNestedScroll(view0, v) : false;
    }

    private static AccessibilityViewProperty stateDescriptionProperty() {
        return new AccessibilityViewProperty(id.tag_state_description, CharSequence.class, 0x40, 30) {
            CharSequence frameworkGet(View view0) {
                return Api30Impl.getStateDescription(view0);
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            Object frameworkGet(View view0) {
                return this.frameworkGet(view0);
            }

            void frameworkSet(View view0, CharSequence charSequence0) {
                Api30Impl.setStateDescription(view0, charSequence0);
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            void frameworkSet(View view0, Object object0) {
                this.frameworkSet(view0, ((CharSequence)object0));
            }

            boolean shouldUpdate(CharSequence charSequence0, CharSequence charSequence1) {
                return !TextUtils.equals(charSequence0, charSequence1);
            }

            @Override  // androidx.core.view.ViewCompat$AccessibilityViewProperty
            boolean shouldUpdate(Object object0, Object object1) {
                return this.shouldUpdate(((CharSequence)object0), ((CharSequence)object1));
            }
        };
    }

    public static void stopNestedScroll(View view0) {
        Api21Impl.stopNestedScroll(view0);
    }

    public static void stopNestedScroll(View view0, int v) {
        if(view0 instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2)view0).stopNestedScroll(v);
            return;
        }
        if(v == 0) {
            ViewCompat.stopNestedScroll(view0);
        }
    }

    private static void tickleInvalidationFlag(View view0) {
        float f = view0.getTranslationY();
        view0.setTranslationY(f + 1.0f);
        view0.setTranslationY(f);
    }

    public static void updateDragShadow(View view0, View.DragShadowBuilder view$DragShadowBuilder0) {
        if(Build.VERSION.SDK_INT >= 24) {
            Api24Impl.updateDragShadow(view0, view$DragShadowBuilder0);
        }
    }
}

