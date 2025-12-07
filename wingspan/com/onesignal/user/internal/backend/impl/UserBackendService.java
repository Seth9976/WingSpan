package com.onesignal.user.internal.backend.impl;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient.DefaultImpls;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.PropertiesDeltasObject;
import com.onesignal.user.internal.backend.PropertiesObject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004JO\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000FJ)\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013JA\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001BR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001C"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/UserBackendService;", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_httpClient", "Lcom/onesignal/core/internal/http/IHttpClient;", "(Lcom/onesignal/core/internal/http/IHttpClient;)V", "createUser", "Lcom/onesignal/user/internal/backend/CreateUserResponse;", "appId", "", "identities", "", "subscriptions", "", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "properties", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "aliasLabel", "aliasValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "refreshDeviceMetadata", "", "propertyiesDelta", "Lcom/onesignal/user/internal/backend/PropertiesDeltasObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/onesignal/user/internal/backend/PropertiesObject;ZLcom/onesignal/user/internal/backend/PropertiesDeltasObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UserBackendService implements IUserBackendService {
    private final IHttpClient _httpClient;

    public UserBackendService(IHttpClient iHttpClient0) {
        Intrinsics.checkNotNullParameter(iHttpClient0, "_httpClient");
        super();
        this._httpClient = iHttpClient0;
    }

    @Override  // com.onesignal.user.internal.backend.IUserBackendService
    public Object createUser(String s, Map map0, List list0, Map map1, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.UserBackendService.createUser.1 userBackendService$createUser$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.UserBackendService.createUser.1) {
            userBackendService$createUser$10 = (com.onesignal.user.internal.backend.impl.UserBackendService.createUser.1)continuation0;
            if((userBackendService$createUser$10.label & 0x80000000) == 0) {
                userBackendService$createUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.createUser(null, null, null, null, this);
                    }
                };
            }
            else {
                userBackendService$createUser$10.label ^= 0x80000000;
            }
        }
        else {
            userBackendService$createUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.createUser(null, null, null, null, this);
                }
            };
        }
        Object object0 = userBackendService$createUser$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(userBackendService$createUser$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject();
                if(!map0.isEmpty() != 0) {
                    jSONObject0.put("identity", JSONObjectExtensionsKt.putMap(new JSONObject(), map0));
                }
                if(!list0.isEmpty() != 0) {
                    jSONObject0.put("subscriptions", JSONConverter.INSTANCE.convertToJSON(list0));
                }
                if(!map1.isEmpty() != 0) {
                    jSONObject0.put("properties", JSONObjectExtensionsKt.putMap(new JSONObject(), map1));
                }
                jSONObject0.put("refresh_device_metadata", true);
                userBackendService$createUser$10.label = 1;
                object0 = this._httpClient.post("apps/" + s + "/users", jSONObject0, userBackendService$createUser$10);
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
        String s1 = ((HttpResponse)object0).getPayload();
        Intrinsics.checkNotNull(s1);
        JSONObject jSONObject1 = new JSONObject(s1);
        return JSONConverter.INSTANCE.convertToCreateUserResponse(jSONObject1);
    }

    @Override  // com.onesignal.user.internal.backend.IUserBackendService
    public Object getUser(String s, String s1, String s2, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.UserBackendService.getUser.1 userBackendService$getUser$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.UserBackendService.getUser.1) {
            userBackendService$getUser$10 = (com.onesignal.user.internal.backend.impl.UserBackendService.getUser.1)continuation0;
            if((userBackendService$getUser$10.label & 0x80000000) == 0) {
                userBackendService$getUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getUser(null, null, null, this);
                    }
                };
            }
            else {
                userBackendService$getUser$10.label ^= 0x80000000;
            }
        }
        else {
            userBackendService$getUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getUser(null, null, null, this);
                }
            };
        }
        Object object0 = userBackendService$getUser$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(userBackendService$getUser$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                userBackendService$getUser$10.label = 1;
                object0 = DefaultImpls.get$default(this._httpClient, "apps/" + s + "/users/by/" + s1 + '/' + s2, null, userBackendService$getUser$10, 2, null);
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
        JSONObject jSONObject0 = new JSONObject(((HttpResponse)object0).getPayload());
        return JSONConverter.INSTANCE.convertToCreateUserResponse(jSONObject0);
    }

    @Override  // com.onesignal.user.internal.backend.IUserBackendService
    public Object updateUser(String s, String s1, String s2, PropertiesObject propertiesObject0, boolean z, PropertiesDeltasObject propertiesDeltasObject0, Continuation continuation0) {
        com.onesignal.user.internal.backend.impl.UserBackendService.updateUser.1 userBackendService$updateUser$10;
        if(continuation0 instanceof com.onesignal.user.internal.backend.impl.UserBackendService.updateUser.1) {
            userBackendService$updateUser$10 = (com.onesignal.user.internal.backend.impl.UserBackendService.updateUser.1)continuation0;
            if((userBackendService$updateUser$10.label & 0x80000000) == 0) {
                userBackendService$updateUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateUser(null, null, null, null, false, null, this);
                    }
                };
            }
            else {
                userBackendService$updateUser$10.label ^= 0x80000000;
            }
        }
        else {
            userBackendService$updateUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateUser(null, null, null, null, false, null, this);
                }
            };
        }
        Object object0 = userBackendService$updateUser$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(userBackendService$updateUser$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                JSONObject jSONObject0 = new JSONObject().put("refresh_device_metadata", z);
                if(propertiesObject0.getHasAtLeastOnePropertySet()) {
                    jSONObject0.put("properties", JSONConverter.INSTANCE.convertToJSON(propertiesObject0));
                }
                if(propertiesDeltasObject0.getHasAtLeastOnePropertySet()) {
                    jSONObject0.put("deltas", JSONConverter.INSTANCE.convertToJSON(propertiesDeltasObject0));
                }
                Intrinsics.checkNotNullExpressionValue(jSONObject0, "jsonObject");
                userBackendService$updateUser$10.label = 1;
                object0 = this._httpClient.patch("apps/" + s + "/users/by/" + s1 + '/' + s2, jSONObject0, userBackendService$updateUser$10);
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

