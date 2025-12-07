package com.onesignal.common.modeling;

import com.onesignal.common.events.IEventNotifier;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003J\u001F\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00028\u00002\b\b\u0002\u0010\b\u001A\u00020\tH&¢\u0006\u0002\u0010\nJ\'\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00028\u00002\b\b\u0002\u0010\b\u001A\u00020\tH&¢\u0006\u0002\u0010\rJ\u0012\u0010\u000E\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\tH&J\u001B\u0010\u000F\u001A\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001A\u00020\tH&¢\u0006\u0002\u0010\u0015J\u000E\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017H&J\u001A\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\t2\b\b\u0002\u0010\b\u001A\u00020\tH&J \u0010\u0019\u001A\u00020\u00062\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00000\u001B2\b\b\u0002\u0010\b\u001A\u00020\tH&¨\u0006\u001C"}, d2 = {"Lcom/onesignal/common/modeling/IModelStore;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "add", "", "model", "tag", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "index", "", "(ILcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "clear", "create", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/onesignal/common/modeling/Model;", "get", "id", "(Ljava/lang/String;)Lcom/onesignal/common/modeling/Model;", "list", "", "remove", "replaceAll", "models", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IModelStore extends IEventNotifier {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static void add$default(IModelStore iModelStore0, int v, Model model0, String s, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
            }
            if((v1 & 4) != 0) {
                s = "NORMAL";
            }
            iModelStore0.add(v, model0, s);
        }

        public static void add$default(IModelStore iModelStore0, Model model0, String s, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
            }
            if((v & 2) != 0) {
                s = "NORMAL";
            }
            iModelStore0.add(model0, s);
        }

        public static void clear$default(IModelStore iModelStore0, String s, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clear");
            }
            if((v & 1) != 0) {
                s = "NORMAL";
            }
            iModelStore0.clear(s);
        }

        public static Model create$default(IModelStore iModelStore0, JSONObject jSONObject0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
            }
            if((v & 1) != 0) {
                jSONObject0 = null;
            }
            return iModelStore0.create(jSONObject0);
        }

        public static void remove$default(IModelStore iModelStore0, String s, String s1, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: remove");
            }
            if((v & 2) != 0) {
                s1 = "NORMAL";
            }
            iModelStore0.remove(s, s1);
        }

        public static void replaceAll$default(IModelStore iModelStore0, List list0, String s, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceAll");
            }
            if((v & 2) != 0) {
                s = "NORMAL";
            }
            iModelStore0.replaceAll(list0, s);
        }
    }

    void add(int arg1, Model arg2, String arg3);

    void add(Model arg1, String arg2);

    void clear(String arg1);

    Model create(JSONObject arg1);

    Model get(String arg1);

    Collection list();

    void remove(String arg1, String arg2);

    void replaceAll(List arg1, String arg2);
}

