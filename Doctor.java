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

        prescribeMedication(medication);
        checkoutPatient();
    }

    public void messagePatient(Patient patient) {
        // uses messageHandler to message Patient
    }

    private void checkoutPatient() {
        // updates patient history
    }

    private void prescribeMedication(String medication) {
        // gives medication to patient
        currentPatient.assignMedication(medication);
    }
}