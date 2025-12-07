package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import jeb.synthetic.TWR;
import org.json.JSONArray;
import org.json.JSONObject;

public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    private static final ThreadFactory THREAD_FACTORY;
    private final Context applicationContext;
    private final Executor backgroundExecutor;
    private final Set consumers;
    private final Provider storageProvider;
    private final Provider userAgentProvider;

    static {
        DefaultHeartBeatController.THREAD_FACTORY = (Runnable runnable0) -> new Thread(runnable0, "heartbeat-information-executor");
    }

    private DefaultHeartBeatController(Context context0, String s, Set set0, Provider provider0) {
        this(() -> new HeartBeatInfoStorage(context0, s), set0, new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), DefaultHeartBeatController.THREAD_FACTORY), provider0, context0);
    }

    DefaultHeartBeatController(Provider provider0, Set set0, Executor executor0, Provider provider1, Context context0) {
        this.storageProvider = provider0;
        this.consumers = set0;
        this.backgroundExecutor = executor0;
        this.userAgentProvider = provider1;
        this.applicationContext = context0;
    }

    public static Component component() {
        return Component.builder(DefaultHeartBeatController.class, new Class[]{HeartBeatController.class, HeartBeatInfo.class}).add(Dependency.required(Context.class)).add(Dependency.required(FirebaseApp.class)).add(Dependency.setOf(HeartBeatConsumer.class)).add(Dependency.requiredProvider(UserAgentPublisher.class)).factory((ComponentContainer componentContainer0) -> new DefaultHeartBeatController(((Context)componentContainer0.get(Context.class)), ((FirebaseApp)componentContainer0.get(FirebaseApp.class)).getPersistenceKey(), componentContainer0.setOf(HeartBeatConsumer.class), componentContainer0.getProvider(UserAgentPublisher.class))).build();
    }

    @Override  // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public HeartBeat getHeartBeatCode(String s) {
        synchronized(this) {
            HeartBeatInfoStorage heartBeatInfoStorage0 = (HeartBeatInfoStorage)this.storageProvider.get();
            if(heartBeatInfoStorage0.shouldSendGlobalHeartBeat(System.currentTimeMillis())) {
                heartBeatInfoStorage0.postHeartBeatCleanUp();
                return HeartBeat.GLOBAL;
            }
            return HeartBeat.NONE;
        }
    }

    @Override  // com.google.firebase.heartbeatinfo.HeartBeatController
    public Task getHeartBeatsHeader() {
        if(!UserManagerCompat.isUserUnlocked(this.applicationContext) != 0) {
            return Tasks.forResult("");
        }
        DefaultHeartBeatController..ExternalSyntheticLambda1 defaultHeartBeatController$$ExternalSyntheticLambda10 = () -> synchronized(this) {
            HeartBeatInfoStorage heartBeatInfoStorage0 = (HeartBeatInfoStorage)this.storageProvider.get();
            List list0 = heartBeatInfoStorage0.getAllHeartBeats();
            heartBeatInfoStorage0.deleteAllHeartBeats();
            JSONArray jSONArray0 = new JSONArray();
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                HeartBeatResult heartBeatResult0 = (HeartBeatResult)list0.get(v1);
                JSONObject jSONObject0 = new JSONObject();
                jSONObject0.put("agent", heartBeatResult0.getUserAgent());
                jSONObject0.put("dates", new JSONArray(heartBeatResult0.getUsedDates()));
                jSONArray0.put(jSONObject0);
            }
            JSONObject jSONObject1 = new JSONObject();
            jSONObject1.put("heartbeats", jSONArray0);
            jSONObject1.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream0 = new Base64OutputStream(byteArrayOutputStream0, 11);
            try(GZIPOutputStream gZIPOutputStream0 = new GZIPOutputStream(base64OutputStream0)) {
                gZIPOutputStream0.write(jSONObject1.toString().getBytes("UTF-8"));
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(base64OutputStream0, throwable0);
                throw throwable0;
            }
            base64OutputStream0.close();
            return byteArrayOutputStream0.toString("UTF-8");
        };
        return Tasks.call(this.backgroundExecutor, defaultHeartBeatController$$ExternalSyntheticLambda10);
    }

    // 检测为 Lambda 实现
    static DefaultHeartBeatController lambda$component$4(ComponentContainer componentContainer0) [...]

    // 检测为 Lambda 实现
    String lambda$getHeartBeatsHeader$2$com-google-firebase-heartbeatinfo-DefaultHeartBeatController() throws Exception [...]

    // 检测为 Lambda 实现
    static HeartBeatInfoStorage lambda$new$3(Context context0, String s) [...]

    // 检测为 Lambda 实现
    Void lambda$registerHeartBeat$1$com-google-firebase-heartbeatinfo-DefaultHeartBeatController() throws Exception [...]

    // 检测为 Lambda 实现
    static Thread lambda$static$0(Runnable runnable0) [...]

    public Task registerHeartBeat() {
        if(this.consumers.size() <= 0) {
            return Tasks.forResult(null);
        }
        if(!UserManagerCompat.isUserUnlocked(this.applicationContext) != 0) {
            return Tasks.forResult(null);
        }
        DefaultHeartBeatController..ExternalSyntheticLambda2 defaultHeartBeatController$$ExternalSyntheticLambda20 = () -> synchronized(this) {
            ((HeartBeatInfoStorage)this.storageProvider.get()).storeHeartBeat(System.currentTimeMillis(), ((UserAgentPublisher)this.userAgentProvider.get()).getUserAgent());
            return null;
        };
        return Tasks.call(this.backgroundExecutor, defaultHeartBeatController$$ExternalSyntheticLambda20);
    }
}

