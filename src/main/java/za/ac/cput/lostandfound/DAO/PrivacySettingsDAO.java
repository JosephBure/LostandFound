package za.ac.cput.lostandfound.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import za.ac.cput.lostandfound.connection.DBConnection;
import za.ac.cput.lostandfound.domain.PrivacySettings;

public class PrivacySettingsDAO {

    // Add a new privacy settings record
    public void add(PrivacySettings settings) throws SQLException {

        String sql = "INSERT INTO PRIVACY_SETTINGS "
                   + "(ID, USER_ID, PROFILE_VISIBILITY, SHOW_CONTACT_INFO, "
                   + "TWO_FACTOR_AUTH, UPDATED_AT) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, settings.getId());
            statement.setInt(2, settings.getUserId());
            statement.setString(3, settings.getProfileVisibility());
            statement.setBoolean(4, settings.isShowContactInfo());
            statement.setBoolean(5, settings.isTwoFactorAuth());
            statement.setTimestamp(6,
                    new Timestamp(System.currentTimeMillis()));

            statement.executeUpdate();
        }
    }

    // Retrieve privacy settings
    public PrivacySettings getByUserId(int userId) throws SQLException {

        String sql = "SELECT * FROM PRIVACY_SETTINGS WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new PrivacySettings(
                        result.getInt("ID"),
                        result.getInt("USER_ID"),
                        result.getString("PROFILE_VISIBILITY"),
                        result.getBoolean("SHOW_CONTACT_INFO"),
                        result.getBoolean("TWO_FACTOR_AUTH"),
                        result.getTimestamp("UPDATED_AT")
                );
            }
        }

        return null;
    }

    // Update privacy settings
    public void update(PrivacySettings settings) throws SQLException {

        String sql = "UPDATE PRIVACY_SETTINGS SET "
                   + "PROFILE_VISIBILITY = ?, "
                   + "SHOW_CONTACT_INFO = ?, "
                   + "TWO_FACTOR_AUTH = ?, "
                   + "UPDATED_AT = ? "
                   + "WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, settings.getProfileVisibility());
            statement.setBoolean(2, settings.isShowContactInfo());
            statement.setBoolean(3, settings.isTwoFactorAuth());
            statement.setTimestamp(4,
                    new Timestamp(System.currentTimeMillis()));
            statement.setInt(5, settings.getUserId());

            statement.executeUpdate();
        }
    }

    // Delete privacy settings
    public void delete(int userId) throws SQLException {

        String sql = "DELETE FROM PRIVACY_SETTINGS WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            statement.executeUpdate();
        }
    }
}