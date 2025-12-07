package kotlinx.coroutines.internal;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"checkParallelism", "", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 0x30)
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int v) {
        if(v < 1) {
            throw new IllegalArgumentException((UnityPlayerActivity.adjustValue("2B081D040D150201521E1F1E081A081100521E111F00020D02091B1D1D4D0D0B1702095E4E1218154E06081152") + v).toString());
        }
    }
}

