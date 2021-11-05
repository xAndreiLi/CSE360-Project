import java.io.*;
import java.util.Scanner;

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

    // creates a new message
    // TODO: need to figure out how to link the message to the doctor and patient
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

    /**
     * This method reads existing messages. If there is no message found, it throws
     * an exception
     * 
     * @param filename - the name of the file
     * @throws FileNotFoundException exception
     */
    public void readMessage(String filename) throws FileNotFoundException {
        File message;
        Scanner reader;
        String data;

        message = findMessage(filename);

        if (message == null) {
            // UH OH THERE IS NO EXISTING MESSAGE
            System.out.println("Cannot find message: " + message);
        } else {
            reader = new Scanner(message);

            while (reader.hasNextLine()) {
                data = reader.nextLine();
                // do something with data
                System.out.println(data);
            }

            reader.close();
        }
    }

    /**
     * This method finds existing messages. If there is no message, then we return
     * null
     * 
     * @param filename - the name of the message
     * @return either the file or null if file not found
     */
    public File findMessage(String filename) {
        File fileToReturn, tempFile;

        tempFile = new File(filename);

        if (tempFile.exists()) {
            fileToReturn = tempFile;
        } else {
            fileToReturn = null;
        }

        return fileToReturn;
    }
}