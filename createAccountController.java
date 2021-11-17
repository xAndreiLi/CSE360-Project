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

    ArrayList<Account> accountList = new ArrayList<Account>();

    @FXML
    void handleCreateAccount(ActionEvent event) throws IOException
    {
        String fName, lname, pass, confPass, email, pharPref, phoneNum, userName, emerFirstname, emerLastName, emerEmail, emerPhoneNum, birthDate;

        fName = firstName.getText();
        lname = lastName.getText();
        pass = password.getText();
        confPass = confPassword.getText();
        birthDate = dateOfBirth.getValue().toString();
        email = this.email.getText();
        pharPref = pharmacyPref.getText();
        phoneNum = phoneNumber.getText();
        userName = username.getText();
        emerFirstname = emerContFirstName.getText();
        emerLastName = EmerContLastName.getText();
        emerEmail = EmerContEmail.getText();
        emerPhoneNum = EmerContPhone.getText();
        
        //reads the file acountList file
        FileInputStream fis = new FileInputStream("accountList.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            accountList = (ArrayList<Account>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();

        //checks if there are any duplicate accounts 
        for (int i = 0; i < accountList.size(); i++)
        {
            Patient patientCheck = (Patient)accountList.get(i);

            //System.out.println("newdob = "+ birthDate); //for debugging
            //System.out.println("inlistdob = "+ patientCheck.getDateOfBirth());

            //duplicate comparison being made
            if(fName.equals(patientCheck.getPatientFirstName())
            && lname.equals(patientCheck.getPatientLastName())
            && birthDate.equals(patientCheck.getDateOfBirth()))
            {
                errorMessage.setText("The Account Aready Exists");
                return;
            }
        }
         
        //checks if any of the text fields are empty
        if (fName == "" || lname == "" || pass == "" || confPass  == "" || email == "" || pharPref  == "" || phoneNum  == "" ||
            userName  == "" || emerFirstname == "" || emerLastName  == "" || emerEmail == "" || emerPhoneNum == "")
        {
                errorMessage.setText("There is an Empty Text Field");
        }
        else
        {
            Patient patient = new Patient(userName, pass, fName, lname, birthDate, email, phoneNum, 
                                          pharPref, emerFirstname, emerLastName, emerEmail, emerPhoneNum);
            accountList.add(patient);
            
            errorMessage.setText(" ");
            System.out.println("Patient added to Array List");
            
            write(accountList);
        }       
    }

    public static void write (ArrayList<Account> plist) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("accountList.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(plist);
        oos.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
