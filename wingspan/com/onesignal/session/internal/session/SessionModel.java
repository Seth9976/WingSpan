package com.onesignal.session.internal.session;

import com.onesignal.common.modeling.Model;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0003\u001A\u00020\r8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0003\u001A\u00020\u00128F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\u0007\"\u0004\b\u001A\u0010\t¨\u0006\u001B"}, d2 = {"Lcom/onesignal/session/internal/session/SessionModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "activeDuration", "getActiveDuration", "()J", "setActiveDuration", "(J)V", "focusTime", "getFocusTime", "setFocusTime", "", "isValid", "()Z", "setValid", "(Z)V", "", "sessionId", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "startTime", "getStartTime", "setStartTime", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SessionModel extends Model {
    public SessionModel() {
        super(null, null, 3, null);
    }

    public final long getActiveDuration() {
        return this.getLongProperty("activeDuration", com.onesignal.session.internal.session.SessionModel.activeDuration.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.session.internal.session.SessionModel.activeDuration.2 extends Lambda implements Function0 {
            public static final com.onesignal.session.internal.session.SessionModel.activeDuration.2 INSTANCE;

            static {
                com.onesignal.session.internal.session.SessionModel.activeDuration.2.INSTANCE = new com.onesignal.session.internal.session.SessionModel.activeDuration.2();
            }

            com.onesignal.session.internal.session.SessionModel.activeDuration.2() {
                super(0);
            }

            public final Long invoke() {
                return 0L;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final long getFocusTime() {
        return this.getLongProperty("focusTime", com.onesignal.session.internal.session.SessionModel.focusTime.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.session.internal.session.SessionModel.focusTime.2 extends Lambda implements Function0 {
            public static final com.onesignal.session.internal.session.SessionModel.focusTime.2 INSTANCE;

            static {
                com.onesignal.session.internal.session.SessionModel.focusTime.2.INSTANCE = new com.onesignal.session.internal.session.SessionModel.focusTime.2();
            }

            com.onesignal.session.internal.session.SessionModel.focusTime.2() {
                super(0);
            }

            public final Long invoke() {
                return 0L;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final String getSessionId() {
        return Model.getStringProperty$default(this, "sessionId", null, 2, null);
    }

    public final long getStartTime() {
        return this.getLongProperty("startTime", com.onesignal.session.internal.session.SessionModel.startTime.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.session.internal.session.SessionModel.startTime.2 extends Lambda implements Function0 {
            public static final com.onesignal.session.internal.session.SessionModel.startTime.2 INSTANCE;

            static {
                com.onesignal.session.internal.session.SessionModel.startTime.2.INSTANCE = new com.onesignal.session.internal.session.SessionModel.startTime.2();
            }

            com.onesignal.session.internal.session.SessionModel.startTime.2() {
                super(0);
            }

            public final Long invoke() {
                return System.currentTimeMillis();
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final boolean isValid() {
        return this.getBooleanProperty("isValid", com.onesignal.session.internal.session.SessionModel.isValid.2.INSTANCE);

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.session.internal.session.SessionModel.isValid.2 extends Lambda implements Function0 {
            public static final com.onesignal.session.internal.session.SessionModel.isValid.2 INSTANCE;

            static {
                com.onesignal.session.internal.session.SessionModel.isValid.2.INSTANCE = new com.onesignal.session.internal.session.SessionModel.isValid.2();
            }

            com.onesignal.session.internal.session.SessionModel.isValid.2() {
                super(0);
            }

            public final Boolean invoke() {
                return true;
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public final void setActiveDuration(long v) {
        Model.setLongProperty$default(this, "activeDuration", v, null, false, 12, null);
    }

    public final void setFocusTime(long v) {
        Model.setLongProperty$default(this, "focusTime", v, null, false, 12, null);
    }

    public final void setSessionId(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "sessionId", s, null, false, 12, null);
    }

    public final void setStartTime(long v) {
        Model.setLongProperty$default(this, "startTime", v, null, false, 12, null);
    }

    public final void setValid(boolean z) {
        Model.setBooleanProperty$default(this, "isValid", z, null, false, 12, null);
    }
}

