package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo.TriggerContentUri;
import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints.ContentUriTrigger;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;

class SystemJobInfoConverter {
    static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    static final String EXTRA_WORK_SPEC_GENERATION = "EXTRA_WORK_SPEC_GENERATION";
    static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    private static final String TAG;
    private final ComponentName mWorkServiceComponent;

    static {
        SystemJobInfoConverter.TAG = "WM-SystemJobInfoConvert";
    }

    SystemJobInfoConverter(Context context) {
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    JobInfo convert(WorkSpec workSpec, int jobId) {
        Constraints constraints0 = workSpec.constraints;
        PersistableBundle persistableBundle0 = new PersistableBundle();
        persistableBundle0.putString("EXTRA_WORK_SPEC_ID", workSpec.id);
        persistableBundle0.putInt("EXTRA_WORK_SPEC_GENERATION", workSpec.getGeneration());
        persistableBundle0.putBoolean("EXTRA_IS_PERIODIC", workSpec.isPeriodic());
        JobInfo.Builder jobInfo$Builder0 = new JobInfo.Builder(jobId, this.mWorkServiceComponent).setRequiresCharging(constraints0.requiresCharging()).setRequiresDeviceIdle(constraints0.requiresDeviceIdle()).setExtras(persistableBundle0);
        SystemJobInfoConverter.setRequiredNetwork(jobInfo$Builder0, constraints0.getRequiredNetworkType());
        boolean z = false;
        if(!constraints0.requiresDeviceIdle()) {
            jobInfo$Builder0.setBackoffCriteria(workSpec.backoffDelayDuration, (workSpec.backoffPolicy == BackoffPolicy.LINEAR ? 0 : 1));
        }
        long v1 = Math.max(workSpec.calculateNextRunTime() - System.currentTimeMillis(), 0L);
        if(Build.VERSION.SDK_INT <= 28) {
            jobInfo$Builder0.setMinimumLatency(v1);
        }
        else if(v1 > 0L) {
            jobInfo$Builder0.setMinimumLatency(v1);
        }
        else if(!workSpec.expedited) {
            jobInfo$Builder0.setImportantWhileForeground(true);
        }
        if(Build.VERSION.SDK_INT >= 24 && constraints0.hasContentUriTriggers()) {
            for(Object object0: constraints0.getContentUriTriggers()) {
                jobInfo$Builder0.addTriggerContentUri(SystemJobInfoConverter.convertContentUriTrigger(((ContentUriTrigger)object0)));
            }
            jobInfo$Builder0.setTriggerContentUpdateDelay(constraints0.getContentTriggerUpdateDelayMillis());
            jobInfo$Builder0.setTriggerContentMaxDelay(constraints0.getContentTriggerMaxDelayMillis());
        }
        jobInfo$Builder0.setPersisted(false);
        if(Build.VERSION.SDK_INT >= 26) {
            jobInfo$Builder0.setRequiresBatteryNotLow(constraints0.requiresBatteryNotLow());
            jobInfo$Builder0.setRequiresStorageNotLow(constraints0.requiresStorageNotLow());
        }
        boolean z1 = workSpec.runAttemptCount > 0;
        if(v1 > 0L) {
            z = true;
        }
        if(Build.VERSION.SDK_INT >= 0x1F && workSpec.expedited && !z1 && !z) {
            jobInfo$Builder0.setExpedited(true);
        }
        return jobInfo$Builder0.build();
    }

    private static JobInfo.TriggerContentUri convertContentUriTrigger(ContentUriTrigger trigger) {
        return new JobInfo.TriggerContentUri(trigger.getUri(), ((int)trigger.isTriggeredForDescendants()));
    }

    static int convertNetworkType(NetworkType networkType) {
        switch(networkType) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                if(Build.VERSION.SDK_INT >= 24) {
                    return 3;
                }
                break;
            }
            case 5: {
                if(Build.VERSION.SDK_INT >= 26) {
                    return 4;
                }
            }
        }
        Logger.get().debug("WM-SystemJobInfoConvert", "API version too low. Cannot convert network type value " + networkType);
        return 1;
    }

    static void setRequiredNetwork(JobInfo.Builder builder, NetworkType networkType) {
        if(Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
            return;
        }
        builder.setRequiredNetworkType(SystemJobInfoConverter.convertNetworkType(networkType));
    }
}

