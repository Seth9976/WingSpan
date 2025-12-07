package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;

class x extends RelativeLayout {
    protected Button a;
    protected EditText b;
    protected Context c;
    protected Rect d;
    protected Rect e;

    public x(Context context0, EditText editText0) {
        super(context0);
        this.b = editText0;
        this.c = context0;
        this.d = new Rect(16, 16, 16, 16);
        this.e = new Rect(0, 0, 0, 0);
        this.createUI();
        this.setBackgroundColor(-1);
    }

    protected void createUI() {
        this.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Button button0 = new Button(this.c);
        this.a = button0;
        button0.setId(View.generateViewId());
        this.a.setText(this.c.getResources().getIdentifier("ok", "string", "android"));
        RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout$LayoutParams0.addRule(15);
        relativeLayout$LayoutParams0.addRule(11);
        this.a.setLayoutParams(relativeLayout$LayoutParams0);
        this.a.setBackgroundColor(0);
        this.addView(this.a);
        this.b.setId(View.generateViewId());
        RelativeLayout.LayoutParams relativeLayout$LayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
        relativeLayout$LayoutParams1.addRule(15);
        relativeLayout$LayoutParams1.addRule(0, this.a.getId());
        this.b.setLayoutParams(relativeLayout$LayoutParams1);
        this.addView(this.b);
        this.setPadding(this.d.left, this.d.top, this.d.right, this.d.bottom);
    }

    @Override  // android.view.View
    public void setOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.a.setOnClickListener(view$OnClickListener0);
    }
}

