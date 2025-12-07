package com.onesignal.inAppMessages.internal.hydrators;

import com.onesignal.common.modeling.MapModel;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\nJ\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000E\u001A\u00020\u000FJ\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/inAppMessages/internal/hydrators/InAppHydrator;", "", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "(Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/user/internal/properties/PropertiesModelStore;)V", "hydrateIAMMessageContent", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "jsonObject", "Lorg/json/JSONObject;", "hydrateIAMMessages", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "jsonArray", "Lorg/json/JSONArray;", "taggedHTMLString", "", "untaggedString", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppHydrator {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/inAppMessages/internal/hydrators/InAppHydrator$Companion;", "", "()V", "LIQUID_TAG_SCRIPT", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String LIQUID_TAG_SCRIPT = "\n\n<script>\n    setPlayerTags(%s);\n</script>";
    private final PropertiesModelStore _propertiesModelStore;
    private final ITime _time;

    static {
        InAppHydrator.Companion = new Companion(null);
    }

    public InAppHydrator(ITime iTime0, PropertiesModelStore propertiesModelStore0) {
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        super();
        this._time = iTime0;
        this._propertiesModelStore = propertiesModelStore0;
    }

    public final InAppMessageContent hydrateIAMMessageContent(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        try {
            InAppMessageContent inAppMessageContent0 = new InAppMessageContent(jSONObject0);
            if(inAppMessageContent0.getContentHtml() == null) {
                Logging.debug$default("displayMessage:OnSuccess: No HTML retrieved from loadMessageContent", null, 2, null);
                return null;
            }
            String s = inAppMessageContent0.getContentHtml();
            Intrinsics.checkNotNull(s);
            inAppMessageContent0.setContentHtml(this.taggedHTMLString(s));
            return inAppMessageContent0;
        }
        catch(JSONException jSONException0) {
            Logging.error(("Error attempting to hydrate InAppMessageContent: " + jSONObject0), jSONException0);
            return null;
        }
    }

    public final List hydrateIAMMessages(JSONArray jSONArray0) {
        Intrinsics.checkNotNullParameter(jSONArray0, "jsonArray");
        ArrayList arrayList0 = new ArrayList();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            JSONObject jSONObject0 = jSONArray0.getJSONObject(v1);
            Intrinsics.checkNotNullExpressionValue(jSONObject0, "jsonArray.getJSONObject(i)");
            InAppMessage inAppMessage0 = new InAppMessage(jSONObject0, this._time);
            if(inAppMessage0.getMessageId() != null) {
                arrayList0.add(inAppMessage0);
            }
        }
        return arrayList0;
    }

    private final String taggedHTMLString(String s) {
        MapModel mapModel0 = ((PropertiesModel)this._propertiesModelStore.getModel()).getTags();
        Intrinsics.checkNotNull(mapModel0, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        String s1 = new JSONObject(mapModel0).toString();
        Intrinsics.checkNotNullExpressionValue(s1, "tagsAsJson.toString()");
        String s2 = String.format("\n\n<script>\n    setPlayerTags(%s);\n</script>", Arrays.copyOf(new Object[]{s1}, 1));
        Intrinsics.checkNotNullExpressionValue(s2, "format(format, *args)");
        return s + s2;
    }
}

