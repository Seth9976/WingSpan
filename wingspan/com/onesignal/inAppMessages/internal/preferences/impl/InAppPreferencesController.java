package com.onesignal.inAppMessages.internal.preferences.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\t\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010!\u001A\u00020\"2\u000E\u0010#\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0018\u0010$\u001A\u00020\"2\u000E\u0010%\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR4\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\n\"\u0004\b\u000F\u0010\fR4\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR(\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0005\u001A\u0004\u0018\u00010\u00138V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001A\u0004\u0018\u00010\u00072\b\u0010\u0005\u001A\u0004\u0018\u00010\u00078V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR4\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001F\u0010\n\"\u0004\b \u0010\f¨\u0006&"}, d2 = {"Lcom/onesignal/inAppMessages/internal/preferences/impl/InAppPreferencesController;", "Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "value", "", "", "clickedMessagesId", "getClickedMessagesId", "()Ljava/util/Set;", "setClickedMessagesId", "(Ljava/util/Set;)V", "dismissedMessagesId", "getDismissedMessagesId", "setDismissedMessagesId", "impressionesMessagesId", "getImpressionesMessagesId", "setImpressionesMessagesId", "", "lastTimeInAppDismissed", "getLastTimeInAppDismissed", "()Ljava/lang/Long;", "setLastTimeInAppDismissed", "(Ljava/lang/Long;)V", "savedIAMs", "getSavedIAMs", "()Ljava/lang/String;", "setSavedIAMs", "(Ljava/lang/String;)V", "viewPageImpressionedIds", "getViewPageImpressionedIds", "setViewPageImpressionedIds", "cleanInAppMessageClickedClickIds", "", "oldClickedClickIds", "cleanInAppMessageIds", "oldMessageIds", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppPreferencesController implements IInAppPreferencesController {
    private final IPreferencesService _prefs;

    public InAppPreferencesController(IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(iPreferencesService0, "_prefs");
        super();
        this._prefs = iPreferencesService0;
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void cleanInAppMessageClickedClickIds(Set set0) {
        if(set0 != null && !set0.isEmpty() != 0) {
            Set set1 = this._prefs.getStringSet("OneSignal", "PREFS_OS_CLICKED_CLICK_IDS_IAMS", null);
            if(set1 != null && !set1.isEmpty() != 0) {
                Set set2 = CollectionsKt.toMutableSet(set1);
                set2.removeAll(set0);
                this._prefs.saveStringSet("OneSignal", "PREFS_OS_CLICKED_CLICK_IDS_IAMS", set2);
            }
        }
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void cleanInAppMessageIds(Set set0) {
        if(set0 != null && !set0.isEmpty() != 0) {
            Set set1 = this._prefs.getStringSet("OneSignal", "PREFS_OS_DISPLAYED_IAMS", null);
            Set set2 = this._prefs.getStringSet("OneSignal", "PREFS_OS_IMPRESSIONED_IAMS", null);
            if(set1 != null && !set1.isEmpty() != 0) {
                Set set3 = CollectionsKt.toMutableSet(set1);
                set3.removeAll(set0);
                this._prefs.saveStringSet("OneSignal", "PREFS_OS_DISPLAYED_IAMS", set3);
            }
            if(set2 != null && !set2.isEmpty() != 0) {
                Set set4 = CollectionsKt.toMutableSet(set2);
                set4.removeAll(set0);
                this._prefs.saveStringSet("OneSignal", "PREFS_OS_IMPRESSIONED_IAMS", set4);
            }
        }
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Set getClickedMessagesId() {
        return this._prefs.getStringSet("OneSignal", "PREFS_OS_CLICKED_CLICK_IDS_IAMS", null);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Set getDismissedMessagesId() {
        return this._prefs.getStringSet("OneSignal", "PREFS_OS_DISPLAYED_IAMS", null);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Set getImpressionesMessagesId() {
        return this._prefs.getStringSet("OneSignal", "PREFS_OS_IMPRESSIONED_IAMS", null);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Long getLastTimeInAppDismissed() {
        return this._prefs.getLong("OneSignal", "PREFS_OS_IAM_LAST_DISMISSED_TIME", null);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public String getSavedIAMs() {
        return this._prefs.getString("OneSignal", "PREFS_OS_CACHED_IAMS", null);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public Set getViewPageImpressionedIds() {
        return this._prefs.getStringSet("OneSignal", "PREFS_OS_PAGE_IMPRESSIONED_IAMS", null);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setClickedMessagesId(Set set0) {
        this._prefs.saveStringSet("OneSignal", "PREFS_OS_CLICKED_CLICK_IDS_IAMS", set0);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setDismissedMessagesId(Set set0) {
        this._prefs.saveStringSet("OneSignal", "PREFS_OS_DISPLAYED_IAMS", set0);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setImpressionesMessagesId(Set set0) {
        this._prefs.saveStringSet("OneSignal", "PREFS_OS_IMPRESSIONED_IAMS", set0);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setLastTimeInAppDismissed(Long long0) {
        this._prefs.saveLong("OneSignal", "PREFS_OS_IAM_LAST_DISMISSED_TIME", long0);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setSavedIAMs(String s) {
        this._prefs.saveString("OneSignal", "PREFS_OS_CACHED_IAMS", s);
    }

    @Override  // com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController
    public void setViewPageImpressionedIds(Set set0) {
        this._prefs.saveStringSet("OneSignal", "PREFS_OS_PAGE_IMPRESSIONED_IAMS", set0);
    }
}

