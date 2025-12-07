package com.onesignal.common;

import android.os.Bundle;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bJ\u001A\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\u0010\r\u001A\u0004\u0018\u00010\fJ\u0010\u0010\u000E\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000F\u001A\u00020\u0004J\u001A\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0012\u001A\u00020\u0006J\u0014\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0015\u001A\u00020\fJ\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001A\u00020\u0001J\u000E\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u0006J\u0010\u0010\u001A\u001A\u00020\f2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0006R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2 = {"Lcom/onesignal/common/JSONUtils;", "", "()V", "EXTERNAL_USER_ID", "", "bundleAsJSONObject", "Lorg/json/JSONObject;", "bundle", "Landroid/os/Bundle;", "compareJSONArrays", "", "jsonArray1", "Lorg/json/JSONArray;", "jsonArray2", "jsonStringToBundle", "data", "newStringMapFromJSONObject", "", "jsonObject", "newStringSetFromJSONArray", "", "jsonArray", "normalizeType", "object", "toUnescapedEUIDString", "json", "wrapInJsonArray", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class JSONUtils {
    public static final String EXTERNAL_USER_ID = "external_user_id";
    public static final JSONUtils INSTANCE;

    static {
        JSONUtils.INSTANCE = new JSONUtils();
    }

    public final JSONObject bundleAsJSONObject(Bundle bundle0) {
        Intrinsics.checkNotNullParameter(bundle0, "bundle");
        JSONObject jSONObject0 = new JSONObject();
        for(Object object0: bundle0.keySet()) {
            String s = (String)object0;
            try {
                jSONObject0.put(s, bundle0.get(s));
            }
            catch(JSONException jSONException0) {
                Logging.error(("bundleAsJSONObject error for key: " + s), jSONException0);
            }
        }
        return jSONObject0;
    }

    public final boolean compareJSONArrays(JSONArray jSONArray0, JSONArray jSONArray1) {
        int v3;
        if(jSONArray0 == null && jSONArray1 == null) {
            return true;
        }
        if(jSONArray0 == null || jSONArray1 == null || jSONArray0.length() != jSONArray1.length()) {
            return false;
        }
        try {
            int v = jSONArray0.length();
            for(int v1 = 0; true; ++v1) {
                if(v1 >= v) {
                    return true;
                }
                int v2 = jSONArray1.length();
                v3 = 0;
            label_10:
                if(v3 >= v2) {
                    return false;
                }
                Object object0 = jSONArray0.get(v1);
                Intrinsics.checkNotNullExpressionValue(object0, "jsonArray1[i]");
                Object object1 = this.normalizeType(object0);
                Object object2 = jSONArray1.get(v3);
                Intrinsics.checkNotNullExpressionValue(object2, "jsonArray2[j]");
                if(!Intrinsics.areEqual(object1, this.normalizeType(object2))) {
                    break;
                }
            }
            ++v3;
            goto label_10;
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
            return false;
        }
    }

    public final Bundle jsonStringToBundle(String s) {
        Intrinsics.checkNotNullParameter(s, "data");
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            Bundle bundle0 = new Bundle();
            Iterator iterator0 = jSONObject0.keys();
            Intrinsics.checkNotNullExpressionValue(iterator0, "jsonObject.keys()");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type kotlin.String");
                bundle0.putString(((String)object0), jSONObject0.getString(((String)object0)));
            }
            return bundle0;
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
            return null;
        }
    }

    public final Map newStringMapFromJSONObject(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        Iterator iterator0 = jSONObject0.keys();
        Intrinsics.checkNotNullExpressionValue(iterator0, "jsonObject.keys()");
        Map map0 = new LinkedHashMap();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s = (String)object0;
            try {
                Object object1 = jSONObject0.opt(s);
                if(!(object1 instanceof JSONArray) && !(object1 instanceof JSONObject)) {
                    if(jSONObject0.isNull(s) || Intrinsics.areEqual("", object1)) {
                        map0.put(s, "");
                    }
                    else {
                        map0.put(s, object1.toString());
                    }
                    continue;
                }
                Logging.error$default(("Omitting key \'" + s + "\'! sendTags DO NOT supported nested values!"), null, 2, null);
            }
            catch(Throwable unused_ex) {
            }
        }
        return map0;
    }

    public final Set newStringSetFromJSONArray(JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "jsonArray");
        Set set0 = new LinkedHashSet();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = jSONArray0.getString(v1);
            Intrinsics.checkNotNullExpressionValue(s, "jsonArray.getString(i)");
            set0.add(s);
        }
        return set0;
    }

    public final Object normalizeType(Object object0) {
        Intrinsics.checkNotNullParameter(object0, "object");
        Class class0 = object0.getClass();
        if(Intrinsics.areEqual(class0, Integer.TYPE)) {
            return (long)((Integer)object0).intValue();
        }
        return Intrinsics.areEqual(class0, Float.TYPE) ? ((double)((Float)object0).floatValue()) : object0;
    }

    public final String toUnescapedEUIDString(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "json");
        String s = jSONObject0.toString();
        Intrinsics.checkNotNullExpressionValue(s, "json.toString()");
        if(jSONObject0.has("external_user_id")) {
            Matcher matcher0 = Pattern.compile("(?<=\"external_user_id\":\").*?(?=\")").matcher(s);
            if(matcher0.find()) {
                String s1 = matcher0.group(0);
                if(s1 != null) {
                    s = matcher0.replaceAll(Matcher.quoteReplacement(StringsKt.replace$default(s1, "\\/", "/", false, 4, null)));
                    Intrinsics.checkNotNullExpressionValue(s, "eidMatcher.replaceAll(unescapedEID)");
                }
            }
        }
        return s;
    }

    public final JSONArray wrapInJsonArray(JSONObject jSONObject0) {
        JSONArray jSONArray0 = new JSONArray().put(jSONObject0);
        Intrinsics.checkNotNullExpressionValue(jSONArray0, "JSONArray().put(jsonObject)");
        return jSONArray0;
    }
}

