import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class createAccountController implements Initializable{

    @FXML
    private Button AccouCreationBack;
    @FXML
    private TextField EmerContEmail;
    @FXML
    private TextField EmerContLastName;
    @FXML
    private TextField EmerContPhone;
    @FXML
    private TextField confPassword;
    @FXML
    private Button creatAccount;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField email;
    @FXML
    private TextField emerContFirstName;
    @FXML
    private Text errorMessage;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField password;
    @FXML
    private TextField pharmacyPref;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField username;

    @FXML
    void handleBackButton(ActionEvent event) throws IOException{
        Stage stage;
		Parent root;
		stage = (Stage) AccouCreationBack.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("FXML/LoginScreen.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

    }

    ArrayList<Patient> patientAList = new ArrayList<>();

    @FXML
    void handleCreateAccount(ActionEvent event) throws IOException
    {
        String fName, lname, pass, confPass, email, pharPref, phoneNum, userName, emerFirstname, emerLastName, emerEmail, emerPhoneNum, birthDate;

        fName = firstName.getText();
        lname = lastName.getText();
        pass = password.getText();
        confPass = confPassword.getText();
        birthDate = dateOfBirth.getPromptText();
        email = this.email.getText();
        pharPref = pharmacyPref.getText();
        phoneNum = phoneNumber.getText();
        userName = username.getText();
        emerFirstname = emerContFirstName.getText();
        emerLastName = EmerContLastName.getText();
        emerEmail = EmerContEmail.getText();
        emerPhoneNum = EmerContPhone.getText();


        FileInputStream fis = new FileInputStream("patientList.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            patientAList = (ArrayList<Patient>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();


        if (fName == "" || lname == "" || pass == "" || confPass  == "" || email == "" || pharPref  == "" || phoneNum  == "" ||
            userName  == "" || emerFirstname == "" || emerLastName  == "" || emerEmail == "" || emerPhoneNum == "")
        {
                errorMessage.setText("There is an Empty Text Field");
        }
        else
        {
            Patient patient = new Patient(userName, pass, fName, lname, birthDate, email, phoneNum, 
                                          pharPref, emerFirstname, emerLastName, emerEmail, emerPhoneNum);
            patientAList.add(patient);

            Doctor doc = new Doctor("doctorFirstName", 0001);//testing
            
            System.out.println("Patient added to Array List");
            
            write(patientAList);
        }
        for (int i = 0; i < patientAList.size(); i++) {
            System.out.println(patientAList.get(i).getUsername());
        }                
    }

    public static void write (ArrayList<Patient> plist ) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("patientList.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(plist);
        oos.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < patientAList.size(); i++) {
            System.out.println(patientAList.get(i));
        }
    }

}
