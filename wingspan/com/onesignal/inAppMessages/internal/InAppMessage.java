package com.onesignal.inAppMessages.internal;

import com.onesignal.common.DateUtils;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.inAppMessages.IInAppMessage;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 N2\u00020\u0001:\u0001NB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u0006B5\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u000EB\u0017\b\u0016\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u0011B\u0015\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\u0002\u0010\u0012J\u000E\u00107\u001A\u0002082\u0006\u00109\u001A\u00020\bJ\u0006\u0010:\u001A\u000208J\u0013\u0010;\u001A\u00020\u00032\b\u0010<\u001A\u0004\u0018\u00010=H\u0096\u0002J\b\u0010>\u001A\u00020?H\u0016J\u000E\u0010@\u001A\u00020\u00032\u0006\u00109\u001A\u00020\bJ\u0012\u0010A\u001A\u0004\u0018\u00010 2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002J6\u0010B\u001A(\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0C0Cj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020/0Cj\b\u0012\u0004\u0012\u00020/`D`D2\u0006\u0010E\u001A\u00020FH\u0002JT\u0010G\u001AF\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0H0Hj*\u0012\u0004\u0012\u00020\b\u0012 \u0012\u001E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0Hj\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`I`I2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002J\u000E\u0010J\u001A\u0002082\u0006\u00109\u001A\u00020\bJ\u0006\u0010K\u001A\u00020\u0003J\u0006\u0010L\u001A\u00020\u0010J\b\u0010M\u001A\u00020\bH\u0016R\u000E\u0010\u0013\u001A\u00020\u0003X\u0082\u000E\u00A2\u0006\u0002\n\u0000R*\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\b0\u00152\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\b0\u0015@BX\u0086\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u001AX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u0010\u0010\u001F\u001A\u0004\u0018\u00010 X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u001E\u0010!\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0003@BX\u0086\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u001A\u0010$\u001A\u00020\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b$\u0010#\"\u0004\b%\u0010&R\u0011\u0010\'\u001A\u00020\u00038F\u00A2\u0006\u0006\u001A\u0004\b\'\u0010#R\u001E\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u0003@BX\u0086\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010#R\u001A\u0010(\u001A\u00020\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b(\u0010#\"\u0004\b)\u0010&R\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u001E\u0010\f\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r@BX\u0086\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b,\u0010-R6\u00100\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0.2\u0012\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0.@BX\u0086\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b1\u00102RN\u00104\u001A\u001A\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b03032\u001E\u0010\u0014\u001A\u001A\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0303@BX\u0086\u000E\u00A2\u0006\b\n\u0000\u001A\u0004\b5\u00106\u00A8\u0006O"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessage;", "Lcom/onesignal/inAppMessages/IInAppMessage;", "isPreview", "", "time", "Lcom/onesignal/core/internal/time/ITime;", "(ZLcom/onesignal/core/internal/time/ITime;)V", "messageId", "", "clickIds", "", "displayedInSession", "redisplayStats", "Lcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats;", "(Ljava/lang/String;Ljava/util/Set;ZLcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats;Lcom/onesignal/core/internal/time/ITime;)V", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lcom/onesignal/core/internal/time/ITime;)V", "(Ljava/lang/String;Lcom/onesignal/core/internal/time/ITime;)V", "actionTaken", "<set-?>", "", "clickedClickIds", "getClickedClickIds", "()Ljava/util/Set;", "displayDuration", "", "getDisplayDuration", "()D", "setDisplayDuration", "(D)V", "endTime", "Ljava/util/Date;", "hasLiquid", "getHasLiquid", "()Z", "isDisplayedInSession", "setDisplayedInSession", "(Z)V", "isFinished", "isTriggerChanged", "setTriggerChanged", "getMessageId", "()Ljava/lang/String;", "getRedisplayStats", "()Lcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats;", "", "Lcom/onesignal/inAppMessages/internal/Trigger;", "triggers", "getTriggers", "()Ljava/util/List;", "", "variants", "getVariants", "()Ljava/util/Map;", "addClickId", "", "clickId", "clearClickIds", "equals", "o", "", "hashCode", "", "isClickAvailable", "parseEndTimeJson", "parseTriggerJson", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "triggersJson", "Lorg/json/JSONArray;", "parseVariants", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "removeClickId", "takeActionAsUnique", "toJSONObject", "toString", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessage implements IInAppMessage {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessage$Companion;", "", "()V", "DISPLAY_DURATION", "", "END_TIME", "HAS_LIQUID", "IAM_ID", "IAM_REDISPLAY_STATS", "IAM_TRIGGERS", "IAM_VARIANTS", "ID", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String DISPLAY_DURATION = "displayDuration";
    private static final String END_TIME = "end_time";
    private static final String HAS_LIQUID = "has_liquid";
    private static final String IAM_ID = "messageId";
    private static final String IAM_REDISPLAY_STATS = "redisplay";
    private static final String IAM_TRIGGERS = "triggers";
    private static final String IAM_VARIANTS = "variants";
    private static final String ID = "id";
    private boolean actionTaken;
    private Set clickedClickIds;
    private double displayDuration;
    private Date endTime;
    private boolean hasLiquid;
    private boolean isDisplayedInSession;
    private boolean isPreview;
    private boolean isTriggerChanged;
    private final String messageId;
    private InAppMessageRedisplayStats redisplayStats;
    private List triggers;
    private Map variants;

    static {
        InAppMessage.Companion = new Companion(null);
    }

    public InAppMessage(String s, ITime iTime0) {
        Intrinsics.checkNotNullParameter(s, "messageId");
        Intrinsics.checkNotNullParameter(iTime0, "time");
        super();
        this.messageId = s;
        this.variants = MapsKt.emptyMap();
        this.triggers = CollectionsKt.emptyList();
        this.clickedClickIds = new LinkedHashSet();
        this.redisplayStats = new InAppMessageRedisplayStats(iTime0);
    }

    public InAppMessage(String s, Set set0, boolean z, InAppMessageRedisplayStats inAppMessageRedisplayStats0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(s, "messageId");
        Intrinsics.checkNotNullParameter(set0, "clickIds");
        Intrinsics.checkNotNullParameter(inAppMessageRedisplayStats0, "redisplayStats");
        Intrinsics.checkNotNullParameter(iTime0, "time");
        this(s, iTime0);
        this.clickedClickIds = CollectionsKt.toMutableSet(set0);
        this.isDisplayedInSession = z;
        this.redisplayStats = inAppMessageRedisplayStats0;
    }

    public InAppMessage(JSONObject jSONObject0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "json");
        Intrinsics.checkNotNullParameter(iTime0, "time");
        String s = jSONObject0.getString("id");
        Intrinsics.checkNotNullExpressionValue(s, "json.getString(ID)");
        this(s, iTime0);
        JSONObject jSONObject1 = jSONObject0.getJSONObject("variants");
        Intrinsics.checkNotNullExpressionValue(jSONObject1, "json.getJSONObject(IAM_VARIANTS)");
        this.variants = this.parseVariants(jSONObject1);
        JSONArray jSONArray0 = jSONObject0.getJSONArray("triggers");
        Intrinsics.checkNotNullExpressionValue(jSONArray0, "json.getJSONArray(IAM_TRIGGERS)");
        this.triggers = this.parseTriggerJson(jSONArray0);
        this.endTime = this.parseEndTimeJson(jSONObject0);
        if(jSONObject0.has("has_liquid")) {
            this.hasLiquid = jSONObject0.getBoolean("has_liquid");
        }
        if(jSONObject0.has("redisplay")) {
            JSONObject jSONObject2 = jSONObject0.getJSONObject("redisplay");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.getJSONObject(IAM_REDISPLAY_STATS)");
            this.redisplayStats = new InAppMessageRedisplayStats(jSONObject2, iTime0);
        }
    }

    public InAppMessage(boolean z, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iTime0, "time");
        this("", iTime0);
        this.isPreview = z;
    }

    public final void addClickId(String s) {
        Intrinsics.checkNotNullParameter(s, "clickId");
        this.clickedClickIds.add(s);
    }

    public final void clearClickIds() {
        this.clickedClickIds.clear();
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 == null || !Intrinsics.areEqual(this.getClass(), object0.getClass()) ? false : Intrinsics.areEqual(this.getMessageId(), ((InAppMessage)object0).getMessageId());
    }

    public final Set getClickedClickIds() {
        return this.clickedClickIds;
    }

    public final double getDisplayDuration() {
        return this.displayDuration;
    }

    public final boolean getHasLiquid() {
        return this.hasLiquid;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessage
    public String getMessageId() {
        return this.messageId;
    }

    public final InAppMessageRedisplayStats getRedisplayStats() {
        return this.redisplayStats;
    }

    public final List getTriggers() {
        return this.triggers;
    }

    public final Map getVariants() {
        return this.variants;
    }

    @Override
    public int hashCode() {
        return this.getMessageId().hashCode();
    }

    public final boolean isClickAvailable(String s) {
        Intrinsics.checkNotNullParameter(s, "clickId");
        return !this.clickedClickIds.contains(s);
    }

    public final boolean isDisplayedInSession() {
        return this.isDisplayedInSession;
    }

    public final boolean isFinished() {
        if(this.endTime == null) {
            return false;
        }
        Date date0 = new Date();
        Date date1 = this.endTime;
        Intrinsics.checkNotNull(date1);
        return date1.before(date0);
    }

    public final boolean isPreview() {
        return this.isPreview;
    }

    public final boolean isTriggerChanged() {
        return this.isTriggerChanged;
    }

    private final Date parseEndTimeJson(JSONObject jSONObject0) {
        String s;
        try {
            s = jSONObject0.getString("end_time");
            Intrinsics.checkNotNullExpressionValue(s, "{\n                json.g…g(END_TIME)\n            }");
        }
        catch(JSONException unused_ex) {
            return null;
        }
        if(Intrinsics.areEqual(s, "null")) {
            return null;
        }
        try {
            return DateUtils.INSTANCE.iso8601Format().parse(s);
        }
        catch(ParseException parseException0) {
            parseException0.printStackTrace();
        }
        return null;
    }

    private final ArrayList parseTriggerJson(JSONArray jSONArray0) throws JSONException {
        ArrayList arrayList0 = new ArrayList();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            JSONArray jSONArray1 = jSONArray0.getJSONArray(v1);
            ArrayList arrayList1 = new ArrayList();
            int v2 = jSONArray1.length();
            for(int v3 = 0; v3 < v2; ++v3) {
                JSONObject jSONObject0 = jSONArray1.getJSONObject(v3);
                Intrinsics.checkNotNullExpressionValue(jSONObject0, "ands.getJSONObject(j)");
                arrayList1.add(new Trigger(jSONObject0));
            }
            arrayList0.add(arrayList1);
        }
        return arrayList0;
    }

    private final HashMap parseVariants(JSONObject jSONObject0) throws JSONException {
        HashMap hashMap0 = new HashMap();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            JSONObject jSONObject1 = jSONObject0.getJSONObject(((String)object0));
            HashMap hashMap1 = new HashMap();
            Iterator iterator1 = jSONObject1.keys();
            while(iterator1.hasNext()) {
                Object object1 = iterator1.next();
                Intrinsics.checkNotNullExpressionValue(((String)object1), "languageType");
                String s = jSONObject1.getString(((String)object1));
                Intrinsics.checkNotNullExpressionValue(s, "variant.getString(languageType)");
                hashMap1.put(((String)object1), s);
            }
            Intrinsics.checkNotNullExpressionValue(((String)object0), "variantType");
            hashMap0.put(((String)object0), hashMap1);
        }
        return hashMap0;
    }

    public final void removeClickId(String s) {
        Intrinsics.checkNotNullParameter(s, "clickId");
        this.clickedClickIds.remove(s);
    }

    public final void setDisplayDuration(double f) {
        this.displayDuration = f;
    }

    public final void setDisplayedInSession(boolean z) {
        this.isDisplayedInSession = z;
    }

    public final void setTriggerChanged(boolean z) {
        this.isTriggerChanged = z;
    }

    public final boolean takeActionAsUnique() {
        if(this.actionTaken) {
            return false;
        }
        this.actionTaken = true;
        return true;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("messageId", this.getMessageId());
            JSONObject jSONObject1 = new JSONObject();
            for(Object object0: this.variants.keySet()) {
                Object object1 = this.variants.get(((String)object0));
                Intrinsics.checkNotNull(object1);
                Map map0 = (Map)object1;
                JSONObject jSONObject2 = new JSONObject();
                for(Object object2: map0.keySet()) {
                    jSONObject2.put(((String)object2), map0.get(((String)object2)));
                }
                jSONObject1.put(((String)object0), jSONObject2);
            }
            jSONObject0.put("variants", jSONObject1);
            jSONObject0.put("displayDuration", this.displayDuration);
            jSONObject0.put("redisplay", this.redisplayStats.toJSONObject());
            JSONArray jSONArray0 = new JSONArray();
            for(Object object3: this.triggers) {
                JSONArray jSONArray1 = new JSONArray();
                for(Object object4: ((List)object3)) {
                    jSONArray1.put(((Trigger)object4).toJSONObject());
                }
                jSONArray0.put(jSONArray1);
            }
            jSONObject0.put("triggers", jSONArray0);
            if(this.endTime != null) {
                jSONObject0.put("end_time", DateUtils.INSTANCE.iso8601Format().format(this.endTime));
            }
            jSONObject0.put("has_liquid", this.hasLiquid);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OSInAppMessage{messageId=\'" + this.getMessageId() + "\', variants=" + this.variants + ", triggers=" + this.triggers + ", clickedClickIds=" + this.clickedClickIds + ", redisplayStats=" + this.redisplayStats + ", displayDuration=" + this.displayDuration + ", displayedInSession=" + this.isDisplayedInSession + ", triggerChanged=" + this.isTriggerChanged + ", actionTaken=" + this.actionTaken + ", isPreview=" + this.isPreview + ", endTime=" + this.endTime + ", hasLiquid=" + this.hasLiquid + '}';
    }
}

