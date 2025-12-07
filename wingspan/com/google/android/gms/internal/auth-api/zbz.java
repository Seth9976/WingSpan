package com.google.android.gms.internal.auth-api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.identity.AuthorizationClient;
import com.google.android.gms.auth.api.identity.AuthorizationRequest.Builder;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.auth.api.identity.zbb;
import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;

public final class zbz extends GoogleApi implements AuthorizationClient {
    private static final ClientKey zba;
    private static final AbstractClientBuilder zbb;
    private static final Api zbc;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zbz.zba = api$ClientKey0;
        zbx zbx0 = new zbx();
        zbz.zbb = zbx0;
        zbz.zbc = new Api("Auth.Api.Identity.Authorization.API", zbx0, api$ClientKey0);
    }

    public zbz(Activity activity0, zbc zbc0) {
        zbb zbb0 = zbb.zbc(zbc0);
        zbb0.zba("q7Z9_828v6oW5Qk-KqVK8g");
        zbc zbc1 = zbb0.zbb();
        super(activity0, zbz.zbc, zbc1, Settings.DEFAULT_SETTINGS);
    }

    public zbz(Context context0, zbc zbc0) {
        zbb zbb0 = zbb.zbc(zbc0);
        zbb0.zba("xjInKU-p36VJif1XaHr5VQ");
        zbc zbc1 = zbb0.zbb();
        super(context0, zbz.zbc, zbc1, Settings.DEFAULT_SETTINGS);
    }

    @Override  // com.google.android.gms.auth.api.identity.AuthorizationClient
    public final Task authorize(AuthorizationRequest authorizationRequest0) {
        Preconditions.checkNotNull(authorizationRequest0);
        Builder authorizationRequest$Builder0 = AuthorizationRequest.zba(authorizationRequest0);
        authorizationRequest$Builder0.zbb(((zbc)this.getApiOptions()).zbb());
        AuthorizationRequest authorizationRequest1 = authorizationRequest$Builder0.build();
        return this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{zbar.zbc}).run(new zbw(this, authorizationRequest1)).setAutoResolveMissingFeatures(false).setMethodKey(0x5FE).build());
    }

    @Override  // com.google.android.gms.auth.api.identity.AuthorizationClient
    public final AuthorizationResult getAuthorizationResultFromIntent(Intent intent0) throws ApiException {
        if(intent0 == null) {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
        Status status0 = (Status)SafeParcelableSerializer.deserializeFromIntentExtra(intent0, "status", Status.CREATOR);
        if(status0 == null) {
            throw new ApiException(Status.RESULT_CANCELED);
        }
        if(!status0.isSuccess()) {
            throw new ApiException(status0);
        }
        AuthorizationResult authorizationResult0 = (AuthorizationResult)SafeParcelableSerializer.deserializeFromIntentExtra(intent0, "authorization_result", AuthorizationResult.CREATOR);
        if(authorizationResult0 == null) {
            throw new ApiException(Status.RESULT_INTERNAL_ERROR);
        }
        return authorizationResult0;
    }
}

