package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build.VERSION;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationChannelGroupCompat {
    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(String s) {
            this.mGroup = new NotificationChannelGroupCompat(s);
        }

        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        public Builder setDescription(String s) {
            this.mGroup.mDescription = s;
            return this;
        }

        public Builder setName(CharSequence charSequence0) {
            this.mGroup.mName = charSequence0;
            return this;
        }
    }

    private boolean mBlocked;
    private List mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup0) {
        this(notificationChannelGroup0, Collections.emptyList());
    }

    NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup0, List list0) {
        this(notificationChannelGroup0.getId());
        this.mName = notificationChannelGroup0.getName();
        if(Build.VERSION.SDK_INT >= 28) {
            this.mDescription = notificationChannelGroup0.getDescription();
        }
        if(Build.VERSION.SDK_INT >= 28) {
            this.mBlocked = notificationChannelGroup0.isBlocked();
            this.mChannels = this.getChannelsCompat(notificationChannelGroup0.getChannels());
            return;
        }
        this.mChannels = this.getChannelsCompat(list0);
    }

    NotificationChannelGroupCompat(String s) {
        this.mChannels = Collections.emptyList();
        this.mId = (String)Preconditions.checkNotNull(s);
    }

    public List getChannels() {
        return this.mChannels;
    }

    private List getChannelsCompat(List list0) {
        List list1 = new ArrayList();
        for(Object object0: list0) {
            NotificationChannel notificationChannel0 = (NotificationChannel)object0;
            String s = notificationChannel0.getGroup();
            if(this.mId.equals(s)) {
                list1.add(new NotificationChannelCompat(notificationChannel0));
            }
        }
        return list1;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    NotificationChannelGroup getNotificationChannelGroup() {
        if(Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroup0 = new NotificationChannelGroup(this.mId, this.mName);
        if(Build.VERSION.SDK_INT >= 28) {
            notificationChannelGroup0.setDescription(this.mDescription);
        }
        return notificationChannelGroup0;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }
}

