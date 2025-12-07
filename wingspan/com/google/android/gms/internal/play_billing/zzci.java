package com.google.android.gms.internal.play_billing;

import java.io.IOException;

public final class zzci extends IOException {
    zzci() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzci(String s, Throwable throwable0) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + s, throwable0);
    }

    zzci(Throwable throwable0) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable0);
    }
}

