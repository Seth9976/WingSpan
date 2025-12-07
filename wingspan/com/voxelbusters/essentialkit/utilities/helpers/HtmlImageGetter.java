package com.voxelbusters.essentialkit.utilities.helpers;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Html.ImageGetter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlImageGetter implements Html.ImageGetter {
    public final class a extends AsyncTask {
        public URL a;
        public b b;

        public a(String s, b htmlImageGetter$b0) {
            try {
                this.a = new URL(s);
            }
            catch(MalformedURLException malformedURLException0) {
                malformedURLException0.printStackTrace();
            }
            this.b = htmlImageGetter$b0;
        }

        @Override  // android.os.AsyncTask
        public final Object doInBackground(Object[] arr_object) {
            Void[] arr_void = (Void[])arr_object;
            try {
                return Drawable.createFromStream(this.a.openStream(), null);
            }
            catch(IOException iOException0) {
                iOException0.printStackTrace();
                return null;
            }
        }

        @Override  // android.os.AsyncTask
        public final void onPostExecute(Object object0) {
            this.b.a = (Drawable)object0;
        }
    }

    public final class b extends BitmapDrawable {
        public Drawable a;

        public b() {
            super();
        }

        @Override  // android.graphics.drawable.BitmapDrawable
        public final void draw(Canvas canvas0) {
            Drawable drawable0 = this.a;
            if(drawable0 != null) {
                drawable0.draw(canvas0);
            }
        }
    }

    public b urlDrawable;

    @Override  // android.text.Html$ImageGetter
    public Drawable getDrawable(String s) {
        try {
            this.urlDrawable = new b();
            new a(s, this.urlDrawable).execute(new Void[0]);
            return this.urlDrawable;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }
}

