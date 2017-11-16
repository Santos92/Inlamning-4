package ServerSide.Users;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 8280824361650624230L;
	protected String namn;
	protected String password;
	// spara all användare i en text fil
	
	public User(String namn, String password){
		this.namn = namn;
		this.password = password;
	}
	
	public void setNamn(String namn) {
	this.namn = namn;
	}
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public String getNamn() {
		return namn;
	}
	
	public String getPassword() {
		return password;
	}
	
}
