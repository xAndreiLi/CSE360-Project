/**
 * Doctor class is responsible for examining Patient objects
 * 
 * @author Randy Pham
 */
public class Doctor extends Account {

    // TODO: something something patient list

    private MessageHandler messageHandler;
    private Patient currentPatient;
    private String doctorFirstName;
    private int doctorID;

    // default constructor
    public Doctor() {
        super();
        messageHandler = new MessageHandler();
        doctorID = 0;
        doctorFirstName = "John";
        currentPatient = null;
    }

    // overload constructor
    public Doctor(String doctorFirstName, int doctorID, String username, String password) {
        super(username, password);
        messageHandler = new MessageHandler();
        this.doctorFirstName = doctorFirstName;
        this.doctorID = doctorID;
    }

    public void examinePatient(String patientSummary, String medication, String date) {
        // examines currentPatient here

        String visitSummary = date + ": " + patientSummary;

        System.out.println(visitSummary);

        prescribeMedication(medication);
        checkoutPatient(visitSummary);
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

    private void checkoutPatient(String summary) {
        // updates patient history with any notes
        // patient history[] will show the last 10 visits

        // add patient summary into queue
        currentPatient.patientHistory.add(summary);

        // check if queue is over 10
        if (currentPatient.patientHistory.size() > 10) {
            // if it is over 10, we keep removing elements until the size is 10
            while (currentPatient.patientHistory.size() > 10) {
                currentPatient.patientHistory.poll();
            }
        }

        // update the patient history array for display purposes
        currentPatient.patientHistoryArray = currentPatient.patientHistory.toArray(currentPatient.patientHistoryArray);
    }

    private void prescribeMedication(String medication) {
        // gives medication to patient
        currentPatient.assignMedication(medication);
    }
}