import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PatientVitalsController extends Controller{

	@FXML
	Button backToNursePage, submitHealthInfo1;

	@FXML
    void handleBackButton(ActionEvent event) throws IOException{
		super.backButton(super.prevPage, backToNursePage);
	}

	@Override
	public void initData(){

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
