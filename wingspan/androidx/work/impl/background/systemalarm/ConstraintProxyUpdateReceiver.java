package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver.PendingResult;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.PackageManagerHelper;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    static final String ACTION = "androidx.work.impl.background.systemalarm.UpdateProxies";
    static final String KEY_BATTERY_CHARGING_PROXY_ENABLED = "KEY_BATTERY_CHARGING_PROXY_ENABLED";
    static final String KEY_BATTERY_NOT_LOW_PROXY_ENABLED = "KEY_BATTERY_NOT_LOW_PROXY_ENABLED";
    static final String KEY_NETWORK_STATE_PROXY_ENABLED = "KEY_NETWORK_STATE_PROXY_ENABLED";
    static final String KEY_STORAGE_NOT_LOW_PROXY_ENABLED = "KEY_STORAGE_NOT_LOW_PROXY_ENABLED";
    static final String TAG;

    static {
        ConstraintProxyUpdateReceiver.TAG = "WM-ConstrntProxyUpdtRec";
    }

    public static Intent newConstraintProxyUpdateIntent(Context context, boolean batteryNotLowProxyEnabled, boolean batteryChargingProxyEnabled, boolean storageNotLowProxyEnabled, boolean networkStateProxyEnabled) {
        Intent intent0 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent0.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent0.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", batteryNotLowProxyEnabled).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", batteryChargingProxyEnabled).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", storageNotLowProxyEnabled).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", networkStateProxyEnabled);
        return intent0;
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String s = intent == null ? null : intent.getAction();
        if(!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(s)) {
            Logger.get().debug("WM-ConstrntProxyUpdtRec", "Ignoring unknown action " + s);
            return;
        }
        BroadcastReceiver.PendingResult broadcastReceiver$PendingResult0 = this.goAsync();
        WorkManagerImpl.getInstance(context).getWorkTaskExecutor().executeOnTaskThread(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean z = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean z1 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean z2 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean z3 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    Logger.get().debug("WM-ConstrntProxyUpdtRec", "Updating proxies: (BatteryNotLowProxy (" + z + "), BatteryChargingProxy (" + z1 + "), StorageNotLowProxy (" + z2 + "), NetworkStateProxy (" + z3 + "), ");
                    PackageManagerHelper.setComponentEnabled(context, BatteryNotLowProxy.class, z);
                    PackageManagerHelper.setComponentEnabled(context, BatteryChargingProxy.class, z1);
                    PackageManagerHelper.setComponentEnabled(context, StorageNotLowProxy.class, z2);
                    PackageManagerHelper.setComponentEnabled(context, NetworkStateProxy.class, z3);
                }
                finally {
                    broadcastReceiver$PendingResult0.finish();
                }
            }
        });
    }
}

