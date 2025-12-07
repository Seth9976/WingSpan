package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.nearby.connection.Payload.File;
import com.google.android.gms.nearby.connection.Payload.Stream;
import com.google.android.gms.nearby.connection.Payload;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class zzfl {
    static Pair zza(Payload payload0) throws IOException {
        switch(payload0.getType()) {
            case 1: {
                return Pair.create(new zzfj().zzb(payload0.getId()).zzd(payload0.getType()).zzb(payload0.asBytes()).zzr(), null);
            }
            case 2: {
                if(payload0.asFile().asJavaFile() == null) {
                    return Pair.create(new zzfj().zzb(payload0.getId()).zzd(payload0.getType()).zzc(payload0.asFile().asParcelFileDescriptor()).zze(null).zzc(payload0.asFile().getSize()).zzr(), null);
                }
                String s = payload0.asFile().asJavaFile().getAbsolutePath();
                return Pair.create(new zzfj().zzb(payload0.getId()).zzd(payload0.getType()).zzc(payload0.asFile().asParcelFileDescriptor()).zze(s).zzc(payload0.asFile().getSize()).zzr(), null);
            }
            case 3: {
                try {
                    ParcelFileDescriptor[] arr_parcelFileDescriptor = ParcelFileDescriptor.createPipe();
                    ParcelFileDescriptor[] arr_parcelFileDescriptor1 = ParcelFileDescriptor.createPipe();
                    return Pair.create(new zzfj().zzb(payload0.getId()).zzd(payload0.getType()).zzc(arr_parcelFileDescriptor[0]).zzd(arr_parcelFileDescriptor1[0]).zzr(), Pair.create(arr_parcelFileDescriptor[1], arr_parcelFileDescriptor1[1]));
                }
                catch(IOException iOException0) {
                    Log.e("NearbyConnections", String.format("Unable to create PFD pipe for streaming payload %d from client to service.", payload0.getId()), iOException0);
                    throw iOException0;
                }
            }
            default: {
                IllegalArgumentException illegalArgumentException0 = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", payload0.getId(), payload0.getType()));
                Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException0);
                throw illegalArgumentException0;
            }
        }
    }

    static Payload zza(zzfh zzfh0) {
        long v = zzfh0.getId();
        switch(zzfh0.getType()) {
            case 1: {
                return Payload.zza(zzfh0.getBytes(), v);
            }
            case 2: {
                String s = zzfh0.zzp();
                if(s != null) {
                    try {
                        return Payload.zza(File.zza(new java.io.File(s), zzfh0.zzq()), v);
                    }
                    catch(FileNotFoundException fileNotFoundException0) {
                        String s1 = String.valueOf(s);
                        Log.w("NearbyConnections", (s1.length() == 0 ? new String("Failed to create Payload from ParcelablePayload: Java file not found at ") : "Failed to create Payload from ParcelablePayload: Java file not found at " + s1), fileNotFoundException0);
                    }
                }
                return Payload.zza(File.zza(zzfh0.zzo()), v);
            }
            case 3: {
                return Payload.zza(Stream.zzb(zzfh0.zzo()), v);
            }
            default: {
                Log.w("NearbyConnections", String.format("Incoming ParcelablePayload %d has unknown type %d", zzfh0.getId(), zzfh0.getType()));
                return null;
            }
        }
    }
}

