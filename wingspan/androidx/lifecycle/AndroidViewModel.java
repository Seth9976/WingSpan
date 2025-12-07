package androidx.lifecycle;

import android.app.Application;

public class AndroidViewModel extends ViewModel {
    private Application mApplication;

    public AndroidViewModel(Application application0) {
        this.mApplication = application0;
    }

    public Application getApplication() {
        return this.mApplication;
    }
}

