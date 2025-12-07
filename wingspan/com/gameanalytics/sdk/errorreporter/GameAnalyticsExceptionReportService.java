package com.gameanalytics.sdk.errorreporter;

import android.content.Intent;
import android.util.Log;
import com.gameanalytics.sdk.device.GADevice;
import com.gameanalytics.sdk.events.GAEvents;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import com.gameanalytics.sdk.store.GAStore;

public class GameAnalyticsExceptionReportService extends ReportingIntentService {
    static final String ACTION_SAVE_REPORT;
    static final String EXTRA_GAME_KEY;
    static final String EXTRA_INFO_LOG_ENABLED;
    static final String EXTRA_SECRET_KEY;
    static final String EXTRA_VERBOSE_LOG_ENABLED;
    static final String EXTRA_WRITABLE_PATH;
    private static final String TAG;

    static {
        GameAnalyticsExceptionReportService.ACTION_SAVE_REPORT = GameAnalyticsExceptionReportService.class.getPackage().getName() + ".actionSaveReport";
        GameAnalyticsExceptionReportService.EXTRA_GAME_KEY = GameAnalyticsExceptionReportService.class.getPackage().getName() + ".extraGameKey";
        GameAnalyticsExceptionReportService.EXTRA_SECRET_KEY = GameAnalyticsExceptionReportService.class.getPackage().getName() + ".extraSecretKey";
        GameAnalyticsExceptionReportService.EXTRA_WRITABLE_PATH = GameAnalyticsExceptionReportService.class.getPackage().getName() + ".extraWritablePath";
        GameAnalyticsExceptionReportService.EXTRA_INFO_LOG_ENABLED = GameAnalyticsExceptionReportService.class.getPackage().getName() + ".extraInfoLogEnabled";
        GameAnalyticsExceptionReportService.EXTRA_VERBOSE_LOG_ENABLED = GameAnalyticsExceptionReportService.class.getPackage().getName() + ".extraVerboseLogEnabled";
        GameAnalyticsExceptionReportService.TAG = "GameAnalyticsExceptionReportService";
    }

    @Override  // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        try {
            if(intent.getAction().equals(GameAnalyticsExceptionReportService.ACTION_SAVE_REPORT)) {
                this.saveReport(intent);
            }
        }
        catch(Exception exception0) {
            Log.e(GameAnalyticsExceptionReportService.TAG, "Error while sending an error report: ", exception0);
        }
    }

    private void saveReport(Intent intent) {
        String s = intent.getStringExtra(GameAnalyticsExceptionReportService.EXTRA_GAME_KEY);
        String s1 = intent.getStringExtra(GameAnalyticsExceptionReportService.EXTRA_SECRET_KEY);
        String s2 = intent.getStringExtra(GameAnalyticsExceptionReportService.EXTRA_WRITABLE_PATH);
        boolean z = intent.getBooleanExtra(GameAnalyticsExceptionReportService.EXTRA_INFO_LOG_ENABLED, false);
        boolean z1 = intent.getBooleanExtra(GameAnalyticsExceptionReportService.EXTRA_VERBOSE_LOG_ENABLED, false);
        GALogger.setInfoLog(z);
        GALogger.setAdvancedInfoLog(z1);
        GALogger.ii(("Got request to report error: " + intent.toString()));
        GADevice.setWritableFilePath(s2);
        if(GAStore.ensureDatabase(false)) {
            GAState.setKeys(s, s1);
            GAState.setInitialized(true);
            GAEvents.processEvents("", false);
        }
    }
}

