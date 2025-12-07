package com.onesignal.core.internal.language.impl;

import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/onesignal/core/internal/language/impl/LanguageContext;", "Lcom/onesignal/core/internal/language/ILanguageContext;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "(Lcom/onesignal/user/internal/properties/PropertiesModelStore;)V", "deviceLanguageProvider", "Lcom/onesignal/core/internal/language/impl/LanguageProviderDevice;", "value", "", "language", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LanguageContext implements ILanguageContext {
    private final PropertiesModelStore _propertiesModelStore;
    private LanguageProviderDevice deviceLanguageProvider;

    public LanguageContext(PropertiesModelStore propertiesModelStore0) {
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        super();
        this._propertiesModelStore = propertiesModelStore0;
        this.deviceLanguageProvider = new LanguageProviderDevice();
    }

    @Override  // com.onesignal.core.internal.language.ILanguageContext
    public String getLanguage() {
        String s = ((PropertiesModel)this._propertiesModelStore.getModel()).getLanguage();
        return s == null ? "zh-CN" : s;
    }

    @Override  // com.onesignal.core.internal.language.ILanguageContext
    public void setLanguage(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        ((PropertiesModel)this._propertiesModelStore.getModel()).setLanguage(s);
    }
}

