package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.runtime.R.id;

public class ViewTreeLifecycleOwner {
    public static LifecycleOwner get(View view0) {
        LifecycleOwner lifecycleOwner0 = (LifecycleOwner)view0.getTag(id.view_tree_lifecycle_owner);
        if(lifecycleOwner0 != null) {
            return lifecycleOwner0;
        }
        for(ViewParent viewParent0 = view0.getParent(); lifecycleOwner0 == null && viewParent0 instanceof View; viewParent0 = ((View)viewParent0).getParent()) {
            lifecycleOwner0 = (LifecycleOwner)((View)viewParent0).getTag(id.view_tree_lifecycle_owner);
        }
        return lifecycleOwner0;
    }

    public static void set(View view0, LifecycleOwner lifecycleOwner0) {
        view0.setTag(id.view_tree_lifecycle_owner, lifecycleOwner0);
    }
}

