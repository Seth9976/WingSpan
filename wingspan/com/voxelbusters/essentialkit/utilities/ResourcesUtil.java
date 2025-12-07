package com.voxelbusters.essentialkit.utilities;

import android.content.Context;
import java.io.InputStream;

public class ResourcesUtil {
    private static boolean getBoolean(Context context0, int v) {
        String s = context0.getResources().getString(v);
        return s != null && s.equals("true");
    }

    public static boolean getBoolean(Context context0, String s) {
        int v = ResourcesUtil.getResourceId(context0, s, "string");
        String s1 = context0.getResources().getString(v);
        return s1 != null && s1.equals("true");
    }

    public static int getColorResourceId(Context context0, String s) {
        return ResourcesUtil.getResourceId(context0, s, "color");
    }

    public static int getDrawableResourceId(Context context0, String s) {
        return ResourcesUtil.getResourceId(context0, s, "drawable");
    }

    public static int getLayoutIdentifierResourceId(Context context0, String s) {
        return ResourcesUtil.getResourceId(context0, s, "id");
    }

    public static int getLayoutResourceId(Context context0, String s) {
        return ResourcesUtil.getResourceId(context0, s, "layout");
    }

    public static int getResourceId(Context context0, String s, String s1) {
        return context0.getResources().getIdentifier(StringUtil.getFileNameWithoutExtension(s), s1, "com.MonsterCouch.Wingspan");
    }

    public static InputStream getStreamFromAssets(Context context0, String s) {
        return context0.getAssets().open(s);
    }

    private static String getString(Context context0, int v) {
        return context0.getResources().getString(v);
    }

    public static String getString(Context context0, String s) {
        int v = ResourcesUtil.getResourceId(context0, s, "string");
        return context0.getResources().getString(v);
    }

    public static String getStringOpt(Context context0, String s) {
        try {
            return ResourcesUtil.getString(context0, s);
        }
        catch(Exception unused_ex) {
            Logger.warning(("Resource not found : " + s));
            return null;
        }
    }
}

