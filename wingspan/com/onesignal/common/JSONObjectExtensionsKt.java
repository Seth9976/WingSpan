package com.onesignal.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\u001AC\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052#\u0010\u0006\u001A\u001F\u0012\u0013\u0012\u00110\u0003\u00A2\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0007\u001A5\u0010\n\u001A\u00020\u000B*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052!\u0010\u0006\u001A\u001D\u0012\u0013\u0012\u00110\u0003\u00A2\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000B0\u0007\u001AM\u0010\f\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u000E\u0010\r\u001A\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012#\u0010\u000E\u001A\u001F\u0012\u0013\u0012\u0011H\u0002\u00A2\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u001A5\u0010\u0010\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052!\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\u0003\u00A2\u0006\f\b\b\u0012\b\b\u0004\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u000B0\u0007\u001A*\u0010\u0012\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0016\u0010\u0013\u001A\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014\u001A \u0010\u0012\u001A\u00020\u0003*\u00020\u00032\u0014\u0010\u0013\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014\u001A\u001C\u0010\u0016\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u0017\u001A\u0004\u0018\u00010\u0015\u001A\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u0019*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u001A\u001A\u0019\u0010\u001B\u001A\u0004\u0018\u00010\u001C*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u001D\u001A\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u001F*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010 \u001A\u0014\u0010!\u001A\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005\u001A\u0019\u0010\"\u001A\u0004\u0018\u00010#*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010$\u001A\u0014\u0010%\u001A\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005\u001A\u0014\u0010&\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0001*\u00020\'\u001A\u0018\u0010(\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150)*\u00020\u0003\u00A8\u0006*"}, d2 = {"expandJSONArray", "", "T", "Lorg/json/JSONObject;", "name", "", "into", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "childObject", "expandJSONObject", "", "putJSONArray", "list", "create", "item", "putJSONObject", "expand", "putMap", "map", "", "", "putSafe", "value", "safeBool", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "safeDouble", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "safeInt", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "safeJSONObject", "safeLong", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "safeString", "toList", "Lorg/json/JSONArray;", "toMap", "", "com.onesignal.core"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class JSONObjectExtensionsKt {
    public static final List expandJSONArray(JSONObject jSONObject0, String s, Function1 function10) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(function10, "into");
        List list0 = new ArrayList();
        if(jSONObject0.has(s)) {
            JSONArray jSONArray0 = jSONObject0.getJSONArray(s);
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject1 = jSONArray0.getJSONObject(v1);
                Intrinsics.checkNotNullExpressionValue(jSONObject1, "itemJSONObject");
                Object object0 = function10.invoke(jSONObject1);
                if(object0 != null) {
                    list0.add(object0);
                }
            }
        }
        return list0;
    }

    public static final void expandJSONObject(JSONObject jSONObject0, String s, Function1 function10) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(function10, "into");
        if(jSONObject0.has(s)) {
            JSONObject jSONObject1 = jSONObject0.getJSONObject(s);
            Intrinsics.checkNotNullExpressionValue(jSONObject1, "this.getJSONObject(name)");
            function10.invoke(jSONObject1);
        }
    }

    public static final JSONObject putJSONArray(JSONObject jSONObject0, String s, List list0, Function1 function10) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(function10, "create");
        if(list0 != null) {
            JSONArray jSONArray0 = new JSONArray();
            for(Object object0: list0) {
                JSONObject jSONObject1 = (JSONObject)function10.invoke(object0);
                if(jSONObject1 != null) {
                    jSONArray0.put(jSONObject1);
                }
            }
            jSONObject0.put(s, jSONArray0);
        }
        return jSONObject0;
    }

    public static final JSONObject putJSONObject(JSONObject jSONObject0, String s, Function1 function10) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        Intrinsics.checkNotNullParameter(function10, "expand");
        JSONObject jSONObject1 = new JSONObject();
        function10.invoke(jSONObject1);
        jSONObject0.put(s, jSONObject1);
        return jSONObject0;
    }

    public static final JSONObject putMap(JSONObject jSONObject0, String s, Map map0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        if(map0 != null) {
            JSONObjectExtensionsKt.putJSONObject(jSONObject0, s, new Function1(map0) {
                final Map $map;

                {
                    this.$map = map0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((JSONObject)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(JSONObject jSONObject0) {
                    Intrinsics.checkNotNullParameter(jSONObject0, "it");
                    JSONObjectExtensionsKt.putMap(jSONObject0, this.$map);
                }
            });
        }
        return jSONObject0;
    }

    public static final JSONObject putMap(JSONObject jSONObject0, Map map0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(map0, "map");
        for(Object object0: map0.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            if(object1 == null) {
                object1 = JSONObject.NULL;
            }
            jSONObject0.put(s, object1);
        }
        return jSONObject0;
    }

    public static final JSONObject putSafe(JSONObject jSONObject0, String s, Object object0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        if(object0 != null) {
            jSONObject0.put(s, object0);
        }
        return jSONObject0;
    }

    public static final Boolean safeBool(JSONObject jSONObject0, String s) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        return jSONObject0.has(s) ? Boolean.valueOf(jSONObject0.getBoolean(s)) : null;
    }

    public static final Double safeDouble(JSONObject jSONObject0, String s) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        return jSONObject0.has(s) ? jSONObject0.getDouble(s) : null;
    }

    public static final Integer safeInt(JSONObject jSONObject0, String s) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        return jSONObject0.has(s) ? jSONObject0.getInt(s) : null;
    }

    public static final JSONObject safeJSONObject(JSONObject jSONObject0, String s) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        return jSONObject0.has(s) ? jSONObject0.getJSONObject(s) : null;
    }

    public static final Long safeLong(JSONObject jSONObject0, String s) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        return jSONObject0.has(s) ? jSONObject0.getLong(s) : null;
    }

    public static final String safeString(JSONObject jSONObject0, String s) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Intrinsics.checkNotNullParameter(s, "name");
        return jSONObject0.has(s) ? jSONObject0.getString(s) : null;
    }

    public static final List toList(JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "<this>");
        int v = jSONArray0.length();
        List list0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = jSONArray0.opt(v1);
            if(JSONObject.NULL.equals(object0)) {
                list0.add(null);
            }
            else if(object0 instanceof JSONArray) {
                list0.add(JSONObjectExtensionsKt.toList(((JSONArray)object0)));
            }
            else if(object0 instanceof JSONObject) {
                list0.add(JSONObjectExtensionsKt.toMap(((JSONObject)object0)));
            }
            else {
                list0.add(object0);
            }
        }
        return list0;
    }

    public static final Map toMap(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "<this>");
        Map map0 = new HashMap();
        Iterator iterator0 = jSONObject0.keys();
        Intrinsics.checkNotNullExpressionValue(iterator0, "this.keys()");
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            Object object1 = jSONObject0.get(((String)object0));
            Intrinsics.checkNotNullExpressionValue(((String)object0), "key");
            if(JSONObject.NULL.equals(object1)) {
                object1 = null;
            }
            else if(object1 instanceof JSONObject) {
                object1 = JSONObjectExtensionsKt.toMap(((JSONObject)object1));
            }
            else if(object1 instanceof JSONArray) {
                object1 = JSONObjectExtensionsKt.toList(((JSONArray)object1));
            }
            map0.put(((String)object0), object1);
        }
        return map0;
    }
}

