package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

public abstract class ActivityResultLauncher {
    public abstract ActivityResultContract getContract();

    public void launch(Object object0) {
        this.launch(object0, null);
    }

    public abstract void launch(Object arg1, ActivityOptionsCompat arg2);

    public abstract void unregister();
}

