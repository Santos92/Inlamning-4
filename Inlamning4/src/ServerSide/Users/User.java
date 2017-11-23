package ServerSide.Users;

import java.io.Serializable;
import java.util.LinkedList;

import Communication.Questions.Match;

public class User implements Serializable {

	private static final long serialVersionUID = 8280824361650624230L;
	protected String namn;
	protected String password;
	private LinkedList<Match> Matcher = new LinkedList<>();
	
	public User(String namn, String password){
		this.namn = namn;
		this.password = password;
	}
	public void addMatch(Match m)
	{
		Matcher.add(m);
	}
	public void setMatch(Match m, int i)
	{
		Matcher.set(i, m);
	}
	public void setNamn(String namn) {
		this.namn = namn;
	}
	public LinkedList<Match> getMatcher() {
		return Matcher;
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
