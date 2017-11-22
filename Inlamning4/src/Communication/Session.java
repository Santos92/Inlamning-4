package Communication;

import java.io.Serializable;
import java.util.LinkedList;

import Communication.Questions.Match;

public class Session implements Serializable {

	private static final long serialVersionUID = -7176442454427247485L;
	private String userName;
	private String userPass;
	private String Message;
	private LinkedList<Match> Matcher;
	private Match pickedMatch;
	public enum gameStates
	{
		TryLogin,
		TryRegister,
		FailAuth,
		FailReg,
		OkReg,
		getMatches,
		RandomMatch,
		GetCategories,
		startRound,
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
	public LinkedList<Match> getMatcher() {
		return Matcher;
	}
	public void setMatcher(LinkedList<Match> matcher) {
		Matcher = matcher;
	}
	public Match getPickedMatch() {
		return pickedMatch;
	}
	public void setPickedMatch(Match pickedMatch) {
		this.pickedMatch = pickedMatch;
	}
	
}
