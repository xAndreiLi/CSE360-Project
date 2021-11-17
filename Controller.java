import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class Controller implements Initializable{

	private Account currentUser;
	private ArrayList<Account> accountList;

	public void setUser(Account user){
		currentUser = user;
	}

	public void setAccountList(ArrayList<Account> list){
		accountList = list;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
