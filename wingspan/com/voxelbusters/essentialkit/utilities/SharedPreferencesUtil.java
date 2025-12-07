package com.voxelbusters.essentialkit.utilities;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;

public class SharedPreferencesUtil {
    public static void deleteKey(String s, int v, Context context0, String s1) {
        SharedPreferences.Editor sharedPreferences$Editor0 = SharedPreferencesUtil.getSharedPreferences(s, v, context0).edit();
        sharedPreferences$Editor0.remove(s1);
        sharedPreferences$Editor0.commit();
    }

    public static JSONObject getJSONObject(String s, int v, Context context0, String s1) {
        return JSONUtil.getJSONObject(SharedPreferencesUtil.getSharedPreferences(s, v, context0).getString(s1, ""));
    }

    public static JSONArray getJsonArray(String s, int v, Context context0, String s1) {
        return JSONUtil.getJSONArray(SharedPreferencesUtil.getSharedPreferences(s, v, context0).getString(s1, ""));
    }

    public static String getKey(String s, int v, Context context0, String s1) {
        return SharedPreferencesUtil.getSharedPreferences(s, v, context0).getString(s1, null);
    }

    public static SharedPreferences getSharedPreferences(String s, int v, Context context0) {
        return context0.getSharedPreferences(s, v);
    }

    public static void setJSONArray(String s, int v, Context context0, String s1, JSONArray jSONArray0) {
        SharedPreferences.Editor sharedPreferences$Editor0 = SharedPreferencesUtil.getSharedPreferences(s, v, context0).edit();
        sharedPreferences$Editor0.putString(s1, jSONArray0.toString());
        sharedPreferences$Editor0.commit();
    }

    public static void setJSONObject(String s, int v, Context context0, String s1, JSONObject jSONObject0) {
        SharedPreferences.Editor sharedPreferences$Editor0 = SharedPreferencesUtil.getSharedPreferences(s, v, context0).edit();
        sharedPreferences$Editor0.putString(s1, jSONObject0.toString());
        sharedPreferences$Editor0.commit();
    }

    public static void setKey(String s, int v, Context context0, String s1, String s2) {
        SharedPreferences.Editor sharedPreferences$Editor0 = SharedPreferencesUtil.getSharedPreferences(s, v, context0).edit();
        sharedPreferences$Editor0.putString(s1, s2);
        sharedPreferences$Editor0.commit();
    }
}

