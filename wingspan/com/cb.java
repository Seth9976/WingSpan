package com;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class cb {
    public static void a(Context context0) {
        File file1;
        int v3;
        int v2;
        InputStream inputStream0;
        int v1;
        int v;
        AssetManager assetManager0 = context0.getAssets();
        ArrayList arrayList0 = new ArrayList();
        try {
            String[] arr_s = assetManager0.list("");
            if(arr_s == null) {
                return;
            }
            v = 0;
            v1 = 0;
            while(true) {
            label_7:
                if(v >= arr_s.length) {
                    goto label_35;
                }
                String s = arr_s[v];
                if(s.contains(".obb")) {
                    inputStream0 = assetManager0.open(s);
                    File file0 = context0.getObbDir();
                    v2 = 1;
                    if(file0.exists()) {
                        v3 = 0;
                    }
                    else {
                        file0.mkdirs();
                        v3 = 1;
                    }
                    file1 = new File(file0, s);
                    arrayList0.add(file1);
                    if(v3 != 0 || file1.exists() && ((int)file1.length()) == inputStream0.available()) {
                        break;
                    }
                    goto label_22;
                }
                ++v;
            }
        }
        catch(Throwable unused_ex) {
            return;
        }
        v2 = v3;
    label_22:
        if(v2 != 0) {
            try {
                ++v1;
                BufferedInputStream bufferedInputStream0 = new BufferedInputStream(inputStream0);
                FileOutputStream fileOutputStream0 = new FileOutputStream(file1);
                byte[] arr_b = new byte[0x400];
                int v4;
                while((v4 = bufferedInputStream0.read(arr_b)) != -1) {
                    fileOutputStream0.write(arr_b, 0, v4);
                }
                bufferedInputStream0.close();
                fileOutputStream0.close();
            }
            catch(Throwable unused_ex) {
            }
        }
        try {
            ++v;
            goto label_7;
        label_35:
            if(!arrayList0.isEmpty()) {
                File[] arr_file = ((File)arrayList0.get(0)).getParentFile().listFiles();
                for(int v5 = 0; true; ++v5) {
                    if(v5 >= arr_file.length) {
                        return;
                    }
                    File file2 = arr_file[v5];
                    if(!arrayList0.contains(file2)) {
                        file2.delete();
                    }
                }
            }
        }
        catch(Throwable unused_ex) {
        }
    }
}

