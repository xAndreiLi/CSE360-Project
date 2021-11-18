import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DoctorNurseMessageController extends Controller {
    @FXML
    TextArea textArea;
    @FXML
    TextField textBox;
    @FXML
    Button sendMessage, patientMessageBackButton;

    private String messageToSend, messageToShow, filename, doctorHash, patientHash;
    private MessageHandler messageHandler = new MessageHandler();
    private Doctor doctor;

    @Override
    public void initData() {
        doctor = (Doctor) currentUser;
        // i want to set the textArea to any previous existing messages
        try {
            showMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        super.backButton(super.prevPage, patientMessageBackButton);
    }

    @FXML
    void handleDoctorSendMessage(ActionEvent event) throws IOException {
        // set the message equal to whatever is in the text box
        messageToSend = textBox.getText();
        // message the patient
        doctor.sendMessage(doctor.getCurrentPatient(), messageToSend);

        // update the textArea
        showMessage();
    }

    /**
     * This method will update the textArea to show the messages between the doctor
     * and their current patient
     * 
     * @throws IOException
     */
    private void showMessage() throws IOException {
        // get hashes of the doctor and patient
        doctorHash = messageHandler.getHashCode(doctor) + "";
        patientHash = messageHandler.getHashCode(doctor.getCurrentPatient()) + "";
        // this is where the message is stored
        filename = doctorHash + patientHash + ".txt";

        // update the textArea and show the message
        messageToShow = messageHandler.readMessage(filename);
        textArea.setText(messageToShow);
    }
}
