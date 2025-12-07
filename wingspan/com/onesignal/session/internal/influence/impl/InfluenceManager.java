package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.application.AppEntryAction;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u00A2\u0006\u0002\u0010\rJ\u001C\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u001FH\u0002J\u0012\u0010&\u001A\u0004\u0018\u00010\u00102\u0006\u0010#\u001A\u00020$H\u0002J\u0016\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F2\u0006\u0010#\u001A\u00020$H\u0002J\u0010\u0010(\u001A\u00020\"2\u0006\u0010)\u001A\u00020\u001FH\u0016J\u0010\u0010*\u001A\u00020\"2\u0006\u0010+\u001A\u00020\u001FH\u0016J\b\u0010,\u001A\u00020\"H\u0016J\u0010\u0010-\u001A\u00020\"2\u0006\u0010)\u001A\u00020\u001FH\u0016J\u0010\u0010.\u001A\u00020\"2\u0006\u0010+\u001A\u00020\u001FH\u0016J\b\u0010/\u001A\u00020\"H\u0016J\u0010\u00100\u001A\u00020\"2\u0006\u00101\u001A\u000202H\u0016J\b\u00103\u001A\u00020\"H\u0016J\u0010\u00104\u001A\u00020\"2\u0006\u0010#\u001A\u00020$H\u0002J,\u00105\u001A\u0002062\u0006\u00107\u001A\u00020\u00102\u0006\u00108\u001A\u0002092\b\u0010:\u001A\u0004\u0018\u00010\u001F2\b\u0010;\u001A\u0004\u0018\u00010<H\u0002J,\u0010=\u001A\u0002062\u0006\u00107\u001A\u00020\u00102\u0006\u00108\u001A\u0002092\b\u0010:\u001A\u0004\u0018\u00010\u001F2\b\u0010;\u001A\u0004\u0018\u00010<H\u0002R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\u00020\u00108BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00190\u000F8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001A\u0010\u0012R\u0014\u0010\u001B\u001A\u00020\u00108BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001C\u0010\u0017R\u001A\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020 0\u001EX\u0082\u0004\u00A2\u0006\u0002\n\u0000\u00A8\u0006>"}, d2 = {"Lcom/onesignal/session/internal/influence/impl/InfluenceManager;", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "preferences", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "timeProvider", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/time/ITime;)V", "channels", "", "Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "getChannels", "()Ljava/util/List;", "dataRepository", "Lcom/onesignal/session/internal/influence/impl/InfluenceDataRepository;", "iAMChannelTracker", "getIAMChannelTracker", "()Lcom/onesignal/session/internal/influence/impl/IChannelTracker;", "influences", "Lcom/onesignal/session/internal/influence/Influence;", "getInfluences", "notificationChannelTracker", "getNotificationChannelTracker", "trackers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/onesignal/session/internal/influence/impl/ChannelTracker;", "attemptSessionUpgrade", "", "entryAction", "Lcom/onesignal/core/internal/application/AppEntryAction;", "directId", "getChannelByEntryAction", "getChannelsToResetByEntryAction", "onDirectInfluenceFromIAM", "messageId", "onDirectInfluenceFromNotification", "notificationId", "onInAppMessageDismissed", "onInAppMessageDisplayed", "onNotificationReceived", "onSessionActive", "onSessionEnded", "duration", "", "onSessionStarted", "restartSessionTrackersIfNeeded", "setSessionTracker", "", "channelTracker", "influenceType", "Lcom/onesignal/session/internal/influence/InfluenceType;", "directNotificationId", "indirectNotificationIds", "Lorg/json/JSONArray;", "willChangeSessionTracker", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InfluenceManager implements IInfluenceManager, ISessionLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ISessionService _sessionService;
    private final InfluenceDataRepository dataRepository;
    private final ConcurrentHashMap trackers;

    public InfluenceManager(ISessionService iSessionService0, IApplicationService iApplicationService0, ConfigModelStore configModelStore0, IPreferencesService iPreferencesService0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iSessionService0, "_sessionService");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iPreferencesService0, "preferences");
        Intrinsics.checkNotNullParameter(iTime0, "timeProvider");
        super();
        this._sessionService = iSessionService0;
        this._applicationService = iApplicationService0;
        this._configModelStore = configModelStore0;
        ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap();
        this.trackers = concurrentHashMap0;
        InfluenceDataRepository influenceDataRepository0 = new InfluenceDataRepository(iPreferencesService0, configModelStore0);
        this.dataRepository = influenceDataRepository0;
        concurrentHashMap0.put(InfluenceConstants.INSTANCE.getIAM_TAG(), new InAppMessageTracker(influenceDataRepository0, iTime0));
        concurrentHashMap0.put(InfluenceConstants.INSTANCE.getNOTIFICATION_TAG(), new NotificationTracker(influenceDataRepository0, iTime0));
        iSessionService0.subscribe(this);
        Collection collection0 = concurrentHashMap0.values();
        Intrinsics.checkNotNullExpressionValue(collection0, "trackers.values");
        for(Object object0: collection0) {
            ((ChannelTracker)object0).initInfluencedTypeFromCache();
        }
    }

    private final void attemptSessionUpgrade(AppEntryAction appEntryAction0, String s) {
        boolean z;
        Influence influence0;
        Logging.debug$default(("InfluenceManager.attemptSessionUpgrade(entryAction: " + appEntryAction0 + ", directId: " + s + ')'), null, 2, null);
        IChannelTracker iChannelTracker0 = this.getChannelByEntryAction(appEntryAction0);
        List list0 = this.getChannelsToResetByEntryAction(appEntryAction0);
        List list1 = new ArrayList();
        if(iChannelTracker0 == null) {
            influence0 = null;
            z = false;
        }
        else {
            influence0 = iChannelTracker0.getCurrentSessionInfluence();
            InfluenceType influenceType0 = InfluenceType.DIRECT;
            if(s == null) {
                s = iChannelTracker0.getDirectId();
            }
            z = this.setSessionTracker(iChannelTracker0, influenceType0, s, null);
        }
        if(z) {
            Logging.debug$default(("InfluenceManager.attemptSessionUpgrade: channel updated, search for ending direct influences on channels: " + list0), null, 2, null);
            Intrinsics.checkNotNull(influence0);
            list1.add(influence0);
            for(Object object0: list0) {
                IChannelTracker iChannelTracker1 = (IChannelTracker)object0;
                if(iChannelTracker1.getInfluenceType() != null && false) {
                    list1.add(iChannelTracker1.getCurrentSessionInfluence());
                    iChannelTracker1.resetAndInitInfluence();
                }
            }
        }
        Logging.debug$default("InfluenceManager.attemptSessionUpgrade: try UNATTRIBUTED to INDIRECT upgrade", null, 2, null);
        for(Object object1: list0) {
            IChannelTracker iChannelTracker2 = (IChannelTracker)object1;
            if(iChannelTracker2.getInfluenceType() != null && false) {
                JSONArray jSONArray0 = iChannelTracker2.getLastReceivedIds();
                if(jSONArray0.length() > 0) {
                    Influence influence1 = iChannelTracker2.getCurrentSessionInfluence();
                    if(this.setSessionTracker(iChannelTracker2, InfluenceType.INDIRECT, null, jSONArray0)) {
                        list1.add(influence1);
                    }
                }
            }
        }
        Logging.debug$default(("InfluenceManager.attemptSessionUpgrade: Trackers after update attempt: " + this.getChannels()), null, 2, null);
    }

    static void attemptSessionUpgrade$default(InfluenceManager influenceManager0, AppEntryAction appEntryAction0, String s, int v, Object object0) {
        if((v & 2) != 0) {
            s = null;
        }
        influenceManager0.attemptSessionUpgrade(appEntryAction0, s);
    }

    // 去混淆评级： 低(30)
    private final IChannelTracker getChannelByEntryAction(AppEntryAction appEntryAction0) {
        return null;
    }

    private final List getChannels() {
        List list0 = new ArrayList();
        list0.add(this.getNotificationChannelTracker());
        list0.add(this.getIAMChannelTracker());
        return list0;
    }

    // 去混淆评级： 低(20)
    private final List getChannelsToResetByEntryAction(AppEntryAction appEntryAction0) {
        List list0 = new ArrayList();
        list0.add(this.getIAMChannelTracker());
        return list0;
    }

    private final IChannelTracker getIAMChannelTracker() {
        Object object0 = this.trackers.get(InfluenceConstants.INSTANCE.getIAM_TAG());
        Intrinsics.checkNotNull(object0);
        return (IChannelTracker)object0;
    }

    @Override  // com.onesignal.session.internal.influence.IInfluenceManager
    public List getInfluences() {
        Collection collection0 = this.trackers.values();
        Intrinsics.checkNotNullExpressionValue(collection0, "trackers.values");
        ArrayList arrayList0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection0, 10));
        for(Object object0: collection0) {
            arrayList0.add(((ChannelTracker)object0).getCurrentSessionInfluence());
        }
        return arrayList0;
    }

    private final IChannelTracker getNotificationChannelTracker() {
        Object object0 = this.trackers.get(InfluenceConstants.INSTANCE.getNOTIFICATION_TAG());
        Intrinsics.checkNotNull(object0);
        return (IChannelTracker)object0;
    }

    @Override  // com.onesignal.session.internal.influence.IInfluenceManager
    public void onDirectInfluenceFromIAM(String s) {
        Intrinsics.checkNotNullParameter(s, "messageId");
        Logging.debug$default(("InfluenceManager.onDirectInfluenceFromIAM(messageId: " + s + ')'), null, 2, null);
        this.setSessionTracker(this.getIAMChannelTracker(), InfluenceType.DIRECT, s, null);
    }

    @Override  // com.onesignal.session.internal.influence.IInfluenceManager
    public void onDirectInfluenceFromNotification(String s) {
        Intrinsics.checkNotNullParameter(s, "notificationId");
        Logging.debug$default(("InfluenceManager.onDirectInfluenceFromNotification(notificationId: " + s + ')'), null, 2, null);
        if(s.length() == 0) {
            return;
        }
        this.attemptSessionUpgrade(AppEntryAction.NOTIFICATION_CLICK, s);
    }

    @Override  // com.onesignal.session.internal.influence.IInfluenceManager
    public void onInAppMessageDismissed() {
        Logging.debug$default("InfluenceManager.onInAppMessageDismissed()", null, 2, null);
        this.getIAMChannelTracker().resetAndInitInfluence();
    }

    @Override  // com.onesignal.session.internal.influence.IInfluenceManager
    public void onInAppMessageDisplayed(String s) {
        Intrinsics.checkNotNullParameter(s, "messageId");
        Logging.debug$default(("InfluenceManager.onInAppMessageReceived(messageId: " + s + ')'), null, 2, null);
        IChannelTracker iChannelTracker0 = this.getIAMChannelTracker();
        iChannelTracker0.saveLastId(s);
        iChannelTracker0.resetAndInitInfluence();
    }

    @Override  // com.onesignal.session.internal.influence.IInfluenceManager
    public void onNotificationReceived(String s) {
        Intrinsics.checkNotNullParameter(s, "notificationId");
        Logging.debug$default(("InfluenceManager.onNotificationReceived(notificationId: " + s + ')'), null, 2, null);
        if(s.length() == 0) {
            return;
        }
        this.getNotificationChannelTracker().saveLastId(s);
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
        InfluenceManager.attemptSessionUpgrade$default(this, this._applicationService.getEntryState(), null, 2, null);
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long v) {
    }

    @Override  // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        this.restartSessionTrackersIfNeeded(this._applicationService.getEntryState());
    }

    private final void restartSessionTrackersIfNeeded(AppEntryAction appEntryAction0) {
        List list0 = this.getChannelsToResetByEntryAction(appEntryAction0);
        List list1 = new ArrayList();
        Logging.debug$default(("InfluenceManager.restartSessionIfNeeded(entryAction: " + appEntryAction0 + "):\n channelTrackers: " + list0), null, 2, null);
        for(Object object0: list0) {
            IChannelTracker iChannelTracker0 = (IChannelTracker)object0;
            JSONArray jSONArray0 = iChannelTracker0.getLastReceivedIds();
            Logging.debug$default(("InfluenceManager.restartSessionIfNeeded: lastIds: " + jSONArray0), null, 2, null);
            Influence influence0 = iChannelTracker0.getCurrentSessionInfluence();
            if((jSONArray0.length() <= 0 ? this.setSessionTracker(iChannelTracker0, InfluenceType.UNATTRIBUTED, null, null) : this.setSessionTracker(iChannelTracker0, InfluenceType.INDIRECT, null, jSONArray0))) {
                list1.add(influence0);
            }
        }
    }

    private final boolean setSessionTracker(IChannelTracker iChannelTracker0, InfluenceType influenceType0, String s, JSONArray jSONArray0) {
        if(!this.willChangeSessionTracker(iChannelTracker0, influenceType0, s, jSONArray0)) {
            return false;
        }
        Logging.debug$default(StringsKt.trimIndent(("\n            ChannelTracker changed: " + iChannelTracker0.getIdTag() + "\n            from:\n            influenceType: " + iChannelTracker0.getInfluenceType() + ", directNotificationId: " + iChannelTracker0.getDirectId() + ", indirectNotificationIds: " + iChannelTracker0.getIndirectIds() + "\n            to:\n            influenceType: " + influenceType0 + ", directNotificationId: " + s + ", indirectNotificationIds: " + jSONArray0 + "\n            ")), null, 2, null);
        iChannelTracker0.setInfluenceType(influenceType0);
        iChannelTracker0.setDirectId(s);
        iChannelTracker0.setIndirectIds(jSONArray0);
        iChannelTracker0.cacheState();
        Logging.debug$default(("InfluenceManager.setSessionTracker: Trackers changed to: " + this.getChannels()), null, 2, null);
        return true;
    }

    // 去混淆评级： 低(22)
    private final boolean willChangeSessionTracker(IChannelTracker iChannelTracker0, InfluenceType influenceType0, String s, JSONArray jSONArray0) {
        if(influenceType0 != iChannelTracker0.getInfluenceType()) {
            return true;
        }
        iChannelTracker0.getInfluenceType();
        return false;
    }
}

