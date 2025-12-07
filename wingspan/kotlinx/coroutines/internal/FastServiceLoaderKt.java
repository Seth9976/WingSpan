package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    static {
        Object object0;
        try {
            object0 = Result.constructor-impl(Class.forName(UnityPlayerActivity.adjustValue("0F1E09130108034B1D1D5E2F14070D03")));
        }
        catch(Throwable throwable0) {
            object0 = Result.constructor-impl(ResultKt.createFailure(throwable0));
        }
        FastServiceLoaderKt.ANDROID_DETECTED = Result.isSuccess-impl(object0);
    }

    public static final boolean getANDROID_DETECTED() [...] // 潜在的解密器
}

