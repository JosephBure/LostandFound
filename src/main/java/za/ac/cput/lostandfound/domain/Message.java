package za.ac.cput.lostandfound.domain;

import java.sql.Timestamp;

/**
 *
 * @author Khanya Bhixa
 */
public class Message {

    private int messageID;
    private String sender;
    private String receiver;
    private String message;
    private Timestamp sentTime;

    public Message() {
    }

    public Message(
            String sender,
            String receiver,
            String message) {

        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public Message(
            int messageID,
            String sender,
            String receiver,
            String message,
            Timestamp sentTime) {

        this.messageID = messageID;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.sentTime = sentTime;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSentTime() {
        return sentTime;
    }

    public void setSentTime(Timestamp sentTime) {
        this.sentTime = sentTime;
    }
}