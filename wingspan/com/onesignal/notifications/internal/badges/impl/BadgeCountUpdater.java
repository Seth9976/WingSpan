package com.onesignal.notifications.internal.badges.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase.DefaultImpls;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadger;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000B\u001A\u00020\fH\u0002J\b\u0010\r\u001A\u00020\fH\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016J\b\u0010\u0012\u001A\u00020\u000FH\u0002J\b\u0010\u0013\u001A\u00020\u000FH\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/notifications/internal/badges/impl/BadgeCountUpdater;", "Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_queryHelper", "Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;", "_databaseProvider", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;Lcom/onesignal/core/internal/database/IDatabaseProvider;)V", "badgesEnabled", "", "areBadgeSettingsEnabled", "", "areBadgesEnabled", "update", "", "updateCount", "count", "updateFallback", "updateStandard", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class BadgeCountUpdater implements IBadgeCountUpdater {
    private final IApplicationService _applicationService;
    private final IDatabaseProvider _databaseProvider;
    private final INotificationQueryHelper _queryHelper;
    private int badgesEnabled;

    public BadgeCountUpdater(IApplicationService iApplicationService0, INotificationQueryHelper iNotificationQueryHelper0, IDatabaseProvider iDatabaseProvider0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationQueryHelper0, "_queryHelper");
        Intrinsics.checkNotNullParameter(iDatabaseProvider0, "_databaseProvider");
        super();
        this._applicationService = iApplicationService0;
        this._queryHelper = iNotificationQueryHelper0;
        this._databaseProvider = iDatabaseProvider0;
        this.badgesEnabled = -1;
    }

    private final boolean areBadgeSettingsEnabled() {
        switch(this.badgesEnabled) {
            case -1: {
                try {
                    ApplicationInfo applicationInfo0 = this._applicationService.getAppContext().getPackageManager().getApplicationInfo("com.MonsterCouch.Wingspan", 0x80);
                    Intrinsics.checkNotNullExpressionValue(applicationInfo0, "_applicationService.appC…A_DATA,\n                )");
                    Bundle bundle0 = applicationInfo0.metaData;
                    if(bundle0 != null) {
                        this.badgesEnabled = Intrinsics.areEqual("DISABLE", bundle0.getString("com.onesignal.BadgeCount")) ? 0 : 1;
                        return this.badgesEnabled == 1;
                    }
                    this.badgesEnabled = 1;
                    return true;
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                    this.badgesEnabled = 0;
                    Logging.error("Error reading meta-data tag \'com.onesignal.BadgeCount\'. Disabling badge setting.", packageManager$NameNotFoundException0);
                    return this.badgesEnabled == 1;
                }
            }
            case 1: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private final boolean areBadgesEnabled() {
        if(this.areBadgeSettingsEnabled()) {
            Context context0 = this._applicationService.getAppContext();
            return NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, context0, null, 2, null);
        }
        return false;
    }

    @Override  // com.onesignal.notifications.internal.badges.IBadgeCountUpdater
    public void update() {
        if(!this.areBadgesEnabled()) {
            return;
        }
        this.updateStandard();
    }

    @Override  // com.onesignal.notifications.internal.badges.IBadgeCountUpdater
    public void updateCount(int v) {
        if(!this.areBadgeSettingsEnabled()) {
            return;
        }
        try {
            ShortcutBadger.applyCountOrThrow(this._applicationService.getAppContext(), v);
        }
        catch(ShortcutBadgeException unused_ex) {
        }
    }

    private final void updateFallback() {
        IntRef ref$IntRef0 = new IntRef();
        DefaultImpls.query$default(this._databaseProvider.getOs(), "notification", null, this._queryHelper.recentUninteractedWithNotificationsWhere().toString(), null, null, null, null, "49", new Function1() {
            final IntRef $notificationCount;

            {
                this.$notificationCount = ref$IntRef0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ICursor)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ICursor iCursor0) {
                Intrinsics.checkNotNullParameter(iCursor0, "it");
                this.$notificationCount.element = iCursor0.getCount();
            }
        }, 0x7A, null);
        this.updateCount(ref$IntRef0.element);
    }

    private final void updateStandard() {
        Context context0 = this._applicationService.getAppContext();
        StatusBarNotification[] arr_statusBarNotification = NotificationHelper.INSTANCE.getActiveNotifications(context0);
        int v1 = 0;
        for(int v = 0; v < arr_statusBarNotification.length; ++v) {
            if(!NotificationHelper.INSTANCE.isGroupSummary(arr_statusBarNotification[v])) {
                ++v1;
            }
        }
        this.updateCount(v1);
    }
}

