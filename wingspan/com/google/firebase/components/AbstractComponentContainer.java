package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

abstract class AbstractComponentContainer implements ComponentContainer {
    @Override  // com.google.firebase.components.ComponentContainer
    public Object get(Class class0) {
        Provider provider0 = this.getProvider(class0);
        return provider0 == null ? null : provider0.get();
    }

    @Override  // com.google.firebase.components.ComponentContainer
    public Set setOf(Class class0) {
        return (Set)this.setOfProvider(class0).get();
    }
}

