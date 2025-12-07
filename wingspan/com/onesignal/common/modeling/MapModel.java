package com.onesignal.common.modeling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010$\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u001D\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0004H\u0016J\u0015\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001EJ\u0016\u0010\u001F\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001A\u00020\u001AH\u0016J\u001D\u0010\"\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010#J\u001E\u0010$\u001A\u00020\u00182\u0014\u0010%\u001A\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0015\u0010\'\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\u0004H\u0016¢\u0006\u0002\u0010 R&\u0010\b\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\n0\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00040\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\fR\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/onesignal/common/modeling/MapModel;", "V", "Lcom/onesignal/common/modeling/Model;", "", "", "parentModel", "parentProperty", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", "key", "containsValue", "value", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "isEmpty", "put", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class MapModel extends Model implements Map, KMutableMap {
    public MapModel() {
        this(null, null, 3, null);
    }

    public MapModel(Model model0, String s) {
        super(model0, s);
    }

    public MapModel(Model model0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            model0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        this(model0, s);
    }

    @Override
    public void clear() {
        for(Object object0: this.getData().keySet()) {
            Model.setOptAnyProperty$default(this, ((String)object0), null, null, false, 12, null);
        }
    }

    @Override
    public final boolean containsKey(Object object0) {
        return object0 instanceof String ? this.containsKey(((String)object0)) : false;
    }

    public boolean containsKey(String s) {
        Intrinsics.checkNotNullParameter(s, "key");
        return this.getData().containsKey(s);
    }

    @Override
    public boolean containsValue(Object object0) {
        return this.getData().containsValue(object0);
    }

    @Override
    public final Set entrySet() {
        return this.getEntries();
    }

    @Override
    public final Object get(Object object0) {
        return object0 instanceof String ? this.get(((String)object0)) : null;
    }

    public Object get(String s) {
        Intrinsics.checkNotNullParameter(s, "key");
        return Model.getOptAnyProperty$default(this, s, null, 2, null);
    }

    public Set getEntries() {
        Iterable iterable0 = this.getData().entrySet();
        Collection collection0 = new ArrayList();
        for(Object object0: iterable0) {
            if(TypeIntrinsics.isMutableMapEntry(object0)) {
                collection0.add(object0);
            }
        }
        return CollectionsKt.toMutableSet(((List)collection0));
    }

    public Set getKeys() {
        return this.getData().keySet();
    }

    public int getSize() {
        return this.getData().size();
    }

    public Collection getValues() {
        Iterable iterable0 = this.getData().values();
        ArrayList arrayList0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable0, 10));
        for(Object object0: iterable0) {
            arrayList0.add(object0);
        }
        return CollectionsKt.toMutableList(arrayList0);
    }

    @Override
    public boolean isEmpty() {
        return this.getData().isEmpty();
    }

    @Override
    public final Set keySet() {
        return this.getKeys();
    }

    @Override
    public Object put(Object object0, Object object1) {
        return this.put(((String)object0), object1);
    }

    public Object put(String s, Object object0) {
        Intrinsics.checkNotNullParameter(s, "key");
        Model.setOptAnyProperty$default(this, s, object0, null, false, 12, null);
        return object0;
    }

    @Override
    public void putAll(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "from");
        for(Object object0: map0.entrySet()) {
            Model.setOptAnyProperty$default(this, ((String)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue(), null, false, 12, null);
        }
    }

    @Override
    public final Object remove(Object object0) {
        return object0 instanceof String ? this.remove(((String)object0)) : null;
    }

    public Object remove(String s) {
        Intrinsics.checkNotNullParameter(s, "key");
        Object object0 = Model.getOptAnyProperty$default(this, s, null, 2, null);
        Model.setOptAnyProperty$default(this, s, null, null, false, 12, null);
        return object0;
    }

    @Override
    public final int size() {
        return this.getSize();
    }

    @Override
    public final Collection values() {
        return this.getValues();
    }
}

