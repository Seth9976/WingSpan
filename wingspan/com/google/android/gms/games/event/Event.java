package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public interface Event extends Parcelable, Freezable {
    String getDescription();

    void getDescription(CharArrayBuffer arg1);

    String getEventId();

    String getFormattedValue();

    void getFormattedValue(CharArrayBuffer arg1);

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    String getName();

    void getName(CharArrayBuffer arg1);

    Player getPlayer();

    long getValue();

    boolean isVisible();
}

