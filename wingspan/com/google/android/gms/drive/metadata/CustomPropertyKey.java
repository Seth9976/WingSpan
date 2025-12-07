package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPropertyKey extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int PRIVATE = 1;
    public static final int PUBLIC;
    private final int visibility;
    private final String zziz;
    private static final Pattern zzja;

    static {
        CustomPropertyKey.CREATOR = new zzc();
        CustomPropertyKey.zzja = Pattern.compile("[\\w.!@$%^&*()/-]+");
    }

    public CustomPropertyKey(String s, int v) {
        Preconditions.checkNotNull(s, "key");
        Preconditions.checkArgument(CustomPropertyKey.zzja.matcher(s).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        Preconditions.checkArgument(v == 0 || v == 1, "visibility must be either PUBLIC or PRIVATE");
        this.zziz = s;
        this.visibility = v;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 == this ? true : object0 != null && object0.getClass() == this.getClass() && ((CustomPropertyKey)object0).getKey().equals(this.zziz) && ((CustomPropertyKey)object0).getVisibility() == this.visibility;
    }

    public static CustomPropertyKey fromJson(JSONObject jSONObject0) throws JSONException {
        return new CustomPropertyKey(jSONObject0.getString("key"), jSONObject0.getInt("visibility"));
    }

    public String getKey() {
        return this.zziz;
    }

    public int getVisibility() {
        return this.visibility;
    }

    @Override
    public int hashCode() {
        return (this.zziz + this.visibility).hashCode();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("key", this.getKey());
        jSONObject0.put("visibility", this.getVisibility());
        return jSONObject0;
    }

    @Override
    public String toString() {
        return "CustomPropertyKey(" + this.zziz + "," + this.visibility + ")";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.zziz, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.visibility);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

