package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {
    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(String s, int v) {
            this.mChannel = new NotificationChannelCompat(s, v);
        }

        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        public Builder setConversationId(String s, String s1) {
            if(Build.VERSION.SDK_INT >= 30) {
                this.mChannel.mParentId = s;
                this.mChannel.mConversationId = s1;
            }
            return this;
        }

        public Builder setDescription(String s) {
            this.mChannel.mDescription = s;
            return this;
        }

        public Builder setGroup(String s) {
            this.mChannel.mGroupId = s;
            return this;
        }

        public Builder setImportance(int v) {
            this.mChannel.mImportance = v;
            return this;
        }

        public Builder setLightColor(int v) {
            this.mChannel.mLightColor = v;
            return this;
        }

        public Builder setLightsEnabled(boolean z) {
            this.mChannel.mLights = z;
            return this;
        }

        public Builder setName(CharSequence charSequence0) {
            this.mChannel.mName = charSequence0;
            return this;
        }

        public Builder setShowBadge(boolean z) {
            this.mChannel.mShowBadge = z;
            return this;
        }

        public Builder setSound(Uri uri0, AudioAttributes audioAttributes0) {
            this.mChannel.mSound = uri0;
            this.mChannel.mAudioAttributes = audioAttributes0;
            return this;
        }

        public Builder setVibrationEnabled(boolean z) {
            this.mChannel.mVibrationEnabled = z;
            return this;
        }

        public Builder setVibrationPattern(long[] arr_v) {
            this.mChannel.mVibrationEnabled = arr_v != null && arr_v.length > 0;
            this.mChannel.mVibrationPattern = arr_v;
            return this;
        }
    }

    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    NotificationChannelCompat(NotificationChannel notificationChannel0) {
        this(notificationChannel0.getId(), notificationChannel0.getImportance());
        this.mName = notificationChannel0.getName();
        this.mDescription = notificationChannel0.getDescription();
        this.mGroupId = notificationChannel0.getGroup();
        this.mShowBadge = notificationChannel0.canShowBadge();
        this.mSound = notificationChannel0.getSound();
        this.mAudioAttributes = notificationChannel0.getAudioAttributes();
        this.mLights = notificationChannel0.shouldShowLights();
        this.mLightColor = notificationChannel0.getLightColor();
        this.mVibrationEnabled = notificationChannel0.shouldVibrate();
        this.mVibrationPattern = notificationChannel0.getVibrationPattern();
        if(Build.VERSION.SDK_INT >= 30) {
            this.mParentId = notificationChannel0.getParentChannelId();
            this.mConversationId = notificationChannel0.getConversationId();
        }
        this.mBypassDnd = notificationChannel0.canBypassDnd();
        this.mLockscreenVisibility = notificationChannel0.getLockscreenVisibility();
        if(Build.VERSION.SDK_INT >= 29) {
            this.mCanBubble = notificationChannel0.canBubble();
        }
        if(Build.VERSION.SDK_INT >= 30) {
            this.mImportantConversation = notificationChannel0.isImportantConversation();
        }
    }

    NotificationChannelCompat(String s, int v) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String)Preconditions.checkNotNull(s);
        this.mImportance = v;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    public String getConversationId() {
        return this.mConversationId;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getGroup() {
        return this.mGroupId;
    }

    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannel getNotificationChannel() {
        if(Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel0 = new NotificationChannel(this.mId, this.mName, this.mImportance);
        notificationChannel0.setDescription(this.mDescription);
        notificationChannel0.setGroup(this.mGroupId);
        notificationChannel0.setShowBadge(this.mShowBadge);
        notificationChannel0.setSound(this.mSound, this.mAudioAttributes);
        notificationChannel0.enableLights(this.mLights);
        notificationChannel0.setLightColor(this.mLightColor);
        notificationChannel0.setVibrationPattern(this.mVibrationPattern);
        notificationChannel0.enableVibration(this.mVibrationEnabled);
        if(Build.VERSION.SDK_INT >= 30) {
            String s = this.mParentId;
            if(s != null) {
                String s1 = this.mConversationId;
                if(s1 != null) {
                    notificationChannel0.setConversationId(s, s1);
                }
            }
        }
        return notificationChannel0;
    }

    public String getParentChannelId() {
        return this.mParentId;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }
}

