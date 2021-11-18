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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PatientInfoController extends Controller{

    @FXML
	private Text currentPatientText, firstNameText, lastNameText, 
            emailText, phoneText;

    @FXML
    private Button patientSummary;

    @FXML
    void handlePatientSummaryButton(ActionEvent event) throws IOException{

    }

    @Override
    public void initData() {
        Patient currentPatient = (Patient) super.currentUser;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}
