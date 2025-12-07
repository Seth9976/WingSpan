package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandHandler implements ExecutionListener {
    static final String ACTION_CONSTRAINTS_CHANGED = "ACTION_CONSTRAINTS_CHANGED";
    static final String ACTION_DELAY_MET = "ACTION_DELAY_MET";
    static final String ACTION_EXECUTION_COMPLETED = "ACTION_EXECUTION_COMPLETED";
    static final String ACTION_RESCHEDULE = "ACTION_RESCHEDULE";
    static final String ACTION_SCHEDULE_WORK = "ACTION_SCHEDULE_WORK";
    static final String ACTION_STOP_WORK = "ACTION_STOP_WORK";
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_GENERATION = "KEY_WORKSPEC_GENERATION";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = null;
    static final long WORK_PROCESSING_TIME_IN_MS = 600000L;
    private final Context mContext;
    private final Object mLock;
    private final Map mPendingDelayMet;
    private final StartStopTokens mStartStopTokens;

    static {
        CommandHandler.TAG = "WM-CommandHandler";
    }

    CommandHandler(Context context, StartStopTokens startStopTokens) {
        this.mContext = context;
        this.mStartStopTokens = startStopTokens;
        this.mPendingDelayMet = new HashMap();
        this.mLock = new Object();
    }

    static Intent createConstraintsChangedIntent(Context context) {
        Intent intent0 = new Intent(context, SystemAlarmService.class);
        intent0.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent0;
    }

    static Intent createDelayMetIntent(Context context, WorkGenerationalId id) {
        Intent intent0 = new Intent(context, SystemAlarmService.class);
        intent0.setAction("ACTION_DELAY_MET");
        return CommandHandler.writeWorkGenerationalId(intent0, id);
    }

    static Intent createExecutionCompletedIntent(Context context, WorkGenerationalId id, boolean needsReschedule) {
        Intent intent0 = new Intent(context, SystemAlarmService.class);
        intent0.setAction("ACTION_EXECUTION_COMPLETED");
        intent0.putExtra("KEY_NEEDS_RESCHEDULE", needsReschedule);
        return CommandHandler.writeWorkGenerationalId(intent0, id);
    }

    static Intent createRescheduleIntent(Context context) {
        Intent intent0 = new Intent(context, SystemAlarmService.class);
        intent0.setAction("ACTION_RESCHEDULE");
        return intent0;
    }

    static Intent createScheduleWorkIntent(Context context, WorkGenerationalId id) {
        Intent intent0 = new Intent(context, SystemAlarmService.class);
        intent0.setAction("ACTION_SCHEDULE_WORK");
        return CommandHandler.writeWorkGenerationalId(intent0, id);
    }

    static Intent createStopWorkIntent(Context context, WorkGenerationalId id) {
        Intent intent0 = new Intent(context, SystemAlarmService.class);
        intent0.setAction("ACTION_STOP_WORK");
        return CommandHandler.writeWorkGenerationalId(intent0, id);
    }

    static Intent createStopWorkIntent(Context context, String workSpecId) {
        Intent intent0 = new Intent(context, SystemAlarmService.class);
        intent0.setAction("ACTION_STOP_WORK");
        intent0.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent0;
    }

    private void handleConstraintsChanged(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        Logger.get().debug("WM-CommandHandler", "Handling constraints changed " + intent);
        new ConstraintsCommandHandler(this.mContext, startId, dispatcher).handleConstraintsChanged();
    }

    private void handleDelayMet(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        synchronized(this.mLock) {
            WorkGenerationalId workGenerationalId0 = CommandHandler.readWorkGenerationalId(intent);
            Logger.get().debug("WM-CommandHandler", "Handing delay met for " + workGenerationalId0);
            if(this.mPendingDelayMet.containsKey(workGenerationalId0)) {
                Logger.get().debug("WM-CommandHandler", "WorkSpec " + workGenerationalId0 + " is is already being handled for ACTION_DELAY_MET");
            }
            else {
                StartStopToken startStopToken0 = this.mStartStopTokens.tokenFor(workGenerationalId0);
                DelayMetCommandHandler delayMetCommandHandler0 = new DelayMetCommandHandler(this.mContext, startId, dispatcher, startStopToken0);
                this.mPendingDelayMet.put(workGenerationalId0, delayMetCommandHandler0);
                delayMetCommandHandler0.handleProcessWork();
            }
        }
    }

    private void handleExecutionCompleted(Intent intent, int startId) {
        WorkGenerationalId workGenerationalId0 = CommandHandler.readWorkGenerationalId(intent);
        boolean z = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
        Logger.get().debug("WM-CommandHandler", "Handling onExecutionCompleted " + intent + ", " + startId);
        this.onExecuted(workGenerationalId0, z);
    }

    private void handleReschedule(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        Logger.get().debug("WM-CommandHandler", "Handling reschedule " + intent + ", " + startId);
        dispatcher.getWorkManager().rescheduleEligibleWork();
    }

    private void handleScheduleWorkIntent(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        WorkGenerationalId workGenerationalId0 = CommandHandler.readWorkGenerationalId(intent);
        Logger.get().debug("WM-CommandHandler", "Handling schedule work for " + workGenerationalId0);
        WorkDatabase workDatabase0 = dispatcher.getWorkManager().getWorkDatabase();
        workDatabase0.beginTransaction();
        try {
            WorkSpec workSpec0 = workDatabase0.workSpecDao().getWorkSpec(workGenerationalId0.getWorkSpecId());
            if(workSpec0 == null) {
                Logger.get().warning("WM-CommandHandler", "Skipping scheduling " + workGenerationalId0 + " because it\'s no longer in the DB");
                return;
            }
            long v2 = workSpec0.calculateNextRunTime();
            if(workSpec0.hasConstraints()) {
                Logger.get().debug("WM-CommandHandler", "Opportunistically setting an alarm for " + workGenerationalId0 + "at " + v2);
                Alarms.setAlarm(this.mContext, workDatabase0, workGenerationalId0, v2);
                Intent intent1 = CommandHandler.createConstraintsChangedIntent(this.mContext);
                dispatcher.getTaskExecutor().getMainThreadExecutor().execute(new AddRunnable(dispatcher, intent1, startId));
            }
            else {
                Logger.get().debug("WM-CommandHandler", "Setting up Alarms for " + workGenerationalId0 + "at " + v2);
                Alarms.setAlarm(this.mContext, workDatabase0, workGenerationalId0, v2);
            }
            workDatabase0.setTransactionSuccessful();
        }
        finally {
            workDatabase0.endTransaction();
        }
    }

    private void handleStopWork(Intent intent, SystemAlarmDispatcher dispatcher) {
        List list0;
        Bundle bundle0 = intent.getExtras();
        String s = bundle0.getString("KEY_WORKSPEC_ID");
        if(bundle0.containsKey("KEY_WORKSPEC_GENERATION")) {
            int v = bundle0.getInt("KEY_WORKSPEC_GENERATION");
            list0 = new ArrayList(1);
            WorkGenerationalId workGenerationalId0 = new WorkGenerationalId(s, v);
            StartStopToken startStopToken0 = this.mStartStopTokens.remove(workGenerationalId0);
            if(startStopToken0 != null) {
                list0.add(startStopToken0);
            }
        }
        else {
            list0 = this.mStartStopTokens.remove(s);
        }
        for(Object object0: list0) {
            Logger.get().debug("WM-CommandHandler", "Handing stopWork work for " + s);
            dispatcher.getWorkManager().stopWork(((StartStopToken)object0));
            Alarms.cancelAlarm(this.mContext, dispatcher.getWorkManager().getWorkDatabase(), ((StartStopToken)object0).getId());
            dispatcher.onExecuted(((StartStopToken)object0).getId(), false);
        }
    }

    private static boolean hasKeys(Bundle bundle, String[] keys) {
        if(bundle != null && !bundle.isEmpty()) {
            for(int v = 0; v < keys.length; ++v) {
                if(bundle.get(keys[v]) == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    boolean hasPendingCommands() {
        synchronized(this.mLock) {
        }
        return !this.mPendingDelayMet.isEmpty();
    }

    @Override  // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId id, boolean needsReschedule) {
        synchronized(this.mLock) {
            DelayMetCommandHandler delayMetCommandHandler0 = (DelayMetCommandHandler)this.mPendingDelayMet.remove(id);
            this.mStartStopTokens.remove(id);
            if(delayMetCommandHandler0 != null) {
                delayMetCommandHandler0.onExecuted(needsReschedule);
            }
        }
    }

    void onHandleIntent(Intent intent, int startId, SystemAlarmDispatcher dispatcher) {
        String s = intent.getAction();
        if("ACTION_CONSTRAINTS_CHANGED".equals(s)) {
            this.handleConstraintsChanged(intent, startId, dispatcher);
            return;
        }
        if("ACTION_RESCHEDULE".equals(s)) {
            this.handleReschedule(intent, startId, dispatcher);
            return;
        }
        if(!CommandHandler.hasKeys(intent.getExtras(), new String[]{"KEY_WORKSPEC_ID"})) {
            Logger.get().error("WM-CommandHandler", "Invalid request for " + s + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if("ACTION_SCHEDULE_WORK".equals(s)) {
            this.handleScheduleWorkIntent(intent, startId, dispatcher);
            return;
        }
        if("ACTION_DELAY_MET".equals(s)) {
            this.handleDelayMet(intent, startId, dispatcher);
            return;
        }
        if("ACTION_STOP_WORK".equals(s)) {
            this.handleStopWork(intent, dispatcher);
            return;
        }
        if("ACTION_EXECUTION_COMPLETED".equals(s)) {
            this.handleExecutionCompleted(intent, startId);
            return;
        }
        Logger.get().warning("WM-CommandHandler", "Ignoring intent " + intent);
    }

    static WorkGenerationalId readWorkGenerationalId(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    private static Intent writeWorkGenerationalId(Intent intent, WorkGenerationalId id) {
        intent.putExtra("KEY_WORKSPEC_ID", id.getWorkSpecId());
        intent.putExtra("KEY_WORKSPEC_GENERATION", id.getGeneration());
        return intent;
    }
}

