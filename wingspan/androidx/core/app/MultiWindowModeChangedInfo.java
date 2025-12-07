package androidx.core.app;

import android.content.res.Configuration;

public final class MultiWindowModeChangedInfo {
    private final boolean mIsInMultiWindowMode;
    private final Configuration mNewConfig;

    public MultiWindowModeChangedInfo(boolean z) {
        this.mIsInMultiWindowMode = z;
        this.mNewConfig = null;
    }

    public MultiWindowModeChangedInfo(boolean z, Configuration configuration0) {
        this.mIsInMultiWindowMode = z;
        this.mNewConfig = configuration0;
    }

    public Configuration getNewConfig() {
        Configuration configuration0 = this.mNewConfig;
        if(configuration0 == null) {
            throw new IllegalStateException("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
        }
        return configuration0;
    }

    public boolean isInMultiWindowMode() {
        return this.mIsInMultiWindowMode;
    }
}

