package com.voxelbusters.essentialkit.utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil {
    public static JSONArray getJSONArray(String s) {
        try {
            if(StringUtil.isNullOrEmpty(s)) {
                s = "[]";
            }
            return new JSONArray(s);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONObject getJSONObject(String s) {
        try {
            if(StringUtil.isNullOrEmpty(s)) {
                s = "{}";
            }
            return new JSONObject(s);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
            return new JSONObject();
        }
    }
}

