/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.lostandfound.DAO;

/**
 *
 * @author rjbur
 */

    import za.ac.cput.lostandfound.connection.DBConnection;
import za.ac.cput.lostandfound.domain.User;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/*
 * Author: Runyararo Joseph Bure StudentNumber-240377222
 */
public class UserDAO {

    /**
       * @param user
     * @return 
     */
    public int insertValue(User user) {

        String insertValues = "INSERT INTO AppUser (name, email, password, phone, role) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement pstmt = con.prepareStatement(insertValues, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getPhone());
            pstmt.setString(5, user.getRole());
            pstmt.executeUpdate();

            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }

        } catch (SQLException se) {
            System.out.println("ERROR: " + se);
        }

        return -1;
    }
public void insertAdminUser(int userId) {
        String sql = "INSERT INTO AdminUser (user_id, permission_level) VALUES (?, ?)";
        insertSubtypeRow(sql, userId, 1);
    }


    public void insertStudentUser(int userId) {
        String sql = "INSERT INTO StudentUser (user_id, student_number) VALUES (?, ?)";
        insertSubtypeRow(sql, userId, 0);
    }

 
    public void insertStaffUser(int userId) {
        String sql = "INSERT INTO StaffUser (user_id, department) VALUES (?, ?)";
        insertSubtypeRow(sql, userId, 0);
    }

    private void insertSubtypeRow(String sql, int userId, int secondColumnValue) {
        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, secondColumnValue);
            pstmt.executeUpdate();

        } catch (SQLException se) {
            System.out.println("ERROR: " + se);
        }
    }

    public ArrayList<User> getAll() {

        ArrayList<User> userList = new ArrayList<>();
        String getAll = "SELECT * FROM AppUser";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement pstmt = con.prepareStatement(getAll);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                userList.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("phone"),
                        rs.getString("role")
                ));
            }

        } catch (SQLException se) {
            System.out.println("ERROR: " + se);
        }

        return userList;
    }

    public boolean isEmailRegistered(String email) {

        String checkEmail = "SELECT * FROM AppUser WHERE email = ?";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement pstmt = con.prepareStatement(checkEmail)) {

            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException se) {
            System.out.println("ERROR: " + se);
        }

        return false;
    }

    public void updateRecord(int userId, String name, String email, String phone, String role) {

        String updateRecord = "UPDATE AppUser SET name = ?, email = ?, phone = ?, role = ? WHERE user_id = ?";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement pstmt = con.prepareStatement(updateRecord)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, role);
            pstmt.setInt(5, userId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }

    public void deleteRecord(int userId) {

        String deleteRecord = "DELETE FROM AppUser WHERE user_id = ?";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement pstmt = con.prepareStatement(deleteRecord)) {

            pstmt.setInt(1, userId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }

    // Login
    public boolean login(User user) {

        String sql = "SELECT * FROM AppUser WHERE email = ? AND password = ?";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error:\n" + ex.getMessage());
        }

        return false;
    }

    // Check if email exists
    public boolean userExists(String email) {

        String sql = "SELECT * FROM AppUser WHERE email = ?";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error:\n" + ex.getMessage());
        }

        return false;
    }

    // Get user by email
    public User getUserByEmail(String email) {

        String sql = "SELECT * FROM AppUser WHERE email = ?";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User(email, rs.getString("password"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setPhone(rs.getInt("phone"));
                    user.setRole(rs.getString("role"));
                    return user;
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error:\n" + ex.getMessage());
        }

        return null;
    }

    // Update password
    public boolean updatePassword(String email, String newPassword) {

        String sql = "UPDATE AppUser SET password = ? WHERE email = ?";

        try (Connection con = DBConnection.derbyConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newPassword);
            ps.setString(2, email);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error:\n" + ex.getMessage());
        }

        return false;
    }

}

    

