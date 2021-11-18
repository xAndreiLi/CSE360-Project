import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SummaryController extends Controller {

	@FXML
	private Button backButton;

	@FXML
	private TextArea summaryEntry;

	private Patient patient;

	private ArrayList<String> summaries;
	private StringBuilder stringOfSummaries = new StringBuilder("");

	@FXML
	void handleBackButton(ActionEvent event) throws IOException {
		super.backButton(super.prevPage, backButton);
	}

	@Override
	public void initData() {
		// initialize summaries here later
		if(super.currentUser instanceof Patient){
			patient = (Patient) super.currentUser;
		} else {
			patient = (Patient) super.selectedAccount;
		}

		summaries = patient.getPatientHistoryArray();

		// use string builder to make a string from the array
		for (int i = 0; i < summaries.size(); i++) {
			stringOfSummaries.append(summaries.get(i) + "\n");
		}

		// update the text to show summary
		summaryEntry.setText(stringOfSummaries.toString());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
