
public class Nurse {
	//work done by Long Ly
    //MAINLY DONE NEED PATIENT LIST TO FINISH
    
    //Nurse responsibities
    /*
    Current Patient
    List of all doctors
    View Patient List
    Records Patient Measurements
    Appoint Doctor to Patient
    Add new patient to patient list
    Remove patient from patient list
    */

    //Nurse Constructor
    //WIP
    private Patient patient;
    private Doctor[] doctors;
    private PatientList patientList;
    private MessageHandler messageHandler;

    //I don't think nurses have their own id or names
    public Nurse(){
        messageHandler = New MessageHandler();
        
    }//end of Nurse Constructor
    
    public void appointDoctorToPatient(Doctor doctor){
        this.patient.assignDoctor(doctor);
    }

    //updating Patient Vitals from Patient class
    //Also appoints paitent to doctor at the same time
    public void updatePatientVitals(float weight, String height, float bodytemp, float bloodPres, Doctor doctor){
        this.patient.updateVitals(weight, height, bodytemp, bloodPres);
        appointDoctorToPatient(doctor);
        
    }//end of updatePaitentVitals

    //  

    public void setCurrentPatient(Patient patient){
        this.patient = patient;
    }

    //
    public String[] patientHistory(){
        return this.patient.getPatientHistoryArray();
    }

    private void viewPatientList(){
        //TO BE WORKED ON
    }//end of viewPatientList

    private void addNewPatientToList(Patient patient){
        //TO BE WORKED ON
        //ADDS PATIENT TO PATIENTLIST

    }//end of addNewPatientToList

    private void removePatientFromList(Patient patient){
        //TO BE WORKED ON
        //REMOVES PATIENT FROM PATIENTLIST

    }//removePatientFromList
   
}//end of nurse class
