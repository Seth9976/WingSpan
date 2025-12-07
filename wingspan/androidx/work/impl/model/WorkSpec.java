package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo.State;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0000\u00A2\u0006\u0002\u0010\bB\u00CB\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0015\u0012\b\b\u0003\u0010\u0016\u001A\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001A\u00020\u0019\u0012\b\b\u0002\u0010\u001A\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u001B\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u001C\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u001D\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u001E\u001A\u00020\u001F\u0012\b\b\u0002\u0010 \u001A\u00020!\u0012\b\b\u0002\u0010\"\u001A\u00020\u0017\u0012\b\b\u0002\u0010#\u001A\u00020\u0017\u00A2\u0006\u0002\u0010$J\u0006\u0010-\u001A\u00020\u0011J\t\u0010.\u001A\u00020\u0003H\u00C6\u0003J\t\u0010/\u001A\u00020\u0015H\u00C6\u0003J\t\u00100\u001A\u00020\u0017H\u00C6\u0003J\t\u00101\u001A\u00020\u0019H\u00C6\u0003J\t\u00102\u001A\u00020\u0011H\u00C6\u0003J\t\u00103\u001A\u00020\u0011H\u00C6\u0003J\t\u00104\u001A\u00020\u0011H\u00C6\u0003J\t\u00105\u001A\u00020\u0011H\u00C6\u0003J\t\u00106\u001A\u00020\u001FH\u00C6\u0003J\t\u00107\u001A\u00020!H\u00C6\u0003J\t\u00108\u001A\u00020\u0017H\u00C6\u0003J\t\u00109\u001A\u00020\nH\u00C6\u0003J\t\u0010:\u001A\u00020\u0017H\u00C6\u0003J\t\u0010;\u001A\u00020\u0003H\u00C6\u0003J\u000B\u0010<\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010=\u001A\u00020\u000EH\u00C6\u0003J\t\u0010>\u001A\u00020\u000EH\u00C6\u0003J\t\u0010?\u001A\u00020\u0011H\u00C6\u0003J\t\u0010@\u001A\u00020\u0011H\u00C6\u0003J\t\u0010A\u001A\u00020\u0011H\u00C6\u0003J\u00D3\u0001\u0010B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0013\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0003\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u00112\b\b\u0002\u0010\u001B\u001A\u00020\u00112\b\b\u0002\u0010\u001C\u001A\u00020\u00112\b\b\u0002\u0010\u001D\u001A\u00020\u00112\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020\u00172\b\b\u0002\u0010#\u001A\u00020\u0017H\u00C6\u0001J\u0013\u0010C\u001A\u00020\u001F2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\u0006\u0010D\u001A\u00020\u001FJ\t\u0010E\u001A\u00020\u0017H\u00D6\u0001J\u000E\u0010F\u001A\u00020G2\u0006\u0010\u001A\u001A\u00020\u0011J\u000E\u0010H\u001A\u00020G2\u0006\u0010\u0012\u001A\u00020\u0011J\u0016\u0010H\u001A\u00020G2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011J\b\u0010I\u001A\u00020\u0003H\u0016R\u0012\u0010\u001A\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001A\u00020\u00198\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001A\u00020\u00158\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u001E\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0016\u0010#\u001A\u00020\u00178\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\r\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0011\u0010\'\u001A\u00020\u001F8F\u00A2\u0006\u0006\u001A\u0004\b\'\u0010(R\u0011\u0010)\u001A\u00020\u001F8F\u00A2\u0006\u0006\u001A\u0004\b)\u0010(R\u0012\u0010\u001B\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u001C\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010 \u001A\u00020!8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u000F\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u001E\u0010\"\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b*\u0010&\"\u0004\b+\u0010,R\u0012\u0010\u0016\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u001D\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u00020\n8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u000B\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000\u00A8\u0006M"}, d2 = {"Landroidx/work/impl/model/WorkSpec;", "", "id", "", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "other", "(Ljava/lang/String;Landroidx/work/impl/model/WorkSpec;)V", "state", "Landroidx/work/WorkInfo$State;", "workerClassName", "inputMergerClassName", "input", "Landroidx/work/Data;", "output", "initialDelay", "", "intervalDuration", "flexDuration", "constraints", "Landroidx/work/Constraints;", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "expedited", "", "outOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "periodCount", "generation", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;II)V", "getGeneration", "()I", "isBackedOff", "()Z", "isPeriodic", "getPeriodCount", "setPeriodCount", "(I)V", "calculateNextRunTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "hasConstraints", "hashCode", "setBackoffDelayDuration", "", "setPeriodic", "toString", "Companion", "IdAndState", "WorkInfoPojo", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class WorkSpec {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/work/impl/model/WorkSpec$Companion;", "", "()V", "SCHEDULE_NOT_REQUESTED_YET", "", "TAG", "", "WORK_INFO_MAPPER", "Landroidx/arch/core/util/Function;", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "Landroidx/work/WorkInfo;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001A\u00020\u0003HÆ\u0003J\t\u0010\b\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/work/impl/model/WorkSpec$IdAndState;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class IdAndState {
        public String id;
        public State state;

        public IdAndState(String s, State workInfo$State0) {
            Intrinsics.checkNotNullParameter(s, "id");
            Intrinsics.checkNotNullParameter(workInfo$State0, "state");
            super();
            this.id = s;
            this.state = workInfo$State0;
        }

        public final String component1() {
            return this.id;
        }

        public final State component2() {
            return this.state;
        }

        public final IdAndState copy(String s, State workInfo$State0) {
            Intrinsics.checkNotNullParameter(s, "id");
            Intrinsics.checkNotNullParameter(workInfo$State0, "state");
            return new IdAndState(s, workInfo$State0);
        }

        public static IdAndState copy$default(IdAndState workSpec$IdAndState0, String s, State workInfo$State0, int v, Object object0) {
            if((v & 1) != 0) {
                s = workSpec$IdAndState0.id;
            }
            if((v & 2) != 0) {
                workInfo$State0 = workSpec$IdAndState0.state;
            }
            return workSpec$IdAndState0.copy(s, workInfo$State0);
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof IdAndState)) {
                return false;
            }
            return Intrinsics.areEqual(this.id, ((IdAndState)object0).id) ? this.state == ((IdAndState)object0).state : false;
        }

        @Override
        public int hashCode() {
            return this.id.hashCode() * 0x1F + this.state.hashCode();
        }

        @Override
        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00070\f\u00A2\u0006\u0002\u0010\u000EJ\t\u0010&\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\'\u001A\u00020\u0005H\u00C6\u0003J\t\u0010(\u001A\u00020\u0007H\u00C6\u0003J\t\u0010)\u001A\u00020\tH\u00C6\u0003J\t\u0010*\u001A\u00020\tH\u00C6\u0003J\u000F\u0010+\u001A\b\u0012\u0004\u0012\u00020\u00030\fH\u00C6\u0003J\u000F\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00070\fH\u00C6\u0003J[\u0010-\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\f2\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00070\fH\u00C6\u0001J\u0013\u0010.\u001A\u00020/2\b\u00100\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u00101\u001A\u00020\tH\u00D6\u0001J\t\u00102\u001A\u00020\u0003H\u00D6\u0001J\u0006\u00103\u001A\u000204R\u0016\u0010\n\u001A\u00020\t8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001E\u0010\u0006\u001A\u00020\u00078\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00070\f8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001E\u0010\b\u001A\u00020\t8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0010\"\u0004\b\u001E\u0010\u001FR\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\f8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u001A\"\u0004\b%\u0010\u001C\u00A8\u00065"}, d2 = {"Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "output", "Landroidx/work/Data;", "runAttemptCount", "", "generation", "tags", "", "progress", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Landroidx/work/Data;IILjava/util/List;Ljava/util/List;)V", "getGeneration", "()I", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getOutput", "()Landroidx/work/Data;", "setOutput", "(Landroidx/work/Data;)V", "getProgress", "()Ljava/util/List;", "setProgress", "(Ljava/util/List;)V", "getRunAttemptCount", "setRunAttemptCount", "(I)V", "getState", "()Landroidx/work/WorkInfo$State;", "setState", "(Landroidx/work/WorkInfo$State;)V", "getTags", "setTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "toWorkInfo", "Landroidx/work/WorkInfo;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class WorkInfoPojo {
        private final int generation;
        private String id;
        private Data output;
        private List progress;
        private int runAttemptCount;
        private State state;
        private List tags;

        public WorkInfoPojo(String s, State workInfo$State0, Data data0, int v, int v1, List list0, List list1) {
            Intrinsics.checkNotNullParameter(s, "id");
            Intrinsics.checkNotNullParameter(workInfo$State0, "state");
            Intrinsics.checkNotNullParameter(data0, "output");
            Intrinsics.checkNotNullParameter(list0, "tags");
            Intrinsics.checkNotNullParameter(list1, "progress");
            super();
            this.id = s;
            this.state = workInfo$State0;
            this.output = data0;
            this.runAttemptCount = v;
            this.generation = v1;
            this.tags = list0;
            this.progress = list1;
        }

        public final String component1() {
            return this.id;
        }

        public final State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final int component4() {
            return this.runAttemptCount;
        }

        public final int component5() {
            return this.generation;
        }

        public final List component6() {
            return this.tags;
        }

        public final List component7() {
            return this.progress;
        }

        public final WorkInfoPojo copy(String s, State workInfo$State0, Data data0, int v, int v1, List list0, List list1) {
            Intrinsics.checkNotNullParameter(s, "id");
            Intrinsics.checkNotNullParameter(workInfo$State0, "state");
            Intrinsics.checkNotNullParameter(data0, "output");
            Intrinsics.checkNotNullParameter(list0, "tags");
            Intrinsics.checkNotNullParameter(list1, "progress");
            return new WorkInfoPojo(s, workInfo$State0, data0, v, v1, list0, list1);
        }

        public static WorkInfoPojo copy$default(WorkInfoPojo workSpec$WorkInfoPojo0, String s, State workInfo$State0, Data data0, int v, int v1, List list0, List list1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                s = workSpec$WorkInfoPojo0.id;
            }
            if((v2 & 2) != 0) {
                workInfo$State0 = workSpec$WorkInfoPojo0.state;
            }
            if((v2 & 4) != 0) {
                data0 = workSpec$WorkInfoPojo0.output;
            }
            if((v2 & 8) != 0) {
                v = workSpec$WorkInfoPojo0.runAttemptCount;
            }
            if((v2 & 16) != 0) {
                v1 = workSpec$WorkInfoPojo0.generation;
            }
            if((v2 & 0x20) != 0) {
                list0 = workSpec$WorkInfoPojo0.tags;
            }
            if((v2 & 0x40) != 0) {
                list1 = workSpec$WorkInfoPojo0.progress;
            }
            return workSpec$WorkInfoPojo0.copy(s, workInfo$State0, data0, v, v1, list0, list1);
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof WorkInfoPojo)) {
                return false;
            }
            if(!Intrinsics.areEqual(this.id, ((WorkInfoPojo)object0).id)) {
                return false;
            }
            if(this.state != ((WorkInfoPojo)object0).state) {
                return false;
            }
            if(!Intrinsics.areEqual(this.output, ((WorkInfoPojo)object0).output)) {
                return false;
            }
            if(this.runAttemptCount != ((WorkInfoPojo)object0).runAttemptCount) {
                return false;
            }
            if(this.generation != ((WorkInfoPojo)object0).generation) {
                return false;
            }
            return Intrinsics.areEqual(this.tags, ((WorkInfoPojo)object0).tags) ? Intrinsics.areEqual(this.progress, ((WorkInfoPojo)object0).progress) : false;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final String getId() {
            return this.id;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final List getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final State getState() {
            return this.state;
        }

        public final List getTags() {
            return this.tags;
        }

        @Override
        public int hashCode() {
            return (((((this.id.hashCode() * 0x1F + this.state.hashCode()) * 0x1F + this.output.hashCode()) * 0x1F + this.runAttemptCount) * 0x1F + this.generation) * 0x1F + this.tags.hashCode()) * 0x1F + this.progress.hashCode();
        }

        public final void setId(String s) {
            Intrinsics.checkNotNullParameter(s, "<set-?>");
            this.id = s;
        }

        public final void setOutput(Data data0) {
            Intrinsics.checkNotNullParameter(data0, "<set-?>");
            this.output = data0;
        }

        public final void setProgress(List list0) {
            Intrinsics.checkNotNullParameter(list0, "<set-?>");
            this.progress = list0;
        }

        public final void setRunAttemptCount(int v) {
            this.runAttemptCount = v;
        }

        public final void setState(State workInfo$State0) {
            Intrinsics.checkNotNullParameter(workInfo$State0, "<set-?>");
            this.state = workInfo$State0;
        }

        public final void setTags(List list0) {
            Intrinsics.checkNotNullParameter(list0, "<set-?>");
            this.tags = list0;
        }

        @Override
        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public final WorkInfo toWorkInfo() {
            if(!this.progress.isEmpty() != 0) {
                Data data0 = (Data)this.progress.get(0);
                return new WorkInfo(UUID.fromString(this.id), this.state, this.output, this.tags, data0, this.runAttemptCount, this.generation);
            }
            return new WorkInfo(UUID.fromString(this.id), this.state, this.output, this.tags, Data.EMPTY, this.runAttemptCount, this.generation);
        }
    }

    public static final Companion Companion = null;
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1L;
    private static final String TAG;
    public static final Function WORK_INFO_MAPPER;
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    private final int generation;
    public final String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long lastEnqueueTime;
    public long minimumRetentionDuration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    private int periodCount;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public State state;
    public String workerClassName;

    static {
        WorkSpec.Companion = new Companion(null);
        Intrinsics.checkNotNullExpressionValue("WM-WorkSpec", "tagWithPrefix(\"WorkSpec\")");
        WorkSpec.TAG = "WM-WorkSpec";
        WorkSpec.WORK_INFO_MAPPER = (List list0) -> {
            if(list0 != null) {
                ArrayList arrayList0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list0, 10));
                for(Object object0: list0) {
                    arrayList0.add(((WorkInfoPojo)object0).toWorkInfo());
                }
                return arrayList0;
            }
            return null;
        };
    }

    public WorkSpec(String s, State workInfo$State0, String s1, String s2, Data data0, Data data1, long v, long v1, long v2, Constraints constraints0, int v3, BackoffPolicy backoffPolicy0, long v4, long v5, long v6, long v7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy0, int v8, int v9) {
        Intrinsics.checkNotNullParameter(s, "id");
        Intrinsics.checkNotNullParameter(workInfo$State0, "state");
        Intrinsics.checkNotNullParameter(s1, "workerClassName");
        Intrinsics.checkNotNullParameter(data0, "input");
        Intrinsics.checkNotNullParameter(data1, "output");
        Intrinsics.checkNotNullParameter(constraints0, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy0, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy0, "outOfQuotaPolicy");
        super();
        this.id = s;
        this.state = workInfo$State0;
        this.workerClassName = s1;
        this.inputMergerClassName = s2;
        this.input = data0;
        this.output = data1;
        this.initialDelay = v;
        this.intervalDuration = v1;
        this.flexDuration = v2;
        this.constraints = constraints0;
        this.runAttemptCount = v3;
        this.backoffPolicy = backoffPolicy0;
        this.backoffDelayDuration = v4;
        this.lastEnqueueTime = v5;
        this.minimumRetentionDuration = v6;
        this.scheduleRequestedAt = v7;
        this.expedited = z;
        this.outOfQuotaPolicy = outOfQuotaPolicy0;
        this.periodCount = v8;
        this.generation = v9;
    }

    public WorkSpec(String s, State workInfo$State0, String s1, String s2, Data data0, Data data1, long v, long v1, long v2, Constraints constraints0, int v3, BackoffPolicy backoffPolicy0, long v4, long v5, long v6, long v7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy0, int v8, int v9, int v10, DefaultConstructorMarker defaultConstructorMarker0) {
        Data data3;
        Data data2;
        State workInfo$State1 = (v10 & 2) == 0 ? workInfo$State0 : State.ENQUEUED;
        if((v10 & 16) == 0) {
            data2 = data0;
        }
        else {
            Intrinsics.checkNotNullExpressionValue(Data.EMPTY, "EMPTY");
            data2 = Data.EMPTY;
        }
        if((v10 & 0x20) == 0) {
            data3 = data1;
        }
        else {
            Intrinsics.checkNotNullExpressionValue(Data.EMPTY, "EMPTY");
            data3 = Data.EMPTY;
        }
        this(s, workInfo$State1, s1, ((v10 & 8) == 0 ? s2 : null), data2, data3, ((v10 & 0x40) == 0 ? v : 0L), ((v10 & 0x80) == 0 ? v1 : 0L), ((v10 & 0x100) == 0 ? v2 : 0L), ((v10 & 0x200) == 0 ? constraints0 : Constraints.NONE), ((v10 & 0x400) == 0 ? v3 : 0), ((v10 & 0x800) == 0 ? backoffPolicy0 : BackoffPolicy.EXPONENTIAL), ((v10 & 0x1000) == 0 ? v4 : 30000L), ((v10 & 0x2000) == 0 ? v5 : 0L), ((v10 & 0x4000) == 0 ? v6 : 0L), ((0x8000 & v10) == 0 ? v7 : -1L), ((0x10000 & v10) == 0 ? z : false), ((0x20000 & v10) == 0 ? outOfQuotaPolicy0 : OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST), ((0x40000 & v10) == 0 ? v8 : 0), ((v10 & 0x80000) == 0 ? v9 : 0));
    }

    public WorkSpec(String s, WorkSpec workSpec0) {
        Intrinsics.checkNotNullParameter(s, "newId");
        Intrinsics.checkNotNullParameter(workSpec0, "other");
        this(s, workSpec0.state, workSpec0.workerClassName, workSpec0.inputMergerClassName, new Data(workSpec0.input), new Data(workSpec0.output), workSpec0.initialDelay, workSpec0.intervalDuration, workSpec0.flexDuration, new Constraints(workSpec0.constraints), workSpec0.runAttemptCount, workSpec0.backoffPolicy, workSpec0.backoffDelayDuration, workSpec0.lastEnqueueTime, workSpec0.minimumRetentionDuration, workSpec0.scheduleRequestedAt, workSpec0.expedited, workSpec0.outOfQuotaPolicy, workSpec0.periodCount, 0, 0x80000, null);
    }

    public WorkSpec(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "id");
        Intrinsics.checkNotNullParameter(s1, "workerClassName_");
        this(s, null, s1, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0xFFFFA, null);
    }

    // 检测为 Lambda 实现
    private static final List WORK_INFO_MAPPER$lambda$1(List list0) [...]

    public final long calculateNextRunTime() {
        long v = 0L;
        if(this.isBackedOff()) {
            return this.backoffPolicy == BackoffPolicy.LINEAR ? this.lastEnqueueTime + RangesKt.coerceAtMost(this.backoffDelayDuration * ((long)this.runAttemptCount), 18000000L) : this.lastEnqueueTime + RangesKt.coerceAtMost(((long)Math.scalb(this.backoffDelayDuration, this.runAttemptCount - 1)), 18000000L);
        }
        if(this.isPeriodic()) {
            int v1 = this.periodCount;
            long v2 = v1 == 0 ? this.lastEnqueueTime + this.initialDelay : this.lastEnqueueTime;
            long v3 = this.flexDuration;
            long v4 = this.intervalDuration;
            if(v3 != v4) {
                if(v1 == 0) {
                    v = -v3;
                }
                return v2 + v4 + v;
            }
            if(v1 != 0) {
                v = v4;
            }
            return v2 + v;
        }
        return this.initialDelay + (this.lastEnqueueTime == 0L ? System.currentTimeMillis() : this.lastEnqueueTime);
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String s, State workInfo$State0, String s1, String s2, Data data0, Data data1, long v, long v1, long v2, Constraints constraints0, int v3, BackoffPolicy backoffPolicy0, long v4, long v5, long v6, long v7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy0, int v8, int v9) {
        Intrinsics.checkNotNullParameter(s, "id");
        Intrinsics.checkNotNullParameter(workInfo$State0, "state");
        Intrinsics.checkNotNullParameter(s1, "workerClassName");
        Intrinsics.checkNotNullParameter(data0, "input");
        Intrinsics.checkNotNullParameter(data1, "output");
        Intrinsics.checkNotNullParameter(constraints0, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy0, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy0, "outOfQuotaPolicy");
        return new WorkSpec(s, workInfo$State0, s1, s2, data0, data1, v, v1, v2, constraints0, v3, backoffPolicy0, v4, v5, v6, v7, z, outOfQuotaPolicy0, v8, v9);
    }

    public static WorkSpec copy$default(WorkSpec workSpec0, String s, State workInfo$State0, String s1, String s2, Data data0, Data data1, long v, long v1, long v2, Constraints constraints0, int v3, BackoffPolicy backoffPolicy0, long v4, long v5, long v6, long v7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy0, int v8, int v9, int v10, Object object0) {
        String s3 = (v10 & 1) == 0 ? s : workSpec0.id;
        State workInfo$State1 = (v10 & 2) == 0 ? workInfo$State0 : workSpec0.state;
        String s4 = (v10 & 4) == 0 ? s1 : workSpec0.workerClassName;
        String s5 = (v10 & 8) == 0 ? s2 : workSpec0.inputMergerClassName;
        Data data2 = (v10 & 16) == 0 ? data0 : workSpec0.input;
        Data data3 = (v10 & 0x20) == 0 ? data1 : workSpec0.output;
        long v11 = (v10 & 0x40) == 0 ? v : workSpec0.initialDelay;
        long v12 = (v10 & 0x80) == 0 ? v1 : workSpec0.intervalDuration;
        long v13 = (v10 & 0x100) == 0 ? v2 : workSpec0.flexDuration;
        Constraints constraints1 = (v10 & 0x200) == 0 ? constraints0 : workSpec0.constraints;
        int v14 = (v10 & 0x400) == 0 ? v3 : workSpec0.runAttemptCount;
        BackoffPolicy backoffPolicy1 = (v10 & 0x800) == 0 ? backoffPolicy0 : workSpec0.backoffPolicy;
        long v15 = (v10 & 0x1000) == 0 ? v4 : workSpec0.backoffDelayDuration;
        long v16 = (v10 & 0x2000) == 0 ? v5 : workSpec0.lastEnqueueTime;
        long v17 = (v10 & 0x4000) == 0 ? v6 : workSpec0.minimumRetentionDuration;
        long v18 = (v10 & 0x8000) == 0 ? v7 : workSpec0.scheduleRequestedAt;
        boolean z1 = (v10 & 0x10000) == 0 ? z : workSpec0.expedited;
        OutOfQuotaPolicy outOfQuotaPolicy1 = (0x20000 & v10) == 0 ? outOfQuotaPolicy0 : workSpec0.outOfQuotaPolicy;
        int v19 = (v10 & 0x40000) == 0 ? v8 : workSpec0.periodCount;
        return (v10 & 0x80000) == 0 ? workSpec0.copy(s3, workInfo$State1, s4, s5, data2, data3, v11, v12, v13, constraints1, v14, backoffPolicy1, v15, v16, v17, v18, z1, outOfQuotaPolicy1, v19, v9) : workSpec0.copy(s3, workInfo$State1, s4, s5, data2, data3, v11, v12, v13, constraints1, v14, backoffPolicy1, v15, v16, v17, v18, z1, outOfQuotaPolicy1, v19, workSpec0.generation);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec0 = (WorkSpec)object0;
        if(!Intrinsics.areEqual(this.id, workSpec0.id)) {
            return false;
        }
        if(this.state != workSpec0.state) {
            return false;
        }
        if(!Intrinsics.areEqual(this.workerClassName, workSpec0.workerClassName)) {
            return false;
        }
        if(!Intrinsics.areEqual(this.inputMergerClassName, workSpec0.inputMergerClassName)) {
            return false;
        }
        if(!Intrinsics.areEqual(this.input, workSpec0.input)) {
            return false;
        }
        if(!Intrinsics.areEqual(this.output, workSpec0.output)) {
            return false;
        }
        if(this.initialDelay != workSpec0.initialDelay) {
            return false;
        }
        if(this.intervalDuration != workSpec0.intervalDuration) {
            return false;
        }
        if(this.flexDuration != workSpec0.flexDuration) {
            return false;
        }
        if(!Intrinsics.areEqual(this.constraints, workSpec0.constraints)) {
            return false;
        }
        if(this.runAttemptCount != workSpec0.runAttemptCount) {
            return false;
        }
        if(this.backoffPolicy != workSpec0.backoffPolicy) {
            return false;
        }
        if(this.backoffDelayDuration != workSpec0.backoffDelayDuration) {
            return false;
        }
        if(this.lastEnqueueTime != workSpec0.lastEnqueueTime) {
            return false;
        }
        if(this.minimumRetentionDuration != workSpec0.minimumRetentionDuration) {
            return false;
        }
        if(this.scheduleRequestedAt != workSpec0.scheduleRequestedAt) {
            return false;
        }
        if(this.expedited != workSpec0.expedited) {
            return false;
        }
        if(this.outOfQuotaPolicy != workSpec0.outOfQuotaPolicy) {
            return false;
        }
        return this.periodCount == workSpec0.periodCount ? this.generation == workSpec0.generation : false;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final boolean hasConstraints() {
        return !Intrinsics.areEqual(Constraints.NONE, this.constraints);
    }

    @Override
    public int hashCode() {
        int v = ((((((((((this.id.hashCode() * 0x1F + this.state.hashCode()) * 0x1F + this.workerClassName.hashCode()) * 0x1F + (this.inputMergerClassName == null ? 0 : this.inputMergerClassName.hashCode())) * 0x1F + this.input.hashCode()) * 0x1F + this.output.hashCode()) * 0x1F + WorkSpec..ExternalSyntheticBackport0.m(this.initialDelay)) * 0x1F + WorkSpec..ExternalSyntheticBackport0.m(this.intervalDuration)) * 0x1F + WorkSpec..ExternalSyntheticBackport0.m(this.flexDuration)) * 0x1F + this.constraints.hashCode()) * 0x1F + this.runAttemptCount) * 0x1F;
        int v1 = this.backoffPolicy.hashCode();
        int v2 = WorkSpec..ExternalSyntheticBackport0.m(this.backoffDelayDuration);
        int v3 = WorkSpec..ExternalSyntheticBackport0.m(this.lastEnqueueTime);
        int v4 = WorkSpec..ExternalSyntheticBackport0.m(this.minimumRetentionDuration);
        int v5 = WorkSpec..ExternalSyntheticBackport0.m(this.scheduleRequestedAt);
        int v6 = this.expedited;
        if(v6) {
            v6 = 1;
        }
        return ((((((((v + v1) * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + this.outOfQuotaPolicy.hashCode()) * 0x1F + this.periodCount) * 0x1F + this.generation;
    }

    public final boolean isBackedOff() {
        return this.state == State.ENQUEUED && this.runAttemptCount > 0;
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0L;
    }

    public final void setBackoffDelayDuration(long v) {
        if(v > 18000000L) {
            Logger.get().warning("WM-WorkSpec", "Backoff delay duration exceeds maximum value");
        }
        if(v < 10000L) {
            Logger.get().warning("WM-WorkSpec", "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = RangesKt.coerceIn(v, 10000L, 18000000L);
    }

    public final void setPeriodCount(int v) {
        this.periodCount = v;
    }

    public final void setPeriodic(long v) {
        if(v < 900000L) {
            Logger.get().warning("WM-WorkSpec", "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.setPeriodic(RangesKt.coerceAtLeast(v, 900000L), RangesKt.coerceAtLeast(v, 900000L));
    }

    public final void setPeriodic(long v, long v1) {
        if(v < 900000L) {
            Logger.get().warning("WM-WorkSpec", "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = RangesKt.coerceAtLeast(v, 900000L);
        if(v1 < 300000L) {
            Logger.get().warning("WM-WorkSpec", "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if(v1 > this.intervalDuration) {
            Logger.get().warning("WM-WorkSpec", "Flex duration greater than interval duration; Changed to " + v);
        }
        this.flexDuration = RangesKt.coerceIn(v1, 300000L, this.intervalDuration);
    }

    @Override
    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }
}

