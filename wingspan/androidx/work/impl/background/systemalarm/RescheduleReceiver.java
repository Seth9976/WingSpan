package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

public class RescheduleReceiver extends BroadcastReceiver {
    private static final String TAG;

    static {
        RescheduleReceiver.TAG = "WM-RescheduleReceiver";
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.get().debug("WM-RescheduleReceiver", "Received intent " + intent);
        try {
            WorkManagerImpl.getInstance(context).setReschedulePendingResult(this.goAsync());
        }
        catch(IllegalStateException illegalStateException0) {
            Logger.get().error("WM-RescheduleReceiver", "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", illegalStateException0);
        }
    }
}

