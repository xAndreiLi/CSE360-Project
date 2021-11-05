import java.io.*;

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

    public void createNewMessage(Doctor doctor, Patient patient) throws IOException {
        // create a file
        String fileName = "message.txt";
        int fileNum = 0;

        message = new File(fileName);
        // this checks if the file name already exists
        if (message.exists() && !message.isDirectory()) {
            // if the file name already exists, simply add a number at the end of it
            while (message.exists()) {
                fileNum++;
                message = new File("messages" + fileNum + ".txt");
            }
        }
        // create new file with that file name
        message.createNewFile();
    }
}