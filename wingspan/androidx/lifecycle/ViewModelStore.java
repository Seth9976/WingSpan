package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ViewModelStore {
    private final HashMap mMap;

    public ViewModelStore() {
        this.mMap = new HashMap();
    }

    public final void clear() {
        for(Object object0: this.mMap.values()) {
            ((ViewModel)object0).clear();
        }
        this.mMap.clear();
    }

    final ViewModel get(String s) {
        return (ViewModel)this.mMap.get(s);
    }

    Set keys() {
        return new HashSet(this.mMap.keySet());
    }

    final void put(String s, ViewModel viewModel0) {
        ViewModel viewModel1 = (ViewModel)this.mMap.put(s, viewModel0);
        if(viewModel1 != null) {
            viewModel1.onCleared();
        }
    }
}

