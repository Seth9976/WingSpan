package com.onesignal.core.internal.operations.impl;

import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelStore;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteAliasOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.operations.SetAliasOperation;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import com.onesignal.user.internal.operations.TrackSessionEndOperation;
import com.onesignal.user.internal.operations.TrackSessionStartOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u00022\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationModelStore;", "Lcom/onesignal/common/modeling/ModelStore;", "Lcom/onesignal/core/internal/operations/Operation;", "prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "create", "jsonObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OperationModelStore extends ModelStore {
    public OperationModelStore(IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(iPreferencesService0, "prefs");
        super("operations", iPreferencesService0);
        this.load();
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public Model create(JSONObject jSONObject0) {
        return this.create(jSONObject0);
    }

    public Operation create(JSONObject jSONObject0) {
        Operation operation0;
        if(jSONObject0 == null) {
            Logging.error$default("null jsonObject sent to OperationModelStore.create", null, 2, null);
            return null;
        }
        if(!jSONObject0.has("name")) {
            Logging.error$default("jsonObject must have \'name\' attribute", null, 2, null);
            return null;
        }
        String s = jSONObject0.getString("name");
        if(s == null) {
            throw new Exception("Unrecognized operation: " + s);
        }
        switch(s) {
            case "create-subscription": {
                operation0 = new CreateSubscriptionOperation();
                break;
            }
            case "delete-alias": {
                operation0 = new DeleteAliasOperation();
                break;
            }
            case "delete-subscription": {
                operation0 = new DeleteSubscriptionOperation();
                break;
            }
            case "delete-tag": {
                operation0 = new DeleteTagOperation();
                break;
            }
            case "login-user": {
                operation0 = new LoginUserOperation();
                break;
            }
            case "login-user-from-subscription": {
                operation0 = new LoginUserFromSubscriptionOperation();
                break;
            }
            case "refresh-user": {
                operation0 = new RefreshUserOperation();
                break;
            }
            case "set-alias": {
                operation0 = new SetAliasOperation();
                break;
            }
            case "set-property": {
                operation0 = new SetPropertyOperation();
                break;
            }
            case "set-tag": {
                operation0 = new SetTagOperation();
                break;
            }
            case "track-purchase": {
                operation0 = new TrackPurchaseOperation();
                break;
            }
            case "track-session-end": {
                operation0 = new TrackSessionEndOperation();
                break;
            }
            case "track-session-start": {
                operation0 = new TrackSessionStartOperation();
                break;
            }
            case "transfer-subscription": {
                operation0 = new TransferSubscriptionOperation();
                break;
            }
            case "update-subscription": {
                operation0 = new UpdateSubscriptionOperation();
                break;
            }
            default: {
                throw new Exception("Unrecognized operation: " + s);
            }
        }
        operation0.initializeFromJson(jSONObject0);
        return operation0;
    }
}

