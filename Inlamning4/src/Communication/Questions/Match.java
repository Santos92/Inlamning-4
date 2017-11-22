package Communication.Questions;

import java.io.Serializable;

public class Match implements Serializable{

	private static final long serialVersionUID = -7411990445543465752L;
	private boolean active;
	private boolean turn;
	
	private static int id = 0;
	private int ID = 0;
	private Round round1;
	private Round round2;
	
	private Round round1Opp;
	private Round round2Opp;
	
	private String Opponent;
	private int OpponentID;
	
	public Match(String opp)
	{
		ID = id++;
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
	public int getID() {
		return ID;
	}
	public Round getRound1() {
		return round1;
	}
	public void setRound1(Round round1) {
		this.round1 = round1;
	}
	public Round getRound2() {
		return round2;
	}
	public void setRound2(Round round2) {
		this.round2 = round2;
	}
	public Round getRound1Opp() {
		return round1Opp;
	}
	public void setRound1Opp(Round round1Opp) {
		this.round1Opp = round1Opp;
	}
	public Round getRound2Opp() {
		return round2Opp;
	}
	public void setRound2Opp(Round round2Opp) {
		this.round2Opp = round2Opp;
	}
	public int getOpponentID() {
		return OpponentID;
	}
	public void setOpponentID(int opponentID) {
		OpponentID = opponentID;
	}
	
}
