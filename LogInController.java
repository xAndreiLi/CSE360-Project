
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
		//System.out.println("Pressed"); //for dubugging
		stage = (Stage) createAccountReq.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("FXML/createAccount.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void takeInUserNameAndPassword(ActionEvent event) throws IOException
    {
        Stage stage;
        Parent rootParent;
        System.out.println("pressed logIn button");
        String userName = usernameLogin.getText();
        String password = passwordLogin.getText();

        if(userName ==  && password == )
        {
            stage = (Stage) signIn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(""))
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}
