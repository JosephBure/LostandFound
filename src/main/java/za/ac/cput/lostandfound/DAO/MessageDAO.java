package za.ac.cput.lostandfound.dao;


import za.ac.cput.lostandfound.connection.DBConnection;
import za.ac.cput.lostandfound.domain.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

/**
 *
 * @author Khanya Bhixa
 */
public class MessageDAO {

    public boolean addMessage(Message message) {

        String sql =
                "INSERT INTO MESSAGES "
                + "(SENDER, RECEIVER, MESSAGE) "
                + "VALUES (?, ?, ?)";

        try (
                Connection connection =
                        DBConnection.derbyConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    message.getSender()
            );

            statement.setString(
                    2,
                    message.getReceiver()
            );

            statement.setString(
                    3,
                    message.getMessage()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }

    public List<Message> getConversation(
            String user1,
            String user2) {

        List<Message> messages =
                new ArrayList<>();

        String sql =
                "SELECT MESSAGEID, SENDER, RECEIVER, "
                + "MESSAGE, SENTTIME "
                + "FROM MESSAGES "
                + "WHERE (SENDER = ? AND RECEIVER = ?) "
                + "OR (SENDER = ? AND RECEIVER = ?) "
                + "ORDER BY MESSAGEID ASC";

        try (
                Connection connection =
                        DBConnection.derbyConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, user1);
            statement.setString(2, user2);
            statement.setString(3, user2);
            statement.setString(4, user1);

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                int id =
                        result.getInt("MESSAGEID");

                String sender =
                        result.getString("SENDER");

                String receiver =
                        result.getString("RECEIVER");

                String message =
                        result.getString("MESSAGE");

                Timestamp sentTime =
                        result.getTimestamp("SENTTIME");

                messages.add(
                        new Message(
                                id,
                                sender,
                                receiver,
                                message,
                                sentTime
                        )
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return messages;
    }
}