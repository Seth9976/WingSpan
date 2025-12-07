package com.onesignal.inAppMessages.internal;

import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\u000BB\r\u0012\u0006\u0010\f\u001A\u00020\u0007¢\u0006\u0002\u0010\rJ\u0006\u0010!\u001A\u00020\"J\u000E\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020\u0000J\u0006\u0010%\u001A\u00020\u001BJ\u0006\u0010&\u001A\u00020\nJ\b\u0010\'\u001A\u00020(H\u0016R\u000E\u0010\f\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001A\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001CR\u001E\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001B@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001CR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u0010\"\u0004\b \u0010\u0012¨\u0006*"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats;", "", "displayQuantity", "", "lastDisplayTime", "", "time", "Lcom/onesignal/core/internal/time/ITime;", "(IJLcom/onesignal/core/internal/time/ITime;)V", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lcom/onesignal/core/internal/time/ITime;)V", "_time", "(Lcom/onesignal/core/internal/time/ITime;)V", "displayDelay", "getDisplayDelay", "()J", "setDisplayDelay", "(J)V", "displayLimit", "getDisplayLimit", "()I", "setDisplayLimit", "(I)V", "getDisplayQuantity", "setDisplayQuantity", "isDelayTimeSatisfied", "", "()Z", "<set-?>", "isRedisplayEnabled", "getLastDisplayTime", "setLastDisplayTime", "incrementDisplayQuantity", "", "setDisplayStats", "displayStats", "shouldDisplayAgain", "toJSONObject", "toString", "", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessageRedisplayStats {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats$Companion;", "", "()V", "DISPLAY_DELAY", "", "DISPLAY_LIMIT", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String DISPLAY_DELAY = "delay";
    private static final String DISPLAY_LIMIT = "limit";
    private final ITime _time;
    private long displayDelay;
    private int displayLimit;
    private int displayQuantity;
    private boolean isRedisplayEnabled;
    private long lastDisplayTime;

    static {
        InAppMessageRedisplayStats.Companion = new Companion(null);
    }

    public InAppMessageRedisplayStats(int v, long v1, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iTime0, "time");
        this(iTime0);
        this.displayQuantity = v;
        this.lastDisplayTime = v1;
    }

    public InAppMessageRedisplayStats(ITime iTime0) {
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._time = iTime0;
        this.lastDisplayTime = -1L;
        this.displayLimit = 1;
    }

    public InAppMessageRedisplayStats(JSONObject jSONObject0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(jSONObject0, "json");
        Intrinsics.checkNotNullParameter(iTime0, "time");
        this(iTime0);
        this.isRedisplayEnabled = true;
        Object object0 = jSONObject0.get("limit");
        Object object1 = jSONObject0.get("delay");
        if(object0 instanceof Integer) {
            this.displayLimit = ((Number)object0).intValue();
        }
        if(object1 instanceof Long) {
            this.displayDelay = ((Number)object1).longValue();
            return;
        }
        if(object1 instanceof Integer) {
            this.displayDelay = (long)((Number)object1).intValue();
        }
    }

    public final long getDisplayDelay() {
        return this.displayDelay;
    }

    public final int getDisplayLimit() {
        return this.displayLimit;
    }

    public final int getDisplayQuantity() {
        return this.displayQuantity;
    }

    public final long getLastDisplayTime() {
        return this.lastDisplayTime;
    }

    public final void incrementDisplayQuantity() {
        ++this.displayQuantity;
    }

    public final boolean isDelayTimeSatisfied() {
        if(Long.compare(this.lastDisplayTime, 0L) < 0) {
            return true;
        }
        long v = this._time.getCurrentTimeMillis();
        long v1 = v / 1000L - this.lastDisplayTime;
        Logging.debug$default(("OSInAppMessage lastDisplayTime: " + this.lastDisplayTime + " currentTimeInSeconds: " + v / 1000L + " diffInSeconds: " + v1 + " displayDelay: " + this.displayDelay), null, 2, null);
        return v1 >= this.displayDelay;
    }

    public final boolean isRedisplayEnabled() {
        return this.isRedisplayEnabled;
    }

    public final void setDisplayDelay(long v) {
        this.displayDelay = v;
    }

    public final void setDisplayLimit(int v) {
        this.displayLimit = v;
    }

    public final void setDisplayQuantity(int v) {
        this.displayQuantity = v;
    }

    public final void setDisplayStats(InAppMessageRedisplayStats inAppMessageRedisplayStats0) {
        Intrinsics.checkNotNullParameter(inAppMessageRedisplayStats0, "displayStats");
        this.lastDisplayTime = inAppMessageRedisplayStats0.lastDisplayTime;
        this.displayQuantity = inAppMessageRedisplayStats0.displayQuantity;
    }

    public final void setLastDisplayTime(long v) {
        this.lastDisplayTime = v;
    }

    public final boolean shouldDisplayAgain() {
        boolean z = this.displayQuantity < this.displayLimit;
        Logging.debug$default(("OSInAppMessage shouldDisplayAgain: " + z), null, 2, null);
        return z;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("limit", this.displayLimit);
            jSONObject0.put("delay", this.displayDelay);
        }
        catch(JSONException jSONException0) {
            jSONException0.printStackTrace();
        }
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "OSInAppMessageDisplayStats{lastDisplayTime=" + this.lastDisplayTime + ", displayQuantity=" + this.displayQuantity + ", displayLimit=" + this.displayLimit + ", displayDelay=" + this.displayDelay + '}';
    }
}

