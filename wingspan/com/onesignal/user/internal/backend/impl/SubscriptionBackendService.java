package com.onesignal.user.internal.backend.impl;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient.DefaultImpls;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.SubscriptionObject;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J3\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000BH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J-\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J1\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J)\u0010\u0015\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000BH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/SubscriptionBackendService;", "Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "createSubscription", "", "appId", "aliasLabel", "aliasValue", "subscription", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/SubscriptionObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubscription", "", "subscriptionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIdentityFromSubscription", "", "transferSubscription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "(Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/SubscriptionObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubscriptionBackendService implements ISubscriptionBackendService {
    private final IHttpClient _httpClient;

    public SubscriptionBackendService(IHttpClient iHttpClient0) {
        Intrinsics.checkNotNullParameter(iHttpClient0, "_httpClient");
        super();
        this._httpClient = iHttpClient0;
    }

    @Override  // com.onesignal.user.internal.backend.ISubscriptionBackendService
    public Object createSubscription(String s, String s1, String s2, SubscriptionObject subscriptionObject0, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.SubscriptionBackendService.createSubscription.1 subscriptionBackendService$createSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.createSubscription.1) {
            subscriptionBackendService$createSubscription$10 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.createSubscription.1)continuation0;
            if((subscriptionBackendService$createSubscription$10.label & 0x80000000) == 0) {
                subscriptionBackendService$createSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.createSubscription(null, null, null, null, this);
                    }
                };
            }
            else {
                subscriptionBackendService$createSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionBackendService$createSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.createSubscription(null, null, null, null, this);
                }
            };
        }
        Object object0 = subscriptionBackendService$createSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionBackendService$createSubscription$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = JSONConverter.INSTANCE.convertToJSON(subscriptionObject0);
                jSONObject0.remove("id");
                JSONObject jSONObject1 = new JSONObject().put("subscription", jSONObject0);
                Intrinsics.checkNotNullExpressionValue(jSONObject1, "requestJSON");
                subscriptionBackendService$createSubscription$10.label = 1;
                object0 = this._httpClient.post("apps/" + s + "/users/by/" + s1 + '/' + s2 + "/subscriptions", jSONObject1, subscriptionBackendService$createSubscription$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
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
        JSONObject jSONObject2 = JSONObjectExtensionsKt.safeJSONObject(new JSONObject(s3), "subscription");
        return jSONObject2 != null && jSONObject2.has("id") ? jSONObject2.getString("id") : null;
    }

    @Override  // com.onesignal.user.internal.backend.ISubscriptionBackendService
    public Object deleteSubscription(String s, String s1, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.SubscriptionBackendService.deleteSubscription.1 subscriptionBackendService$deleteSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.deleteSubscription.1) {
            subscriptionBackendService$deleteSubscription$10 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.deleteSubscription.1)continuation0;
            if((subscriptionBackendService$deleteSubscription$10.label & 0x80000000) == 0) {
                subscriptionBackendService$deleteSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.deleteSubscription(null, null, this);
                    }
                };
            }
            else {
                subscriptionBackendService$deleteSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionBackendService$deleteSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.deleteSubscription(null, null, this);
                }
            };
        }
        Object object0 = subscriptionBackendService$deleteSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionBackendService$deleteSubscription$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                subscriptionBackendService$deleteSubscription$10.label = 1;
                object0 = this._httpClient.delete("apps/" + s + "/subscriptions/" + s1, subscriptionBackendService$deleteSubscription$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
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
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.user.internal.backend.ISubscriptionBackendService
    public Object getIdentityFromSubscription(String s, String s1, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.SubscriptionBackendService.getIdentityFromSubscription.1 subscriptionBackendService$getIdentityFromSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.getIdentityFromSubscription.1) {
            subscriptionBackendService$getIdentityFromSubscription$10 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.getIdentityFromSubscription.1)continuation0;
            if((subscriptionBackendService$getIdentityFromSubscription$10.label & 0x80000000) == 0) {
                subscriptionBackendService$getIdentityFromSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getIdentityFromSubscription(null, null, this);
                    }
                };
            }
            else {
                subscriptionBackendService$getIdentityFromSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionBackendService$getIdentityFromSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getIdentityFromSubscription(null, null, this);
                }
            };
        }
        Object object0 = subscriptionBackendService$getIdentityFromSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionBackendService$getIdentityFromSubscription$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                subscriptionBackendService$getIdentityFromSubscription$10.label = 1;
                object0 = DefaultImpls.get$default(this._httpClient, "apps/" + s + "/subscriptions/" + s1 + "/user/identity", null, subscriptionBackendService$getIdentityFromSubscription$10, 2, null);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
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
        String s2 = ((HttpResponse)object0).getPayload();
        Intrinsics.checkNotNull(s2);
        JSONObject jSONObject0 = JSONObjectExtensionsKt.safeJSONObject(new JSONObject(s2), "identity");
        if(jSONObject0 != null) {
            Map map0 = JSONObjectExtensionsKt.toMap(jSONObject0);
            if(map0 != null) {
                Map map1 = new LinkedHashMap(MapsKt.mapCapacity(map0.size()));
                for(Object object2: map0.entrySet()) {
                    map1.put(((Map.Entry)object2).getKey(), String.valueOf(((Map.Entry)object2).getValue()));
                }
                return map1;
            }
        }
        return MapsKt.emptyMap();
    }

    @Override  // com.onesignal.user.internal.backend.ISubscriptionBackendService
    public Object transferSubscription(String s, String s1, String s2, String s3, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.SubscriptionBackendService.transferSubscription.1 subscriptionBackendService$transferSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.transferSubscription.1) {
            subscriptionBackendService$transferSubscription$10 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.transferSubscription.1)continuation0;
            if((subscriptionBackendService$transferSubscription$10.label & 0x80000000) == 0) {
                subscriptionBackendService$transferSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.transferSubscription(null, null, null, null, this);
                    }
                };
            }
            else {
                subscriptionBackendService$transferSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionBackendService$transferSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.transferSubscription(null, null, null, null, this);
                }
            };
        }
        Object object0 = subscriptionBackendService$transferSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionBackendService$transferSubscription$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject().put("identity", new JSONObject().put(s2, s3));
                Intrinsics.checkNotNullExpressionValue(jSONObject0, "requestJSON");
                subscriptionBackendService$transferSubscription$10.label = 1;
                object0 = this._httpClient.patch("apps/" + s + "/subscriptions/" + s1 + "/owner", jSONObject0, subscriptionBackendService$transferSubscription$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
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
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.user.internal.backend.ISubscriptionBackendService
    public Object updateSubscription(String s, String s1, SubscriptionObject subscriptionObject0, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.SubscriptionBackendService.updateSubscription.1 subscriptionBackendService$updateSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.SubscriptionBackendService.updateSubscription.1) {
            subscriptionBackendService$updateSubscription$10 = (com.onesignal.user.internal.backend.impl.SubscriptionBackendService.updateSubscription.1)continuation0;
            if((subscriptionBackendService$updateSubscription$10.label & 0x80000000) == 0) {
                subscriptionBackendService$updateSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateSubscription(null, null, null, this);
                    }
                };
            }
            else {
                subscriptionBackendService$updateSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionBackendService$updateSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateSubscription(null, null, null, this);
                }
            };
        }
        Object object0 = subscriptionBackendService$updateSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionBackendService$updateSubscription$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject().put("subscription", JSONConverter.INSTANCE.convertToJSON(subscriptionObject0));
                Intrinsics.checkNotNullExpressionValue(jSONObject0, "requestJSON");
                subscriptionBackendService$updateSubscription$10.label = 1;
                object0 = this._httpClient.patch("apps/" + s + "/subscriptions/" + s1, jSONObject0, subscriptionBackendService$updateSubscription$10);
                if(object0 == object1) {
                    return object1;
                }
                break;
            }
            case 1: {
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
        return Unit.INSTANCE;
    }
}

