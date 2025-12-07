package kotlin.io;

import com.unity3d.player.UnityPlayerActivity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u001C\u0010\u0005\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t\u001A!\u0010\n\u001A\u00020\u000B*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\f\u001A\u00020\rH\u0087\b\u001A!\u0010\u000E\u001A\u00020\u000F*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\f\u001A\u00020\rH\u0087\b\u001AB\u0010\u0010\u001A\u00020\u0001*\u00020\u000226\u0010\u0011\u001A2\u0012\u0013\u0012\u00110\u0004\u00A2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r\u00A2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001AJ\u0010\u0010\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001A\u00020\r26\u0010\u0011\u001A2\u0012\u0013\u0012\u00110\u0004\u00A2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\r\u00A2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00010\u0012\u001A7\u0010\u0018\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\t2!\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\u0007\u00A2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001A\u0012\u0004\u0012\u00020\u00010\u0019\u001A\r\u0010\u001B\u001A\u00020\u001C*\u00020\u0002H\u0087\b\u001A\r\u0010\u001D\u001A\u00020\u001E*\u00020\u0002H\u0087\b\u001A\u0017\u0010\u001F\u001A\u00020 *\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\tH\u0087\b\u001A\n\u0010!\u001A\u00020\u0004*\u00020\u0002\u001A\u001A\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00070#*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\t\u001A\u0014\u0010$\u001A\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\t\u001A\u0017\u0010%\u001A\u00020&*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\tH\u0087\b\u001A?\u0010\'\u001A\u0002H(\"\u0004\b\u0000\u0010(*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\t2\u0018\u0010)\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u0002H(0\u0019H\u0086\b\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010+\u001A\u0012\u0010,\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u001C\u0010-\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t\u001A\u0017\u0010.\u001A\u00020/*\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\tH\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u00060"}, d2 = {"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    public static final void appendBytes(File file0, byte[] arr_b) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_b, UnityPlayerActivity.adjustValue("0F021F0017"));
        Closeable closeable0 = new FileOutputStream(file0, true);
        try {
            ((FileOutputStream)closeable0).write(arr_b);
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(closeable0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(closeable0, null);
    }

    public static final void appendText(File file0, String s, Charset charset0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("1A151515"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        byte[] arr_b = s.getBytes(charset0);
        Intrinsics.checkNotNullExpressionValue(arr_b, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B150B042F181A04144D1106111F120B154E"));
        FilesKt.appendBytes(file0, arr_b);
    }

    public static void appendText$default(File file0, String s, Charset charset0, int v, Object object0) {
        if((v & 2) != 0) {
            charset0 = Charsets.UTF_8;
        }
        FilesKt.appendText(file0, s, charset0);
    }

    private static final BufferedReader bufferedReader(File file0, Charset charset0, int v) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        InputStreamReader inputStreamReader0 = new InputStreamReader(new FileInputStream(file0), charset0);
        return inputStreamReader0 instanceof BufferedReader ? ((BufferedReader)inputStreamReader0) : new BufferedReader(inputStreamReader0, v);
    }

    static BufferedReader bufferedReader$default(File file0, Charset charset0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        if((v1 & 2) != 0) {
            v = 0x2000;
        }
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        InputStreamReader inputStreamReader0 = new InputStreamReader(new FileInputStream(file0), charset0);
        return inputStreamReader0 instanceof BufferedReader ? ((BufferedReader)inputStreamReader0) : new BufferedReader(inputStreamReader0, v);
    }

    private static final BufferedWriter bufferedWriter(File file0, Charset charset0, int v) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(new FileOutputStream(file0), charset0);
        return outputStreamWriter0 instanceof BufferedWriter ? ((BufferedWriter)outputStreamWriter0) : new BufferedWriter(outputStreamWriter0, v);
    }

    static BufferedWriter bufferedWriter$default(File file0, Charset charset0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        if((v1 & 2) != 0) {
            v = 0x2000;
        }
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(new FileOutputStream(file0), charset0);
        return outputStreamWriter0 instanceof BufferedWriter ? ((BufferedWriter)outputStreamWriter0) : new BufferedWriter(outputStreamWriter0, v);
    }

    public static final void forEachBlock(File file0, int v, Function2 function20) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(function20, UnityPlayerActivity.adjustValue("0F131908010F"));
        byte[] arr_b = new byte[RangesKt.coerceAtLeast(v, 0x200)];
        Closeable closeable0 = new FileInputStream(file0);
        try {
            int v1;
            while((v1 = ((FileInputStream)closeable0).read(arr_b)) > 0) {
                function20.invoke(arr_b, v1);
            }
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(closeable0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(closeable0, null);
    }

    public static final void forEachBlock(File file0, Function2 function20) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(function20, UnityPlayerActivity.adjustValue("0F131908010F"));
        FilesKt.forEachBlock(file0, 0x1000, function20);
    }

    public static final void forEachLine(File file0, Charset charset0, Function1 function10) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        Intrinsics.checkNotNullParameter(function10, UnityPlayerActivity.adjustValue("0F131908010F"));
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(file0), charset0)), function10);
    }

    public static void forEachLine$default(File file0, Charset charset0, Function1 function10, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        FilesKt.forEachLine(file0, charset0, function10);
    }

    private static final FileInputStream inputStream(File file0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new FileInputStream(file0);
    }

    private static final FileOutputStream outputStream(File file0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new FileOutputStream(file0);
    }

    private static final PrintWriter printWriter(File file0, Charset charset0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(new FileOutputStream(file0), charset0);
        return outputStreamWriter0 instanceof BufferedWriter ? new PrintWriter(((BufferedWriter)outputStreamWriter0)) : new PrintWriter(new BufferedWriter(outputStreamWriter0, 0x2000));
    }

    static PrintWriter printWriter$default(File file0, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(new FileOutputStream(file0), charset0);
        return outputStreamWriter0 instanceof BufferedWriter ? new PrintWriter(((BufferedWriter)outputStreamWriter0)) : new PrintWriter(new BufferedWriter(outputStreamWriter0, 0x2000));
    }

    public static final byte[] readBytes(File file0) {
        int v3;
        int v2;
        int v1;
        byte[] arr_b;
        long v;
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Closeable closeable0 = new FileInputStream(file0);
        try {
            v = file0.length();
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(closeable0, throwable0);
            throw throwable0;
        }
        String s = UnityPlayerActivity.adjustValue("281901044E");
        try {
            if(Long.compare(v, 0x7FFFFFFFL) > 0) {
                throw new OutOfMemoryError(s + file0 + UnityPlayerActivity.adjustValue("4E191E411A0E08451007174D49") + v + UnityPlayerActivity.adjustValue("4E1214150B124E450601500B081A410E0B520315000E1C1849"));
            }
            arr_b = new byte[((int)v)];
            v1 = (int)v;
            v2 = 0;
            while(true) {
            label_9:
                if(v1 <= 0) {
                    goto label_15;
                }
                v3 = ((FileInputStream)closeable0).read(arr_b, v2, v1);
                if(v3 >= 0) {
                    break;
                }
                goto label_15;
            }
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(closeable0, throwable0);
            throw throwable0;
        }
        v1 -= v3;
        v2 += v3;
        goto label_9;
    label_15:
        String s1 = UnityPlayerActivity.adjustValue("0D1F1D1821074F111A07034141000410361B141544");
        try {
            if(v1 > 0) {
                arr_b = Arrays.copyOf(arr_b, v2);
                Intrinsics.checkNotNullExpressionValue(arr_b, s1);
            }
            else {
                int v4 = ((FileInputStream)closeable0).read();
                if(v4 != -1) {
                    ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream0 = new ExposingBufferByteArrayOutputStream(0x2001);
                    exposingBufferByteArrayOutputStream0.write(v4);
                    ByteStreamsKt.copyTo$default(((FileInputStream)closeable0), exposingBufferByteArrayOutputStream0, 0, 2, null);
                    int v5 = exposingBufferByteArrayOutputStream0.size() + ((int)v);
                    if(v5 < 0) {
                        throw new OutOfMemoryError(s + file0 + UnityPlayerActivity.adjustValue("4E191E411A0E08451007174D150141010C064E19034103040A0A00175E"));
                    }
                    byte[] arr_b1 = exposingBufferByteArrayOutputStream0.getBuffer();
                    byte[] arr_b2 = Arrays.copyOf(arr_b, v5);
                    Intrinsics.checkNotNullExpressionValue(arr_b2, s1);
                    arr_b = ArraysKt.copyInto(arr_b1, arr_b2, ((int)v), 0, exposingBufferByteArrayOutputStream0.size());
                }
            }
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(closeable0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(closeable0, null);
        return arr_b;
    }

    public static final List readLines(File file0, Charset charset0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        ArrayList arrayList0 = new ArrayList();
        FilesKt.forEachLine(file0, charset0, new Function1(arrayList0) {
            final ArrayList $result;

            {
                this.$result = arrayList0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((String)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(String s) {
                Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("0704"));
                this.$result.add(s);
            }
        });
        return arrayList0;
    }

    public static List readLines$default(File file0, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        return FilesKt.readLines(file0, charset0);
    }

    public static final String readText(File file0, Charset charset0) {
        String s;
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        Closeable closeable0 = new InputStreamReader(new FileInputStream(file0), charset0);
        try {
            s = TextStreamsKt.readText(((InputStreamReader)closeable0));
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(closeable0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(closeable0, null);
        return s;
    }

    public static String readText$default(File file0, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        return FilesKt.readText(file0, charset0);
    }

    private static final InputStreamReader reader(File file0, Charset charset0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        return new InputStreamReader(new FileInputStream(file0), charset0);
    }

    static InputStreamReader reader$default(File file0, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        return new InputStreamReader(new FileInputStream(file0), charset0);
    }

    public static final Object useLines(File file0, Charset charset0, Function1 function10) {
        Object object0;
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        Intrinsics.checkNotNullParameter(function10, UnityPlayerActivity.adjustValue("0C1C020205"));
        InputStreamReader inputStreamReader0 = new InputStreamReader(new FileInputStream(file0), charset0);
        BufferedReader bufferedReader0 = inputStreamReader0 instanceof BufferedReader ? ((BufferedReader)inputStreamReader0) : new BufferedReader(inputStreamReader0, 0x2000);
        try {
            object0 = function10.invoke(TextStreamsKt.lineSequence(bufferedReader0));
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(bufferedReader0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(bufferedReader0, null);
        return object0;
    }

    public static Object useLines$default(File file0, Charset charset0, Function1 function10, int v, Object object0) {
        Object object1;
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        InputStreamReader inputStreamReader0 = new InputStreamReader(new FileInputStream(file0), charset0);
        BufferedReader bufferedReader0 = inputStreamReader0 instanceof BufferedReader ? ((BufferedReader)inputStreamReader0) : new BufferedReader(inputStreamReader0, 0x2000);
        try {
            object1 = function10.invoke(TextStreamsKt.lineSequence(bufferedReader0));
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(bufferedReader0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(bufferedReader0, null);
        return object1;
    }

    public static final void writeBytes(File file0, byte[] arr_b) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(arr_b, UnityPlayerActivity.adjustValue("0F021F0017"));
        Closeable closeable0 = new FileOutputStream(file0);
        try {
            ((FileOutputStream)closeable0).write(arr_b);
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(closeable0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(closeable0, null);
    }

    public static final void writeText(File file0, String s, Charset charset0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(s, UnityPlayerActivity.adjustValue("1A151515"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        byte[] arr_b = s.getBytes(charset0);
        Intrinsics.checkNotNullExpressionValue(arr_b, UnityPlayerActivity.adjustValue("1A1804124E001445180F060C4F020009025C3D041F0800064E4B150B042F181A04144D1106111F120B154E"));
        FilesKt.writeBytes(file0, arr_b);
    }

    public static void writeText$default(File file0, String s, Charset charset0, int v, Object object0) {
        if((v & 2) != 0) {
            charset0 = Charsets.UTF_8;
        }
        FilesKt.writeText(file0, s, charset0);
    }

    private static final OutputStreamWriter writer(File file0, Charset charset0) {
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        return new OutputStreamWriter(new FileOutputStream(file0), charset0);
    }

    static OutputStreamWriter writer$default(File file0, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Intrinsics.checkNotNullParameter(charset0, UnityPlayerActivity.adjustValue("0D180C131D0413"));
        return new OutputStreamWriter(new FileOutputStream(file0), charset0);
    }
}

