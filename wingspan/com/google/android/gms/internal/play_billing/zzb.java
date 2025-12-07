package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.android.billingclient.api.BillingResult.Builder;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.InAppMessageResult;
import com.android.billingclient.api.Purchase;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public final class zzb {
    public static final int zza;

    static {
        zzb.zza = Runtime.getRuntime().availableProcessors();
    }

    public static int zza(Intent intent0, String s) {
        if(intent0 == null) {
            zzb.zzk("ProxyBillingActivity", "Got null intent!");
            return 0;
        }
        return zzb.zzm(intent0.getExtras(), "ProxyBillingActivity");
    }

    public static int zzb(Bundle bundle0, String s) {
        if(bundle0 == null) {
            zzb.zzk(s, "Unexpected null bundle received!");
            return 6;
        }
        Object object0 = bundle0.get("RESPONSE_CODE");
        if(object0 == null) {
            zzb.zzj(s, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        if(object0 instanceof Integer) {
            return (int)(((Integer)object0));
        }
        zzb.zzk(s, "Unexpected type for bundle response code: " + object0.getClass().getName());
        return 6;
    }

    public static Bundle zzc(boolean z, boolean z1, boolean z2, boolean z3, String s) {
        Bundle bundle0 = new Bundle();
        bundle0.putString("playBillingLibraryVersion", s);
        if(z) {
            bundle0.putBoolean("enablePendingPurchases", true);
        }
        return bundle0;
    }

    public static Bundle zzd(String s) {
        Bundle bundle0 = new Bundle();
        bundle0.putString("playBillingLibraryVersion", s);
        return bundle0;
    }

    public static BillingResult zze(Intent intent0, String s) {
        if(intent0 == null) {
            zzb.zzk("BillingHelper", "Got null intent!");
            Builder billingResult$Builder0 = BillingResult.newBuilder();
            billingResult$Builder0.setResponseCode(6);
            billingResult$Builder0.setDebugMessage("An internal error occurred.");
            return billingResult$Builder0.build();
        }
        Builder billingResult$Builder1 = BillingResult.newBuilder();
        billingResult$Builder1.setResponseCode(zzb.zzb(intent0.getExtras(), s));
        billingResult$Builder1.setDebugMessage(zzb.zzg(intent0.getExtras(), s));
        return billingResult$Builder1.build();
    }

    public static InAppMessageResult zzf(Bundle bundle0, String s) {
        return bundle0 == null ? new InAppMessageResult(0, null) : new InAppMessageResult(zzb.zzm(bundle0, "BillingClient"), bundle0.getString("IN_APP_MESSAGE_PURCHASE_TOKEN"));
    }

    public static String zzg(Bundle bundle0, String s) {
        if(bundle0 == null) {
            zzb.zzk(s, "Unexpected null bundle received!");
            return "";
        }
        Object object0 = bundle0.get("DEBUG_MESSAGE");
        if(object0 == null) {
            zzb.zzj(s, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        }
        if(object0 instanceof String) {
            return (String)object0;
        }
        zzb.zzk(s, "Unexpected type for debug message: " + object0.getClass().getName());
        return "";
    }

    public static String zzh(int v) {
        return zza.zza(v).toString();
    }

    public static List zzi(Bundle bundle0) {
        ArrayList arrayList0 = bundle0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList arrayList1 = bundle0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        List list0 = new ArrayList();
        if(arrayList0 != null && arrayList1 != null) {
            zzb.zzj("BillingHelper", "Found purchase list of " + arrayList0.size() + " items");
            for(int v = 0; v < arrayList0.size() && v < arrayList1.size(); ++v) {
                Purchase purchase0 = zzb.zzn(((String)arrayList0.get(v)), ((String)arrayList1.get(v)));
                if(purchase0 != null) {
                    list0.add(purchase0);
                }
            }
            return list0;
        }
        Purchase purchase1 = zzb.zzn(bundle0.getString("INAPP_PURCHASE_DATA"), bundle0.getString("INAPP_DATA_SIGNATURE"));
        if(purchase1 == null) {
            zzb.zzj("BillingHelper", "Couldn\'t find single purchase data as well.");
            return null;
        }
        list0.add(purchase1);
        return list0;
    }

    public static void zzj(String s, String s1) {
        if(Log.isLoggable(s, 2)) {
            if(!s1.isEmpty()) {
                for(int v = 40000; !s1.isEmpty() && v > 0; v -= v1) {
                    int v1 = Math.min(s1.length(), Math.min(4000, v));
                    Log.v(s, s1.substring(0, v1));
                    s1 = s1.substring(v1);
                }
                return;
            }
            Log.v(s, s1);
        }
    }

    public static void zzk(String s, String s1) {
        if(Log.isLoggable(s, 5)) {
            Log.w(s, s1);
        }
    }

    public static void zzl(String s, String s1, Throwable throwable0) {
        if(Log.isLoggable(s, 5)) {
            Log.w(s, s1, throwable0);
        }
    }

    private static int zzm(Bundle bundle0, String s) {
        if(bundle0 == null) {
            zzb.zzk(s, "Unexpected null bundle received!");
            return 0;
        }
        return bundle0.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
    }

    private static Purchase zzn(String s, String s1) {
        if(s != null && s1 != null) {
            try {
                return new Purchase(s, s1);
            }
            catch(JSONException jSONException0) {
                zzb.zzk("BillingHelper", "Got JSONException while parsing purchase data: " + jSONException0.toString());
                return null;
            }
        }
        zzb.zzj("BillingHelper", "Received a null purchase data.");
        return null;
    }
}

