package kotlinx.coroutines.sync;

import com.unity3d.player.UnityPlayerActivity;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0001H&J\u001D\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000FJ\u0014\u0010\u0010\u001A\u00020\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0001H&J\u0014\u0010\u0011\u001A\u00020\u000E2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0001H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004R(\u0010\u0005\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/sync/Mutex;", "", "isLocked", "", "()Z", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "holdsLock", "owner", "lock", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "unlock", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public interface Mutex {
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.WARNING, message = "Mutex.onLock deprecated without replacement. For additional details please refer to #2794")
        public static void getOnLock$annotations() {
        }

        public static Object lock$default(Mutex mutex0, Object object0, Continuation continuation0, int v, Object object1) {
            if(object1 != null) {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D0D01020C"));
            }
            if((v & 1) != 0) {
                object0 = null;
            }
            return mutex0.lock(object0, continuation0);
        }

        public static boolean tryLock$default(Mutex mutex0, Object object0, int v, Object object1) {
            if(object1 != null) {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D151C182B0A1105"));
            }
            if((v & 1) != 0) {
                object0 = null;
            }
            return mutex0.tryLock(object0);
        }

        public static void unlock$default(Mutex mutex0, Object object0, int v, Object object1) {
            if(object1 != null) {
                throw new UnsupportedOperationException(UnityPlayerActivity.adjustValue("3D051D041C4104041E02034D1607150F45160B160C14021547040009050004001514451C01044D121B11170A001A150941070F47111A07034D150F1300000642500B140002130C1D004A4D14000D080619"));
            }
            if((v & 1) != 0) {
                object0 = null;
            }
            mutex0.unlock(object0);
        }
    }

    SelectClause2 getOnLock();

    boolean holdsLock(Object arg1);

    boolean isLocked();

    Object lock(Object arg1, Continuation arg2);

    boolean tryLock(Object arg1);

    void unlock(Object arg1);
}

