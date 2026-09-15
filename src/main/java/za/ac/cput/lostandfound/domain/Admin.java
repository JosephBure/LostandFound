/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.lostandfound.domain;



/**
 *
 * @author Sinesipho bosch
 */




public class Admin  {
 
    private int logId;
    private String userName;
    private String action;
    private String logTime;
 
    public Admin() {
    }
 
    // Constructor used when reading a full row back from the database
    public Admin(int logId, String userName, String action, String logTime) {
        this.logId = logId;
        this.userName = userName;
        this.action = action;
        this.logTime = logTime;
    }
 
    // Constructor used when creating a new entry 
    public Admin(String userName, String action, String logTime) {
        this.userName = userName;
        this.action = action;
        this.logTime = logTime;
    }
 
    public int getLogId() {
        return logId;
    }
 
    public void setLogId(int logId) {
        this.logId = logId;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getAction() {
        return action;
    }
 
    public void setAction(String action) {
        this.action = action;
    }
 
    public String getLogTime() {
        return logTime;
    }
 
    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }
 
    @Override
    public String toString() {
        return userName + " - " + action + " (" + logTime + ")";
    }
}
 



