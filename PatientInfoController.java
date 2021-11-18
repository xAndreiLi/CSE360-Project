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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PatientInfoController extends Controller {

    @FXML
    private Text currentPatientName;

    @FXML
    private Text displayBirthDate;

    @FXML
    private Text displayContactEmail;

    @FXML
    private Text displayContactFirstName;

    @FXML
    private Text displayContactLastName;

    @FXML
    private Text displayContactName;

    @FXML
    private Text displayDateOfBirth;

    @FXML
    private Text displayEmail;

    @FXML
    private Text displayFirstName;

    @FXML
    private Text displayPhone;

    @FXML
    private Pane displayUserName;

    @FXML
    private Text displayUsername;

    @FXML
    private Text emerEmail;

    @FXML
    private Text emerFirstName;

    @FXML
    private Text emerLastName;

    @FXML
    private Text emerPhone;

    @FXML
    private Text patiInfoImmunHistory;

    @FXML
    private Text patiInfoPrefPharmacy;

    @FXML
    private Text patiInfoPrescribedMed;

    @FXML
    private Text patiInfoPrevHealthIssue;

    @FXML
    private Button PatientSummary, messagePatientButton, PatiInfoBack;

    private Doctor doctor;
    private Nurse nurse;
    private Patient currentPatient;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException{
		if(super.currentUser instanceof Nurse){
            super.goToPage("FXML/NurseSelectPatientPage.fxml", PatiInfoBack);
        } else{
            super.goToPage("FXML/DoctorSelectPatient.fxml", PatiInfoBack);
        }
	}

    @FXML
    void handlePatientSummaryButton(ActionEvent event) throws IOException {
        super.goToPage("FXML/Summary.fxml", PatientSummary);
    }

    @FXML
    void handlePatientMessageButton(ActionEvent event) throws IOException {
        super.goToPage("FXML/DoctorMessaging.fxml", messagePatientButton);
    }

    @Override
    public void initData() {
        if (super.currentUser instanceof Doctor) {
            doctor = (Doctor) super.currentUser;
        } else if (super.currentUser instanceof Nurse) {
            nurse = (Nurse) super.currentUser;
        }

        currentPatient = (Patient) super.selectedAccount;
        //user info
        currentPatientName.setText(currentPatient.getPatientFullName());
        displayUsername.setText(currentPatient.getUsername());
        displayDateOfBirth.setText(currentPatient.getDateOfBirth());
        displayEmail.setText(currentPatient.getPatientEmail());
        displayPhone.setText(currentPatient.getPhoneNumber());
        //emergency contact info
        emerFirstName.setText(currentPatient.getEmergencyFirstName());
        emerLastName.setText(currentPatient.getPatientLastName());
        emerEmail.setText(currentPatient.getEmergencyEmail());
        emerPhone.setText(currentPatient.getPhoneNumber());
        //
        patiInfoPrevHealthIssue.setText(currentPatient.getPrevHealthIssues());
        patiInfoPrescribedMed.setText(currentPatient.getMedication());
        patiInfoImmunHistory.setText(currentPatient.getImmunization());
        patiInfoPrefPharmacy.setText(currentPatient.getPharmacy());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

}
