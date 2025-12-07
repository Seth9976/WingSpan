package com.onesignal.inAppMessages.internal;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager.Position;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0010\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001E\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0011\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001C\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\u00020\u001EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u001A\u0010#\u001A\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u001A\"\u0004\b%\u0010\u001CR\u001A\u0010&\u001A\u00020\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010\u001A\"\u0004\b(\u0010\u001C¨\u0006*"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "contentHtml", "", "getContentHtml", "()Ljava/lang/String;", "setContentHtml", "(Ljava/lang/String;)V", "displayDuration", "", "getDisplayDuration", "()Ljava/lang/Double;", "setDisplayDuration", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "displayLocation", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "getDisplayLocation", "()Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "setDisplayLocation", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;)V", "isFullBleed", "", "()Z", "setFullBleed", "(Z)V", "pageHeight", "", "getPageHeight", "()I", "setPageHeight", "(I)V", "useHeightMargin", "getUseHeightMargin", "setUseHeightMargin", "useWidthMargin", "getUseWidthMargin", "setUseWidthMargin", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class InAppMessageContent {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageContent$Companion;", "", "()V", "DISPLAY_DURATION", "", "HTML", "REMOVE_HEIGHT_MARGIN", "REMOVE_WIDTH_MARGIN", "STYLES", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    public static final String DISPLAY_DURATION = "display_duration";
    public static final String HTML = "html";
    public static final String REMOVE_HEIGHT_MARGIN = "remove_height_margin";
    public static final String REMOVE_WIDTH_MARGIN = "remove_width_margin";
    public static final String STYLES = "styles";
    private String contentHtml;
    private Double displayDuration;
    private Position displayLocation;
    private boolean isFullBleed;
    private int pageHeight;
    private boolean useHeightMargin;
    private boolean useWidthMargin;

    static {
        InAppMessageContent.Companion = new Companion(null);
    }

    public InAppMessageContent(JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        boolean z;
        super();
        this.useHeightMargin = true;
        this.useWidthMargin = true;
        this.contentHtml = JSONObjectExtensionsKt.safeString(jSONObject0, "html");
        this.displayDuration = JSONObjectExtensionsKt.safeDouble(jSONObject0, "display_duration");
        JSONObject jSONObject1 = JSONObjectExtensionsKt.safeJSONObject(jSONObject0, "styles");
        int v = 0;
        if(jSONObject1 == null) {
            z = false;
        }
        else {
            Boolean boolean0 = JSONObjectExtensionsKt.safeBool(jSONObject1, "remove_height_margin");
            z = boolean0 == null ? false : boolean0.booleanValue();
        }
        this.useHeightMargin = !z;
        if(jSONObject1 != null) {
            Boolean boolean1 = JSONObjectExtensionsKt.safeBool(jSONObject1, "remove_width_margin");
            if(boolean1 != null) {
                v = boolean1.booleanValue();
            }
        }
        this.useWidthMargin = v ^ 1;
        this.isFullBleed = !this.useHeightMargin;
    }

    public final String getContentHtml() {
        return this.contentHtml;
    }

    public final Double getDisplayDuration() {
        return this.displayDuration;
    }

    public final Position getDisplayLocation() {
        return this.displayLocation;
    }

    public final int getPageHeight() {
        return this.pageHeight;
    }

    public final boolean getUseHeightMargin() {
        return this.useHeightMargin;
    }

    public final boolean getUseWidthMargin() {
        return this.useWidthMargin;
    }

    public final boolean isFullBleed() {
        return this.isFullBleed;
    }

    public final void setContentHtml(String s) {
        this.contentHtml = s;
    }

    public final void setDisplayDuration(Double double0) {
        this.displayDuration = double0;
    }

    public final void setDisplayLocation(Position webViewManager$Position0) {
        this.displayLocation = webViewManager$Position0;
    }

    public final void setFullBleed(boolean z) {
        this.isFullBleed = z;
    }

    public final void setPageHeight(int v) {
        this.pageHeight = v;
    }

    public final void setUseHeightMargin(boolean z) {
        this.useHeightMargin = z;
    }

    public final void setUseWidthMargin(boolean z) {
        this.useWidthMargin = z;
    }
}

