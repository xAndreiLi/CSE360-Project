import java.io.Serializable;

public class Account implements Serializable{

	private String username, password;

	public Account()
	{
		username = "";
		password = "";
	}
	public Account(String username, String password)
	{
		this.password = password;
		this.username = username;
	}
}
