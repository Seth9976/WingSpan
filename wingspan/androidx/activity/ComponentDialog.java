package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u001A\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0016\u001A\u00020\u0017J\u0006\u0010\u0018\u001A\u00020\u000FJ\b\u0010\u0019\u001A\u00020\u0011H\u0002J\b\u0010\u001A\u001A\u00020\u0011H\u0017J\u0012\u0010\u001B\u001A\u00020\u00112\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0015J\b\u0010\u001E\u001A\u00020\u0011H\u0015J\b\u0010\u001F\u001A\u00020\u0011H\u0015J\u0010\u0010 \u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u001A\u0010 \u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010 \u001A\u00020\u00112\u0006\u0010!\u001A\u00020\u0007H\u0016R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/activity/ComponentDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "addContentView", "", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getOnBackPressedDispatcher", "initViewTreeOwners", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "setContentView", "layoutResID", "activity_release"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public class ComponentDialog extends Dialog implements OnBackPressedDispatcherOwner, LifecycleOwner {
    private LifecycleRegistry _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    public ComponentDialog(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        this(context0, 0, 2, null);
    }

    public ComponentDialog(Context context0, int v) {
        Intrinsics.checkNotNullParameter(context0, "context");
        super(context0, v);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(() -> {
            Intrinsics.checkNotNullParameter(this, "this$0");
            this.super.onBackPressed();
        });
    }

    public ComponentDialog(Context context0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            v = 0;
        }
        this(context0, v);
    }

    @Override  // android.app.Dialog
    public void addContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        Intrinsics.checkNotNullParameter(view0, "view");
        this.initViewTreeOwners();
        super.addContentView(view0, viewGroup$LayoutParams0);
    }

    @Override  // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.getLifecycleRegistry();
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry lifecycleRegistry0 = this._lifecycleRegistry;
        if(lifecycleRegistry0 == null) {
            lifecycleRegistry0 = new LifecycleRegistry(this);
            this._lifecycleRegistry = lifecycleRegistry0;
        }
        return lifecycleRegistry0;
    }

    @Override  // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    private final void initViewTreeOwners() {
        Window window0 = this.getWindow();
        Intrinsics.checkNotNull(window0);
        ViewTreeLifecycleOwner.set(window0.getDecorView(), this);
        Window window1 = this.getWindow();
        Intrinsics.checkNotNull(window1);
        View view0 = window1.getDecorView();
        Intrinsics.checkNotNullExpressionValue(view0, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.set(view0, this);
    }

    @Override  // android.app.Dialog
    public void onBackPressed() {
        this.onBackPressedDispatcher.onBackPressed();
    }

    // 检测为 Lambda 实现
    private static final void onBackPressedDispatcher$lambda-1(ComponentDialog componentDialog0) [...]

    @Override  // android.app.Dialog
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.getLifecycleRegistry().handleLifecycleEvent(Event.ON_CREATE);
    }

    @Override  // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.getLifecycleRegistry().handleLifecycleEvent(Event.ON_RESUME);
    }

    @Override  // android.app.Dialog
    protected void onStop() {
        this.getLifecycleRegistry().handleLifecycleEvent(Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    @Override  // android.app.Dialog
    public void setContentView(int v) {
        this.initViewTreeOwners();
        super.setContentView(v);
    }

    @Override  // android.app.Dialog
    public void setContentView(View view0) {
        Intrinsics.checkNotNullParameter(view0, "view");
        this.initViewTreeOwners();
        super.setContentView(view0);
    }

    @Override  // android.app.Dialog
    public void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        Intrinsics.checkNotNullParameter(view0, "view");
        this.initViewTreeOwners();
        super.setContentView(view0, viewGroup$LayoutParams0);
    }
}

