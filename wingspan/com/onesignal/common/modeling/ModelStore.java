package com.onesignal.common.modeling;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.core.internal.preferences.IPreferencesService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00020\u0006B\u001D\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0002\u0010\u000BJ\u001D\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00020\bH\u0016\u00A2\u0006\u0002\u0010\u001AJ%\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00020\bH\u0016\u00A2\u0006\u0002\u0010\u001DJ)\u0010\u001E\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00020\b2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0002\u00A2\u0006\u0002\u0010\u001FJ\u0010\u0010 \u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\bH\u0016J\u0017\u0010!\u001A\u0004\u0018\u00018\u00002\u0006\u0010\"\u001A\u00020\bH\u0016\u00A2\u0006\u0002\u0010#J\u000E\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\b\u0010&\u001A\u00020\u0017H\u0004J\u0018\u0010\'\u001A\u00020\u00172\u0006\u0010(\u001A\u00020)2\u0006\u0010\u0019\u001A\u00020\bH\u0016J\u0006\u0010*\u001A\u00020\u0017J\u0018\u0010+\u001A\u00020\u00172\u0006\u0010\"\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\bH\u0016J\u001D\u0010,\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00020\bH\u0002\u00A2\u0006\u0002\u0010\u001AJ\u001E\u0010-\u001A\u00020\u00172\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000.2\u0006\u0010\u0019\u001A\u00020\bH\u0016J\u0016\u0010/\u001A\u00020\u00172\f\u00100\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u0016\u00101\u001A\u00020\u00172\f\u00100\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\rX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015\u00A8\u00062"}, d2 = {"Lcom/onesignal/common/modeling/ModelStore;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/common/modeling/IModelStore;", "Lcom/onesignal/common/modeling/IModelChangedHandler;", "name", "", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Ljava/lang/String;Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "changeSubscription", "Lcom/onesignal/common/events/EventProducer;", "hasSubscribers", "", "getHasSubscribers", "()Z", "models", "", "getName", "()Ljava/lang/String;", "add", "", "model", "tag", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "index", "", "(ILcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "addItem", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;Ljava/lang/Integer;)V", "clear", "get", "id", "(Ljava/lang/String;)Lcom/onesignal/common/modeling/Model;", "list", "", "load", "onChanged", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "persist", "remove", "removeItem", "replaceAll", "", "subscribe", "handler", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class ModelStore implements IEventNotifier, IModelChangedHandler, IModelStore {
    private final IPreferencesService _prefs;
    private final EventProducer changeSubscription;
    private final List models;
    private final String name;

    public ModelStore() {
        this(null, null, 3, null);
    }

    public ModelStore(String s, IPreferencesService iPreferencesService0) {
        this.name = s;
        this._prefs = iPreferencesService0;
        this.changeSubscription = new EventProducer();
        this.models = new ArrayList();
    }

    public ModelStore(String s, IPreferencesService iPreferencesService0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            iPreferencesService0 = null;
        }
        this(s, iPreferencesService0);
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public void add(int v, Model model0, String s) {
        Object object0 = null;
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        synchronized(this.models) {
            for(Object object1: this.models) {
                if(Intrinsics.areEqual(((Model)object1).getId(), model0.getId())) {
                    object0 = object1;
                    break;
                }
            }
            if(((Model)object0) != null) {
                this.removeItem(((Model)object0), s);
            }
            this.addItem(model0, s, v);
        }
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public void add(Model model0, String s) {
        Object object0 = null;
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        synchronized(this.models) {
            for(Object object1: this.models) {
                if(Intrinsics.areEqual(((Model)object1).getId(), model0.getId())) {
                    object0 = object1;
                    break;
                }
            }
            if(((Model)object0) != null) {
                this.removeItem(((Model)object0), s);
            }
            ModelStore.addItem$default(this, model0, s, null, 4, null);
        }
    }

    private final void addItem(Model model0, String s, Integer integer0) {
        synchronized(this.models) {
            if(integer0 == null) {
                this.models.add(model0);
            }
            else {
                this.models.add(((int)integer0), model0);
            }
            model0.subscribe(this);
            this.persist();
        }
        Function1 function10 = new Function1(s) {
            final Model $model;
            final String $tag;

            {
                this.$model = model0;
                this.$tag = s;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IModelStoreChangeHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IModelStoreChangeHandler iModelStoreChangeHandler0) {
                Intrinsics.checkNotNullParameter(iModelStoreChangeHandler0, "it");
                iModelStoreChangeHandler0.onModelAdded(this.$model, this.$tag);
            }
        };
        this.changeSubscription.fire(function10);
    }

    static void addItem$default(ModelStore modelStore0, Model model0, String s, Integer integer0, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItem");
        }
        if((v & 4) != 0) {
            integer0 = null;
        }
        modelStore0.addItem(model0, s, integer0);
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public void clear(String s) {
        Intrinsics.checkNotNullParameter(s, "tag");
        List list0 = CollectionsKt.toList(this.models);
        synchronized(this.models) {
            this.models.clear();
            this.persist();
        }
        for(Object object0: list0) {
            ((Model)object0).unsubscribe(this);
            Function1 function10 = new Function1(s) {
                final Model $item;
                final String $tag;

                {
                    this.$item = model0;
                    this.$tag = s;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((IModelStoreChangeHandler)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(IModelStoreChangeHandler iModelStoreChangeHandler0) {
                    Intrinsics.checkNotNullParameter(iModelStoreChangeHandler0, "it");
                    iModelStoreChangeHandler0.onModelRemoved(this.$item, this.$tag);
                }
            };
            this.changeSubscription.fire(function10);
        }
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public Model get(String s) {
        Intrinsics.checkNotNullParameter(s, "id");
        for(Object object0: this.models) {
            if(Intrinsics.areEqual(((Model)object0).getId(), s)) {
                return (Model)object0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.changeSubscription.getHasSubscribers();
    }

    public final String getName() {
        return this.name;
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public Collection list() {
        return this.models;
    }

    protected final void load() {
        synchronized(this.models) {
            if(this.name != null) {
                IPreferencesService iPreferencesService0 = this._prefs;
                if(iPreferencesService0 != null) {
                    JSONArray jSONArray0 = new JSONArray(iPreferencesService0.getString("OneSignal", "MODEL_STORE_" + this.name, "[]"));
                    int v1 = jSONArray0.length();
                    for(int v2 = 0; v2 < v1; ++v2) {
                        Model model0 = this.create(jSONArray0.getJSONObject(v2));
                        if(model0 != null) {
                            this.models.add(model0);
                            model0.subscribe(this);
                        }
                    }
                }
            }
        }
    }

    @Override  // com.onesignal.common.modeling.IModelChangedHandler
    public void onChanged(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
        this.persist();
        Function1 function10 = new Function1(s) {
            final ModelChangedArgs $args;
            final String $tag;

            {
                this.$args = modelChangedArgs0;
                this.$tag = s;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IModelStoreChangeHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IModelStoreChangeHandler iModelStoreChangeHandler0) {
                Intrinsics.checkNotNullParameter(iModelStoreChangeHandler0, "it");
                iModelStoreChangeHandler0.onModelUpdated(this.$args, this.$tag);
            }
        };
        this.changeSubscription.fire(function10);
    }

    public final void persist() {
        synchronized(this.models) {
            if(this.name != null && this._prefs != null) {
                JSONArray jSONArray0 = new JSONArray();
                for(Object object0: this.models) {
                    jSONArray0.put(((Model)object0).toJSON());
                }
                this._prefs.saveString("OneSignal", "MODEL_STORE_" + this.name, jSONArray0.toString());
            }
        }
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public void remove(String s, String s1) {
        Object object0 = null;
        Intrinsics.checkNotNullParameter(s, "id");
        Intrinsics.checkNotNullParameter(s1, "tag");
        synchronized(this.models) {
            for(Object object1: this.models) {
                if(Intrinsics.areEqual(((Model)object1).getId(), s)) {
                    object0 = object1;
                    break;
                }
            }
            if(((Model)object0) == null) {
                return;
            }
            this.removeItem(((Model)object0), s1);
        }
    }

    private final void removeItem(Model model0, String s) {
        synchronized(this.models) {
            this.models.remove(model0);
            model0.unsubscribe(this);
            this.persist();
        }
        Function1 function10 = new Function1(s) {
            final Model $model;
            final String $tag;

            {
                this.$model = model0;
                this.$tag = s;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((IModelStoreChangeHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(IModelStoreChangeHandler iModelStoreChangeHandler0) {
                Intrinsics.checkNotNullParameter(iModelStoreChangeHandler0, "it");
                iModelStoreChangeHandler0.onModelRemoved(this.$model, this.$tag);
            }
        };
        this.changeSubscription.fire(function10);
    }

    @Override  // com.onesignal.common.modeling.IModelStore
    public void replaceAll(List list0, String s) {
        Intrinsics.checkNotNullParameter(list0, "models");
        Intrinsics.checkNotNullParameter(s, "tag");
        synchronized(list0) {
            this.clear(s);
            for(Object object0: list0) {
                this.add(((Model)object0), s);
            }
        }
    }

    public void subscribe(IModelStoreChangeHandler iModelStoreChangeHandler0) {
        Intrinsics.checkNotNullParameter(iModelStoreChangeHandler0, "handler");
        this.changeSubscription.subscribe(iModelStoreChangeHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((IModelStoreChangeHandler)object0));
    }

    public void unsubscribe(IModelStoreChangeHandler iModelStoreChangeHandler0) {
        Intrinsics.checkNotNullParameter(iModelStoreChangeHandler0, "handler");
        this.changeSubscription.unsubscribe(iModelStoreChangeHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((IModelStoreChangeHandler)object0));
    }
}

