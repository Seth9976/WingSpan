package androidx.core.view;

import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController.OnControllableInsetsChangedListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.SimpleArrayMap;

public final class WindowInsetsControllerCompat {
    static class Impl20 extends Impl {
        private final View mView;
        protected final Window mWindow;

        Impl20(Window window0, View view0) {
            this.mWindow = window0;
            this.mView = view0;
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0) {
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void controlWindowInsetsAnimation(int v, long v1, Interpolator interpolator0, CancellationSignal cancellationSignal0, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat0) {
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void hide(int v) {
            for(int v1 = 1; v1 <= 0x100; v1 <<= 1) {
                if((v & v1) != 0) {
                    this.hideForType(v1);
                }
            }
        }

        private void hideForType(int v) {
            switch(v) {
                case 1: {
                    this.setSystemUiFlag(4);
                    return;
                }
                case 2: {
                    this.setSystemUiFlag(2);
                    return;
                }
                case 8: {
                    ((InputMethodManager)this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
                }
            }
        }

        // 检测为 Lambda 实现
        static void lambda$showForType$0(View view0) [...]

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0) {
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void setSystemBarsBehavior(int v) {
            switch(v) {
                case 0: {
                    this.unsetSystemUiFlag(0x1800);
                    return;
                }
                case 1: {
                    this.unsetSystemUiFlag(0x1000);
                    this.setSystemUiFlag(0x800);
                    return;
                }
                case 2: {
                    this.unsetSystemUiFlag(0x800);
                    this.setSystemUiFlag(0x1000);
                }
            }
        }

        protected void setSystemUiFlag(int v) {
            View view0 = this.mWindow.getDecorView();
            view0.setSystemUiVisibility(v | view0.getSystemUiVisibility());
        }

        protected void setWindowFlag(int v) {
            this.mWindow.addFlags(v);
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void show(int v) {
            for(int v1 = 1; v1 <= 0x100; v1 <<= 1) {
                if((v & v1) != 0) {
                    this.showForType(v1);
                }
            }
        }

        private void showForType(int v) {
            switch(v) {
                case 1: {
                    this.unsetSystemUiFlag(4);
                    this.unsetWindowFlag(0x400);
                    return;
                }
                case 2: {
                    this.unsetSystemUiFlag(2);
                    return;
                }
                case 8: {
                    View view0 = this.mView;
                    if(view0.isInEditMode() || view0.onCheckIsTextEditor()) {
                        view0.requestFocus();
                    }
                    else {
                        view0 = this.mWindow.getCurrentFocus();
                    }
                    if(view0 == null) {
                        view0 = this.mWindow.findViewById(0x1020002);
                    }
                    if(view0 != null && view0.hasWindowFocus()) {
                        view0.post(() -> ((InputMethodManager)view0.getContext().getSystemService("input_method")).showSoftInput(view0, 0));
                    }
                }
            }
        }

        protected void unsetSystemUiFlag(int v) {
            View view0 = this.mWindow.getDecorView();
            view0.setSystemUiVisibility(~v & view0.getSystemUiVisibility());
        }

        protected void unsetWindowFlag(int v) {
            this.mWindow.clearFlags(v);
        }
    }

    static class Impl23 extends Impl20 {
        Impl23(Window window0, View view0) {
            super(window0, view0);
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 0x2000) != 0;
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        public void setAppearanceLightStatusBars(boolean z) {
            if(z) {
                this.unsetWindowFlag(0x4000000);
                this.setWindowFlag(0x80000000);
                this.setSystemUiFlag(0x2000);
                return;
            }
            this.unsetSystemUiFlag(0x2000);
        }
    }

    static class Impl26 extends Impl23 {
        Impl26(Window window0, View view0) {
            super(window0, view0);
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        public void setAppearanceLightNavigationBars(boolean z) {
            if(z) {
                this.unsetWindowFlag(0x8000000);
                this.setWindowFlag(0x80000000);
                this.setSystemUiFlag(16);
                return;
            }
            this.unsetSystemUiFlag(16);
        }
    }

    static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap mListeners;
        protected Window mWindow;

        Impl30(Window window0, WindowInsetsControllerCompat windowInsetsControllerCompat0) {
            this(window0.getInsetsController(), windowInsetsControllerCompat0);
            this.mWindow = window0;
        }

        Impl30(WindowInsetsController windowInsetsController0, WindowInsetsControllerCompat windowInsetsControllerCompat0) {
            this.mListeners = new SimpleArrayMap();
            this.mInsetsController = windowInsetsController0;
            this.mCompatController = windowInsetsControllerCompat0;
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0) {
            if(this.mListeners.containsKey(windowInsetsControllerCompat$OnControllableInsetsChangedListener0)) {
                return;
            }
            WindowInsetsControllerCompat.Impl30..ExternalSyntheticLambda0 windowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda00 = (WindowInsetsController windowInsetsController0, int v) -> if(this.mInsetsController == windowInsetsController0) {
                windowInsetsControllerCompat$OnControllableInsetsChangedListener0.onControllableInsetsChanged(this.mCompatController, v);
            };
            this.mListeners.put(windowInsetsControllerCompat$OnControllableInsetsChangedListener0, windowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda00);
            this.mInsetsController.addOnControllableInsetsChangedListener(windowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda00);
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void controlWindowInsetsAnimation(int v, long v1, Interpolator interpolator0, CancellationSignal cancellationSignal0, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat0) {
            androidx.core.view.WindowInsetsControllerCompat.Impl30.1 windowInsetsControllerCompat$Impl30$10 = new WindowInsetsAnimationControlListener() {
                private WindowInsetsAnimationControllerCompat mCompatAnimController;

                {
                    WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat0 = windowInsetsAnimationControlListenerCompat0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.mCompatAnimController = null;
                }

                @Override  // android.view.WindowInsetsAnimationControlListener
                public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController0) {
                    windowInsetsAnimationControlListenerCompat0.onCancelled((windowInsetsAnimationController0 == null ? null : this.mCompatAnimController));
                }

                @Override  // android.view.WindowInsetsAnimationControlListener
                public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController0) {
                    windowInsetsAnimationControlListenerCompat0.onFinished(this.mCompatAnimController);
                }

                @Override  // android.view.WindowInsetsAnimationControlListener
                public void onReady(WindowInsetsAnimationController windowInsetsAnimationController0, int v) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat0 = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController0);
                    this.mCompatAnimController = windowInsetsAnimationControllerCompat0;
                    windowInsetsAnimationControlListenerCompat0.onReady(windowInsetsAnimationControllerCompat0, v);
                }
            };
            this.mInsetsController.controlWindowInsetsAnimation(v, v1, interpolator0, cancellationSignal0, windowInsetsControllerCompat$Impl30$10);
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void hide(int v) {
            this.mInsetsController.hide(v);
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mInsetsController.getSystemBarsAppearance() & 16) != 0;
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mInsetsController.getSystemBarsAppearance() & 8) != 0;
        }

