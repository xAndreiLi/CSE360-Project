import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class PatientPhysicalController extends Controller {

	@FXML
	private Button backPatientPhysical, submitMedPrescription;
	@FXML
	private TextArea patientSummary, prescribedMedication;
	@FXML
	private DatePicker patiPhysicalDate;

	private Doctor doctor;
	private Patient patient;
	private String patientSummaryString, medicationString, dateString;

	public void handleBackButton(ActionEvent event) throws IOException {
		super.backButton(super.prevPage, backPatientPhysical);
	}

	public void handleSubmitButton(ActionEvent event) throws IOException {
		// grab text from textareas and date
		patientSummaryString = patientSummary.getText();
		medicationString = prescribedMedication.getText();
		dateString = patiPhysicalDate.getValue().format(DateTimeFormatter.ofPattern("MMM d yyyy"));
		// call examinePatient() to write summary and add it to the patient's patient
		// history array
		doctor.examinePatient(patientSummaryString, medicationString, dateString);
		super.saveData();
	}

	@Override
	public void initData() {
		doctor = (Doctor) super.currentUser;
		patient = (Patient) super.selectedAccount;
		doctor.setCurrentPatient(patient);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
