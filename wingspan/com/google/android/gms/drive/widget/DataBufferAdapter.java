package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter extends BaseAdapter {
    private final int fieldId;
    private final int resource;
    private static final GmsLogger zzbz;
    private final Context zzgw;
    private int zzmz;
    private final List zzna;
    private final LayoutInflater zznb;
    private boolean zznc;

    static {
        DataBufferAdapter.zzbz = new GmsLogger("DataBufferAdapter", "");
    }

    public DataBufferAdapter(Context context0, int v) {
        this(context0, v, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context0, int v, int v1) {
        this(context0, v, v1, new ArrayList());
    }

    public DataBufferAdapter(Context context0, int v, int v1, List list0) {
        this.zznc = true;
        this.zzgw = context0;
        this.zzmz = v;
        this.resource = v;
        this.fieldId = v1;
        this.zzna = list0;
        this.zznb = (LayoutInflater)context0.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context0, int v, int v1, DataBuffer[] arr_dataBuffer) {
        this(context0, v, v1, Arrays.asList(arr_dataBuffer));
    }

    public DataBufferAdapter(Context context0, int v, List list0) {
        this(context0, v, 0, list0);
    }

    public DataBufferAdapter(Context context0, int v, DataBuffer[] arr_dataBuffer) {
        this(context0, v, 0, Arrays.asList(arr_dataBuffer));
    }

    public void append(DataBuffer dataBuffer0) {
        this.zzna.add(dataBuffer0);
        if(this.zznc) {
            this.notifyDataSetChanged();
        }
    }

    public void clear() {
        for(Object object0: this.zzna) {
            ((DataBuffer)object0).release();
        }
        this.zzna.clear();
        if(this.zznc) {
            this.notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.zzgw;
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        int v = 0;
        for(Object object0: this.zzna) {
            v += ((DataBuffer)object0).getCount();
        }
        return v;
    }

    @Override  // android.widget.BaseAdapter
    public View getDropDownView(int v, View view0, ViewGroup viewGroup0) {
        return this.zza(v, view0, viewGroup0, this.zzmz);
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) throws CursorIndexOutOfBoundsException {
        int v1 = v;
        for(Object object0: this.zzna) {
            DataBuffer dataBuffer0 = (DataBuffer)object0;
            int v2 = dataBuffer0.getCount();
            if(v2 <= v1) {
                v1 -= v2;
            }
            else {
                try {
                    return dataBuffer0.get(v1);
                }
                catch(CursorIndexOutOfBoundsException unused_ex) {
                    throw new CursorIndexOutOfBoundsException(v, this.getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(v, this.getCount());
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        return this.zza(v, view0, viewGroup0, this.resource);
    }

    @Override  // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zznc = true;
    }

    public void setDropDownViewResource(int v) {
        this.zzmz = v;
    }

    public void setNotifyOnChange(boolean z) {
        this.zznc = z;
    }

    private final View zza(int v, View view0, ViewGroup viewGroup0, int v1) {
        TextView textView0;
        if(view0 == null) {
            view0 = this.zznb.inflate(v1, viewGroup0, false);
        }
        try {
            textView0 = this.fieldId == 0 ? ((TextView)view0) : ((TextView)view0.findViewById(this.fieldId));
        }
        catch(ClassCastException classCastException0) {
            DataBufferAdapter.zzbz.e("DataBufferAdapter", "You must supply a resource ID for a TextView", classCastException0);
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", classCastException0);
        }
        Object object0 = this.getItem(v);
        if(object0 instanceof CharSequence) {
            textView0.setText(((CharSequence)object0));
            return view0;
        }
        textView0.setText(object0.toString());
        return view0;
    }
}

