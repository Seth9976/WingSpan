package com.unity.androidnotifications;

import android.app.Notification.Builder;
import android.util.Log;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedTransferQueue;

public class UnityNotificationBackgroundThread extends Thread {
    static class CancelAllNotificationsTask extends Task {
        private CancelAllNotificationsTask() {
            super(null);
        }

        CancelAllNotificationsTask(com.unity.androidnotifications.UnityNotificationBackgroundThread.1 unityNotificationBackgroundThread$10) {
        }

        @Override  // com.unity.androidnotifications.UnityNotificationBackgroundThread$Task
        public boolean run(UnityNotificationManager unityNotificationManager0, ConcurrentHashMap concurrentHashMap0) {
            if(concurrentHashMap0.isEmpty()) {
                return false;
            }
            Enumeration enumeration0 = concurrentHashMap0.keys();
            while(enumeration0.hasMoreElements()) {
                Integer integer0 = (Integer)enumeration0.nextElement();
                unityNotificationManager0.cancelPendingNotificationIntent(((int)integer0));
                unityNotificationManager0.deleteExpiredNotificationIntent(String.valueOf(integer0));
            }
            concurrentHashMap0.clear();
            return true;
        }
    }

    static class CancelNotificationTask extends Task {
        private int notificationId;

        public CancelNotificationTask(int v) {
            super(null);
            this.notificationId = v;
        }

        @Override  // com.unity.androidnotifications.UnityNotificationBackgroundThread$Task
        public boolean run(UnityNotificationManager unityNotificationManager0, ConcurrentHashMap concurrentHashMap0) {
            unityNotificationManager0.cancelPendingNotificationIntent(this.notificationId);
            if(concurrentHashMap0.remove(this.notificationId) != null) {
                unityNotificationManager0.deleteExpiredNotificationIntent(String.valueOf(this.notificationId));
                return true;
            }
            return false;
        }
    }

    static class HousekeepingTask extends Task {
        UnityNotificationBackgroundThread thread;

        public HousekeepingTask(UnityNotificationBackgroundThread unityNotificationBackgroundThread0) {
            super(null);
            this.thread = unityNotificationBackgroundThread0;
        }

        @Override  // com.unity.androidnotifications.UnityNotificationBackgroundThread$Task
        public boolean run(UnityNotificationManager unityNotificationManager0, ConcurrentHashMap concurrentHashMap0) {
            HashSet hashSet0 = new HashSet();
            Enumeration enumeration0 = concurrentHashMap0.keys();
            while(enumeration0.hasMoreElements()) {
                hashSet0.add(String.valueOf(enumeration0.nextElement()));
            }
            this.thread.performHousekeeping(hashSet0);
            return false;
        }
    }

    static class ScheduleNotificationTask extends Task {
        private boolean isCustomized;
        private boolean isNew;
        private Notification.Builder notificationBuilder;
        private int notificationId;

        public ScheduleNotificationTask(int v, Notification.Builder notification$Builder0, boolean z, boolean z1) {
            super(null);
            this.notificationId = v;
            this.notificationBuilder = notification$Builder0;
            this.isCustomized = z;
            this.isNew = z1;
        }

        @Override  // com.unity.androidnotifications.UnityNotificationBackgroundThread$Task
        public boolean run(UnityNotificationManager unityNotificationManager0, ConcurrentHashMap concurrentHashMap0) {
            String s;
            try {
                s = String.valueOf(this.notificationId);
                UnityNotificationManager.mUnityNotificationManager.performNotificationScheduling(this.notificationId, this.notificationBuilder, this.isCustomized);
                return this.isNew;
            }
            catch(Throwable throwable0) {
                concurrentHashMap0.remove(this.notificationId);
                unityNotificationManager0.cancelPendingNotificationIntent(this.notificationId);
                unityNotificationManager0.deleteExpiredNotificationIntent(s);
                throw throwable0;
            }
        }
    }

    static abstract class Task {
        private Task() {
        }

        Task(com.unity.androidnotifications.UnityNotificationBackgroundThread.1 unityNotificationBackgroundThread$10) {
        }

        public abstract boolean run(UnityNotificationManager arg1, ConcurrentHashMap arg2);
    }

    private static final int TASKS_FOR_HOUSEKEEPING = 50;
    private UnityNotificationManager mManager;
    private ConcurrentHashMap mScheduledNotifications;
    private LinkedTransferQueue mTasks;
    private int mTasksSinceHousekeeping;

    public UnityNotificationBackgroundThread(UnityNotificationManager unityNotificationManager0, ConcurrentHashMap concurrentHashMap0) {
        this.mTasks = new LinkedTransferQueue();
        this.mTasksSinceHousekeeping = 50;
        this.mManager = unityNotificationManager0;
        this.mScheduledNotifications = concurrentHashMap0;
        if(concurrentHashMap0.size() == 0) {
            this.loadNotifications();
        }
    }

    public void enqueueCancelAllNotifications() {
        this.mTasks.add(new CancelAllNotificationsTask(null));
    }

    public void enqueueCancelNotification(int v) {
        this.mTasks.add(new CancelNotificationTask(v));
    }

    private void enqueueHousekeeping() {
        this.mTasks.add(new HousekeepingTask(this));
    }

    public void enqueueNotification(int v, Notification.Builder notification$Builder0, boolean z, boolean z1) {
        this.mTasks.add(new ScheduleNotificationTask(v, notification$Builder0, z, z1));
    }

    private boolean executeTask(UnityNotificationManager unityNotificationManager0, Task unityNotificationBackgroundThread$Task0, ConcurrentHashMap concurrentHashMap0) {
        try {
            return unityNotificationBackgroundThread$Task0.run(unityNotificationManager0, concurrentHashMap0);
        }
        catch(Exception exception0) {
            Log.e("UnityNotifications", "Exception executing notification task", exception0);
            return false;
        }
    }

    private void loadNotifications() {
        for(Object object0: this.mManager.loadSavedNotifications()) {
            Integer integer0 = ((Notification.Builder)object0).getExtras().getInt("id", -1);
            this.mScheduledNotifications.put(integer0, ((Notification.Builder)object0));
        }
    }

    private void performHousekeeping(Set set0) {
        boolean z = this.mTasksSinceHousekeeping >= 50;
        this.mTasksSinceHousekeeping = 0;
        if(z) {
            this.mManager.performNotificationHousekeeping(set0);
        }
        this.mManager.saveScheduledNotificationIDs(set0);
    }

    @Override
    public void run() {
        while(true) {
            boolean z = false;
            try {
                do {
                label_1:
                    Task unityNotificationBackgroundThread$Task0 = (Task)this.mTasks.take();
                    z |= this.executeTask(this.mManager, unityNotificationBackgroundThread$Task0, this.mScheduledNotifications);
                    if(!(unityNotificationBackgroundThread$Task0 instanceof HousekeepingTask)) {
                        ++this.mTasksSinceHousekeeping;
                    }
                }
                while(this.mTasks.size() != 0 || !z);
                try {
                    this.enqueueHousekeeping();
                }
                catch(InterruptedException unused_ex) {
                    z = false;
                    break;
                }
            }
            catch(InterruptedException unused_ex) {
                break;
            }
        }
        if(!this.mTasks.isEmpty()) {
            goto label_1;
        }
    }

    class com.unity.androidnotifications.UnityNotificationBackgroundThread.1 {
    }

}

