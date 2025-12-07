package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.viewmodel.R.id;

public class ViewTreeViewModelStoreOwner {
    public static ViewModelStoreOwner get(View view0) {
        ViewModelStoreOwner viewModelStoreOwner0 = (ViewModelStoreOwner)view0.getTag(id.view_tree_view_model_store_owner);
        if(viewModelStoreOwner0 != null) {
            return viewModelStoreOwner0;
        }
        for(ViewParent viewParent0 = view0.getParent(); viewModelStoreOwner0 == null && viewParent0 instanceof View; viewParent0 = ((View)viewParent0).getParent()) {
            viewModelStoreOwner0 = (ViewModelStoreOwner)((View)viewParent0).getTag(id.view_tree_view_model_store_owner);
        }
        return viewModelStoreOwner0;
    }

    public static void set(View view0, ViewModelStoreOwner viewModelStoreOwner0) {
        view0.setTag(id.view_tree_view_model_store_owner, viewModelStoreOwner0);
    }
}

