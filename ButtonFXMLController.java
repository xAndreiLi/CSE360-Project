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


public class ButtonFXMLController implements Initializable{

	@FXML
	private Button createAccountReq;
	private Button signIn;
	private TextField usernameLogin;
	private TextField passwordLogin;

    
    @FXML 
	protected void handleCreateAccountButtonAction(ActionEvent e) throws IOException{
		Stage stage;
		Parent root;
		System.out.println("Create Account button pressed");
		stage = (Stage) createAccountReq.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("FXML/createAccount.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();		
    }

	protected void handleLoginButtonAction(ActionEvent e) throws IOException{
		LoginHandler login = new LoginHandler();
		String username = usernameLogin.getText();
		String password = passwordLogin.getText();

		System.out.println("Log In button pressed");

		//Once login handler is made, check needs to be made here
		
		if(true){
			Stage stage;
			Parent root;
			stage = (Stage) signIn.getScene().getWindow();
			//If success, goes to next screen depending on account type
		}
		else{
			//If fail, displays fail message
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb){
		
	}

}