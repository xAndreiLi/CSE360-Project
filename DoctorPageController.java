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
import javafx.stage.Stage;

public class DoctorPageController extends Controller{

    private Doctor currentDoctor;
    private Patient currentPatient;

    @FXML
    private Button PatientListButton, editPhysicalButton, goToPatientInfo;

    @FXML
    void handlePatientListButton(ActionEvent event) throws IOException {
        super.goToPage("FXML/PatientList.fxml", PatientListButton);
    }

    @FXML
    void handlePatientPhysicalButton(ActionEvent event) throws IOException {
        if(currentPatient!=null){
			super.goToPage("FXML/PatientPhysical.fxml", editPhysicalButton);
		}
    }

    @FXML
    void handlePatientInfoButton(ActionEvent event) throws IOException {
        if(currentPatient!=null){
			super.goToPage("FXML/PatientInformation.fxml", goToPatientInfo);
		}
    }

    @Override
    public void initData(){
        currentDoctor = (Doctor) currentUser;
        currentPatient = (Patient) selectedAccount;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // i want to show the Doctor object's currentPatient here if they have one
        // if (Doctor.currentPatient != null)
        // { update the Text with id="selectedPatient" }
    }

}
