import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PatientListController extends Controller {

	class PatientListItem {
		private StringProperty name, birthday, pharmacy, room;

		public PatientListItem(String name, String birthday, String pharmacy, String room){
			this.name = new SimpleStringProperty(name);
			this.birthday = new SimpleStringProperty(birthday);
			this.pharmacy = new SimpleStringProperty(pharmacy);
			this.room = new SimpleStringProperty(room);
		}

		public String getName(){
			return name.get();
		}

		public String getBirthday(){
			return birthday.get();
		}

		public String getPharmacy(){
			return pharmacy.get();
		}

		public String getRoom(){
			return room.get();
		}
	}

	private ObservableList<PatientListItem> patientList;

	@FXML
	private Button patiListBack;

	@FXML TableView<PatientListItem> patientTable;

	@FXML
	private TableColumn<PatientListItem, String> patiListBirthDate;

	@FXML
	private TableColumn<PatientListItem, String> patiListName;

	@FXML
	private TableColumn<PatientListItem, String> patiListPharmacy;

	@FXML
	private TableColumn<PatientListItem, String> patiListRoom;

	@FXML
	public void handleBackButton(ActionEvent event) throws IOException {
		super.backButton(super.prevPage, patiListBack);
	}

	@Override
	public void initData() {

		patientList = FXCollections.observableArrayList();

		for(int i=5;i<super.accountList.size();i++){
			Patient patient = (Patient) super.accountList.get(i);
			PatientListItem item = new PatientListItem(
				patient.getPatientFirstName()+patient.getPatientLastName(), 
				patient.getDateOfBirth(), patient.getDateOfBirth(), patient.getRoom());
			patientList.add(item);
		}

		patiListName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		patiListBirthDate.setCellValueFactory(new PropertyValueFactory<>("Birthday"));
		patiListPharmacy.setCellValueFactory(new PropertyValueFactory<>("Pharmacy"));
		patiListRoom.setCellValueFactory(new PropertyValueFactory<>("Room"));

		patientTable.setItems(patientList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
