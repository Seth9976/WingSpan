package kotlinx.coroutines;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001C\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\n\u0010\u0007\u001A\u00060\bj\u0002`\tH\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u0010\u0010\f\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000EH\u0017J\b\u0010\u000F\u001A\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "limitedParallelism", "parallelism", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class Unconfined extends CoroutineDispatcher {
    public static final Unconfined INSTANCE;

    static {
        Unconfined.INSTANCE = new Unconfined();
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext0, Runnable runnable0) {
        YieldContext yieldContext0 = (YieldContext)coroutineContext0.get(YieldContext.Key);
        if(yieldContext0 == null) {
            throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("2A191E110F15040D171C0343340002080B14071E080540050E16020F040E094E07120B111A19020F4E02060B52011E01184E030245071D1509410C1847111A0B5014080B0D0345141B1E0E15070E094B5227164D1801144712000F004D340002080B14071E08054E050E16020F040E090B13470C1C4E0902141C41040A160B5C4D0C0F0A0245011B020841170E1245021C1F1D041C0D1E45160B1C08060F1502451B1D3404121E0013061A201508050B0547041C0A5009081D1106111106500E00020D144B"));
        }
        yieldContext0.dispatcherWasUnconfined = true;
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext0) {
        return false;
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int v) {
        throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("021900081A040335131C11010D0B0D0E161F4E191E41000E1345011B001D0E1C15020152081F1F412A081415131A1305041C1249301C0D1F0307070F0201"));
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return UnityPlayerActivity.adjustValue("2A191E110F15040D171C0343340002080B14071E0805");
    }
}

