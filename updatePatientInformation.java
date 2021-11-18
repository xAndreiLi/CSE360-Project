import java.io.IOException;

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
        EmerContLastName.setText(currentPatient.getEmergencyLastName()
        EmerContEmail.setText()        
    }
    @FXML
    private void accountUpdateconfirmButton(Action event) throws IOException{
        Patient currentPatient = (Patient)super.currentUser;

        currentPatient.setUsername(username.getText());
        currentPatient.setPatientFirstName(firstName.getText());
        currentPatient.set

    }
    @FXML
    void handleBackButton(ActionEvent event) {
        
    }

}
