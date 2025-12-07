package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.WorkInfo.State;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0012\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\nH\'J\u000E\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u000E\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0014\u0010\r\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u000EH\'J\u0016\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0010\u001A\u00020\nH\'J\u0016\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0016\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0014\u001A\u00020\u0015H\'J\u000E\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\'J\u0016\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00150\u000E2\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u000E\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\'J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0016\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u001C\u001A\u00020\u0005H\'J\u0016\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u001E\u001A\u00020\u0005H\'J\u0012\u0010\u001F\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0016\u0010 \u001A\b\u0012\u0004\u0012\u00020!0\u00072\u0006\u0010\u001C\u001A\u00020\u0005H\'J\u0012\u0010\"\u001A\u0004\u0018\u00010#2\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u001C\u0010$\u001A\b\u0012\u0004\u0012\u00020#0\u00072\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0016\u0010&\u001A\b\u0012\u0004\u0012\u00020#0\u00072\u0006\u0010\u001C\u001A\u00020\u0005H\'J\u0016\u0010\'\u001A\b\u0012\u0004\u0012\u00020#0\u00072\u0006\u0010\u001E\u001A\u00020\u0005H\'J\"\u0010(\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00070\u000E2\f\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u001C\u0010)\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00070\u000E2\u0006\u0010\u001C\u001A\u00020\u0005H\'J\u001C\u0010*\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00070\u000E2\u0006\u0010\u001E\u001A\u00020\u0005H\'J\b\u0010+\u001A\u00020,H\'J\u0010\u0010-\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0010\u0010.\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0010\u0010/\u001A\u00020\n2\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0010\u00100\u001A\u00020\u00032\u0006\u00101\u001A\u00020\bH\'J\u0018\u00102\u001A\u00020\n2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u00103\u001A\u00020\u0015H\'J\b\u00104\u001A\u00020\u0003H\'J\b\u00105\u001A\u00020\nH\'J\u0010\u00106\u001A\u00020\n2\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0018\u00107\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u00108\u001A\u00020\u0015H\'J\u0018\u00109\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010:\u001A\u00020\u0012H\'J\u0018\u0010;\u001A\u00020\n2\u0006\u0010<\u001A\u00020\u001A2\u0006\u0010\u0004\u001A\u00020\u0005H\'J\u0010\u0010=\u001A\u00020\u00032\u0006\u00101\u001A\u00020\bH\'\u00A8\u0006>"}, d2 = {"Landroidx/work/impl/model/WorkSpecDao;", "", "delete", "", "id", "", "getAllEligibleWorkSpecsForScheduling", "", "Landroidx/work/impl/model/WorkSpec;", "maxLimit", "", "getAllUnfinishedWork", "getAllWorkSpecIds", "getAllWorkSpecIdsLiveData", "Landroidx/lifecycle/LiveData;", "getEligibleWorkForScheduling", "schedulerLimit", "getInputsFromPrerequisites", "Landroidx/work/Data;", "getRecentlyCompletedWork", "startingAt", "", "getRunningWork", "getScheduleRequestedAtLiveData", "getScheduledWork", "getState", "Landroidx/work/WorkInfo$State;", "getUnfinishedWorkWithName", "name", "getUnfinishedWorkWithTag", "tag", "getWorkSpec", "getWorkSpecIdAndStatesForName", "Landroidx/work/impl/model/WorkSpec$IdAndState;", "getWorkStatusPojoForId", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "getWorkStatusPojoForIds", "ids", "getWorkStatusPojoForName", "getWorkStatusPojoForTag", "getWorkStatusPojoLiveDataForIds", "getWorkStatusPojoLiveDataForName", "getWorkStatusPojoLiveDataForTag", "hasUnfinishedWork", "", "incrementGeneration", "incrementPeriodCount", "incrementWorkSpecRunAttemptCount", "insertWorkSpec", "workSpec", "markWorkSpecScheduled", "startTime", "pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast", "resetScheduledState", "resetWorkSpecRunAttemptCount", "setLastEnqueuedTime", "enqueueTime", "setOutput", "output", "setState", "state", "updateWorkSpec", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface WorkSpecDao {
    void delete(String arg1);

    List getAllEligibleWorkSpecsForScheduling(int arg1);

    List getAllUnfinishedWork();

    List getAllWorkSpecIds();

    LiveData getAllWorkSpecIdsLiveData();

    List getEligibleWorkForScheduling(int arg1);

    List getInputsFromPrerequisites(String arg1);

    List getRecentlyCompletedWork(long arg1);

    List getRunningWork();

    LiveData getScheduleRequestedAtLiveData(String arg1);

    List getScheduledWork();

    State getState(String arg1);

    List getUnfinishedWorkWithName(String arg1);

    List getUnfinishedWorkWithTag(String arg1);

    WorkSpec getWorkSpec(String arg1);

    List getWorkSpecIdAndStatesForName(String arg1);

    WorkInfoPojo getWorkStatusPojoForId(String arg1);

    List getWorkStatusPojoForIds(List arg1);

    List getWorkStatusPojoForName(String arg1);

    List getWorkStatusPojoForTag(String arg1);

    LiveData getWorkStatusPojoLiveDataForIds(List arg1);

    LiveData getWorkStatusPojoLiveDataForName(String arg1);

    LiveData getWorkStatusPojoLiveDataForTag(String arg1);

    boolean hasUnfinishedWork();

    void incrementGeneration(String arg1);

    void incrementPeriodCount(String arg1);

    int incrementWorkSpecRunAttemptCount(String arg1);

    void insertWorkSpec(WorkSpec arg1);

    int markWorkSpecScheduled(String arg1, long arg2);

    void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();

    int resetScheduledState();

    int resetWorkSpecRunAttemptCount(String arg1);

    void setLastEnqueuedTime(String arg1, long arg2);

    void setOutput(String arg1, Data arg2);

    int setState(State arg1, String arg2);

    void updateWorkSpec(WorkSpec arg1);
}