        // 检测为 Lambda 实现
        void lambda$addOnControllableInsetsChangedListener$0$androidx-core-view-WindowInsetsControllerCompat$Impl30(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0, WindowInsetsController windowInsetsController0, int v) [...]

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0) {
            WindowInsetsController.OnControllableInsetsChangedListener windowInsetsController$OnControllableInsetsChangedListener0 = (WindowInsetsController.OnControllableInsetsChangedListener)this.mListeners.remove(windowInsetsControllerCompat$OnControllableInsetsChangedListener0);
            if(windowInsetsController$OnControllableInsetsChangedListener0 != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener(windowInsetsController$OnControllableInsetsChangedListener0);
            }
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        public void setAppearanceLightNavigationBars(boolean z) {
            if(z) {
                if(this.mWindow != null) {
                    this.setSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(16, 16);
                return;
            }
            if(this.mWindow != null) {
                this.unsetSystemUiFlag(16);
            }
            this.mInsetsController.setSystemBarsAppearance(0, 16);
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        public void setAppearanceLightStatusBars(boolean z) {
            if(z) {
                if(this.mWindow != null) {
                    this.setSystemUiFlag(0x2000);
                }
                this.mInsetsController.setSystemBarsAppearance(8, 8);
                return;
            }
            if(this.mWindow != null) {
                this.unsetSystemUiFlag(0x2000);
            }
            this.mInsetsController.setSystemBarsAppearance(0, 8);
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void setSystemBarsBehavior(int v) {
            this.mInsetsController.setSystemBarsBehavior(v);
        }

        protected void setSystemUiFlag(int v) {
            View view0 = this.mWindow.getDecorView();
            view0.setSystemUiVisibility(v | view0.getSystemUiVisibility());
        }

        @Override  // androidx.core.view.WindowInsetsControllerCompat$Impl
        void show(int v) {
            if(this.mWindow != null && (v & 8) != 0 && Build.VERSION.SDK_INT < 0x20) {
                ((InputMethodManager)this.mWindow.getContext().getSystemService("input_method")).isActive();
            }
            this.mInsetsController.show(v);
        }

        protected void unsetSystemUiFlag(int v) {
            View view0 = this.mWindow.getDecorView();
            view0.setSystemUiVisibility(~v & view0.getSystemUiVisibility());
        }
    }

    static class Impl {
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0) {
        }

        void controlWindowInsetsAnimation(int v, long v1, Interpolator interpolator0, CancellationSignal cancellationSignal0, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat0) {
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        void hide(int v) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0) {
        }

        public void setAppearanceLightNavigationBars(boolean z) {
        }

        public void setAppearanceLightStatusBars(boolean z) {
        }

        void setSystemBarsBehavior(int v) {
        }

        void show(int v) {
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsControllerCompat arg1, int arg2);
    }

    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    public WindowInsetsControllerCompat(Window window0, View view0) {
        if(Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(window0, this);
            return;
        }
        if(Build.VERSION.SDK_INT >= 26) {
            this.mImpl = new Impl26(window0, view0);
            return;
        }
        this.mImpl = new Impl23(window0, view0);
    }

    @Deprecated
    private WindowInsetsControllerCompat(WindowInsetsController windowInsetsController0) {
        this.mImpl = new Impl30(windowInsetsController0, this);
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0) {
        this.mImpl.addOnControllableInsetsChangedListener(windowInsetsControllerCompat$OnControllableInsetsChangedListener0);
    }

    public void controlWindowInsetsAnimation(int v, long v1, Interpolator interpolator0, CancellationSignal cancellationSignal0, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat0) {
        this.mImpl.controlWindowInsetsAnimation(v, v1, interpolator0, cancellationSignal0, windowInsetsAnimationControlListenerCompat0);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int v) {
        this.mImpl.hide(v);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener windowInsetsControllerCompat$OnControllableInsetsChangedListener0) {
        this.mImpl.removeOnControllableInsetsChangedListener(windowInsetsControllerCompat$OnControllableInsetsChangedListener0);
    }

    public void setAppearanceLightNavigationBars(boolean z) {
        this.mImpl.setAppearanceLightNavigationBars(z);
    }

    public void setAppearanceLightStatusBars(boolean z) {
        this.mImpl.setAppearanceLightStatusBars(z);
    }

    public void setSystemBarsBehavior(int v) {
        this.mImpl.setSystemBarsBehavior(v);
    }

    public void show(int v) {
        this.mImpl.show(v);
    }

    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController windowInsetsController0) {
        return new WindowInsetsControllerCompat(windowInsetsController0);
    }
}

