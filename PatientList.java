import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;

//This Class will read and write Patient objects to a file
//Will need a "Save" folder for the methods to write and read to/from

public class PatientList {

        //This file will be used to load in people
        String loadList = "Save/MasterList.txt";
        File saveFile;
        FileWriter myWriter;
        
        public PatientList(){
        //Creating the Master Save File
        try{
            saveFile = new File(loadList);
        
            //For testing
            if (saveFile.createNewFile()){
                System.out.println("File Create");
            } else {
                System.out.println("File Exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } //end Catch
}
    
    public void savePatient(Patient pat) {
        String fileName = pat.getPatientFullName() + ".txt";
        WriteObjectToFile(pat, fileName);
        try{
            myWriter = new FileWriter(saveFile, true);
            myWriter.write(fileName);
            myWriter.write("\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
    }
}

    //This method will be used to LOAD objects from file
    //Will need to create a loop in the main to read off a seperate text file to 
    //Load all past objects
    public static Object ReadObjectFromFile(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void WriteObjectToFile(Object serObj, String name) {
        try {

            String filepath = "Save/" + name;
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


