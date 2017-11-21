package Communication.Questions;

import java.io.Serializable;

public class Match implements Serializable{

	private static final long serialVersionUID = -7411990445543465752L;
	private boolean active;
	private boolean turn;
	
	private static int ID;
	
	private Round round1;
	private Round round2;
	
	private Round round1Opp;
	private Round round2Opp;
	
	private String Opponent;
	
	public Match(String opp)
	{
		ID++;
		setOpponent(opp);
	}
	public String getOpponent() {
		return Opponent;
	}
	public void setOpponent(String opponent) {
		Opponent = opponent;
	}
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
