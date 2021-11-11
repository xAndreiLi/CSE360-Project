//worked on by Hy Nguyen

// 11-05-2021
// Still waiting on the Message Handler to set up operations. 
// Still need to work on the patient History
import java.util.LinkedList;
import java.util.Queue;

public class Patient {

    // Patient Attributes
    float weight, bodyTemp, bloodPres; // vitals taken by Nurse
    String patientEmail, patientFName, patientLName, patientNumber, height, // Patient info and reason for visit
            emerFName, emerLName, emerEmail, emergenNumber, medication; // Emergency Contact Info
    Doctor currentDoctor;
    MessageHandler messageHandler;
    String[] patientHistoryArray, dateOfBirth, visitReason;
    public Queue<String> patientHistory = new LinkedList<>();

    // Patient Operations

    public Patient() {
        // Empty Patient
        this.patientFName = "John";
        this.patientLName = "Doe";
        this.dateOfBirth = null;
        this.visitReason = null;
        this.patientEmail = "johndoe@doe.com";
        this.patientNumber = "000-000-0000";
        this.emerFName = "Jane";
        this.emerLName = "Doe";
        this.emerEmail = "janedoe@doe.com";
        this.emergenNumber = "000-000-0000";
        this.medication = "";
        // Setting default vitals
        this.weight = 0;
        this.height = "0 ' 0";
        this.bodyTemp = 0;
        this.bloodPres = 0;
        this.patientHistoryArray = new String[10];
    }

    public Patient(String fName, String lName, String[] birthday, String[] visitReason, String email, String phoneNum,
            String emerfName, String emerlName, String emerEmail, String emergenNumber) {
        this.patientFName = fName;
        this.patientLName = lName;
        this.dateOfBirth = birthday;
        this.visitReason = visitReason;
        this.patientEmail = email;
        this.patientNumber = phoneNum;
        this.emerFName = emerfName;
        this.emerLName = emerlName;
        this.emerEmail = emerEmail;
        this.emergenNumber = emergenNumber;
        // Setting default vitals
        this.weight = 0;
        this.height = "0 ' 0";
        this.bodyTemp = 0;
        this.bloodPres = 0;
        this.patientHistoryArray = new String[10];
    }

    // This function will be used by the Patients to mesage their doctors
    // It'll take in a Doctor as the receiptient of the message, and the message
    // itself
    public void messageDoctor(Doctor doc, String messString) {
        // Uses messageHand
        String messageToSend = "Patient " + this.patientFName + ": " + messString;
        try{
            messageHandler.writeMessage(doc, this, messageToSend);
        } catch (Exception e) {
            System.out.println("there was a problem creating a message from doctor to current patient");
            e.printStackTrace();
        }
    }

    // This message will be used to update a patient contact information.
    // It will return a boolean if information is updated
    public boolean changeContactInformation(String email, String phoneNum) {
        boolean success = false;
        if (email != "") {
            this.patientEmail = email;
            success = true;
        }
        if (phoneNum != "") {
            this.patientNumber = phoneNum;
            success = true;
        }
        return success;
    }

    public String[] getPatientHistoryArray() {
        return this.patientHistoryArray;
    }

    public void updateVitals(float weight, String height, float bodyTemp, float bloodPres) {
        this.weight = weight;
        this.height = height;
        this.bodyTemp = bodyTemp;
        this.bloodPres = bloodPres;
    }

    public void assignDoctor(Doctor doctor) {
        this.currentDoctor = doctor;
    }

    public void assignMedication(String medication) {
        this.medication = medication;
    }

    // Getters for the View Own Patient Info
    public float getWeight() {
        return this.weight;
    }

    public float getBodyTemp() {
        return this.bodyTemp;
    }

    public float getbloodPres() {
        return this.bloodPres;
    }

    public String getPatientEmail() {
        return this.patientEmail;
    }

    public String getPatientFirstName() {
        return this.patientFName;
    }

    public String getPatientLastName() {
        return this.patientLName;
    }

    public String getPatientFullName() {
        return this.patientFName + " " + this.patientLName;
    }

    public String getPhoneNumber() {
        return this.patientNumber;
    }

    public String getHeight() {
        return this.height;
    }

    public String getEmergencyFirstName() {
        return this.emerFName;
    }

    public String getEmergencyLastName() {
        return this.emerLName;
    }

    public String getEmergencyFullName() {
        return this.emerFName + " " + this.emerLName;
    }

    public String getEmergencyEmail() {
        return this.emerEmail;
    }

    public String getEmergencyPhoneNumb() {
        return this.emergenNumber;
    }

}
