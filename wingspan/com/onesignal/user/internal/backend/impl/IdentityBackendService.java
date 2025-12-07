package com.onesignal.user.internal.backend.impl;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.IIdentityBackendService;
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

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJI\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000E2\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000EH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/IdentityBackendService;", "Lcom/onesignal/user/internal/backend/IIdentityBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "deleteAlias", "", "appId", "", "aliasLabel", "aliasValue", "aliasLabelToDelete", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAlias", "", "identities", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class IdentityBackendService implements IIdentityBackendService {
    private final IHttpClient _httpClient;

    public IdentityBackendService(IHttpClient iHttpClient0) {
        Intrinsics.checkNotNullParameter(iHttpClient0, "_httpClient");
        super();
        this._httpClient = iHttpClient0;
    }

    @Override  // com.onesignal.user.internal.backend.IIdentityBackendService
    public Object deleteAlias(String s, String s1, String s2, String s3, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.IdentityBackendService.deleteAlias.1 identityBackendService$deleteAlias$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.IdentityBackendService.deleteAlias.1) {
            identityBackendService$deleteAlias$10 = (com.onesignal.user.internal.backend.impl.IdentityBackendService.deleteAlias.1)continuation0;
            if((identityBackendService$deleteAlias$10.label & 0x80000000) == 0) {
                identityBackendService$deleteAlias$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.deleteAlias(null, null, null, null, this);
                    }
                };
            }
            else {
                identityBackendService$deleteAlias$10.label ^= 0x80000000;
            }
        }
        else {
            identityBackendService$deleteAlias$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.deleteAlias(null, null, null, null, this);
                }
            };
        }
        Object object0 = identityBackendService$deleteAlias$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(identityBackendService$deleteAlias$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                identityBackendService$deleteAlias$10.label = 1;
                object0 = this._httpClient.delete("apps/" + s + "/users/by/" + s1 + '/' + s2 + "/identity/" + s3, identityBackendService$deleteAlias$10);
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

    @Override  // com.onesignal.user.internal.backend.IIdentityBackendService
    public Object setAlias(String s, String s1, String s2, Map map0, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.IdentityBackendService.setAlias.1 identityBackendService$setAlias$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.IdentityBackendService.setAlias.1) {
            identityBackendService$setAlias$10 = (com.onesignal.user.internal.backend.impl.IdentityBackendService.setAlias.1)continuation0;
            if((identityBackendService$setAlias$10.label & 0x80000000) == 0) {
                identityBackendService$setAlias$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.setAlias(null, null, null, null, this);
                    }
                };
            }
            else {
                identityBackendService$setAlias$10.label ^= 0x80000000;
            }
        }
        else {
            identityBackendService$setAlias$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.setAlias(null, null, null, null, this);
                }
            };
        }
        Object object0 = identityBackendService$setAlias$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(identityBackendService$setAlias$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject().put("identity", JSONObjectExtensionsKt.putMap(new JSONObject(), map0));
                Intrinsics.checkNotNullExpressionValue(jSONObject0, "requestJSONObject");
                identityBackendService$setAlias$10.label = 1;
                object0 = this._httpClient.patch("apps/" + s + "/users/by/" + s1 + '/' + s2 + "/identity", jSONObject0, identityBackendService$setAlias$10);
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
        JSONObject jSONObject1 = new JSONObject(s3).getJSONObject("identity");
        Intrinsics.checkNotNullExpressionValue(jSONObject1, "responseJSON.getJSONObject(\"identity\")");
        Map map1 = JSONObjectExtensionsKt.toMap(jSONObject1);
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(MapsKt.mapCapacity(map1.size()));
        for(Object object2: map1.entrySet()) {
            linkedHashMap0.put(((Map.Entry)object2).getKey(), String.valueOf(((Map.Entry)object2).getValue()));
        }
        return linkedHashMap0;
    }
}

