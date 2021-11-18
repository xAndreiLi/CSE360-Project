import java.io.IOException;
import java.net.URL;
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

	private String[] summaries;
	private StringBuilder stringOfSummaries = new StringBuilder("");

	@FXML
	void handleBackButton(ActionEvent event) throws IOException {
		super.backButton(super.prevPage, backButton);
	}

	@Override
	public void initData() {
		// initialize summaries here later
		patient = (Patient) super.selectedAccount;

		summaries = patient.getPatientHistoryArray();

		// use string builder to make a string from the array
		for (int i = 0; i < summaries.length; i++) {
			stringOfSummaries.append(summaries[i] + "\n");
		}

		// update the text to show summary
		summaryEntry.setText(stringOfSummaries.toString());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
