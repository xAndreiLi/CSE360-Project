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

public class NursePageController extends Controller{

	private Nurse currentNurse;
	private Patient currentPatient;

    @FXML
	private Button PatientListButton;

	@FXML
	private Button editVitalsButton;

	@FXML
	private Button goToPatientInfo;

	@FXML
	private Text selectedPatient;

    @FXML
    void handlePatientListButton(ActionEvent event) throws IOException{
		super.goToPage("FXML/PatientList.fxml", PatientListButton);
    }

	@FXML
    void handlePatientVitalsButton(ActionEvent event) throws IOException{
		if(currentPatient!=null){
			super.goToPage("FXML/PatientVitals.fxml", editVitalsButton);
		}
    }

	void handlePatientInfoButton(ActionEvent event) throws IOException{
		if(currentPatient!=null){
			super.goToPage("FXML/PatientInformation.fxml", goToPatientInfo);
		}
	}

	@Override
	public void initData() {
		currentNurse = (Nurse) super.currentUser;
		currentPatient = (Patient) super.selectedAccount;
		if(currentPatient!= null){
			selectedPatient.setText("Selected Patient : " + currentPatient.getPatientFullName());
		}
		
	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}
