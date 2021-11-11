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

public class CreateAccountController implements Initializable{

    @FXML
    private Button AccouCreationBack;

    @FXML
    private TextField passwordLogin;

    @FXML
    private Button signIn;

    @FXML
    private TextField usernameLogin;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException{
        Stage stage;
		Parent root;
		//System.out.println("Pressed"); //for dubugging
		stage = (Stage) AccouCreationBack.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("FXML/LoginScreen.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void takeInUserNameAndPassword(ActionEvent event) throws IOException
    {
        Stage stage;
        Parent root;
        System.out.println("pressed logIn button");
        String userName = usernameLogin.getText();
        String password = passwordLogin.getText();

        if(true) // Username and password match in file
        {
            stage = (Stage) signIn.getScene().getWindow();
            if(true) // If account has patient type
            {
                root = FXMLLoader.load(getClass().getResource("FXML/PatientList.fxml"));
            }
            else if(true) // If account has nurse type
            {
                root = FXMLLoader.load(getClass().getResource("FXML/NurseSelectPatientPage.fxml"));
            }
            else if(true) // If account has doctor type
            {
                root = FXMLLoader.load(getClass().getResource("FXML/DoctorSelectPatient.fxml"));
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            // Set log text to invalid credentials
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}
