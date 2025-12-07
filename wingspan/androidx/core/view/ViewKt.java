package androidx.core.view;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001A2\u0010\u0019\u001A\u00020\u001A*\u00020\u00032#\b\u0004\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00110\u0003\u00A2\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\b\u001A2\u0010 \u001A\u00020\u001A*\u00020\u00032#\b\u0004\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00110\u0003\u00A2\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\b\u001A2\u0010!\u001A\u00020\u001A*\u00020\u00032#\b\u0004\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00110\u0003\u00A2\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\b\u001A2\u0010\"\u001A\u00020\u001A*\u00020\u00032#\b\u0004\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00110\u0003\u00A2\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\b\u001A2\u0010#\u001A\u00020$*\u00020\u00032#\b\u0004\u0010\u001B\u001A\u001D\u0012\u0013\u0012\u00110\u0003\u00A2\u0006\f\b\u001D\u0012\b\b\u001E\u0012\u0004\b\b(\u001F\u0012\u0004\u0012\u00020\u001A0\u001CH\u0086\b\u001A\u0014\u0010%\u001A\u00020&*\u00020\u00032\b\b\u0002\u0010\'\u001A\u00020(\u001A%\u0010)\u001A\u00020**\u00020\u00032\u0006\u0010+\u001A\u00020,2\u000E\b\u0004\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0-H\u0086\b\u001A%\u0010.\u001A\u00020**\u00020\u00032\u0006\u0010+\u001A\u00020,2\u000E\b\u0004\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0-H\u0087\b\u001A\u0017\u0010/\u001A\u00020\u001A*\u00020\u00032\b\b\u0001\u00100\u001A\u00020\fH\u0086\b\u001A7\u00101\u001A\u00020\u001A\"\n\b\u0000\u00102\u0018\u0001*\u000203*\u00020\u00032\u0017\u00104\u001A\u0013\u0012\u0004\u0012\u0002H2\u0012\u0004\u0012\u00020\u001A0\u001C\u00A2\u0006\u0002\b5H\u0087\b\u00A2\u0006\u0002\b6\u001A&\u00101\u001A\u00020\u001A*\u00020\u00032\u0017\u00104\u001A\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001A0\u001C\u00A2\u0006\u0002\b5H\u0086\b\u001A5\u00107\u001A\u00020\u001A*\u00020\u00032\b\b\u0003\u00108\u001A\u00020\f2\b\b\u0003\u00109\u001A\u00020\f2\b\b\u0003\u0010:\u001A\u00020\f2\b\b\u0003\u0010;\u001A\u00020\fH\u0086\b\u001A5\u0010<\u001A\u00020\u001A*\u00020\u00032\b\b\u0003\u0010=\u001A\u00020\f2\b\b\u0003\u00109\u001A\u00020\f2\b\b\u0003\u0010>\u001A\u00020\f2\b\b\u0003\u0010;\u001A\u00020\fH\u0087\b\"*\u0010\u0002\u001A\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001A\u00020\u00018\u00C6\u0002@\u00C6\u0002X\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"*\u0010\u0007\u001A\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001A\u00020\u00018\u00C6\u0002@\u00C6\u0002X\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\u0006\"*\u0010\t\u001A\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001A\u00020\u00018\u00C6\u0002@\u00C6\u0002X\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006\"\u0016\u0010\u000B\u001A\u00020\f*\u00020\u00038\u00C6\u0002\u00A2\u0006\u0006\u001A\u0004\b\r\u0010\u000E\"\u0016\u0010\u000F\u001A\u00020\f*\u00020\u00038\u00C6\u0002\u00A2\u0006\u0006\u001A\u0004\b\u0010\u0010\u000E\"\u0016\u0010\u0011\u001A\u00020\f*\u00020\u00038\u00C6\u0002\u00A2\u0006\u0006\u001A\u0004\b\u0012\u0010\u000E\"\u0016\u0010\u0013\u001A\u00020\f*\u00020\u00038\u00C6\u0002\u00A2\u0006\u0006\u001A\u0004\b\u0014\u0010\u000E\"\u0016\u0010\u0015\u001A\u00020\f*\u00020\u00038\u00C6\u0002\u00A2\u0006\u0006\u001A\u0004\b\u0016\u0010\u000E\"\u0016\u0010\u0017\u001A\u00020\f*\u00020\u00038\u00C6\u0002\u00A2\u0006\u0006\u001A\u0004\b\u0018\u0010\u000E\u00A8\u0006?"}, d2 = {"value", "", "isGone", "Landroid/view/View;", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnAttach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnDetach", "doOnLayout", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", "T", "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class ViewKt {
    public static final void doOnAttach(View view0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$doOnAttach");
        Intrinsics.checkParameterIsNotNull(function10, "action");
        if(ViewCompat.isAttachedToWindow(view0)) {
            function10.invoke(view0);
            return;
        }
        view0.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view0) {
                Intrinsics.checkParameterIsNotNull(view0, "view");
                view0.removeOnAttachStateChangeListener(this);
                function10.invoke(view0);
            }

            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view0) {
                Intrinsics.checkParameterIsNotNull(view0, "view");
            }
        });
    }

    public static final void doOnDetach(View view0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$doOnDetach");
        Intrinsics.checkParameterIsNotNull(function10, "action");
        if(!ViewCompat.isAttachedToWindow(view0)) {
            function10.invoke(view0);
            return;
        }
        view0.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view0) {
                Intrinsics.checkParameterIsNotNull(view0, "view");
            }

            @Override  // android.view.View$OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view0) {
                Intrinsics.checkParameterIsNotNull(view0, "view");
                view0.removeOnAttachStateChangeListener(this);
                function10.invoke(view0);
            }
        });
    }

    public static final void doOnLayout(View view0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$doOnLayout");
        Intrinsics.checkParameterIsNotNull(function10, "action");
        if(ViewCompat.isLaidOut(view0) && !view0.isLayoutRequested()) {
            function10.invoke(view0);
            return;
        }
        view0.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override  // android.view.View$OnLayoutChangeListener
            public void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
                Intrinsics.checkParameterIsNotNull(view0, "view");
                view0.removeOnLayoutChangeListener(this);
                function10.invoke(view0);
            }
        });
    }

    public static final void doOnNextLayout(View view0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$doOnNextLayout");
        Intrinsics.checkParameterIsNotNull(function10, "action");
        view0.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override  // android.view.View$OnLayoutChangeListener
            public void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
                Intrinsics.checkParameterIsNotNull(view0, "view");
                view0.removeOnLayoutChangeListener(this);
                function10.invoke(view0);
            }
        });
    }

    public static final OneShotPreDrawListener doOnPreDraw(View view0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$doOnPreDraw");
        Intrinsics.checkParameterIsNotNull(function10, "action");
        OneShotPreDrawListener oneShotPreDrawListener0 = OneShotPreDrawListener.add(view0, new Runnable() {
            @Override
            public final void run() {
                function10.invoke(view0);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(oneShotPreDrawListener0, "OneShotPreDrawListener.add(this) { action(this) }");
        return oneShotPreDrawListener0;
    }

    public static final Bitmap drawToBitmap(View view0, Bitmap.Config bitmap$Config0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$drawToBitmap");
        Intrinsics.checkParameterIsNotNull(bitmap$Config0, "config");
        if(!ViewCompat.isLaidOut(view0)) {
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        Bitmap bitmap0 = Bitmap.createBitmap(view0.getWidth(), view0.getHeight(), bitmap$Config0);
        Intrinsics.checkExpressionValueIsNotNull(bitmap0, "Bitmap.createBitmap(width, height, config)");
        Canvas canvas0 = new Canvas(bitmap0);
        canvas0.translate(-((float)view0.getScrollX()), -((float)view0.getScrollY()));
        view0.draw(canvas0);
        return bitmap0;
    }

    public static Bitmap drawToBitmap$default(View view0, Bitmap.Config bitmap$Config0, int v, Object object0) {
        if((v & 1) != 0) {
            bitmap$Config0 = Bitmap.Config.ARGB_8888;
        }
        return ViewKt.drawToBitmap(view0, bitmap$Config0);
    }

    public static final int getMarginBottom(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$marginBottom");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(!(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams)) {
            viewGroup$LayoutParams0 = null;
        }
        return ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) == null ? 0 : ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin;
    }

    public static final int getMarginEnd(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$marginEnd");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        return viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0)) : 0;
    }

    public static final int getMarginLeft(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$marginLeft");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(!(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams)) {
            viewGroup$LayoutParams0 = null;
        }
        return ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) == null ? 0 : ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin;
    }

    public static final int getMarginRight(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$marginRight");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(!(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams)) {
            viewGroup$LayoutParams0 = null;
        }
        return ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) == null ? 0 : ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin;
    }

    public static final int getMarginStart(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$marginStart");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        return viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0)) : 0;
    }

    public static final int getMarginTop(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$marginTop");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(!(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams)) {
            viewGroup$LayoutParams0 = null;
        }
        return ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) == null ? 0 : ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin;
    }

    public static final boolean isGone(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$isGone");
        return view0.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$isInvisible");
        return view0.getVisibility() == 4;
    }

    public static final boolean isVisible(View view0) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$isVisible");
        return view0.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view0, long v, Function0 function00) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$postDelayed");
        Intrinsics.checkParameterIsNotNull(function00, "action");
        Runnable runnable0 = new Runnable() {
            @Override
            public final void run() {
                function00.invoke();
            }
        };
        view0.postDelayed(runnable0, v);
        return runnable0;
    }

    public static final Runnable postOnAnimationDelayed(View view0, long v, Function0 function00) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$postOnAnimationDelayed");
        Intrinsics.checkParameterIsNotNull(function00, "action");
        Runnable runnable0 = new Runnable() {
            @Override
            public final void run() {
                function00.invoke();
            }
        };
        view0.postOnAnimationDelayed(runnable0, v);
        return runnable0;
    }

    public static final void setGone(View view0, boolean z) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$isGone");
        view0.setVisibility((z ? 8 : 0));
    }

    public static final void setInvisible(View view0, boolean z) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$isInvisible");
        view0.setVisibility((z ? 4 : 0));
    }

    public static final void setPadding(View view0, int v) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$setPadding");
        view0.setPadding(v, v, v, v);
    }

    public static final void setVisible(View view0, boolean z) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$isVisible");
        view0.setVisibility((z ? 0 : 8));
    }

    public static final void updateLayoutParams(View view0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$updateLayoutParams");
        Intrinsics.checkParameterIsNotNull(function10, "block");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        function10.invoke(viewGroup$LayoutParams0);
        view0.setLayoutParams(viewGroup$LayoutParams0);
    }

    public static final void updateLayoutParamsTyped(View view0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$updateLayoutParams");
        Intrinsics.checkParameterIsNotNull(function10, "block");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, "T");
        function10.invoke(viewGroup$LayoutParams0);
        view0.setLayoutParams(viewGroup$LayoutParams0);
    }

    public static final void updatePadding(View view0, int v, int v1, int v2, int v3) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$updatePadding");
        view0.setPadding(v, v1, v2, v3);
    }

    public static void updatePadding$default(View view0, int v, int v1, int v2, int v3, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = view0.getPaddingLeft();
        }
        if((v4 & 2) != 0) {
            v1 = view0.getPaddingTop();
        }
        if((v4 & 4) != 0) {
            v2 = view0.getPaddingRight();
        }
        if((v4 & 8) != 0) {
            v3 = view0.getPaddingBottom();
        }
        Intrinsics.checkParameterIsNotNull(view0, "$this$updatePadding");
        view0.setPadding(v, v1, v2, v3);
    }

    public static final void updatePaddingRelative(View view0, int v, int v1, int v2, int v3) {
        Intrinsics.checkParameterIsNotNull(view0, "$this$updatePaddingRelative");
        view0.setPaddingRelative(v, v1, v2, v3);
    }

    public static void updatePaddingRelative$default(View view0, int v, int v1, int v2, int v3, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = view0.getPaddingStart();
        }
        if((v4 & 2) != 0) {
            v1 = view0.getPaddingTop();
        }
        if((v4 & 4) != 0) {
            v2 = view0.getPaddingEnd();
        }
        if((v4 & 8) != 0) {
            v3 = view0.getPaddingBottom();
        }
        Intrinsics.checkParameterIsNotNull(view0, "$this$updatePaddingRelative");
        view0.setPaddingRelative(v, v1, v2, v3);
    }
}

