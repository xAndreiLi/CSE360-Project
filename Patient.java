//worked on by Hy Nguyen

public class Patient {

    //Patient Attributes
    float weight, bodyTemp, bloodPres; //vitals taken by Nurse
    String patientEmail, patientFName, patientLName, patientNumber, height,//Patient info and reason for visit
        emerFName, emerLName, emerEmail, emergenNumber; //Emergency Contact Info
    Doctor currenDoctor;
    MessageHandler messageHandler;
    String[] patientHistory, dateOfBirth, visitReason;

    //Patient Operations

    public Patient(){
        //Empty Patient 
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
        //Setting default vitals
        this.weight = 0;
        this.height = "0 ' 0";
        this.bodyTemp = 0;
        this.bloodPres = 0;

    }
    public Patient(String fName, String lName, String[] birthday, String[] visitReason, String email, String phoneNum, String emerfName, String emerlName, String emerEmail, String emergenNumber){
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
        //Setting default vitals
        this.weight = 0;
        this.height = "0 ' 0";
        this.bodyTemp = 0;
        this.bloodPres = 0;

    }
    //This function will be used by the Patients to mesage their doctors
    //It'll take in a Doctor as the receiptient of the message, and the message itself
    void messageDoctor(Doctor dr, String messString){
        //To be worked on!!
    }

    //This message will be used to update a patient contact information.
    //It will return a boolean if information is updated
    boolean changeContactInformation(String email, String phoneNum){
        boolean success = false;
        if (email != ""){
            this.patientEmail = email;
            success = true;
        } if (phoneNum != ""){
            this.patientNumber = phoneNum;
            success = true;
        }
        return success;
    }

    String[] getPatientHistory(){
        return this.patientHistory;
    }

    void updateVitals(float weight, String height, float bodyTemp, float bloodPres){
        this.weight = weight;
        this.height = height;
        this.bodyTemp = bodyTemp;
        this.bloodPres = bloodPres;
    }

    //Getters for the View Own Patient Info
    float getWeight(){
        return this.weight;
    }

    float getBodyTemp(){
        return this.bodyTemp;
    }

    float getbloodPres(){
        return this.bloodPres;
    }

    
}
