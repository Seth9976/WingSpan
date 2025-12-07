package com.google.android.gms.games;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

public final class FriendsResolutionRequiredException extends ResolvableApiException {
    private FriendsResolutionRequiredException(Status status0) {
        super(status0);
    }

    public static FriendsResolutionRequiredException zza(Status status0) {
        return new FriendsResolutionRequiredException(status0);
    }
}

