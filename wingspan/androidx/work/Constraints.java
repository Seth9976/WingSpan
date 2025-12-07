package androidx.work;

import android.net.Uri;
import android.os.Build.VERSION;
import androidx.work.impl.model.WorkSpec..ExternalSyntheticBackport0;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001E2\u00020\u0001:\u0003\u001D\u001E\u001FB\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0000¢\u0006\u0002\u0010\u0003B[\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\u0007\u0012\b\b\u0002\u0010\n\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\f\u0012\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0019\u001A\u00020\u00072\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u0007H\u0007J\b\u0010\u001B\u001A\u00020\u001CH\u0016J\u0006\u0010\t\u001A\u00020\u0007J\u0006\u0010\u0006\u001A\u00020\u0007J\b\u0010\b\u001A\u00020\u0007H\u0007J\u0006\u0010\n\u001A\u00020\u0007R\u0016\u0010\r\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000B\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u001C\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0010\u0010\t\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/work/Constraints;", "", "other", "(Landroidx/work/Constraints;)V", "requiredNetworkType", "Landroidx/work/NetworkType;", "requiresCharging", "", "requiresDeviceIdle", "requiresBatteryNotLow", "requiresStorageNotLow", "contentTriggerUpdateDelayMillis", "", "contentTriggerMaxDelayMillis", "contentUriTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "(Landroidx/work/NetworkType;ZZZZJJLjava/util/Set;)V", "getContentTriggerMaxDelayMillis", "()J", "getContentTriggerUpdateDelayMillis", "getContentUriTriggers", "()Ljava/util/Set;", "getRequiredNetworkType", "()Landroidx/work/NetworkType;", "equals", "hasContentUriTriggers", "hashCode", "", "Builder", "Companion", "ContentUriTrigger", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Constraints {
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000F\b\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\fH\u0007J\u0006\u0010\u0017\u001A\u00020\u0004J\u000E\u0010\u0018\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\nJ\u000E\u0010\u001A\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\u001B\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\fJ\u0010\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\fH\u0007J\u000E\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\fJ\u0010\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020 H\u0007J\u0018\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u00112\u0006\u0010!\u001A\u00020\"H\u0007J\u0010\u0010#\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020 H\u0007J\u0018\u0010#\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u00112\u0006\u0010!\u001A\u00020\"H\u0007R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/work/Constraints$Builder;", "", "()V", "constraints", "Landroidx/work/Constraints;", "(Landroidx/work/Constraints;)V", "contentUriTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "requiredNetworkType", "Landroidx/work/NetworkType;", "requiresBatteryNotLow", "", "requiresCharging", "requiresDeviceIdle", "requiresStorageNotLow", "triggerContentMaxDelay", "", "triggerContentUpdateDelay", "addContentUriTrigger", "uri", "Landroid/net/Uri;", "triggerForDescendants", "build", "setRequiredNetworkType", "networkType", "setRequiresBatteryNotLow", "setRequiresCharging", "setRequiresDeviceIdle", "setRequiresStorageNotLow", "setTriggerContentMaxDelay", "duration", "Ljava/time/Duration;", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "setTriggerContentUpdateDelay", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Builder {
        private Set contentUriTriggers;
        private NetworkType requiredNetworkType;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay;
        private long triggerContentUpdateDelay;

        public Builder() {
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
        }

        public Builder(Constraints constraints0) {
            Intrinsics.checkNotNullParameter(constraints0, "constraints");
            super();
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1L;
            this.triggerContentMaxDelay = -1L;
            this.contentUriTriggers = new LinkedHashSet();
            this.requiresCharging = constraints0.requiresCharging();
            this.requiresDeviceIdle = constraints0.requiresDeviceIdle();
            this.requiredNetworkType = constraints0.getRequiredNetworkType();
            this.requiresBatteryNotLow = constraints0.requiresBatteryNotLow();
            this.requiresStorageNotLow = constraints0.requiresStorageNotLow();
            if(Build.VERSION.SDK_INT >= 24) {
                this.triggerContentUpdateDelay = constraints0.getContentTriggerUpdateDelayMillis();
                this.triggerContentMaxDelay = constraints0.getContentTriggerMaxDelayMillis();
                this.contentUriTriggers = CollectionsKt.toMutableSet(constraints0.getContentUriTriggers());
            }
        }

        public final Builder addContentUriTrigger(Uri uri0, boolean z) {
            Intrinsics.checkNotNullParameter(uri0, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(uri0, z));
            return this;
        }

        public final Constraints build() {
            long v1;
            long v;
            Set set0;
            if(Build.VERSION.SDK_INT >= 24) {
                set0 = CollectionsKt.toSet(this.contentUriTriggers);
                v = this.triggerContentUpdateDelay;
                v1 = this.triggerContentMaxDelay;
            }
            else {
                set0 = SetsKt.emptySet();
                v = -1L;
                v1 = -1L;
            }
            boolean z = this.requiresCharging;
            return this.requiresDeviceIdle ? new Constraints(this.requiredNetworkType, z, true, this.requiresBatteryNotLow, this.requiresStorageNotLow, v, v1, set0) : new Constraints(this.requiredNetworkType, z, false, this.requiresBatteryNotLow, this.requiresStorageNotLow, v, v1, set0);
        }

        public final Builder setRequiredNetworkType(NetworkType networkType0) {
            Intrinsics.checkNotNullParameter(networkType0, "networkType");
            this.requiredNetworkType = networkType0;
            return this;
        }

        public final Builder setRequiresBatteryNotLow(boolean z) {
            this.requiresBatteryNotLow = z;
            return this;
        }

        public final Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        public final Builder setRequiresDeviceIdle(boolean z) {
            this.requiresDeviceIdle = z;
            return this;
        }

        public final Builder setRequiresStorageNotLow(boolean z) {
            this.requiresStorageNotLow = z;
            return this;
        }

        public final Builder setTriggerContentMaxDelay(long v, TimeUnit timeUnit0) {
            Intrinsics.checkNotNullParameter(timeUnit0, "timeUnit");
            this.triggerContentMaxDelay = timeUnit0.toMillis(v);
            return this;
        }

        public final Builder setTriggerContentMaxDelay(Duration duration0) {
            Intrinsics.checkNotNullParameter(duration0, "duration");
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration0);
            return this;
        }

        public final Builder setTriggerContentUpdateDelay(long v, TimeUnit timeUnit0) {
            Intrinsics.checkNotNullParameter(timeUnit0, "timeUnit");
            this.triggerContentUpdateDelay = timeUnit0.toMillis(v);
            return this;
        }

        public final Builder setTriggerContentUpdateDelay(Duration duration0) {
            Intrinsics.checkNotNullParameter(duration0, "duration");
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration0);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/work/Constraints$Companion;", "", "()V", "NONE", "Landroidx/work/Constraints;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001A\u00020\u00052\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001A\u00020\rH\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u000E"}, d2 = {"Landroidx/work/Constraints$ContentUriTrigger;", "", "uri", "Landroid/net/Uri;", "isTriggeredForDescendants", "", "(Landroid/net/Uri;Z)V", "()Z", "getUri", "()Landroid/net/Uri;", "equals", "other", "hashCode", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        private final Uri uri;

        public ContentUriTrigger(Uri uri0, boolean z) {
            Intrinsics.checkNotNullParameter(uri0, "uri");
            super();
            this.uri = uri0;
            this.isTriggeredForDescendants = z;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!Intrinsics.areEqual(this.getClass(), (object0 == null ? null : object0.getClass()))) {
                return false;
            }
            Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            return Intrinsics.areEqual(this.uri, ((ContentUriTrigger)object0).uri) ? this.isTriggeredForDescendants == ((ContentUriTrigger)object0).isTriggeredForDescendants : false;
        }

        public final Uri getUri() {
            return this.uri;
        }

        @Override
        public int hashCode() {
            return this.uri.hashCode() * 0x1F + WorkSpec..ExternalSyntheticBackport0.m(this.isTriggeredForDescendants);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }

    public static final Companion Companion;
    public static final Constraints NONE;
    private final long contentTriggerMaxDelayMillis;
    private final long contentTriggerUpdateDelayMillis;
    private final Set contentUriTriggers;
    private final NetworkType requiredNetworkType;
    private final boolean requiresBatteryNotLow;
    private final boolean requiresCharging;
    private final boolean requiresDeviceIdle;
    private final boolean requiresStorageNotLow;

    static {
        Constraints.Companion = new Companion(null);
        Constraints.NONE = new Constraints(null, false, false, false, false, 0L, 0L, null, 0xFF, null);
    }

    public Constraints() {
        this(null, false, false, false, false, 0L, 0L, null, 0xFF, null);
    }

    public Constraints(Constraints constraints0) {
        Intrinsics.checkNotNullParameter(constraints0, "other");
        this(constraints0.requiredNetworkType, constraints0.requiresCharging, constraints0.requiresDeviceIdle, constraints0.requiresBatteryNotLow, constraints0.requiresStorageNotLow, constraints0.contentTriggerUpdateDelayMillis, constraints0.contentTriggerMaxDelayMillis, constraints0.contentUriTriggers);
    }

    public Constraints(NetworkType networkType0, boolean z, boolean z1, boolean z2, boolean z3, long v, long v1, Set set0) {
        Intrinsics.checkNotNullParameter(networkType0, "requiredNetworkType");
        Intrinsics.checkNotNullParameter(set0, "contentUriTriggers");
        super();
        this.requiredNetworkType = networkType0;
        this.requiresCharging = z;
        this.requiresDeviceIdle = z1;
        this.requiresBatteryNotLow = z2;
        this.requiresStorageNotLow = z3;
        this.contentTriggerUpdateDelayMillis = v;
        this.contentTriggerMaxDelayMillis = v1;
        this.contentUriTriggers = set0;
    }

    public Constraints(NetworkType networkType0, boolean z, boolean z1, boolean z2, boolean z3, long v, long v1, Set set0, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v2 & 1) == 0 ? networkType0 : NetworkType.NOT_REQUIRED), ((v2 & 2) == 0 ? z : false), ((v2 & 4) == 0 ? z1 : false), ((v2 & 8) == 0 ? z2 : false), ((v2 & 16) == 0 ? z3 : false), ((v2 & 0x20) == 0 ? v : -1L), ((v2 & 0x40) == 0 ? v1 : -1L), ((v2 & 0x80) == 0 ? set0 : SetsKt.emptySet()));
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null || !Intrinsics.areEqual(this.getClass(), object0.getClass()) || this.requiresCharging != ((Constraints)object0).requiresCharging) {
            return false;
        }
        if(this.requiresDeviceIdle != ((Constraints)object0).requiresDeviceIdle) {
            return false;
        }
        if(this.requiresBatteryNotLow != ((Constraints)object0).requiresBatteryNotLow) {
            return false;
        }
        if(this.requiresStorageNotLow != ((Constraints)object0).requiresStorageNotLow) {
            return false;
        }
        if(this.contentTriggerUpdateDelayMillis != ((Constraints)object0).contentTriggerUpdateDelayMillis) {
            return false;
        }
        if(this.contentTriggerMaxDelayMillis != ((Constraints)object0).contentTriggerMaxDelayMillis) {
            return false;
        }
        return this.requiredNetworkType == ((Constraints)object0).requiredNetworkType ? Intrinsics.areEqual(this.contentUriTriggers, ((Constraints)object0).contentUriTriggers) : false;
    }

    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    public final Set getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public final boolean hasContentUriTriggers() {
        return !this.contentUriTriggers.isEmpty();
    }

    @Override
    public int hashCode() {
        return ((((((this.requiredNetworkType.hashCode() * 0x1F + this.requiresCharging) * 0x1F + this.requiresDeviceIdle) * 0x1F + this.requiresBatteryNotLow) * 0x1F + this.requiresStorageNotLow) * 0x1F + ((int)(this.contentTriggerUpdateDelayMillis ^ this.contentTriggerUpdateDelayMillis >>> 0x20))) * 0x1F + ((int)(this.contentTriggerMaxDelayMillis ^ this.contentTriggerMaxDelayMillis >>> 0x20))) * 0x1F + this.contentUriTriggers.hashCode();
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }
}

