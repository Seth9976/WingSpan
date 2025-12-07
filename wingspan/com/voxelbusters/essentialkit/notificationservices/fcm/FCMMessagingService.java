package com.voxelbusters.essentialkit.notificationservices.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.voxelbusters.essentialkit.notificationservices.NotificationDispatcher;
import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationBuilder;
import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.ResourcesUtil;
import org.json.JSONObject;

public class FCMMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCMMessagingService";

    @Override  // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage0) {
        Notification notification0;
        if(ResourcesUtil.getBoolean(this, "NOTIFICATION_SERVICES_USES_EXTERNAL_SERVICE")) {
            Logger.warning("External Remote Notification Service enabled. So CPNP\'s client won\'t be used.");
            return;
        }
        Logger.debug("Remote notification received");
        Logger.debug(("Message type : " + remoteMessage0.getMessageType()));
        Logger.debug(("Get Data : " + remoteMessage0.getData()));
        if(remoteMessage0.getData().size() > 0) {
            Logger.debug(("Message data payload: " + remoteMessage0.getData().toString()));
            notification0 = Notification.fromJson(this, new JSONObject(remoteMessage0.getData()));
        }
        else {
            notification0 = null;
        }
        if(remoteMessage0.getNotification() != null) {
            if(notification0 == null) {
                NotificationBuilder notificationBuilder0 = new NotificationBuilder("" + System.currentTimeMillis());
                notificationBuilder0.setTitle(remoteMessage0.getNotification().getTitle(), false);
                notificationBuilder0.setBody(remoteMessage0.getNotification().getBody(), false);
                notification0 = notificationBuilder0.build();
            }
            else {
                notification0.contentTitle = remoteMessage0.getNotification().getTitle();
                notification0.contentText = remoteMessage0.getNotification().getBody();
            }
        }
        if(notification0 != null) {
            notification0.isRemoteNotification = true;
            new NotificationDispatcher(this.getApplicationContext(), notification0).dispatch();
        }
        Logger.debug(("Notification info : " + notification0));
    }

    @Override  // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String s) {
        Logger.debug(("Refreshed token: " + s));
    }
}

