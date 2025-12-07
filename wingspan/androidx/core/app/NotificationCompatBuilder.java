package androidx.core.app;

import android.app.Notification.Action.Builder;
import android.app.Notification.Action;
import android.app.Notification.BubbleMetadata;
import android.app.Notification.Builder;
import android.app.Notification;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private final List mActionExtrasList;
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    NotificationCompatBuilder(Builder notificationCompat$Builder0) {
        this.mActionExtrasList = new ArrayList();
        this.mExtras = new Bundle();
        this.mBuilderCompat = notificationCompat$Builder0;
        this.mContext = notificationCompat$Builder0.mContext;
        this.mBuilder = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(notificationCompat$Builder0.mContext, notificationCompat$Builder0.mChannelId) : new Notification.Builder(notificationCompat$Builder0.mContext);
        Notification notification0 = notificationCompat$Builder0.mNotification;
        this.mBuilder.setWhen(notification0.when).setSmallIcon(notification0.icon, notification0.iconLevel).setContent(notification0.contentView).setTicker(notification0.tickerText, notificationCompat$Builder0.mTickerView).setVibrate(notification0.vibrate).setLights(notification0.ledARGB, notification0.ledOnMS, notification0.ledOffMS).setOngoing((notification0.flags & 2) != 0).setOnlyAlertOnce((notification0.flags & 8) != 0).setAutoCancel((notification0.flags & 16) != 0).setDefaults(notification0.defaults).setContentTitle(notificationCompat$Builder0.mContentTitle).setContentText(notificationCompat$Builder0.mContentText).setContentInfo(notificationCompat$Builder0.mContentInfo).setContentIntent(notificationCompat$Builder0.mContentIntent).setDeleteIntent(notification0.deleteIntent).setFullScreenIntent(notificationCompat$Builder0.mFullScreenIntent, (notification0.flags & 0x80) != 0).setLargeIcon(notificationCompat$Builder0.mLargeIcon).setNumber(notificationCompat$Builder0.mNumber).setProgress(notificationCompat$Builder0.mProgressMax, notificationCompat$Builder0.mProgress, notificationCompat$Builder0.mProgressIndeterminate);
        this.mBuilder.setSubText(notificationCompat$Builder0.mSubText).setUsesChronometer(notificationCompat$Builder0.mUseChronometer).setPriority(notificationCompat$Builder0.mPriority);
        for(Object object0: notificationCompat$Builder0.mActions) {
            this.addAction(((Action)object0));
        }
        if(notificationCompat$Builder0.mExtras != null) {
            this.mExtras.putAll(notificationCompat$Builder0.mExtras);
        }
        this.mContentView = notificationCompat$Builder0.mContentView;
        this.mBigContentView = notificationCompat$Builder0.mBigContentView;
        this.mBuilder.setShowWhen(notificationCompat$Builder0.mShowWhen);
        this.mBuilder.setLocalOnly(notificationCompat$Builder0.mLocalOnly).setGroup(notificationCompat$Builder0.mGroupKey).setGroupSummary(notificationCompat$Builder0.mGroupSummary).setSortKey(notificationCompat$Builder0.mSortKey);
        this.mGroupAlertBehavior = notificationCompat$Builder0.mGroupAlertBehavior;
        this.mBuilder.setCategory(notificationCompat$Builder0.mCategory).setColor(notificationCompat$Builder0.mColor).setVisibility(notificationCompat$Builder0.mVisibility).setPublicVersion(notificationCompat$Builder0.mPublicVersion).setSound(notification0.sound, notification0.audioAttributes);
        List list0 = Build.VERSION.SDK_INT < 28 ? NotificationCompatBuilder.combineLists(NotificationCompatBuilder.getPeople(notificationCompat$Builder0.mPersonList), notificationCompat$Builder0.mPeople) : notificationCompat$Builder0.mPeople;
        if(list0 != null && !list0.isEmpty()) {
            for(Object object1: list0) {
                this.mBuilder.addPerson(((String)object1));
            }
        }
        this.mHeadsUpContentView = notificationCompat$Builder0.mHeadsUpContentView;
        if(notificationCompat$Builder0.mInvisibleActions.size() > 0) {
            Bundle bundle0 = notificationCompat$Builder0.getExtras().getBundle("android.car.EXTENSIONS");
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            Bundle bundle1 = new Bundle(bundle0);
            Bundle bundle2 = new Bundle();
            for(int v = 0; v < notificationCompat$Builder0.mInvisibleActions.size(); ++v) {
                bundle2.putBundle(Integer.toString(v), NotificationCompatJellybean.getBundleForAction(((Action)notificationCompat$Builder0.mInvisibleActions.get(v))));
            }
            bundle0.putBundle("invisible_actions", bundle2);
            bundle1.putBundle("invisible_actions", bundle2);
            notificationCompat$Builder0.getExtras().putBundle("android.car.EXTENSIONS", bundle0);
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle1);
        }
        if(notificationCompat$Builder0.mSmallIcon != null) {
            this.mBuilder.setSmallIcon(notificationCompat$Builder0.mSmallIcon);
        }
        if(Build.VERSION.SDK_INT >= 24) {
            this.mBuilder.setExtras(notificationCompat$Builder0.mExtras).setRemoteInputHistory(notificationCompat$Builder0.mRemoteInputHistory);
            if(notificationCompat$Builder0.mContentView != null) {
                this.mBuilder.setCustomContentView(notificationCompat$Builder0.mContentView);
            }
            if(notificationCompat$Builder0.mBigContentView != null) {
                this.mBuilder.setCustomBigContentView(notificationCompat$Builder0.mBigContentView);
            }
            if(notificationCompat$Builder0.mHeadsUpContentView != null) {
                this.mBuilder.setCustomHeadsUpContentView(notificationCompat$Builder0.mHeadsUpContentView);
            }
        }
        if(Build.VERSION.SDK_INT >= 26) {
            this.mBuilder.setBadgeIconType(notificationCompat$Builder0.mBadgeIcon).setSettingsText(notificationCompat$Builder0.mSettingsText).setShortcutId(notificationCompat$Builder0.mShortcutId).setTimeoutAfter(notificationCompat$Builder0.mTimeout).setGroupAlertBehavior(notificationCompat$Builder0.mGroupAlertBehavior);
            if(notificationCompat$Builder0.mColorizedSet) {
                this.mBuilder.setColorized(notificationCompat$Builder0.mColorized);
            }
            if(!TextUtils.isEmpty(notificationCompat$Builder0.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if(Build.VERSION.SDK_INT >= 28) {
            for(Object object2: notificationCompat$Builder0.mPersonList) {
                Person person0 = ((androidx.core.app.Person)object2).toAndroidPerson();
                this.mBuilder.addPerson(person0);
            }
        }
        if(Build.VERSION.SDK_INT >= 29) {
            this.mBuilder.setAllowSystemGeneratedContextualActions(notificationCompat$Builder0.mAllowSystemGeneratedContextualActions);
            Notification.BubbleMetadata notification$BubbleMetadata0 = BubbleMetadata.toPlatform(notificationCompat$Builder0.mBubbleMetadata);
            this.mBuilder.setBubbleMetadata(notification$BubbleMetadata0);
            if(notificationCompat$Builder0.mLocusId != null) {
                this.mBuilder.setLocusId(notificationCompat$Builder0.mLocusId.toLocusId());
            }
        }
        if(Build.VERSION.SDK_INT >= 0x1F && notificationCompat$Builder0.mFgsDeferBehavior != 0) {
            this.mBuilder.setForegroundServiceBehavior(notificationCompat$Builder0.mFgsDeferBehavior);
        }
        if(notificationCompat$Builder0.mSilent) {
            this.mGroupAlertBehavior = this.mBuilderCompat.mGroupSummary ? 2 : 1;
            this.mBuilder.setVibrate(null);
            this.mBuilder.setSound(null);
            notification0.defaults &= -3;
            this.mBuilder.setDefaults(notification0.defaults);
            if(Build.VERSION.SDK_INT >= 26) {
                if(TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                    this.mBuilder.setGroup("silent");
                }
                this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
            }
        }
    }

    private void addAction(Action notificationCompat$Action0) {
        IconCompat iconCompat0 = notificationCompat$Action0.getIconCompat();
        Notification.Action.Builder notification$Action$Builder0 = new Notification.Action.Builder((iconCompat0 == null ? null : iconCompat0.toIcon()), notificationCompat$Action0.getTitle(), notificationCompat$Action0.getActionIntent());
        if(notificationCompat$Action0.getRemoteInputs() != null) {
            RemoteInput[] arr_remoteInput = androidx.core.app.RemoteInput.fromCompat(notificationCompat$Action0.getRemoteInputs());
            for(int v = 0; v < arr_remoteInput.length; ++v) {
                notification$Action$Builder0.addRemoteInput(arr_remoteInput[v]);
            }
        }
        Bundle bundle0 = notificationCompat$Action0.getExtras() == null ? new Bundle() : new Bundle(notificationCompat$Action0.getExtras());
        bundle0.putBoolean("android.support.allowGeneratedReplies", notificationCompat$Action0.getAllowGeneratedReplies());
        if(Build.VERSION.SDK_INT >= 24) {
            notification$Action$Builder0.setAllowGeneratedReplies(notificationCompat$Action0.getAllowGeneratedReplies());
        }
        bundle0.putInt("android.support.action.semanticAction", notificationCompat$Action0.getSemanticAction());
        if(Build.VERSION.SDK_INT >= 28) {
            notification$Action$Builder0.setSemanticAction(notificationCompat$Action0.getSemanticAction());
        }
        if(Build.VERSION.SDK_INT >= 29) {
            notification$Action$Builder0.setContextual(notificationCompat$Action0.isContextual());
        }
        if(Build.VERSION.SDK_INT >= 0x1F) {
            notification$Action$Builder0.setAuthenticationRequired(notificationCompat$Action0.isAuthenticationRequired());
        }
        bundle0.putBoolean("android.support.action.showsUserInterface", notificationCompat$Action0.getShowsUserInterface());
        notification$Action$Builder0.addExtras(bundle0);
        Notification.Action notification$Action0 = notification$Action$Builder0.build();
        this.mBuilder.addAction(notification$Action0);
    }

    public Notification build() {
        Style notificationCompat$Style0 = this.mBuilderCompat.mStyle;
        if(notificationCompat$Style0 != null) {
            notificationCompat$Style0.apply(this);
        }
        RemoteViews remoteViews0 = notificationCompat$Style0 == null ? null : notificationCompat$Style0.makeContentView(this);
        Notification notification0 = this.buildInternal();
        if(remoteViews0 != null) {
            notification0.contentView = remoteViews0;
        }
        else if(this.mBuilderCompat.mContentView != null) {
            notification0.contentView = this.mBuilderCompat.mContentView;
        }
        if(notificationCompat$Style0 != null) {
            RemoteViews remoteViews1 = notificationCompat$Style0.makeBigContentView(this);
            if(remoteViews1 != null) {
                notification0.bigContentView = remoteViews1;
            }
        }
        if(notificationCompat$Style0 != null) {
            RemoteViews remoteViews2 = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this);
            if(remoteViews2 != null) {
                notification0.headsUpContentView = remoteViews2;
            }
        }
        if(notificationCompat$Style0 != null) {
            Bundle bundle0 = NotificationCompat.getExtras(notification0);
            if(bundle0 != null) {
                notificationCompat$Style0.addCompatExtras(bundle0);
            }
        }
        return notification0;
    }

    protected Notification buildInternal() {
        if(Build.VERSION.SDK_INT >= 26) {
            return this.mBuilder.build();
        }
        if(Build.VERSION.SDK_INT >= 24) {
            Notification notification0 = this.mBuilder.build();
            if(this.mGroupAlertBehavior != 0) {
                if(notification0.getGroup() != null && (notification0.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2) {
                    this.removeSoundAndVibration(notification0);
                }
                if(notification0.getGroup() != null && (notification0.flags & 0x200) == 0 && this.mGroupAlertBehavior == 1) {
                    this.removeSoundAndVibration(notification0);
                }
            }
            return notification0;
        }
        this.mBuilder.setExtras(this.mExtras);
        Notification notification1 = this.mBuilder.build();
        RemoteViews remoteViews0 = this.mContentView;
        if(remoteViews0 != null) {
            notification1.contentView = remoteViews0;
        }
        RemoteViews remoteViews1 = this.mBigContentView;
        if(remoteViews1 != null) {
            notification1.bigContentView = remoteViews1;
        }
        RemoteViews remoteViews2 = this.mHeadsUpContentView;
        if(remoteViews2 != null) {
            notification1.headsUpContentView = remoteViews2;
        }
        if(this.mGroupAlertBehavior != 0) {
            if(notification1.getGroup() != null && (notification1.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2) {
                this.removeSoundAndVibration(notification1);
            }
            if(notification1.getGroup() != null && (notification1.flags & 0x200) == 0 && this.mGroupAlertBehavior == 1) {
                this.removeSoundAndVibration(notification1);
            }
        }
        return notification1;
    }

    private static List combineLists(List list0, List list1) {
        if(list0 == null) {
            return list1;
        }
        if(list1 == null) {
            return list0;
        }
        ArraySet arraySet0 = new ArraySet(list0.size() + list1.size());
        arraySet0.addAll(list0);
        arraySet0.addAll(list1);
        return new ArrayList(arraySet0);
    }

    @Override  // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }

    private static List getPeople(List list0) {
        if(list0 == null) {
            return null;
        }
        List list1 = new ArrayList(list0.size());
        for(Object object0: list0) {
            ((ArrayList)list1).add(((androidx.core.app.Person)object0).resolveToLegacyUri());
        }
        return list1;
    }

    private void removeSoundAndVibration(Notification notification0) {
        notification0.sound = null;
        notification0.vibrate = null;
        notification0.defaults &= -3;
    }
}

