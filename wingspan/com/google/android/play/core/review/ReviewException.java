package com.google.android.play.core.review;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.review.model.zza;
import java.util.Locale;

public class ReviewException extends ApiException {
    public ReviewException(int v) {
        super(new Status(v, String.format(Locale.getDefault(), "Review Error(%d): %s", v, zza.zza(v))));
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}

