package com.onesignal.core.internal.http;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\t\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/onesignal/core/internal/http/HttpResponse;", "", "statusCode", "", "payload", "", "throwable", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "isSuccess", "", "()Z", "getPayload", "()Ljava/lang/String;", "getStatusCode", "()I", "getThrowable", "()Ljava/lang/Throwable;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class HttpResponse {
    private final String payload;
    private final int statusCode;
    private final Throwable throwable;

    public HttpResponse(int v, String s, Throwable throwable0) {
        this.statusCode = v;
        this.payload = s;
        this.throwable = throwable0;
    }

    public HttpResponse(int v, String s, Throwable throwable0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 4) != 0) {
            throwable0 = null;
        }
        this(v, s, throwable0);
    }

    public final String getPayload() {
        return this.payload;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final boolean isSuccess() {
        return this.statusCode == 200 || this.statusCode == 201 || this.statusCode == 202 || this.statusCode == 304;
    }
}

