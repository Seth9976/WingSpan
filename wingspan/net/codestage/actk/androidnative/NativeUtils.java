package net.codestage.actk.androidnative;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.util.Log;
import com.unity3d.player.UnityPlayerActivity;
import java.lang.reflect.Field;

class NativeUtils {
    static String LogTag = "ACTk";
    private static Context applicationContext;
    private static final char[] hexArray;

    static {
        NativeUtils.hexArray = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    static String BytesToHex(byte[] arr_b) {
        char[] arr_c = new char[arr_b.length * 2];
        for(int v = 0; v < arr_b.length; ++v) {
            int v1 = (arr_b[v] ^ 0x90) & 0xFF;
            arr_c[v * 2] = NativeUtils.hexArray[v1 >>> 4];
            arr_c[v * 2 + 1] = NativeUtils.hexArray[v1 & 15];
        }
        return new String(arr_c);
    }

    static boolean ContainsIgnoreCase(String s, String s1) {
        return s == null || s1 == null ? false : s.toLowerCase().contains(s1.toLowerCase());
    }

    static String GetApkPath() throws PackageManager.NameNotFoundException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        NativeUtils.GetUnityPlayerActivityIfNeeded();
        if(NativeUtils.applicationContext == null) {
            Log.e("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310105010500461345150B044D340008131C520D1F03150B191344"));
            return null;
        }
        PackageManager packageManager0 = NativeUtils.applicationContext.getPackageManager();
        if(packageManager0 == null) {
            Log.e("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310105010500461345150B044D110F020C04150B50000000000000004F"));
            return null;
        }
        ApplicationInfo applicationInfo0 = packageManager0.getApplicationInfo("com.MonsterCouch.Wingspan", 0);
        if(applicationInfo0 == null) {
            Log.e("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310105010500461345150B044D201E110B0C110F04040E002809031D4F"));
            return null;
        }
        return applicationInfo0.publicSourceDir;
    }

    private static void GetUnityPlayerActivityIfNeeded() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        if(NativeUtils.applicationContext != null) {
            return;
        }
        Class class0 = Class.forName(UnityPlayerActivity.adjustValue("0D1F004F1B0F0E110B5D14431102001E0000402503081A1837091317151F"));
        if(class0 == null) {
            Log.e("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310105010500461345150B044D02010C49101C070414520A4F17091317151F4F3B0F0E110B3E1C0C180B1347061E0F031E40"));
            return;
        }
        Field field0 = class0.getDeclaredField(UnityPlayerActivity.adjustValue("0D051F130B0F1324111A191B081A18"));
        if(field0 == null) {
            Log.e("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310105010500461345150B044D02010C49101C070414520A4F17091317151F4F3B0F0E110B3E1C0C180B135D06071C02080F1A2004111B181919184E070E001E0A51"));
            return;
        }
        Activity activity0 = (Activity)field0.get(null);
        if(activity0 == null) {
            Log.e("ACTk", UnityPlayerActivity.adjustValue("353302050B2906161A291503041C00130A004E353F3321333A45310105010500461345150B044D200D150E131B1A094D071C0E0A4511011D43140008131C410A5E1D0D0F1802175C3B1E041517310B040B0B0257021B1315001C1A310E1507170E110B4E160404020546"));
            return;
        }
        NativeUtils.applicationContext = activity0.getApplicationContext();
    }
}

