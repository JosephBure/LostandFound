package za.ac.cput.lostandfound.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import za.ac.cput.lostandfound.connection.DBConnection;
import za.ac.cput.lostandfound.domain.AccountSettings;



public class AccountSettingsDAO {

    // Add a new account settings record
    public void add(AccountSettings settings) throws SQLException {

        String sql = "INSERT INTO ACCOUNT_SETTINGS "
                   + "(ID, USER_ID, USERNAME, EMAIL, PHONE_NUMBER, UPDATED_AT) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, settings.getId());
            statement.setInt(2, settings.getUserId());
            statement.setString(3, settings.getUsername());
            statement.setString(4, settings.getEmail());
            statement.setString(5, settings.getPhoneNumber());
            statement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

            statement.executeUpdate();
        }
    }

    // Retrieve an account settings record
    public AccountSettings getByUserId(int userId) throws SQLException {

        String sql = "SELECT * FROM ACCOUNT_SETTINGS WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return new AccountSettings(
                        result.getInt("ID"),
                        result.getInt("USER_ID"),
                        result.getString("USERNAME"),
                        result.getString("EMAIL"),
                        result.getString("PHONE_NUMBER"),
                        result.getTimestamp("UPDATED_AT")
                );
            }
        }

        return null;
    }

    // Update an existing account settings record
    public void update(AccountSettings settings) throws SQLException {

        String sql = "UPDATE ACCOUNT_SETTINGS SET "
                   + "USERNAME = ?, "
                   + "EMAIL = ?, "
                   + "PHONE_NUMBER = ?, "
                   + "UPDATED_AT = ? "
                   + "WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, settings.getUsername());
            statement.setString(2, settings.getEmail());
            statement.setString(3, settings.getPhoneNumber());
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            statement.setInt(5, settings.getUserId());

            statement.executeUpdate();
        }
    }

    // Delete an account settings record
    public void delete(int userId) throws SQLException {

        String sql = "DELETE FROM ACCOUNT_SETTINGS WHERE USER_ID = ?";

        try (Connection connection = DBConnection.derbyConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, userId);

            statement.executeUpdate();
        }
    }
}