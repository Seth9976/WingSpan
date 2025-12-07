package androidx.core.app;

import android.app.AlarmManager.AlarmClockInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;

public final class AlarmManagerCompat {
    static class Api19Impl {
        static void setExact(AlarmManager alarmManager0, int v, long v1, PendingIntent pendingIntent0) {
            alarmManager0.setExact(v, v1, pendingIntent0);
        }
    }

    static class Api21Impl {
        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long v, PendingIntent pendingIntent0) {
            return new AlarmManager.AlarmClockInfo(v, pendingIntent0);
        }

        static void setAlarmClock(AlarmManager alarmManager0, Object object0, PendingIntent pendingIntent0) {
            alarmManager0.setAlarmClock(((AlarmManager.AlarmClockInfo)object0), pendingIntent0);
        }
    }

    static class Api23Impl {
        static void setAndAllowWhileIdle(AlarmManager alarmManager0, int v, long v1, PendingIntent pendingIntent0) {
            alarmManager0.setAndAllowWhileIdle(v, v1, pendingIntent0);
        }

        static void setExactAndAllowWhileIdle(AlarmManager alarmManager0, int v, long v1, PendingIntent pendingIntent0) {
            alarmManager0.setExactAndAllowWhileIdle(v, v1, pendingIntent0);
        }
    }

    public static void setAlarmClock(AlarmManager alarmManager0, long v, PendingIntent pendingIntent0, PendingIntent pendingIntent1) {
        Api21Impl.setAlarmClock(alarmManager0, Api21Impl.createAlarmClockInfo(v, pendingIntent0), pendingIntent1);
    }

    public static void setAndAllowWhileIdle(AlarmManager alarmManager0, int v, long v1, PendingIntent pendingIntent0) {
        Api23Impl.setAndAllowWhileIdle(alarmManager0, v, v1, pendingIntent0);
    }

    public static void setExact(AlarmManager alarmManager0, int v, long v1, PendingIntent pendingIntent0) {
        Api19Impl.setExact(alarmManager0, v, v1, pendingIntent0);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager0, int v, long v1, PendingIntent pendingIntent0) {
        Api23Impl.setExactAndAllowWhileIdle(alarmManager0, v, v1, pendingIntent0);
    }
}

