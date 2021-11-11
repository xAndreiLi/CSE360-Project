//worked on by Hy Nguyen

// 11-11-2021
// Should be all finsihed. Just need to test and debug as a whole
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Patient implements Serializable {

    // Patient Attributes
    float weight, bodyTemp, bloodPres; // vitals taken by Nurse
    String patientEmail, patientFName, patientLName, patientNumber, height, // Patient info and reason for visit
            emerFName, emerLName, emerEmail, emergenNumber, medication, // Emergency Contact Info
            username, password, dateOfBirth, pharmacy; 
    Doctor currentDoctor;
    MessageHandler messageHandler;
    String[] patientHistoryArray;
    public Queue<String> patientHistory = new LinkedList<>();

    // Patient Operations

    public Patient() {
        // Empty Patient
        this.username = "null";
        this.password = "null";
        this.dateOfBirth = "Jan. 01, 2000";
        this.patientFName = "John";
        this.patientLName = "Doe";
        this.dateOfBirth = null;
        this.patientEmail = "johndoe@doe.com";
        this.patientNumber = "000-000-0000";
        this.emerFName = "Jane";
        this.emerLName = "Doe";
        this.emerEmail = "janedoe@doe.com";
        this.emergenNumber = "000-000-0000";
        this.medication = "";
        this.pharmacy = "CVS";
        // Setting default vitals
        this.weight = 0;
        this.height = "0 ' 0";
        this.bodyTemp = 0;
        this.bloodPres = 0;
        this.patientHistoryArray = new String[10];
    }

    public Patient(String username, String password, String fName, String lName, String birthday, String email, String phoneNum, String pharmacy,
            String emerfName, String emerlName, String emerEmail, String emergenNumber) {
        this.username = username;
        this.password = password;
        this.patientFName = fName;
        this.patientLName = lName;
        this.dateOfBirth = birthday;
        this.patientEmail = email;
        this.patientNumber = phoneNum;
        this.emerFName = emerfName;
        this.emerLName = emerlName;
        this.emerEmail = emerEmail;
        this.emergenNumber = emergenNumber;
        this.pharmacy = pharmacy;
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

    // Setters for Patient Creation if needed
    public void setWeight(float weight){
        this.weight = weight;
    }

    public void setBodyTemp(float bodyTemp){
        this.bodyTemp = bodyTemp;
    }

    public void setBloodPressure(float bloodPres){
        this.bloodPres = bloodPres;
    }

    public void setPatientEmail(String email){
        this.patientEmail = email;
    }
    public void setPatientFirstName(String FirstName){
        this.patientFName = FirstName;
    }
    public void setPatientLastName(String lastName){
        this.patientLName = lastName;
    }
    public void setPatientPhoneNumber(String number){
        this.patientNumber = number;
    }
    public void setPatientHeight(String height){
        this.height = height;
    }

    public void setEmergencyContact(String firstName, String lastName, String email, String number){
        this.emerFName = firstName;
        this.emerLName = lastName;
        this.emerEmail = email;
        this.emergenNumber = number;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setDateOfBirth(String birthday){
        this.dateOfBirth = birthday;
    }

    public void setDateOfBirth(String month, String day, String year){
        String birthday = month + " " + day + ", " + year;
        this.dateOfBirth = birthday;
    }
    public void setPharmacy(String pharmacy){
        this.pharmacy = pharmacy;
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

    public String getMedication(){
        return this.medication;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public String getPharmacy(){
        return this.pharmacy;
    }
}
