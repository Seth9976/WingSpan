package com.onesignal.notifications;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Deprecated(message = "This is not applicable for Android 12+")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/onesignal/notifications/BackgroundImageLayout;", "", "image", "", "titleTextColor", "bodyTextColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBodyTextColor", "()Ljava/lang/String;", "getImage", "getTitleTextColor", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class BackgroundImageLayout {
    private final String bodyTextColor;
    private final String image;
    private final String titleTextColor;

    public BackgroundImageLayout() {
        this(null, null, null, 7, null);
    }

    public BackgroundImageLayout(String s, String s1, String s2) {
        this.image = s;
        this.titleTextColor = s1;
        this.bodyTextColor = s2;
    }

    public BackgroundImageLayout(String s, String s1, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
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

    public final String getBodyTextColor() {
        return this.bodyTextColor;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitleTextColor() {
        return this.titleTextColor;
    }
}

