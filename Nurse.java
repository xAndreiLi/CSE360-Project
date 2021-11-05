import Patient;

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
    private PatientList PatientList;
    private MessageHandler messagehandler;

    public Nurse(){
        
    }//end of Nurse Constructor

    public void updatePatientVitals(float weight, float height, float bodytemp, float bloodPres){
        updateVitals(weight, height, bodytemp, bloodPres);
    }

   
}
