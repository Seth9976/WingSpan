package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/OutcomeEventsPreferences;", "Lcom/onesignal/session/internal/outcomes/impl/IOutcomeEventsPreferences;", "preferences", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "value", "", "", "unattributedUniqueOutcomeEventsSentByChannel", "getUnattributedUniqueOutcomeEventsSentByChannel", "()Ljava/util/Set;", "setUnattributedUniqueOutcomeEventsSentByChannel", "(Ljava/util/Set;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OutcomeEventsPreferences implements IOutcomeEventsPreferences {
    private final IPreferencesService preferences;

    public OutcomeEventsPreferences(IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(iPreferencesService0, "preferences");
        super();
        this.preferences = iPreferencesService0;
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsPreferences
    public Set getUnattributedUniqueOutcomeEventsSentByChannel() {
        return this.preferences.getStringSet("OneSignal", "PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT", null);
    }

    @Override  // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsPreferences
    public void setUnattributedUniqueOutcomeEventsSentByChannel(Set set0) {
        this.preferences.saveStringSet("OneSignal", "PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT", set0);
    }
}

