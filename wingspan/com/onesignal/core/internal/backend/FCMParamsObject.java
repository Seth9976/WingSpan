package com.onesignal.core.internal.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/onesignal/core/internal/backend/FCMParamsObject;", "", "projectId", "", "appId", "apiKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "getAppId", "getProjectId", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class FCMParamsObject {
    private final String apiKey;
    private final String appId;
    private final String projectId;

    public FCMParamsObject() {
        this(null, null, null, 7, null);
    }

    public FCMParamsObject(String s, String s1, String s2) {
        this.projectId = s;
        this.appId = s1;
        this.apiKey = s2;
    }

    public FCMParamsObject(String s, String s1, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            s2 = null;
        }
        this(s, s1, s2);
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getProjectId() {
        return this.projectId;
    }
}

