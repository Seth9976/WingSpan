package com.onesignal.debug;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2 = {"Lcom/onesignal/debug/IDebugManager;", "", "alertLevel", "Lcom/onesignal/debug/LogLevel;", "getAlertLevel", "()Lcom/onesignal/debug/LogLevel;", "setAlertLevel", "(Lcom/onesignal/debug/LogLevel;)V", "logLevel", "getLogLevel", "setLogLevel", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IDebugManager {
    LogLevel getAlertLevel();

    LogLevel getLogLevel();

    void setAlertLevel(LogLevel arg1);

    void setLogLevel(LogLevel arg1);
}

