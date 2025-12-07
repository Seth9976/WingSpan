package com.gameanalytics.sdk.http;

public enum EGAHTTPApiResponse {
    NoResponse,
    BadResponse,
    RequestTimeout,
    JsonEncodeFailed,
    JsonDecodeFailed,
    InternalServerError,
    BadRequest,
    Unauthorized,
    UnknownResponseCode,
    Ok,
    Created;

    private static EGAHTTPApiResponse[] $values() [...] // Inlined contents
}

