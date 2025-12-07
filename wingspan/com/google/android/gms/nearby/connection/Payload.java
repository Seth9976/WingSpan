package com.google.android.gms.nearby.connection;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class Payload {
    public static class File {
        private final java.io.File zzab;
        private final ParcelFileDescriptor zzac;
        private final long zzad;

        private File(java.io.File file0, ParcelFileDescriptor parcelFileDescriptor0, long v) {
            this.zzab = file0;
            this.zzac = parcelFileDescriptor0;
            this.zzad = v;
        }

        public java.io.File asJavaFile() {
            return this.zzab;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.zzac;
        }

        public long getSize() {
            return this.zzad;
        }

        public static File zza(ParcelFileDescriptor parcelFileDescriptor0) {
            return new File(null, ((ParcelFileDescriptor)Preconditions.checkNotNull(parcelFileDescriptor0, "Cannot create Payload.File from null ParcelFileDescriptor.")), parcelFileDescriptor0.getStatSize());
        }

        public static File zza(java.io.File file0, long v) throws FileNotFoundException {
            return new File(((java.io.File)Preconditions.checkNotNull(file0, "Cannot create Payload.File from null java.io.File.")), ParcelFileDescriptor.open(file0, 0x10000000), v);
        }
    }

    public static class Stream {
        private final ParcelFileDescriptor zzac;
        private InputStream zzae;

        private Stream(ParcelFileDescriptor parcelFileDescriptor0, InputStream inputStream0) {
            this.zzac = parcelFileDescriptor0;
            this.zzae = inputStream0;
        }

        public InputStream asInputStream() {
            if(this.zzae == null) {
                this.zzae = new ParcelFileDescriptor.AutoCloseInputStream(this.zzac);
            }
            return this.zzae;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.zzac;
        }

        public static Stream zza(InputStream inputStream0) {
            Preconditions.checkNotNull(inputStream0, "Cannot create Payload.Stream from null InputStream.");
            return new Stream(null, inputStream0);
        }

        public static Stream zzb(ParcelFileDescriptor parcelFileDescriptor0) {
            Preconditions.checkNotNull(parcelFileDescriptor0, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor0, null);
        }
    }

    public @interface Type {
        public static final int BYTES = 1;
        public static final int FILE = 2;
        public static final int STREAM = 3;

    }

    private final long id;
    private final int type;
    private final Stream zzaa;
    private final byte[] zzy;
    private final File zzz;

    private Payload(long v, int v1, byte[] arr_b, File payload$File0, Stream payload$Stream0) {
        this.id = v;
        this.type = v1;
        this.zzy = arr_b;
        this.zzz = payload$File0;
        this.zzaa = payload$Stream0;
    }

    public byte[] asBytes() {
        return this.zzy;
    }

    public File asFile() {
        return this.zzz;
    }

    public Stream asStream() {
        return this.zzaa;
    }

    public static Payload fromBytes(byte[] arr_b) {
        Preconditions.checkNotNull(arr_b, "Cannot create a Payload from null bytes.");
        return Payload.zza(arr_b, UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(ParcelFileDescriptor parcelFileDescriptor0) {
        return Payload.zza(File.zza(parcelFileDescriptor0), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(java.io.File file0) throws FileNotFoundException {
        return Payload.zza(File.zza(file0, file0.length()), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(ParcelFileDescriptor parcelFileDescriptor0) {
        return Payload.zza(Stream.zzb(parcelFileDescriptor0), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(InputStream inputStream0) {
        return Payload.zza(Stream.zza(inputStream0), UUID.randomUUID().getLeastSignificantBits());
    }

    public long getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public static Payload zza(File payload$File0, long v) {
        return new Payload(v, 2, null, payload$File0, null);
    }

    public static Payload zza(Stream payload$Stream0, long v) {
        return new Payload(v, 3, null, null, payload$Stream0);
    }

    public static Payload zza(byte[] arr_b, long v) {
        return new Payload(v, 1, arr_b, null, null);
    }
}

