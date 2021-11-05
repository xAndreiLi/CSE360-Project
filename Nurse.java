
public class Nurse {
	//work done by Long Ly
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
    private MessageHandler messagehandler;

    public Nurse(){
        this.patient = NULL;
        this.doctors = NULL;
        this.patientList = NULL;
        
    }//end of Nurse Constructor


    //updating Patient Vitals from Patient class
    public void updatePatientVitals(float weight, String height, float bodytemp, float bloodPres){
        this.patient.updateVitals(weight, height, bodytemp, bloodPres);
    }//end of updatePaitentVitals

    public void recordPatientMeasurements(Patient patient){ 
        //may be replaced by updatePatientVitals
    }//end of recordPatientMeasurements

    private void viewPatientList(){
        //TO BE WORKED ON
    }//end of viewPatientList

    private void addNewPatientToList(Patient patient){
        //ADDS PATIENT TO PATIENTLIST

    }//end of addNewPatientToList

    private void removePatientFromList(Patient patient){
        //REMOVE PATIENT FROM PATIENTLIST

    }//removePatientFromList
   
}//end of nurse class
