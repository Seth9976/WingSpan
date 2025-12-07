package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessageClickResult;
import com.onesignal.inAppMessages.InAppMessageActionUrlType;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010,\u001A\u00020-2\u0006\u0010\u0002\u001A\u00020\u0003H\u0002J\u0018\u0010.\u001A\u00020-2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0002J\u0006\u0010/\u001A\u00020\u0003R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u000B\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0014\u0010\r\u001A\u00020\u000EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\nR\u0017\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001C0\u0015¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0018R\u001C\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010$\u001A\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\nR\u001C\u0010&\u001A\u0004\u0018\u00010\'X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "Lcom/onesignal/inAppMessages/IInAppMessageClickResult;", "json", "Lorg/json/JSONObject;", "promptFactory", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "(Lorg/json/JSONObject;Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;)V", "actionId", "", "getActionId", "()Ljava/lang/String;", "clickId", "getClickId", "closingMessage", "", "getClosingMessage", "()Z", "isFirstClick", "setFirstClick", "(Z)V", "outcomes", "", "Lcom/onesignal/inAppMessages/internal/InAppMessageOutcome;", "getOutcomes", "()Ljava/util/List;", "pageId", "getPageId", "prompts", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "getPrompts", "tags", "Lcom/onesignal/inAppMessages/internal/InAppMessageTag;", "getTags", "()Lcom/onesignal/inAppMessages/internal/InAppMessageTag;", "setTags", "(Lcom/onesignal/inAppMessages/internal/InAppMessageTag;)V", "url", "getUrl", "urlTarget", "Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;", "getUrlTarget", "()Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;", "setUrlTarget", "(Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;)V", "parseOutcomes", "", "parsePrompts", "toJSONObject", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessageClickResult implements IInAppMessageClickResult {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult$Companion;", "", "()V", "CLICK_NAME", "", "CLICK_URL", "CLOSE", "CLOSES_MESSAGE", "FIRST_CLICK", "ID", "NAME", "OUTCOMES", "PAGE_ID", "PROMPTS", "TAGS", "URL", "URL_TARGET", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String CLICK_NAME = "click_name";
    private static final String CLICK_URL = "click_url";
    private static final String CLOSE = "close";
    private static final String CLOSES_MESSAGE = "closes_message";
    public static final Companion Companion = null;
    private static final String FIRST_CLICK = "first_click";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String OUTCOMES = "outcomes";
    private static final String PAGE_ID = "pageId";
    private static final String PROMPTS = "prompts";
    private static final String TAGS = "tags";
    private static final String URL = "url";
    private static final String URL_TARGET = "url_target";
    private final String actionId;
    private final String clickId;
    private final boolean closingMessage;
    private boolean isFirstClick;
    private final List outcomes;
    private final String pageId;
    private final List prompts;
    private InAppMessageTag tags;
    private final String url;
    private InAppMessageActionUrlType urlTarget;

    static {
        InAppMessageClickResult.Companion = new Companion(null);
    }

    public InAppMessageClickResult(JSONObject jSONObject0, IInAppMessagePromptFactory iInAppMessagePromptFactory0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "json");
        Intrinsics.checkNotNullParameter(iInAppMessagePromptFactory0, "promptFactory");
        super();
        this.outcomes = new ArrayList();
        this.prompts = new ArrayList();
        this.clickId = jSONObject0.optString("id", null);
        this.actionId = jSONObject0.optString("name", null);
        this.url = jSONObject0.optString("url", null);
        this.pageId = jSONObject0.optString("pageId", null);
        String s = jSONObject0.optString("url_target", null);
        this.setUrlTarget(InAppMessageActionUrlType.Companion.fromString(s));
        if(this.getUrlTarget() == null) {
            this.setUrlTarget(InAppMessageActionUrlType.IN_APP_WEBVIEW);
        }
        this.closingMessage = jSONObject0.optBoolean("close", true);
        if(jSONObject0.has("outcomes")) {
            this.parseOutcomes(jSONObject0);
        }
        if(jSONObject0.has("tags")) {
            JSONObject jSONObject1 = jSONObject0.getJSONObject("tags");
            Intrinsics.checkNotNullExpressionValue(jSONObject1, "json.getJSONObject(TAGS)");
            this.tags = new InAppMessageTag(jSONObject1);
        }
        if(jSONObject0.has("prompts")) {
            this.parsePrompts(jSONObject0, iInAppMessagePromptFactory0);
        }
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessageClickResult
    public String getActionId() {
        return this.actionId;
    }

    public final String getClickId() {
        return this.clickId;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessageClickResult
    public boolean getClosingMessage() {
        return this.closingMessage;
    }

    public final List getOutcomes() {
        return this.outcomes;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final List getPrompts() {
        return this.prompts;
    }

    public final InAppMessageTag getTags() {
        return this.tags;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessageClickResult
    public String getUrl() {
        return this.url;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessageClickResult
    public InAppMessageActionUrlType getUrlTarget() {
        return this.urlTarget;
    }

    public final boolean isFirstClick() {
        return this.isFirstClick;
    }

    private final void parseOutcomes(JSONObject jSONObject0) throws JSONException {
        JSONArray jSONArray0 = jSONObject0.getJSONArray("outcomes");
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = jSONArray0.get(v1);
            Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type org.json.JSONObject");
            InAppMessageOutcome inAppMessageOutcome0 = new InAppMessageOutcome(((JSONObject)object0));
            this.outcomes.add(inAppMessageOutcome0);
        }
    }

    private final void parsePrompts(JSONObject jSONObject0, IInAppMessagePromptFactory iInAppMessagePromptFactory0) throws JSONException {
        JSONArray jSONArray0 = jSONObject0.getJSONArray("prompts");
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = jSONArray0.getString(v1);
            Intrinsics.checkNotNullExpressionValue(s, "promptType");
            InAppMessagePrompt inAppMessagePrompt0 = iInAppMessagePromptFactory0.createPrompt(s);
            if(inAppMessagePrompt0 != null) {
                this.prompts.add(inAppMessagePrompt0);
            }
        }
    }

    public final void setFirstClick(boolean z) {
        this.isFirstClick = z;
    }

    public final void setTags(InAppMessageTag inAppMessageTag0) {
        this.tags = inAppMessageTag0;
    }

    public void setUrlTarget(InAppMessageActionUrlType inAppMessageActionUrlType0) {
        this.urlTarget = inAppMessageActionUrlType0;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("click_name", this.getActionId());
            jSONObject0.put("click_url", this.getUrl());
            jSONObject0.put("first_click", this.isFirstClick);
            jSONObject0.put("closes_message", this.getClosingMessage());
            JSONArray jSONArray0 = new JSONArray();
            for(Object object0: this.outcomes) {
                jSONArray0.put(((InAppMessageOutcome)object0).toJSONObject());
            }
            jSONObject0.put("outcomes", jSONArray0);
            InAppMessageTag inAppMessageTag0 = this.tags;
            if(inAppMessageTag0 != null) {
                Intrinsics.checkNotNull(inAppMessageTag0);
                jSONObject0.put("tags", inAppMessageTag0.toJSONObject());
            }
            if(this.getUrlTarget() != null) {
                jSONObject0.put("url_target", String.valueOf(this.getUrlTarget()));
                return jSONObject0;
            }
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }
}

