package net.codestage.actk.androidnative;

public interface CodeHashCallback {
    void OnError(String arg1);

    void OnSuccess(String arg1, String[] arg2, String[] arg3, String arg4);
}

