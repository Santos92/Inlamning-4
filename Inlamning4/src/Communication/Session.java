package Communication;

import java.io.Serializable;

public class Session implements Serializable {

	private static final long serialVersionUID = -7176442454427247485L;
	private String userName;
	private String userPass;
	private String Message;
	public enum gameStates
	{
		TryLogin,
		TryRegister,
		FailAuth,
		FailReg,
		OkReg,
		AuthAccept;
	}
	public gameStates state;
	
	public String getUserName() {
		return userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public String getMessage() {
		return Message;
	}
	public gameStates getState() {
		return state;
	}
	public void setState(gameStates s)
	{
		state = s;
	}
	public void setUserName(String s)
	{
		userName = s;
	}
	public void setUserPass(String s)
	{
		userPass = s;
	}
	public void setMessage(String s)
	{
		Message = s;
	}
	
}
