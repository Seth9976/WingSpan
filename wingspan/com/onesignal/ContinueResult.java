package com.onesignal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0015\u0010\u0005\u001A\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\fR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/onesignal/ContinueResult;", "R", "", "isSuccess", "", "data", "throwable", "", "(ZLjava/lang/Object;Ljava/lang/Throwable;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "()Z", "getThrowable", "()Ljava/lang/Throwable;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ContinueResult {
    private final Object data;
    private final boolean isSuccess;
    private final Throwable throwable;

    public ContinueResult(boolean z, Object object0, Throwable throwable0) {
        this.isSuccess = z;
        this.data = object0;
        this.throwable = throwable0;
    }

    public final Object getData() {
        return this.data;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}

