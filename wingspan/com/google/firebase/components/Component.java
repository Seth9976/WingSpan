package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Component {
    public static class Builder {
        private final Set dependencies;
        private ComponentFactory factory;
        private int instantiation;
        private String name;
        private final Set providedInterfaces;
        private Set publishedEvents;
        private int type;

        @SafeVarargs
        private Builder(Class class0, Class[] arr_class) {
            this.name = null;
            HashSet hashSet0 = new HashSet();
            this.providedInterfaces = hashSet0;
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            Preconditions.checkNotNull(class0, "Null interface");
            hashSet0.add(class0);
            for(int v = 0; v < arr_class.length; ++v) {
                Preconditions.checkNotNull(arr_class[v], "Null interface");
            }
            Collections.addAll(this.providedInterfaces, arr_class);
        }

        Builder(Class class0, Class[] arr_class, com.google.firebase.components.Component.1 component$10) {
            this(class0, arr_class);
        }

        static Builder access$100(Builder component$Builder0) {
            return component$Builder0.intoSet();
        }

        public Builder add(Dependency dependency0) {
            Preconditions.checkNotNull(dependency0, "Null dependency");
            this.validateInterface(dependency0.getInterface());
            this.dependencies.add(dependency0);
            return this;
        }

        public Builder alwaysEager() {
            return this.setInstantiation(1);
        }

        public Component build() {
            Preconditions.checkState(this.factory != null, "Missing required property: factory.");
            return new Component(this.name, new HashSet(this.providedInterfaces), new HashSet(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents, null);
        }

        public Builder eagerInDefaultApp() {
            return this.setInstantiation(2);
        }

        public Builder factory(ComponentFactory componentFactory0) {
            this.factory = (ComponentFactory)Preconditions.checkNotNull(componentFactory0, "Null factory");
            return this;
        }

        private Builder intoSet() {
            this.type = 1;
            return this;
        }

        public Builder name(String s) {
            this.name = s;
            return this;
        }

        public Builder publishes(Class class0) {
            this.publishedEvents.add(class0);
            return this;
        }

        private Builder setInstantiation(int v) {
            Preconditions.checkState(this.instantiation == 0, "Instantiation type has already been set.");
            this.instantiation = v;
            return this;
        }

        private void validateInterface(Class class0) {
            Preconditions.checkArgument(!this.providedInterfaces.contains(class0), "Components are not allowed to depend on interfaces they themselves provide.");
        }
    }

    private final Set dependencies;
    private final ComponentFactory factory;
    private final int instantiation;
    private final String name;
    private final Set providedInterfaces;
    private final Set publishedEvents;
    private final int type;

    private Component(String s, Set set0, Set set1, int v, int v1, ComponentFactory componentFactory0, Set set2) {
        this.name = s;
        this.providedInterfaces = Collections.unmodifiableSet(set0);
        this.dependencies = Collections.unmodifiableSet(set1);
        this.instantiation = v;
        this.type = v1;
        this.factory = componentFactory0;
        this.publishedEvents = Collections.unmodifiableSet(set2);
    }

    Component(String s, Set set0, Set set1, int v, int v1, ComponentFactory componentFactory0, Set set2, com.google.firebase.components.Component.1 component$10) {
        this(s, set0, set1, v, v1, componentFactory0, set2);
    }

    public static Builder builder(Class class0) {
        return new Builder(class0, new Class[0], null);
    }

    @SafeVarargs
    public static Builder builder(Class class0, Class[] arr_class) {
        return new Builder(class0, arr_class, null);
    }

    public Set getDependencies() {
        return this.dependencies;
    }

    public ComponentFactory getFactory() {
        return this.factory;
    }

    public String getName() {
        return this.name;
    }

    public Set getProvidedInterfaces() {
        return this.providedInterfaces;
    }

    public Set getPublishedEvents() {
        return this.publishedEvents;
    }

    public static Component intoSet(Object object0, Class class0) {
        return Component.intoSetBuilder(class0).factory(new Component..ExternalSyntheticLambda1(object0)).build();
    }

    public static Builder intoSetBuilder(Class class0) {
        return Builder.access$100(Component.builder(class0));
    }

    public boolean isAlwaysEager() {
        return this.instantiation == 1;
    }

    public boolean isEagerInDefaultApp() {
        return this.instantiation == 2;
    }

    public boolean isLazy() {
        return this.instantiation == 0;
    }

    public boolean isValue() {
        return this.type == 0;
    }

    static Object lambda$intoSet$2(Object object0, ComponentContainer componentContainer0) [...] // Inlined contents

    static Object lambda$of$0(Object object0, ComponentContainer componentContainer0) [...] // Inlined contents

    static Object lambda$of$1(Object object0, ComponentContainer componentContainer0) [...] // Inlined contents

    @Deprecated
    public static Component of(Class class0, Object object0) {
        return Component.builder(class0).factory(new Component..ExternalSyntheticLambda2(object0)).build();
    }

    @SafeVarargs
    public static Component of(Object object0, Class class0, Class[] arr_class) {
        return Component.builder(class0, arr_class).factory(new Component..ExternalSyntheticLambda0(object0)).build();
    }

    @Override
    public String toString() {
        return "Component<" + Arrays.toString(this.providedInterfaces.toArray()) + ">{" + this.instantiation + ", type=" + this.type + ", deps=" + Arrays.toString(this.dependencies.toArray()) + "}";
    }

    public Component withFactory(ComponentFactory componentFactory0) {
        return new Component(this.name, this.providedInterfaces, this.dependencies, this.instantiation, this.type, componentFactory0, this.publishedEvents);
    }

    class com.google.firebase.components.Component.1 {
    }

}

