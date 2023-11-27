package org.example.repo.inMemoryRepo;

import org.example.model.Notification;
import org.example.repo.IRepository;

import java.util.ArrayList;
import java.util.List;

public class NotificationRepository implements IRepository<Notification> {
    private ArrayList<Notification> notifications;
    private static NotificationRepository instance;

    private NotificationRepository() {
        this.notifications = new ArrayList<>();
    }

    @Override
    public ArrayList<Notification> getObjects() {
        return notifications;
    }

    @Override
    public void save(Notification entity) {
        notifications.add(entity);
    }

    @Override
    public void update(Notification entity, String action) {

    }

    @Override
    public void delete(Notification object) {
        notifications.remove(object);
    }


    public static NotificationRepository getInstance() {
        if (instance == null) {
            instance = new NotificationRepository();
        }
        return instance;
    }
}
