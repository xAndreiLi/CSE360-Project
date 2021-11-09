import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * Message Handler class handles all message-related functions. Uses I/O file
 * system to handle messages.
 * 
 * @author Randy Pham
 */
public class MessageHandler {
    Doctor doctor;
    Patient patient;
    String fileDir = "Messages/";

    // default constructor
    public MessageHandler() {

    }

    /**
     * This method creates a new <code>File</code> that will hold the contents of
     * the message between the sender and the receiver
     * 
     * @param sender   - the object that is sending the message (i.e. Doctor or
     *                 Patient)
     * @param receiver - the object that is receiving the message (i.e. Patient or
     *                 Doctor)
     * @param message  - the message itself
     * @throws IOException
     */
    public void createNewMessage(Object sender, Object receiver, String message) throws IOException {
        File messageFile;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        int fileNum = 0;
        // using hash code for doctor and patient to link messages together
        // converted both hashes to strings
        String senderHash = getHashCode(sender) + "";
        String receiverHash = getHashCode(receiver) + "";
        // file name for the file
        String fileName = fileDir + senderHash + receiverHash + ".txt";

        messageFile = new File(fileName);
        // this checks if the file name already exists
        if (messageFile.exists()) { // && !messageFile.isDirectory()) {
            // if the file name already exists, simply add a number at the end of it
            while (messageFile.exists()) {
                fileNum++;
                // new file name: 11234567890.txt
                messageFile = new File(fileNum + fileName);
            }
        }
        // create new file with that file name
        messageFile.createNewFile();

        // writing the file here
        fileWriter = new FileWriter(messageFile);
        bufferedWriter = new BufferedWriter(fileWriter);
        // write the message to the file
        bufferedWriter.write(message);

        // close writer to prevent leak
        bufferedWriter.close();
        System.out.println("File writing done");
    }

    /**
     * This method reads existing files from the Messages/ folder. If there is no
     * message found, it throws an exception
     * 
     * @param filename - the name of the file
     * @throws FileNotFoundException exception
     */
    public void readMessage(String filename) throws FileNotFoundException {
        File messageFile;
        Scanner reader;
        String data;

        messageFile = findMessage(fileDir + filename);

        if (messageFile == null) {
            // UH OH THERE IS NO EXISTING MESSAGE
            System.out.println("Cannot find message: " + messageFile);
        } else {
            reader = new Scanner(messageFile);

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

    /**
     * This method returns the hashcode for the object
     * 
     * @param object - the object that is sending the message
     * @return the hashcode for the sender
     */
    public int getHashCode(Object object) {
        int hashCode = Objects.hashCode(object);
        return hashCode;
    }
}