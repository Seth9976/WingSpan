package androidx.core.app;

import androidx.core.util.Consumer;

public interface OnPictureInPictureModeChangedProvider {
    void addOnPictureInPictureModeChangedListener(Consumer arg1);

    void removeOnPictureInPictureModeChangedListener(Consumer arg1);
}

