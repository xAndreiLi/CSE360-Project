import java.io.*;

import javax.print.Doc;

/**
 * Message Handler class handles all message-related functions. Uses I/O file
 * system to handle messages.
 * 
 * @author Randy Pham
 */
public class MessageHandler {
    File message;
    Doctor doctor;
    Patient patient;

    // default constructor
    public MessageHandler() {

    }

    public void createNewMessage(Doctor doctor, Patient patient) {
        message = new File("message.txt");
    }
}