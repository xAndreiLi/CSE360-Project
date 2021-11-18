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
		private Patient patient;
		private StringProperty name, birthday, pharmacy, room;

		public PatientListItem(Patient patient, String name, String birthday, String pharmacy, String room){
			this.patient = patient;
			this.name = new SimpleStringProperty(name);
			this.birthday = new SimpleStringProperty(birthday);
			this.pharmacy = new SimpleStringProperty(pharmacy);
			this.room = new SimpleStringProperty(room);
		}

		public Patient getPatient(){
			return patient;
		}

		public StringProperty nameProperty(){
			return name;
		}
		public StringProperty birthdayProperty(){
			return birthday;
		}
		public StringProperty pharmacyProperty(){
			return pharmacy;
		}
		public StringProperty roomProperty(){
			return room;
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
		if(!patientTable.getSelectionModel().isEmpty()){
			super.selectedAccount = patientTable.getSelectionModel().getSelectedItem().getPatient();
		}
		
		super.backButton(super.prevPage, patiListBack);
	}

	@Override
	public void initData() {

		patientList = FXCollections.observableArrayList();

		for(int i=5;i<super.accountList.size();i++){
			Patient patient = (Patient) super.accountList.get(i);
			PatientListItem item = new PatientListItem(patient,
				patient.getPatientFirstName() +" "+ patient.getPatientLastName(), 
				patient.getDateOfBirth(), patient.getPharmacy(), patient.getRoom());
			patientList.add(item);
		}

		patiListName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		patiListBirthDate.setCellValueFactory(cellData -> cellData.getValue().birthdayProperty());
		patiListPharmacy.setCellValueFactory(cellData -> cellData.getValue().pharmacyProperty());
		patiListRoom.setCellValueFactory(cellData -> cellData.getValue().roomProperty());

		patientTable.setItems(patientList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
