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
import javafx.stage.Stage;


public class ButtonFXMLController implements Initializable{

	@FXML
	private Button createAccountReq;

    
    @FXML 
	protected void handleCreateAccountButtonAction(ActionEvent e) throws IOException{
 		Stage stage;
		Parent root;
		System.out.println("Pressed");
		stage = (Stage) createAccountReq.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("FXML/createAccount.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();		
    }

	@Override
	public void initialize(URL url, ResourceBundle rb){
		
	}

}