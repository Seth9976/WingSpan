package com.gameanalytics.sdk.utilities;

import android.content.Context;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GAUtilities {
    public static final String GAID_PACKAGE_NAME = "com.google.android.gms.ads.identifier";
    public static final String OAID_PACKAGE_NAME = "com.huawei.hms.ads.identifier";

    public static JSONArray array(String string) {
        try {
            return new JSONArray(string);
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    public static JSONObject dictionary(String string) {
        try {
            return new JSONObject(string);
        }
        catch(JSONException unused_ex) {
            return null;
        }
    }

    public static String getGAID(Context context) {
        return Reflection.getAdId("com.google.android.gms.ads.identifier", context);
    }

    public static String getOAID(Context context) {
        try {
            String s = Reflection.getAdId("com.huawei.hms.ads.identifier", context);
            if(!GAUtilities.isZeroId(s)) {
                return s;
            }
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    public static byte[] gzipCompress(String data) throws IOException {
        byte[] arr_b;
        com.gameanalytics.sdk.utilities.GAUtilities.1 gAUtilities$10;
        ByteArrayOutputStream byteArrayOutputStream0;
        if(data != null && data.length() != 0) {
            try {
                byteArrayOutputStream0 = new ByteArrayOutputStream();
            }
            catch(Throwable throwable0) {
                byteArrayOutputStream0 = null;
                gAUtilities$10 = null;
                goto label_14;
            }
            try {
                gAUtilities$10 = null;
                gAUtilities$10 = new GZIPOutputStream(byteArrayOutputStream0) {
                    {
                        OutputStream out = byteArrayOutputStream0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.def.setLevel(9);
                    }
                };
                gAUtilities$10.write(data.getBytes("UTF-8"));
                gAUtilities$10.close();
                arr_b = byteArrayOutputStream0.toByteArray();
                goto label_22;
            }
            catch(Throwable throwable0) {
            }
            try {
            label_14:
                if(byteArrayOutputStream0 != null) {
                    byteArrayOutputStream0.close();
                }
                if(gAUtilities$10 != null) {
                    gAUtilities$10.close();
                }
            }
            catch(IOException iOException0) {
                iOException0.printStackTrace();
            }
            throw throwable0;
            try {
            label_22:
                byteArrayOutputStream0.close();
                gAUtilities$10.close();
            }
            catch(IOException iOException1) {
                iOException1.printStackTrace();
            }
            return arr_b;
        }
        return new byte[0];
    }

    public static String gzipDecompress(byte[] data) throws Exception {
        String s;
        BufferedReader bufferedReader0;
        Throwable throwable1;
        GZIPInputStream gZIPInputStream0;
        try {
            gZIPInputStream0 = new GZIPInputStream(new ByteArrayInputStream(data));
        }
        catch(Throwable throwable0) {
            gZIPInputStream0 = null;
            throwable1 = throwable0;
            bufferedReader0 = null;
            goto label_21;
        }
        try {
            bufferedReader0 = new BufferedReader(new InputStreamReader(gZIPInputStream0, "UTF-8"));
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            bufferedReader0 = null;
            goto label_21;
        }
        try {
            s = "";
            String s1;
            while((s1 = bufferedReader0.readLine()) != null) {
                s = s + s1;
            }
            bufferedReader0.close();
            goto label_29;
        }
        catch(Throwable throwable1) {
        }
        try {
        label_21:
            if(bufferedReader0 != null) {
                bufferedReader0.close();
            }
            if(gZIPInputStream0 != null) {
                gZIPInputStream0.close();
            }
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
        }
        throw throwable1;
        try {
        label_29:
            bufferedReader0.close();
            gZIPInputStream0.close();
        }
        catch(IOException iOException1) {
            iOException1.printStackTrace();
        }
        return s;
    }

    public static String hmac(String key, byte[] data) {
        try {
            Mac mac0 = Mac.getInstance("HmacSHA256");
            mac0.init(new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256"));
            return Base64.encodeToString(mac0.doFinal(data), 0);
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
            noSuchAlgorithmException0.printStackTrace();
            return "";
        }
        catch(InvalidKeyException invalidKeyException0) {
            invalidKeyException0.printStackTrace();
            return "";
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            unsupportedEncodingException0.printStackTrace();
            return "";
        }
    }

    public static Boolean isLimitAdTrackingEnabled(String packageName, Context context) {
        return Reflection.isLimitAdTrackingEnabled(packageName, context);
    }

    public static boolean isZeroId(String id) {
        boolean z = false;
        UUID uUID0 = UUID.fromString("00000000-0000-0000-0000-000000000000");
        try {
            if(UUID.fromString(id) == uUID0) {
                z = true;
            }
        }
        catch(Exception unused_ex) {
        }
        boolean z1 = id != null && z;
        if(!z1 && id != null) {
            for(int v = 0; v < id.length(); ++v) {
                z1 = id.charAt(v) == 0x30;
                if(!z1) {
                    break;
                }
            }
        }
        return z1;
    }

    public static String joinStringArray(String[] v, String delimiter) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < v.length; ++v) {
            if(v > 0) {
                stringBuilder0.append(delimiter);
            }
            stringBuilder0.append(v[v]);
        }
        return stringBuilder0.toString();
    }

    public static String jsonString(ArrayList arr) {
        try {
            JSONArray jSONArray0 = new JSONArray();
            for(Object object0: arr) {
                jSONArray0.put(((JSONObject)object0));
            }
            return jSONArray0.toString();
        }
        catch(Exception unused_ex) {
            return "";
        }
    }

    public static boolean stringArrayContainsString(String[] array, String search) {
        if(array.length == 0) {
            return false;
        }
        for(int v = 0; v < array.length; ++v) {
            if(array[v].equals(search)) {
                return true;
            }
        }
        return false;
    }

    public static boolean stringMatch(String string, String pattern) {
        return string == null || pattern == null ? false : Pattern.matches(pattern, string);
    }

    public static long timeIntervalSince1970() [...] // 潜在的解密器
}

