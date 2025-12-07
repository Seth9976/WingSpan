package com.unity3d.plugin.downloader.e;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Scanner;

public final class c {
    public static void a(URI uRI0, Map map0) {
        String s;
        Scanner scanner0 = new Scanner(uRI0.getRawQuery());
        scanner0.useDelimiter("&");
        try {
            while(true) {
                if(!scanner0.hasNext()) {
                    return;
                }
                String[] arr_s = scanner0.next().split("=");
                switch(arr_s.length) {
                    case 1: {
                        s = null;
                        break;
                    }
                    case 2: {
                        s = URLDecoder.decode(arr_s[1], "UTF-8");
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("query parameter invalid");
                    }
                }
                map0.put(URLDecoder.decode(arr_s[0], "UTF-8"), s);
            }
        }
        catch(UnsupportedEncodingException unused_ex) {
            Log.e("URIQueryDecoder", "UTF-8 Not Recognized as a charset.  Device configuration Error.");
        }
    }
}

