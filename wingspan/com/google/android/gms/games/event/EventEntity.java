package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzc;

public final class EventEntity extends zzc implements Event {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final Uri zzd;
    private final String zze;
    private final PlayerEntity zzf;
    private final long zzg;
    private final String zzh;
    private final boolean zzi;

    static {
        EventEntity.CREATOR = new zza();
    }

    public EventEntity(Event event0) {
        this.zza = event0.getEventId();
        this.zzb = event0.getName();
        this.zzc = event0.getDescription();
        this.zzd = event0.getIconImageUri();
        this.zze = event0.getIconImageUrl();
        this.zzf = (PlayerEntity)event0.getPlayer().freeze();
        this.zzg = event0.getValue();
        this.zzh = event0.getFormattedValue();
        this.zzi = event0.isVisible();
    }

    EventEntity(String s, String s1, String s2, Uri uri0, String s3, Player player0, long v, String s4, boolean z) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = s2;
        this.zzd = uri0;
        this.zze = s3;
        this.zzf = new PlayerEntity(player0);
        this.zzg = v;
        this.zzh = s4;
        this.zzi = z;
    }

    @Override
    public boolean equals(Object object0) {
        return EventEntity.zzc(this, object0);
    }

    public Event freeze() {
        return this;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return this;
    }

    @Override  // com.google.android.gms.games.event.Event
    public String getDescription() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.games.event.Event
    public void getDescription(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.event.Event
    public String getEventId() {
        return this.zza;
    }

    @Override  // com.google.android.gms.games.event.Event
    public String getFormattedValue() {
        return this.zzh;
    }

    @Override  // com.google.android.gms.games.event.Event
    public void getFormattedValue(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzh, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.event.Event
    public Uri getIconImageUri() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.games.event.Event
    public String getIconImageUrl() {
        return this.zze;
    }

    @Override  // com.google.android.gms.games.event.Event
    public String getName() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.games.event.Event
    public void getName(CharArrayBuffer charArrayBuffer0) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.event.Event
    public Player getPlayer() {
        return this.zzf;
    }

    @Override  // com.google.android.gms.games.event.Event
    public long getValue() {
        return this.zzg;
    }

    @Override
    public int hashCode() {
        return EventEntity.zza(this);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override  // com.google.android.gms.games.event.Event
    public boolean isVisible() {
        return this.zzi;
    }

    @Override
    public String toString() {
        return EventEntity.zzb(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getEventId(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getName(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.getIconImageUri(), v, false);
        SafeParcelWriter.writeString(parcel0, 5, this.getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.getPlayer(), v, false);
        SafeParcelWriter.writeLong(parcel0, 7, this.getValue());
        SafeParcelWriter.writeString(parcel0, 8, this.getFormattedValue(), false);
        SafeParcelWriter.writeBoolean(parcel0, 9, this.isVisible());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    static int zza(Event event0) {
        return Objects.hashCode(new Object[]{event0.getEventId(), event0.getName(), event0.getDescription(), event0.getIconImageUri(), event0.getIconImageUrl(), event0.getPlayer(), event0.getValue(), event0.getFormattedValue(), Boolean.valueOf(event0.isVisible())});
    }

    static String zzb(Event event0) {
        return Objects.toStringHelper(event0).add("Id", event0.getEventId()).add("Name", event0.getName()).add("Description", event0.getDescription()).add("IconImageUri", event0.getIconImageUri()).add("IconImageUrl", event0.getIconImageUrl()).add("Player", event0.getPlayer()).add("Value", event0.getValue()).add("FormattedValue", event0.getFormattedValue()).add("isVisible", Boolean.valueOf(event0.isVisible())).toString();
    }

    // 去混淆评级： 低(36)
    static boolean zzc(Event event0, Object object0) {
        if(!(object0 instanceof Event)) {
            return false;
        }
        return event0 == object0 ? true : Objects.equal(((Event)object0).getEventId(), event0.getEventId()) && Objects.equal(((Event)object0).getName(), event0.getName()) && Objects.equal(((Event)object0).getDescription(), event0.getDescription()) && Objects.equal(((Event)object0).getIconImageUri(), event0.getIconImageUri()) && Objects.equal(((Event)object0).getIconImageUrl(), event0.getIconImageUrl()) && Objects.equal(((Event)object0).getPlayer(), event0.getPlayer()) && Objects.equal(((Event)object0).getValue(), event0.getValue()) && Objects.equal(((Event)object0).getFormattedValue(), event0.getFormattedValue()) && Objects.equal(Boolean.valueOf(((Event)object0).isVisible()), Boolean.valueOf(event0.isVisible()));
    }
}

