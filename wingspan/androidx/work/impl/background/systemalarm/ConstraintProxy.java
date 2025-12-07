package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver {
    public static class BatteryChargingProxy extends ConstraintProxy {
        @Override  // androidx.work.impl.background.systemalarm.ConstraintProxy
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        @Override  // androidx.work.impl.background.systemalarm.ConstraintProxy
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        @Override  // androidx.work.impl.background.systemalarm.ConstraintProxy
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        @Override  // androidx.work.impl.background.systemalarm.ConstraintProxy
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
        }
    }

    private static final String TAG;

    static {
        ConstraintProxy.TAG = "WM-ConstraintProxy";
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Logger.get().debug("WM-ConstraintProxy", "onReceive : " + intent);
        context.startService(CommandHandler.createConstraintsChangedIntent(context));
    }

    static void updateAll(Context context, List workSpecs) {
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        boolean z3 = false;
        for(Object object0: workSpecs) {
            Constraints constraints0 = ((WorkSpec)object0).constraints;
            z |= constraints0.requiresBatteryNotLow();
            z1 |= constraints0.requiresCharging();
            z2 |= constraints0.requiresStorageNotLow();
            z3 |= constraints0.getRequiredNetworkType() != NetworkType.NOT_REQUIRED;
            if(z && z1 && z2 && z3) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(context, z, z1, z2, z3));
    }
}

