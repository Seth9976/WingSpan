package com.onesignal.common.modeling;

import com.onesignal.core.internal.preferences.IPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0017\u0010\u000B\u001A\u00028\u00002\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000ER\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/onesignal/common/modeling/SimpleModelStore;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/modeling/ModelStore;", "_create", "Lkotlin/Function0;", "name", "", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "create", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/onesignal/common/modeling/Model;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class SimpleModelStore extends ModelStore {
    private final Function0 _create;

    public SimpleModelStore(Function0 function00, String s, IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(function00, "_create");
        super(s, iPreferencesService0);
        this._create = function00;
        this.load();
    }

    public SimpleModelStore(Function0 function00, String s, IPreferencesService iPreferencesService0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            s = null;
        }
        if((v & 4) != 0) {
            iPreferencesService0 = null;
        }
        this(function00, s, iPreferencesService0);
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public Model create(JSONObject jSONObject0) {
        Model model0 = (Model)this._create.invoke();
        if(jSONObject0 != null) {
            model0.initializeFromJson(jSONObject0);
        }
        return model0;
    }
}

