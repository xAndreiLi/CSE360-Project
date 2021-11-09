import java.io.*;
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

    // default constructor
    public MessageHandler() {

    }

    // creates a new file and writes the message between the doctor and the patient
    // to it
    // TODO: need to figure out how to link the message to the doctor and patient
    public void createNewMessage(Doctor doctor, Patient patient, String message) throws IOException {
        File messageFile;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String fileName = "message.txt";
        int fileNum = 0;

        messageFile = new File(fileName);
        // this checks if the file name already exists
        if (messageFile.exists() && !messageFile.isDirectory()) {
            // if the file name already exists, simply add a number at the end of it
            while (messageFile.exists()) {
                fileNum++;
                messageFile = new File("message" + fileNum + ".txt");
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
     * This method reads existing messages. If there is no message found, it throws
     * an exception
     * 
     * @param filename - the name of the file
     * @throws FileNotFoundException exception
     */
    public void readMessage(String filename) throws FileNotFoundException {
        File messageFile;
        Scanner reader;
        String data;

        messageFile = findMessage(filename);

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
}