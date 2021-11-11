/**
 * Doctor class is responsible for examining Patient objects
 * 
 * @author Randy Pham
 */
public class Doctor {

    // TODO: something something patient list

    private MessageHandler messageHandler;
    private Patient currentPatient;
    private String doctorFirstName;
    private int doctorID;

    // default constructor
    public Doctor() {
        messageHandler = new MessageHandler();
        doctorID = 0;
        doctorFirstName = "John";
    }

    // overload constructor
    public Doctor(String doctorFirstName, int doctorID) {
        messageHandler = new MessageHandler();
        this.doctorFirstName = doctorFirstName;
        this.doctorID = doctorID;
    }

    public void examinePatient(String patientSummary, String medication) {
        // examines currentPatient here

        prescribeMedication(medication);
        checkoutPatient(patientSummary);
    }

    public void messagePatient(Patient patient, String message) {
        // uses messageHandler to message Patient
        String messageToSend = "Doctor " + doctorFirstName + ": " + message;
        try {
            messageHandler.writeMessage(this, patient, messageToSend);
        } catch (Exception e) {
            System.out.println("there was a problem creating a message from doctor to current patient");
            e.printStackTrace();
        }
    }

    // GETTER METHODS

    public Patient getCurrentPatient() {
        return this.currentPatient;
    }

    public String getDoctorFirstName() {
        return this.doctorFirstName;
    }

    public int getDoctorID() {
        return this.doctorID;
    }

    // SETTER METHODS

    public void setCurrentPatient(Patient currentPatient) {
        this.currentPatient = currentPatient;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    // HELPER METHODS

    private void checkoutPatient(String patientSummary) {
        // updates patient history with any notes
        // patient history[] will show the last 10 visits
        int index = 0;

        for (int i = 0; i < currentPatient.getPatientHistory().length; i++) {
            if (currentPatient.getPatientHistory()[i] != "") {

            }
        }

        currentPatient.getPatientHistory()[0] = patientSummary;
    }

    private void prescribeMedication(String medication) {
        // gives medication to patient
        currentPatient.assignMedication(medication);
    }
}