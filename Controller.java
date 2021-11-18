import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class Controller implements Initializable{

	protected Account currentUser;
	protected ArrayList<Account> accountList;

	public void setUser(Account user){
		currentUser = user;
	}

	public void setAccountList(ArrayList<Account> list){
		accountList = list;
	}

	public void initData(){

	}

	public void saveData() throws IOException{
		FileOutputStream fos = new FileOutputStream("./data/accountList.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(accountList);
        oos.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}
