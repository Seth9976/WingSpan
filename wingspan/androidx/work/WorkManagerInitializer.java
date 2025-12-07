package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

public final class WorkManagerInitializer implements Initializer {
    private static final String TAG;

    static {
        WorkManagerInitializer.TAG = "WM-WrkMgrInitializer";
    }

    public WorkManager create(Context context) {
        Logger.get().debug("WM-WrkMgrInitializer", "Initializing WorkManager with default configuration.");
        WorkManager.initialize(context, new Builder().build());
        return WorkManager.getInstance(context);
    }

    @Override  // androidx.startup.Initializer
    public Object create(Context context) {
        return this.create(context);
    }

    @Override  // androidx.startup.Initializer
    public List dependencies() {
        return Collections.emptyList();
    }
}

