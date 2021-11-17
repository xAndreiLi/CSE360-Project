import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController implements Initializable {

    private ArrayList<Account> accountList;

    @FXML
    private Button createAccountReq;

    @FXML
    private TextField passwordLogin;

    @FXML
    private Button signIn;

    @FXML
    private TextField usernameLogin;

    @FXML
    void handleCreateAccountButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader loader;
        Parent root;
        stage = (Stage) createAccountReq.getScene().getWindow();

        loader = new FXMLLoader(getClass().getResource("FXML/createAccount.fxml"));
        root = loader.load();
        Controller controller = loader.getController();
        controller.setAccountList(accountList);
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void takeInUserNameAndPassword(ActionEvent event) throws IOException {
        Stage stage;
        FXMLLoader loader;
        Parent root;
        System.out.println("pressed logIn button");
        String userName = usernameLogin.getText();
        String password = passwordLogin.getText();

        Account currentUser = null;

        for(int i = 0; i<accountList.size(); i++){
            if(userName.equals(accountList.get(i).getUsername())  && password.equals(accountList.get(i).getPassword())){
                currentUser = accountList.get(i);
            }
        }

        if (currentUser != null) // Username and password match in file
        {
            stage = (Stage) signIn.getScene().getWindow();
            Controller controller;
            if (currentUser instanceof Patient) // If account has patient type
            {
                loader = new FXMLLoader(getClass().getResource("FXML/PatientInformation.fxml"));
                controller = loader.getController();
            } else if (currentUser instanceof Nurse) // If account has nurse type
            {
                loader = new FXMLLoader(getClass().getResource("FXML/NurseSelectPatientPage.fxml"));
                controller = loader.getController();
            } else // If account has doctor type
            {
                loader = new FXMLLoader(getClass().getResource("FXML/DoctorSelectPatient.fxml"));
                controller = loader.getController();
            }
            root = loader.load();
            controller = loader.getController();
            controller.setUser(currentUser);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            // Set log text to invalid credentials
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("Initializing Accounts");

        accountList = new ArrayList<Account>();

        // Check if accountList has not been initialized
        File accFile = new File("./data/accountList.tmp");
        if (!accFile.exists()) {
            System.out.println("accountList not found: creating new file");
            FileOutputStream fos;
            ObjectOutputStream oos;
            try {
                fos = new FileOutputStream("./data/accountList.tmp");
                oos = new ObjectOutputStream(fos);
                
                // Add doctors and nurses
                Doctor andrei = new Doctor("Andrei", 0, "andreili", "apple");
                Doctor hector = new Doctor("Hector", 0, "hectord", "pear");
                Nurse randy = new Nurse("randy", "hello");
                Nurse tommy = new Nurse("tommy", "password");
                Nurse longg = new Nurse("long", "peanut");

                accountList.add(andrei);
                accountList.add(hector);
                accountList.add(randy);
                accountList.add(tommy);
                accountList.add(longg);

                oos.writeObject(accountList);
                oos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {    // If accountList exists then read and add to accountList
            try {
                System.out.println("Reading from accountList");
                FileInputStream fis = new FileInputStream("./data/accountList.tmp");
                ObjectInputStream ois = new ObjectInputStream(fis);
                accountList = (ArrayList<Account>)ois.readObject();
                ois.close();
            } catch (EOFException e){

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
