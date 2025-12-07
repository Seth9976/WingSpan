package com.onesignal.common.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/onesignal/common/exceptions/BackendException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "statusCode", "", "response", "", "(ILjava/lang/String;)V", "getResponse", "()Ljava/lang/String;", "getStatusCode", "()I", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class BackendException extends Exception {
    private final String response;
    private final int statusCode;

    public BackendException(int v, String s) {
        this.statusCode = v;
        this.response = s;
    }

    public BackendException(int v, String s, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            s = null;
        }
        this(v, s);
    }

    public final String getResponse() {
        return this.response;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}

