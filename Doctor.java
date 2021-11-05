/**
 * Doctor class is responsible for examining Patient objects
 * 
 * @author Randy Pham
 */
public class Doctor {

    public Patient currentPatient;

    // TODO: something something patient list

    private MessageHandler messageHandler;

    // default constructor
    public Doctor() {
        messageHandler = new MessageHandler();
    }

    public void setPatient(Patient patient) {
        currentPatient = patient;
    }

    public void examinePatient() {
        // examines currentPatient here
        String medication = "";

        updatePatientHistory();
        prescribeMedication(medication);
    }

    public void messagePatient(Patient patient) {
        // uses messageHandler to message Patient
    }

    private void updatePatientHistory() {
        // updates patient history
        // TODO: figure out how to check if patient history[i] is checked
    }

    private void prescribeMedication(String medication) {
        // gives medication to patient
        currentPatient.assignMedication(medication);
    }
}