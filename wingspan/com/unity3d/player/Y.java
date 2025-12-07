package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;

class y implements TextView.OnEditorActionListener {
    final z a;

    y(z z0) {
        this.a = z0;
        super();
    }

    @Override  // android.widget.TextView$OnEditorActionListener
    public boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
        if(v == 6) {
            String s = this.a.a();
            this.a.a(s, false);
        }
        return false;
    }
}

