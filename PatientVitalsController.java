import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PatientVitalsController extends Controller {

	@FXML
	private Button backToNursePage, submitHealthInfo;

	@FXML
	private TextArea Immunization, healthIssues;

	@FXML
	private TextField PatientTemperature, patientBloodPressure, patientHeight, patientWeight;

	@FXML
	private Text currentPatient;

	@FXML
	void handleBackButton(ActionEvent event) throws IOException {
		super.backButton(super.prevPage, backToNursePage);
	}

	@FXML
	void handleSubmitButton(ActionEvent event) throws IOException {
		Patient cp = (Patient) super.currentUser;
		cp.setImmunization(Immunization.getText());
		cp.setHealthIssues(healthIssues.getText());

		float bp = Float.parseFloat(patientBloodPressure.getText());
		cp.setBloodPressure(bp);
		cp.setPatientHeight(patientHeight.getText());

		float w = Float.parseFloat(patientWeight.getText());
		cp.setWeight(w);

		float t = Float.parseFloat(PatientTemperature.getText());
		cp.setBodyTemp(t);
	}

	@Override
	public void initData() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
