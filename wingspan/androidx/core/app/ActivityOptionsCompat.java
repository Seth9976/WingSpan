package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class ActivityOptionsCompat {
    static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        ActivityOptionsCompatImpl(ActivityOptions activityOptions0) {
            this.mActivityOptions = activityOptions0;
        }

        @Override  // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            return Build.VERSION.SDK_INT >= 24 ? Api24Impl.getLaunchBounds(this.mActivityOptions) : null;
        }

        @Override  // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent pendingIntent0) {
            Api23Impl.requestUsageTimeReport(this.mActivityOptions, pendingIntent0);
        }

        @Override  // androidx.core.app.ActivityOptionsCompat
        public ActivityOptionsCompat setLaunchBounds(Rect rect0) {
            return Build.VERSION.SDK_INT >= 24 ? new ActivityOptionsCompatImpl(Api24Impl.setLaunchBounds(this.mActivityOptions, rect0)) : this;
        }

        @Override  // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override  // androidx.core.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat0) {
            if(activityOptionsCompat0 instanceof ActivityOptionsCompatImpl) {
                this.mActivityOptions.update(((ActivityOptionsCompatImpl)activityOptionsCompat0).mActivityOptions);
            }
        }
    }

    static class Api16Impl {
        static ActivityOptions makeCustomAnimation(Context context0, int v, int v1) {
            return ActivityOptions.makeCustomAnimation(context0, v, v1);
        }

        static ActivityOptions makeScaleUpAnimation(View view0, int v, int v1, int v2, int v3) {
            return ActivityOptions.makeScaleUpAnimation(view0, v, v1, v2, v3);
        }

        static ActivityOptions makeThumbnailScaleUpAnimation(View view0, Bitmap bitmap0, int v, int v1) {
            return ActivityOptions.makeThumbnailScaleUpAnimation(view0, bitmap0, v, v1);
        }
    }

    static class Api21Impl {
        static ActivityOptions makeSceneTransitionAnimation(Activity activity0, View view0, String s) {
            return ActivityOptions.makeSceneTransitionAnimation(activity0, view0, s);
        }

        @SafeVarargs
        static ActivityOptions makeSceneTransitionAnimation(Activity activity0, Pair[] arr_pair) {
            return ActivityOptions.makeSceneTransitionAnimation(activity0, arr_pair);
        }

        static ActivityOptions makeTaskLaunchBehind() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    static class Api23Impl {
        static ActivityOptions makeBasic() {
            return ActivityOptions.makeBasic();
        }

        static ActivityOptions makeClipRevealAnimation(View view0, int v, int v1, int v2, int v3) {
            return ActivityOptions.makeClipRevealAnimation(view0, v, v1, v2, v3);
        }

        static void requestUsageTimeReport(ActivityOptions activityOptions0, PendingIntent pendingIntent0) {
            activityOptions0.requestUsageTimeReport(pendingIntent0);
        }
    }

    static class Api24Impl {
        static Rect getLaunchBounds(ActivityOptions activityOptions0) {
            return activityOptions0.getLaunchBounds();
        }

        static ActivityOptions setLaunchBounds(ActivityOptions activityOptions0, Rect rect0) {
            return activityOptions0.setLaunchBounds(rect0);
        }
    }

    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    public Rect getLaunchBounds() {
        return null;
    }

    public static ActivityOptionsCompat makeBasic() {
        return new ActivityOptionsCompatImpl(Api23Impl.makeBasic());
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View view0, int v, int v1, int v2, int v3) {
        return new ActivityOptionsCompatImpl(Api23Impl.makeClipRevealAnimation(view0, v, v1, v2, v3));
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context context0, int v, int v1) {
        return new ActivityOptionsCompatImpl(Api16Impl.makeCustomAnimation(context0, v, v1));
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View view0, int v, int v1, int v2, int v3) {
        return new ActivityOptionsCompatImpl(Api16Impl.makeScaleUpAnimation(view0, v, v1, v2, v3));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity0, View view0, String s) {
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(activity0, view0, s));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity0, androidx.core.util.Pair[] arr_pair) {
        if(arr_pair != null) {
            Pair[] arr_pair1 = new Pair[arr_pair.length];
            for(int v = 0; v < arr_pair.length; ++v) {
                arr_pair1[v] = Pair.create(((View)arr_pair[v].first), ((String)arr_pair[v].second));
            }
            return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(activity0, arr_pair1));
        }
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(activity0, null));
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new ActivityOptionsCompatImpl(Api21Impl.makeTaskLaunchBehind());
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view0, Bitmap bitmap0, int v, int v1) {
        return new ActivityOptionsCompatImpl(Api16Impl.makeThumbnailScaleUpAnimation(view0, bitmap0, v, v1));
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent0) {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect0) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat0) {
    }
}

