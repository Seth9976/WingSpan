package androidx.media.app;

import android.app.Notification.DecoratedMediaCustomViewStyle;
import android.app.Notification.MediaStyle;
import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat.Action;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.Style;
import androidx.media.R.color;
import androidx.media.R.id;
import androidx.media.R.integer;
import androidx.media.R.layout;

public class NotificationCompat {
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        @Override  // androidx.media.app.NotificationCompat$MediaStyle
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor0) {
            if(Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor0.getBuilder().setStyle(this.fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
                return;
            }
            super.apply(notificationBuilderWithBuilderAccessor0);
        }

        @Override  // androidx.media.app.NotificationCompat$MediaStyle
        int getBigContentViewLayoutResource(int v) {
            return v > 3 ? layout.notification_template_big_media_custom : layout.notification_template_big_media_narrow_custom;
        }

        @Override  // androidx.media.app.NotificationCompat$MediaStyle
        int getContentViewLayoutResource() {
            return this.mBuilder.getContentView() == null ? super.getContentViewLayoutResource() : layout.notification_template_media_custom;
        }

        @Override  // androidx.media.app.NotificationCompat$MediaStyle
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor0) {
            if(Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViews0 = this.mBuilder.getBigContentView() == null ? this.mBuilder.getContentView() : this.mBuilder.getBigContentView();
            if(remoteViews0 == null) {
                return null;
            }
            RemoteViews remoteViews1 = this.generateBigContentView();
            this.buildIntoRemoteViews(remoteViews1, remoteViews0);
            this.setBackgroundColor(remoteViews1);
            return remoteViews1;
        }

        @Override  // androidx.media.app.NotificationCompat$MediaStyle
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor0) {
            if(Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z = this.mBuilder.getContentView() != null;
            if(z || this.mBuilder.getBigContentView() != null) {
                RemoteViews remoteViews0 = this.generateContentView();
                if(z) {
                    this.buildIntoRemoteViews(remoteViews0, this.mBuilder.getContentView());
                }
                this.setBackgroundColor(remoteViews0);
                return remoteViews0;
            }
            return null;
        }

        @Override  // androidx.core.app.NotificationCompat$Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor0) {
            if(Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews remoteViews0 = this.mBuilder.getHeadsUpContentView() == null ? this.mBuilder.getContentView() : this.mBuilder.getHeadsUpContentView();
            if(remoteViews0 == null) {
                return null;
            }
            RemoteViews remoteViews1 = this.generateBigContentView();
            this.buildIntoRemoteViews(remoteViews1, remoteViews0);
            this.setBackgroundColor(remoteViews1);
            return remoteViews1;
        }

        private void setBackgroundColor(RemoteViews remoteViews0) {
            int v = this.mBuilder.getColor() == 0 ? this.mBuilder.mContext.getResources().getColor(color.notification_material_background_media_default_color) : this.mBuilder.getColor();
            remoteViews0.setInt(id.status_bar_latest_event_content, "setBackgroundColor", v);
        }
    }

    public static class MediaStyle extends Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        Token mToken;

        public MediaStyle() {
            this.mActionsToShowInCompact = null;
        }

        public MediaStyle(Builder notificationCompat$Builder0) {
            this.mActionsToShowInCompact = null;
            this.setBuilder(notificationCompat$Builder0);
        }

        @Override  // androidx.core.app.NotificationCompat$Style
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor0) {
            notificationBuilderWithBuilderAccessor0.getBuilder().setStyle(this.fillInMediaStyle(new Notification.MediaStyle()));
        }

        Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle notification$MediaStyle0) {
            int[] arr_v = this.mActionsToShowInCompact;
            if(arr_v != null) {
                notification$MediaStyle0.setShowActionsInCompactView(arr_v);
            }
            Token mediaSessionCompat$Token0 = this.mToken;
            if(mediaSessionCompat$Token0 != null) {
                notification$MediaStyle0.setMediaSession(((MediaSession.Token)mediaSessionCompat$Token0.getToken()));
            }
            return notification$MediaStyle0;
        }

        RemoteViews generateBigContentView() {
            int v = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews remoteViews0 = this.applyStandardTemplate(false, this.getBigContentViewLayoutResource(v), false);
            remoteViews0.removeAllViews(id.media_actions);
            if(v > 0) {
                for(int v1 = 0; v1 < v; ++v1) {
                    RemoteViews remoteViews1 = this.generateMediaActionButton(((Action)this.mBuilder.mActions.get(v1)));
                    remoteViews0.addView(id.media_actions, remoteViews1);
                }
            }
            if(this.mShowCancelButton) {
                remoteViews0.setViewVisibility(id.cancel_action, 0);
                int v2 = this.mBuilder.mContext.getResources().getInteger(integer.cancel_button_image_alpha);
                remoteViews0.setInt(id.cancel_action, "setAlpha", v2);
                remoteViews0.setOnClickPendingIntent(id.cancel_action, this.mCancelButtonIntent);
                return remoteViews0;
            }
            remoteViews0.setViewVisibility(id.cancel_action, 8);
            return remoteViews0;
        }

        RemoteViews generateContentView() {
            RemoteViews remoteViews0 = this.applyStandardTemplate(false, this.getContentViewLayoutResource(), true);
            int v = this.mBuilder.mActions.size();
            int v1 = this.mActionsToShowInCompact == null ? 0 : Math.min(this.mActionsToShowInCompact.length, 3);
            remoteViews0.removeAllViews(id.media_actions);
            if(v1 > 0) {
                for(int v2 = 0; v2 < v1; ++v2) {
                    if(v2 >= v) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", v2, ((int)(v - 1))));
                    }
                    RemoteViews remoteViews1 = this.generateMediaActionButton(((Action)this.mBuilder.mActions.get(this.mActionsToShowInCompact[v2])));
                    remoteViews0.addView(id.media_actions, remoteViews1);
                }
            }
            if(this.mShowCancelButton) {
                remoteViews0.setViewVisibility(id.end_padder, 8);
                remoteViews0.setViewVisibility(id.cancel_action, 0);
                remoteViews0.setOnClickPendingIntent(id.cancel_action, this.mCancelButtonIntent);
                int v3 = this.mBuilder.mContext.getResources().getInteger(integer.cancel_button_image_alpha);
                remoteViews0.setInt(id.cancel_action, "setAlpha", v3);
                return remoteViews0;
            }
            remoteViews0.setViewVisibility(id.end_padder, 0);
            remoteViews0.setViewVisibility(id.cancel_action, 8);
            return remoteViews0;
        }

        private RemoteViews generateMediaActionButton(Action notificationCompat$Action0) {
            RemoteViews remoteViews0 = new RemoteViews("com.MonsterCouch.Wingspan", layout.notification_media_action);
            remoteViews0.setImageViewResource(id.action0, notificationCompat$Action0.getIcon());
            if(notificationCompat$Action0.getActionIntent() != null) {
                remoteViews0.setOnClickPendingIntent(id.action0, notificationCompat$Action0.getActionIntent());
            }
            remoteViews0.setContentDescription(id.action0, notificationCompat$Action0.getTitle());
            return remoteViews0;
        }

        int getBigContentViewLayoutResource(int v) {
            return v > 3 ? layout.notification_template_big_media : layout.notification_template_big_media_narrow;
        }

        int getContentViewLayoutResource() {
            return layout.notification_template_media;
        }

        public static Token getMediaSession(Notification notification0) {
            Bundle bundle0 = androidx.core.app.NotificationCompat.getExtras(notification0);
            if(bundle0 != null) {
                Parcelable parcelable0 = bundle0.getParcelable("android.mediaSession");
                return parcelable0 == null ? null : Token.fromToken(parcelable0);
            }
            return null;
        }

        @Override  // androidx.core.app.NotificationCompat$Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor0) {
            return null;
        }

        @Override  // androidx.core.app.NotificationCompat$Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor0) {
            return null;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent0) {
            this.mCancelButtonIntent = pendingIntent0;
            return this;
        }

        public MediaStyle setMediaSession(Token mediaSessionCompat$Token0) {
            this.mToken = mediaSessionCompat$Token0;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int[] arr_v) {
            this.mActionsToShowInCompact = arr_v;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            return this;
        }
    }

}

