package com.onesignal.user.internal.backend.impl;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.user.internal.backend.CreateUserResponse;
import com.onesignal.user.internal.backend.PropertiesDeltasObject;
import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.backend.PurchaseObject;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\u0007\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\u0007\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\rJ\u0014\u0010\u0007\u001A\u00020\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\r0\u0010¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/JSONConverter;", "", "()V", "convertToCreateUserResponse", "Lcom/onesignal/user/internal/backend/CreateUserResponse;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "propertiesDeltas", "Lcom/onesignal/user/internal/backend/PropertiesDeltasObject;", "properties", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "subscription", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "Lorg/json/JSONArray;", "subscriptions", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class JSONConverter {
    public static final JSONConverter INSTANCE;

    static {
        JSONConverter.INSTANCE = new JSONConverter();
    }

    public final CreateUserResponse convertToCreateUserResponse(JSONObject jSONObject0) {
        Map map3;
        Map map1;
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        JSONObject jSONObject1 = JSONObjectExtensionsKt.safeJSONObject(jSONObject0, "identity");
        if(jSONObject1 == null) {
            map1 = MapsKt.emptyMap();
        }
        else {
            Map map0 = JSONObjectExtensionsKt.toMap(jSONObject1);
            if(map0 == null) {
                map1 = MapsKt.emptyMap();
            }
            else {
                map1 = new LinkedHashMap(MapsKt.mapCapacity(map0.size()));
                for(Object object0: map0.entrySet()) {
                    map1.put(((Map.Entry)object0).getKey(), String.valueOf(((Map.Entry)object0).getValue()));
                }
            }
        }
        JSONObject jSONObject2 = JSONObjectExtensionsKt.safeJSONObject(jSONObject0, "properties");
        Double double0 = null;
        if(jSONObject2 == null) {
            map3 = null;
        }
        else {
            JSONObject jSONObject3 = JSONObjectExtensionsKt.safeJSONObject(jSONObject2, "tags");
            if(jSONObject3 == null) {
                map3 = null;
            }
            else {
                Map map2 = JSONObjectExtensionsKt.toMap(jSONObject3);
                if(map2 == null) {
                    map3 = null;
                }
                else {
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
                    for(Object object1: map2.entrySet()) {
                        linkedHashMap0.put(((Map.Entry)object1).getKey(), String.valueOf(((Map.Entry)object1).getValue()));
                    }
                    map3 = linkedHashMap0;
                }
            }
        }
        String s = jSONObject2 == null ? null : JSONObjectExtensionsKt.safeString(jSONObject2, "language");
        String s1 = jSONObject2 == null ? null : JSONObjectExtensionsKt.safeString(jSONObject2, "timezone_id");
        String s2 = jSONObject2 == null ? null : JSONObjectExtensionsKt.safeString(jSONObject2, "country");
        Double double1 = jSONObject2 == null ? null : JSONObjectExtensionsKt.safeDouble(jSONObject2, "lat");
        if(jSONObject2 != null) {
            double0 = JSONObjectExtensionsKt.safeDouble(jSONObject2, "long");
        }
        return new CreateUserResponse(map1, new PropertiesObject(map3, s, s1, s2, double1, double0), JSONObjectExtensionsKt.expandJSONArray(jSONObject0, "subscriptions", com.onesignal.user.internal.backend.impl.JSONConverter.convertToCreateUserResponse.respSubscriptions.1.INSTANCE));

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.user.internal.backend.impl.JSONConverter.convertToCreateUserResponse.respSubscriptions.1 extends Lambda implements Function1 {
            public static final com.onesignal.user.internal.backend.impl.JSONConverter.convertToCreateUserResponse.respSubscriptions.1 INSTANCE;

            static {
                com.onesignal.user.internal.backend.impl.JSONConverter.convertToCreateUserResponse.respSubscriptions.1.INSTANCE = new com.onesignal.user.internal.backend.impl.JSONConverter.convertToCreateUserResponse.respSubscriptions.1();
            }

            com.onesignal.user.internal.backend.impl.JSONConverter.convertToCreateUserResponse.respSubscriptions.1() {
                super(1);
            }

            public final SubscriptionObject invoke(JSONObject jSONObject0) {
                Intrinsics.checkNotNullParameter(jSONObject0, "it");
                String s = jSONObject0.getString("type");
                Intrinsics.checkNotNullExpressionValue(s, "it.getString(\"type\")");
                SubscriptionObjectType subscriptionObjectType0 = SubscriptionObjectType.Companion.fromString(s);
                return subscriptionObjectType0 == null ? null : new SubscriptionObject(jSONObject0.getString("id"), subscriptionObjectType0, JSONObjectExtensionsKt.safeString(jSONObject0, "token"), JSONObjectExtensionsKt.safeBool(jSONObject0, "enabled"), JSONObjectExtensionsKt.safeInt(jSONObject0, "notification_types"), JSONObjectExtensionsKt.safeString(jSONObject0, "sdk"), JSONObjectExtensionsKt.safeString(jSONObject0, "device_model"), JSONObjectExtensionsKt.safeString(jSONObject0, "device_os"), JSONObjectExtensionsKt.safeBool(jSONObject0, "rooted"), JSONObjectExtensionsKt.safeInt(jSONObject0, "net_type"), JSONObjectExtensionsKt.safeString(jSONObject0, "carrier"), JSONObjectExtensionsKt.safeString(jSONObject0, "app_version"));
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((JSONObject)object0));
            }
        }

    }

    public final JSONArray convertToJSON(List list0) {
        Intrinsics.checkNotNullParameter(list0, "subscriptions");
        JSONArray jSONArray0 = new JSONArray();
        for(Object object0: list0) {
            jSONArray0.put(this.convertToJSON(((SubscriptionObject)object0)));
        }
        return jSONArray0;
    }

    public final JSONObject convertToJSON(PropertiesDeltasObject propertiesDeltasObject0) {
        Intrinsics.checkNotNullParameter(propertiesDeltasObject0, "propertiesDeltas");
        JSONObject jSONObject0 = JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(new JSONObject(), "session_time", propertiesDeltasObject0.getSessionTime()), "session_count", propertiesDeltasObject0.getSessionCount());
        BigDecimal bigDecimal0 = propertiesDeltasObject0.getAmountSpent();
        return bigDecimal0 == null ? JSONObjectExtensionsKt.putJSONArray(JSONObjectExtensionsKt.putSafe(jSONObject0, "amount_spent", null), "purchases", propertiesDeltasObject0.getPurchases(), com.onesignal.user.internal.backend.impl.JSONConverter.convertToJSON.1.INSTANCE) : JSONObjectExtensionsKt.putJSONArray(JSONObjectExtensionsKt.putSafe(jSONObject0, "amount_spent", bigDecimal0.toString()), "purchases", propertiesDeltasObject0.getPurchases(), com.onesignal.user.internal.backend.impl.JSONConverter.convertToJSON.1.INSTANCE);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "it", "Lcom/onesignal/user/internal/backend/PurchaseObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.user.internal.backend.impl.JSONConverter.convertToJSON.1 extends Lambda implements Function1 {
            public static final com.onesignal.user.internal.backend.impl.JSONConverter.convertToJSON.1 INSTANCE;

            static {
                com.onesignal.user.internal.backend.impl.JSONConverter.convertToJSON.1.INSTANCE = new com.onesignal.user.internal.backend.impl.JSONConverter.convertToJSON.1();
            }

            com.onesignal.user.internal.backend.impl.JSONConverter.convertToJSON.1() {
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((PurchaseObject)object0));
            }

            public final JSONObject invoke(PurchaseObject purchaseObject0) {
                Intrinsics.checkNotNullParameter(purchaseObject0, "it");
                return new JSONObject().put("sku", purchaseObject0.getSku()).put("iso", purchaseObject0.getIso()).put("amount", purchaseObject0.getAmount().toString());
            }
        }

    }

    public final JSONObject convertToJSON(PropertiesObject propertiesObject0) {
        Intrinsics.checkNotNullParameter(propertiesObject0, "properties");
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putMap(new JSONObject(), "tags", propertiesObject0.getTags()), "language", propertiesObject0.getLanguage()), "timezone_id", propertiesObject0.getTimezoneId()), "lat", propertiesObject0.getLatitude()), "long", propertiesObject0.getLongitude()), "country", propertiesObject0.getCountry());
    }

    public final JSONObject convertToJSON(SubscriptionObject subscriptionObject0) {
        Intrinsics.checkNotNullParameter(subscriptionObject0, "subscription");
        JSONObject jSONObject0 = JSONObjectExtensionsKt.putSafe(new JSONObject(), "id", subscriptionObject0.getId());
        SubscriptionObjectType subscriptionObjectType0 = subscriptionObject0.getType();
        return subscriptionObjectType0 == null ? JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(jSONObject0, "type", null), "token", subscriptionObject0.getToken()), "enabled", subscriptionObject0.getEnabled()), "notification_types", subscriptionObject0.getNotificationTypes()), "sdk", subscriptionObject0.getSdk()), "device_model", subscriptionObject0.getDeviceModel()), "device_os", subscriptionObject0.getDeviceOS()), "rooted", subscriptionObject0.getRooted()), "net_type", subscriptionObject0.getNetType()), "carrier", subscriptionObject0.getCarrier()), "app_version", subscriptionObject0.getAppVersion()) : JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(jSONObject0, "type", subscriptionObjectType0.getValue()), "token", subscriptionObject0.getToken()), "enabled", subscriptionObject0.getEnabled()), "notification_types", subscriptionObject0.getNotificationTypes()), "sdk", subscriptionObject0.getSdk()), "device_model", subscriptionObject0.getDeviceModel()), "device_os", subscriptionObject0.getDeviceOS()), "rooted", subscriptionObject0.getRooted()), "net_type", subscriptionObject0.getNetType()), "carrier", subscriptionObject0.getCarrier()), "app_version", subscriptionObject0.getAppVersion());
    }
}

