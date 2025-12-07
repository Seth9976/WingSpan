package com.onesignal.user.internal.backend;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000B\u0018\u00002\u00020\u0001B[\u0012\u0018\b\u0002\u0010\u0002\u001A\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000BR\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\rR\u0015\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0016\u0010\u0014R!\u0010\u0002\u001A\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\r¨\u0006\u001A"}, d2 = {"Lcom/onesignal/user/internal/backend/PropertiesObject;", "", "tags", "", "", "language", "timezoneId", "country", "latitude", "", "longitude", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "getCountry", "()Ljava/lang/String;", "hasAtLeastOnePropertySet", "", "getHasAtLeastOnePropertySet", "()Z", "getLanguage", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "getTags", "()Ljava/util/Map;", "getTimezoneId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PropertiesObject {
    private final String country;
    private final String language;
    private final Double latitude;
    private final Double longitude;
    private final Map tags;
    private final String timezoneId;

    public PropertiesObject() {
        this(null, null, null, null, null, null, 0x3F, null);
    }

    public PropertiesObject(Map map0, String s, String s1, String s2, Double double0, Double double1) {
        this.tags = map0;
        this.language = s;
        this.timezoneId = s1;
        this.country = s2;
        this.latitude = double0;
        this.longitude = double1;
    }

    public PropertiesObject(Map map0, String s, String s1, String s2, Double double0, Double double1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v & 1) == 0 ? map0 : null), ((v & 2) == 0 ? s : null), ((v & 4) == 0 ? s1 : null), ((v & 8) == 0 ? s2 : null), ((v & 16) == 0 ? double0 : null), ((v & 0x20) == 0 ? double1 : null));
    }

    public final String getCountry() {
        return this.country;
    }

    public final boolean getHasAtLeastOnePropertySet() {
        return this.tags != null || this.language != null || this.timezoneId != null || this.country != null || this.latitude != null || this.longitude != null;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final Map getTags() {
        return this.tags;
    }

    public final String getTimezoneId() {
        return this.timezoneId;
    }
}

