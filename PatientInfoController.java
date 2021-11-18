import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.print.Doc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PatientInfoController extends Controller {

    @FXML
    private Text currentPatientText, firstNameText, lastNameText, emailText, phoneText;

    @FXML
    private Button PatientSummary, messagePatientButton;

    private Doctor doctor;
    private Nurse nurse;
    private Patient patient;

    @FXML
    void handlePatientSummaryButton(ActionEvent event) throws IOException {

    }

    @FXML
    void handlePatientMessageButton(ActionEvent event) throws IOException {

    }

    @Override
    public void initData() {
        if (super.currentUser instanceof Doctor) {
            doctor = (Doctor) super.currentUser;
        } else if (super.currentUser instanceof Nurse) {
            nurse = (Nurse) super.currentUser;
        }

        patient = (Patient) super.selectedAccount;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
