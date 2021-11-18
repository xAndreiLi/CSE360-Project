import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class PatientMainMenuController extends Controller{

    @FXML
    private Button PatiInfoBack;

    @FXML
    private Button PatientSummary;

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
    private Text displayEmail1;

    @FXML
    private Text displayFirstName;

    @FXML
    private Text displayPhone;

    @FXML
    private Text displayPhone1;

    @FXML
    private Pane displayUserName;

    @FXML
    private Text displayUsername;

    @FXML
    private Button doctorMessage;

    @FXML
    private Button editPatientInfo;

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
    void handlePatientSummaryButton(ActionEvent event) throws IOException{
        goToPage("FXML/updatePatientInformation.fxml", editPatientInfo);
    }
	
	@Override
    public void initData() {
        Patient currentPatient = (Patient) super.currentUser;
        //user info
        currentPatientName.setText(currentPatient.getPatientFullName());
        displayUsername.setText(currentPatient.getUsername());
        displayBirthDate.setText(currentPatient.getDateOfBirth());
        displayEmail1.setText(currentPatient.getPatientEmail());
        displayPhone1.setText(currentPatient.getPhoneNumber());
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
