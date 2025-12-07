package com.onesignal.core.internal.config;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\r\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005R$\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00078F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR$\u0010\r\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00078F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\n\"\u0004\b\u000F\u0010\fR$\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00078F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0006\u001A\u00020\u00138F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0006\u001A\u00020\u00138F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R$\u0010\u001A\u001A\u00020\u00132\u0006\u0010\u0006\u001A\u00020\u00138F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001A\u0010\u0015\"\u0004\b\u001B\u0010\u0017R$\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00078F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001D\u0010\n\"\u0004\b\u001E\u0010\f¨\u0006 "}, d2 = {"Lcom/onesignal/core/internal/config/InfluenceConfigModel;", "Lcom/onesignal/common/modeling/Model;", "parentModel", "parentProperty", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "value", "", "iamLimit", "getIamLimit", "()I", "setIamLimit", "(I)V", "indirectIAMAttributionWindow", "getIndirectIAMAttributionWindow", "setIndirectIAMAttributionWindow", "indirectNotificationAttributionWindow", "getIndirectNotificationAttributionWindow", "setIndirectNotificationAttributionWindow", "", "isDirectEnabled", "()Z", "setDirectEnabled", "(Z)V", "isIndirectEnabled", "setIndirectEnabled", "isUnattributedEnabled", "setUnattributedEnabled", "notificationLimit", "getNotificationLimit", "setNotificationLimit", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InfluenceConfigModel extends Model {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/core/internal/config/InfluenceConfigModel$Companion;", "", "()V", "DEFAULT_INDIRECT_ATTRIBUTION_WINDOW", "", "DEFAULT_NOTIFICATION_LIMIT", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    public static final int DEFAULT_INDIRECT_ATTRIBUTION_WINDOW = 0x5A0;
    public static final int DEFAULT_NOTIFICATION_LIMIT = 10;

    static {
        InfluenceConfigModel.Companion = new Companion(null);
    }

    public InfluenceConfigModel(Model model0, String s) {
        Intrinsics.checkNotNullParameter(model0, "parentModel");
        Intrinsics.checkNotNullParameter(s, "parentProperty");
        super(model0, s);
    }

    public final int getIamLimit() {
        return this.getIntProperty("iamLimit", com.onesignal.core.internal.config.InfluenceConfigModel.iamLimit.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.InfluenceConfigModel.iamLimit.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.InfluenceConfigModel.iamLimit.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.InfluenceConfigModel.iamLimit.2.INSTANCE = new com.onesignal.core.internal.config.InfluenceConfigModel.iamLimit.2();
            }

            com.onesignal.core.internal.config.InfluenceConfigModel.iamLimit.2() {
                super(0);
            }

            public final Integer invoke() {
                return 10;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final int getIndirectIAMAttributionWindow() {
        return this.getIntProperty("indirectIAMAttributionWindow", com.onesignal.core.internal.config.InfluenceConfigModel.indirectIAMAttributionWindow.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.InfluenceConfigModel.indirectIAMAttributionWindow.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.InfluenceConfigModel.indirectIAMAttributionWindow.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.InfluenceConfigModel.indirectIAMAttributionWindow.2.INSTANCE = new com.onesignal.core.internal.config.InfluenceConfigModel.indirectIAMAttributionWindow.2();
            }

            com.onesignal.core.internal.config.InfluenceConfigModel.indirectIAMAttributionWindow.2() {
                super(0);
            }

            public final Integer invoke() {
                return 0x5A0;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final int getIndirectNotificationAttributionWindow() {
        return this.getIntProperty("indirectNotificationAttributionWindow", com.onesignal.core.internal.config.InfluenceConfigModel.indirectNotificationAttributionWindow.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.InfluenceConfigModel.indirectNotificationAttributionWindow.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.InfluenceConfigModel.indirectNotificationAttributionWindow.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.InfluenceConfigModel.indirectNotificationAttributionWindow.2.INSTANCE = new com.onesignal.core.internal.config.InfluenceConfigModel.indirectNotificationAttributionWindow.2();
            }

            com.onesignal.core.internal.config.InfluenceConfigModel.indirectNotificationAttributionWindow.2() {
                super(0);
            }

            public final Integer invoke() {
                return 0x5A0;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final int getNotificationLimit() {
        return this.getIntProperty("notificationLimit", com.onesignal.core.internal.config.InfluenceConfigModel.notificationLimit.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.InfluenceConfigModel.notificationLimit.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.InfluenceConfigModel.notificationLimit.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.InfluenceConfigModel.notificationLimit.2.INSTANCE = new com.onesignal.core.internal.config.InfluenceConfigModel.notificationLimit.2();
            }

            com.onesignal.core.internal.config.InfluenceConfigModel.notificationLimit.2() {
                super(0);
            }

            public final Integer invoke() {
                return 10;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean isDirectEnabled() {
        return this.getBooleanProperty("isDirectEnabled", com.onesignal.core.internal.config.InfluenceConfigModel.isDirectEnabled.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.InfluenceConfigModel.isDirectEnabled.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.InfluenceConfigModel.isDirectEnabled.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.InfluenceConfigModel.isDirectEnabled.2.INSTANCE = new com.onesignal.core.internal.config.InfluenceConfigModel.isDirectEnabled.2();
            }

            com.onesignal.core.internal.config.InfluenceConfigModel.isDirectEnabled.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean isIndirectEnabled() {
        return this.getBooleanProperty("isIndirectEnabled", com.onesignal.core.internal.config.InfluenceConfigModel.isIndirectEnabled.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.InfluenceConfigModel.isIndirectEnabled.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.InfluenceConfigModel.isIndirectEnabled.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.InfluenceConfigModel.isIndirectEnabled.2.INSTANCE = new com.onesignal.core.internal.config.InfluenceConfigModel.isIndirectEnabled.2();
            }

            com.onesignal.core.internal.config.InfluenceConfigModel.isIndirectEnabled.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean isUnattributedEnabled() {
        return this.getBooleanProperty("isUnattributedEnabled", com.onesignal.core.internal.config.InfluenceConfigModel.isUnattributedEnabled.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.core.internal.config.InfluenceConfigModel.isUnattributedEnabled.2 extends Lambda implements Function0 {
            public static final com.onesignal.core.internal.config.InfluenceConfigModel.isUnattributedEnabled.2 INSTANCE;

            static {
                com.onesignal.core.internal.config.InfluenceConfigModel.isUnattributedEnabled.2.INSTANCE = new com.onesignal.core.internal.config.InfluenceConfigModel.isUnattributedEnabled.2();
            }

            com.onesignal.core.internal.config.InfluenceConfigModel.isUnattributedEnabled.2() {
                super(0);
            }

            public final Boolean invoke() {
                return false;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final void setDirectEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "isDirectEnabled", z, null, false, 12, null);
    }

    public final void setIamLimit(int v) {
        Model.setIntProperty$default(this, "iamLimit", v, null, false, 12, null);
    }

    public final void setIndirectEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "isIndirectEnabled", z, null, false, 12, null);
    }

    public final void setIndirectIAMAttributionWindow(int v) {
        Model.setIntProperty$default(this, "indirectIAMAttributionWindow", v, null, false, 12, null);
    }

    public final void setIndirectNotificationAttributionWindow(int v) {
        Model.setIntProperty$default(this, "indirectNotificationAttributionWindow", v, null, false, 12, null);
    }

    public final void setNotificationLimit(int v) {
        Model.setIntProperty$default(this, "notificationLimit", v, null, false, 12, null);
    }

    public final void setUnattributedEnabled(boolean z) {
        Model.setBooleanProperty$default(this, "isUnattributedEnabled", z, null, false, 12, null);
    }
}

