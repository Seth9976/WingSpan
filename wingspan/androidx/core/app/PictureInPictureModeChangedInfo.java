package androidx.core.app;

import android.content.res.Configuration;

public final class PictureInPictureModeChangedInfo {
    private final boolean mIsInPictureInPictureMode;
    private final Configuration mNewConfig;

    public PictureInPictureModeChangedInfo(boolean z) {
        this.mIsInPictureInPictureMode = z;
        this.mNewConfig = null;
    }

    public PictureInPictureModeChangedInfo(boolean z, Configuration configuration0) {
        this.mIsInPictureInPictureMode = z;
        this.mNewConfig = configuration0;
    }

    public Configuration getNewConfig() {
        Configuration configuration0 = this.mNewConfig;
        if(configuration0 == null) {
            throw new IllegalStateException("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
        }
        return configuration0;
    }

    public boolean isInPictureInPictureMode() {
        return this.mIsInPictureInPictureMode;
    }
}

