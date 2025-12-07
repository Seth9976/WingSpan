package com.gameanalytics.sdk.errorreporter;

import androidx.core.app.JobIntentService;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;

public abstract class ReportingIntentService extends JobIntentService {
    private ExceptionReporter exceptionReporter;

    protected ExceptionReporter getExceptionReporter() {
        return this.exceptionReporter;
    }

    @Override  // androidx.core.app.JobIntentService
    public void onCreate() {
        if(GAState.useErrorReporting()) {
            this.exceptionReporter = ExceptionReporter.register(this);
        }
        GALogger.d("ReportingIntentService: onCreate");
        super.onCreate();
    }

    @Override  // androidx.core.app.JobIntentService
    public void onDestroy() {
        super.onDestroy();
        GALogger.d("ReportingIntentService: onDestroy");
    }
}

