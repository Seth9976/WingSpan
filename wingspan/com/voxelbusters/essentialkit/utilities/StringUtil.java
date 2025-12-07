package com.voxelbusters.essentialkit.utilities;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringUtil {
    public static final Charset CHAR_SET;

    static {
        StringUtil.CHAR_SET = Charset.forName("UTF-8");
    }

    public static String fromBase64EncodedString(String s) {
        if(StringUtil.isNullOrEmpty(s)) {
            return null;
        }
        byte[] arr_b = Base64.decode(s.getBytes(), 0);
        try {
            return new String(arr_b, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            unsupportedEncodingException0.printStackTrace();
            return "";
        }
    }

    public static String getBase64EncodedString(String s) {
        byte[] arr_b = Base64.encode(s.getBytes(), 0);
        try {
            return new String(arr_b, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            unsupportedEncodingException0.printStackTrace();
            return "";
        }
    }

    public static String getFileNameWithoutExtension(String s) {
        int v = s.lastIndexOf(46);
        return v < 0 ? s : s.substring(0, v);
    }

    public static String getNonNull(String s) {
        return s == null ? "" : s;
    }

    // 去混淆评级： 低(20)
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.equals("") || s.equals("null");
    }
}

