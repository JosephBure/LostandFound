package za.ac.cput.lostandfound.domain;

import java.sql.Timestamp;

public class PrivacySettings {

    private int id;
    private int userId;
    private String profileVisibility;
    private boolean showContactInfo;
    private boolean twoFactorAuth;
    private Timestamp updatedAt;

    public PrivacySettings() {
    }

    public PrivacySettings(int id, int userId, String profileVisibility, boolean showContactInfo, boolean twoFactorAuth, Timestamp updatedAt) {
        this.id = id;
        this.userId = userId;
        this.profileVisibility = profileVisibility;
        this.showContactInfo = showContactInfo;
        this.twoFactorAuth = twoFactorAuth;
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

    public String getProfileVisibility() {
        return profileVisibility;
    }

    public void setProfileVisibility(String profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

    public boolean isShowContactInfo() {
        return showContactInfo;
    }

    public void setShowContactInfo(boolean showContactInfo) {
        this.showContactInfo = showContactInfo;
    }

    public boolean isTwoFactorAuth() {
        return twoFactorAuth;
    }

    public void setTwoFactorAuth(boolean twoFactorAuth) {
        this.twoFactorAuth = twoFactorAuth;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}