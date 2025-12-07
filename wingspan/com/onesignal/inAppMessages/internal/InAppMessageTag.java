package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000F\u001A\u00020\u0003J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageTag;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "tagsToAdd", "getTagsToAdd", "()Lorg/json/JSONObject;", "setTagsToAdd", "tagsToRemove", "Lorg/json/JSONArray;", "getTagsToRemove", "()Lorg/json/JSONArray;", "setTagsToRemove", "(Lorg/json/JSONArray;)V", "toJSONObject", "toString", "", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessageTag {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageTag$Companion;", "", "()V", "ADD_TAGS", "", "REMOVE_TAGS", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String ADD_TAGS = "adds";
    public static final Companion Companion = null;
    private static final String REMOVE_TAGS = "removes";
    private JSONObject tagsToAdd;
    private JSONArray tagsToRemove;

    static {
        InAppMessageTag.Companion = new Companion(null);
    }

    public InAppMessageTag(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "json");
        super();
        JSONArray jSONArray0 = null;
        this.tagsToAdd = jSONObject0.has("adds") ? jSONObject0.getJSONObject("adds") : null;
        if(jSONObject0.has("removes")) {
            jSONArray0 = jSONObject0.getJSONArray("removes");
        }
        this.tagsToRemove = jSONArray0;
    }

    public final JSONObject getTagsToAdd() {
        return this.tagsToAdd;
    }

    public final JSONArray getTagsToRemove() {
        return this.tagsToRemove;
    }

    public final void setTagsToAdd(JSONObject jSONObject0) {
        this.tagsToAdd = jSONObject0;
    }

    public final void setTagsToRemove(JSONArray jSONArray0) {
        this.tagsToRemove = jSONArray0;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            JSONObject jSONObject1 = this.tagsToAdd;
            if(jSONObject1 != null) {
                jSONObject0.put("adds", jSONObject1);
            }
            JSONArray jSONArray0 = this.tagsToRemove;
            if(jSONArray0 != null) {
                jSONObject0.put("removes", jSONArray0);
                return jSONObject0;
            }
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OSInAppMessageTag{adds=" + this.tagsToAdd + ", removes=" + this.tagsToRemove + '}';
    }
}

