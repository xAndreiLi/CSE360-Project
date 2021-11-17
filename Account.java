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

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}
}
