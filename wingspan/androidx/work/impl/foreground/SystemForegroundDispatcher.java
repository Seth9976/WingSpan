package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class SystemForegroundDispatcher implements ExecutionListener, WorkConstraintsCallback {
    interface Callback {
        void cancelNotification(int arg1);

        void notify(int arg1, Notification arg2);

        void startForeground(int arg1, int arg2, Notification arg3);

        void stop();
    }

    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_GENERATION = "KEY_GENERATION";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG;
    private Callback mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    WorkGenerationalId mCurrentForegroundId;
    final Map mForegroundInfoById;
    final Object mLock;
    private final TaskExecutor mTaskExecutor;
    final Set mTrackedWorkSpecs;
    private WorkManagerImpl mWorkManagerImpl;
    final Map mWorkSpecById;

    static {
        SystemForegroundDispatcher.TAG = "WM-SystemFgDispatcher";
    }

    SystemForegroundDispatcher(Context context) {
        this.mContext = context;
        this.mLock = new Object();
        WorkManagerImpl workManagerImpl0 = WorkManagerImpl.getInstance(this.mContext);
        this.mWorkManagerImpl = workManagerImpl0;
        this.mTaskExecutor = workManagerImpl0.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTrackerImpl(this.mWorkManagerImpl.getTrackers(), this);
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    SystemForegroundDispatcher(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker tracker) {
        this.mContext = context;
        this.mLock = new Object();
        this.mWorkManagerImpl = workManagerImpl;
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = tracker;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    public static Intent createCancelWorkIntent(Context context, String workSpecId) {
        Intent intent0 = new Intent(context, SystemForegroundService.class);
        intent0.setAction("ACTION_CANCEL_WORK");
        intent0.setData(Uri.parse(("workspec://" + workSpecId)));
        intent0.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent0;
    }

    public static Intent createNotifyIntent(Context context, WorkGenerationalId id, ForegroundInfo info) {
        Intent intent0 = new Intent(context, SystemForegroundService.class);
        intent0.setAction("ACTION_NOTIFY");
        intent0.putExtra("KEY_NOTIFICATION_ID", info.getNotificationId());
        intent0.putExtra("KEY_FOREGROUND_SERVICE_TYPE", info.getForegroundServiceType());
        intent0.putExtra("KEY_NOTIFICATION", info.getNotification());
        intent0.putExtra("KEY_WORKSPEC_ID", id.getWorkSpecId());
        intent0.putExtra("KEY_GENERATION", id.getGeneration());
        return intent0;
    }

    public static Intent createStartForegroundIntent(Context context, WorkGenerationalId id, ForegroundInfo info) {
        Intent intent0 = new Intent(context, SystemForegroundService.class);
        intent0.setAction("ACTION_START_FOREGROUND");
        intent0.putExtra("KEY_WORKSPEC_ID", id.getWorkSpecId());
        intent0.putExtra("KEY_GENERATION", id.getGeneration());
        intent0.putExtra("KEY_NOTIFICATION_ID", info.getNotificationId());
        intent0.putExtra("KEY_FOREGROUND_SERVICE_TYPE", info.getForegroundServiceType());
        intent0.putExtra("KEY_NOTIFICATION", info.getNotification());
        return intent0;
    }

    public static Intent createStopForegroundIntent(Context context) {
        Intent intent0 = new Intent(context, SystemForegroundService.class);
        intent0.setAction("ACTION_STOP_FOREGROUND");
        return intent0;
    }

    private void handleCancelWork(Intent intent) {
        Logger.get().info("WM-SystemFgDispatcher", "Stopping foreground work for " + intent);
        String s = intent.getStringExtra("KEY_WORKSPEC_ID");
        if(s != null && !TextUtils.isEmpty(s)) {
            this.mWorkManagerImpl.cancelWorkById(UUID.fromString(s));
        }
    }

    private void handleNotify(Intent intent) {
        int v = 0;
        int v1 = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int v2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String s = intent.getStringExtra("KEY_WORKSPEC_ID");
        WorkGenerationalId workGenerationalId0 = new WorkGenerationalId(s, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification0 = (Notification)intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger.get().debug("WM-SystemFgDispatcher", "Notifying with (id:" + v1 + ", workSpecId: " + s + ", notificationType :" + v2 + ")");
        if(notification0 != null && this.mCallback != null) {
            ForegroundInfo foregroundInfo0 = new ForegroundInfo(v1, notification0, v2);
            this.mForegroundInfoById.put(workGenerationalId0, foregroundInfo0);
            if(this.mCurrentForegroundId == null) {
                this.mCurrentForegroundId = workGenerationalId0;
                this.mCallback.startForeground(v1, v2, notification0);
                return;
            }
            this.mCallback.notify(v1, notification0);
            if(v2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for(Object object0: this.mForegroundInfoById.entrySet()) {
                    v |= ((ForegroundInfo)((Map.Entry)object0).getValue()).getForegroundServiceType();
                }
                ForegroundInfo foregroundInfo1 = (ForegroundInfo)this.mForegroundInfoById.get(this.mCurrentForegroundId);
                if(foregroundInfo1 != null) {
                    this.mCallback.startForeground(foregroundInfo1.getNotificationId(), v, foregroundInfo1.getNotification());
                }
            }
        }
    }

    private void handleStartForeground(Intent intent) {
        Logger.get().info("WM-SystemFgDispatcher", "Started foreground service " + intent);
        androidx.work.impl.foreground.SystemForegroundDispatcher.1 systemForegroundDispatcher$10 = new Runnable() {
            @Override
            public void run() {
                WorkSpec workSpec0 = SystemForegroundDispatcher.this.mWorkManagerImpl.getProcessor().getRunningWorkSpec(intent.getStringExtra("KEY_WORKSPEC_ID"));
                if(workSpec0 != null && workSpec0.hasConstraints()) {
                    synchronized(SystemForegroundDispatcher.this.mLock) {
                        WorkGenerationalId workGenerationalId0 = WorkSpecKt.generationalId(workSpec0);
                        SystemForegroundDispatcher.this.mWorkSpecById.put(workGenerationalId0, workSpec0);
                        SystemForegroundDispatcher.this.mTrackedWorkSpecs.add(workSpec0);
                        SystemForegroundDispatcher.this.mConstraintsTracker.replace(SystemForegroundDispatcher.this.mTrackedWorkSpecs);
                    }
                }
            }
        };
        this.mTaskExecutor.executeOnTaskThread(systemForegroundDispatcher$10);
    }

    void handleStop(Intent intent) {
        Logger.get().info("WM-SystemFgDispatcher", "Stopping foreground service");
        Callback systemForegroundDispatcher$Callback0 = this.mCallback;
        if(systemForegroundDispatcher$Callback0 != null) {
            systemForegroundDispatcher$Callback0.stop();
        }
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(List workSpecs) {
    }

    @Override  // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(List workSpecs) {
        if(!workSpecs.isEmpty()) {
            for(Object object0: workSpecs) {
                Logger.get().debug("WM-SystemFgDispatcher", "Constraints unmet for WorkSpec " + ((WorkSpec)object0).id);
                this.mWorkManagerImpl.stopForegroundWork(WorkSpecKt.generationalId(((WorkSpec)object0)));
            }
        }
    }

    void onDestroy() {
        this.mCallback = null;
        synchronized(this.mLock) {
            this.mConstraintsTracker.reset();
        }
        this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
    }

    @Override  // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        synchronized(this.mLock) {
            WorkSpec workSpec0 = (WorkSpec)this.mWorkSpecById.remove(id);
            if((workSpec0 == null ? false : this.mTrackedWorkSpecs.remove(workSpec0))) {
                this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);
            }
        }
        ForegroundInfo foregroundInfo0 = (ForegroundInfo)this.mForegroundInfoById.remove(id);
        if(id.equals(this.mCurrentForegroundId) && this.mForegroundInfoById.size() > 0) {
            Iterator iterator0 = this.mForegroundInfoById.entrySet().iterator();
            Object object1 = iterator0.next();
            Map.Entry map$Entry0;
            for(map$Entry0 = (Map.Entry)object1; iterator0.hasNext(); map$Entry0 = (Map.Entry)object2) {
                Object object2 = iterator0.next();
            }
            this.mCurrentForegroundId = (WorkGenerationalId)map$Entry0.getKey();
            if(this.mCallback != null) {
                ForegroundInfo foregroundInfo1 = (ForegroundInfo)map$Entry0.getValue();
                this.mCallback.startForeground(foregroundInfo1.getNotificationId(), foregroundInfo1.getForegroundServiceType(), foregroundInfo1.getNotification());
                this.mCallback.cancelNotification(foregroundInfo1.getNotificationId());
            }
        }
        Callback systemForegroundDispatcher$Callback0 = this.mCallback;
        if(foregroundInfo0 != null && systemForegroundDispatcher$Callback0 != null) {
            Logger.get().debug("WM-SystemFgDispatcher", "Removing Notification (id: " + foregroundInfo0.getNotificationId() + ", workSpecId: " + id + ", notificationType: " + foregroundInfo0.getForegroundServiceType());
            systemForegroundDispatcher$Callback0.cancelNotification(foregroundInfo0.getNotificationId());
        }
    }

    void onStartCommand(Intent intent) {
        String s = intent.getAction();
        if("ACTION_START_FOREGROUND".equals(s)) {
            this.handleStartForeground(intent);
            this.handleNotify(intent);
            return;
        }
        if("ACTION_NOTIFY".equals(s)) {
            this.handleNotify(intent);
            return;
        }
        if("ACTION_CANCEL_WORK".equals(s)) {
            this.handleCancelWork(intent);
            return;
        }
        if("ACTION_STOP_FOREGROUND".equals(s)) {
            this.handleStop(intent);
        }
    }

    void setCallback(Callback callback) {
        if(this.mCallback != null) {
            Logger.get().error("WM-SystemFgDispatcher", "A callback already exists.");
            return;
        }
        this.mCallback = callback;
    }
}

