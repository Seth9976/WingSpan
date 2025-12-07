package android.support.v4.media;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    static {
        try {
            ParceledListSliceAdapterApi21.sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        }
        catch(ClassNotFoundException | NoSuchMethodException classNotFoundException0) {
            classNotFoundException0.printStackTrace();
        }
    }

    static Object newInstance(List list0) {
        try {
            return ParceledListSliceAdapterApi21.sConstructor.newInstance(list0);
        }
        catch(InstantiationException | IllegalAccessException | InvocationTargetException instantiationException0) {
            instantiationException0.printStackTrace();
            return null;
        }
    }
}

