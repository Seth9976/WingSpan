package com.onesignal.inAppMessages.internal.display.impl;

import android.content.Context;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0006H\u0016JP\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\bH\u0016J\u0018\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/OSWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "computeScroll", "", "overScrollBy", "", "deltaX", "", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "scrollTo", "x", "y", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OSWebView extends WebView {
    public OSWebView(Context context0) {
        Intrinsics.checkNotNull(context0);
        super(context0);
    }

    @Override  // android.webkit.WebView
    public void computeScroll() {
    }

    @Override  // android.view.View
    public boolean overScrollBy(int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7, boolean z) {
        return false;
    }

    @Override  // android.view.View
    public void scrollTo(int v, int v1) {
    }
}

