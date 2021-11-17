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

public class NursePageController extends Controller{

	private Nurse currentNurse;

    @FXML
	private Button PatientListButton;

	@FXML
	private Button editVitalsButton;

	@FXML
	private Button goToPatientInfo;

    @FXML
    void handlePatientListButton(ActionEvent event) throws IOException{
		System.out.println("Go to Patient Info Pressed");
        Stage stage;
		Parent root;
		stage = (Stage) PatientListButton.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("FXML/PatientList.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

	@FXML
    void handlePatientVitalsButton(ActionEvent event) throws IOException{
        Stage stage;
		Parent root;
		stage = (Stage) editVitalsButton.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("FXML/PatientVitals.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

	void setNurse(Nurse nurse)
	{
		this.currentNurse = nurse;
	}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}
