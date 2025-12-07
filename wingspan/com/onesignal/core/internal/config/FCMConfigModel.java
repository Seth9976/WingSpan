package com.onesignal.core.internal.config;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000E\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005R(\u0010\u0007\u001A\u0004\u0018\u00010\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR(\u0010\f\u001A\u0004\u0018\u00010\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000BR(\u0010\u000F\u001A\u0004\u0018\u00010\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000B¨\u0006\u0012"}, d2 = {"Lcom/onesignal/core/internal/config/FCMConfigModel;", "Lcom/onesignal/common/modeling/Model;", "parentModel", "parentProperty", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "value", "apiKey", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "projectId", "getProjectId", "setProjectId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class FCMConfigModel extends Model {
    public FCMConfigModel(Model model0, String s) {
        Intrinsics.checkNotNullParameter(model0, "parentModel");
        Intrinsics.checkNotNullParameter(s, "parentProperty");
        super(model0, s);
    }

    public final String getApiKey() {
        return this.getOptStringProperty("apiKey", com.onesignal.core.internal.config.FCMConfigModel.apiKey.2.INSTANCE);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0010\u0000\u001A\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.FCMConfigModel.apiKey.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.FCMConfigModel.apiKey.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.FCMConfigModel.apiKey.2.INSTANCE = new com.onesignal.core.internal.config.FCMConfigModel.apiKey.2();
            }

            com.onesignal.core.internal.config.FCMConfigModel.apiKey.2() {
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return null;
            }

            public final String invoke() [...] // Inlined contents
        }

    }

    public final String getAppId() {
        return this.getOptStringProperty("appId", com.onesignal.core.internal.config.FCMConfigModel.appId.2.INSTANCE);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0010\u0000\u001A\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.FCMConfigModel.appId.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.FCMConfigModel.appId.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.FCMConfigModel.appId.2.INSTANCE = new com.onesignal.core.internal.config.FCMConfigModel.appId.2();
            }

            com.onesignal.core.internal.config.FCMConfigModel.appId.2() {
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return null;
            }

            public final String invoke() [...] // Inlined contents
        }

    }

    public final String getProjectId() {
        return this.getOptStringProperty("projectId", com.onesignal.core.internal.config.FCMConfigModel.projectId.2.INSTANCE);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0010\u0000\u001A\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.FCMConfigModel.projectId.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.FCMConfigModel.projectId.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.FCMConfigModel.projectId.2.INSTANCE = new com.onesignal.core.internal.config.FCMConfigModel.projectId.2();
            }

            com.onesignal.core.internal.config.FCMConfigModel.projectId.2() {
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return null;
            }

            public final String invoke() [...] // Inlined contents
        }

    }

    public final void setApiKey(String s) {
        Model.setOptStringProperty$default(this, "apiKey", s, null, false, 12, null);
    }

    public final void setAppId(String s) {
        Model.setOptStringProperty$default(this, "appId", s, null, false, 12, null);
    }

    public final void setProjectId(String s) {
        Model.setOptStringProperty$default(this, "projectId", s, null, false, 12, null);
    }
}

