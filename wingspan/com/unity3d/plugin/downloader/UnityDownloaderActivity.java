package com.unity3d.plugin.downloader;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.unity3d.plugin.downloader.b.b;
import com.unity3d.plugin.downloader.b.d;
import com.unity3d.plugin.downloader.b.i;
import com.unity3d.plugin.downloader.b.m;
import com.unity3d.plugin.downloader.b.n;
import com.unity3d.plugin.downloader.b.o;
import com.unity3d.plugin.downloader.b.p;
import com.unity3d.plugin.downloader.c.j;
import java.io.InputStream;

public class UnityDownloaderActivity extends Activity implements n {
    private ProgressBar a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private View g;
    private View h;
    private Button i;
    private Button j;
    private boolean k;
    private int l;
    private o m;
    private p n;

    private void a(boolean z) {
        this.k = z;
        int v = m.b(this, (z ? "text_button_resume" : "text_button_pause"));
        this.i.setText(v);
    }

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(int v) {
        boolean z3;
        boolean z2;
        boolean z1;
        if(this.l != v) {
            this.l = v;
            this.b.setText(m.a(this, v));
        }
        int v1 = 0;
        boolean z = true;
        switch(v) {
            case 1: 
            case 2: 
            case 3: {
                z1 = false;
                z2 = false;
                z3 = true;
                break;
            }
            case 4: {
                z1 = false;
                z2 = false;
                z3 = false;
                break;
            }
            case 5: {
                this.finish();
                return;
            }
            case 8: 
            case 9: {
                z3 = false;
                z1 = true;
                z2 = true;
                z = false;
                break;
            }
            case 7: 
            case 12: 
            case 14: {
                z1 = false;
                z3 = false;
                z2 = true;
                break;
            }
            case 15: 
            case 16: 
            case 18: 
            case 19: {
                z1 = false;
                z3 = false;
                z2 = true;
                z = false;
                break;
            }
            default: {
                z1 = false;
                z2 = true;
                z3 = true;
                break;
            }
        }
        if(this.g.getVisibility() != (z ? 0 : 8)) {
            this.g.setVisibility((z ? 0 : 8));
        }
        if(!z1) {
            v1 = 8;
        }
        if(this.h.getVisibility() != v1) {
            this.h.setVisibility(v1);
        }
        this.a.setIndeterminate(z3);
        this.a(z2);
    }

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(Messenger messenger0) {
        o o0 = i.a(messenger0);
        this.m = o0;
        o0.a(this.n.a());
    }

    @Override  // com.unity3d.plugin.downloader.b.n
    public final void a(b b0) {
        this.e.setText(this.getString(m.b(this, "kilobytes_per_second"), new Object[]{m.a(b0.d)}));
        this.f.setText(this.getString(m.b(this, "time_remaining"), new Object[]{m.a(b0.c)}));
        this.a.setMax(((int)(b0.a >> 8)));
        this.a.setProgress(((int)(b0.b >> 8)));
        this.d.setText(Long.toString(b0.b * 100L / b0.a) + "%");
        this.c.setText(m.a(b0.b, b0.a));
    }

    @Override  // android.app.Activity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.requestWindowFeature(1);
        try {
            Intent intent0 = new Intent(this, Class.forName(this.getIntent().getStringExtra("unityplayer.Activity")));
            intent0.setFlags(0x10200000);
            intent0.setAction("android.intent.action.MAIN");
            intent0.addCategory("android.intent.category.LAUNCHER");
            if(j.a(this, PendingIntent.getActivity(this, 0, intent0, 0x8000000), UnityDownloaderService.class) != 0) {
                this.n = d.a(this, UnityDownloaderService.class);
                this.setContentView(m.c(this, "main"));
                try {
                    InputStream inputStream0 = this.getAssets().open("bin/Data/splash.png");
                    BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
                    bitmapFactory$Options0.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Bitmap bitmap0 = BitmapFactory.decodeStream(inputStream0, null, bitmapFactory$Options0);
                    inputStream0.close();
                    ((ImageView)this.findViewById(m.d(this, "splashImage"))).setImageBitmap(bitmap0);
                }
                catch(Exception unused_ex) {
                }
                this.a = (ProgressBar)this.findViewById(m.d(this, "progressBar"));
                this.b = (TextView)this.findViewById(m.d(this, "statusText"));
                this.c = (TextView)this.findViewById(m.d(this, "progressAsFraction"));
                this.d = (TextView)this.findViewById(m.d(this, "progressAsPercentage"));
                this.e = (TextView)this.findViewById(m.d(this, "progressAverageSpeed"));
                this.f = (TextView)this.findViewById(m.d(this, "progressTimeRemaining"));
                this.g = this.findViewById(m.d(this, "downloaderDashboard"));
                this.h = this.findViewById(m.d(this, "approveCellular"));
                this.i = (Button)this.findViewById(m.d(this, "pauseButton"));
                this.j = (Button)this.findViewById(m.d(this, "wifiSettingsButton"));
                this.i.setOnClickListener(new a(this));
                this.j.setOnClickListener(new com.unity3d.plugin.downloader.b(this));
                ((Button)this.findViewById(m.d(this, "resumeOverCellular"))).setOnClickListener(new c(this));
                return;
            }
        }
        catch(ClassNotFoundException classNotFoundException0) {
            Log.e("OBB", "Cannot find own package! MAYDAY!");
            classNotFoundException0.printStackTrace();
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            Log.e("OBB", "Cannot find own package! MAYDAY!");
            packageManager$NameNotFoundException0.printStackTrace();
        }
        this.finish();
    }

    @Override  // android.app.Activity
    protected void onResume() {
        p p0 = this.n;
        if(p0 != null) {
            p0.a(this);
        }
        super.onResume();
    }

    @Override  // android.app.Activity
    protected void onStop() {
        p p0 = this.n;
        if(p0 != null) {
            p0.b(this);
        }
        super.onStop();
    }
}

