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

public class LogInController implements Initializable{

    @FXML
    private Button createAccountReq;

    @FXML
    private TextField passwordLogin;

    @FXML
    private Button signIn;

    @FXML
    private TextField usernameLogin;

    @FXML
    void handleCreateAccountButtonAction(ActionEvent event) throws IOException{
        Stage stage;
		Parent root;
		System.out.println("Pressed"); //for dubugging
		stage = (Stage) createAccountReq.getScene().getWindow();

		root = FXMLLoader.load(getClass().getResource("FXML/createAccount.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void takeInUserNameAndPassword(ActionEvent event) throws IOException
    {
        PatientList patientList;
        Stage stage;
        FXMLLoader loader;
        System.out.println("pressed logIn button");
        String userName = usernameLogin.getText();
        String password = passwordLogin.getText();


        if(true) // Username and password match in file
        {
            stage = (Stage) signIn.getScene().getWindow();
            if(true) // If account has patient type
            {
                loader = FXMLLoader.load(getClass().getResource("FXML/PatientList.fxml"));
                PatientInfoController controller = loader.getController();
            }
            else if(true) // If account has nurse type
            {
                loader = FXMLLoader.load(getClass().getResource("FXML/NurseSelectPatientPage.fxml"));
                NursePageController controller = loader.getController();
                //controller.setNurse();
            }
            else if(true) // If account has doctor type
            {
                loader = FXMLLoader.load(getClass().getResource("FXML/DoctorSelectPatient.fxml"));
                DoctorPageController controller = loader.getController();
            }

            Scene scene = new Scene(loader.load());
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
