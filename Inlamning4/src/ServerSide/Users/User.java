package ServerSide.Users;

import java.io.Serializable;
import java.util.LinkedList;

import Communication.Questions.Match;

public class User implements Serializable {

	private static final long serialVersionUID = 8280824361650624230L;
	protected String namn;
	protected String password;
	private LinkedList<Match> Matcher;
	
	public User(String namn, String password){
		this.namn = namn;
		this.password = password;
		this.Matcher = new LinkedList<Match>();
	}
	public void addMatch(Match m)
	{
		Matcher.add(m);
	}
	public LinkedList<Match> getMatcher() {
		return Matcher;
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
