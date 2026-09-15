/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.lostandfound.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Khanya Bhixa
 */
public class DBConnection {
   public static Connection derbyConnection() throws SQLException 
            
    {
String DATABASE_URL = "jdbc:derby://localhost:1527/LostAndFound";
String username = "administrator";
String password = "admin";
Connection connection = DriverManager.getConnection(DATABASE_URL,
username, password);
return connection;

    }
    
}
    
  
