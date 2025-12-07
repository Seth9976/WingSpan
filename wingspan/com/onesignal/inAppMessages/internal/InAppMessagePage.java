package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\b\u0010\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000E\u001A\u00020\u0003R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001C\u0010\u000B\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "pageId", "", "getPageId", "()Ljava/lang/String;", "setPageId", "(Ljava/lang/String;)V", "pageIndex", "getPageIndex", "setPageIndex", "toJSONObject", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class InAppMessagePage {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessagePage$Companion;", "", "()V", "PAGE_ID", "", "PAGE_INDEX", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    public static final String PAGE_ID = "pageId";
    public static final String PAGE_INDEX = "pageIndex";
    private String pageId;
    private String pageIndex;

    static {
        InAppMessagePage.Companion = new Companion(null);
    }

    public InAppMessagePage(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        super();
        this.pageId = jSONObject0.optString("pageId", null);
        this.pageIndex = jSONObject0.optString("pageIndex", null);
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageIndex() {
        return this.pageIndex;
    }

    public final void setPageId(String s) {
        this.pageId = s;
    }

    public final void setPageIndex(String s) {
        this.pageIndex = s;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("pageId", this.pageId);
            jSONObject0.put("pageIndex", this.pageIndex);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }
}

