import java.io.IOException;
import java.net.PasswordAuthentication;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.util.ArrayList;

public class createAccountController {

    ArrayList patientArrayList = new ArrayList();

    @FXML
    private Button AccouCreationBack;
    @FXML
    private TextField confPassword;
    @FXML
    private Button creatAccount;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField email;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private Text errorMessage;
    @FXML
    private TextField password;
    @FXML
    private TextField pharmacyPref;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField username;

    void handleCreateAccount(ActionEvent event) throws IOException{
        String fName, lName, pass, confpass, email, pharmacyPref, phoneNum, userName, dateOfBirth;
        fName = firstName.getText();
        lName = lastName.getText();
        pass = password.getText();
        confpass = confPassword.getText();
        email = this.email.getText();
        pharmacyPref = this.pharmacyPref.getText();
        phoneNum = phoneNumber.getText();
        userName = username.getText();
        dateOfBirth = this.dateOfBirth.getText();

        //check to see if any of the text fields are empty 
        if (fName == "" || lName == "" || pass == "" || confpass == "" || 
            email == "" || pharmacyPref == "" || phoneNum == "" || userName == "" || dateOfBirth == "")
        {
            errorMessage.setText("One of the text fields are Empty");
        }
        else
        {
            Patient newPatient = new patient(fName, lName, dateOfBirth, email, phoneNum, );

        }
    }

}
