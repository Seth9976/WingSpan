package com.voxelbusters.essentialkit.uiviews;

import android.app.Activity;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.app.TimePickerDialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature;
import java.util.Calendar;

public class TimePicker implements IFeature {
    private Activity context;
    private TimePickerDialog dialog;

    public TimePicker(Activity activity0) {
        this.context = activity0;
    }

    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature
    public String getFeatureName() {
        return "Time Picker";
    }

    @RunOnUiThread
    public void setListener(ITimePickerListener iUiViews$ITimePickerListener0) {
        public final class a implements TimePickerDialog.OnTimeSetListener {
            public final ITimePickerListener a;

            public a(ITimePickerListener iUiViews$ITimePickerListener0) {
            }

            @Override  // android.app.TimePickerDialog$OnTimeSetListener
            public final void onTimeSet(android.widget.TimePicker timePicker0, int v, int v1) {
                System.out.println("On Time Set");
                ITimePickerListener iUiViews$ITimePickerListener0 = this.a;
                if(iUiViews$ITimePickerListener0 != null) {
                    iUiViews$ITimePickerListener0.onSuccess(v, v1);
                }
            }
        }


        public final class b implements DialogInterface.OnCancelListener {
            public final ITimePickerListener a;

            public b(ITimePickerListener iUiViews$ITimePickerListener0) {
            }

            @Override  // android.content.DialogInterface$OnCancelListener
            public final void onCancel(DialogInterface dialogInterface0) {
                Logger.debug("Cancelled Time Picker Dialog");
                ITimePickerListener iUiViews$ITimePickerListener0 = this.a;
                if(iUiViews$ITimePickerListener0 != null) {
                    iUiViews$ITimePickerListener0.onCancel();
                }
            }
        }

        Calendar calendar0 = Calendar.getInstance();
        TimePickerDialog timePickerDialog0 = new TimePickerDialog(this.context, new a(iUiViews$ITimePickerListener0), calendar0.get(11), calendar0.get(12), true);
        this.dialog = timePickerDialog0;
        timePickerDialog0.setOnCancelListener(new b(iUiViews$ITimePickerListener0));
    }

    public void setValue(int v, int v1) {
        this.dialog.updateTime(v, v1);
    }

    @RunOnUiThread
    public void show() {
        this.dialog.show();
    }
}

