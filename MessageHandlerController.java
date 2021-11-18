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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MessageHandlerController extends Controller {
    @FXML
    TextField textBox;
    @FXML
    Button sendMessage;
    @FXML
    Button patientMessageBackButton;

    private String message;

    @FXML
    void handleMessageView(ActionEvent event) throws IOException {

    }

    @FXML
    void handleSendMessage(ActionEvent event) throws IOException {
        Doctor doctor = (Doctor) super.currentUser;

        message = textBox.getText();

        doctor.messagePatient(doctor.getCurrentPatient(), message);
    }
}
