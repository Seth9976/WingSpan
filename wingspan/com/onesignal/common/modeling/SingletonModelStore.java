package com.onesignal.common.modeling;

import com.onesignal.common.events.EventProducer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u001D\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001BJ\u001D\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001BJ\u0018\u0010\u001D\u001A\u00020\u00192\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u001A\u001A\u00020\u0015H\u0016J\u001D\u0010 \u001A\u00020\u00192\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001BJ\u0016\u0010!\u001A\u00020\u00192\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0016\u0010#\u001A\u00020\u00192\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\nH\u0016R\u001A\u0010\b\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/onesignal/common/modeling/SingletonModelStore;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/modeling/ISingletonModelStore;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "store", "Lcom/onesignal/common/modeling/ModelStore;", "(Lcom/onesignal/common/modeling/ModelStore;)V", "changeSubscription", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "hasSubscribers", "", "getHasSubscribers", "()Z", "model", "getModel", "()Lcom/onesignal/common/modeling/Model;", "replaceLock", "", "singletonId", "", "getStore", "()Lcom/onesignal/common/modeling/ModelStore;", "onModelAdded", "", "tag", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "replace", "subscribe", "handler", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class SingletonModelStore implements IModelStoreChangeHandler, ISingletonModelStore {
    private final EventProducer changeSubscription;
    private final Object replaceLock;
    private final String singletonId;
    private final ModelStore store;

    public SingletonModelStore(ModelStore modelStore0) {
        Intrinsics.checkNotNullParameter(modelStore0, "store");
        super();
        this.store = modelStore0;
        this.changeSubscription = new EventProducer();
        this.singletonId = "-singleton-";
        this.replaceLock = new Object();
        modelStore0.subscribe(this);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.changeSubscription.getHasSubscribers();
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStore
    public Model getModel() {
        synchronized(this) {
            Model model0 = this.store.get(this.singletonId);
            if(model0 != null) {
                return model0;
            }
            Model model1 = DefaultImpls.create$default(this.store, null, 1, null);
            if(model1 != null) {
                model1.setId(this.singletonId);
                DefaultImpls.add$default(this.store, model1, null, 2, null);
                return model1;
            }
        }
        throw new Exception("Unable to initialize model from store " + this.store);
    }

    public final ModelStore getStore() {
        return this.store;
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(Model model0, String s) {
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(Model model0, String s) {
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
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
                this.invoke(((ISingletonModelStoreChangeHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ISingletonModelStoreChangeHandler iSingletonModelStoreChangeHandler0) {
                Intrinsics.checkNotNullParameter(iSingletonModelStoreChangeHandler0, "it");
                iSingletonModelStoreChangeHandler0.onModelUpdated(this.$args, this.$tag);
            }
        };
        this.changeSubscription.fire(function10);
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStore
    public void replace(Model model0, String s) {
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        synchronized(this.replaceLock) {
            Model model1 = this.getModel();
            model1.initializeFromModel(this.singletonId, model0);
            this.store.persist();
            Function1 function10 = new Function1(s) {
                final Model $existingModel;
                final String $tag;

                {
                    this.$existingModel = model0;
                    this.$tag = s;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((ISingletonModelStoreChangeHandler)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(ISingletonModelStoreChangeHandler iSingletonModelStoreChangeHandler0) {
                    Intrinsics.checkNotNullParameter(iSingletonModelStoreChangeHandler0, "it");
                    iSingletonModelStoreChangeHandler0.onModelReplaced(this.$existingModel, this.$tag);
                }
            };
            this.changeSubscription.fire(function10);
        }
    }

    public void subscribe(ISingletonModelStoreChangeHandler iSingletonModelStoreChangeHandler0) {
        Intrinsics.checkNotNullParameter(iSingletonModelStoreChangeHandler0, "handler");
        this.changeSubscription.subscribe(iSingletonModelStoreChangeHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((ISingletonModelStoreChangeHandler)object0));
    }

    public void unsubscribe(ISingletonModelStoreChangeHandler iSingletonModelStoreChangeHandler0) {
        Intrinsics.checkNotNullParameter(iSingletonModelStoreChangeHandler0, "handler");
        this.changeSubscription.unsubscribe(iSingletonModelStoreChangeHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((ISingletonModelStoreChangeHandler)object0));
    }
}

