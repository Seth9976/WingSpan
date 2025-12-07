package com.voxelbusters.essentialkit.utilities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.voxelbusters.essentialkit.utilities.helpers.PermissionRequestFragment;
import com.voxelbusters.essentialkit.utilities.helpers.interfaces.IPermissionRequestCallback;
import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {
    private static String SHARED_PREFERENCES_PERMISSION_HISTORY_KEY = "VB_SHARED_PREFERENCES_PERMISSION_HISTORY";

    // 去混淆评级： 低(20)
    private static boolean getPermissionHistoryStatus(Context context0, String s) {
        return context0.getSharedPreferences("VB_SHARED_PREFERENCES_PERMISSION_HISTORY", 0).getBoolean(s, false);
    }

    public static PermissionStatus getPermissionStatus(Context context0, String s) {
        if(s == null) {
            return PermissionStatus.Authorized;
        }
        if(ContextCompat.checkSelfPermission(context0, s) == 0) {
            return PermissionStatus.Authorized;
        }
        if(!PermissionUtil.getPermissionHistoryStatus(context0, s)) {
            return PermissionStatus.NotDetermined;
        }
        return ActivityCompat.shouldShowRequestPermissionRationale(((Activity)context0), s) ? PermissionStatus.NotDetermined : PermissionStatus.Denied;
    }

    // 检测为 Lambda 实现
    static void lambda$requestPermissions$0(ArrayList arrayList0, String s, PermissionRequestFragment permissionRequestFragment0, Activity activity0) [...]

    public static void requestPermission(Context context0, String s, String s1, IPermissionRequestCallback iPermissionRequestCallback0) {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(s);
        PermissionUtil.requestPermissions(context0, arrayList0, s1, iPermissionRequestCallback0);
    }

    public static void requestPermissions(Context context0, List list0, String s, IPermissionRequestCallback iPermissionRequestCallback0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            String s1 = (String)object0;
            if(s1 != null && PermissionUtil.getPermissionStatus(context0, s1) != PermissionStatus.Authorized) {
                arrayList0.add(s1);
            }
        }
        if(arrayList0.size() == 0) {
            if(iPermissionRequestCallback0 != null) {
                iPermissionRequestCallback0.onPermissionGrant();
            }
            return;
        }
        for(Object object1: arrayList0) {
            PermissionUtil.setPermissionHistoryStatus(context0, ((String)object1));
        }
        PermissionRequestFragment permissionRequestFragment0 = new PermissionRequestFragment();
        permissionRequestFragment0.setCallback(iPermissionRequestCallback0);
        ((Activity)context0).runOnUiThread(() -> {
            Bundle bundle0 = new Bundle();
            bundle0.putStringArray("PermissionList", ((String[])arrayList0.toArray(new String[arrayList0.size()])));
            bundle0.putString("MessageInfo", s);
            permissionRequestFragment0.setArguments(bundle0);
            FragmentTransaction fragmentTransaction0 = ((Activity)context0).getFragmentManager().beginTransaction();
            fragmentTransaction0.add(0, permissionRequestFragment0);
            fragmentTransaction0.commit();
        });
    }

    private static void setPermissionHistoryStatus(Context context0, String s) {
        SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("VB_SHARED_PREFERENCES_PERMISSION_HISTORY", 0).edit();
        sharedPreferences$Editor0.putBoolean(s, true);
        sharedPreferences$Editor0.commit();
    }

    public static boolean verifyPermissions(int[] arr_v) {
        if(arr_v.length < 1) {
            return false;
        }
        for(int v = 0; v < arr_v.length; ++v) {
            if(arr_v[v] != 0) {
                return false;
            }
        }
        return true;
    }
}

