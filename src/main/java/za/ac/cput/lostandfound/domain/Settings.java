package za.ac.cput.lostandfound.domain;

public class Settings {

    private boolean reportUpdates;
    private boolean adminAnnouncements;
    private boolean pushNotifications;

    public Settings() {
    }

    public Settings(boolean reportUpdates,
                    boolean adminAnnouncements,
                    boolean pushNotifications) {

        this.reportUpdates = reportUpdates;
        this.adminAnnouncements = adminAnnouncements;
        this.pushNotifications = pushNotifications;
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
}