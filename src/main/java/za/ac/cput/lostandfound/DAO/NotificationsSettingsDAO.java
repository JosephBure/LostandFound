package za.ac.cput.lostandfound.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import za.ac.cput.lostandfound.connection.DBConnection;
import za.ac.cput.lostandfound.domain.NotificationsSettings;

public class NotificationsSettingsDAO {

    // Add a new notification settings record
    public void add(NotificationsSettings settings) throws SQLException {

        String sql = "INSERT INTO NOTIFICATION_SETTINGS "
                   + "(ID, USER_ID, REPORT_UPDATES, ADMIN_ANNOUNCEMENTS, "
                   + "PUSH_NOTIFICATIONS, UPDATED_AT) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, settings.getId());
            statement.setInt(2, settings.getUserId());
            statement.setBoolean(3, settings.isReportUpdates());
            statement.setBoolean(4, settings.isAdminAnnouncements());
            statement.setBoolean(5, settings.isPushNotifications());
            statement.setTimestamp(6,
                    new Timestamp(System.currentTimeMillis()));

            statement.executeUpdate();
        }
    }

    // Retrieve notification settings
    public NotificationsSettings getByUserId(int userId)
            throws SQLException {

        String sql = "SELECT * FROM NOTIFICATION_SETTINGS "
                   + "WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new NotificationsSettings(
                        result.getInt("ID"),
                        result.getInt("USER_ID"),
                        result.getBoolean("REPORT_UPDATES"),
                        result.getBoolean("ADMIN_ANNOUNCEMENTS"),
                        result.getBoolean("PUSH_NOTIFICATIONS"),
                        result.getTimestamp("UPDATED_AT")
                );
            }
        }

        return null;
    }

    // Update notification settings
    public void update(NotificationsSettings settings)
            throws SQLException {

        String sql = "UPDATE NOTIFICATION_SETTINGS SET "
                   + "REPORT_UPDATES = ?, "
                   + "ADMIN_ANNOUNCEMENTS = ?, "
                   + "PUSH_NOTIFICATIONS = ?, "
                   + "UPDATED_AT = ? "
                   + "WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBoolean(1, settings.isReportUpdates());
            statement.setBoolean(2, settings.isAdminAnnouncements());
            statement.setBoolean(3, settings.isPushNotifications());
            statement.setTimestamp(4,
                    new Timestamp(System.currentTimeMillis()));
            statement.setInt(5, settings.getUserId());

            statement.executeUpdate();
        }
    }

    // Delete notification settings
    public void delete(int userId) throws SQLException {

        String sql = "DELETE FROM NOTIFICATION_SETTINGS "
                   + "WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            statement.executeUpdate();
        }
    }
}