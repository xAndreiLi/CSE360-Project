import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PatientPhysicalController extends Controller{

	@FXML
	Button backPatientPhysical, submitMedPrescription;

	void handleBackButton(ActionEvent event) throws IOException{
		super.backButton(super.prevPage, backPatientPhysical);
	}

	void handleSubmitButton(ActionEvent event) throws IOException{
		// TO DO
	}

	@Override
	public void initData(){

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
