import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PatientListController extends Controller{

	@FXML
	Button patiListBack;

	@FXML
    void handleBackButton(ActionEvent event) throws IOException{
		super.backButton(super.prevPage, patiListBack);
	}

	@Override
	public void initData() {

	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
