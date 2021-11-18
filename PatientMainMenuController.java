import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PatientMainMenuController extends Controller{

	@FXML
    void handlePatientSummaryButton(ActionEvent event) throws IOException{

    }
	
	@Override
    public void initData() {
        Patient currentPatient = (Patient) super.currentUser;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

}
