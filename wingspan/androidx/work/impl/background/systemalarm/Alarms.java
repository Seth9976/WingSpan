package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;

class Alarms {
    static class Api19Impl {
        static void setExact(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
            alarmManager.setExact(type, triggerAtMillis, operation);
        }
    }

    private static final String TAG;

    static {
        Alarms.TAG = "WM-Alarms";
    }

    public static void cancelAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId id) {
        SystemIdInfoDao systemIdInfoDao0 = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo0 = systemIdInfoDao0.getSystemIdInfo(id);
        if(systemIdInfo0 != null) {
            Alarms.cancelExactAlarm(context, id, systemIdInfo0.systemId);
            Logger.get().debug("WM-Alarms", "Removing SystemIdInfo for workSpecId (" + id + ")");
            systemIdInfoDao0.removeSystemIdInfo(id);
        }
    }

    private static void cancelExactAlarm(Context context, WorkGenerationalId id, int alarmId) {
        AlarmManager alarmManager0 = (AlarmManager)context.getSystemService("alarm");
        PendingIntent pendingIntent0 = PendingIntent.getService(context, alarmId, CommandHandler.createDelayMetIntent(context, id), 0x24000000);
        if(pendingIntent0 != null && alarmManager0 != null) {
            Logger.get().debug("WM-Alarms", "Cancelling existing alarm with (workSpecId, systemId) (" + id + ", " + alarmId + ")");
            alarmManager0.cancel(pendingIntent0);
        }
    }

    public static void setAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId id, long triggerAtMillis) {
        SystemIdInfoDao systemIdInfoDao0 = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo0 = systemIdInfoDao0.getSystemIdInfo(id);
        if(systemIdInfo0 != null) {
            Alarms.cancelExactAlarm(context, id, systemIdInfo0.systemId);
            Alarms.setExactAlarm(context, id, systemIdInfo0.systemId, triggerAtMillis);
            return;
        }
        int v1 = new IdGenerator(workDatabase).nextAlarmManagerId();
        systemIdInfoDao0.insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(id, v1));
        Alarms.setExactAlarm(context, id, v1, triggerAtMillis);
    }

    private static void setExactAlarm(Context context, WorkGenerationalId id, int alarmId, long triggerAtMillis) {
        AlarmManager alarmManager0 = (AlarmManager)context.getSystemService("alarm");
        PendingIntent pendingIntent0 = PendingIntent.getService(context, alarmId, CommandHandler.createDelayMetIntent(context, id), 0xC000000);
        if(alarmManager0 != null) {
            Api19Impl.setExact(alarmManager0, 0, triggerAtMillis, pendingIntent0);
        }
    }
}

