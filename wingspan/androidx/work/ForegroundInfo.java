package androidx.work;

import android.app.Notification;

public final class ForegroundInfo {
    private final int mForegroundServiceType;
    private final Notification mNotification;
    private final int mNotificationId;

    public ForegroundInfo(int notificationId, Notification notification) {
        this(notificationId, notification, 0);
    }

    public ForegroundInfo(int notificationId, Notification notification, int foregroundServiceType) {
        this.mNotificationId = notificationId;
        this.mNotification = notification;
        this.mForegroundServiceType = foregroundServiceType;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || this.getClass() != o.getClass() || this.mNotificationId != ((ForegroundInfo)o).mNotificationId) {
            return false;
        }
        return this.mForegroundServiceType == ((ForegroundInfo)o).mForegroundServiceType ? this.mNotification.equals(((ForegroundInfo)o).mNotification) : false;
    }

    public int getForegroundServiceType() {
        return this.mForegroundServiceType;
    }

    public Notification getNotification() {
        return this.mNotification;
    }

    public int getNotificationId() {
        return this.mNotificationId;
    }

    @Override
    public int hashCode() {
        return (this.mNotificationId * 0x1F + this.mForegroundServiceType) * 0x1F + this.mNotification.hashCode();
    }

    @Override
    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.mNotificationId + ", mForegroundServiceType=" + this.mForegroundServiceType + ", mNotification=" + this.mNotification + '}';
    }
}

