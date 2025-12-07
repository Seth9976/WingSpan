package kotlin.time;

import com.unity3d.player.UnityPlayerActivity;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001A\u0010\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BH\u0002\u001A\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\u000BH\u0000\u001A\u0018\u0010\u0010\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\u000BH\u0000\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u001C\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0011"}, d2 = {"durationAssertionsEnabled", "", "getDurationAssertionsEnabled", "()Z", "precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "createFormatForDecimals", "decimals", "", "formatToExactDecimals", "", "value", "", "formatUpToDecimals", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class DurationJvmKt {
    private static final boolean durationAssertionsEnabled;
    private static final ThreadLocal[] precisionFormats;

    static {
        DurationJvmKt.durationAssertionsEnabled = false;
        ThreadLocal[] arr_threadLocal = new ThreadLocal[4];
        for(int v = 0; v < 4; ++v) {
            arr_threadLocal[v] = new ThreadLocal();
        }
        DurationJvmKt.precisionFormats = arr_threadLocal;
    }

    private static final DecimalFormat createFormatForDecimals(int v) {
        DecimalFormat decimalFormat0 = new DecimalFormat(UnityPlayerActivity.adjustValue("5E"));
        if(v > 0) {
            decimalFormat0.setMinimumFractionDigits(v);
        }
        decimalFormat0.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat0;
    }

    public static final String formatToExactDecimals(double f, int v) {
        DecimalFormat decimalFormat1;
        ThreadLocal[] arr_threadLocal = DurationJvmKt.precisionFormats;
        if(v < arr_threadLocal.length) {
            ThreadLocal threadLocal0 = arr_threadLocal[v];
            DecimalFormat decimalFormat0 = threadLocal0.get();
            if(decimalFormat0 == null) {
                decimalFormat0 = DurationJvmKt.createFormatForDecimals(v);
                threadLocal0.set(decimalFormat0);
            }
            else {
                Intrinsics.checkNotNullExpressionValue(decimalFormat0, UnityPlayerActivity.adjustValue("091519494741585F520A150B001B0D134D5B401101120149130D1B1D4A57120B154E"));
            }
            decimalFormat1 = decimalFormat0;
        }
        else {
            decimalFormat1 = DurationJvmKt.createFormatForDecimals(v);
        }
        String s = decimalFormat1.format(f);
        Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("081F1F0C0F1549031D1C1D0C1546170609070B59"));
        return s;
    }

    public static final String formatUpToDecimals(double f, int v) {
        DecimalFormat decimalFormat0 = DurationJvmKt.createFormatForDecimals(0);
        decimalFormat0.setMaximumFractionDigits(v);
        String s = decimalFormat0.format(f);
        Intrinsics.checkNotNullExpressionValue(s, UnityPlayerActivity.adjustValue("0D0208001A04210A00031119270113230011071D0C0D1D4985E5D44E0D67414E414745524E50430701130A040646060C0D1B044E"));
        return s;
    }

    public static final boolean getDurationAssertionsEnabled() [...] // 潜在的解密器
}

