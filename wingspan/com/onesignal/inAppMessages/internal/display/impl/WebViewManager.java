package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.ViewUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0001\u0018\u0000 <2\u00020\u0001:\u0003<=>B5\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u00A2\u0006\u0002\u0010\u000EJ\u0006\u0010\u001D\u001A\u00020\u001EJ\u0010\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001B\u001A\u00020 H\u0002J\u0011\u0010!\u001A\u00020\u001EH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\"J\u000E\u0010#\u001A\u00020\u001E2\u0006\u0010$\u001A\u00020\u0010J\u0011\u0010%\u001A\u00020\u001EH\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\"J\b\u0010&\u001A\u00020\u001EH\u0002J\u0010\u0010\'\u001A\u00020\u00152\u0006\u0010\u0004\u001A\u00020\u0005H\u0002J\u0010\u0010(\u001A\u00020\u00152\u0006\u0010\u0004\u001A\u00020\u0005H\u0002J\u0010\u0010)\u001A\u00020\u001E2\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0010\u0010*\u001A\u00020\u001E2\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u0018\u0010+\u001A\u00020\u00152\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010,\u001A\u00020-H\u0002J\u0016\u0010.\u001A\u00020\u001E2\u0006\u0010/\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0005J\u0012\u00100\u001A\u00020\u001E2\b\u00101\u001A\u0004\u0018\u00010\u0018H\u0002J\u0010\u00102\u001A\u00020\u001E2\u0006\u0010\u0004\u001A\u00020\u0005H\u0002J)\u00103\u001A\u00020\u001E2\u0006\u00104\u001A\u00020\u00052\u0006\u00105\u001A\u00020\u00122\u0006\u00106\u001A\u00020\u0010H\u0087@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00107J\u001B\u00108\u001A\u00020\u001E2\b\u00109\u001A\u0004\u0018\u00010\u0015H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010:J\u0011\u0010;\u001A\u00020\u001EH\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\"R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0010X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E\u00A2\u0006\u0004\n\u0002\u0010\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0082\u000E\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006?"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "activity", "Landroid/app/Activity;", "messageContent", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_promptFactory", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Landroid/app/Activity;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;)V", "closing", "", "currentActivityName", "", "dismissFired", "lastPageHeight", "", "Ljava/lang/Integer;", "messageView", "Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView;", "messageViewMutex", "Lkotlinx/coroutines/sync/Mutex;", "webView", "Lcom/onesignal/inAppMessages/internal/display/impl/OSWebView;", "backgroundDismissAndAwaitNextMessage", "", "blurryRenderingWebViewForKitKatWorkAround", "Landroid/webkit/WebView;", "calculateHeightAndShowWebViewAfterNewActivity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNewInAppMessageView", "dragToDismissDisabled", "dismissAndAwaitNextMessage", "enableWebViewRemoteDebugging", "getWebViewMaxSizeX", "getWebViewMaxSizeY", "onActivityAvailable", "onActivityStopped", "pageRectToViewHeight", "jsonObject", "Lorg/json/JSONObject;", "setContentSafeAreaInsets", "content", "setMessageView", "view", "setWebViewToMaxSize", "setupWebView", "currentActivity", "base64Message", "isFullScreen", "(Landroid/app/Activity;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMessageView", "newHeight", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSafeAreaInsets", "Companion", "OSJavaScriptInterface", "Position", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class WebViewManager implements IActivityLifecycleHandler {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Companion;", "", "()V", "EVENT_TYPE_ACTION_TAKEN", "", "EVENT_TYPE_KEY", "EVENT_TYPE_PAGE_CHANGE", "EVENT_TYPE_RENDERING_COMPLETE", "EVENT_TYPE_RESIZE", "GET_PAGE_META_DATA_JS_FUNCTION", "IAM_DISPLAY_LOCATION_KEY", "IAM_DRAG_TO_DISMISS_DISABLED_KEY", "IAM_PAGE_META_DATA_KEY", "JS_OBJ_NAME", "MARGIN_PX_SIZE", "", "SAFE_AREA_JS_OBJECT", "SET_SAFE_AREA_INSETS_JS_FUNCTION", "SET_SAFE_AREA_INSETS_SCRIPT", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\u000E\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$OSJavaScriptInterface;", "", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;)V", "getDisplayLocation", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "jsonObject", "Lorg/json/JSONObject;", "getDragToDismissDisabled", "", "getPageHeightData", "", "handleActionTaken", "", "handlePageChange", "handleRenderComplete", "postMessage", "message", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public final class OSJavaScriptInterface {
        private final Position getDisplayLocation(JSONObject jSONObject0) {
            Position webViewManager$Position0;
            try {
                webViewManager$Position0 = Position.FULL_SCREEN;
                if(jSONObject0.has("displayLocation") && !Intrinsics.areEqual(jSONObject0.get("displayLocation"), "")) {
                    String s = jSONObject0.optString("displayLocation", "FULL_SCREEN");
                    Intrinsics.checkNotNullExpressionValue(s, "jsonObject.optString(\n  …                        )");
                    Locale locale0 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale0, "getDefault()");
                    String s1 = s.toUpperCase(locale0);
                    Intrinsics.checkNotNullExpressionValue(s1, "this as java.lang.String).toUpperCase(locale)");
                    return Position.valueOf(s1);
                }
            }
            catch(JSONException jSONException0) {
                jSONException0.printStackTrace();
            }
            return webViewManager$Position0;
        }

        private final boolean getDragToDismissDisabled(JSONObject jSONObject0) {
            try {
                return jSONObject0.getBoolean("dragToDismissDisabled");
            }
            catch(JSONException unused_ex) {
                return false;
            }
        }

        private final int getPageHeightData(JSONObject jSONObject0) {
            try {
                JSONObject jSONObject1 = jSONObject0.getJSONObject("pageMetaData");
                Intrinsics.checkNotNullExpressionValue(jSONObject1, "jsonObject.getJSONObject(IAM_PAGE_META_DATA_KEY)");
                return WebViewManager.this.pageRectToViewHeight(WebViewManager.this.activity, jSONObject1);
            }
            catch(JSONException unused_ex) {
                return -1;
            }
        }

        private final void handleActionTaken(JSONObject jSONObject0) throws JSONException {
            JSONObject jSONObject1 = jSONObject0.getJSONObject("body");
            Intrinsics.checkNotNullExpressionValue(jSONObject1, "body");
            String s = JSONObjectExtensionsKt.safeString(jSONObject1, "id");
            boolean z = jSONObject1.getBoolean("close");
            WebViewManager.this.closing = z;
            if(WebViewManager.this.message.isPreview()) {
                InAppMessageClickResult inAppMessageClickResult0 = new InAppMessageClickResult(jSONObject1, WebViewManager.this._promptFactory);
                WebViewManager.this._lifecycle.messageActionOccurredOnPreview(WebViewManager.this.message, inAppMessageClickResult0);
            }
            else if(s != null) {
                InAppMessageClickResult inAppMessageClickResult1 = new InAppMessageClickResult(jSONObject1, WebViewManager.this._promptFactory);
                WebViewManager.this._lifecycle.messageActionOccurredOnMessage(WebViewManager.this.message, inAppMessageClickResult1);
            }
            if(WebViewManager.this.closing) {
                WebViewManager.this.backgroundDismissAndAwaitNextMessage();
            }
        }

        private final void handlePageChange(JSONObject jSONObject0) throws JSONException {
            InAppMessagePage inAppMessagePage0 = new InAppMessagePage(jSONObject0);
            WebViewManager.this._lifecycle.messagePageChanged(WebViewManager.this.message, inAppMessagePage0);
        }

        private final void handleRenderComplete(JSONObject jSONObject0) {
            Position webViewManager$Position0 = this.getDisplayLocation(jSONObject0);
            int v = webViewManager$Position0 == Position.FULL_SCREEN ? -1 : this.getPageHeightData(jSONObject0);
            boolean z = this.getDragToDismissDisabled(jSONObject0);
            WebViewManager.this.messageContent.setDisplayLocation(webViewManager$Position0);
            WebViewManager.this.messageContent.setPageHeight(v);
            WebViewManager.this.createNewInAppMessageView(z);
        }

        @JavascriptInterface
        public final void postMessage(String s) {
            Intrinsics.checkNotNullParameter(s, "message");
            try {
                Logging.debug$default(("OSJavaScriptInterface:postMessage: " + s), null, 2, null);
                JSONObject jSONObject0 = new JSONObject(s);
                String s1 = jSONObject0.getString("type");
                if(s1 != null) {
                    switch(s1) {
                        case "action_taken": {
                            InAppMessageView inAppMessageView0 = WebViewManager.this.messageView;
                            if(inAppMessageView0 != null && !inAppMessageView0.isDragging()) {
                                this.handleActionTaken(jSONObject0);
                                return;
                            }
                            break;
                        }
                        case "page_change": {
                            this.handlePageChange(jSONObject0);
                            return;
                        }
                        case "rendering_complete": {
                            this.handleRenderComplete(jSONObject0);
                        }
                    }
                }
            }
            catch(JSONException jSONException0) {
                jSONException0.printStackTrace();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "", "(Ljava/lang/String;I)V", "isBanner", "", "()Z", "TOP_BANNER", "BOTTOM_BANNER", "CENTER_MODAL", "FULL_SCREEN", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static enum Position {
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[Position.values().length];
                arr_v[Position.TOP_BANNER.ordinal()] = 1;
                arr_v[Position.BOTTOM_BANNER.ordinal()] = 2;
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        private static final Position[] $values() [...] // Inlined contents

        public final boolean isBanner() {
            switch(WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
                case 1: 
                case 2: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
    }

    public static final Companion Companion = null;
    public static final String EVENT_TYPE_ACTION_TAKEN = "action_taken";
    public static final String EVENT_TYPE_KEY = "type";
    public static final String EVENT_TYPE_PAGE_CHANGE = "page_change";
    public static final String EVENT_TYPE_RENDERING_COMPLETE = "rendering_complete";
    public static final String EVENT_TYPE_RESIZE = "resize";
    public static final String GET_PAGE_META_DATA_JS_FUNCTION = "getPageMetaData()";
    public static final String IAM_DISPLAY_LOCATION_KEY = "displayLocation";
    public static final String IAM_DRAG_TO_DISMISS_DISABLED_KEY = "dragToDismissDisabled";
    public static final String IAM_PAGE_META_DATA_KEY = "pageMetaData";
    public static final String JS_OBJ_NAME = "OSAndroid";
    private static final int MARGIN_PX_SIZE = 0;
    public static final String SAFE_AREA_JS_OBJECT = "{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}";
    public static final String SET_SAFE_AREA_INSETS_JS_FUNCTION = "setSafeAreaInsets(%s)";
    public static final String SET_SAFE_AREA_INSETS_SCRIPT = "\n\n<script>\n    setSafeAreaInsets(%s);\n</script>";
    private final IApplicationService _applicationService;
    private final IInAppLifecycleService _lifecycle;
    private final IInAppMessagePromptFactory _promptFactory;
    private Activity activity;
    private boolean closing;
    private String currentActivityName;
    private boolean dismissFired;
    private Integer lastPageHeight;
    private final InAppMessage message;
    private final InAppMessageContent messageContent;
    private InAppMessageView messageView;
    private final Mutex messageViewMutex;
    private OSWebView webView;

    // 检测为 Lambda 实现
    public static void $r8$lambda$N-KbBTfmSF_aTHp9-tTNnU4O4B8(WebViewManager webViewManager0, String s) [...]

    static {
        WebViewManager.Companion = new Companion(null);
        WebViewManager.MARGIN_PX_SIZE = ViewUtils.INSTANCE.dpToPx(24);
    }

    public WebViewManager(InAppMessage inAppMessage0, Activity activity0, InAppMessageContent inAppMessageContent0, IInAppLifecycleService iInAppLifecycleService0, IApplicationService iApplicationService0, IInAppMessagePromptFactory iInAppMessagePromptFactory0) {
        Intrinsics.checkNotNullParameter(inAppMessage0, "message");
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageContent0, "messageContent");
        Intrinsics.checkNotNullParameter(iInAppLifecycleService0, "_lifecycle");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iInAppMessagePromptFactory0, "_promptFactory");
        super();
        this.message = inAppMessage0;
        this.activity = activity0;
        this.messageContent = inAppMessageContent0;
        this._lifecycle = iInAppLifecycleService0;
        this._applicationService = iApplicationService0;
        this._promptFactory = iInAppMessagePromptFactory0;
        this.messageViewMutex = MutexKt.Mutex$default(false, 1, null);
    }

    public static final Object access$updateSafeAreaInsets(WebViewManager webViewManager0, Continuation continuation0) {
        return webViewManager0.updateSafeAreaInsets(continuation0);
    }

    public final void backgroundDismissAndAwaitNextMessage() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
            int label;

            {
                WebViewManager.this = webViewManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.display.impl.WebViewManager.backgroundDismissAndAwaitNextMessage.1(WebViewManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.display.impl.WebViewManager.backgroundDismissAndAwaitNextMessage.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return WebViewManager.this.dismissAndAwaitNextMessage(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    private final void blurryRenderingWebViewForKitKatWorkAround(WebView webView0) {
    }

    private final Object calculateHeightAndShowWebViewAfterNewActivity(Continuation continuation0) {
        WebViewManager webViewManager0;
        com.onesignal.inAppMessages.internal.display.impl.WebViewManager.calculateHeightAndShowWebViewAfterNewActivity.1 webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager.calculateHeightAndShowWebViewAfterNewActivity.1) {
            webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager.calculateHeightAndShowWebViewAfterNewActivity.1)continuation0;
            if((webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.label & 0x80000000) == 0) {
                webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.calculateHeightAndShowWebViewAfterNewActivity(this);
                    }
                };
            }
            else {
                webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.label ^= 0x80000000;
            }
        }
        else {
            webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.calculateHeightAndShowWebViewAfterNewActivity(this);
                }
            };
        }
        Object object0 = webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                InAppMessageView inAppMessageView0 = this.messageView;
                if(inAppMessageView0 == null) {
                    return Unit.INSTANCE;
                }
                Intrinsics.checkNotNull(inAppMessageView0);
                if(inAppMessageView0.getDisplayPosition() == Position.FULL_SCREEN && !this.messageContent.isFullBleed()) {
                    webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.label = 1;
                    return this.showMessageView(null, webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10) == object1 ? object1 : Unit.INSTANCE;
                }
                Logging.debug$default("In app message new activity, calculate height and show ", null, 2, null);
                webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.L$0 = this;
                webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.label = 2;
                if(this._applicationService.waitUntilActivityReady(webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10) == object1) {
                    return object1;
                }
                webViewManager0 = this;
                goto label_33;
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                return Unit.INSTANCE;
            }
            case 2: {
                webViewManager0 = (WebViewManager)webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_33:
                webViewManager0.setWebViewToMaxSize(webViewManager0.activity);
                if(webViewManager0.messageContent.isFullBleed()) {
                    webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.L$0 = webViewManager0;
                    webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.label = 3;
                    if(webViewManager0.updateSafeAreaInsets(webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10) == object1) {
                        return object1;
                    }
                }
                break;
            }
            case 3: {
                WebViewManager webViewManager1 = (WebViewManager)webViewManager$calculateHeightAndShowWebViewAfterNewActivity$10.L$0;
                ResultKt.throwOnFailure(object0);
                webViewManager0 = webViewManager1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        OSWebView oSWebView0 = webViewManager0.webView;
        Intrinsics.checkNotNull(oSWebView0);
        oSWebView0.evaluateJavascript("getPageMetaData()", (String s) -> WebViewManager.calculateHeightAndShowWebViewAfterNewActivity$lambda-0(webViewManager0, s));
        return Unit.INSTANCE;
    }

    private static final void calculateHeightAndShowWebViewAfterNewActivity$lambda-0(WebViewManager webViewManager0, String s) {
        Intrinsics.checkNotNullParameter(webViewManager0, "this$0");
        try {
            ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(webViewManager0, webViewManager0.pageRectToViewHeight(webViewManager0.activity, new JSONObject(s)), null) {
                final int $pagePxHeight;
                int label;

                {
                    WebViewManager.this = webViewManager0;
                    this.$pagePxHeight = v;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.inAppMessages.internal.display.impl.WebViewManager.calculateHeightAndShowWebViewAfterNewActivity.2.1(WebViewManager.this, this.$pagePxHeight, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.inAppMessages.internal.display.impl.WebViewManager.calculateHeightAndShowWebViewAfterNewActivity.2.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            this.label = 1;
                            return WebViewManager.this.showMessageView(Boxing.boxInt(this.$pagePxHeight), this) == object1 ? object1 : Unit.INSTANCE;
                        }
                        case 1: {
                            ResultKt.throwOnFailure(object0);
                            return Unit.INSTANCE;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            }, 1, null);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
    }

    public final void createNewInAppMessageView(boolean z) {
        this.lastPageHeight = this.messageContent.getPageHeight();
        Context context0 = this._applicationService.getAppContext();
        boolean z1 = AndroidUtils.INSTANCE.getManifestMetaBoolean(context0, "com.onesignal.inAppMessageHideGrayOverlay");
        OSWebView oSWebView0 = this.webView;
        Intrinsics.checkNotNull(oSWebView0);
        this.setMessageView(new InAppMessageView(oSWebView0, this.messageContent, z, z1));
        InAppMessageView inAppMessageView0 = this.messageView;
        Intrinsics.checkNotNull(inAppMessageView0);
        inAppMessageView0.setMessageController(new InAppMessageViewListener() {
            @Override  // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$InAppMessageViewListener
            public void onMessageWasDismissed() {
                this._lifecycle.messageWasDismissed(this.message);
                this._applicationService.removeActivityLifecycleHandler(this.$self);
            }

            @Override  // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$InAppMessageViewListener
            public void onMessageWasDisplayed() {
                this._lifecycle.messageWasDisplayed(this.message);
            }

            @Override  // com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$InAppMessageViewListener
            public void onMessageWillDismiss() {
                this._lifecycle.messageWillDismiss(this.message);
            }
        });
        this._applicationService.addActivityLifecycleHandler(this);
    }

    public final Object dismissAndAwaitNextMessage(Continuation continuation0) {
        WebViewManager webViewManager0;
        com.onesignal.inAppMessages.internal.display.impl.WebViewManager.dismissAndAwaitNextMessage.1 webViewManager$dismissAndAwaitNextMessage$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager.dismissAndAwaitNextMessage.1) {
            webViewManager$dismissAndAwaitNextMessage$10 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager.dismissAndAwaitNextMessage.1)continuation0;
            if((webViewManager$dismissAndAwaitNextMessage$10.label & 0x80000000) == 0) {
                webViewManager$dismissAndAwaitNextMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.dismissAndAwaitNextMessage(this);
                    }
                };
            }
            else {
                webViewManager$dismissAndAwaitNextMessage$10.label ^= 0x80000000;
            }
        }
        else {
            webViewManager$dismissAndAwaitNextMessage$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.dismissAndAwaitNextMessage(this);
                }
            };
        }
        Object object0 = webViewManager$dismissAndAwaitNextMessage$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(webViewManager$dismissAndAwaitNextMessage$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                InAppMessageView inAppMessageView0 = this.messageView;
                if(inAppMessageView0 != null && !this.dismissFired) {
                    this.dismissFired = true;
                    this._lifecycle.messageWillDismiss(this.message);
                    webViewManager$dismissAndAwaitNextMessage$10.L$0 = this;
                    webViewManager$dismissAndAwaitNextMessage$10.label = 1;
                    if(inAppMessageView0.dismissAndAwaitNextMessage(webViewManager$dismissAndAwaitNextMessage$10) == object1) {
                        return object1;
                    }
                    webViewManager0 = this;
                    break;
                }
                return Unit.INSTANCE;
            }
            case 1: {
                webViewManager0 = (WebViewManager)webViewManager$dismissAndAwaitNextMessage$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        webViewManager0.dismissFired = false;
        webViewManager0.setMessageView(null);
        return Unit.INSTANCE;
    }

    private final void enableWebViewRemoteDebugging() {
        if(Logging.atLogLevel(LogLevel.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    // 去混淆评级： 低(20)
    private final int getWebViewMaxSizeX(Activity activity0) {
        return this.messageContent.isFullBleed() ? ViewUtils.INSTANCE.getFullbleedWindowWidth(activity0) : ViewUtils.INSTANCE.getWindowWidth(activity0) - WebViewManager.MARGIN_PX_SIZE * 2;
    }

    // 去混淆评级： 低(20)
    private final int getWebViewMaxSizeY(Activity activity0) {
        return this.messageContent.isFullBleed() ? ViewUtils.INSTANCE.getWindowHeight(activity0) : ViewUtils.INSTANCE.getWindowHeight(activity0) - WebViewManager.MARGIN_PX_SIZE * 2;
    }

    @Override  // com.onesignal.core.internal.application.IActivityLifecycleHandler
    public void onActivityAvailable(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        String s = this.currentActivityName;
        this.activity = activity0;
        this.currentActivityName = activity0.getLocalClassName();
        Logging.debug$default(("In app message activity available currentActivityName: " + this.currentActivityName + " lastActivityName: " + s), null, 2, null);
        ThreadUtilsKt.suspendifyOnMain(new Function1(this, null) {
            final String $lastActivityName;
            int label;

            {
                this.$lastActivityName = s;
                WebViewManager.this = webViewManager0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.display.impl.WebViewManager.onActivityAvailable.1(this.$lastActivityName, WebViewManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.display.impl.WebViewManager.onActivityAvailable.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        String s = this.$lastActivityName;
                        if(s == null) {
                            this.label = 1;
                            if(WebViewManager.this.showMessageView(null, this) == object1) {
                                return object1;
                            }
                        }
                        else if(Intrinsics.areEqual(s, WebViewManager.this.currentActivityName)) {
                            this.label = 3;
                            if(WebViewManager.this.calculateHeightAndShowWebViewAfterNewActivity(this) == object1) {
                                return object1;
                            }
                        }
                        else if(!WebViewManager.this.closing) {
                            if(WebViewManager.this.messageView != null) {
                                InAppMessageView inAppMessageView0 = WebViewManager.this.messageView;
                                Intrinsics.checkNotNull(inAppMessageView0);
                                inAppMessageView0.removeAllViews();
                            }
                            this.label = 2;
                            if(WebViewManager.this.showMessageView(WebViewManager.this.lastPageHeight, this) == object1) {
                                return object1;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    case 1: 
                    case 2: 
                    case 3: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        });
    }

    @Override  // com.onesignal.core.internal.application.IActivityLifecycleHandler
    public void onActivityStopped(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Logging.debug$default(StringsKt.trimIndent(("\n            In app message activity stopped, cleaning views, currentActivityName: " + this.currentActivityName + "\n            activity: " + this.activity + "\n            messageView: " + this.messageView + "\n            ")), null, 2, null);
        if(this.messageView != null && Intrinsics.areEqual(activity0.getLocalClassName(), this.currentActivityName)) {
            InAppMessageView inAppMessageView0 = this.messageView;
            Intrinsics.checkNotNull(inAppMessageView0);
            inAppMessageView0.removeAllViews();
        }
    }

    private final int pageRectToViewHeight(Activity activity0, JSONObject jSONObject0) {
        try {
            int v = jSONObject0.getJSONObject("rect").getInt("height");
            int v1 = ViewUtils.INSTANCE.dpToPx(v);
            Logging.debug$default(("getPageHeightData:pxHeight: " + v1), null, 2, null);
            int v2 = this.getWebViewMaxSizeY(activity0);
            if(v1 > v2) {
                Logging.debug$default(("getPageHeightData:pxHeight is over screen max: " + v2), null, 2, null);
                return v2;
            }
            return v1;
        }
        catch(JSONException jSONException0) {
            Logging.error("pageRectToViewHeight could not get page height", jSONException0);
            return -1;
        }
    }

    public final void setContentSafeAreaInsets(InAppMessageContent inAppMessageContent0, Activity activity0) {
        Intrinsics.checkNotNullParameter(inAppMessageContent0, "content");
        Intrinsics.checkNotNullParameter(activity0, "activity");
        int[] arr_v = ViewUtils.INSTANCE.getCutoutAndStatusBarInsets(activity0);
        String s = String.format("{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}", Arrays.copyOf(new Object[]{((int)arr_v[0]), ((int)arr_v[1]), ((int)arr_v[2]), ((int)arr_v[3])}, 4));
        Intrinsics.checkNotNullExpressionValue(s, "format(format, *args)");
        String s1 = String.format("\n\n<script>\n    setSafeAreaInsets(%s);\n</script>", Arrays.copyOf(new Object[]{s}, 1));
        Intrinsics.checkNotNullExpressionValue(s1, "format(format, *args)");
        inAppMessageContent0.setContentHtml(inAppMessageContent0.getContentHtml() + s1);
    }

    private final void setMessageView(InAppMessageView inAppMessageView0) {
        this.messageView = inAppMessageView0;
    }

    private final void setWebViewToMaxSize(Activity activity0) {
        OSWebView oSWebView0 = this.webView;
        Intrinsics.checkNotNull(oSWebView0);
        oSWebView0.layout(0, 0, this.getWebViewMaxSizeX(activity0), this.getWebViewMaxSizeY(activity0));
    }

    public final Object setupWebView(Activity activity0, String s, boolean z, Continuation continuation0) {
        WebViewManager webViewManager0;
        com.onesignal.inAppMessages.internal.display.impl.WebViewManager.setupWebView.1 webViewManager$setupWebView$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager.setupWebView.1) {
            webViewManager$setupWebView$10 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager.setupWebView.1)continuation0;
            if((webViewManager$setupWebView$10.label & 0x80000000) == 0) {
                webViewManager$setupWebView$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.setupWebView(null, null, false, this);
                    }
                };
            }
            else {
                webViewManager$setupWebView$10.label ^= 0x80000000;
            }
        }
        else {
            webViewManager$setupWebView$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.setupWebView(null, null, false, this);
                }
            };
        }
        Object object0 = webViewManager$setupWebView$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(webViewManager$setupWebView$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                this.enableWebViewRemoteDebugging();
                OSWebView oSWebView0 = new OSWebView(activity0);
                this.webView = oSWebView0;
                Intrinsics.checkNotNull(oSWebView0);
                oSWebView0.setOverScrollMode(2);
                OSWebView oSWebView1 = this.webView;
                Intrinsics.checkNotNull(oSWebView1);
                oSWebView1.setVerticalScrollBarEnabled(false);
                OSWebView oSWebView2 = this.webView;
                Intrinsics.checkNotNull(oSWebView2);
                oSWebView2.setHorizontalScrollBarEnabled(false);
                OSWebView oSWebView3 = this.webView;
                Intrinsics.checkNotNull(oSWebView3);
                oSWebView3.getSettings().setJavaScriptEnabled(true);
                OSWebView oSWebView4 = this.webView;
                Intrinsics.checkNotNull(oSWebView4);
                oSWebView4.addJavascriptInterface(new OSJavaScriptInterface(this), "OSAndroid");
                if(z) {
                    OSWebView oSWebView5 = this.webView;
                    Intrinsics.checkNotNull(oSWebView5);
                    oSWebView5.setSystemUiVisibility(0xC02);
                    if(Build.VERSION.SDK_INT >= 30) {
                        OSWebView oSWebView6 = this.webView;
                        Intrinsics.checkNotNull(oSWebView6);
                        oSWebView6.setFitsSystemWindows(false);
                    }
                }
                Intrinsics.checkNotNull(this.webView);
                this._lifecycle.messageWillDisplay(this.message);
                webViewManager$setupWebView$10.L$0 = this;
                webViewManager$setupWebView$10.L$1 = activity0;
                webViewManager$setupWebView$10.L$2 = s;
                webViewManager$setupWebView$10.label = 1;
                if(this._applicationService.waitUntilActivityReady(webViewManager$setupWebView$10) == object1) {
                    return object1;
                }
                webViewManager0 = this;
                break;
            }
            case 1: {
                s = (String)webViewManager$setupWebView$10.L$2;
                activity0 = (Activity)webViewManager$setupWebView$10.L$1;
                webViewManager0 = (WebViewManager)webViewManager$setupWebView$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        webViewManager0.setWebViewToMaxSize(activity0);
        OSWebView oSWebView7 = webViewManager0.webView;
        Intrinsics.checkNotNull(oSWebView7);
        oSWebView7.loadData(s, "text/html; charset=utf-8", "base64");
        return Unit.INSTANCE;
    }

    private final Object showMessageView(Integer integer0, Continuation continuation0) {
        Unit unit0;
        Mutex mutex0;
        WebViewManager webViewManager0;
        WebViewManager webViewManager1;
        Integer integer1;
        com.onesignal.inAppMessages.internal.display.impl.WebViewManager.showMessageView.1 webViewManager$showMessageView$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager.showMessageView.1) {
            webViewManager$showMessageView$10 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager.showMessageView.1)continuation0;
            if((webViewManager$showMessageView$10.label & 0x80000000) == 0) {
                webViewManager$showMessageView$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.showMessageView(null, this);
                    }
                };
            }
            else {
                webViewManager$showMessageView$10.label ^= 0x80000000;
            }
        }
        else {
            webViewManager$showMessageView$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.showMessageView(null, this);
                }
            };
        }
        Object object0 = webViewManager$showMessageView$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(webViewManager$showMessageView$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Mutex mutex1 = this.messageViewMutex;
                webViewManager$showMessageView$10.L$0 = this;
                webViewManager$showMessageView$10.L$1 = integer0;
                webViewManager$showMessageView$10.L$2 = mutex1;
                webViewManager$showMessageView$10.label = 1;
                if(mutex1.lock(null, webViewManager$showMessageView$10) == object1) {
                    return object1;
                }
                webViewManager1 = this;
                integer1 = integer0;
                mutex0 = mutex1;
                break;
            }
            case 1: {
                mutex0 = (Mutex)webViewManager$showMessageView$10.L$2;
                integer1 = (Integer)webViewManager$showMessageView$10.L$1;
                webViewManager1 = (WebViewManager)webViewManager$showMessageView$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: {
                mutex0 = (Mutex)webViewManager$showMessageView$10.L$1;
                webViewManager0 = (WebViewManager)webViewManager$showMessageView$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    goto label_57;
                }
                catch(Throwable throwable0) {
                    mutex0.unlock(null);
                    throw throwable0;
                }
            }
            case 3: {
                mutex0 = (Mutex)webViewManager$showMessageView$10.L$1;
                webViewManager0 = (WebViewManager)webViewManager$showMessageView$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    goto label_65;
                }
                catch(Throwable throwable0) {
                    mutex0.unlock(null);
                    throw throwable0;
                }
            }
            case 4: {
                mutex0 = (Mutex)webViewManager$showMessageView$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    unit0 = Unit.INSTANCE;
                    goto label_76;
                }
                catch(Throwable throwable0) {
                    mutex0.unlock(null);
                    throw throwable0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            if(webViewManager1.messageView != null) {
                Logging.debug$default(("In app message, showing first one with height: " + integer1), null, 2, null);
                InAppMessageView inAppMessageView0 = webViewManager1.messageView;
                if(inAppMessageView0 != null) {
                    OSWebView oSWebView0 = webViewManager1.webView;
                    Intrinsics.checkNotNull(oSWebView0);
                    inAppMessageView0.setWebView(oSWebView0);
                }
                if(integer1 != null) {
                    webViewManager1.lastPageHeight = integer1;
                    InAppMessageView inAppMessageView1 = webViewManager1.messageView;
                    if(inAppMessageView1 != null) {
                        webViewManager$showMessageView$10.L$0 = webViewManager1;
                        webViewManager$showMessageView$10.L$1 = mutex0;
                        webViewManager$showMessageView$10.L$2 = null;
                        webViewManager$showMessageView$10.label = 2;
                        if(inAppMessageView1.updateHeight(((int)integer1), webViewManager$showMessageView$10) == object1) {
                            return object1;
                        }
                    }
                }
                webViewManager0 = webViewManager1;
            label_57:
                InAppMessageView inAppMessageView2 = webViewManager0.messageView;
                if(inAppMessageView2 != null) {
                    webViewManager$showMessageView$10.L$0 = webViewManager0;
                    webViewManager$showMessageView$10.L$1 = mutex0;
                    webViewManager$showMessageView$10.L$2 = null;
                    webViewManager$showMessageView$10.label = 3;
                    if(inAppMessageView2.showView(webViewManager0.activity, webViewManager$showMessageView$10) == object1) {
                        return object1;
                    }
                }
            label_65:
                InAppMessageView inAppMessageView3 = webViewManager0.messageView;
                if(inAppMessageView3 == null) {
                    unit0 = null;
                }
                else {
                    webViewManager$showMessageView$10.L$0 = mutex0;
                    webViewManager$showMessageView$10.L$1 = null;
                    webViewManager$showMessageView$10.L$2 = null;
                    webViewManager$showMessageView$10.label = 4;
                    if(inAppMessageView3.checkIfShouldDismiss(webViewManager$showMessageView$10) == object1) {
                        return object1;
                    }
                    unit0 = Unit.INSTANCE;
                }
                goto label_76;
            }
            goto label_78;
        }
        catch(Throwable throwable0) {
            mutex0.unlock(null);
            throw throwable0;
        }
    label_76:
        mutex0.unlock(null);
        return unit0;
        try {
        label_78:
            Logging.warn$default("No messageView found to update a with a new height.", null, 2, null);
        }
        catch(Throwable throwable0) {
            mutex0.unlock(null);
            throw throwable0;
        }
        mutex0.unlock(null);
        return Unit.INSTANCE;
    }

    private final Object updateSafeAreaInsets(Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new Function2(null) {
            int label;

            {
                WebViewManager.this = webViewManager0;
                super(2, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.onesignal.inAppMessages.internal.display.impl.WebViewManager.updateSafeAreaInsets.2(WebViewManager.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function2
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.onesignal.inAppMessages.internal.display.impl.WebViewManager.updateSafeAreaInsets.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                ResultKt.throwOnFailure(object0);
                int[] arr_v = ViewUtils.INSTANCE.getCutoutAndStatusBarInsets(WebViewManager.this.activity);
                String s = String.format("{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}", Arrays.copyOf(new Object[]{Boxing.boxInt(arr_v[0]), Boxing.boxInt(arr_v[1]), Boxing.boxInt(arr_v[2]), Boxing.boxInt(arr_v[3])}, 4));
                Intrinsics.checkNotNullExpressionValue(s, "format(format, *args)");
                String s1 = String.format("setSafeAreaInsets(%s)", Arrays.copyOf(new Object[]{s}, 1));
                Intrinsics.checkNotNullExpressionValue(s1, "format(format, *args)");
                OSWebView oSWebView0 = WebViewManager.this.webView;
                Intrinsics.checkNotNull(oSWebView0);
                oSWebView0.evaluateJavascript(s1, null);
                return Unit.INSTANCE;
            }
        }, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }
}

