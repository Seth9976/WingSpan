package com.onesignal.core.internal.backend.impl;

import com.onesignal.common.IDManager;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.backend.FCMParamsObject;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.backend.InfluenceParamsObject;
import com.onesignal.core.internal.backend.ParamsObject;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000F"}, d2 = {"Lcom/onesignal/core/internal/backend/impl/ParamsBackendService;", "Lcom/onesignal/core/internal/backend/IParamsBackendService;", "_http", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "fetchParams", "Lcom/onesignal/core/internal/backend/ParamsObject;", "appId", "", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processOutcomeJson", "Lcom/onesignal/core/internal/backend/InfluenceParamsObject;", "outcomeJson", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ParamsBackendService implements IParamsBackendService {
    private final IHttpClient _http;

    public ParamsBackendService(IHttpClient iHttpClient0) {
        Intrinsics.checkNotNullParameter(iHttpClient0, "_http");
        super();
        this._http = iHttpClient0;
    }

    @Override  // com.onesignal.core.internal.backend.IParamsBackendService
    public Object fetchParams(String s, String s1, Continuation continuation0) {
        ParamsBackendService paramsBackendService0;
        com.onesignal.core.internal.backend.impl.ParamsBackendService.fetchParams.1 paramsBackendService$fetchParams$10;
        if(continuation0 instanceof com.onesignal.core.internal.backend.impl.ParamsBackendService.fetchParams.1) {
            paramsBackendService$fetchParams$10 = (com.onesignal.core.internal.backend.impl.ParamsBackendService.fetchParams.1)continuation0;
            if((paramsBackendService$fetchParams$10.label & 0x80000000) == 0) {
                paramsBackendService$fetchParams$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.fetchParams(null, null, this);
                    }
                };
            }
            else {
                paramsBackendService$fetchParams$10.label ^= 0x80000000;
            }
        }
        else {
            paramsBackendService$fetchParams$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.fetchParams(null, null, this);
                }
            };
        }
        Object object0 = paramsBackendService$fetchParams$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(paramsBackendService$fetchParams$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Logging.log(LogLevel.DEBUG, "ParamsBackendService.fetchParams(appId: " + s + ", subscriptionId: " + s1 + ')');
                String s2 = s1 == null || IDManager.INSTANCE.isLocalId(s1) ? "apps/" + s + "/android_params.js" : "apps/" + s + "/android_params.js" + "?player_id=" + s1;
                paramsBackendService$fetchParams$10.L$0 = this;
                paramsBackendService$fetchParams$10.label = 1;
                object0 = this._http.get(s2, "CACHE_KEY_REMOTE_PARAMS", paramsBackendService$fetchParams$10);
                if(object0 == object1) {
                    return object1;
                }
                paramsBackendService0 = this;
                break;
            }
            case 1: {
                paramsBackendService0 = (ParamsBackendService)paramsBackendService$fetchParams$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((HttpResponse)object0).isSuccess()) {
            throw new BackendException(((HttpResponse)object0).getStatusCode(), ((HttpResponse)object0).getPayload());
        }
        String s3 = ((HttpResponse)object0).getPayload();
        Intrinsics.checkNotNull(s3);
        JSONObject jSONObject0 = new JSONObject(s3);
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        JSONObjectExtensionsKt.expandJSONObject(jSONObject0, "outcomes", new Function1(paramsBackendService0) {
            final ObjectRef $influenceParams;

            {
                this.$influenceParams = ref$ObjectRef0;
                ParamsBackendService.this = paramsBackendService0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((JSONObject)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(JSONObject jSONObject0) {
                Intrinsics.checkNotNullParameter(jSONObject0, "it");
                this.$influenceParams.element = ParamsBackendService.this.processOutcomeJson(jSONObject0);
            }
        });
        ObjectRef ref$ObjectRef1 = new ObjectRef();
        JSONObjectExtensionsKt.expandJSONObject(jSONObject0, "fcm", new Function1() {
            final ObjectRef $fcmParams;

            {
                this.$fcmParams = ref$ObjectRef0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((JSONObject)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(JSONObject jSONObject0) {
                Intrinsics.checkNotNullParameter(jSONObject0, "it");
                String s = JSONObjectExtensionsKt.safeString(jSONObject0, "api_key");
                String s1 = JSONObjectExtensionsKt.safeString(jSONObject0, "app_id");
                this.$fcmParams.element = new FCMParamsObject(JSONObjectExtensionsKt.safeString(jSONObject0, "project_id"), s1, s);
            }
        });
        String s4 = JSONObjectExtensionsKt.safeString(jSONObject0, "android_sender_id");
        Boolean boolean0 = JSONObjectExtensionsKt.safeBool(jSONObject0, "enterp");
        Boolean boolean1 = JSONObjectExtensionsKt.safeBool(jSONObject0, "require_ident_auth");
        JSONArray jSONArray0 = jSONObject0.optJSONArray("chnl_lst");
        Boolean boolean2 = JSONObjectExtensionsKt.safeBool(jSONObject0, "fba");
        Boolean boolean3 = JSONObjectExtensionsKt.safeBool(jSONObject0, "restore_ttl_filter");
        Boolean boolean4 = JSONObjectExtensionsKt.safeBool(jSONObject0, "clear_group_on_summary_click");
        Boolean boolean5 = JSONObjectExtensionsKt.safeBool(jSONObject0, "receive_receipts_enable");
        Boolean boolean6 = JSONObjectExtensionsKt.safeBool(jSONObject0, "disable_gms_missing_prompt");
        Boolean boolean7 = JSONObjectExtensionsKt.safeBool(jSONObject0, "unsubscribe_on_notifications_disabled");
        Boolean boolean8 = JSONObjectExtensionsKt.safeBool(jSONObject0, "location_shared");
        Boolean boolean9 = JSONObjectExtensionsKt.safeBool(jSONObject0, "requires_user_privacy_consent");
        Long long0 = JSONObjectExtensionsKt.safeLong(jSONObject0, "oprepo_execution_interval");
        InfluenceParamsObject influenceParamsObject0 = (InfluenceParamsObject)ref$ObjectRef0.element;
        InfluenceParamsObject influenceParamsObject1 = influenceParamsObject0 == null ? new InfluenceParamsObject(null, null, null, null, null, null, null, 0x7F, null) : influenceParamsObject0;
        FCMParamsObject fCMParamsObject0 = (FCMParamsObject)ref$ObjectRef1.element;
        return fCMParamsObject0 == null ? new ParamsObject(s4, boolean0, boolean1, jSONArray0, boolean2, boolean3, boolean4, boolean5, boolean6, boolean7, boolean8, boolean9, long0, influenceParamsObject1, new FCMParamsObject(null, null, null, 7, null)) : new ParamsObject(s4, boolean0, boolean1, jSONArray0, boolean2, boolean3, boolean4, boolean5, boolean6, boolean7, boolean8, boolean9, long0, influenceParamsObject1, fCMParamsObject0);
    }

    private final InfluenceParamsObject processOutcomeJson(JSONObject jSONObject0) {
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ObjectRef ref$ObjectRef1 = new ObjectRef();
        ObjectRef ref$ObjectRef2 = new ObjectRef();
        ObjectRef ref$ObjectRef3 = new ObjectRef();
        ObjectRef ref$ObjectRef4 = new ObjectRef();
        ObjectRef ref$ObjectRef5 = new ObjectRef();
        ObjectRef ref$ObjectRef6 = new ObjectRef();
        JSONObjectExtensionsKt.expandJSONObject(jSONObject0, "direct", new Function1() {
            final ObjectRef $isDirectEnabled;

            {
                this.$isDirectEnabled = ref$ObjectRef0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((JSONObject)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(JSONObject jSONObject0) {
                Intrinsics.checkNotNullParameter(jSONObject0, "it");
                this.$isDirectEnabled.element = JSONObjectExtensionsKt.safeBool(jSONObject0, "enabled");
            }
        });
        JSONObjectExtensionsKt.expandJSONObject(jSONObject0, "indirect", new Function1(ref$ObjectRef0, ref$ObjectRef1, ref$ObjectRef2, ref$ObjectRef3) {
            final ObjectRef $iamLimit;
            final ObjectRef $indirectIAMAttributionWindow;
            final ObjectRef $indirectNotificationAttributionWindow;
            final ObjectRef $isIndirectEnabled;
            final ObjectRef $notificationLimit;

            {
                this.$isIndirectEnabled = ref$ObjectRef0;
                this.$indirectNotificationAttributionWindow = ref$ObjectRef1;
                this.$notificationLimit = ref$ObjectRef2;
                this.$indirectIAMAttributionWindow = ref$ObjectRef3;
                this.$iamLimit = ref$ObjectRef4;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((JSONObject)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(JSONObject jSONObject0) {
                Intrinsics.checkNotNullParameter(jSONObject0, "indirectJSON");
                this.$isIndirectEnabled.element = JSONObjectExtensionsKt.safeBool(jSONObject0, "enabled");
                JSONObjectExtensionsKt.expandJSONObject(jSONObject0, "notification_attribution", new Function1(this.$notificationLimit) {
                    final ObjectRef $indirectNotificationAttributionWindow;
                    final ObjectRef $notificationLimit;

                    {
                        this.$indirectNotificationAttributionWindow = ref$ObjectRef0;
                        this.$notificationLimit = ref$ObjectRef1;
                        super(1);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        this.invoke(((JSONObject)object0));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(JSONObject jSONObject0) {
                        Intrinsics.checkNotNullParameter(jSONObject0, "it");
                        this.$indirectNotificationAttributionWindow.element = JSONObjectExtensionsKt.safeInt(jSONObject0, "minutes_since_displayed");
                        this.$notificationLimit.element = JSONObjectExtensionsKt.safeInt(jSONObject0, "limit");
                    }
                });
                JSONObjectExtensionsKt.expandJSONObject(jSONObject0, "in_app_message_attribution", new Function1(this.$iamLimit) {
                    final ObjectRef $iamLimit;
                    final ObjectRef $indirectIAMAttributionWindow;

                    {
                        this.$indirectIAMAttributionWindow = ref$ObjectRef0;
                        this.$iamLimit = ref$ObjectRef1;
                        super(1);
                    }

                    @Override  // kotlin.jvm.functions.Function1
                    public Object invoke(Object object0) {
                        this.invoke(((JSONObject)object0));
                        return Unit.INSTANCE;
                    }

                    public final void invoke(JSONObject jSONObject0) {
                        Intrinsics.checkNotNullParameter(jSONObject0, "it");
                        this.$indirectIAMAttributionWindow.element = JSONObjectExtensionsKt.safeInt(jSONObject0, "minutes_since_displayed");
                        this.$iamLimit.element = JSONObjectExtensionsKt.safeInt(jSONObject0, "limit");
                    }
                });
            }
        });
        JSONObjectExtensionsKt.expandJSONObject(jSONObject0, "unattributed", new Function1() {
            final ObjectRef $isUnattributedEnabled;

            {
                this.$isUnattributedEnabled = ref$ObjectRef0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((JSONObject)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(JSONObject jSONObject0) {
                Intrinsics.checkNotNullParameter(jSONObject0, "it");
                this.$isUnattributedEnabled.element = JSONObjectExtensionsKt.safeBool(jSONObject0, "enabled");
            }
        });
        return new InfluenceParamsObject(((Integer)ref$ObjectRef0.element), ((Integer)ref$ObjectRef1.element), ((Integer)ref$ObjectRef2.element), ((Integer)ref$ObjectRef3.element), ((Boolean)ref$ObjectRef4.element), ((Boolean)ref$ObjectRef5.element), ((Boolean)ref$ObjectRef6.element));
    }
}

