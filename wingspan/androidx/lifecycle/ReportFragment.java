package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build.VERSION;
import android.os.Bundle;

public class ReportFragment extends Fragment {
    interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    static class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity0, Bundle bundle0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity0, Bundle bundle0) {
            ReportFragment.dispatch(activity0, Event.ON_CREATE);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity0) {
            ReportFragment.dispatch(activity0, Event.ON_RESUME);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity0) {
            ReportFragment.dispatch(activity0, Event.ON_START);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity0) {
            ReportFragment.dispatch(activity0, Event.ON_DESTROY);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity0) {
            ReportFragment.dispatch(activity0, Event.ON_PAUSE);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity0) {
            ReportFragment.dispatch(activity0, Event.ON_STOP);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity0) {
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity0) {
        }

        static void registerIn(Activity activity0) {
            activity0.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        }
    }

    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener mProcessListener;

    static void dispatch(Activity activity0, Event lifecycle$Event0) {
        if(activity0 instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner)activity0).getLifecycle().handleLifecycleEvent(lifecycle$Event0);
            return;
        }
        if(activity0 instanceof LifecycleOwner) {
            Lifecycle lifecycle0 = ((LifecycleOwner)activity0).getLifecycle();
            if(lifecycle0 instanceof LifecycleRegistry) {
                ((LifecycleRegistry)lifecycle0).handleLifecycleEvent(lifecycle$Event0);
            }
        }
    }

    private void dispatch(Event lifecycle$Event0) {
        if(Build.VERSION.SDK_INT < 29) {
            ReportFragment.dispatch(this.getActivity(), lifecycle$Event0);
        }
    }

    private void dispatchCreate(ActivityInitializationListener reportFragment$ActivityInitializationListener0) {
        if(reportFragment$ActivityInitializationListener0 != null) {
            reportFragment$ActivityInitializationListener0.onCreate();
        }
    }

    private void dispatchResume(ActivityInitializationListener reportFragment$ActivityInitializationListener0) {
        if(reportFragment$ActivityInitializationListener0 != null) {
            reportFragment$ActivityInitializationListener0.onResume();
        }
    }

    private void dispatchStart(ActivityInitializationListener reportFragment$ActivityInitializationListener0) {
        if(reportFragment$ActivityInitializationListener0 != null) {
            reportFragment$ActivityInitializationListener0.onStart();
        }
    }

    static ReportFragment get(Activity activity0) {
        return (ReportFragment)activity0.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void injectIfNeededIn(Activity activity0) {
        if(Build.VERSION.SDK_INT >= 29) {
            LifecycleCallbacks.registerIn(activity0);
        }
        FragmentManager fragmentManager0 = activity0.getFragmentManager();
        if(fragmentManager0.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager0.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager0.executePendingTransactions();
        }
    }

    @Override  // android.app.Fragment
    public void onActivityCreated(Bundle bundle0) {
        super.onActivityCreated(bundle0);
        this.dispatchCreate(this.mProcessListener);
        this.dispatch(Event.ON_CREATE);
    }

    @Override  // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dispatch(Event.ON_DESTROY);
        this.mProcessListener = null;
    }

    @Override  // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.dispatch(Event.ON_PAUSE);
    }

    @Override  // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.dispatchResume(this.mProcessListener);
        this.dispatch(Event.ON_RESUME);
    }

    @Override  // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.dispatchStart(this.mProcessListener);
        this.dispatch(Event.ON_START);
    }

    @Override  // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.dispatch(Event.ON_STOP);
    }

    void setProcessListener(ActivityInitializationListener reportFragment$ActivityInitializationListener0) {
        this.mProcessListener = reportFragment$ActivityInitializationListener0;
    }
}

