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
    private Button createAccount;

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
    void handleCreateAccount(ActionEvent event) throws IOException
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
