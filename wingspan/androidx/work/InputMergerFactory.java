package androidx.work;

public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(String arg1);

    public final InputMerger createInputMergerWithDefaultFallback(String className) {
        InputMerger inputMerger0 = this.createInputMerger(className);
        return inputMerger0 == null ? InputMerger.fromClassName(className) : inputMerger0;
    }

    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new InputMergerFactory() {
            @Override  // androidx.work.InputMergerFactory
            public InputMerger createInputMerger(String className) {
                return null;
            }
        };
    }
}

