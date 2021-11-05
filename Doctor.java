/**
 * Doctor class is responsible for examining Patient objects
 * 
 * @author Randy Pham
 */
public class Doctor {

    public Patient currentPatient;

    private MessageHandler messageHandler;

    public void setPatient(Patient patient) {
        currentPatient = patient;
    }

    public void examinePatient() {
        // examines currentPatient here

        updatePatientHistory();
        prescribeMedication();
    }

    public void messagePatient(Patient patient) {
        // uses messageHandler to message Patient
    }

    private void updatePatientHistory() {

    }

    private void prescribeMedication() {

    }
}