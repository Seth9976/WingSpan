package androidx.work;

import java.util.List;

public abstract class InputMerger {
    private static final String TAG;

    static {
        InputMerger.TAG = "WM-InputMerger";
    }

    public static InputMerger fromClassName(String className) {
        try {
            return (InputMerger)Class.forName(className).getDeclaredConstructor().newInstance();
        }
        catch(Exception exception0) {
            Logger.get().error("WM-InputMerger", "Trouble instantiating + " + className, exception0);
            return null;
        }
    }

    public abstract Data merge(List arg1);
}

