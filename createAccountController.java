import java.io.IOException;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class createAccountController {

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
    private TextField password;
    @FXML
    private TextField pharmacyPref;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField username;

    ArrayList[][] patientArrayList = new ArrayList[3][100];

    void handleCreateAccount(ActionEvent event) throws IOException{


    }

}
