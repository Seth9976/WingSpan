package kotlinx.coroutines.android;

import android.os.Looper;
import com.unity3d.player.UnityPlayerActivity;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001A\u00020\b2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00010\nH\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016R\u0014\u0010\u0003\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0}, xi = 0x30)
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    @Override  // kotlinx.coroutines.internal.MainDispatcherFactory
    public MainCoroutineDispatcher createDispatcher(List list0) {
        Looper looper0 = Looper.getMainLooper();
        if(looper0 == null) {
            throw new IllegalStateException(UnityPlayerActivity.adjustValue("3A18084103000E0B52021F02110B13470C014E1E02154E0011041B02110F0D0B"));
        }
        return new HandlerContext(HandlerDispatcherKt.asHandler(looper0, true), null, 2, null);
    }

    @Override  // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return 0x3FFFFFFF;
    }

    @Override  // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return UnityPlayerActivity.adjustValue("281F1F411A041411014E3404121E0013061A0B021E4F1D04132813071E4D071C0E0A45190104010800194A061D1C1F1815070F02165F1A151E154E0C08010702154D020F0F4707174E051E040A");
    }
}

