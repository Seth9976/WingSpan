package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;

public class PackageManagerHelper {
    private static final String TAG;

    static {
        PackageManagerHelper.TAG = "WM-PackageManagerHelper";
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class klazz) {
        return PackageManagerHelper.isComponentExplicitlyEnabled(context, klazz.getName());
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String className) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, className)) == 1;
    }

    public static void setComponentEnabled(Context context, Class klazz, boolean enabled) {
        String s = "enabled";
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, klazz.getName()), (enabled ? 1 : 2), 1);
            Logger.get().debug("WM-PackageManagerHelper", klazz.getName() + " " + (enabled ? "enabled" : "disabled"));
        }
        catch(Exception exception0) {
            Logger logger0 = Logger.get();
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(klazz.getName());
            stringBuilder0.append("could not be ");
            if(!enabled) {
                s = "disabled";
            }
            stringBuilder0.append(s);
            logger0.debug("WM-PackageManagerHelper", stringBuilder0.toString(), exception0);
        }
    }
}

