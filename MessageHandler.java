import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
//import java.util.Scanner;

/**
 * Message Handler class handles all message-related functions. Uses I/O file
 * system to handle messages.
 * 
 * @author Randy Pham
 */
public class MessageHandler implements Serializable {
    private String fileDir = "Messages/";

    // default constructor
    public MessageHandler() {

    }

    /**
     * This method will either create a new <code>File</code> that will hold the
     * contents of the message between the Doctor and Patient or write to an
     * existing <code>File</code> that holds previous messages between Doctor and
     * Patient. The file is created with the hashcodes of the doctor object and
     * patient object respectfully in the "Messages/" folder. Example file:
     * Messages/111111222222.txt
     * 
     * @param account - the doctor or nurse object
     * @param patient - the patient object
     * @param message - the message itself
     * @throws IOException
     */
    public void writeMessage(Account account, Patient patient, String message) throws IOException {
        File messageFile;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        // using hash code for doctor and patient to link messages together
        // converted both hashes to strings
        String accountHash = getHashCode(account) + "";
        String patientHash = getHashCode(patient) + "";
        // file name for the file
        String fileName = fileDir + accountHash + patientHash + ".txt";

        messageFile = new File(fileName);
        // this checks if the file already exists
        if (messageFile.exists()) {
            // if file already exists, no need to create a new file
            // simply append message to existing file

            // filewriter in append mode
            fileWriter = new FileWriter(messageFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            // create a new line after previous message and write new message to file
            bufferedWriter.newLine();
            bufferedWriter.write(message);

            // close writer to prevent leak
            bufferedWriter.close();
            System.out.println(fileName + " updated");
        } else {
            // create new file with that file name
            messageFile.createNewFile();

            // writing to new file
            fileWriter = new FileWriter(messageFile);
            bufferedWriter = new BufferedWriter(fileWriter);

            // write the message to the file
            bufferedWriter.write(message);

            // close writer to prevent leak
            bufferedWriter.close();
            System.out.println("new file writing done at: " + fileName);
        }
    }

    /**
     * This method reads existing files from the Messages/ folder and returns a
     * string containing the contents of the file. If there is no message found, it
     * throws an exception. Note: it already appends "Messages/" to the param
     * filename
     * 
     * @param filename - the name of the file
     * @throws IOException
     */
    public String readMessage(String filename) throws IOException {
        File messageFile;
        // Scanner reader;
        String content; // flag, message;
        // int numOfLines = 0, rowNum = 0;

        messageFile = findMessage(fileDir + filename);

        if (messageFile == null) {
            // UH OH THERE IS NO EXISTING MESSAGE
            System.out.println("Cannot find message at: " + messageFile);

            return "Cannot find message error";
        } else {
            /*
             * // count number of lines numOfLines = countLines(fileDir + filename); reader
             * = new Scanner(messageFile);
             * 
             * // make an array to store the messages // array has row = numOfLines and col
             * = 2 messageArray = new String[numOfLines][2];
             * 
             * while (reader.hasNextLine()) { line = reader.nextLine(); flag =
             * line.substring(0, 2); message = line.substring(2); // store in array
             * messageArray[rowNum][0] = flag; messageArray[rowNum][1] = message; rowNum++;
             * }
             * 
             * 
             * 
             * reader.close();
             */
            /*
             * reader = new Scanner(messageFile);
             * 
             * while (reader.hasNextLine()) { line = reader.nextLine(); // display the line
             * to the gui System.out.println(line); }
             * 
             * reader.close();
             */

            Path pathFromFile = messageFile.toPath();

            content = Files.readString(pathFromFile);

            return content;
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

    /**
     * This helper method is to read the number of lines in a file
     * 
     * @param filename - the name of the file
     * @return the number of lines in a file
     *
     *         private int countLines(String filename) throws IOException { int
     *         count = 0; BufferedReader reader = new BufferedReader(new
     *         FileReader(filename));
     * 
     *         while (reader.readLine() != null) { count++; }
     * 
     *         reader.close(); return count; }
     */
}