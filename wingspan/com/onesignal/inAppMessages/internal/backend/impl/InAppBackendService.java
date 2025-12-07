package com.onesignal.inAppMessages.internal.backend.impl;

import com.onesignal.common.NetworkUtils.ResponseStatusType;
import com.onesignal.common.NetworkUtils;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient.DefaultImpls;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.hydrators.InAppHydrator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u00A2\u0006\u0002\u0010\bJ+\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000EH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0011J#\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u000EH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0015J$\u0010\u0016\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\r\u001A\u00020\u000EH\u0002J)\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u000EH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u0015J\"\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\n2\b\u0010\u001F\u001A\u0004\u0018\u00010\u000EH\u0002J\u0018\u0010 \u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u000EH\u0002JE\u0010!\u001A\u00020\u001C2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\"\u001A\u0004\u0018\u00010\u000E2\u0006\u0010#\u001A\u00020$H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010%J3\u0010&\u001A\u00020\u001C2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\'J=\u0010(\u001A\u00020\u001C2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010)\u001A\u0004\u0018\u00010\u000EH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010*R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006+"}, d2 = {"Lcom/onesignal/inAppMessages/internal/backend/impl/InAppBackendService;", "Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_hydrator", "Lcom/onesignal/inAppMessages/internal/hydrators/InAppHydrator;", "(Lcom/onesignal/core/internal/http/IHttpClient;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/inAppMessages/internal/hydrators/InAppHydrator;)V", "htmlNetworkRequestAttemptCount", "", "getIAMData", "Lcom/onesignal/inAppMessages/internal/backend/GetIAMDataResponse;", "appId", "", "messageId", "variantId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIAMPreviewData", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "previewUUID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "htmlPathForMessage", "listInAppMessages", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "subscriptionId", "printHttpErrorForInAppMessageRequest", "", "requestType", "statusCode", "response", "printHttpSuccessForInAppMessageRequest", "sendIAMClick", "clickId", "isFirstClick", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendIAMImpression", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendIAMPageImpression", "pageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppBackendService implements IInAppBackendService {
    private final IDeviceService _deviceService;
    private final IHttpClient _httpClient;
    private final InAppHydrator _hydrator;
    private int htmlNetworkRequestAttemptCount;

    public InAppBackendService(IHttpClient iHttpClient0, IDeviceService iDeviceService0, InAppHydrator inAppHydrator0) {
        Intrinsics.checkNotNullParameter(iHttpClient0, "_httpClient");
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(inAppHydrator0, "_hydrator");
        super();
        this._httpClient = iHttpClient0;
        this._deviceService = iDeviceService0;
        this._hydrator = inAppHydrator0;
    }

    @Override  // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    public Object getIAMData(String s, String s1, String s2, Continuation continuation0) {
        InAppBackendService inAppBackendService0;
        com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMData.1 inAppBackendService$getIAMData$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMData.1) {
            inAppBackendService$getIAMData$10 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMData.1)continuation0;
            if((inAppBackendService$getIAMData$10.label & 0x80000000) == 0) {
                inAppBackendService$getIAMData$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getIAMData(null, null, null, this);
                    }
                };
            }
            else {
                inAppBackendService$getIAMData$10.label ^= 0x80000000;
            }
        }
        else {
            inAppBackendService$getIAMData$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getIAMData(null, null, null, this);
                }
            };
        }
        Object object0 = inAppBackendService$getIAMData$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppBackendService$getIAMData$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                String s3 = this.htmlPathForMessage(s1, s2, s);
                if(s3 == null) {
                    return new GetIAMDataResponse(null, false);
                }
                inAppBackendService$getIAMData$10.L$0 = this;
                inAppBackendService$getIAMData$10.label = 1;
                object0 = this._httpClient.get(s3, null, inAppBackendService$getIAMData$10);
                if(object0 == object1) {
                    return object1;
                }
                inAppBackendService0 = this;
                break;
            }
            case 1: {
                inAppBackendService0 = (InAppBackendService)inAppBackendService$getIAMData$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((HttpResponse)object0).isSuccess()) {
            inAppBackendService0.htmlNetworkRequestAttemptCount = 0;
            String s4 = ((HttpResponse)object0).getPayload();
            Intrinsics.checkNotNull(s4);
            JSONObject jSONObject0 = new JSONObject(s4);
            return new GetIAMDataResponse(inAppBackendService0._hydrator.hydrateIAMMessageContent(jSONObject0), false);
        }
        inAppBackendService0.printHttpErrorForInAppMessageRequest("html", ((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        int v = ((HttpResponse)object0).getStatusCode();
        if(NetworkUtils.INSTANCE.getResponseStatusType(v) == ResponseStatusType.RETRYABLE && inAppBackendService0.htmlNetworkRequestAttemptCount < 3) {
            ++inAppBackendService0.htmlNetworkRequestAttemptCount;
            return new GetIAMDataResponse(null, true);
        }
        inAppBackendService0.htmlNetworkRequestAttemptCount = 0;
        return new GetIAMDataResponse(null, false);
    }

    @Override  // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    public Object getIAMPreviewData(String s, String s1, Continuation continuation0) {
        InAppBackendService inAppBackendService0;
        com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMPreviewData.1 inAppBackendService$getIAMPreviewData$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMPreviewData.1) {
            inAppBackendService$getIAMPreviewData$10 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.getIAMPreviewData.1)continuation0;
            if((inAppBackendService$getIAMPreviewData$10.label & 0x80000000) == 0) {
                inAppBackendService$getIAMPreviewData$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getIAMPreviewData(null, null, this);
                    }
                };
            }
            else {
                inAppBackendService$getIAMPreviewData$10.label ^= 0x80000000;
            }
        }
        else {
            inAppBackendService$getIAMPreviewData$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getIAMPreviewData(null, null, this);
                }
            };
        }
        Object object0 = inAppBackendService$getIAMPreviewData$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppBackendService$getIAMPreviewData$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                inAppBackendService$getIAMPreviewData$10.L$0 = this;
                inAppBackendService$getIAMPreviewData$10.label = 1;
                object0 = this._httpClient.get("in_app_messages/device_preview?preview_id=" + s1 + "&app_id=" + s, null, inAppBackendService$getIAMPreviewData$10);
                if(object0 == object1) {
                    return object1;
                }
                inAppBackendService0 = this;
                break;
            }
            case 1: {
                inAppBackendService0 = (InAppBackendService)inAppBackendService$getIAMPreviewData$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((HttpResponse)object0).isSuccess()) {
            String s2 = ((HttpResponse)object0).getPayload();
            Intrinsics.checkNotNull(s2);
            JSONObject jSONObject0 = new JSONObject(s2);
            return inAppBackendService0._hydrator.hydrateIAMMessageContent(jSONObject0);
        }
        inAppBackendService0.printHttpErrorForInAppMessageRequest("html", ((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        return null;
    }

    private final String htmlPathForMessage(String s, String s1, String s2) {
        if(s1 == null) {
            Logging.error$default(("Unable to find a variant for in-app message " + s), null, 2, null);
            return null;
        }
        return "in_app_messages/" + s + "/variants/" + s1 + "/html?app_id=" + s2;
    }

    @Override  // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    public Object listInAppMessages(String s, String s1, Continuation continuation0) {
        InAppBackendService inAppBackendService0;
        com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.listInAppMessages.1 inAppBackendService$listInAppMessages$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.listInAppMessages.1) {
            inAppBackendService$listInAppMessages$10 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.listInAppMessages.1)continuation0;
            if((inAppBackendService$listInAppMessages$10.label & 0x80000000) == 0) {
                inAppBackendService$listInAppMessages$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.listInAppMessages(null, null, this);
                    }
                };
            }
            else {
                inAppBackendService$listInAppMessages$10.label ^= 0x80000000;
            }
        }
        else {
            inAppBackendService$listInAppMessages$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.listInAppMessages(null, null, this);
                }
            };
        }
        Object object0 = inAppBackendService$listInAppMessages$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppBackendService$listInAppMessages$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                inAppBackendService$listInAppMessages$10.L$0 = this;
                inAppBackendService$listInAppMessages$10.label = 1;
                object0 = DefaultImpls.get$default(this._httpClient, "apps/" + s + "/subscriptions/" + s1 + "/iams", null, inAppBackendService$listInAppMessages$10, 2, null);
                if(object0 == object1) {
                    return object1;
                }
                inAppBackendService0 = this;
                break;
            }
            case 1: {
                inAppBackendService0 = (InAppBackendService)inAppBackendService$listInAppMessages$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((HttpResponse)object0).isSuccess()) {
            JSONObject jSONObject0 = new JSONObject(((HttpResponse)object0).getPayload());
            if(jSONObject0.has("in_app_messages")) {
                JSONArray jSONArray0 = jSONObject0.getJSONArray("in_app_messages");
                Intrinsics.checkNotNullExpressionValue(jSONArray0, "iamMessagesAsJSON");
                return inAppBackendService0._hydrator.hydrateIAMMessages(jSONArray0);
            }
        }
        return null;
    }

    private final void printHttpErrorForInAppMessageRequest(String s, int v, String s1) {
        Logging.error$default(("Encountered a " + v + " error while attempting in-app message " + s + " request: " + s1), null, 2, null);
    }

    private final void printHttpSuccessForInAppMessageRequest(String s, String s1) {
        Logging.debug$default(("Successful post for in-app message " + s + " request: " + s1), null, 2, null);
    }

    @Override  // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    public Object sendIAMClick(String s, String s1, String s2, String s3, String s4, boolean z, Continuation continuation0) {
        InAppBackendService inAppBackendService0;
        com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMClick.1 inAppBackendService$sendIAMClick$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMClick.1) {
            inAppBackendService$sendIAMClick$10 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMClick.1)continuation0;
            if((inAppBackendService$sendIAMClick$10.label & 0x80000000) == 0) {
                inAppBackendService$sendIAMClick$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendIAMClick(null, null, null, null, null, false, this);
                    }
                };
            }
            else {
                inAppBackendService$sendIAMClick$10.label ^= 0x80000000;
            }
        }
        else {
            inAppBackendService$sendIAMClick$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendIAMClick(null, null, null, null, null, false, this);
                }
            };
        }
        Object object0 = inAppBackendService$sendIAMClick$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppBackendService$sendIAMClick$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMClick.json.1 inAppBackendService$sendIAMClick$json$10 = new JSONObject() {
                    {
                        String s = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        InAppBackendService inAppBackendService0 = s1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        String s1 = s4;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        String s2 = s2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        String s3 = z;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.put("app_id", s);
                        this.put("device_type", inAppBackendService0._deviceService.getDeviceType().getValue());
                        this.put("player_id", s1);
                        this.put("click_id", s2);
                        this.put("variant_id", s3);
                        if(z) {
                            this.put("first_click", true);
                        }
                    }
                };
                inAppBackendService$sendIAMClick$10.L$0 = this;
                inAppBackendService$sendIAMClick$10.label = 1;
                object0 = this._httpClient.post("in_app_messages/" + s3 + "/click", inAppBackendService$sendIAMClick$json$10, inAppBackendService$sendIAMClick$10);
                if(object0 == object1) {
                    return object1;
                }
                inAppBackendService0 = this;
                break;
            }
            case 1: {
                inAppBackendService0 = (InAppBackendService)inAppBackendService$sendIAMClick$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((HttpResponse)object0).isSuccess()) {
            String s5 = ((HttpResponse)object0).getPayload();
            Intrinsics.checkNotNull(s5);
            inAppBackendService0.printHttpSuccessForInAppMessageRequest("engagement", s5);
            return Unit.INSTANCE;
        }
        inAppBackendService0.printHttpErrorForInAppMessageRequest("engagement", ((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        throw new BackendException(((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
    }

    @Override  // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    public Object sendIAMImpression(String s, String s1, String s2, String s3, Continuation continuation0) {
        InAppBackendService inAppBackendService0;
        com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMImpression.1 inAppBackendService$sendIAMImpression$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMImpression.1) {
            inAppBackendService$sendIAMImpression$10 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMImpression.1)continuation0;
            if((inAppBackendService$sendIAMImpression$10.label & 0x80000000) == 0) {
                inAppBackendService$sendIAMImpression$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendIAMImpression(null, null, null, null, this);
                    }
                };
            }
            else {
                inAppBackendService$sendIAMImpression$10.label ^= 0x80000000;
            }
        }
        else {
            inAppBackendService$sendIAMImpression$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendIAMImpression(null, null, null, null, this);
                }
            };
        }
        Object object0 = inAppBackendService$sendIAMImpression$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppBackendService$sendIAMImpression$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject() {
                    {
                        String s = s1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        String s1 = s2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        String s2 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.put("app_id", s);
                        this.put("player_id", s1);
                        this.put("variant_id", s2);
                        this.put("device_type", inAppBackendService0._deviceService.getDeviceType().getValue());
                        this.put("first_impression", true);
                    }
                };
                inAppBackendService$sendIAMImpression$10.L$0 = this;
                inAppBackendService$sendIAMImpression$10.label = 1;
                object0 = this._httpClient.post("in_app_messages/" + s3 + "/impression", jSONObject0, inAppBackendService$sendIAMImpression$10);
                if(object0 == object1) {
                    return object1;
                }
                inAppBackendService0 = this;
                break;
            }
            case 1: {
                inAppBackendService0 = (InAppBackendService)inAppBackendService$sendIAMImpression$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((HttpResponse)object0).isSuccess()) {
            String s4 = ((HttpResponse)object0).getPayload();
            Intrinsics.checkNotNull(s4);
            inAppBackendService0.printHttpSuccessForInAppMessageRequest("impression", s4);
            return Unit.INSTANCE;
        }
        inAppBackendService0.printHttpErrorForInAppMessageRequest("impression", ((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        throw new BackendException(((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
    }

    @Override  // com.onesignal.inAppMessages.internal.backend.IInAppBackendService
    public Object sendIAMPageImpression(String s, String s1, String s2, String s3, String s4, Continuation continuation0) {
        InAppBackendService inAppBackendService0;
        com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMPageImpression.1 inAppBackendService$sendIAMPageImpression$10;
        if(continuation0 instanceof com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMPageImpression.1) {
            inAppBackendService$sendIAMPageImpression$10 = (com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMPageImpression.1)continuation0;
            if((inAppBackendService$sendIAMPageImpression$10.label & 0x80000000) == 0) {
                inAppBackendService$sendIAMPageImpression$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.sendIAMPageImpression(null, null, null, null, null, this);
                    }
                };
            }
            else {
                inAppBackendService$sendIAMPageImpression$10.label ^= 0x80000000;
            }
        }
        else {
            inAppBackendService$sendIAMPageImpression$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.sendIAMPageImpression(null, null, null, null, null, this);
                }
            };
        }
        Object object0 = inAppBackendService$sendIAMPageImpression$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(inAppBackendService$sendIAMPageImpression$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                com.onesignal.inAppMessages.internal.backend.impl.InAppBackendService.sendIAMPageImpression.json.1 inAppBackendService$sendIAMPageImpression$json$10 = new JSONObject() {
                    {
                        String s = s1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        String s1 = s2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        String s2 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        InAppBackendService inAppBackendService0 = s4;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.put("app_id", s);
                        this.put("player_id", s1);
                        this.put("variant_id", s2);
                        this.put("device_type", inAppBackendService0._deviceService.getDeviceType().getValue());
                        this.put("page_id", s3);
                    }
                };
                inAppBackendService$sendIAMPageImpression$10.L$0 = this;
                inAppBackendService$sendIAMPageImpression$10.label = 1;
                object0 = this._httpClient.post("in_app_messages/" + s3 + "/pageImpression", inAppBackendService$sendIAMPageImpression$json$10, inAppBackendService$sendIAMPageImpression$10);
                if(object0 == object1) {
                    return object1;
                }
                inAppBackendService0 = this;
                break;
            }
            case 1: {
                inAppBackendService0 = (InAppBackendService)inAppBackendService$sendIAMPageImpression$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((HttpResponse)object0).isSuccess()) {
            String s5 = ((HttpResponse)object0).getPayload();
            Intrinsics.checkNotNull(s5);
            inAppBackendService0.printHttpSuccessForInAppMessageRequest("page impression", s5);
            return Unit.INSTANCE;
        }
        inAppBackendService0.printHttpErrorForInAppMessageRequest("page impression", ((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        throw new BackendException(((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
    }
}

