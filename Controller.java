import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller implements Initializable{

	protected Account currentUser, selectedAccount;
	protected ArrayList<Account> accountList;
	protected String currPage, prevPage;

	public void setUser(Account user){
		currentUser = user;
	}

	public void setAccountList(ArrayList<Account> list){
		accountList = list;
	}

	public void setSelectedAccount(Account account){
		selectedAccount = account;
	}

	public void setCurrPage(String page){
		currPage = page;
	}

	public void setPrevPage(String page){
		prevPage = page;
	}

	public void backButton(String prevPage, Button button) throws IOException{
        Stage stage;
		Parent root;
		FXMLLoader loader;
		Controller controller;
		stage = (Stage) button.getScene().getWindow();
		loader = new FXMLLoader(getClass().getResource(prevPage));
		root = loader.load();
		
		controller = loader.getController();
		controller.setUser(currentUser);
		controller.setAccountList(accountList);
		controller.setSelectedAccount(selectedAccount);
		controller.setCurrPage(prevPage);
		controller.setPrevPage(currPage);
		controller.initData();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void goToPage(String newPage, Button button) throws IOException{
		Stage stage;
		Parent root;
		FXMLLoader loader;
		Controller controller;
		stage = (Stage) button.getScene().getWindow();
		loader = new FXMLLoader(getClass().getResource(newPage));
		root = loader.load();
		
		controller = loader.getController();
		controller.setUser(currentUser);
		controller.setAccountList(accountList);
		controller.setSelectedAccount(selectedAccount);
		controller.setCurrPage(newPage);
		controller.setPrevPage(currPage);
		controller.initData();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void saveData() throws IOException{
		FileOutputStream fos = new FileOutputStream("./data/accountList.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(accountList);
        oos.close();
	}

	public void initData(){
		//Empty for child classes to override
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
