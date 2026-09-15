package za.ac.cput.lostandfound.domain;

import java.sql.Timestamp;

public class NotificationsSettings {

    private int id;
    private int userId;
    private boolean reportUpdates;
    private boolean adminAnnouncements;
    private boolean pushNotifications;
    private Timestamp updatedAt;

    public NotificationsSettings() {
    }

    public NotificationsSettings(int id, int userId, boolean reportUpdates, boolean adminAnnouncements, boolean pushNotifications, Timestamp updatedAt) {
        this.id = id;
        this.userId = userId;
        this.reportUpdates = reportUpdates;
        this.adminAnnouncements = adminAnnouncements;
        this.pushNotifications = pushNotifications;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isReportUpdates() {
        return reportUpdates;
    }

    public void setReportUpdates(boolean reportUpdates) {
        this.reportUpdates = reportUpdates;
    }

    public boolean isAdminAnnouncements() {
        return adminAnnouncements;
    }

    public void setAdminAnnouncements(boolean adminAnnouncements) {
        this.adminAnnouncements = adminAnnouncements;
    }

    public boolean isPushNotifications() {
        return pushNotifications;
    }

    public void setPushNotifications(boolean pushNotifications) {
        this.pushNotifications = pushNotifications;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}