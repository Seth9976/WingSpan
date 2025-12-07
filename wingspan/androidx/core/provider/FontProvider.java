package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jeb.synthetic.TWR;

class FontProvider {
    static class Api16Impl {
        static Cursor query(ContentResolver contentResolver0, Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1, Object object0) {
            return contentResolver0.query(uri0, arr_s, s, arr_s1, s1, ((CancellationSignal)object0));
        }
    }

    private static final Comparator sByteArrayComparator;

    static {
        FontProvider.sByteArrayComparator = (byte[] arr_b, byte[] arr_b1) -> {
            if(arr_b.length != arr_b1.length) {
                return arr_b.length - arr_b1.length;
            }
            for(int v = 0; v < arr_b.length; ++v) {
                int v1 = arr_b[v];
                int v2 = arr_b1[v];
                if(v1 != v2) {
                    return v1 - v2;
                }
            }
            return 0;
        };
    }

    private static List convertToByteArrayList(Signature[] arr_signature) {
        List list0 = new ArrayList();
        for(int v = 0; v < arr_signature.length; ++v) {
            list0.add(arr_signature[v].toByteArray());
        }
        return list0;
    }

    private static boolean equalsByteArrayList(List list0, List list1) {
        if(list0.size() != list1.size()) {
            return false;
        }
        for(int v = 0; v < list0.size(); ++v) {
            if(!Arrays.equals(((byte[])list0.get(v)), ((byte[])list1.get(v)))) {
                return false;
            }
        }
        return true;
    }

    private static List getCertificates(FontRequest fontRequest0, Resources resources0) {
        return fontRequest0.getCertificates() == null ? FontResourcesParserCompat.readCerts(resources0, fontRequest0.getCertificatesArrayResId()) : fontRequest0.getCertificates();
    }

    static FontFamilyResult getFontFamilyResult(Context context0, FontRequest fontRequest0, CancellationSignal cancellationSignal0) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfo0 = FontProvider.getProvider(context0.getPackageManager(), fontRequest0, context0.getResources());
        return providerInfo0 == null ? FontFamilyResult.create(1, null) : FontFamilyResult.create(0, FontProvider.query(context0, fontRequest0, providerInfo0.authority, cancellationSignal0));
    }

    static ProviderInfo getProvider(PackageManager packageManager0, FontRequest fontRequest0, Resources resources0) throws PackageManager.NameNotFoundException {
        String s = fontRequest0.getProviderAuthority();
        ProviderInfo providerInfo0 = packageManager0.resolveContentProvider(s, 0);
        if(providerInfo0 == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + s);
        }
        if(!providerInfo0.packageName.equals(fontRequest0.getProviderPackage())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + s + ", but package was not " + fontRequest0.getProviderPackage());
        }
        List list0 = FontProvider.convertToByteArrayList(packageManager0.getPackageInfo(providerInfo0.packageName, 0x40).signatures);
        Collections.sort(list0, FontProvider.sByteArrayComparator);
        List list1 = FontProvider.getCertificates(fontRequest0, resources0);
        for(int v = 0; v < list1.size(); ++v) {
            ArrayList arrayList0 = new ArrayList(((Collection)list1.get(v)));
            Collections.sort(arrayList0, FontProvider.sByteArrayComparator);
            if(FontProvider.equalsByteArrayList(list0, arrayList0)) {
                return providerInfo0;
            }
        }
        return null;
    }

    // 检测为 Lambda 实现
    static int lambda$static$0(byte[] arr_b, byte[] arr_b1) [...]

    static FontInfo[] query(Context context0, FontRequest fontRequest0, String s, CancellationSignal cancellationSignal0) {
        boolean z;
        int v10;
        Uri uri2;
        int v8;
        ArrayList arrayList0 = new ArrayList();
        Uri uri0 = new Uri.Builder().scheme("content").authority(s).build();
        Uri uri1 = new Uri.Builder().scheme("content").authority(s).appendPath("file").build();
        Cursor cursor0 = null;
        try {
            cursor0 = Api16Impl.query(context0.getContentResolver(), uri0, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest0.getQuery()}, null, cancellationSignal0);
            if(cursor0 != null && cursor0.getCount() > 0) {
                int v = cursor0.getColumnIndex("result_code");
                ArrayList arrayList1 = new ArrayList();
                int v1 = cursor0.getColumnIndex("_id");
                int v2 = cursor0.getColumnIndex("file_id");
                int v3 = cursor0.getColumnIndex("font_ttc_index");
                int v4 = cursor0.getColumnIndex("font_weight");
                int v5 = cursor0.getColumnIndex("font_italic");
                while(cursor0.moveToNext()) {
                    int v6 = v == -1 ? 0 : cursor0.getInt(v);
                    int v7 = v3 == -1 ? 0 : cursor0.getInt(v3);
                    if(v2 == -1) {
                        v8 = v6;
                        uri2 = ContentUris.withAppendedId(uri0, cursor0.getLong(v1));
                    }
                    else {
                        v8 = v6;
                        uri2 = ContentUris.withAppendedId(uri1, cursor0.getLong(v2));
                    }
                    int v9 = v4 == -1 ? 400 : cursor0.getInt(v4);
                    if(v5 == -1 || cursor0.getInt(v5) != 1) {
                        v10 = v8;
                        z = false;
                    }
                    else {
                        v10 = v8;
                        z = true;
                    }
                    arrayList1.add(FontInfo.create(uri2, v7, v9, z, v10));
                }
                arrayList0 = arrayList1;
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        if(cursor0 != null) {
            cursor0.close();
        }
        return (FontInfo[])arrayList0.toArray(new FontInfo[0]);
    }
}

