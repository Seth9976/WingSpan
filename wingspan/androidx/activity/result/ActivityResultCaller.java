package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

public interface ActivityResultCaller {
    ActivityResultLauncher registerForActivityResult(ActivityResultContract arg1, ActivityResultCallback arg2);

    ActivityResultLauncher registerForActivityResult(ActivityResultContract arg1, ActivityResultRegistry arg2, ActivityResultCallback arg3);
}

