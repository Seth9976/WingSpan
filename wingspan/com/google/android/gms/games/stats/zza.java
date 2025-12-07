package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zza implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        float f = 0.0f;
        float f1 = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        Bundle bundle0 = null;
        while(parcel0.dataPosition() < v) {
            int v4 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v4)) {
                case 1: {
                    f = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                case 2: {
                    f1 = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                case 3: {
                    v1 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 4: {
                    v2 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 5: {
                    v3 = SafeParcelReader.readInt(parcel0, v4);
                    break;
                }
                case 6: {
                    f2 = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                case 7: {
                    f3 = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                case 8: {
                    bundle0 = SafeParcelReader.createBundle(parcel0, v4);
                    break;
                }
                case 9: {
                    f4 = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                case 10: {
                    f5 = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                case 11: {
                    f6 = SafeParcelReader.readFloat(parcel0, v4);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v4);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new PlayerStatsEntity(f, f1, v1, v2, v3, f2, f3, bundle0, f4, f5, f6);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new PlayerStatsEntity[v];
    }

    static void zza(PlayerStatsEntity playerStatsEntity0, Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeFloat(parcel0, 1, playerStatsEntity0.getAverageSessionLength());
        SafeParcelWriter.writeFloat(parcel0, 2, playerStatsEntity0.getChurnProbability());
        SafeParcelWriter.writeInt(parcel0, 3, playerStatsEntity0.getDaysSinceLastPlayed());
        SafeParcelWriter.writeInt(parcel0, 4, playerStatsEntity0.getNumberOfPurchases());
        SafeParcelWriter.writeInt(parcel0, 5, playerStatsEntity0.getNumberOfSessions());
        SafeParcelWriter.writeFloat(parcel0, 6, playerStatsEntity0.getSessionPercentile());
        SafeParcelWriter.writeFloat(parcel0, 7, playerStatsEntity0.getSpendPercentile());
        SafeParcelWriter.writeBundle(parcel0, 8, playerStatsEntity0.zza(), false);
        SafeParcelWriter.writeFloat(parcel0, 9, playerStatsEntity0.getSpendProbability());
        SafeParcelWriter.writeFloat(parcel0, 10, playerStatsEntity0.getHighSpenderProbability());
        SafeParcelWriter.writeFloat(parcel0, 11, playerStatsEntity0.getTotalSpendNext28Days());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

