package com.google.firebase.installations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    @Override  // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseInstallationsApi.class).name("fire-installations").add(Dependency.required(FirebaseApp.class)).add(Dependency.optionalProvider(HeartBeatController.class)).factory((ComponentContainer componentContainer0) -> new FirebaseInstallations(((FirebaseApp)componentContainer0.get(FirebaseApp.class)), componentContainer0.getProvider(HeartBeatController.class))).build(), HeartBeatConsumerComponent.create(), LibraryVersionComponent.create("fire-installations", "17.1.0")});
    }

    // 检测为 Lambda 实现
    static FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer componentContainer0) [...]
}

