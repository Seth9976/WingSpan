package com.voxelbusters.essentialkit.uiviews;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.DatePickerDialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature;
import java.util.Calendar;
import java.util.Date;

public class DatePicker implements IFeature {
    private Activity context;
    private DatePickerDialog dialog;
    private IDatePickerListener listener;
    private final DialogInterface.OnCancelListener onCancelListener;
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    public DatePicker(Activity activity0) {
        public final class a implements DatePickerDialog.OnDateSetListener {
            public final DatePicker a;

            @Override  // android.app.DatePickerDialog$OnDateSetListener
            public final void onDateSet(android.widget.DatePicker datePicker0, int v, int v1, int v2) {
                System.out.println("On Date Set");
                if(DatePicker.access$000(DatePicker.this) != null) {
                    DatePicker.access$000(DatePicker.this).onSuccess(v, v1, v2);
                }
            }
        }


        public final class b implements DialogInterface.OnCancelListener {
            public final DatePicker a;

            @Override  // android.content.DialogInterface$OnCancelListener
            public final void onCancel(DialogInterface dialogInterface0) {
                Logger.debug("Cancelled Date Picker Dialog");
                if(DatePicker.access$000(DatePicker.this) != null) {
                    DatePicker.access$000(DatePicker.this).onCancel();
                }
            }
        }


        public final class c implements Runnable {
            public final DatePicker a;

            @Override
            public final void run() {
                Calendar calendar0 = Calendar.getInstance();
                DatePickerDialog datePickerDialog0 = new DatePickerDialog(DatePicker.access$200(DatePicker.this), DatePicker.access$300(DatePicker.this), calendar0.get(1), calendar0.get(2), calendar0.get(5));
                DatePicker.access$102(DatePicker.this, datePickerDialog0);
                DatePicker.access$100(DatePicker.this).setOnCancelListener(DatePicker.access$400(DatePicker.this));
            }
        }

        this.context = activity0;
        this.onDateSetListener = new a(this);
        this.onCancelListener = new b(this);
        activity0.runOnUiThread(new c(this));
    }

    public static IDatePickerListener access$000(DatePicker datePicker0) {
        return datePicker0.listener;
    }

    public static DatePickerDialog access$100(DatePicker datePicker0) {
        return datePicker0.dialog;
    }

    public static DatePickerDialog access$102(DatePicker datePicker0, DatePickerDialog datePickerDialog0) {
        datePicker0.dialog = datePickerDialog0;
        return datePickerDialog0;
    }

    public static Activity access$200(DatePicker datePicker0) {
        return datePicker0.context;
    }

    public static DatePickerDialog.OnDateSetListener access$300(DatePicker datePicker0) {
        return datePicker0.onDateSetListener;
    }

    public static DialogInterface.OnCancelListener access$400(DatePicker datePicker0) {
        return datePicker0.onCancelListener;
    }

    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature
    public String getFeatureName() {
        return "Date Picker";
    }

    public void setListener(IDatePickerListener iUiViews$IDatePickerListener0) {
        this.listener = iUiViews$IDatePickerListener0;
    }

    @RunOnUiThread
    public void setMaxValue(Date date0) {
        this.dialog.getDatePicker().setMaxDate(date0.getTime());
    }

    @RunOnUiThread
    public void setMinValue(Date date0) {
        this.dialog.getDatePicker().setMinDate(date0.getTime());
    }

    @RunOnUiThread
    public void setValue(int v, int v1, int v2) {
        this.dialog.getDatePicker().updateDate(v, v1, v2);
    }

    @RunOnUiThread
    public void show() {
        this.dialog.show();
    }
}

