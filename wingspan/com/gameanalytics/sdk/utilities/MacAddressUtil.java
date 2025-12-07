package com.gameanalytics.sdk.utilities;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class MacAddressUtil {
    public static String getMacAddress(Context context) {
        String s = MacAddressUtil.getRawMacAddress(context);
        return s == null ? null : MacAddressUtil.removeSpaceString(s.toUpperCase(Locale.US));
    }

    private static String getRawMacAddress(Context context) {
        String s = MacAddressUtil.loadAddress("wlan0");
        if(s != null) {
            return s;
        }
        String s1 = MacAddressUtil.loadAddress("eth0");
        if(s1 != null) {
            return s1;
        }
        try {
            String s2 = ((WifiManager)context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if(s2 != null) {
                return s2;
            }
        }
        catch(Exception unused_ex) {
        }
        return null;
    }

    private static String loadAddress(String interfaceName) {
        try {
            StringBuilder stringBuilder0 = new StringBuilder(1000);
            BufferedReader bufferedReader0 = new BufferedReader(new FileReader("/sys/class/net/" + interfaceName + "/address"), 0x400);
            char[] arr_c = new char[0x400];
            int v;
            while((v = bufferedReader0.read(arr_c)) != -1) {
                stringBuilder0.append(String.valueOf(arr_c, 0, v));
            }
            bufferedReader0.close();
            return stringBuilder0.toString();
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    private static String removeSpaceString(String inputString) {
        if(inputString == null) {
            return null;
        }
        String s1 = inputString.replaceAll("\\s", "");
        return TextUtils.isEmpty(s1) ? null : s1;
    }
}

