package com.google.android.gms.games;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface CurrentPlayerInfo extends Parcelable, Freezable {
    int getFriendsListVisibilityStatus();
}

