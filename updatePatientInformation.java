import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class updatePatientInformation extends Controller{

    @FXML
    private TextField   EmerContEmail,EmerContLastName,EmerContPhone, confPassword,email, 
                        emerContFirstName,firstName,lastName,password,pharmacyPref,phoneNumber,username;

    @FXML
    private Button accountUpdateBACKButton,confirmButton;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private Text errorMessage;


    @Override
    public void initData() {
        Patient currentPatient = (Patient)super.currentUser;
        emerContFirstName.setText(currentPatient.getEmergencyFirstName());
        EmerContLastName.setText(currentPatient.getEmergencyLastName());
        EmerContEmail.setText(currentPatient.getEmergencyEmail());
        EmerContPhone.setText(currentPatient.getEmergencyPhoneNumb());
        
        firstName.setText(currentPatient.getPatientFirstName());
        lastName.setText(currentPatient.getPatientLastName());
        email.setText(currentPatient.getPatientEmail());
        password.setText(currentPatient.getPassword());
        username.setText(currentPatient.getUsername());
        pharmacyPref.setText(currentPatient.getPharmacy());
        phoneNumber.setText(currentPatient.getPhoneNumber());
        dateOfBirth.setValue(LOCAL_DATE(currentPatient.getDateOfBirth()));
    }


    public static final LocalDate LOCAL_DATE (String dateString)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }


    @FXML
    private void accountUpdateconfirmButton(ActionEvent event) throws IOException{
        Patient cp = (Patient)super.currentUser;
      
        cp.setPatientFirstName(firstName.getText());
        cp.setPatientLastName(lastName.getText());
        cp.setPatientEmail(email.getText());
        cp.setPassword(password.getText());
        cp.setUsername(username.getText());
        cp.setPharmacy(pharmacyPref.getText());
        cp.setPatientPhoneNumber(phoneNumber.getText());
        cp.setEmergencyContact(emerContFirstName.getText(), EmerContLastName.getText(), EmerContEmail.getText(), EmerContPhone.getText());

        cp.setDateOfBirth(dateOfBirth.getValue().toString());
        errorMessage.setText("Updated");
    }
    @FXML
    void handleBackButton(ActionEvent event) throws IOException{
        super.backButton(super.prevPage, accountUpdateBACKButton);
    }
}
