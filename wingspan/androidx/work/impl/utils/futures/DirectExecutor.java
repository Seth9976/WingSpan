package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

enum DirectExecutor implements Executor {
    INSTANCE;

    private static DirectExecutor[] $values() [...] // Inlined contents

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    @Override
    public String toString() {
        return "DirectExecutor";
    }
}

