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

    public void messagePatient(Patient patient, String message) {
        // uses messageHandler to message Patient
        String messageToSend = "D:" + message;
        try {
            messageHandler.writeMessage(this, patient, messageToSend);
        } catch (Exception e) {
            System.out.println("there was a problem creating a message from doctor to current patient");
            e.printStackTrace();
        }
    }

    private void checkoutPatient() {
        // updates patient history
    }

    private void prescribeMedication(String medication) {
        // gives medication to patient
        currentPatient.assignMedication(medication);
    }
}