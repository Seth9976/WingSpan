package androidx.browser.trusted.sharing;

import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShareTarget {
    @Retention(RetentionPolicy.SOURCE)
    public @interface EncodingType {
    }

    public static final class FileFormField {
        public static final String KEY_ACCEPTED_TYPES = "androidx.browser.trusted.sharing.KEY_ACCEPTED_TYPES";
        public static final String KEY_NAME = "androidx.browser.trusted.sharing.KEY_FILE_NAME";
        public final List acceptedTypes;
        public final String name;

        public FileFormField(String name, List acceptedTypes) {
            this.name = name;
            this.acceptedTypes = Collections.unmodifiableList(acceptedTypes);
        }

        static FileFormField fromBundle(Bundle bundle) {
            if(bundle == null) {
                return null;
            }
            String s = bundle.getString("androidx.browser.trusted.sharing.KEY_FILE_NAME");
            ArrayList arrayList0 = bundle.getStringArrayList("androidx.browser.trusted.sharing.KEY_ACCEPTED_TYPES");
            return s == null || arrayList0 == null ? null : new FileFormField(s, arrayList0);
        }

        Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putString("androidx.browser.trusted.sharing.KEY_FILE_NAME", this.name);
            bundle0.putStringArrayList("androidx.browser.trusted.sharing.KEY_ACCEPTED_TYPES", new ArrayList(this.acceptedTypes));
            return bundle0;
        }
    }

    public static class Params {
        public static final String KEY_FILES = "androidx.browser.trusted.sharing.KEY_FILES";
        public static final String KEY_TEXT = "androidx.browser.trusted.sharing.KEY_TEXT";
        public static final String KEY_TITLE = "androidx.browser.trusted.sharing.KEY_TITLE";
        public final List files;
        public final String text;
        public final String title;

        public Params(String title, String text, List files) {
            this.title = title;
            this.text = text;
            this.files = files;
        }

        static Params fromBundle(Bundle bundle) {
            ArrayList arrayList0 = null;
            if(bundle == null) {
                return null;
            }
            ArrayList arrayList1 = bundle.getParcelableArrayList("androidx.browser.trusted.sharing.KEY_FILES");
            if(arrayList1 != null) {
                arrayList0 = new ArrayList();
                for(Object object0: arrayList1) {
                    arrayList0.add(FileFormField.fromBundle(((Bundle)object0)));
                }
            }
            return new Params(bundle.getString("androidx.browser.trusted.sharing.KEY_TITLE"), bundle.getString("androidx.browser.trusted.sharing.KEY_TEXT"), arrayList0);
        }

        Bundle toBundle() {
            Bundle bundle0 = new Bundle();
            bundle0.putString("androidx.browser.trusted.sharing.KEY_TITLE", this.title);
            bundle0.putString("androidx.browser.trusted.sharing.KEY_TEXT", this.text);
            if(this.files != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: this.files) {
                    arrayList0.add(((FileFormField)object0).toBundle());
                }
                bundle0.putParcelableArrayList("androidx.browser.trusted.sharing.KEY_FILES", arrayList0);
            }
            return bundle0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestMethod {
    }

    public static final String ENCODING_TYPE_MULTIPART = "multipart/form-data";
    public static final String ENCODING_TYPE_URL_ENCODED = "application/x-www-form-urlencoded";
    public static final String KEY_ACTION = "androidx.browser.trusted.sharing.KEY_ACTION";
    public static final String KEY_ENCTYPE = "androidx.browser.trusted.sharing.KEY_ENCTYPE";
    public static final String KEY_METHOD = "androidx.browser.trusted.sharing.KEY_METHOD";
    public static final String KEY_PARAMS = "androidx.browser.trusted.sharing.KEY_PARAMS";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public final String action;
    public final String encodingType;
    public final String method;
    public final Params params;

    public ShareTarget(String action, String method, String encodingType, Params params) {
        this.action = action;
        this.method = method;
        this.encodingType = encodingType;
        this.params = params;
    }

    public static ShareTarget fromBundle(Bundle bundle) {
        String s = bundle.getString("androidx.browser.trusted.sharing.KEY_ACTION");
        String s1 = bundle.getString("androidx.browser.trusted.sharing.KEY_METHOD");
        String s2 = bundle.getString("androidx.browser.trusted.sharing.KEY_ENCTYPE");
        Params shareTarget$Params0 = Params.fromBundle(bundle.getBundle("androidx.browser.trusted.sharing.KEY_PARAMS"));
        return s == null || shareTarget$Params0 == null ? null : new ShareTarget(s, s1, s2, shareTarget$Params0);
    }

    public Bundle toBundle() {
        Bundle bundle0 = new Bundle();
        bundle0.putString("androidx.browser.trusted.sharing.KEY_ACTION", this.action);
        bundle0.putString("androidx.browser.trusted.sharing.KEY_METHOD", this.method);
        bundle0.putString("androidx.browser.trusted.sharing.KEY_ENCTYPE", this.encodingType);
        bundle0.putBundle("androidx.browser.trusted.sharing.KEY_PARAMS", this.params.toBundle());
        return bundle0;
    }
}

