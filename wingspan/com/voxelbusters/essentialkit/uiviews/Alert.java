package com.voxelbusters.essentialkit.uiviews;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View.OnClickListener;
import android.view.View;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature;
import java.util.ArrayList;

public class Alert implements IFeature {
    public final class b {
        public String a;

        public b(String s) {
        }
    }

    private ArrayList buttons;
    private Context context;
    private AlertDialog dialog;
    private IButtonClickListener listener;
    private String message;
    private String title;

    public Alert(Context context0) {
        this.context = context0;
    }

    public static IButtonClickListener access$100(Alert alert0) {
        return alert0.listener;
    }

    public void addButton(String s, boolean z) {
        if(this.buttons == null) {
            this.buttons = new ArrayList();
        }
        this.buttons.add(new b(s));
    }

    @RunOnUiThread
    public void dismiss() {
        if(this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
            this.dialog = null;
        }
    }

    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature
    public String getFeatureName() {
        return "Alert View";
    }

    public String getMessage() {
        return this.message;
    }

    private int getThemeStyle() [...] // Inlined contents

    public String getTitle() {
        return this.title;
    }

    public void setMessage(String s) {
        this.message = s;
    }

    public void setTitle(String s) {
        this.title = s;
    }

    @RunOnUiThread
    public void show(IButtonClickListener iUiViews$IButtonClickListener0) {
        public final class a implements DialogInterface.OnShowListener {
            public final IButtonClickListener a;
            public final Alert b;

            public a(IButtonClickListener iUiViews$IButtonClickListener0) {
                this.a = iUiViews$IButtonClickListener0;
                super();
            }

            @Override  // android.content.DialogInterface$OnShowListener
            public final void onShow(DialogInterface dialogInterface0) {
                public final class com.voxelbusters.essentialkit.uiviews.Alert.a.a implements View.OnClickListener {
                    public final int a;
                    public final a b;

                    public com.voxelbusters.essentialkit.uiviews.Alert.a.a(int v) {
                        this.a = v;
                        super();
                    }

                    @Override  // android.view.View$OnClickListener
                    public final void onClick(View view0) {
                        Logger.debug(("Button Index : " + this.a + "  buttons final : " + (Alert.this.buttons.size() - 1)));
                        IButtonClickListener iUiViews$IButtonClickListener0 = a.this.a;
                        if(iUiViews$IButtonClickListener0 != null) {
                            iUiViews$IButtonClickListener0.onClick(this.a);
                        }
                    }
                }

                if(Alert.this.buttons != null) {
                    for(int v = 0; v < Alert.this.buttons.size(); ++v) {
                        Alert.this.dialog.getButton(-1 - v).setOnClickListener(new com.voxelbusters.essentialkit.uiviews.Alert.a.a(this, v));
                    }
                }
            }
        }

        this.listener = iUiViews$IButtonClickListener0;
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(new ContextThemeWrapper(this.context, 0x1030239));
        alertDialog$Builder0.setTitle(this.title);
        alertDialog$Builder0.setMessage(this.message);
        alertDialog$Builder0.setCancelable(false);
        if(this.buttons != null) {
            for(int v = 0; v < this.buttons.size(); ++v) {
                b alert$b0 = (b)this.buttons.get(v);
                switch(-1 - v) {
                    case -3: {
                        alertDialog$Builder0.setNeutralButton(alert$b0.a, null);
                        break;
                    }
                    case -2: {
                        alertDialog$Builder0.setNegativeButton(alert$b0.a, null);
                        break;
                    }
                    case -1: {
                        alertDialog$Builder0.setPositiveButton(alert$b0.a, null);
                        break;
                    }
                    default: {
                        Logger.error("Only max 3 buttons are allowed");
                    }
                }
            }
        }
        AlertDialog alertDialog0 = alertDialog$Builder0.create();
        this.dialog = alertDialog0;
        alertDialog0.setOnShowListener(new a(this, iUiViews$IButtonClickListener0));
        this.dialog.show();
    }
}

