package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class EventRef extends DataBufferRef implements Event {
    EventRef(DataHolder dataHolder0, int v) {
        super(dataHolder0, v);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object object0) {
        return EventEntity.zzc(this, object0);
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new EventEntity(this);
    }

    @Override  // com.google.android.gms.games.event.Event
    public final String getDescription() {
        return this.getString("description");
    }

    @Override  // com.google.android.gms.games.event.Event
    public final void getDescription(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("description", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.event.Event
    public final String getEventId() {
        return this.getString("external_event_id");
    }

    @Override  // com.google.android.gms.games.event.Event
    public final String getFormattedValue() {
        return this.getString("formatted_value");
    }

    @Override  // com.google.android.gms.games.event.Event
    public final void getFormattedValue(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("formatted_value", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.event.Event
    public final Uri getIconImageUri() {
        return this.parseUri("icon_image_uri");
    }

    @Override  // com.google.android.gms.games.event.Event
    public String getIconImageUrl() {
        return this.getString("icon_image_url");
    }

    @Override  // com.google.android.gms.games.event.Event
    public final String getName() {
        return this.getString("name");
    }

    @Override  // com.google.android.gms.games.event.Event
    public final void getName(CharArrayBuffer charArrayBuffer0) {
        this.copyToBuffer("name", charArrayBuffer0);
    }

    @Override  // com.google.android.gms.games.event.Event
    public final Player getPlayer() {
        return new PlayerRef(this.mDataHolder, this.mDataRow, null);
    }

    @Override  // com.google.android.gms.games.event.Event
    public final long getValue() {
        return this.getLong("value");
    }

    @Override  // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return EventEntity.zza(this);
    }

    @Override  // com.google.android.gms.games.event.Event
    public final boolean isVisible() {
        return this.getBoolean("visibility");
    }

    @Override
    public final String toString() {
        return EventEntity.zzb(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new EventEntity(this).writeToParcel(parcel0, v);
    }
}

