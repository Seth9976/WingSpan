package com.voxelbusters.essentialkit.notificationservices;

import com.voxelbusters.essentialkit.notificationservices.datatypes.Notification;
import com.voxelbusters.essentialkit.notificationservices.datatypes.NotificationAccessState;
import java.util.List;

public class INotificationServices {
    public interface INotificationReceivedListener {
        void onNotificationReceived(Notification arg1);
    }

    public interface INotificationsRequestListener {
        void onFailure(String arg1);

        void onSuccess(List arg1);
    }

    public interface IRegisterRemoteNotificationsListener {
        void onFailure(String arg1);

        void onSuccess(String arg1);
    }

    public interface IRequestNotificationPermissionsListener {
        void onFailure(String arg1);

        void onSuccess(NotificationAccessState arg1);
    }

    public interface IScheduleNotificationListener {
        void onFailure(String arg1);

        void onSuccess();
    }

    public interface IUnregisterRemoteNotificationServiceListener {
        void onFailure(String arg1);

        void onSuccess();
    }

}

