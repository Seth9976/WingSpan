package com.onesignal.user.internal.properties;

import com.onesignal.common.modeling.MapModel;
import com.onesignal.common.modeling.Model;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00A2\u0006\u0002\u0010\u0002J\u001A\u00108\u001A\u0004\u0018\u00010\u00012\u0006\u00109\u001A\u00020\u00042\u0006\u0010:\u001A\u00020;H\u0014R$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001A\u0004\u0018\u00010\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00048F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0003\u001A\u0004\u0018\u00010\r8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0003\u001A\u0004\u0018\u00010\u00138F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u0003\u001A\u0004\u0018\u00010\u00198F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER(\u0010\u001F\u001A\u0004\u0018\u00010\u00192\b\u0010\u0003\u001A\u0004\u0018\u00010\u00198F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b \u0010\u001C\"\u0004\b!\u0010\u001ER(\u0010#\u001A\u0004\u0018\u00010\"2\b\u0010\u0003\u001A\u0004\u0018\u00010\"8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R(\u0010)\u001A\u0004\u0018\u00010(2\b\u0010\u0003\u001A\u0004\u0018\u00010(8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u0017\u00101\u001A\b\u0012\u0004\u0012\u00020\u0004028F\u00A2\u0006\u0006\u001A\u0004\b3\u00104R(\u00105\u001A\u0004\u0018\u00010\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00048F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b6\u0010\u0007\"\u0004\b7\u0010\t\u00A8\u0006<"}, d2 = {"Lcom/onesignal/user/internal/properties/PropertiesModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "country", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "language", "getLanguage", "setLanguage", "", "locationAccuracy", "getLocationAccuracy", "()Ljava/lang/Float;", "setLocationAccuracy", "(Ljava/lang/Float;)V", "", "locationBackground", "getLocationBackground", "()Ljava/lang/Boolean;", "setLocationBackground", "(Ljava/lang/Boolean;)V", "", "locationLatitude", "getLocationLatitude", "()Ljava/lang/Double;", "setLocationLatitude", "(Ljava/lang/Double;)V", "locationLongitude", "getLocationLongitude", "setLocationLongitude", "", "locationTimestamp", "getLocationTimestamp", "()Ljava/lang/Long;", "setLocationTimestamp", "(Ljava/lang/Long;)V", "", "locationType", "getLocationType", "()Ljava/lang/Integer;", "setLocationType", "(Ljava/lang/Integer;)V", "onesignalId", "getOnesignalId", "setOnesignalId", "tags", "Lcom/onesignal/common/modeling/MapModel;", "getTags", "()Lcom/onesignal/common/modeling/MapModel;", "timezone", "getTimezone", "setTimezone", "createModelForProperty", "property", "jsonObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PropertiesModel extends Model {
    public PropertiesModel() {
        super(null, null, 3, null);
    }

    @Override  // com.onesignal.common.modeling.Model
    protected Model createModelForProperty(String s, JSONObject jSONObject0) {
        Intrinsics.checkNotNullParameter(s, "property");
        Intrinsics.checkNotNullParameter(jSONObject0, "jsonObject");
        if(Intrinsics.areEqual(s, "tags")) {
            MapModel mapModel0 = new MapModel(this, "tags");
            Iterator iterator0 = jSONObject0.keys();
            Intrinsics.checkNotNullExpressionValue(iterator0, "jsonObject.keys()");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                Intrinsics.checkNotNullExpressionValue(((String)object0), "key");
                String s1 = jSONObject0.getString(((String)object0));
                Intrinsics.checkNotNullExpressionValue(s1, "jsonObject.getString(key)");
                Model.setStringProperty$default(mapModel0, ((String)object0), s1, null, false, 12, null);
            }
            return mapModel0;
        }
        return null;
    }

    public final String getCountry() {
        return this.getStringProperty("country", com.onesignal.user.internal.properties.PropertiesModel.country.2.INSTANCE);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 0x30)
        final class com.onesignal.user.internal.properties.PropertiesModel.country.2 extends Lambda implements Function0 {
            public static final com.onesignal.user.internal.properties.PropertiesModel.country.2 INSTANCE;

            static {
                com.onesignal.user.internal.properties.PropertiesModel.country.2.INSTANCE = new com.onesignal.user.internal.properties.PropertiesModel.country.2();
            }

            com.onesignal.user.internal.properties.PropertiesModel.country.2() {
                super(0);
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return "US";
            }

            public final String invoke() [...] // Inlined contents
        }

    }

    public final String getLanguage() {
        return Model.getOptStringProperty$default(this, "language", null, 2, null);
    }

    public final Float getLocationAccuracy() {
        return Model.getOptFloatProperty$default(this, "locationAccuracy", null, 2, null);
    }

    public final Boolean getLocationBackground() {
        return Model.getOptBooleanProperty$default(this, "locationBackground", null, 2, null);
    }

    public final Double getLocationLatitude() {
        return Model.getOptDoubleProperty$default(this, "locationLatitude", null, 2, null);
    }

    public final Double getLocationLongitude() {
        return Model.getOptDoubleProperty$default(this, "locationLongitude", null, 2, null);
    }

    public final Long getLocationTimestamp() {
        return Model.getOptLongProperty$default(this, "locationTimestamp", null, 2, null);
    }

    public final Integer getLocationType() {
        return Model.getOptIntProperty$default(this, "locationType", null, 2, null);
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", null, 2, null);
    }

    public final MapModel getTags() {
        return this.getMapModelProperty("tags", new Function0() {
            {
                PropertiesModel.this = propertiesModel0;
                super(0);
            }

            public final MapModel invoke() {
                return new MapModel(PropertiesModel.this, "tags");
            }

            @Override  // kotlin.jvm.functions.Function0
            public Object invoke() {
                return this.invoke();
            }
        });
    }

    public final String getTimezone() {
        return Model.getOptStringProperty$default(this, "timezone", null, 2, null);
    }

    public final void setCountry(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "country", s, null, false, 12, null);
    }

    public final void setLanguage(String s) {
        Model.setOptStringProperty$default(this, "language", s, null, false, 12, null);
    }

    public final void setLocationAccuracy(Float float0) {
        Model.setOptFloatProperty$default(this, "locationAccuracy", float0, null, false, 12, null);
    }

    public final void setLocationBackground(Boolean boolean0) {
        Model.setOptBooleanProperty$default(this, "locationBackground", boolean0, null, false, 12, null);
    }

    public final void setLocationLatitude(Double double0) {
        Model.setOptDoubleProperty$default(this, "locationLatitude", double0, null, false, 12, null);
    }

    public final void setLocationLongitude(Double double0) {
        Model.setOptDoubleProperty$default(this, "locationLongitude", double0, null, false, 12, null);
    }

    public final void setLocationTimestamp(Long long0) {
        Model.setOptLongProperty$default(this, "locationTimestamp", long0, null, false, 12, null);
    }

    public final void setLocationType(Integer integer0) {
        Model.setOptIntProperty$default(this, "locationType", integer0, null, false, 12, null);
    }

    public final void setOnesignalId(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        Model.setStringProperty$default(this, "onesignalId", s, null, false, 12, null);
    }

    public final void setTimezone(String s) {
        Model.setOptStringProperty$default(this, "timezone", s, null, false, 12, null);
    }
}

