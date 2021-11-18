import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SummaryController extends Controller{

	String summaries;

	@FXML 
	Button backButton;
	
	@FXML
	TextArea summaryEntry;

	@FXML
    void handleBackButton(ActionEvent event) throws IOException{
		super.backButton(super.prevPage, backButton);
	}

	@Override
	public void initData(){
		// initialize summaries here later
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
